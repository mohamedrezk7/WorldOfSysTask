package com.worldofsystem.pages;

import com.worldofsystem.utils.ElementActions;
import com.worldofsystem.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class AddSystemUser {
    //variables
    private final WebDriver driver;
    SoftAssert softAssert = new SoftAssert();

    // locators
    private final By UserRoleField = By.xpath("(//div[@class='oxd-select-text-input' and text()='-- Select --'])[1]");
    private final By UserRoleOption = By.xpath("//div[@role='option']");
    private final By EmployeeNameField = By.xpath("//input[@placeholder='Type for hints...']");
    private final By EmployeeNameFieldOption = By.cssSelector("div.oxd-autocomplete-dropdown > div");
    private final By StatusField = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[1]");
    private final By StatusFieldOption = By.xpath("//div[@role='option']");
    private final By UserNameField = By.xpath("//label[text()='Username']/ancestor::div[contains(@class, 'oxd-input-group')]//input");
    private final By PasswordField = By.xpath("(//input[@type='password'])[1]");
    private final By ConfirmPasswordField = By.xpath("(//input[@type='password'])[2]");
    private final By SaveButton = By.xpath("//button[normalize-space()='Save']");
    private final By LogOutButton = By.xpath("//span[@class='oxd-userdropdown-tab']");
    private final By LogOutOption = By.cssSelector("a[href=\"/web/index.php/auth/logout\"]");
    private final By WaitElementShow=By.xpath("//h5[text()='System Users']");
    private final By Dashboard=By.xpath("//h6[text()='Dashboard']");

    // constructor
    public AddSystemUser(WebDriver driver) {
        this.driver = driver;
    }

    // actions
    public AddSystemUser enterUserRoleOption(String option) throws InterruptedException {
        ElementActions.selectValueFromDropDownList(driver, this.UserRoleField, this.UserRoleOption, option);
        return this;
    }

    public AddSystemUser enterEmployeeNameField(String searchKey) throws InterruptedException {
        ElementActions.selectValueFromAutosuggestionField(driver, this.EmployeeNameField, this.EmployeeNameFieldOption, searchKey);
        return this;
    }

    public AddSystemUser enterStatusField(String option) throws InterruptedException {
        ElementActions.selectValueFromDropDownList(driver, this.StatusField, this.StatusFieldOption, option);
        return this;
    }

    public AddSystemUser enterUserName(String UserName) {
        ElementActions.sendData(driver, this.UserNameField, UserName);
        return this;
    }

    public AddSystemUser enterPasswordField(String PasswordField) {
        ElementActions.sendData(driver, this.PasswordField, PasswordField);
        return this;
    }

    public AddSystemUser enterConfirmPasswordField(String ConfirmPasswordField) {
        ElementActions.sendData(driver, this.ConfirmPasswordField, ConfirmPasswordField);
        return this;
    }

    public AddSystemUser clickSaveButton() {
        ElementActions.clickElement(driver, this.SaveButton);
        return this;
    }
    public AddSystemUser clickLogOutButton() {
        ElementActions.clickElement(driver, this.LogOutButton);
        return this;
    }
    public AddSystemUser clickLogOutOption() {
        ElementActions.clickElement(driver, this.LogOutOption);
        return this;
    }
    public AddSystemUser WaitElement() {
        ElementActions.clickElement(driver, this.WaitElementShow);
        return this;
    }

    // validation
    public void verifySuccessfulLogin(String name){
        String actualValue = ElementActions.getText(driver , this.Dashboard);
        System.out.println(actualValue);
        softAssert.assertEquals(actualValue,name);
    }
}
