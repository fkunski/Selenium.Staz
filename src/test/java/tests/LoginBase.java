package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import pages.LoginPage;


public class LoginBase extends TestBase{
    LoginPage loginPage;

    @BeforeClass
    public void setUp(){
        super.setUp();
        //sterowanie otwarciem URL
        driver.get(configReader.getAccountLoginURL()); //tu ma problem
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }
}