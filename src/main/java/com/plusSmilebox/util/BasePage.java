package com.plusSmilebox.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private WebDriver driver;
    private WebDriverWait wait10;


    public BasePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
        wait10 = new WebDriverWait(driver,10);
    }



}
