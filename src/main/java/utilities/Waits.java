package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static drivers_and_browsers_setup.Web_Driver_Manager.get_Web_Driver;

public class Waits {

    private static WebDriverWait wait;

    /**
     * Using presenceOfElementLocated() assures that an element is present on the DOM of a page,
     * but not necessarily visible in the UI.
     * @param locator the By locator of the target element
     */
    public static WebElement wait_Element_Presence_In_DOM_Only(By locator, int seconds)
    {
        wait = new WebDriverWait(get_Web_Driver(), Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * Using visibilityOfElementLocated() assures that an element is present on the DOM of a page
     * and visible in the UI.
     * @param locator the By locator of the target element
     * @param seconds timeout in seconds
     */
    public static WebElement wait_Element_Visibility_In_DOM_And_UI(By locator, int seconds)
    {
        wait = new WebDriverWait(get_Web_Driver(),Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement wait_Element_Clickable(By locator, int seconds)
    {
        wait = new WebDriverWait(get_Web_Driver(), Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
