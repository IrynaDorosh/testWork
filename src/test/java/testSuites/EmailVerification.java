package testSuites;
import com.plusSmilebox.pages.initialPages.RegisterPage;
import com.plusSmilebox.pages.initialPages.StartPage;
import com.plusSmilebox.util.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.util.List;
import static com.plusSmilebox.util.Constants.PROJECT_ROOT;

public class EmailVerification {

    static {
        System.setProperty("webdriver.chrome.driver", PROJECT_ROOT + "libs\\chromedriver.exe");
    }

    private WebDriver driver;
    private WebDriverWait wait15;
    private StartPage startPage;
    private RegisterPage registerPage;

    private void refreshDriver() {
        driver = new ChromeDriver();
        wait15 = new WebDriverWait(driver, 15);
        startPage = new StartPage(driver);
        registerPage = new RegisterPage(driver);
    }

    @Test
    public void emailVerification() {
        List<String> listEmails = FileUtils.readFileToStringList(PROJECT_ROOT+"src\\test\\resources\\usernames.txt");
        List<String> listPasses = FileUtils.readFileToStringList(PROJECT_ROOT+"src\\test\\resources\\passwords.txt");

        for (int i = 0; i < listEmails.size(); i++) {
            refreshDriver();

            driver.get("https://plus-qa.smilebox.com/Account/Welcome");
            startPage.linkSignUpWithEmail.click();
            wait15.withMessage("Register page is not displayed")
                    .until(ExpectedConditions.titleContains("Register"));
            registerPage.nameForRegistrationInput.sendKeys("Irina A " + i);
            registerPage.emailForRegistrationInput.sendKeys(listEmails.get(i));
            registerPage.passwordForRegistrationInput.sendKeys(listPasses.get(i));
            registerPage.buttonSignIn.click();
            try {
                wait15.withMessage("Choose Design")
                        .until(ExpectedConditions.titleContains("Choose Design"));
            } catch (Exception e) {
                System.out.println("Choose Design page not found. Check email" + listEmails.get(i));
            }
            driver.quit();
        }
    }
}





