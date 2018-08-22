package com.plusSmilebox.pages;

import com.plusSmilebox.util.Helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DashboardPage {

    private WebDriver driver;
    private WebDriverWait wait8;


    public DashboardPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
        wait8 = new WebDriverWait(driver,8);
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
        wait8.withMessage("iconProfileDropdown is not present")
                .until(ExpectedConditions.visibilityOf(iconProfileDropdown));
      iconProfileDropdown.click();
      buttonLogOut.click();
      Assert.assertNotEquals(driver.getTitle(), "Smilebox Dashboard");  //TODO wait for title to be absent
    }

    public void clickOnTemplatesDropdownInBarHeader() {  //this method is separated to 2   selectChristmasTemplatesFromDropdownInBarHeader :click and select
        wait8.until(ExpectedConditions.visibilityOf(dropdownTemplatesFromDropdownInBarHeader));
        dropdownTemplatesFromDropdownInBarHeader.click();
    }
    public void selectChristmasTemplatesFromDropdown(){
        wait8.until(ExpectedConditions.visibilityOf(listOfTemplatesFromDropdownInBarHeader));
        Assert.assertTrue(listOfTemplatesFromDropdownInBarHeader.isEnabled());
        templateChristmasFromDropdownInBarHeader.click();
    }
    public void selectOtherBusinessTemplatesFromDropdown() {
        wait8.until(ExpectedConditions.visibilityOf(listOfTemplatesFromDropdownInBarHeader));
        templateOtherBusinessFromDropdownInBarHeader.click();
    }



    public void selectACategoryFromDropDownInFilters() throws InterruptedException {
        dropDownAllCategoriesInFilters.click();
        Assert.assertTrue(listDropDownOfAllCategories.isEnabled());
        subcategoryFromFilters.click();

    }



}
