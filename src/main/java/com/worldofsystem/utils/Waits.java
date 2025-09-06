package com.worldofsystem.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {
    // present - visible - clickable
    private Waits(){

    };

    // wait for element to be present
    public static WebElement waitForElementPresent(WebDriver driver , By locator){
        //code
        LogsUtil.info("Waiting for element To Be Present" , locator.toString());
        return new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(driver1 -> driver1.findElement(locator));
    };

    // wait for element to be visible
    public static WebElement waitForElementVisible(WebDriver driver , By locator){
        //code
        LogsUtil.info("Waiting for element To Be Visible" , locator.toString());
        return new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(driver1 -> {

                    WebElement element = waitForElementPresent(driver, locator);
                    return element.isDisplayed() ? element: null;

                });
    }

    // wait for element to be clickable
    public static WebElement waitForElementClickable(WebDriver driver , By locator){
        //code
        LogsUtil.info("Waiting for element To Be Clickable" , locator.toString());
        return new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(driver1 -> {

                    WebElement element = waitForElementVisible(driver, locator);
                    return element.isEnabled() ? element: null;

                });
    }
    public static WebElement waitForElementClickable2(WebDriver driver, By locator) {
        LogsUtil.info("Waiting for element to be clickable: " + locator);
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            // Use the standard condition for clickability
            return wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (TimeoutException e) {
            LogsUtil.error("Timeout: Element was not clickable. Locator: " + locator);
            throw new TimeoutException("Timeout: Element was not clickable: " + locator, e);
        }
    }
}
