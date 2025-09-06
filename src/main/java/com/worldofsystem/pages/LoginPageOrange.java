package com.worldofsystem.pages;

import com.worldofsystem.utils.BrowserActions;
import com.worldofsystem.utils.ElementActions;
import com.worldofsystem.utils.PropertiesUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageOrange {
    // variables
    String baseUrl = PropertiesUtils.getPropertyValue("baseUrl");
    private final  WebDriver driver;

    // locators
    private final By userNaneField = By.xpath("//input[@name='username']");
    private final  By passwordFiled = By.xpath("//input[@name='password']");
    private final  By logInButton = By.xpath("//button[@type='submit']");

    // constructor
    public LoginPageOrange(WebDriver driver){
        this.driver = driver;
    }
    // navigate To home Page
    public LoginPageOrange navigateToLoginPage(){
        BrowserActions.navigateToURL(driver , baseUrl);
        return this;
    }
    // actions
    public LoginPageOrange enterUserName(String userName){
        ElementActions.sendData(driver, this.userNaneField, userName);
        return this;
    }
    public LoginPageOrange enterPassword(String password){
        ElementActions.sendData(driver, this.passwordFiled, password);
        return this;
    }
    public LoginPageOrange clickLogin(){
        ElementActions.clickElement(driver, this.logInButton);
        return this;
    }
    // validation
}