package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.ExtentManager;
import java.lang.reflect.Method;
import java.time.Duration;

public class TestBase {
    WebDriver driver;
    ConfigReader configReader;
    WebDriverWait wait;

    protected ExtentReports extent;
    protected ExtentTest test;
    @BeforeSuite
    public void setUpSuite(){
        extent = ExtentManager.getInstance();
    }
    @BeforeMethod
    public void setUpMethod(Method method){
        test = extent.createTest((method.getName()));
    }
    @BeforeClass
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {
        configReader = new ConfigReader();

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();

            if (configReader.isNoDefaultBrowserCheck()) {
                options.addArguments("--no-default-browser-check=new");
            }
            if (configReader.isNoFirstRun()) {
                options.addArguments("--no-first-run=new");
            }
            if (configReader.isIncognito()) {
                options.addArguments("incognito");
            }
            options.addArguments("user-data-dir=C:/Users/Ewa/AppData/Local/Google/Chrome/User Data/Default");
            //options.addArguments("user-data-dir=C:/Temp/ChromeProfile");  // Tymczasowy katalog
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            if (configReader.isIncognito()) {
                options.addArguments("--inprivate");
            }
            driver = new EdgeDriver(options);
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    @BeforeClass
    public void setUp(){
        configReader = new ConfigReader();
        ChromeOptions options = new ChromeOptions();

        if (configReader.isNoDefaultBrowserCheck()){
            options.addArguments("--no-default-browser-check=new");
        }
        if(configReader.isNoFirstRun()){
            options.addArguments("--no-first-run=new");
        }
        if(configReader.isIncognito()){
            options.addArguments("--incognito");
        }
        options.addArguments("user-data-dir=C:/Users/Ewa Lotterhoff/AppData/Local/Google/Chrome/User Data/Default");
        driver = new ChromeDriver(options);
    }
    @AfterMethod
    public void afterMethod(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            test.log(Status.FAIL, "Test Case Failed: " + result.getName());
            test.log(Status.FAIL, "Reason: " + result.getThrowable());

            //dodawanie screena
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getName());
            try{
                test.addScreenCaptureFromPath(screenshotPath);
            }catch(Exception e){
                test.log(Status.FAIL, "Screenshot: "+e.getMessage());
            }
        }else if(result.getStatus() == ITestResult.SUCCESS){
            test.log(Status.PASS,"Test Case Passes: " + result.getName());
        }else if(result.getStatus() == ITestResult.SKIP){
            test.log(Status.SKIP,"Test Case Skipped: " + result.getName());
        }
    }
    @AfterSuite
    public void tearDownSuite(){
        extent.flush();
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
