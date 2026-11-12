package test_bases;

import data_reader.Load_Properties;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import static drivers_and_browsers_setup.Web_Driver_Manager.*;

import org.testng.annotations.*;
import java.io.File;

public abstract class TestBase {

    /************************************OBJECTS_DECLARATIONS/INSTANTIATIONS*****************************/
    protected WebDriver web_Driver;

    /*****************************************ENVIRONMENT_DATA***********************************************/
    protected final String url = Load_Properties.environment_Data.getProperty("ebay_url");
    private final static String browser_Name = Load_Properties.environment_Data.getProperty("browser_Name");

    /***********************************************METHODS**************************************************/
    @SneakyThrows
    @BeforeSuite(alwaysRun = true)
    public void setUp_Suite()
    {
        FileUtils.deleteDirectory(new File("Screenshots"));
        FileUtils.deleteDirectory(new File("allure-results"));
        FileUtils.deleteDirectory(new File("allure-report"));
    }
    @Parameters({"browser_Name"})
    public void setUp_Environment()
    {
        web_Driver = create_WebDriver_Instance(browser_Name);
        web_Driver.get(url);
    }

    @AfterMethod(alwaysRun = true)
    public void clearUp_Environment()
    {
        if(web_Driver != null)
        {
            web_Driver.quit();
            web_Driver = null;
        }
        web_Driver_Thread.remove();
    }
}
