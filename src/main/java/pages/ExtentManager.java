package pages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;
    //metody
    public static ExtentReports getInstance(){
        if (extent == null){
            extent = createInstance("testReportExtent.html");
        }
        return extent;
    }
    private static ExtentReports createInstance(String fileName){
        ExtentSparkReporter reporter = new ExtentSparkReporter(fileName);
        reporter.config().setDocumentTitle("Test Report");
        reporter.config().setReportName("TTest Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        return extent;
    }
}
