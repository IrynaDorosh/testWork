package testSuites;
import com.plusSmilebox.pages.*;
import com.plusSmilebox.util.Constants;
import com.plusSmilebox.util.Helpers;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import util.BaseTest;
import util.ListenerSmile;

import java.util.concurrent.TimeUnit;

@Listeners(ListenerSmile.class)
public class SmileTestSuite extends BaseTest {

    private StartPage startPage;
    private FBloginPage fBloginPage;
    private DashboardPage dashboardPage;
    private LogInWithEmailPage logInWithEmailPage;
    private WebDriverWait wait8;
    private EditorPage editorPage;

    @BeforeClass
    public void beforeClass() {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        startPage = new StartPage(driver);
        fBloginPage = new FBloginPage(driver);
        logInWithEmailPage = new LogInWithEmailPage(driver);
        dashboardPage = new DashboardPage(driver);
        wait8 = new WebDriverWait(driver, 8);
        editorPage = new EditorPage(driver);
    }

    @Test(priority = 1)
    public void testUserCanLogInViaFacebookButton() {
        driver.get(Constants.LINK_START_PAGE);
        startPage.clickButtonLoginWithFB();
            wait8.withMessage("Facebook page is not displayed")
                    .until(ExpectedConditions.titleContains("Facebook"));
        fBloginPage.logInWithFBcredentials();
        wait8.withMessage("Smilebox Dashboard page is not displayed")
                .until(ExpectedConditions.titleContains("Smilebox Dashboard"));
        Assert.assertEquals("Smilebox Dashboard", driver.getTitle());
        dashboardPage.logOutViaProvileDropdownOnDashboarPage();
    }

    @Test(priority = 2)
    public void testUserCanLogInViaLogInWithEmailButton () {
        driver.get(Constants.LINK_START_PAGE);
        startPage.clicklinkLogInWithExistedAccount();
        wait8.withMessage("Login page is not displayed")
                .until(ExpectedConditions.titleContains("Login"));
        logInWithEmailPage.logInWithEmail();
        wait8.withMessage("Smilebox Dashboard page is not displayed")
                .until(ExpectedConditions.titleContains("Smilebox Dashboard"));
        Assert.assertEquals(driver.getTitle(), "Smilebox Dashboard");
    }

    @Test(priority = 3)
    public void testUserCanSelectTemplatesFromHeaderContainer_FirstAndLast ()  {
        //super.logInWithEmailFromStartPage(); //TODO remove later
        driver.get(Constants.LINK_MAIN_PAGE);  //to refresh Dashboard
        driver.manage().window().maximize();
        wait8.withMessage("Smilebox Dashboard page is not displayed")
                .until(ExpectedConditions.titleContains("Smilebox Dashboard"));
        Assert.assertFalse(Helpers.isElementPresent(dashboardPage.subtitleNameAfterFiltering)); //to ensure that no templates are selected
        dashboardPage.clickOnTemplatesDropdownInBarHeader();
        dashboardPage.selectChristmasTemplatesFromDropdown();
        Assert.assertEquals(dashboardPage.subtitleNameAfterFiltering.getText(), "Christmas");
        dashboardPage.clickOnTemplatesDropdownInBarHeader();
        dashboardPage.selectOtherBusinessTemplatesFromDropdown();
        Assert.assertEquals(dashboardPage.subtitleNameAfterFiltering.getText(), "Other Business");
    }

    @Test(priority = 4)
    public void testCheckThatCreationListDisplayedAfterClickingOnMyCreationsTab () throws InterruptedException {
        super.logInWithEmailFromStartPage(); //remove later
        dashboardPage.tabMyCreationsInBarheader.click();
            wait8.withMessage("My Creations title is not displayed")
                .until(ExpectedConditions.titleContains("My Creations"));
        //Assert empty
        dashboardPage.logoSmilebox.click();
            wait8.withMessage("Smilebox Dashboard page is not displayed")
                .until(ExpectedConditions.titleContains("Smilebox Dashboard"));
        dashboardPage.templateExampleJoimUsFloral.click();
            wait8.withMessage("Personalise button is not displayed")
                .until(ExpectedConditions.visibilityOf(dashboardPage.buttonPersonalise));
        dashboardPage.buttonPersonalise.click();
            wait8.withMessage("Smilebox Plus Editor Page is not displayed")
                    .until(ExpectedConditions.titleContains("Smilebox Plus Editor"));
        editorPage.fillInFieldsInFloralTemplate();
        editorPage.savingModifiedTemplate();
            wait8.withMessage("Not redirected to Editor page after Save +Save")
                .until(ExpectedConditions.visibilityOf(editorPage.buttonPreviewAndShare));
        driver.get("https://plus.smilebox.com/MyCreations");
        //delete edited template
        Thread.sleep(3000);
    }


    @Ignore
    @Test(priority = 3)
    public void checkThatFilterWorksInAllCategories() throws InterruptedException {
        //super.logInWithEmailFromStartPage(); //TODO move to helpers
        driver.manage().window().maximize();
        dashboardPage.buttonCloseFromMarketingWrapper.click();
        dashboardPage.selectACategoryFromDropDownInFilters();
        Thread.sleep(2000);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }


}

