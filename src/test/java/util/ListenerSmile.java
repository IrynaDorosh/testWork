package util;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
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

    @Override
    public void onTestStart(ITestResult iTestResult) {
        Logger logger = ((BaseTest) iTestResult.getInstance()).getLogger();
        logger.debug("*** " + iTestResult.getMethod().getMethodName() + " started ***");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
//        System.out.println("The name of the testcase succedeed is :" + iTestResult.getName());
        Logger logger = ((BaseTest) iTestResult.getInstance()).getLogger();
        logger.debug(iTestResult.getMethod().getMethodName() + " finished successfully");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Logger logger = ((BaseTest) iTestResult.getInstance()).getLogger();
        logger.debug(iTestResult.getMethod().getMethodName() + " FAILED");

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
                String filePath = "./screenShots/";
                String fullPath = filePath + methodName + "-" + formattedDate + ".png";
                FileUtils.copyFile(scrFile, new File(fullPath));
                System.out.println("***Placed screen shot in " + filePath + " ***");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
