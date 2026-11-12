package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;

import static drivers_and_browsers_setup.Web_Driver_Manager.get_Web_Driver;
import static utilities.Waits.wait_Element_Presence_In_DOM_Only;

public class Js_Injection {

    private static JavascriptExecutor js;

    /**
     * Clicks an element from the DOM when a native click fails, for example when an overlay covers it.
     * @param locator By locator of the target element
     */
    public static void js_Click(By locator)
    {
        js = (JavascriptExecutor) get_Web_Driver();
        js.executeScript("arguments[0].focus()", wait_Element_Presence_In_DOM_Only(locator, 60));
        js.executeScript("arguments[0].click()", wait_Element_Presence_In_DOM_Only(locator, 60));
    }

    public static void js_Scroll_View_Element_Center_With_Window(By locator)
    {
        js = (JavascriptExecutor) get_Web_Driver();

        Point coordinates = wait_Element_Presence_In_DOM_Only(locator, 60).getLocation();
        int x = coordinates.getX();
        int y = coordinates.getY();

        Dimension dims = get_Web_Driver().manage().window().getSize();
        int windowWidth = dims.getWidth();
        int windowHeight = dims.getHeight();

        js.executeScript("window.scrollTo(" + (x - windowWidth / 2) + "," + (y - windowHeight / 2) + ");");
    }

    public static void js_Highlight_Element(By locator, String color)
    {
        js = (JavascriptExecutor) get_Web_Driver();
        js.executeScript("arguments[0].style.background = '" + color + "'", wait_Element_Presence_In_DOM_Only(locator, 60));
    }

    public static void scrollTo_Highlight(By locator, String color)
    {
        js_Scroll_View_Element_Center_With_Window(locator);
        js_Highlight_Element(locator, color);
    }
}
