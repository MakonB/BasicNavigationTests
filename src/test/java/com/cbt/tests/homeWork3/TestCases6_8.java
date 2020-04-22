package com.cbt.tests.homeWork3;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCases6_8 {

    WebDriver driver = BrowserFactory.getDriver("chrome");


    @Test
    public void testCase6() {
        driver.get("https://www.tempmailaddress.com/");
        driver.manage().window().maximize();
        String email = driver.findElement(By.xpath("//span[@id='email']")).getText();
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[text()='Sign Up For Mailing List']")).click();
        driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys("David");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
        driver.findElement(By.xpath("//button[@name='wooden_spoon']")).click();
        String  expected= "Thank you for signing up. Click the button below to return to the home page.";
        String actual = driver.findElement(By.cssSelector("h3[name='signup_message']")).getText();
        Assert.assertEquals(actual,expected);

        driver.get("https://www.tempmailaddress.com/");
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='do-not-reply@practice.cybertekschool.com']")));
        driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).click();

        String expected2 = "do-not-reply@practice.cybertekschool.com";
        String actual2 = driver.findElement(By.xpath("//span[@id='odesilatel']")).getText();
        Assert.assertEquals(actual2,expected2);

        String expected3 ="Thanks for subscribing to practice.cybertekschool.com!";
        String actual3 = driver.findElement(By.xpath("//span[@id='predmet']")).getText();
        Assert.assertEquals(actual3,expected3);

        driver.quit();

    }


    @Test
    public void testCase7() throws InterruptedException {

        driver.get("http://practice-cybertekschool.herokuapp.com");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[text()='File Upload']")).click();
        String path = "/Users/beibitbaimuratov/Desktop/file.txt";
        driver.findElement(By.id("file-upload")).sendKeys(path);
        driver.findElement(By.xpath("//input[@id='file-submit']")).click();

        String expected = "File Uploaded!";
        String actual = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(actual,expected);
        String expected2 = "file.txt";
        String actual2 = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(actual2,expected2);
        driver.quit();
    }


    @Test
    public void testCase8(){
        driver.get("http://practice-cybertekschool.herokuapp.com");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[text()='Autocomplete']")).click();
        WebElement input = driver.findElement(By.cssSelector("input[id='myCountry']"));
        input.sendKeys("United States of America");
        driver.findElement(By.cssSelector("input[type='button']")).click();
        String expected = "You selected: United States of America";
        String actual = driver.findElement(By.cssSelector("p[id='result']")).getText();
        Assert.assertEquals(actual,expected);
        driver.quit();

    }

}
