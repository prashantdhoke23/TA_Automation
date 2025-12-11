package com.qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TA_Wait {

    WebDriverWait wait;
    public void waitInbuilt(WebDriver driver, String condition, WebElement element){

        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            if (condition == "visible") {
                wait.until(ExpectedConditions.visibilityOf(element));
            }if (condition == "clickable") {
                wait.until(ExpectedConditions.elementToBeClickable(element));
            }
            if (condition == "select"){
                wait.until(ExpectedConditions.elementToBeSelected(element));
            }

            else {
                throw new RuntimeException("Invalid condition");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


