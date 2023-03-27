package com.adobe.aem.guides.wknd.core.models;


import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.inject.Inject;
import javax.inject.Named;
import com.adobe.cq.wcm.core.components.models.Image;

@Model(adaptables = {Resource.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class SocialMedia {

    @ValueMapValue
    @Named("socialMediaLink")
    private String link;

    @ValueMapValue(name = "fileReference")
    private String imageSrc;

    public String getLink() {
        return link;
    }


    public String getImageSrc() {
        return imageSrc;
    }
}
