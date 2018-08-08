package initialTestSuite;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class ListenerSmile implements ITestListener {


    WebDriver driver=null;
    String filePath = "./screenShots/";


    public void onTestStart(ITestResult iTestResult) {

    }
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
          //  helpers.letsScreenshot();
        System.out.println("The name of the testcase succedeed is :"+iTestResult.getName());

    }
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        //System.out.println("The name of the testcase failed is :"+iTestResult.getName());
        System.out.println("************Error: "+ iTestResult.getName()+" test has failed ***************");
        String methodName=iTestResult.getName().toString().trim();
        takeScreenShot(methodName);

    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }


    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }

    public void takeScreenShot(String methodName) {
        //get the driver

       // driver=TestBase.getDriver();
       // driver = testBase.getDriver();

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //The below method will save the screen shot in d drive with test method name
        try {
            FileUtils.copyFile(scrFile, new File(filePath+methodName+".png"));
            System.out.println("***Placed screen shot in "+filePath+" ***");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
