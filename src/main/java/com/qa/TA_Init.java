package com.qa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TA_Init {

    public String title;
    public WebDriver driver;

    public void driverInit(){
        // Optional but recommended: automatically setup chromedriver binary
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.get("https://www.amerihealth.com/resources/for-providers/index.html");
        title = driver.getTitle();
        System.out.println(title);
    }

    public void waitInit(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.titleIs("For providers | Resources | AmeriHealth"));
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
