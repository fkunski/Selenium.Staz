package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.ExtentManager;
import pages.QuestionaryPage;

import java.lang.reflect.Method;

public class QuestionaryBase {
    WebDriver driver;
    ConfigReader configReader;
    QuestionaryPage questionaryPage;

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
    @AfterMethod
    public void afterMethod(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            test.log(Status.FAIL, "Test Case Failed: " + result.getName());
            test.log(Status.FAIL, "Reason: " + result.getThrowable());
        }else if(result.getStatus() == ITestResult.SUCCESS){
            test.log(Status.PASS,"Test Case Passes: " + result.getName());
        }else if(result.getStatus() == ITestResult.SKIP){
            test.log(Status.SKIP,"Test Case Skipped: " + result.getName());
        }

    }
    @BeforeClass
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {
        configReader = new ConfigReader();

        if (browser.equalsIgnoreCase("chrome")) {
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
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            if (configReader.isIncognito()) {
                options.addArguments("--inprivate");
            }
            driver = new EdgeDriver(options);
        }

        //sterowanie otwarciem URL
        driver.get(configReader.getQuestionaryURL());
        questionaryPage = PageFactory.initElements(driver, QuestionaryPage.class);
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
