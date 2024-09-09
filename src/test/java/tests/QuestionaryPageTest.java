package tests;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;
import pages.LoggerClass;
//import
public class QuestionaryPageTest extends QuestionaryBase {
    //Metody testowe
    @Test
    public void questionaryNameSurnameTest(){
        LoggerClass.info("Starting Questionary Name And Surname test");
        questionaryPage.QuestionaryFieldName();
        questionaryPage.QuestionaryFieldSurname();
        LoggerClass.info("Finished Questionary Name And Surname test");
    }
    @Test
    public void questionaryGenderOptionOneTest(){
        LoggerClass.info("Starting Questionary Gender test");
        LoggerClass.info("Selecting female");
        questionaryPage.QuestionaryGenderOptionOne();
    }
    @Test
    public void questionaryGenderOptionTwoTest(){
        LoggerClass.info("Selecting male");
        questionaryPage.QuestionaryGenderOptionTwo();
    }
    @Test
    public void questionaryAgeOptionTest(){
        test.log(Status.INFO, "Starting Questionary Age test");

        test.log(Status.INFO, "Select less than 15");
        LoggerClass.info("Starting Questionary Age test");
        LoggerClass.info("Selecting less than 15");
        questionaryPage.QuestionaryFieldAge015();
        LoggerClass.info("Selecting 15-19");
        questionaryPage.QuestionaryFieldAge1519();
        LoggerClass.info("Selecting 20-29");
        questionaryPage.QuestionaryFieldAge2029();
        LoggerClass.info("Selecting 30-39");
        questionaryPage.QuestionaryFieldAge3039();
        LoggerClass.info("Selecting 40-60");
        questionaryPage.QuestionaryFieldAge4060();
        LoggerClass.info("Selecting more than 60");
        questionaryPage.QuestionaryFieldAge60100();
    }
    @Test
    public void questionaryProductOptionTest(){
        LoggerClass.info("Starting Product selection");
        LoggerClass.info("Selecting Shirt");
        questionaryPage.QuestionaryFieldShirt();
        LoggerClass.info("Selecting Shores");
        questionaryPage.QuestionaryFieldShoes();
        LoggerClass.info("Selecting Bag");
        questionaryPage.QuestionaryFieldBag();
        LoggerClass.info("Selecting Ball");
        questionaryPage.QuestionaryFieldBall();
        LoggerClass.info("Selecting Other");
        questionaryPage.QuestionaryFieldOther();
        LoggerClass.info("Putting what otker in text area...");
        questionaryPage.QuestionaryFieldOtherTextArea();

    }
    @Test
    public void questionarySelectOptionTest(){
        LoggerClass.info("Starting Select Option");
        questionaryPage.QuestionaryOptionSelectSport();
        LoggerClass.info("Selecting Football");
        questionaryPage.QuestionarySelectFootBall();
        LoggerClass.info("Selecting Volleyball");
        questionaryPage.QuestionarySelectVolleyBall();
    }
    @Test
    public void questionaryDateInput(){
        LoggerClass.info("Starting Questionary Data Picker Test");
        questionaryPage.QuestionaryDataPickerFormClear();
        questionaryPage.QuestionaryDateInput("11-11-2024");
    }

}
