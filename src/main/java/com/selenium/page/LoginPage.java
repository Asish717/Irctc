package com.selenium.page;

import com.selenium.base.BaseClass;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class LoginPage {
    Logger logger=Logger.getLogger(LoginPage.class.getName());
    WebDriver driver;
    @FindBy(xpath = "/html/body/app-root/app-home/div[1]/app-header/div[1]/div[2]/a/i")
    WebElement hamButton;

    @FindBy(xpath = "//*[text()='LOGIN']")
    WebElement loginButton;

    @FindBy(xpath = "//body/app-root[1]/app-home[1]/div[3]/app-login[1]/p-dialog[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/form[1]/div[4]/div[1]/app-captcha[1]/div[1]/div[1]/div[2]/span[1]/img[1]")
    WebElement imageCaptcha;

    @FindBy(id = "captcha")
    WebElement enterCaptcha;

    @FindBy(xpath = "//input[@placeholder='User Name']")
    WebElement loginName;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement password;

    @FindBy(xpath = "//button[contains(text(),'SIGN IN')]")
    WebElement signInButton;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void CaptureText() throws InterruptedException, IOException, TesseractException {
        hamButton.click();
        loginButton.click();
        logger.info("Entering to login page");
        Thread.sleep(1000);
        loginName.sendKeys("asish");
        Thread.sleep(1000);
        password.sendKeys("12345");
        Thread.sleep(1000);
        logger.info("Details filled");

        File screenShot= imageCaptcha.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot,new File("E:\\IRCTC\\src\\Captcha\\capture.png"));

        Tesseract tesseract =new Tesseract();
        tesseract.setDatapath("D:\\Tesseract\\tessdata");
        String scrappedText=tesseract.doOCR(new File("E:\\IRCTC\\src\\Captcha\\capture.png"));
        System.out.println(scrappedText);

        enterCaptcha.sendKeys(scrappedText);
        Thread.sleep(2000);
        logger.info("Entered Captcha");

        signInButton.click();
        logger.info("Clicked Signin");
    }

}