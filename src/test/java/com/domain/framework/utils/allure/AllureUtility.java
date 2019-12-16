package com.domain.framework.utils.allure;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.Attachment;


public class AllureUtility {

    private final static String ALLURE_SCREENSHOT_TYPE = "image/png";
    private final static String ALLURE_SCREENSHOT_PAGE_VALUE = "Page screenshot";
    private final static String ALLURE_ATTACHMENT_PRECONDITION_VALUE = "Precondition data";

    @Attachment(value = ALLURE_ATTACHMENT_PRECONDITION_VALUE)
    public static String attachInfo(String value) throws JsonProcessingException {
        return value;
    }


}
