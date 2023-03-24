package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.NavigationMenu;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageFilter;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;


import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Model(adaptables = {SlingHttpServletRequest.class},
        adapters = {NavigationMenu.class},
        resourceType = {NavigationMenuImpl.RESOURCE_TYPE},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class NavigationMenuImpl implements NavigationMenu {
    protected static final String RESOURCE_TYPE = "wknd/components/navigation";
    @Self
    SlingHttpServletRequest request;
    @Inject
    @Via("resource")
    private Page navigationRoot;
    @ValueMapValue
    private int structureDepth;
    @ValueMapValue
    private boolean collectAllPages;
    private final List<Page> items = new ArrayList<>();
    @ValueMapValue
    private String id;

    @ValueMapValue
    private String accessibilityLabel;

//    @ValueMapValue
//    private int structureStart;

//    @ValueMapValue
//    private boolean disableShadowing;

    @PostConstruct
    private void init() {
        Page rootPage = navigationRoot;
        Iterator<Page> childPages = rootPage.listChildren(new PageFilter(request));
        while (childPages.hasNext()) {
            items.add(childPages.next());
        }
        if (collectAllPages) {
            List<Page> pages = items;
            while (true) {
                List<Page> nextLevelChildren = getPageChildrenList(pages);
                if (nextLevelChildren.isEmpty()) {
                    break;
                } else {
                    items.addAll(nextLevelChildren);
                    pages = nextLevelChildren;
                }
            }
        } else {
            int i = 1;
            List<Page> pages = items;
            while (i < structureDepth) {
                List<Page> nextLevelChildren = getPageChildrenList(pages);
                i++;
                items.addAll(nextLevelChildren);
                pages = nextLevelChildren;
            }
        }
    }

    private List<Page> getPageChildrenList(List<Page> pages) {
        List<Page> nextLevelChildren = new ArrayList<>();
        for (Page page : pages) {
            Iterator<Page> children = page.listChildren();
            while (children.hasNext()) {
                nextLevelChildren.add(children.next());
            }
        }
        return nextLevelChildren;
    }

    @Override
    public List<Page> getItems() {
        return items;
    }

    @Override
    public boolean isCollectAllPages() {
        return collectAllPages;
    }

    @Override
    public int getStructureDepth() {
        return structureDepth;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getAccessibilityLabel() {
        return accessibilityLabel;
    }

//    @Override
//    public int getStructureStart() {
//        return structureStart;
//    }
//
//    @Override
//    public boolean isDisableShadowing() {
//        return disableShadowing;
//    }
}
