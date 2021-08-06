package com.qa.zohobook.pages;

import com.qa.zohobook.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends BasePage {
    WebDriver driver;

    @FindBy(xpath = "//div[@class =\"zoho_logo ZohoBooks\"]")
    private WebElement pageLogo;

    @FindBy(xpath = "//span[@id =\"headtitle\"]")
    private WebElement headTitle;

    @FindBy (css="#login_id")
    private WebElement emailTextBox;

    @FindBy(xpath = "//button[@class=\"btn blue\" and @id=\"nextbtn\"]")
    private WebElement nextButton;

    @FindBy(linkText = "Forgot Password?")
    private WebElement forgetPasswordLink;

    @FindBy(xpath="//div[@class=\"signin_fed_text\"]")
    private WebElement footerSigninText;

    public  SignInPage(WebDriver driver ) {
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    public String signInPageTitle(){

        return driver.getTitle();
    }

    public  Boolean getPageLogo() {
          if (pageLogo.isDisplayed()) {
           return true;
          }
          return false;
    }

    public String siginPageHeaderText(){
       if(headTitle.isDisplayed()){
       return headTitle.getText();
       }
       return null;
    }
    public String footerText(){
        if(footerSigninText.isDisplayed()){
            return footerSigninText.getText();
        }
        return null;
    }
    public ResetPasswordPage navigateToReSetPasswordPage(){
        forgetPasswordLink.isDisplayed();
        forgetPasswordLink.click();
        return new ResetPasswordPage(driver);
    }

    public void signinPageEmailTextBox(String email_MobileNumber){
        emailTextBox.sendKeys(email_MobileNumber);
    }

    public boolean doClickonNextbutton(){
        if(nextButton.isDisplayed() && nextButton.isEnabled()){
              nextButton.click();
              return true;
        }
        return false;
    }

}
