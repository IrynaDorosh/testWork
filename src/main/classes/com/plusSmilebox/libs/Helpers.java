package classes.com.plusSmilebox.libs;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helpers {
    private WebDriver driver;

    public Helpers(WebDriver driver) {
        this.driver = driver;
    }

    public void letsScreenshot() throws IOException {
        File screenshot = (File)((TakesScreenshot)this.driver).getScreenshotAs(OutputType.FILE);
        String path = "./screenShots/" + this.folderName() + "/" + screenshot.getName();
        FileUtils.copyFile(screenshot, new File(path));
    }

    private String folderName() {
        return "newFolder";
    }
}
