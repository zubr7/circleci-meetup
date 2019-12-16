package com.domain.framework.utils.allure;

import com.domain.framework.utils.logger.Logger;
import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.model.StepResult;

public class StepLifecycleListenerImp implements StepLifecycleListener {
    protected static final Logger logger = Logger.getInstance(StepLifecycleListenerImp.class);

    @Override
    public void beforeStepStart(StepResult result) {
        logger.info(String.format("allure: %s", result.getName()));
    }
}
