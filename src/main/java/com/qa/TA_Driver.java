package com.qa;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TA_Driver {

    public String title;
    public WebDriver driver;

    public WebDriver driverInit(String browser){

        if(browser=="chrome"){
             driver = new ChromeDriver();
        }
        if(browser=="firefox"){
            driver = new FirefoxDriver();
        }
        if(browser=="edge"){
            driver = new EdgeDriver();
        }

        return  driver;

    }

    public void driverQuit(){
        if (driver != null) {
            driver.quit();
        }
    }
    public void goToURL(String url){
        driver.get(url);
    }
    public void driverClose(){
        if (driver != null) {
            driver.close();
        }
    }
}
