package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification3 {

    public static void main(String[] args) {

        List<String> urls = Arrays.asList("https://www.luluandgeorgia.com/",
                "https://wayfair.com/",
                "https://walmart.com",
                "https://westelm.com/");


        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.luluandgeorgia.com/");
        String title = driver.getTitle().toLowerCase().replace(" ","");
        if (driver.getCurrentUrl().contains(title)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL " + driver.getCurrentUrl() + " " + driver.getTitle());
        }
        driver.quit();


        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://wayfair.com/");
        String title1 = driver.getTitle().toLowerCase().replace(" ","");
        if (driver.getCurrentUrl().contains(title1)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL " + driver.getCurrentUrl() + " " + driver.getTitle());
        }
        driver.quit();

        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://walmart.com");
        String title2 = driver.getTitle().toLowerCase().replace(" ","");
        if (driver.getCurrentUrl().contains(title2)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL " + driver.getCurrentUrl() + " " + driver.getTitle());
        }
        driver.quit();

        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://westelm.com/");
        String title3 = driver.getTitle().toLowerCase().replace(" ","");
        if (driver.getCurrentUrl().contains(title3)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL " + driver.getCurrentUrl() + " " + driver.getTitle());
        }
        driver.quit();

    }
}
