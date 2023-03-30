package com.adobe.aem.guides.wknd.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = {Resource.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CardResources {
    @ValueMapValue
    private String text;
    @ValueMapValue
    private String link;
    @ValueMapValue(name = "fileReference")
    private String imageSrc;

    public String getLink() {
        return link;
    }
    public String getImageSrc() {
        return imageSrc;
    }

    public String getText() {
        return text;
    }
}
