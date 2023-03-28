package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.Book;
import com.adobe.aem.guides.wknd.core.models.LinkResource;
import com.adobe.aem.guides.wknd.core.models.TextLinks;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;

import javax.inject.Inject;
import java.util.List;

@Model(adaptables = {SlingHttpServletRequest.class},
        adapters = {TextLinks.class},
        resourceType = {TextLinksImpl.RESOURCE_TYPE},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TextLinksImpl implements TextLinks {
    protected static final String RESOURCE_TYPE = "wknd/components/textLinks";
    @Inject
    @Via("resource")
    private List<LinkResource> resources;

    @Override
    public List<LinkResource> getResources() {
        return resources;
    }
}
