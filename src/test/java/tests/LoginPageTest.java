package tests;
import org.testng.annotations.Test;

public class LoginPageTest extends LoginBase{
    @Test
    public void loginTest(){loginPage.LoginFirstUser(configReader.getUserName(), configReader.getPassword());}
    @Test
    public void logoutTest(){
        loginPage.LogoutUser();
    }
    }



