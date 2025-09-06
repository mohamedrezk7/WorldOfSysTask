package com.worldofsystem.pages;

import com.worldofsystem.utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Candidates {
    //variables
    private final WebDriver driver;

    // locators
    private final By addCandidatesButton = By.xpath("//div[contains(@class, 'orangehrm-header-container')]//button[contains(@class, 'oxd-button--secondary')]");


    // constructor
    public Candidates(WebDriver driver){
        this.driver=driver;
    }

    // actions
    public Candidates clickAddCandidatesButton(){
        ElementActions.clickElement(driver,this.addCandidatesButton);
        return this;
    }
}
