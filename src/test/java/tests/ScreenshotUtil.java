package tests;

import ch.qos.logback.core.util.FileUtil;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {
    public static String captureScreenshot(WebDriver driver, String screenshotName){
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotPath = "screenshots/"+screenshotName+"_"+timestamp+".png";
        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(source, new File(screenshotName));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    return screenshotPath;
    }
}
