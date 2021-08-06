package com.qa.zohobook.tests;

import com.qa.zohobook.base.BaseTest;
import com.qa.zohobook.utils.Constant;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignupTest extends BaseTest
{
@BeforeClass
 public void signUpPageSetUP(){
    signup= home.navigateToSignUpPage();
}


@Test(priority = 1)
    public void signupPageTitle(){
    //signup=home.clickOnSignUpButton();
    String title=signup.signUpPageTitle();
    System.out.println(title);
    Assert.assertEquals(title,Constant.SignUp_PAge_Title);
}
@Test(priority = 2)
public void getAlreadySetAccountSigninLinkTest(){
    Assert.assertTrue(signup.isAlreadySetAccountSigninLink());

}
@Test(priority = 3)
    public void isSignUpHeadingTextTest(){
   String signUPHeadingText= signup.isSignUpHeadingText();
    System.out.println(signUPHeadingText);
    Assert.assertEquals(signUPHeadingText,Constant.SignUp_Header_Text);

}

@Test(priority = 4)
    public void RegisterSignUpPageTest(){
    signup.doEnterCompanyName("Miatl");
    signup.doEnterEmail("Mimmm_@yahpp.com");
    signup.doEnterContactNumber("08977678996");
    signup.doEnterPassword("mit_kalp@123");

}
@Test(priority = 5)
    public void selectCounteryTest(){
    //signup.selectCountry("United Kingdom");
    Assert.assertEquals(signup.selectCountry("United Kingdom"),Constant.getSignUp_PAge_DropDownText);

}


@Test(priority = 6)
    public void verifyCheckBox(){
    //System.out.println(signup.chekBox());
    Assert.assertEquals(2,signup.chekBox());
}

@Test(priority = 7)
    public void clickAccountButtonTest(){
   Assert.assertTrue( signup.clickCreateAccountButton());


}



    }
