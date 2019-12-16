package com.domain.webproject.tests;

import com.codeborne.selenide.WebDriverRunner;
import com.domain.framework.config.EnvironmentManager;
import com.domain.framework.utils.logger.Logger;
import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;


public class LoginPositiveTests {

    @BeforeEach
    public void precondition(){
        open(EnvironmentManager.BASE_URL);
    }

    @Description("Login Positive Test")
    @Tag("smoke")
    @Tag("web_demo")
    @Test
    public void loginPositiveTest() {

        for (String item : System.getProperties().stringPropertyNames()) {
            Logger.getInstance().info(item + ": " + System.getProperty(item));
        }
        Logger.getInstance().info("System.getenv()");
        for (String item : System.getenv().keySet()) {
            Logger.getInstance().info(item + ": " + System.getenv(item));
        }
        
        Logger.getInstance().info("CONFIG_VAR2 value -> " + System.getenv("CONFIG_VAR2"));
        Logger.getInstance().info("MY_ENV_VAR value -> " + System.getenv("MY_ENV_VAR"));
        Logger.getInstance().info("WORKDIR value -> " + System.getenv("WORKDIR"));
        Logger.getInstance().info("BRANCH value -> " + System.getenv("BRANCH"));
        
                
        int navigationItemAmount = $$x("//li[@class='b-main-navigation__item']") .size();

        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assertions.assertEquals(4, navigationItemAmount, "Navigation Items have unexpected amount");
    }

    @AfterEach
    public void postcondition(){
        close();
    }

}
