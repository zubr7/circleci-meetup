package com.domain.framework.utils.logger;

import io.qameta.allure.Step;
import org.slf4j.LoggerFactory;

public class Logger {

    private org.slf4j.Logger logger;

    private Logger(){
        this(Logger.class);
    }
    private Logger(Class clazz){
        logger = LoggerFactory.getLogger(clazz);
    }

    public static Logger getInstance(){
        return new Logger();
    }

    public static Logger getInstance(Class clazz){
        return new Logger(clazz);
    }

    public void info(Object message){
        logger.info(message.toString());
    }

    public void debug(Object message){
        logger.debug(message.toString());
    }

    public void testStartInfo(Class clazz){
        info(String.format("======= Test '%s' is started =======", clazz.getSimpleName()));
    }

    public void stepInfo(Object message){
        allureInfo(">>>   STEP: " + message);
    }

    @Step("{0}")
    public void allureInfo(Object message){
    }

    public void warn(Object message){
        logger.warn(message.toString());
    }

    @Step("Warn: {0}")
    public void allureWarn(Object message){
        warn(message);
    }

    public void error(Object message){
        logger.error(message.toString());
    }

    @Step("Error: {0}")
    public void allureError(Object message){
        error(message);
    }

}
