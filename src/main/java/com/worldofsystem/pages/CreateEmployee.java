package com.worldofsystem.pages;

import com.worldofsystem.utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateEmployee {

    //variables
    private final WebDriver driver;

    // locators
    private final By firstNameField = By.xpath("//input[@name = 'firstName']");
    private final By lastNameField = By.xpath("//input[@name = 'lastName']");
    private final By employeeIdField = By.xpath("(//input[contains(@class,'oxd-input')])[5] ");
    private final By saveButton = By.xpath("//button[@type='submit' and normalize-space()='Save']");

    // constructor
    public CreateEmployee(WebDriver driver){
        this.driver=driver;
    }

    // actions

    public CreateEmployee enterFirstName(String name){
        ElementActions.sendData(driver, this.firstNameField,name);
        return this;
    }
    public CreateEmployee enterLastName(String name){
        ElementActions.sendData(driver, this.lastNameField,name);
        return this;
    }
    public CreateEmployee clearEmployeeId() {
        ElementActions.clearElement(driver,this.employeeIdField);
        return this;
    }
    public CreateEmployee enterEmployeeId(String name){
        ElementActions.sendData(driver, this.employeeIdField,name);
        return this;
    }
    public CreateEmployee clickSaveButton(){
        ElementActions.clickElement(driver, this.saveButton);
        return this;
    }

}
