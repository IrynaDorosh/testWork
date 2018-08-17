package com.plusSmilebox.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DashboardPage {

    private WebDriver driver;
    public DashboardPage(WebDriver driver){
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
    public WebElement subtitleNameAfterFiltering;

    @FindBy (id="bar-pf-avatar")
    public WebElement iconProfileDropdown;

    @FindBy (id="signout")
    public WebElement buttonLogOut;


    /**
     * METHODS
     */


    public void logOutViaProvileDropdownOnDashboarPage(){
      iconProfileDropdown.click();
      buttonLogOut.click();
      Assert.assertNotEquals( driver.getTitle(), "Smilebox Dashboard");
    }

    public void selectChristmasTemplatesFromDropdown(){
        dropdownTemplates.click();
        Assert.assertTrue(listOfTemplates.isEnabled());
        ChristmasTemplates.click();
    }
}
