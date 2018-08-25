package com.plusSmilebox.pages;

import com.plusSmilebox.util.BasePage;
import com.plusSmilebox.util.Helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DashboardPage extends BasePage {

    private WebDriver driver;

    public DashboardPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath="//img[@src='/img/smilebox-logo-h-white.png']")
    public WebElement logoSmilebox;

    @FindBy(xpath="//span[text() = 'TEMPLATES']")
    public WebElement dropdownTemplatesFromDropdownInBarHeader;

    @FindBy(xpath="//a[@href='/MyCreations' and text() = 'MY CREATIONS']")
    public WebElement tabMyCreationsInBarheader;

    @FindBy(xpath="//div[@class = 'designs-list']")
    public WebElement listOfTemplatesFromDropdownInBarHeader;

    @FindBy(xpath="//p[@class='bar-menu-subcategory-name' and text() = 'Christmas']")
    public WebElement templateChristmasFromDropdownInBarHeader;

    @FindBy(xpath="//p[@class='bar-menu-subcategory-name' and text() = 'Other Business']")
    public WebElement templateOtherBusinessFromDropdownInBarHeader;

    @FindBy(xpath="//p[@class='sub-title']/span[@class='sub-name']")
    public WebElement subtitleNameAfterFiltering;

    @FindBy (xpath = "//div[@id='bar-pf-avatar']")
    public WebElement iconProfileDropdown;
    @FindBy (id="signout")
    public WebElement buttonLogOut;

    @FindBy (xpath = "//div[@class='all-categories-container']")
    public WebElement dropDownAllCategoriesInFilters;

    @FindBy(xpath="//div[@class=\"sb-vbar-float-wrapper\"]")
    public WebElement listDropDownOfAllCategories;

    @FindBy (xpath="//li[@class='filter-subcategory']")
    public WebElement subcategoryFromFilters;

    @FindBy (xpath="//div[@class='btn-close' and text()='Halloween']")
    public WebElement buttonCloseFromMarketingWrapper;

     @FindBy (xpath = "//div[@class='img-container' and parent::div//p[@title='Join Us Floral']]")
     public WebElement templateExampleJoimUsFloral;


    @FindBy (xpath = "//button[@id='btn-personalize']")
    public WebElement buttonPersonalise;




    /**
     * METHODS
     */


    public void logOutViaProvileDropdownOnDashboarPage(){
        waitForElementIsVisible(iconProfileDropdown, 10).click();
      buttonLogOut.click();
    }

    public void clickOnTemplatesDropdownInBarHeader() {  //this method is separated to 2   selectChristmasTemplatesFromDropdownInBarHeader :click and select
        waitForElementIsVisible(dropdownTemplatesFromDropdownInBarHeader, 10).click();
    }
    public void selectChristmasTemplatesFromDropdown(){
        waitForElementIsVisible(templateChristmasFromDropdownInBarHeader, 10);
        Assert.assertTrue(listOfTemplatesFromDropdownInBarHeader.isEnabled());
        templateChristmasFromDropdownInBarHeader.click();
    }
    public void selectOtherBusinessTemplatesFromDropdown() {
        waitForElementIsVisible(listOfTemplatesFromDropdownInBarHeader, 10);
        templateOtherBusinessFromDropdownInBarHeader.click();
    }



    public void selectACategoryFromDropDownInFilters() throws InterruptedException {
        dropDownAllCategoriesInFilters.click();
        Assert.assertTrue(listDropDownOfAllCategories.isEnabled());
        subcategoryFromFilters.click();

    }



}
