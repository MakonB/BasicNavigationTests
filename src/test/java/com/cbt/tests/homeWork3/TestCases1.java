package com.cbt.tests.homeWork3;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TestCases1 {


    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Registration Form")).click();

    }

    @Test
    public void verifyWarningMessage(){
        WebElement dataBirth = driver.findElement(By.xpath("//input[@name='birthday']"));
        dataBirth.sendKeys("wrong_dob”");

        WebElement warningMessage = driver.findElement(By.xpath("//small[text()='The date of birth is not valid']"));
        String expected = "The date of birth is not valid";
        Assert.assertEquals(warningMessage.getText(),expected);
        Assert.assertTrue(warningMessage.isDisplayed());
    }


    @Test
    public void verifyLanguagesDisplayed(){
        List<WebElement> languages = driver.findElements(By.xpath("//label[@class='form-check-label']"));
        Assert.assertTrue(languages.get(0).isDisplayed());
        Assert.assertTrue(languages.get(1).isDisplayed());
        Assert.assertTrue(languages.get(2).isDisplayed());

        Assert.assertEquals(languages.get(0).getText(),"C++");
        Assert.assertEquals(languages.get(1).getText(),"Java");
        Assert.assertEquals(languages.get(2).getText(),"JavaScript");
    }


    @Test
    public void verifyWarningMessage2(){
        WebElement inputBox = driver.findElement(By.cssSelector("[name='firstname']"));
        inputBox.sendKeys("a");

        WebElement warningMessage = driver.findElement(By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']"));
        String expected = "first name must be more than 2 and less than 64 characters long";

        Assert.assertTrue(warningMessage.isDisplayed());
        Assert.assertEquals(warningMessage.getText(),expected);
    }


    @Test
    public void verifyWarningMessage3(){
        driver.findElement(By.cssSelector("[name='lastname']")).sendKeys("a");
        WebElement warningMessage = driver.findElement(By.xpath("//small[text()='The last name must be more than 2 and less than 64 characters long']"));

        String expected = "The last name must be more than 2 and less than 64 characters long";

        Assert.assertTrue(warningMessage.isDisplayed());
        Assert.assertEquals(warningMessage.getText(),expected);
    }

    @Test
    public void VerifySuccessMessage() throws InterruptedException {
        driver.findElement(By.cssSelector("[name='firstname']")).sendKeys("abc");
        driver.findElement(By.cssSelector("[name='lastname']")).sendKeys("absd");
        driver.findElement(By.cssSelector("[name='username']")).sendKeys("ansf12234");
        driver.findElement(By.cssSelector("[name='email']")).sendKeys("bbaimurat@gmail.com");
        driver.findElement(By.cssSelector("[name='password']")).sendKeys("kjkjkj123");
        driver.findElement(By.cssSelector("[name='phone']")).sendKeys("123-123-1234");
        driver.findElement(By.xpath("//input[@value='male']")).click();
        driver.findElement(By.cssSelector("[name='birthday']")).sendKeys("11/23/1985");
        Select  select = new Select( driver.findElement(By.cssSelector("select[name='department']")));
        select.selectByVisibleText("MPDC");
        select= new Select(driver.findElement(By.cssSelector("select[name='job_title']")));
        select.selectByVisibleText("SDET");
        driver.findElement(By.cssSelector("input[id='inlineCheckbox1']")).click();
        driver.findElement(By.cssSelector("button[id='wooden_spoon']")).click();
        Thread.sleep(3000);

        WebElement element = driver.findElement(By.xpath("//p"));
        String expected = "You've successfully completed registration!";
        Assert.assertEquals(element.getText(),expected);
        Assert.assertTrue(element.isDisplayed());


    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
