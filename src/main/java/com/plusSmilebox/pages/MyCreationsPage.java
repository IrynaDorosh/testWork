package com.plusSmilebox.pages;

import com.plusSmilebox.util.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyCreationsPage extends BasePage {

    public MyCreationsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//div[@class='mc-list-container']/p")
     public WebElement containerForCreations;

    @FindBy(xpath="//div[@id='creations-list']")
    public WebElement creationList;
}
