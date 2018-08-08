package com.plusSmilebox.libs;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;


public class Helpers {

    private WebDriver driver;
    public Helpers(WebDriver driver){
        this.driver = driver;
    }

    public void letsScreenshot() throws IOException {
    File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    String path = "./screenShots/"+folderName()+ "/"+ screenshot.getName();
        FileUtils.copyFile(screenshot, new File(path));
    }
//TODO should return name of test suite
    private String folderName(){
        return "newFolder";
    }




}
