package com.domain.framework.config;

public class EnvironmentManager extends BaseConfigManager{

    private static final String CONFIG_NAME = "environment";
    static {
        loadProperties(CONFIG_NAME);
    }

    public static final String BASE_URL = properties.getProperty("selenide.webUrl");

}
