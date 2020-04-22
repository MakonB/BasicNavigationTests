package com.cbt.tests.homeWork3;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCases_9_12 {

    WebDriver driver = BrowserFactory.getDriver("chrome");


    @Test(dataProvider = "data")
    public void testWithDDT(String string){
         WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice-cybertekschool.herokuapp.com");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[text()='Status Codes']")).click();
        driver.findElement(By.xpath("//a[text()='"+string+"']")).click();
        String expected = "This page returned a "+string+" status code";
        String actual = driver.findElement(By.xpath("//p")).getText().split("\\.")[0].trim();
        Assert.assertEquals(actual,expected);
        driver.quit();

    }

    @DataProvider
    public Object[] data(){
        return new Object[]{"200","301","404","500"};
    }


}
