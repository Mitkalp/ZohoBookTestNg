package com.qa.zohobook.pages;

import com.qa.zohobook.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SignUpPage extends BasePage {
    WebDriver driver;


    public SignUpPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//p[@class=\"sign-in\"]")
   private WebElement alreadyHaveZohoAccountLink;

    @FindBy(css = "#signup-heading")
    private  WebElement signUpHeading;

    @FindBy(id = "company_name")
   private WebElement companyNameBox;

    @FindBy(id="email_id")
    private WebElement emailIdBox;

    @FindBy(css = "#contact_number.form-control")
  private WebElement contactNumberBox;

    @FindBy(id = "password")
   private WebElement passwordBox;

    @FindBy(id="country")
    WebElement countryBox;

    @FindBy(xpath = "//input[@type=\"checkbox\"]")
   private  List<WebElement> checkBox;

    @FindBy(css="button.btn-signup")
    private  WebElement createAccountButton;



    public String signUpPageTitle(){
        return driver.getTitle();

    }

    public boolean isAlreadySetAccountSigninLink(){
       if (alreadyHaveZohoAccountLink.isDisplayed()){
           System.out.println(alreadyHaveZohoAccountLink.getText());
          return true;
        }
        //alreadyHaveZohoAccountLink.click();
        return false;
    }
    public String isSignUpHeadingText(){
        if(signUpHeading.isDisplayed()){
           return signUpHeading.getText();

        }
        return null;
    }



    public void doEnterCompanyName(String companyName){
        companyNameBox.sendKeys(companyName);
     }

     public void doEnterEmail(String email){
         emailIdBox.sendKeys(email);
     }

     public void doEnterContactNumber(String contactNumber){
         System.out.println("in");
         contactNumberBox.sendKeys(contactNumber);
    }

    public void doEnterPassword(String password){
         passwordBox.sendKeys(password);

    }

    public String selectCountry (String countryName){
            Select country = new Select(countryBox);
            List<WebElement> count = country.getOptions();
            System.out.println(count.size());
            for (int i = 0; i < count.size(); i++) {
                String text = count.get(i).getText();
                System.out.println(text);
            }

            country.selectByVisibleText(countryName);

            return countryName;
    }

    public int chekBox () {
            checkBox.get(0).click();
            return checkBox.size();
    }

    public boolean clickCreateAccountButton () {
            if (createAccountButton.isDisplayed() && createAccountButton.isEnabled()) {
                createAccountButton.submit();
                return true;
            }
            return false;


    }




    }

