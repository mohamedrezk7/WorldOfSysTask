package com.worldofsystem.pages;

import com.worldofsystem.utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Recruitment {

    //variables
    private final WebDriver driver;

    // locators
    private final By addVacancyButton = By.xpath("//div[contains(@class, 'orangehrm-header-container')]//button[contains(@class, 'oxd-button--secondary')]");
    private final By vacanciesButton = By.xpath("//a[text()='Vacancies']");
    private final By candidatesButton = By.xpath("//a[text()='Candidates']");
    // constructor
    public Recruitment(WebDriver driver){
        this.driver=driver;
    }

    // actions

//    public Recruitment clickAddVacancyButton(){
//        ElementActions.clickElement(driver, this.addVacancyButton);
//        return this;
//    }
    public Recruitment clickVacanciesButton(){
        ElementActions.clickElement(driver, this.vacanciesButton);
        return this;
    }
    public Recruitment clickCandidatesButton(){
        ElementActions.clickElement(driver, this.candidatesButton);
        return this;
    }

}