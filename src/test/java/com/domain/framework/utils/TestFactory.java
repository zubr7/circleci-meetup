package com.domain.framework.utils;

import com.domain.framework.utils.logger.Logger;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;
import static org.junit.platform.launcher.TagFilter.includeTags;

public class TestFactory {
    protected static final Logger logger = Logger.getInstance();
    private static String TAG_ENVIRONMENT_VARIABLE = "TEST_TAG";
    private static String DEFAULT_TAG = "web_demo";
    private static String DEFAULT_TEST_PACKAGE = "com.domain.webproject.tests";
    //todo: https://github.com/junit-team/junit5/pull/19

    @Tag("testfactory")
    @Test
    void testFactoryTest() {
        beforeTestsSetup();
        try {
            String customTag = System.getenv(TAG_ENVIRONMENT_VARIABLE);
            String testTag = DEFAULT_TAG;
            if (isNotEmpty(customTag)) {
                testTag = customTag;
            }
            LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                    .selectors(selectPackage(DEFAULT_TEST_PACKAGE))
                    .filters(includeTags(testTag))
                    .build();
            Launcher launcher = LauncherFactory.create();
            TestExecutionListener listener = new SummaryGeneratingListener();
            launcher.registerTestExecutionListeners(listener);
            launcher.execute(request);
        } catch (Exception e) {
            logger.info("Caught Unhandled Exception during tests run " + e.getMessage());

        } finally {
            afterTestExecution();
        }

    }

    public static void beforeTestsSetup() {
        //insert any code that should be executed once before all the tests run
    }

    public static void afterTestExecution() {
        //insert any code that should be executed once after all the tests run
    }
}
