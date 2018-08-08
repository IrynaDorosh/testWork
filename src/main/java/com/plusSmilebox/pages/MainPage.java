package com.plusSmilebox.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MainPage {

    private WebDriver driver;
    public MainPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//div[@class='template-container-ie']")
    public WebElement logoSmilebox;

    @FindBy(xpath="//span[text() = 'TEMPLATES']")
    public WebElement dropdownTemplates;

    @FindBy(xpath="//div[@class = 'designs-list']")
    public WebElement listOfTemplates;

    @FindBy(xpath="//p[@class='bar-menu-subcategory-name' and text() = 'Christmas']")
    public WebElement ChristmasTemplates;

    @FindBy(xpath="//p[@class='sub-title']/span[@class='sub-name']")
    public WebElement SubtitleNameAfterFiltering;

    /**
     * METHODS
     */

    public void selectChristmasTemplatesFromDropdown(){
        dropdownTemplates.click();
        Assert.assertTrue(listOfTemplates.isEnabled());
        ChristmasTemplates.click();
    }
}
