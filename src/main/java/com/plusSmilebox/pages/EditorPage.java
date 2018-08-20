package com.plusSmilebox.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditorPage {

    private WebDriver driver;
    private WebDriverWait wait8;


    public EditorPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
        wait8 = new WebDriverWait(driver,8);
    }

    @FindBy(xpath="//div[@id='inTxt1']/div")
    public WebElement textBlock1InFloralTemplate;

    @FindBy(xpath="//div[@id='inTxt2']/div")
    public WebElement textBlock2InFloralTemplate;

    @FindBy(xpath="//button[@class = 'btn' and @id='btnSaveCreation']")
    public WebElement buttonSave1OnEditor;

    @FindBy(xpath="//button[@id='btnSaveCreation' and @class = 'popup-rect-btn']")
    public WebElement buttonSave2OnEditor;

    @FindBy(xpath="//button[@id='btnPreview']")
    public WebElement buttonPreviewAndShare;








}
