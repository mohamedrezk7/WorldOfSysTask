package com.worldofsystem.pages;

import com.worldofsystem.utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.asserts.SoftAssert;

public class AddCandidates {

    //variables
    private final WebDriver driver;
    SoftAssert softassert = new SoftAssert();

    // locators
    private final By firstNameField = By.xpath("//input[@name='firstName']");
    private final By lastNameField = By.xpath("//input[@name='lastName']");
    private final By emailField = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[1]/div/div[2]/input");
    private final By saveButton = By.xpath("//button[@type='submit' and contains(@class, 'oxd-button--secondary')]");
    private final By fullNameField = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[1]/form/div[1]/div[1]/div/div[2]/p");

    // constructor
    public AddCandidates(WebDriver driver){
        this.driver=driver;
    }

    // ACTIONS
    public AddCandidates addFirstName(String value){
        ElementActions.sendData(driver,this.firstNameField,value);
        return this;
    }
    public AddCandidates addLastName(String value){
        ElementActions.sendData(driver,this.lastNameField,value);
        return this;
    }
    public AddCandidates addEmail(String value){
        ElementActions.sendData(driver,this.emailField,value);
        return this;
    }
    public AddCandidates clickSaveButton(){
        ElementActions.clickElement(driver,this.saveButton);
        return this;
    }

    // validations
    public void verifyCandidatesCreated(String name){
        String actualValue = ElementActions.getText(driver , this.fullNameField);
        System.out.println(actualValue);
        softassert.assertEquals(actualValue,name);
    }
}
