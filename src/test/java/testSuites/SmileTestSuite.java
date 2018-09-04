package testSuites;
import com.plusSmilebox.pages.*;
import com.plusSmilebox.pages.additionalPages.FacebookPage;
import com.plusSmilebox.pages.initialPages.FBloginPage;
import com.plusSmilebox.pages.initialPages.LogInWithEmailPage;
import com.plusSmilebox.pages.initialPages.RegisterPage;
import com.plusSmilebox.pages.initialPages.StartPage;
import com.plusSmilebox.util.Constants;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import util.BaseTest;
import util.ListenerSmile;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Listeners(ListenerSmile.class)
public class SmileTestSuite extends BaseTest {

    protected FBloginPage fBloginPage;

    protected EditorPage editorPage;
    protected MyCreationsPage myCreationsPage;
    protected final static Logger logger = Logger.getLogger(SmileTestSuite.class);
    protected RegisterPage registerPage;
    protected FacebookPage facebookPage;

    @Override
    public Logger getLogger() {
        return logger;
    }

    @BeforeClass
    public void beforeClass() {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        fBloginPage = new FBloginPage(driver);
        editorPage = new EditorPage(driver);
        myCreationsPage= new MyCreationsPage(driver);
        registerPage = new RegisterPage(driver);
        facebookPage = new FacebookPage(driver);

    }

    @Test(priority = 1)
    public void testUserCanLogInViaFacebookButton() {
        driver.get(Constants.LINK_START_PAGE);
        startPage.clickButtonLoginWithFB();
        waitForTitleRefreshed("Facebook", 20);
        fBloginPage.logInWithFBcredentials();
        waitForTitleRefreshed("Smilebox Dashboard", 20);
        dashboardPage.logOutViaProvileDropdownOnDashboarPage();
        Assert.assertNotEquals(driver.getTitle(), "Smilebox Dashboard");
    }

    @Test(priority = 2)
    public void testUserCanLogInViaLogInWithEmailButton () {
        driver.get(Constants.LINK_START_PAGE);
        startPage.clickLinkLogInWithExistedAccount();
        logInWithEmailPage.logInWithEmail();
        waitForTitleRefreshed("Smilebox Dashboard", 20);
        Assert.assertEquals(driver.getTitle(), "Smilebox Dashboard");
    }
    //after selecting filters in Template header, Designs in body are refreshed (and become less) and title refreshed too
    @Test(priority = 3)
    public void testUserSelectTemplatesFromHeader_FirstAndLast() throws InterruptedException {
        initialStepRedirectsToDashboardPage();
        int amountDesignsBeforeFiltering = amountTemplatesDesignsInBody(); //all Designs available (325 or so)
        logger.info("amountTemplatesDesignsInBody = " + amountDesignsBeforeFiltering);

        listTemplatesFiltersInHeader().get(0).click(); // select first filter (e.g. Christmas) in header
        waitForTitleRefreshed("Search results", 10);
        int amountDesignsAfterFiltering = amountTemplatesDesignsInBody();
        Assert.assertTrue(amountDesignsBeforeFiltering > amountDesignsAfterFiltering); //verify that designs are refreshed after filtering
        logger.info("amountDesignsAfterFiltering = " + amountDesignsAfterFiltering);

        listTemplatesFiltersInHeader().get(listTemplatesFiltersInHeader().size()-1).click(); // click on last filter (e.g. Other Business)
        waitForTitleRefreshed("Search results", 10);
        int amountDesignsAfterFiltering2 = amountTemplatesDesignsInBody();
        Assert.assertTrue(amountDesignsBeforeFiltering > amountDesignsAfterFiltering2); //verify that designs are refreshed
        logger.info("amountDesignsAfterFiltering2 = " + amountDesignsAfterFiltering2);

    }
 //TODO move this method to dashboard page
    protected int amountTemplatesDesignsInBody() throws InterruptedException {
        int x;
        int res = 0;
        List<WebElement> listBigTemplates;
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        do {
            x = res;
            jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            listBigTemplates = driver.findElements(By.xpath(dashboardPage.xptemplatesDesignsInBody));
            res = listBigTemplates.size();
            Thread.sleep(3000);
        } while (x < res);
        return res;
    }
    //TODO move this method to dashboard page
    private List<WebElement> listTemplatesFiltersInHeader(){
        waitForElementIsVisible(dashboardPage.dropdownTemplatesInBarHeader, 10).click();
        List<WebElement> listTemplatesFilters = driver.findElements(By.xpath(dashboardPage.xpTemplatesFiltersInHeader));
        Assert.assertTrue(listTemplatesFilters.size()>2);
        return listTemplatesFilters;
    }




    @Test(priority = 4)
    public void testCheckThatCreationListDisplayedAfterClickingOnMyCreationsTab() throws InterruptedException {
        initialStepRedirectsToDashboardPage();
        dashboardPage.templateExampleJoimUsFloral.click();
        waitForElementIsVisible(dashboardPage.buttonPersonalise, 30).click();
        editorPage.fillInFieldsInFloralTemplate();
        editorPage.savingModifiedTemplate();
        driver.get(Constants.LINK_MY_CREATIONS_PAGE);
        Assert.assertTrue(isElementDisplayed(myCreationsPage.creationList));// check assert
        //implement functionality delete edited template
    }

    @Test(priority = 5)
    public void testShouldFail() {
        driver.get(Constants.LINK_LOGIN_WITH_EMAIL_PAGE);
        try {
            waitForElementIsVisible(logInWithEmailPage.inputFieldEmail, 10).sendKeys("Invalid email");
        } catch (Exception e) {
            waitForElementIsVisible(startPage.linkLogInWithExistedAccount, 10).click();
            waitForElementIsVisible(logInWithEmailPage.inputFieldEmail, 10).sendKeys("Invalid email");
        }
        logInWithEmailPage.buttonSubmit.click();
        Assert.assertEquals(driver.getTitle(), "Smilebox dashboard");
    }

    @Ignore
    @Test (priority = 5)
    public void shareSditedTemplateOnFacebook() throws InterruptedException {
        //facebookPage.logInToFB();
        initialStepRedirectsToDashboardPage();
        dashboardPage.tabMyCreationsInBarheader.click();
        waitForTitleRefreshed("My Creation", 10);
        dashboardPage.buttonShare_readyToShareTemplate.click();
        waitForElementIsVisible(dashboardPage.buttonShareFB_readyToShareTemplate, 10).click();
        Thread.sleep(3000);

    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}

