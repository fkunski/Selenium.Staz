package pages;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuestionaryPage extends BasePage {
    //Elementy Strony
    @FindBy(xpath = "//input[@id='Imię']")
    WebElement questionaryName;
    @FindBy(xpath = "//input[@id='Nazwisk']")
    WebElement questionarySurname;
    @FindBy(xpath = "//input[@name='KobietaCzyMezczyzna' and @value='Kobieta']")
    WebElement questionaryFemale;
    @FindBy(xpath = "//input[@name='KobietaCzyMezczyzna' and @value='Mężczyzna']")
    WebElement questionaryMale;
    @FindBy(xpath = "//input[@id='Wiek']")
    WebElement questionaryAge;
    @FindBy(xpath = "//input[@id='Wiek' and @value = 'mniej niż 15']")
     WebElement questionaryAge015;
    @FindBy(xpath = "//input[@id='Wiek' and @value = '15-19']")
    WebElement questionaryAge1519;
    @FindBy(xpath = "//input[@id='Wiek' and @value = '20-29']")
    WebElement questionaryAge2029;
    @FindBy(xpath = "//input[@id='Wiek' and @value = '30-39']")
    WebElement questionaryAge3039;
    @FindBy(xpath = "//input[@id='Wiek' and @value = '40-60']")
    WebElement questionaryAge4060;
    @FindBy(xpath = "//input[@id='Wiek' and @value = 'więcej niż 60']")
    WebElement questionaryAge60100;
    @FindBy(xpath= "//input[@id='Produkt' and @value = 'Koszulka meczowa']")
    WebElement questionaryItemShirt;
    @FindBy(xpath= "//input[@name='Produkt' and @value = 'Piłka nożna']")
    WebElement questionaryItemBall;
    @FindBy(xpath= "//input[@name='Produkt' and @value = 'Buty sportowe']")
    WebElement questionaryItemShoes;
    @FindBy(xpath= "//input[@name='Produkt' and @value = 'Torba sportowa']")
    WebElement questionaryItemBag;
    @FindBy(xpath= "//input[@name='Muzyka' and @value = 'Inna']")
    WebElement questionaryItemOther;
    @FindBy(xpath="//input[@name='Produkt' and @type='text']")
    WebElement questionaryItemOtherTextArea;
    @FindBy(xpath="//select[@class='moj-select' and @name='Sport']")
    WebElement questionarySelectSport;
    @FindBy(xpath="//option[@value='pilkaNozna']")
    WebElement questionarySelectFootBall;
    @FindBy(xpath="//option[@value='siatkowka']")
    WebElement questionarySelectVolleyBall;
    @FindBy(xpath="//input[@class='form-control white']")
    WebElement questionaryDateInput;
    @FindBy(xpath="//input[@type='button' and @value='Alert']")
    WebElement questionaryAlertButton;
    @FindBy(xpath="//input[@type='button' and @value='Prompt Alert']")
    WebElement questionaryPromptAlertButton;
    @FindBy(xpath="//input[@type='button' and @value='Confirm Alert']")
    WebElement questionaryConfirmAlertButton;
    @FindBy(xpath="//input[@type='button' and @value='Kliknij RIGHT']")
    WebElement questionaryRightClickButton;
    @FindBy(xpath="//input[@type='button' and @value='PROCES']")
    WebElement questionaryProcesButton;
    @FindBy(xpath="//input[@type='button' and @value='Dwuklik pokaż komunikat']")
    WebElement questionaryDoubleClickButton;
    @FindBy(xpath="//input[@type='button' and @value='Otwórz nowe okno']")
    WebElement questionaryOpenNewWindowButton;
    public QuestionaryPage(WebDriver driver) {
        super(driver);
    }
    //Konstruktor + inicjalizacja pageFactory
    public void QuestionaryFieldName(){
        questionaryName.sendKeys("Wojtek");
    }
    public void QuestionaryFieldSurname(){
        questionarySurname.sendKeys("Ziutowy");
    }
    public void QuestionaryGenderOptionOne(){
        questionaryFemale.click();
    }
    public void QuestionaryGenderOptionTwo(){
        questionaryMale.click();
    }
    public void QuestionaryFieldAge015(){
        questionaryAge015.click();
    }
    public void QuestionaryFieldAge1519(){
        questionaryAge1519.click();
    }
    public void QuestionaryFieldAge2029(){
        questionaryAge2029.click();
    }
    public void QuestionaryFieldAge3039(){
        questionaryAge3039.click();
    }
    public void QuestionaryFieldAge4060(){
        questionaryAge4060.click();
    }
    public void QuestionaryFieldAge60100(){
        questionaryAge60100.click();
    }
    public void QuestionaryFieldShirt() {
        questionaryItemShirt.click();
    }
    public void QuestionaryFieldBall() {
        questionaryItemBall.click();
    }
    public void QuestionaryFieldShoes() {
        questionaryItemShoes.click();
    }
    public void QuestionaryFieldBag() {
        questionaryItemBag.click();
    }
    public void QuestionaryFieldOther() {
        questionaryItemOther.click();
    }
    public void QuestionaryFieldOtherTextArea() {
        questionaryItemOtherTextArea.sendKeys("sample text");
    }
    public void QuestionaryOptionSelectSport(){
        questionarySelectSport.click();
    }
    public void QuestionarySelectFootBall(){
        questionarySelectFootBall.click();
    }
    public void QuestionarySelectVolleyBall(){
        questionarySelectVolleyBall.click();
    }
    public void QuestionaryDataPickerFormClear(){
        questionaryDateInput.clear();
    }
    public void QuestionaryDateInput(String dataField){
        questionaryDateInput.sendKeys(dataField);
        actions.sendKeys(Keys.ESCAPE).perform();
    }
    public void QuestionaryAlertButtonClick(){
        questionaryAlertButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public void QuestionaryPromptAlertButtonClick(){
        questionaryPromptAlertButton.click();
        Alert promptAlert = driver.switchTo().alert();
        String textToPromptAlert = "testowy teskt";
        promptAlert.sendKeys(textToPromptAlert);
        promptAlert.accept();
    }
    public void QuestionaryConfirmAlertButtonClick(){
        questionaryConfirmAlertButton.click();
        Alert confirmAcceptAlert = driver.switchTo().alert();
        confirmAcceptAlert.accept();
    }
    public void QuestionaryDismissAlertButtonClick(){
        questionaryConfirmAlertButton.click();
        Alert confirmDismissAlert = driver.switchTo().alert();
        confirmDismissAlert.dismiss();
    }
    public void QuestionaryClickRicghtButtonClick(){questionaryRightClickButton.click();}
    public void QuestionaryProcesButtonClick(){questionaryProcesButton.click();}
}
