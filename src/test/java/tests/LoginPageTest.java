package tests;
import com.aventstack.extentreports.Status;
import org.testng.IDynamicGraph;
import org.testng.annotations.Test;

public class LoginPageTest extends LoginBase{

    @Test
    public void loginTest(){
        test.log(Status.INFO, "Rozpoczęcie logowania");
        loginPage.sendUsernameField(configReader.getUserName());
        loginPage.sendPasswordField(configReader.getPassword());
        loginPage.loginButtonClick();
    }
    @Test
    public void logoutTest(){
        test.log(Status.INFO, "Wylogowanie");
        loginPage.LogoutUser();
    }
    }



