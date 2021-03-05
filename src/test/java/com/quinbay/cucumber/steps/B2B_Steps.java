package com.quinbay.cucumber.steps;
import com.quinbay.Pages.RegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.*;

public class B2B_Steps  {


    WebDriver driver;
    RegistrationPage basePage;

    @Given("I am on travelForBusiness page")
    public void iAmOnTravelForBusinessPage() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://travelforbusiness.blibli.com/");

        basePage = new RegistrationPage(driver);
        basePage = PageFactory.initElements(driver, RegistrationPage.class);
        assertTrue("Web Page is loaded",basePage.verifyuserOnTravelForBusinessPage());

    }
    @When("I Click on register")
    public void iClickOnRegister() {
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
        basePage.setBrowseNpwp();
        basePage.setRobotNpwp("/Users/balajic/Downloads/AllDocs/Cucumbers.pdf");

    }

    @Then("I Upload TDP Document")
    public void iUploadTDPDocument() throws AWTException,InterruptedException{
          Thread.sleep(6000);
          basePage.setBrowse_tdp();
          basePage.setRobotTdp("Supervised Learning.pdf");
    }

    @Then("I Upload SIUP Document")
    public void iUploadSIUPDocument() throws AWTException,InterruptedException{
          Thread.sleep(6000);
         basePage.setBrowse_siup();
         basePage.setRobotSiup("Semisupervised.pdf");
    }
    @Then("I check the Documents")
    public void iCheckTheDocuments() {
        assertEquals("NPWP Uploaded Succesfully","Cucumbers.pdf",basePage.verifyNPWP());

        Double size =basePage.checkFileSize("/Users/balajic/Downloads/AllDocs/Cucumbers.pdf");
        Double req=3.0000;
        assertThat("The files is Greater thaan 3MB",size,lessThanOrEqualTo(req));

        assertEquals("TDP Uploaded Succesfully","Supervised Learning.pdf",basePage.verifyTDP());
        assertEquals("SIUP Uploaded Succesfully","Semisupervised.pdf",basePage.verifySIUP());


    }
    @Then("I accpet to Terms and Conditions")
    public void iAccpetToTermsAndConditions() throws InterruptedException {
        basePage.setTermsAndConditions();

    }

//WebElement yourChkBox  = driver.findElement(By.xpath("//div[@class='checkbox']/input"));
// JavascriptExecutor js = (JavascriptExecutor) driver;
//js.executeScript("arguments[0].setAttribute('value', 'true');", yourChkBox );

//        Point point= element.getLocation();
//        int xcords=point.getX();
//        int ycords=point.getY();
//        System.out.println(element.getSize().getWidth());
//        System.out.println(element.getSize().getHeight());
//        builder.moveByOffset(xcords-100,ycords).build();
//        builder.click().build().perform();

//       Thread.sleep(6000);
//        basePage.checkDoc();
//        Thread.sleep(5000);
//        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
//        driver.switchTo().window(tabs2.get(1));
//
//
//        Thread.sleep(5000);
//        assertTrue("The doc not uploaded", basePage.visible_doc());

}
