package com.adobe.aem.guides.wknd.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;


@Model(adaptables = {Resource.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class BookItems {
    @ValueMapValue
    private String bookName;
    @ValueMapValue
    private String yearOfCreation;

    public String getBookName() {
        return bookName;
    }

    public String getYearOfCreation() {
        return yearOfCreation;
    }

}
