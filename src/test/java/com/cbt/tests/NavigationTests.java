package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;

public class NavigationTests {

    public static void verifyTitleWithChrome() {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://google.com");
        driver.manage().window().maximize();
        String googleTitle = driver.getTitle();

        driver.navigate().to("https://etsy.com");
        String etsyTitle =  driver.getTitle();

        driver.navigate().back();

        StringUtility.verifyEquals( driver.getTitle(),googleTitle);

        driver.navigate().forward();
        StringUtility.verifyEquals( driver.getTitle(),etsyTitle);

        driver.quit();
    }


    public static void verifyTitleWithFox() {

        WebDriver driver = BrowserFactory.getDriver("firefox");
        driver.get("https://google.com");
        driver.manage().window().maximize();
        String googleTitle = driver.getTitle();

        driver.navigate().to("https://etsy.com");
        String etsyTitle =  driver.getTitle();

        driver.navigate().back();

        StringUtility.verifyEquals( driver.getTitle(),googleTitle);

        driver.navigate().forward();
        StringUtility.verifyEquals( driver.getTitle(),etsyTitle);

        driver.quit();
    }

    public static void verifyTitleWithSafari() {

        WebDriver driver = BrowserFactory.getDriver("safari");
        driver.get("https://google.com");
        driver.manage().window().maximize();
        String googleTitle = driver.getTitle();

        driver.navigate().to("https://etsy.com");
        String etsyTitle =  driver.getTitle();

        driver.navigate().back();

        StringUtility.verifyEquals( driver.getTitle(),googleTitle);

        driver.navigate().forward();
        StringUtility.verifyEquals( driver.getTitle(),etsyTitle);

        driver.quit();
    }





    public static void main(String[] args) {


        verifyTitleWithChrome();

        verifyTitleWithFox();

        verifyTitleWithSafari();


    }

}
