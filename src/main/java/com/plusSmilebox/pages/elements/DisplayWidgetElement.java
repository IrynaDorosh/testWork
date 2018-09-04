package com.plusSmilebox.pages.elements;

import com.plusSmilebox.pages.DashboardPage;
import com.plusSmilebox.util.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class DisplayWidgetElement extends BasePage {
    public DisplayWidgetElement(WebDriver driver) {
        super(driver);
    }

    protected DashboardPage dashboardPage = new DashboardPage(driver);

    @FindBy(xpath="//label [ contains (text(),'Slideshow') ] //child::span[@class='checkmark']")
    public WebElement tickDesignsFilter_Slideshow;
    @FindBy(xpath="//label [ contains (text(),'Invitation') ] //child::span[@class='checkmark']")
    public WebElement tickDesignsFilter_Invitation;
    @FindBy(xpath="//label [ contains (text(),'Greeting') ] //child::span[@class='checkmark']")
    public WebElement tickDesignsFilter_Greeting;
    @FindBy(xpath="//label [ contains (text(),'Flyer') ] //child::span[@class='checkmark']")
    public WebElement tickDesignsFilter_Flyer;


//    @FindBy(xpath="")
//    public WebElement ;
//    @FindBy(xpath="")
//    public WebElement ;
//    @FindBy(xpath="")
//    public WebElement ;


    /**
     * METHODS
     */

    public List<WebElement> listDesignsAfterUntickAll_ExceptSlideshow() throws InterruptedException {
        waitForElementIsVisible(tickDesignsFilter_Slideshow, 10);
        tickDesignsFilter_Invitation.click();
        tickDesignsFilter_Greeting.click();
        tickDesignsFilter_Flyer.click();
        List<WebElement> listAfterFilter = dashboardPage.listTemplatesDesignsInBody1();
        return listAfterFilter;
    }

    public List<WebElement> listDesignsAfterUntickAll_ExceptInvitation() throws InterruptedException {
        waitForElementIsVisible(tickDesignsFilter_Invitation, 10);
        tickDesignsFilter_Slideshow.click();
        tickDesignsFilter_Greeting.click();
        tickDesignsFilter_Flyer.click();
        List<WebElement> listAfterFilter = dashboardPage.listTemplatesDesignsInBody1();
        return listAfterFilter;
    }

    public List<WebElement> listDesignsAfterUntickAll_ExceptGreetings() throws InterruptedException {
        waitForElementIsVisible(tickDesignsFilter_Greeting, 10);
        tickDesignsFilter_Slideshow.click();
        tickDesignsFilter_Invitation.click();
        tickDesignsFilter_Flyer.click();
        List<WebElement> listAfterFilter = dashboardPage.listTemplatesDesignsInBody1();
        return listAfterFilter;
    }

    public List<WebElement> listDesignsAfterUntickAll_ExceptFlyer() throws InterruptedException {
        waitForElementIsVisible(tickDesignsFilter_Flyer, 10);
        tickDesignsFilter_Slideshow.click();
        tickDesignsFilter_Invitation.click();
        tickDesignsFilter_Greeting.click();
        List<WebElement> listAfterFilter = dashboardPage.listTemplatesDesignsInBody1();
        return listAfterFilter;
    }
     //amount of format vary from 0 to -3 as Designs are displayed in marketing-box in header
     // and they are not affected by filter
    public boolean comparingAmountOfDesignsAndFormats (List<WebElement> listDesigns, List<WebElement>  listFormats){
        boolean res = false;
        if(listDesigns.size()==listFormats.size()
                || (listDesigns.size()-1) == listFormats.size()
                || (listDesigns.size()-2) == listFormats.size()
                || (listDesigns.size()-3) == listFormats.size()){
            res = true;
        }
        return res;
    }









}
