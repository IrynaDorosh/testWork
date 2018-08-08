package classes.com.plusSmilebox.libs;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerSmile implements ITestListener {
    public ListenerSmile() {
    }

    public void onTestStart(ITestResult iTestResult) {
    }

    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("The name of the testcase succedeed is :" + iTestResult.getName());
    }

    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("The name of the testcase failed is :" + iTestResult.getName());
    }

    public void onTestSkipped(ITestResult iTestResult) {
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    public void onStart(ITestContext iTestContext) {
    }

    public void onFinish(ITestContext iTestContext) {
    }
}
