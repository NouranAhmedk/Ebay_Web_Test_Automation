package drivers_and_browsers_setup;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Browser_Factory {

    /**
     * Prepare browser-options for each browser that we may test on, then return an instance of the browser-driver
     * that contains all the browser-options that I set to be used to control the automated browser.
     * @param browser_Name is sent either from .xml file OR can be sent as a parameter from TestBase which has its
     * value called from environment.properties file.
     * @return browser-driver instance
     */

    public static WebDriver get_Configured_Browser(String browser_Name)
    {
        switch(browser_Name.toLowerCase())
        {
            case "chrome" -> {
                ChromeOptions chrome_Options = new ChromeOptions();
                chrome_Options.setPageLoadStrategy(PageLoadStrategy.EAGER);
                chrome_Options.addArguments(
                        "--disable-extensions",
                        "--disable-dev-shm-usage",
                        "--disable-popup-blocking",
                        "--start-maximized"
                );
                return new ChromeDriver(chrome_Options);
            }
            case "firefox" -> {
                FirefoxOptions firefox_Options = new FirefoxOptions();
                firefox_Options.addArguments(
                        "--disable-extensions",
                        "--disable-dev-shm-usage",
                        "--disable-popup-blocking",
                        "--start-maximized"
                );
                firefox_Options.setPageLoadStrategy(PageLoadStrategy.EAGER);
                return new FirefoxDriver(firefox_Options);
            }
            case "chromeheadless" -> {
                ChromeOptions chrome_Options = new ChromeOptions();
                chrome_Options.setPageLoadStrategy(PageLoadStrategy.EAGER);
                chrome_Options.addArguments(
                        "--headless=new",
                        "--disable-extensions",
                        "--disable-gpu",
                        "--no-sandbox",
                        "--disable-dev-shm-usage",
                        "--disable-popup-blocking",
                        "--window-size=1920,1080"
                );
                return new ChromeDriver(chrome_Options);
            }
            default -> {
                EdgeOptions edge_Options = new EdgeOptions();
                edge_Options.setPageLoadStrategy(PageLoadStrategy.EAGER);
                edge_Options.addArguments(
                        "--disable-extensions",
                        "--disable-dev-shm-usage",
                        "--disable-popup-blocking",
                        "--start-maximized"
                );
                return new EdgeDriver(edge_Options);
            }
        }
    }
}
