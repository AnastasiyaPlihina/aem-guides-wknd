package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.Book;
import com.adobe.aem.guides.wknd.core.models.BookItems;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.inject.Inject;
import java.util.List;

@Model(adaptables = {SlingHttpServletRequest.class},
        adapters = {Book.class},
        resourceType = {BookImpl.RESOURCE_TYPE},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class BookImpl implements Book {
    protected static final String RESOURCE_TYPE = "wknd/components/book";
    @ValueMapValue
    private String title;
    @ValueMapValue
    private String fname;
    @ValueMapValue
    private String lname;
    @Inject
    @Via("resource")
    private List<BookItems> books;
    @Override
    public String getFname() {
        return fname;
    }

    @Override
    public String getLname() {
        return lname;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public List<BookItems> getBooks() {
        return books;
    }
}
