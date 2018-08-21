package com.plusSmilebox.util;

import com.plusSmilebox.pages.DashboardPage;
import com.plusSmilebox.pages.FBloginPage;
import com.plusSmilebox.pages.LogInWithEmailPage;
import com.plusSmilebox.pages.StartPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;


public class Helpers {

    private static  WebDriver driver;
    private static WebDriverWait wait8;

    public Helpers(WebDriver driver) {
        this.driver = driver;
        wait8 = new WebDriverWait(driver, 8);
           }


    public static boolean isElementPresent(WebElement webElement) {
        try {
            webElement.isEnabled();
            return true;
        } catch (
                NoSuchElementException e) {
            return false;
        }
    }

    public static void waitForElementToBePresent (WebElement webElement, String errorMessage){
        try {
            wait8.until(ExpectedConditions.visibilityOf(webElement));
        } catch (TimeoutException e){
            System.out.println(errorMessage);
        }
    }
    public static void waitForPageTitleToDIsplayed (String title, String errorMessage ) {
        try {
            wait8.until(ExpectedConditions.titleContains(title));
        } catch (TimeoutException e){
            System.out.println(errorMessage);
        }
    }





}
