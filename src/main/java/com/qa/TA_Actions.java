package com.qa;

import org.openqa.selenium.WebElement;

public class TA_Actions {



    public void elementToBeClick(WebElement element) {
        element.click();
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