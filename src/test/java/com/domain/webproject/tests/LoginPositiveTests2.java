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


public class LoginPositiveTests2 {

    @BeforeEach
    public void precondition(){
        open(EnvironmentManager.BASE_URL);
    }

    @Description("Login Positive Test")
    @Tag("smoke")
    @Tag("web_demo")
    @Test
    public void loginPositiveTest() {

        Logger.getInstance().info("Environment value -> " + System.getenv("env_var_name"));
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
