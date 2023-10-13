package com.selenium;

import com.selenium.base.BaseClass;
import com.selenium.page.LoginPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import net.sourceforge.tess4j.TesseractException;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class IRCTCtest extends BaseClass {
    Logger logger =Logger.getLogger(IRCTCtest.class.getName());
    LoginPage loginPage;
    @BeforeMethod
    public void start (){
        setup();
        loginPage=new LoginPage(driver);
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Testing Captcha")
    public void customerLoginPage() throws TesseractException, IOException, InterruptedException {
        loginPage.CaptureText();
        logger.info("End of the Program");
    }

}