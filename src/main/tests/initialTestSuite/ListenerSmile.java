package initialTestSuite;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ListenerSmile implements ITestListener {

    private String filePath = "./screenShots/";

    public void onTestStart(ITestResult iTestResult) {
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("The name of the testcase succedeed is :" + iTestResult.getName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("************Error: " + iTestResult.getName() + " test has failed ***************");
        String methodName = iTestResult.getName().trim();

        Object currentTestClass = iTestResult.getInstance();
        WebDriver webDriver = ((BaseTest) currentTestClass).getDriver();

        takeScreenShot(webDriver, methodName);
    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {
    }

    private void takeScreenShot(WebDriver driver, String methodName) {
        if (driver != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy___HH-mm-ss");
            String formattedDate = simpleDateFormat.format(new Date());

            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            //The below method will save the screen shot in d drive with test method name
            try {
                String fullPath = filePath + methodName + "-" + formattedDate + ".png";
                FileUtils.copyFile(scrFile, new File(fullPath));
                System.out.println("***Placed screen shot in " + filePath + " ***");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
