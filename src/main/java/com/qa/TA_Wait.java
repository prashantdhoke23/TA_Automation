package com.qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.TimeoutException; // Specific exception for better handling
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TA_Wait {

    // Removed the WebDriverWait field, as it's better to initialize it inside the method.

    public void waitInbuilt(WebDriver driver, String condition, WebElement element) {

        // Good Practice: Initialize WebDriverWait locally for each wait call
        // Using 10 seconds as a standard robust default timeout
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // FIX: Use .equalsIgnoreCase() for reliable string comparison
            if ("visible".equalsIgnoreCase(condition)) {
                wait.until(ExpectedConditions.visibilityOf(element));
            } else if ("clickable".equalsIgnoreCase(condition)) { // Use else if
                wait.until(ExpectedConditions.elementToBeClickable(element));
            } else if ("select".equalsIgnoreCase(condition)) { // Use else if
                wait.until(ExpectedConditions.elementToBeSelected(element));
            }
            else {
                // Throw an IllegalArgumentException if the condition name is invalid
                throw new IllegalArgumentException("Invalid wait condition specified: " + condition);
            }
        } catch (TimeoutException e) {
            // Catch the specific Selenium TimeoutException and re-throw with context
            throw new RuntimeException("Timeout error waiting for element with condition: " + condition, e);
        }
        // No need for a final generic catch block, let other exceptions (like StaleElementReferenceException) bubble up.
    }
}