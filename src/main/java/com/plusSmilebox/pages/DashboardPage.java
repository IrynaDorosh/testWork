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
    public WebElement dropdownTemplatesFromDropdownInBarHeader;

    @FindBy(xpath="//div[@class = 'designs-list']")
    public WebElement listOfTemplatesFromDropdownInBarHeader;

    @FindBy(xpath="//p[@class='bar-menu-subcategory-name' and text() = 'Christmas']")
    public WebElement ChristmasTemplatesFromDropdownInBarHeader;

    @FindBy(xpath="//p[@class='sub-title']/span[@class='sub-name']")
    public WebElement subtitleNameAfterFiltering;

    @FindBy (id="bar-pf-avatar")
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







    /**
     * METHODS
     */


    public void logOutViaProvileDropdownOnDashboarPage(){
      iconProfileDropdown.click();
      buttonLogOut.click();
      Assert.assertNotEquals( driver.getTitle(), "Smilebox Dashboard");
    }

    public void selectChristmasTemplatesFromDropdownInBarHeader(){
        dropdownTemplatesFromDropdownInBarHeader.click();
        Assert.assertTrue(listOfTemplatesFromDropdownInBarHeader.isEnabled());
        ChristmasTemplatesFromDropdownInBarHeader.click();
    }

    public void selectACategoryFromDropDownInFilters() throws InterruptedException {
        dropDownAllCategoriesInFilters.click();
        Assert.assertTrue(listDropDownOfAllCategories.isEnabled());
        subcategoryFromFilters.click();

    }
}
