package com.quinbay.cucumber.steps;
import com.quinbay.cucumber.Pages.RegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class B2B_Steps  {


    WebDriver driver;
    RegistrationPage basePage=new RegistrationPage();
    @Given("I am on travelForBusiness page")
    public void iAmOnTravelForBusinessPage() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://travelforbusiness.blibli.com/");
        basePage=PageFactory.initElements(driver,RegistrationPage.class);


        assertTrue("Web Page is loaded",basePage.verifyuserOnTravelForBusinessPage());

    }
    @When("I Click on register")
    public void iClickOnRegister() throws InterruptedException{
       basePage.clickOnRegister();

    }

    @Then("I Should be redirect to the Forms")
    public void iShouldBeRedirectToTheForms() {
        assertTrue("Registration Page is Not Loaded",basePage.verifyuserOnRegistartionPage());

    }

    @And("I Fill the details")
    public void iFillTheDetails() throws InterruptedException{
            basePage.setBusinessProfile();
            basePage.setProvince();
            assertTrue("City Dropdown was not Enabled",basePage.verifyCity());
            basePage.setCity();
            assertTrue("District was not Enabled",basePage.verifyDistrict());
            basePage.setDistrict();
            assertTrue("Sub-District was not Enabled", basePage.verifySubDistrict());
            basePage.setSubDistrict();
            basePage.setUserProfile();

    }

    @Then("I Upload NPWP Document")
    public void iUploadNPWPDocument() throws AWTException,InterruptedException{
        Thread.sleep(2000);
        basePage.setBrowse();
        basePage.setRobot("/Users/balajic/Downloads/AllDocs/Cucumbers.pdf");

        //assertEquals("Document not Added","Cucumbers.pdf",basePage.verifyNPWP());
    }

    @Then("I Upload TDP Document")
    public void iUploadTDPDocument() throws AWTException,InterruptedException{
//         Thread.sleep(5000);
//        basePage.verifyNPWP();
//        Thread.sleep(2000);
//        basePage.setBrowse();
//        basePage.setRobot("/Users/balajic/Downloads/AllDocs/Cucumbers.pdf");
    }

    @Then("I Upload SIUP Document")
    public void iUploadSIUPDocument() throws AWTException,InterruptedException{
//        Thread.sleep(2000);
//        basePage.setBrowse();
//        basePage.setRobot("/Users/balajic/Downloads/AllDocs/Cucumbers.pdf");
    }

    @Then("I accpet to Terms and Conditions")
    public void iAccpetToTermsAndConditions() {
    }
}
