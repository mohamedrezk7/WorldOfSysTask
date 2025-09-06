package com.worldofsystem.pages;

import com.worldofsystem.utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddVacancy {
    //variables
    private final WebDriver driver;

    // locators
    private final By addVacancyButton = By.xpath("//div[contains(@class, 'orangehrm-header-container')]//button[contains(@class, 'oxd-button--secondary')]");
    private final By vacancyNameField = By.xpath("//label[contains(text(), 'Vacancy Name')]/ancestor::div[contains(@class, 'oxd-input-group')]//input");
    private final By jobTitleListField = By.xpath("//div[@class='oxd-select-text-input']");
    private final By optionValueJobTitle = By.xpath("//div[@role='option']");
    private final By hiringManagerFiledElement = By.cssSelector("input[placeholder='Type for hints...']");
    private final By saveButton = By.xpath("//button[@type='submit']");
    private final By hiringManagerValueOption = By.cssSelector("div.oxd-autocomplete-dropdown > div");

    // constructor
    public AddVacancy(WebDriver driver){
        this.driver=driver;
    }

    // actions
    public AddVacancy enterVacancyNameField(String value){
        ElementActions.sendData(driver,this.vacancyNameField,value);
        return this;
    }
    public AddVacancy enterJobTitleListField(String value) throws InterruptedException {
        ElementActions.selectValueFromDropDownList(driver,this.jobTitleListField,this.optionValueJobTitle, value);
        return this;
    }
    public AddVacancy enterHiringManager(String valueSearch) throws InterruptedException {
        ElementActions.selectValueFromAutosuggestionField(driver,this.hiringManagerFiledElement,this.hiringManagerValueOption,valueSearch);
        return this;
    }
    public AddVacancy clickSaveButton(){
        ElementActions.clickElement(driver,this.saveButton);
        return this;
    }
}
