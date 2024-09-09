package tests;

import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;
import pages.QuestionaryPage;

public class QuestionaryAlertsPageTest extends QuestionaryBase {
@Test
    public void questionaryALertClickTest(){
    test.log(Status.INFO, "Otwrcie alertu do zatwierdzenia");
    questionaryPage.QuestionaryAlertButtonClick();
}
}
