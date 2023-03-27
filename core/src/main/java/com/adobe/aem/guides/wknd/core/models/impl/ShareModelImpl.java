package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.Book;
import com.adobe.aem.guides.wknd.core.models.BookItems;
import com.adobe.aem.guides.wknd.core.models.ShareModel;
import com.adobe.aem.guides.wknd.core.models.SocialMedia;
import com.adobe.cq.wcm.core.components.models.Image;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.inject.Inject;
import java.awt.*;
import java.util.List;

@Model(adaptables = {SlingHttpServletRequest.class},
        adapters = {ShareModel.class},
        resourceType = {ShareModelImpl.RESOURCE_TYPE},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ShareModelImpl implements ShareModel {
    protected static final String RESOURCE_TYPE = "wknd/components/shareComponent";

    @ValueMapValue
    private String title;
    @Inject
    @Via("resource")
    private List<SocialMedia> resources;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public List<SocialMedia> getResources() {
        return resources;
    }
}
