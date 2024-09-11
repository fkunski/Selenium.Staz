package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import pages.QuestionaryPage;

public class QuestionaryBase extends TestBase{
      QuestionaryPage questionaryPage;
    @BeforeClass
    public void setUp() {
        super.setUp();
        //sterowanie otwarciem URL
        driver.get(configReader.getQuestionaryURL()); //tu ma problem
        questionaryPage = PageFactory.initElements(driver, QuestionaryPage.class);
        }

//    @Attachment(value = "Screenshot", type = "image/png");
//    public byte[] takeScreenshot(){
//        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        try{
//            return FileUtils.readFileToByteArray(screenshot);
//        }catch(IOException e){
//            e.printStackTrace();
//        }
//        return new byte[0];
//    }
}
