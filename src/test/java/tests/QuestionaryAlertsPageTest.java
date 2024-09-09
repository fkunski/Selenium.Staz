package tests;

import com.aventstack.extentreports.Status;
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
        test.log(Status.INFO, "Test zatwierdzający alert");
        questionaryPage.QuestionaryConfirmAlertButtonClick();
    }
    @Test
    public void questionaryCancelAlertButtonTest(){
        test.log(Status.INFO, "Test anulujący alert");
        questionaryPage.QuestionaryDismissAlertButtonClick();
    }
    @Test
    public void questionaryRightClickTest(){
        questionaryPage.QuestionaryClickRightButtonClick();
    }
    @Test
    public void questionaryProcesButtonClickTest(){
        questionaryPage.QuestionaryProcesButtonClick();
    }
}
