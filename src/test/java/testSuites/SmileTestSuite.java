package testSuites;
import com.plusSmilebox.pages.*;
import com.plusSmilebox.pages.additionalPages.FacebookPage;
import com.plusSmilebox.pages.initialPages.FBloginPage;
import com.plusSmilebox.pages.initialPages.RegisterPage;
import com.plusSmilebox.util.Constants;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
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
    public void testLogInViaFacebookButton() {
        driver.get(Constants.LINK_START_PAGE);
        startPage.clickButtonLoginWithFB();
        waitForTitleRefreshed("Facebook", 20);
        fBloginPage.logInWithFBcredentials();
        waitForTitleRefreshed("Smilebox Dashboard", 20);
        dashboardPage.logOutViaProvileDropdownOnDashboarPage();
        Assert.assertNotEquals(driver.getTitle(), "Smilebox Dashboard");
    }

    @Test(priority = 2)
    public void testLogInViaLogInWithEmailButton() {
        driver.get(Constants.LINK_START_PAGE);
        startPage.clickLinkLogInWithExistedAccount();
        logInWithEmailPage.logInWithEmail();
        waitForTitleRefreshed("Smilebox Dashboard", 20);
        Assert.assertEquals(driver.getTitle(), "Smilebox Dashboard");
    }

    @Test (priority = 3)
    public void testVerifyCheckboxesOnDasboard() throws InterruptedException {
        initialStepRedirectsToDashboardPage();

        List<WebElement> listSlideshow = displayWidgetElement.listDesignsAfterUntickAll_ExceptSlideshow();
        List<WebElement> formatSlideshow = driver.findElements(By.xpath(dashboardPage.xpFormatBoxSlideshow));
        logger.info("Amount of 'Slideshow' formats are: "+ formatSlideshow.size());
        Assert.assertTrue(displayWidgetElement.comparingAmountOfDesignsAndFormats(listSlideshow, formatSlideshow));

        dashboardPage.logoSmilebox.click(); //to get to the top of the page
        List<WebElement> listInvitation = displayWidgetElement.listDesignsAfterUntickAll_ExceptInvitation();
        List<WebElement> formatInvitation = driver.findElements(By.xpath(dashboardPage.xpFormatBoxInvitation));
        logger.info("Amount of 'Invitation' formats are: "+ formatInvitation.size());
        Assert.assertTrue(displayWidgetElement.comparingAmountOfDesignsAndFormats(listInvitation,formatInvitation ));

        dashboardPage.logoSmilebox.click();
        List<WebElement> listGreetings = displayWidgetElement.listDesignsAfterUntickAll_ExceptGreetings();
        List<WebElement> formatGreetings = driver.findElements(By.xpath(dashboardPage.xpFormatBoxGreeting));
        logger.info("Amount of 'Greetings' formats are: "+ formatGreetings.size());
        Assert.assertTrue(displayWidgetElement.comparingAmountOfDesignsAndFormats(listGreetings,formatGreetings));

        dashboardPage.logoSmilebox.click();
        List<WebElement> listFlyers = displayWidgetElement.listDesignsAfterUntickAll_ExceptFlyer();
        List<WebElement> formatFlyers = driver.findElements(By.xpath(dashboardPage.xpFormatBoxFlyer));
        logger.info("Amount of 'Flyers' formats are: "+ formatFlyers.size());
        Assert.assertTrue(displayWidgetElement.comparingAmountOfDesignsAndFormats(listFlyers, formatFlyers));
    }

    @Test(priority = 3)
    public void testSelectTemplatesFromHeader_FirstAndLast() throws InterruptedException {
        initialStepRedirectsToDashboardPage();
        int amountDesignsBeforeFiltering = dashboardPage.amountTemplatesDesignsInBody1(); //all Designs available (325 or so)
        logger.info("amountTemplatesDesignsInBody = " + amountDesignsBeforeFiltering);

        dashboardPage.listTemplatesFiltersInHeader().get(0).click(); // select first filter (e.g. Christmas) in header
        waitForElementIsVisible(dashboardPage.templatesDesignsInBody, 10);
        int amountDesignsAfterFiltering = dashboardPage.amountTemplatesDesignsInBody1();
        Assert.assertTrue(amountDesignsBeforeFiltering > amountDesignsAfterFiltering); //verify that designs are refreshed after filtering
        logger.info("amountDesignsAfterFiltering = " + amountDesignsAfterFiltering);

        dashboardPage.listTemplatesFiltersInHeader().get(dashboardPage.listTemplatesFiltersInHeader().size()-1).click(); // click on last filter (e.g. Other Business)
        waitForElementIsVisible(dashboardPage.templatesDesignsInBody, 10);
        int amountDesignsAfterFiltering2 = dashboardPage.amountTemplatesDesignsInBody1();
        Assert.assertTrue(amountDesignsBeforeFiltering > amountDesignsAfterFiltering2); //verify that designs are refreshed
        logger.info("amountDesignsAfterFiltering2 = " + amountDesignsAfterFiltering2);
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}

