package classes.com.plusSmilebox.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FBloginPage {
    private WebDriver driver;

    public FBloginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='email_container']/input")
    public WebElement inputFieldEmailOrPhone;

    @FindBy(xpath = "//input[@id='pass']")
    public WebElement inputFieldPassword;

    @FindBy(xpath = "//button[@id='loginbutton']")
    public WebElement buttonLogIn;




    public void logInWithFBcredentials() {
        this.inputFieldEmailOrPhone.sendKeys(new CharSequence[]{"i-dorosh@mail.ru"});
        this.inputFieldPassword.sendKeys(new CharSequence[]{"qwe123rty"});
        this.buttonLogIn.click();
    }
}
