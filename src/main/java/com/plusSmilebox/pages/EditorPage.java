package com.plusSmilebox.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditorPage {

    private WebDriver driver;
    private WebDriverWait wait8;
    private WebDriverWait wait20;


    public EditorPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
        wait8 = new WebDriverWait(driver,8);
        wait20 = new WebDriverWait(driver,20);
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
        wait20.withMessage("Text block in Edior page is not visible")
                .until(ExpectedConditions.visibilityOf(this.textBlock1InFloralTemplate));
        textBlock1InFloralTemplate.clear();
        textBlock1InFloralTemplate.sendKeys("FOR ALL MY FRIENDS");
        textBlock2InFloralTemplate.clear();
        textBlock2InFloralTemplate.sendKeys("You are invited to the best party ever!");
        textBlock3InFloralTemplate.clear();
        textBlock3InFloralTemplate.sendKeys("WAIT FOR YOU THIS WEEK-END!");
    }

    public void savingModifiedTemplate() {
        buttonSave1OnEditor.click();
        buttonSave2OnEditor.click();
    }
}
