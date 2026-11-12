package drivers_and_browsers_setup;

import org.openqa.selenium.WebDriver;

import static drivers_and_browsers_setup.Browser_Factory.get_Configured_Browser;

public class Web_Driver_Manager {
/*************OBJECTS_DECLARATIONS/INSTANTIATIONS**********/

    public static ThreadLocal<WebDriver> web_Driver_Thread = new ThreadLocal<>();

/************PREPARE_INSTANCE_METHODS*************/

    /**
     * Will be ThreadLocal explanation
     *
     * @param driver
     */
    public static void set_Web_Driver(WebDriver driver) {
        web_Driver_Thread.set(driver);
    }

    public static WebDriver get_Web_Driver() {
        return web_Driver_Thread.get();
    }

    public static WebDriver create_WebDriver_Instance(String browser_Name) {
        set_Web_Driver(get_Configured_Browser(browser_Name));
        return get_Web_Driver();
    }
}
