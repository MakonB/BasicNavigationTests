package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {

    private static WebDriver driver;

    public static WebDriver getDriver(String browserName) {

        if(System.getProperty("os.name").contains("Mac") && browserName.equals("edge") ){
            return null;
        }else if(!System.getProperty("os.name").contains("Mac") && browserName.equals("safari")){
            return null;
        }


        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().version("81").setup();
            return new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else if (browserName.equals("opera")) {
            WebDriverManager.operadriver().setup();
            return new OperaDriver();
        }else if(browserName.equals("safari")) {
            WebDriver safariDriver = new SafariDriver();
            return safariDriver;
        }else if(browserName.equals("edge")){
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
        }else {
            WebDriverManager.iedriver().setup();
            return new InternetExplorerDriver();
        }
    }

}
