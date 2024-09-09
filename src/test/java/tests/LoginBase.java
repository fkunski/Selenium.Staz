package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;
import tests.ConfigReader;
import java.util.Properties;

public class LoginBase {
    WebDriver driver;
    ConfigReader configReader;
    LoginPage loginPage;
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
            options.addArguments("incognito");
        }
        options.addArguments("user-data-dir=C:/Users/Ewa Lotterhoff/AppData/Local/Google/Chrome/User Data/Default");
        driver = new ChromeDriver(options);

        //sterowanie otwarciem URL
        driver.get(configReader.getAccountLoginURL());
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}