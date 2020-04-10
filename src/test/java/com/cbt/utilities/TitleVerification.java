package com.cbt.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class TitleVerification {

    public static void main(String[] args) {

        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login");

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
        String title1 = driver.getTitle();
        String url1 = driver.getCurrentUrl();

        driver.get("http://practice.cybertekschool.com/dropdown");
        String title2 = driver.getTitle();
        String url2 = driver.getCurrentUrl();

        driver.get("http://practice.cybertekschool.com/login");
        String title3 = driver.getTitle();
        String url3 = driver.getCurrentUrl();

        driver.quit();

        if (title1.equals(title2) && title2.equals(title3)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        if (url1.startsWith("http://practice.cybertekschool.com") && url1.startsWith("http://practice.cybertekschool.com")
           && url3.startsWith("http://practice.cybertekschool.com")){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }


    }

}
