package com.domain.framework.utils.logger;

import com.codeborne.selenide.logevents.LogEvent;
import com.codeborne.selenide.logevents.LogEventListener;

public class Log4jSelenide  implements LogEventListener {

    private final String SELENIDE_PREFIX = "Selenide: ";

    @Override
    public void afterEvent(LogEvent currentLog) {
        Logger.getInstance().info(SELENIDE_PREFIX + currentLog.toString());
    }

    @Override
    public void beforeEvent(LogEvent currentLog) {
        Logger.getInstance().info(SELENIDE_PREFIX + currentLog.toString());
    }

}
