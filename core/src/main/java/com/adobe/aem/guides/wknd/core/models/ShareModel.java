package com.adobe.aem.guides.wknd.core.models;

import com.adobe.cq.wcm.core.components.models.Image;

import java.util.List;

public interface ShareModel {
    String getTitle();
    List<SocialMedia> getResources();

}
