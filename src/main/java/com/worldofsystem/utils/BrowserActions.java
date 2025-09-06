package com.worldofsystem.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrowserActions {
    private BrowserActions(){

    };
    public static void navigateToURL(WebDriver driver , String url){
        driver.get(url);
        LogsUtil.info("Navigated to URL" , url);
    }

    // Get Current Url
    public static String getCurrentUrl(WebDriver driver ){
      LogsUtil.info("Current URL" , driver.getCurrentUrl());
      return driver.getCurrentUrl();
    };

    public static String getText(WebDriver driver , By element){
        //code
        Waits.waitForElementVisible(driver , element);
        return driver.findElement(element).getText();
    }
    public static void closeBrowser(WebDriver driver){
        //code
        LogsUtil.info("Closing the Browser");
        driver.quit();
    }
}
