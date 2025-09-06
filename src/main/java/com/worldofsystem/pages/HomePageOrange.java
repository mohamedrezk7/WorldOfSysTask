package com.worldofsystem.pages;

import com.worldofsystem.utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageOrange {
    // variables
    private  final WebDriver driver;

    // locators
    private final By pimModule =By.xpath("//a[@href='/web/index.php/pim/viewPimModule' ]");
    private final By Recruitment = By.xpath("//a[@href='/web/index.php/recruitment/viewRecruitmentModule']");
    private final By Admin = By.xpath("//span[text()='Admin']");

    // constructor
    public HomePageOrange (WebDriver driver){
        this.driver=driver;
    }

    // actions

    public HomePageOrange ClickOnPimModule (){
        ElementActions.clickElement(driver , this.pimModule);
        return  this;
    }
    public HomePageOrange ClickOnRecruitment (){
        ElementActions.clickElement(driver , this.Recruitment);
        return  this;
    }
    public HomePageOrange ClickOnAdmin (){
        ElementActions.clickElement(driver , this.Admin);
        return  this;
    }
}
