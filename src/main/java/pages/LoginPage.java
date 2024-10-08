package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    //elementy strony
    @FindBy(xpath = "//input[@id='username']")
    WebElement usernameField;
    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;
    @FindBy(xpath = "//button[@type='submit' and @value='Zaloguj się']")
    WebElement loginButton;
    @FindBy(xpath = "//a[text()='Wyloguj]")
    WebElement logoutButton;
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    //metody loginpagea
    public void LoginFirstUser(String username, String password){
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }
    public void LogoutUser(){
        logoutButton.click();
    }
}
