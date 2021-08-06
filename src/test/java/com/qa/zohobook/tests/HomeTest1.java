package com.qa.zohobook.tests;

import com.qa.zohobook.base.BaseTest;
import com.qa.zohobook.utils.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest1 extends BaseTest {


    @Test(priority = 1)
    public void pageTitleTest(){
        String title=home.getPageTitle();
        System.out.println("page Title is"+ title);
        Assert.assertEquals(title, Constant.Page_Title);
    }


    @Test(priority = 3)
    public void clickOnSignUpButtonTest() {
        home.navigateToSignUpPage();

    }


    @Test(priority = 2)
    public void freeTrialButtonTest(){
     home.trail14DaysButton();
    }







}