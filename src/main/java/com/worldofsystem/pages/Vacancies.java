package com.worldofsystem.pages;

import com.worldofsystem.utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Vacancies {

    //variables
    private final WebDriver driver;

    // locators
    private final By addVacancyButton = By.xpath("//div[contains(@class, 'orangehrm-header-container')]//button[contains(@class, 'oxd-button--secondary')]");
    private final By vacancyNameField = By.xpath("//label[contains(text(), 'Vacancy Name')]/ancestor::div[contains(@class, 'oxd-input-group')]//input");
    private final By jobTitleListField = By.xpath("(//div[contains(@class, 'oxd-select-text')])[1]");
    private final By hiringManagerFiled = By.xpath("//input[@placeholder='Type for hints...']/parent::div");
    private final By saveButton = By.xpath("//button[@type='submit']");

    // constructor
    public Vacancies(WebDriver driver){
        this.driver=driver;
    }

    // actions
    public Vacancies clickAddVacancyButton(){
        ElementActions.clickElement(driver,this.addVacancyButton);
        return this;
    }

}
