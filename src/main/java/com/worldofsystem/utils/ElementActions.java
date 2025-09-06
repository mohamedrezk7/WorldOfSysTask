package com.worldofsystem.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ElementActions {
    private ElementActions(){

    };
    // variables
    // send Keys

    public static void sendData (WebDriver driver , By locator , String data){
        //code
        Waits.waitForElementVisible(driver,locator);
        Scrolling.scrollToElement(driver , locator);
        driver.findElement(locator).sendKeys(data);
        LogsUtil.info("Data Sent" , data , "Im in the field", locator.toString());
    }

    //click
    public static void clickElement (WebDriver driver , By locator){
        //code
        Waits.waitForElementClickable(driver,locator);
        Waits.waitForElementClickable2(driver,locator);
        driver.findElement(locator).click();
        LogsUtil.info("Click On the Element " ,  locator.toString());
    }
    public static void clickElementWithScroll (WebDriver driver , By locator){
        //code
        Waits.waitForElementClickable(driver,locator);
        Waits.waitForElementClickable2(driver,locator);
        Scrolling.scrollToElement(driver , locator);
        driver.findElement(locator).click();
        LogsUtil.info("Click On the Element " ,  locator.toString());
    }
    public static void clearElement (WebDriver driver , By locator){
        //code
        Waits.waitForElementClickable(driver,locator);
        Scrolling.scrollToElement(driver , locator);
        driver.findElement(locator).sendKeys(Keys.CONTROL + "a");
        driver.findElement(locator).sendKeys(Keys.DELETE);
        LogsUtil.info("Click On the Element " ,  locator.toString());
    }

    public static String getText (WebDriver driver , By locator){
        //code
        Waits.waitForElementClickable(driver,locator);
        Scrolling.scrollToElement(driver , locator);
       return driver.findElement(locator).getText();
    }
    public static void  selectElementFromDropDownList(WebDriver driver , By locatorParent , By LocatorValue, String Value ){
        Waits.waitForElementClickable(driver,locatorParent);
        Scrolling.scrollToElement(driver , locatorParent);
        WebElement selectElement = driver.findElement(locatorParent);
        selectElement.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List <WebElement> options  = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(LocatorValue));
        Scrolling.scrollToElement(driver,LocatorValue);
        for (WebElement option : options) {
            if (option.getText().trim().equals(Value)) {
                option.click();
                break;
            }
        }
    }

    public static void  autoSuggestSelect(WebDriver driver , By locatorParent , By LocatorValue, String Value1 , String ValueOption ){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement hiringManagerInput = wait.until(ExpectedConditions.elementToBeClickable(locatorParent));
        hiringManagerInput.sendKeys(Value1);
//        Scrolling.scrollToElement(driver , locatorParent);

        List<WebElement> suggestions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(LocatorValue));
        Waits.waitForElementVisible(driver, LocatorValue);
        Waits.waitForElementClickable(driver, LocatorValue);
        Scrolling.scrollToElement(driver,LocatorValue);

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN)  // first suggestion
//                .sendKeys(Keys.ARROW_DOWN)  // second suggestion
                .sendKeys(Keys.ENTER)       // select
                .build().perform();

//        for (WebElement suggestion : suggestions) {
//            if (suggestion.getText().trim().equalsIgnoreCase(ValueOption)) {
//                Scrolling.scrollToElement(driver,LocatorValue);
//                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", suggestion);
////                suggestion.click();
//                break;
//            }
//        }
    }

    public static void waitElement (WebDriver driver , By locator){
        //code
        Waits.waitForElementClickable(driver,locator);
        Scrolling.scrollToElement(driver , locator);

        LogsUtil.info("Wait  the Element " ,  locator.toString());
    }

    public static void selectValueFromAutosuggestionField (WebDriver driver,By inputField ,By selectedOption , String searchText) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        sendData(driver,inputField,searchText);
        Thread.sleep(2000);
        List<WebElement> options = wait.until(ExpectedConditions
                .visibilityOfAllElementsLocatedBy(selectedOption));
        Thread.sleep(2000);
        options.get(0).click();

//        for (WebElement option : options) {
//            if (option.getText().equalsIgnoreCase(targetManager)) {
//                option.click();
//                break;
//            }
//
//        }
    }
    public static void selectValueFromDropDownList (WebDriver driver, By inputField ,By selectedOption ,String searchText) throws InterruptedException {
        Waits.waitForElementClickable(driver,inputField);
        driver.findElement(inputField).click();
        Thread.sleep(2000);
        List<WebElement> options = driver.findElements(selectedOption);
        Thread.sleep(2000);
        for (WebElement opt : options) {
            if (opt.getText().equals(searchText)) {
                opt.click();
                break;
            }
        }
    }
}
