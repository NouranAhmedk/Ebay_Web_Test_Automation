package listeners;

import io.qameta.allure.Allure;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static drivers_and_browsers_setup.Web_Driver_Manager.*;


public class ITestListener_Listener implements ITestListener, IInvokedMethodListener {

    /******************************METHODS_USED_IN_LISTENER_IMPLEMENTATIONS**********************************/
    private boolean isDriverAlive() {
        try {
            WebDriver driver = get_Web_Driver();
            if(driver == null) return false;
            driver.getTitle();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @SneakyThrows
    private byte[] takeScreenShot(String pass_Or_Fail_Dir_Path, String TC_Name, String ss_Extension) {

        if(!isDriverAlive()) return null;

        LocalDateTime local_Date_Time = LocalDateTime.now();
        DateTimeFormatter date_Format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss.SSS");
        String date = date_Format.format(local_Date_Time);
        TakesScreenshot ss = (TakesScreenshot) get_Web_Driver();
        byte[] bytes = ss.getScreenshotAs(OutputType.BYTES);
        File targetFile = new File("Screenshots/" + pass_Or_Fail_Dir_Path + TC_Name + date + ss_Extension);
        FileUtils.writeByteArrayToFile(targetFile, bytes);
        return bytes;
    }

    /********************************LISTENER_IMPLEMENTATIONS************************************************/
    @SneakyThrows
    @Override
    public void onTestStart(ITestResult result)
    {
        System.out.println("Test case has started");
    }
    @Override
    @SneakyThrows
    public void onTestSuccess(ITestResult result)
    {
        Thread.sleep(1300);
        takeScreenShot("Passed_TCs_Screenshots/", result.getName(), ".png");
    }

    @Override
    @SneakyThrows
    public void onTestFailure(ITestResult result) {
        Thread.sleep(1300);
        takeScreenShot("Failed_TCs_Screenshots/", result.getName(), ".png");
    }
    @Override
    @SneakyThrows
    public void onTestSkipped(ITestResult result)
    {
        Thread.sleep(1300);
        takeScreenShot("Skipped_TCs_Screenshots/", result.getName(), ".png");
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult result) {
        if (method.isTestMethod() && result.getStatus() == ITestResult.FAILURE && isDriverAlive()) {
            byte[] bytes = ((TakesScreenshot) get_Web_Driver()).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Failed Screenshot - " + result.getName(), "image/png", new ByteArrayInputStream(bytes), ".png");
        }
    }
}
