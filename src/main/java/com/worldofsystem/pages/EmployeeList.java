package com.worldofsystem.pages;

import com.worldofsystem.utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class EmployeeList {
    // variables
    private final WebDriver driver;
    SoftAssert softassert = new SoftAssert();

     // locators
        private final By firstName = By.xpath("//input[@name='firstName']");
        private final By lastName = By.xpath("//input[@name='lastName']");
        private final By employeeId = By.xpath("(//div[contains(@class, 'oxd-input-group')]//input)[4]");
    // constructor
    public EmployeeList(WebDriver driver){
        this.driver=driver;

    }
    // validation
    public void verifyEmployeeFirstName(String name){
        String actualValue = ElementActions.getText(driver , firstName);
        softassert.assertEquals(actualValue,name);
    }
    public void verifyEmployeeLastName(String name){
        String actualValue = ElementActions.getText(driver , lastName);
        softassert.assertEquals(actualValue,name);
    }
    public void verifyEmployeeID(String name){
        String actualValue = ElementActions.getText(driver , employeeId);
        softassert.assertEquals(actualValue,name);
    }
}
