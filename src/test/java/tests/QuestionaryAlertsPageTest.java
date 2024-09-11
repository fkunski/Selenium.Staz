package tests;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QuestionaryPage;

public class QuestionaryAlertsPageTest extends QuestionaryBase {
@Test
    public void questionaryAlertButtonTest(){
    test.log(Status.INFO, "Otwrcie alertu do zatwierdzenia");
    questionaryPage.QuestionaryAlertButtonClick();
}
    @Test
    public void questionaryPromptAlertButtonTest(){
        test.log(Status.INFO, "Otwarcie propmt alertu");
        questionaryPage.QuestionaryPromptAlertButtonClick();
        test.log(Status.INFO, "wprowadzenie tekstu");
        questionaryPage.QuestionaryPromptAlertTextInsert("teskt do zatwierdzenia");
        test.log(Status.INFO, "Zatwierdzenie alertu");
        questionaryPage.QuestionaryPromptAlertAcceptButton();
    }
    @Test
    public void questionaryConfirmAlertButtonTest(){
        test.log(Status.INFO, "OTWARCIE ALERTU");
        questionaryPage.QuestionaryConfirmAlertButtonClick();
    }
    @Test
    public void questionaryCancelAlertButtonTest(){
        test.log(Status.INFO, "Test anulujący alert");
        questionaryPage.QuestionaryDismissAlertButtonClick();
    }
    @Test
    public void questionaryRightClickButtonTest(){
        test.log(Status.INFO, "Kliknięcie prawym przyciskiem");
        questionaryPage.QuestionaryClickRightButtonClick();
        WebElement rightClickInfo = driver.findElement(By.xpath("//p[@id='rightClickInfo']"));
        String actualText = rightClickInfo.getText();
        String expectedText = "Przycisk RIGHT został kliknięty";
        Assert.assertEquals(actualText, expectedText, "Przycisk nie został kliknięty");
    }
    @Test
    public void questionaryProcesTest(){
        test.log(Status.INFO, "Test wyświetlania paska");
        questionaryPage.QuestionaryProcesButtonClick();
        WebElement procesInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='processText']")));
        String actualText = procesInfo.getText();
        String expectedText = "Element Proces został wyświetlony";
        Assert.assertEquals(actualText, expectedText,"Proces nie został uruchomiony");
        }

    @Test
    public void questionaryDoubleClickTest(){
    test.log(Status.INFO,"Dwuklik na elemencie");
    questionaryPage.QuestionaryDoubleClick();
    WebElement doubleClickInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='p-doubleClick']")));
    String actualText = doubleClickInfo.getText();
    String expectedText = "Przycisk dwuklik został kliknięty";
    Assert.assertEquals(actualText,expectedText,"Przycisk nie został dwa razy kliknięty");
        }
    @Test
    public void questionaryNewTabTest(){
    test.log(Status.INFO,"Otwarcie nowej zakładki");
    questionaryPage.QuestionaryNewTabClick();
    test.log(Status.INFO,"zmiana zakladki w przegladarce");
    questionaryPage.QuestionaryChangeTabInBrowser();
    }
}
