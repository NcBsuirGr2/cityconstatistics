package com.citycon.mikestatistics.springconfig;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class DispatcherServletConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    public String[] getServletMappings() {
        Logger logger = LoggerFactory.getLogger("com.citycon.mikestatistics.springconfig");
        logger.debug("getting mappings");
        return new String[] {"/"};
    }
    @Override
    public Class<?>[] getRootConfigClasses() {
        Logger logger = LoggerFactory.getLogger("com.citycon.mikestatistics.springconfig");
        logger.debug("get root config");
        return new Class<?>[] {RootConfig.class};
    }
    @Override
    public Class<?>[] getServletConfigClasses() {
        Logger logger = LoggerFactory.getLogger("com.citycon.mikestatistics.springconfig");
        logger.debug("get servlet config");
        return new Class<?>[] {WebConfig.class};
    }
}
