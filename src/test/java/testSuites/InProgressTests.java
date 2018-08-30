package testSuites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class InProgressTests extends SmileTestSuite {



    @Test
        public void freeFlyerCreateAndShareViaEmail(){
        initialStepRedirectsToDashboardPage();
        //display all tesmplates
        List<WebElement> we = driver.findElements(By.xpath("//div[@class='design-container design-pop']"));
        System.out.println("Size is:" + we.size());
        }


    }





