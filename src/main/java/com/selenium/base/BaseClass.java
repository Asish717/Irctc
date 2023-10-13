package com.selenium.base;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseClass {
    Logger logger=Logger.getLogger(BaseClass.class.getName());
    public static WebDriver driver;
    public void setup(){
        PropertyConfigurator.configure("E:\\IRCTC\\log4j.properties");
        ChromeOptions chrom=new ChromeOptions();
        chrom.addArguments("--disable-notifications");
        driver =new ChromeDriver(chrom);
        logger.info("Launching the browser");
        driver.manage().window().maximize();
        driver.get("https://www.irctc.co.in/nget/redirect?destination=");
        logger.debug("Launching the IRCTC site");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

}