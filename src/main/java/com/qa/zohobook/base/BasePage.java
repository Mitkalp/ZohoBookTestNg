package com.qa.zohobook.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public WebDriver driver;
    public Properties propUtil;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

    public WebDriver init_driver(String browser) {
        System.out.println("Browser value is " + browser);

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            // driver = new ChromeDriver();
            tlDriver.set(new ChromeDriver());
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            //driver=new FirefoxDriver();
            tlDriver.set(new FirefoxDriver());
        } else if (browser.equalsIgnoreCase("safari")) {
            //driver=new SafariDriver();
            tlDriver.set(new SafariDriver());
        } else {
            System.out.println("please enter valid browser value" + browser);
        }

        //driver.manage().deleteAllCookies();
        getDriver().manage().deleteAllCookies();
        //driver.manage().window().maximize();
        getDriver().manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //return driver;
        return getDriver();
    }

    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }

    public Properties init_prop() {
        propUtil = new Properties();
        try {
            FileInputStream ip = new FileInputStream("src/main/java/com/qa/zohobook/config/config.properties");
            propUtil.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return propUtil;
    }

    public String getScreenshot() {
        File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
        File destination = new File(path);
        try {
            FileUtils.copyFile(src, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }
}
