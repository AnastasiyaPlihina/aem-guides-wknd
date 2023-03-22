package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.Byline;
import com.adobe.aem.guides.wknd.core.models.ServiceDemo;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

@Model(
        adaptables = {SlingHttpServletRequest.class},
        adapters = {ServiceDemo.class},
        resourceType = {ServiceDemoImpl.RESOURCE_TYPE},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class ServiceDemoImpl implements ServiceDemo {
    protected static final String RESOURCE_TYPE = "wknd/components/servicedemo";
    private static final Logger log = LoggerFactory.getLogger(ServiceDemoImpl.class);
    @ValueMapValue
    private String value;

    @PostConstruct
    protected void init() {
        log.info("ServiceDemoImpl init");
    }

    @Override
    public String getValue() {
        return value;
    }
}
