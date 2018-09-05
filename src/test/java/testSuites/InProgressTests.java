package testSuites;
import com.plusSmilebox.util.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import java.util.List;
public class InProgressTests extends SmileTestSuite {



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




    public void shareSditedTemplateOnFacebook() throws InterruptedException {
        //facebookPage.logInToFB();
        initialStepRedirectsToDashboardPage();
        dashboardPage.tabMyCreationsInBarheader.click();
        waitForTitleRefreshed("My Creation", 10);
        dashboardPage.buttonShare_readyToShareTemplate.click();
        waitForElementIsVisible(dashboardPage.buttonShareFB_readyToShareTemplate, 10).click();
        Thread.sleep(3000);

    }





    }





