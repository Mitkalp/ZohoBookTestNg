package com.qa.zohobook.base;

import com.qa.zohobook.pages.HomePage1;
import com.qa.zohobook.pages.SignInPage;
import com.qa.zohobook.pages.SignUpPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.Properties;

public class BaseTest {
   public BasePage basePage;
   public Properties propUtil;
   public WebDriver driver;
   public HomePage1 home;
   public SignInPage signIn;
   public  SignUpPage signup;


   @BeforeTest
    public void startUp(){

       basePage=new BasePage();
       propUtil =basePage.init_prop();
       String browser= propUtil.getProperty("browser");
       driver=basePage.init_driver(browser);
       home=new HomePage1(driver);
       driver.get(propUtil.getProperty("url"));

   }

   @AfterTest
   public void tearDown(){
       driver.quit();
   }


}
