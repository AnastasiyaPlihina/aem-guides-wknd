package com.adobe.aem.guides.wknd.core.models;

import com.day.cq.wcm.api.Page;

import java.util.List;

public interface NavigationMenu {
    List<Page> getItems();

    boolean isCollectAllPages();

    int getStructureDepth();

    String getId();

    String getAccessibilityLabel();
    //    int getStructureStart();
    //    boolean isDisableShadowing();

}
