package com.plusSmilebox.util;

import com.plusSmilebox.pages.DashboardPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

   protected WebDriver driver;
    protected WebDriverWait wait;
    protected WebDriverWait wait10;
    Logger logger = Logger.getLogger(BasePage.class);



    public BasePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
        wait10 = new WebDriverWait(driver,10);
    }






    protected WebElement waitForElementIsVisible(WebElement element, int timeToWait) { // the same in BaseTest
        wait = new WebDriverWait(driver, timeToWait);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            logger.error("WebElement " + element +" is not visible");
        }
        return element;
    }

    }




