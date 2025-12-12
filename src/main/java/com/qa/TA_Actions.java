package com.qa;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TA_Actions {

    private WebDriver driver;

    // Constructor to receive the WebDriver
    public TA_Actions(WebDriver driver) {
        this.driver = driver;
    }

    public void elementToBeClick(WebElement element) {
        // --- 1. Attempt Standard Click (Preferred) ---
        try {
            // Before clicking, ensure it is scrolled into view (best practice for reliability)
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

            element.click();
            System.out.println("INFO: Successfully clicked element using standard Selenium click.");
            return; // Exit if successful

        } catch (ElementClickInterceptedException e) {

            // --- 2. Fallback to JavaScript Click ---
            System.err.println("WARNING: ElementClickInterceptedException encountered. Falling back to JavaScript click.");

            try {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", element);
                System.out.println("INFO: Successfully clicked element using JavaScript click.");

            } catch (Exception jsException) {
                // If the JS click also fails, re-throw the original exception for the test to fail
                System.err.println("ERROR: JavaScript click also failed. Test step failed.");
                throw e;
            }
        } catch (Exception e) {
            // Handle other potential click exceptions (like StaleElementReferenceException)
            throw e;
        }
    }

    public void sendKeys(WebElement element, String values) {
        element.sendKeys(values);
    }

    public String getDomAttr(WebElement element, String name) {
        return element.getDomAttribute(name);
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public boolean isSelected(WebElement element) {
        return element.isSelected();
    }

    public boolean isEnable(WebElement element) {
        return element.isEnabled();
    }

    public String getDomProp(WebElement element, String name) {
        return element.getDomProperty(name);
    }

    // Changed return type to Dimension if you intend to use the returned size
    public void getSize(WebElement element) {
        element.getSize();
    }

    public void submitted(WebElement element) {
        element.submit();
    }
}