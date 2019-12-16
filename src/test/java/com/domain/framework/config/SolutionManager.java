package com.domain.framework.config;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.domain.framework.utils.logger.Log4jSelenide;
import io.qameta.allure.selenide.AllureSelenide;

public class SolutionManager extends BaseConfigManager{

    private static final String CONFIG_NAME = "solution";
    static {
        loadProperties(CONFIG_NAME);
        initLoggerProperties();
    }

    public static final boolean LOG_CONSOLE_VERBOSE = Boolean.parseBoolean(properties.getProperty("log.selenide.verbose"));
    public static final boolean LOG_ALLURE_VERBOSE = Boolean.parseBoolean(properties.getProperty("log.selenide.to.allure.verbose"));


    public static void initLoggerProperties(){
        if (LOG_ALLURE_VERBOSE)
            SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        if (LOG_CONSOLE_VERBOSE)
            SelenideLogger.addListener("Log4jSelenide", new Log4jSelenide());
    }




}
