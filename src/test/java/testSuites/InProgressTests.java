package testSuites;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
public class InProgressTests extends SmileTestSuite {

    @Test
    public void testVerifyCheckboxesOnDasboard() throws InterruptedException {
        initialStepRedirectsToDashboardPage();

        List<WebElement> listSlideshow = displayWidgetElement.listDesignsAfterUntickAll_ExceptSlideshow();
        logger.info("Amount of 'Slideshow' designs are: "+ listSlideshow.size());
        List<WebElement> formatSlideshow = driver.findElements(By.xpath(dashboardPage.xpFormatBoxSlideshow));
        logger.info("Amount of 'Slideshow' formats are: "+ formatSlideshow.size());
        Assert.assertTrue(displayWidgetElement.comparingAmountOfDesignsAndFormats(listSlideshow, formatSlideshow));

        dashboardPage.logoSmilebox.click(); //to get to the top of the page
        List<WebElement> listInvitation = displayWidgetElement.listDesignsAfterUntickAll_ExceptInvitation();
        logger.info("Amount of 'Invitation' designs are: "+ listInvitation.size());
        List<WebElement> formatInvitation = driver.findElements(By.xpath(dashboardPage.xpFormatBoxInvitation));
        logger.info("Amount of 'Invitation' formats are: "+ formatInvitation.size());
        Assert.assertTrue(displayWidgetElement.comparingAmountOfDesignsAndFormats(listInvitation,formatInvitation ));

        dashboardPage.logoSmilebox.click();
        List<WebElement> listGreetings = displayWidgetElement.listDesignsAfterUntickAll_ExceptGreetings();
        logger.info("Amount of 'Greetings' designs are: " + listGreetings.size());
        List<WebElement> formatGreetings = driver.findElements(By.xpath(dashboardPage.xpFormatBoxGreeting));
        logger.info("Amount of 'Greetings' formats are: "+ formatGreetings.size());
        Assert.assertTrue(displayWidgetElement.comparingAmountOfDesignsAndFormats(listGreetings,formatGreetings));

        dashboardPage.logoSmilebox.click();
        List<WebElement> listFlyers = displayWidgetElement.listDesignsAfterUntickAll_ExceptFlyer();
        logger.info("Amount of 'Flyers' designs are: " + listFlyers.size());
        List<WebElement> formatFlyers = driver.findElements(By.xpath(dashboardPage.xpFormatBoxFlyer));
        logger.info("Amount of 'Flyers' formats are: "+ formatFlyers.size());
        Assert.assertTrue(displayWidgetElement.comparingAmountOfDesignsAndFormats(listFlyers, formatFlyers));
    }





    }





