package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.ShareModel;
import com.adobe.aem.guides.wknd.core.models.TestComponentModel;
import com.adobe.aem.guides.wknd.core.models.WordItems;
import com.day.cq.wcm.api.WCMMode;
import com.day.cq.wcm.api.components.ComponentContext;
import com.day.cq.wcm.api.components.EditAction;
import com.day.cq.wcm.api.components.Toolbar;
import com.day.cq.wcm.commons.WCMUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;


import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Model(adaptables = {SlingHttpServletRequest.class},
        adapters = {TestComponentModel.class},
        resourceType = {TestComponentModelImpl.RESOURCE_TYPE},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TestComponentModelImpl implements TestComponentModel {
    protected static final String RESOURCE_TYPE = "wknd/components/testComponent";
    //    @Inject
//    @Via("resource")
//    private List<WordItems> words;
    @ValueMapValue
    private String words;
    @ValueMapValue
    private boolean sortedWords;


//    @Override
//    public List<WordItems> getWords() {
//        if (sortedWords) {
//            words.sort(Comparator.comparing(WordItems::getWord));
//        }
//        return words;
//    }

    @Override
    public String getWords() {
        if (sortedWords) {
            String replaceWords = words.replace("<p>", "").replace("</p>", "");
            String[] wordsArray = replaceWords.split(" ");
            Arrays.sort(wordsArray);
            StringBuilder sortedWords = new StringBuilder("<p>");
            for (String word : wordsArray) {
                sortedWords.append(word).append(" ");
            }
            return sortedWords.append("</p>").toString();
        }
        return words;
    }

    @Override
    public boolean isSortedWords() {
        return sortedWords;
    }


}
