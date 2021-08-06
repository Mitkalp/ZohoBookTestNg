package com.qa.zohobook.pages;

import com.qa.zohobook.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage1 extends BasePage {
    public WebDriver driver;

    public HomePage1(WebDriver driver){
       this.driver= driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy (xpath = "//*[@id=\"head\"]/div/div[3]/div[3]/a[2]")
    WebElement signUpButton;

    @FindBy(css = ".button")
    WebElement free14daysTrailsButton;

    @FindBy(xpath = "//div[@id=\"schedule_demo\"]")
    WebElement exploeDemoAccountButton;

    @FindBy(xpath = "//a[@class=\"zgh-login\"]")
    WebElement signinLink;


    public String getPageTitle(){
       return driver.getTitle();

    }
    public SignInPage navigateToSigninPage(){
        signinLink.click();
        return new SignInPage(driver);

    }

    public SignUpPage navigateToSignUpPage(){
    signUpButton.click();
    return new SignUpPage(driver);

}

    public void trail14DaysButton(){
    System.out.println(free14daysTrailsButton.isDisplayed());
    //free14daysTrailsButton.click();



}
}
