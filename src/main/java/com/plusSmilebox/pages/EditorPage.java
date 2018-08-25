package com.plusSmilebox.pages;

import com.plusSmilebox.util.BasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditorPage extends BasePage {


    public EditorPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath="//div[@id='inTxt1']/div")
    public WebElement textBlock1InFloralTemplate;

    @FindBy(xpath="//div[@id='inTxt2']/div")
    public WebElement textBlock2InFloralTemplate;

    @FindBy(xpath="//div[@id='inTxt3']/div")
    public WebElement textBlock3InFloralTemplate;

    @FindBy(xpath="//button[@class = 'btn' and @id='btnSaveCreation']")
    public WebElement buttonSave1OnEditor;

    @FindBy(xpath="//button[@id='btnSaveCreation' and @class = 'popup-rect-btn']")
    public WebElement buttonSave2OnEditor;

    @FindBy(xpath="//button[@id='btnPreview']")
    public WebElement buttonPreviewAndShare;

    /**
     * METHODS
     */

    public void fillInFieldsInFloralTemplate() {
        waitForElementIsVisible(textBlock1InFloralTemplate, 30);
        textBlock1InFloralTemplate.clear();
        textBlock1InFloralTemplate.sendKeys("FOR ALL MY FRIENDS");
        textBlock2InFloralTemplate.clear();
        textBlock2InFloralTemplate.sendKeys("You are invited to the best party ever!");
        textBlock3InFloralTemplate.clear();
        textBlock3InFloralTemplate.sendKeys("WAIT FOR YOU THIS SUNDAY AT 15.00!");
    }

    public void savingModifiedTemplate() {
        buttonSave1OnEditor.click();
        buttonSave2OnEditor.click();
    }
}
