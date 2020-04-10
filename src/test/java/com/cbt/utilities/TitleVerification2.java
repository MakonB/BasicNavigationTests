package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification2 {

    public static void main(String[] args) {

        List<String> urls = Arrays.asList("https://www.luluandgeorgia.com/",
                "https://wayfair.com/",
                "https://walmart.com",
                "https://westelm.com/");

        /*
         * 3.Visit all websites one by one.
         * 4.Verify that URL of the website contains the title of the website.
         * Ignore spaces and casein comparison. For example,title of in the first
         * website title is Lulu and Giorgia and the URLis https://lulugandgeorgia.com.
         * So,this test case must pass.
         * 5.Close the browser at the end of the test.
         */

        WebDriver driver = BrowserFactory.getDriver("chrome");
        for (String url : urls) {
            driver.get(url);
            if (url.contains(driver.getTitle().toLowerCase().replace(" ",""))){
                System.out.println("PASS " +driver.getTitle() );
            }else {
                System.out.println("FAIL " + url + " " + driver.getTitle());
            }

        }
        driver.quit();
    }
}
