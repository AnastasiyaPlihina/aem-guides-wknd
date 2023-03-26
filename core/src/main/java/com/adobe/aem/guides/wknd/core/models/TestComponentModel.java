package com.adobe.aem.guides.wknd.core.models;

import java.util.List;

public interface TestComponentModel {
    List<WordItems> getWords();
    boolean isSortedWords();
}
