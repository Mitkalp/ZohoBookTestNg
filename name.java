<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="ZohoBook Test Suite"  parallel="tests" thread-count="3" >

    <listeners>
        <listener class-name="com.qa.zohobook.listeners.ExtentReportListener" />
    </listeners>

    <test name="Home Test">
        <classes>
            <class name="com.qa.zohobook.tests.HomeTest1"/>
        </classes>
    </test>
    <test name="Signup Test">
        <classes>
            <class name="com.qa.zohobook.tests.SignupTest"/>
        </classes>
    </test>
    <test name="SigIn Test">
        <classes>
            <class name="com.qa.zohobook.tests.SignInTest"/>
        </classes>
    </test>



</suite>