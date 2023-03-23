package com.adobe.aem.guides.wknd.core.models;

import java.util.List;

public interface Book {
    String getFname();
    String getLname();
    String getTitle();
    List<BookItems> getBooks();
}
