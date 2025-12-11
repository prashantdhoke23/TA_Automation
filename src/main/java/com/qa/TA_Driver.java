package com.qa;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TA_Driver {

    public String title;
    public WebDriver driver;

    public void driverInit(){
        driver = new ChromeDriver();
    }

    public void driverQuit(){
        if (driver != null) {
            driver.quit();
        }
    }

    public void driverClose(){
        if (driver != null) {
            driver.close();
        }
    }
}
