package com.domain.framework.config;

import com.domain.framework.utils.logger.Logger;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Properties;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

public abstract class BaseConfigManager {

    private static final String PROFILE_ENVIRONMENT_VARIABLE = "TEST_PROFILE";
    private static final String SELENIDE_STARTKEY = "selenide.";
    private static final MessageFormat PROPERTY_FILE_NAME_PATTERN = new MessageFormat("/{0}.properties");

    protected static Logger log = Logger.getInstance(BaseConfigManager.class);
    protected static Properties properties = new Properties();

    /**
     * Loads all properties from the file depending on the set up system profile.
     * If profile hasn't been set up, the default profile will be used.
     */
    protected static void loadProperties(String propertyBundle) {
        properties = getProperties(propertyBundle);
        initSelenideProperties();
    }

    public static Properties getProperties(String propertyBundle) {
        String propFileName;
        String customProfile = System.getenv(PROFILE_ENVIRONMENT_VARIABLE);

        if (isNotEmpty(customProfile)) {
            log.info("Loading profile properties for: " + customProfile);
            propFileName = PROPERTY_FILE_NAME_PATTERN.format(new Object[]{customProfile});
        } else {
            propFileName = PROPERTY_FILE_NAME_PATTERN.format(new Object[]{propertyBundle});
        }

        Properties localProperties = new Properties();
        try {
            localProperties.load(BaseConfigManager.class.getResourceAsStream(propFileName));
        } catch (IOException e) {
            throw new RuntimeException(propFileName + "  property file is not loaded because of " + e.getStackTrace());
        }
        return localProperties;
    }

    private static void initSelenideProperties(){
        for (String key : properties.stringPropertyNames()) {
            if (key.startsWith(SELENIDE_STARTKEY))
                System.setProperty(key, properties.getProperty(key));
        }
    }
}
