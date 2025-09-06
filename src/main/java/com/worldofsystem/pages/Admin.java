package com.worldofsystem.pages;

import com.worldofsystem.utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Admin {

    //variables
    private final WebDriver driver;

    // locators
    private final By AddSystemUserButton = By.xpath("//button[@type='button' and contains(@class, 'oxd-button--secondary')]");

    // constructor
    public Admin(WebDriver driver){
        this.driver=driver;
    }

    // actions
    public Admin clickAddSystemUserButton(){
        ElementActions.clickElement(driver, this.AddSystemUserButton);
        return this;
    }

}
