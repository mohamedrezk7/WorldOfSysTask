package com.worldofsystem.drivers;

import com.worldofsystem.utils.LogsUtil;
import org.openqa.selenium.WebDriver;

import static org.testng.FileAssert.fail;

public class DriverManager {
    //code
    private static final ThreadLocal<WebDriver> driverThreadLocal =new ThreadLocal<>();
    private DriverManager(){
        super();
    }
    public static WebDriver createInstance(String browserName){
        //code
        WebDriver driver = BrowserFactory.getBrowser(browserName);
        LogsUtil.info("Browser Created" , browserName);
        setDriver(driver);
        return getDriver();
    }

    public static void setDriver(WebDriver driver){
        driverThreadLocal.set(driver);
    }

    public static WebDriver getDriver(){
        if(driverThreadLocal.get()==null){
            //code
            LogsUtil.error("Driver Is Null");
            fail("Driver Is Null");
        }
        return driverThreadLocal.get();
    }

}
