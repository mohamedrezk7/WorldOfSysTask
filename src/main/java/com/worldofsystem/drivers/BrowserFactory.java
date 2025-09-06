package com.worldofsystem.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
    public static WebDriver getBrowser(String browserName){
      switch (browserName.toLowerCase()){
          case "chrome":
              ChromeOptions options = new ChromeOptions();
              options.addArguments("--start-maximized");
              options.addArguments("--disable-extensions");
              options.addArguments("--disable-notifications");
              options.addArguments("--remote-allow-origins=*");
//              options.addArguments("--incognito");

              // Disable password manager argument
              options.addArguments("--disable-password-generation");
              options.addArguments("--disable-save-password-bubble");
              options.addArguments("--disable-password-manager");
              options.addArguments("--disable-features=VizDisplayCompositor");
              return new ChromeDriver(options);

          case "firefox":
              return new FirefoxDriver();
          default:
              EdgeOptions edgeOptions = new EdgeOptions();
              edgeOptions.addArguments("--start-maximized");
              edgeOptions.addArguments("--disable-extensions");
              edgeOptions.addArguments("--disable-notifications");
              edgeOptions.addArguments("--remote-allow-origins=*");
              return new EdgeDriver(edgeOptions);
      }
    }
}
