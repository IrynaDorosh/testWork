package com.plusSmilebox.pages;

import com.plusSmilebox.util.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class DashboardPage extends BasePage {


    public DashboardPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath="//img[@src='/img/smilebox-logo-h-white.png']")
    public WebElement logoSmilebox;

    @FindBy(xpath="//span[text() = 'TEMPLATES']")
    public WebElement dropdownTemplatesInBarHeader;

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

    @FindBy (xpath = "//div[@data-status='Created']//ancestor::div[@class='mc-box']//a[@class='mc-action mc-action-share-option mc-fb-icon has-tooltip']")
    public WebElement buttonShareFB_readyToShareTemplate;

    @FindBy (xpath="//div[@data-status='Created']//ancestor::div[@class='mc-box']//child::button[@class='mc-action-share']")
    public WebElement buttonShare_readyToShareTemplate;

    @FindBy (xpath="//div[@class='img-container' and parent::div//p[@title='Spooktacular Celebration']]")
    public WebElement templateFlyerFreeSpooktacular;

    public final String xptemplatesDesignsInBody = "//div[@class='design-container design-pop']";
    @FindBy (xpath = xptemplatesDesignsInBody )
    public WebElement templatesDesignsInBody;

    public final String xpTemplatesFiltersInHeader = "//li[@class='bar-menu-subcategory-name-wrap']";
    @FindBy (xpath = xpTemplatesFiltersInHeader)
    public WebElement templatesFiltersInHeader;

    public final String xpFormatBoxSlideshow= "//span[@class='format-box' and contains(text(), 'Slideshow')]";
    public final String xpFormatBoxInvitation= "//span[@class='format-box' and contains(text(), 'Invitation')]";
    public final String xpFormatBoxGreeting= "//span[@class='format-box' and contains(text(), 'Greeting')]";
    public final String xpFormatBoxFlyer= "//span[@class='format-box' and contains(text(), 'Flyer')]";




    /**
     * METHODS
     */


    public void logOutViaProvileDropdownOnDashboarPage(){
        waitForElementIsVisible(iconProfileDropdown, 10).click();
      buttonLogOut.click();
    }


    public void selectACategoryFromDropDownInFilters() throws InterruptedException {
        dropDownAllCategoriesInFilters.click();
        Assert.assertTrue(listDropDownOfAllCategories.isEnabled());
        subcategoryFromFilters.click();
    }


    public int amountTemplatesDesignsInBody1() throws InterruptedException {
        int x;
        int res = 0;
        List<WebElement> listBigTemplates;
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        do {
            x = res;
            jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            listBigTemplates = driver.findElements(By.xpath(xptemplatesDesignsInBody));
            res = listBigTemplates.size();
            Thread.sleep(3000);
        } while (x < res);
        return res;
    }

    public List<WebElement> listTemplatesDesignsInBody1() throws InterruptedException {
        int x;
        int res = 0;
        List<WebElement> listBigTemplates;
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        do {
            x = res;
            jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            listBigTemplates = driver.findElements(By.xpath(xptemplatesDesignsInBody));
            res = listBigTemplates.size();
            Thread.sleep(3000);
        } while (x < res);
        return listBigTemplates;
    }









//    public List<WebElement> listTemplatesFiltersInHeader(){
//        waitForElementIsVisible(dropdownTemplatesInBarHeader, 10).click();
//        List<WebElement> listTemplatesFilters = driver.findElements(By.xpath(xpTemplatesFiltersInHeader));
//        Assert.assertTrue(listTemplatesFilters.size()>2);
//        return listTemplatesFilters;
//    }





}
