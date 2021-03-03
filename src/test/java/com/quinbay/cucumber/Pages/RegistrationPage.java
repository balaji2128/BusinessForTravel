package com.quinbay.cucumber.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class RegistrationPage {


   @FindBy(xpath = "//button[@class='banner-model__cta--register']")
    WebElement register;
   @FindBy(xpath = "(//input[@type='text'])[1]")
   WebElement companyName;
   @FindBy(xpath = "(//input[@type='number'])[1]")
   WebElement phoneNum;
   @FindBy(xpath = "(//textarea)")
   WebElement address;
   @FindBy(xpath = "(//input[@type='number'])[2]")
   WebElement postcode;
   @FindBy(xpath = "(//div[@role='button'])[2]")
   WebElement province;
   @FindBy(xpath = "(//div//ul//li//button[@class=\"blu-list__item\"])[1]")
   WebElement province_name;
   @FindBy(xpath = "(//div[@role='button'])[5]")
    WebElement city;
    @FindBy(xpath = "(//div//ul//li//button[@class=\"blu-list__item\"])[35]")
    WebElement city_name;
    @FindBy(xpath = "(//div[@role='button'])[8]")
    WebElement district;
    @FindBy(xpath = "(//div//ul//li//button[@class=\"blu-list__item\"])[42]")
    WebElement district_name;
    @FindBy(xpath = "(//div[@role='button'])[11]")
    WebElement subDistrict;
    @FindBy(xpath = "(//div//ul//li//button[@class=\"blu-list__item\"])[45]")
    WebElement subDistrict_name;

    @FindBy(xpath = "(//input[@type='text'])[2]")
    WebElement firstName;
    @FindBy(xpath = "(//input[@type='text'])[3]")
    WebElement lastName;
    @FindBy(xpath = "(//input[@type='text'])[4]")
    WebElement job;
    @FindBy(xpath = "(//input[@type='number'])[3]")
    WebElement phonenumber;
    @FindBy(xpath = "(//input[@type='text'])[5]")
    WebElement email;

    @FindBy(xpath = "(//button[@class='blu-btn b-secondary'])[1]")
    WebElement browse;
    @FindBy(xpath = "(//input[@type='text'])[6]")
    WebElement npwp_label;


    public boolean verifyuserOnTravelForBusinessPage() {
        return register.isDisplayed();
    }
    public void clickOnRegister(){   register.click();   }

    public boolean verifyuserOnRegistartionPage()
    {
        return companyName.isDisplayed();
    }
    public void setBusinessProfile() {
        companyName.click();
        companyName.sendKeys("Stark Industries");
        phoneNum.sendKeys("8871823592");
        address.sendKeys("#1027,Malibu point,Newyork,America");
    }
    public void setProvince() {
        province.click();
        province_name.click();
    }
    public void setCity() {
        city_name.click();
    }

    public void setDistrict() {
        district_name.click();
    }

    public void setSubDistrict() {
        subDistrict_name.click();
    }

    public void setUserProfile() {
        postcode.sendKeys("560102");
        firstName.sendKeys("Tony");
        lastName.sendKeys("Stark");
        job.sendKeys("Philanthrophist");
        phonenumber.sendKeys("9843127821");
        email.sendKeys("tonystark007@gmail.com");

    }
    public void setBrowse() {
       browse.sendKeys(Keys.ENTER);
    }
    public void setRobot(String path) throws InterruptedException {
       // File file = new File(path);
        StringSelection StringSelection = new StringSelection(path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(StringSelection, null); //Copies the filepath to clipboard
        Robot robot = null;

        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
//This launches java applet, so we are using cmd+tab to shift the focus
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.delay(500);
//Open Goto window
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_G);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_G);
//Paste the clipboard value
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_V);
     Thread.sleep(2000);
//Press Enter key to close the Goto window and Upload window
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(500);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }

    public boolean verifyCity() {
        city.click();
        return city_name.isDisplayed();
    }

    public boolean verifyDistrict() {
        district.click();
        return district_name.isDisplayed();
    }
    public boolean verifySubDistrict(){
        subDistrict.click();
        return district_name.isDisplayed();
    }
    public String verifyNPWP()
    {
        System.out.println(npwp_label.getText());
        return npwp_label.getText();
    }

}







