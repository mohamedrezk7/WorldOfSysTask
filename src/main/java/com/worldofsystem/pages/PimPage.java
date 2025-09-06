package com.worldofsystem.pages;

import com.worldofsystem.utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PimPage {

    // variables
    private final WebDriver driver;

    // locators
    private final By addEmployeeButton = By.xpath("//button[normalize-space()='Add']");
    private final By employeeIdField = By.xpath("//label[text()='Employee Id']/following::input[1]");
    private final By searchButton = By.xpath("//button[normalize-space()='Search']");
    private final By firstResult = By.xpath("//div[@class='oxd-table-body']/div[@class='oxd-table-card'][1]/div[@role='row']");

    // constructor
    public PimPage (WebDriver driver){
        this.driver=driver;
    }

    // actions
    public PimPage clickAddEmployeeButton(){
        ElementActions.clickElement(driver,this.addEmployeeButton);
        return this;
    }
    public  PimPage enterEmployeeId1(String id) throws InterruptedException {
        ElementActions.sendData(driver,this.employeeIdField,id);
        Thread.sleep(2000);
        return this;
    }
    public PimPage clickSearchButton(){
        ElementActions.clickElement(driver,this.searchButton);
        return this;
    }
    public PimPage clickFirstResult(){
        ElementActions.clickElement(driver,this.firstResult);
        return this;
    }
}
