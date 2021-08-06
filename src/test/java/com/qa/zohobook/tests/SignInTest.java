package com.qa.zohobook.tests;

import com.qa.zohobook.base.BaseTest;
import com.qa.zohobook.utils.Constant;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SignInTest extends BaseTest {

    @BeforeClass
    public void signInPageSetUp() {
        signIn = home.navigateToSigninPage();
    }

    @Test(priority = 1)
    public void signInPageTitleTest() {
        String title = signIn.signInPageTitle();
        System.out.println(title);
        Assert.assertEquals(title, Constant.Signin_Page_Title);
    }

    @Test(priority = 2)
    public void getPageLogoTest() {
        Assert.assertTrue(signIn.getPageLogo());
    }

    @Test(priority = 3)
    public void signinPageHeaderTextTest() {
        String signinheadertText = signIn.siginPageHeaderText();
        System.out.println(signinheadertText);
        Assert.assertEquals(signinheadertText, Constant.Signin_Header_Text);
    }

    @Test(priority = 4)
    public void footerTextTest() {
        String FooterText = signIn.footerText();
        System.out.println(FooterText);
        Assert.assertEquals(FooterText, "Sign in using");
    }

    @Test(priority = 6)
    public void forgetPasswordTest() {
        signIn.navigateToReSetPasswordPage();

    }

    @Test(priority = 7)
    public void signinEmailTextFieldTest() {
        signIn.signinPageEmailTextBox("Mimmm_@yahpp.com");
        signIn.doClickonNextbutton();
    }


}
