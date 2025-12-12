package com.qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TA_Driver {

    // Keep it simple for sequential execution
    public WebDriver driver;

    public WebDriver driverInit(String browser) {

        // FIX: Use equalsIgnoreCase() for safe string comparison
        if ("chrome".equalsIgnoreCase(browser)) {
            driver = new ChromeDriver();
        } else if ("firefox".equalsIgnoreCase(browser)) { // Use else if for better logic
            driver = new FirefoxDriver();
        } else if ("edge".equalsIgnoreCase(browser)) {
            driver = new EdgeDriver();
        } else {
            // Good practice: Throw an error if browser is unknown
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        return driver;
    }

    // Methods now access the instance variable 'this.driver'
    public void driverQuit() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }
    public void goToURL(String url) {
        // We assume driver is initialized before this is called
        this.driver.get(url);
    }
    public void driverClose() {
        if (this.driver != null) {
            this.driver.close();
        }
    }
    // You may want to add a getter if other classes need the driver:
    public WebDriver getDriver() {
        return this.driver;
    }
}