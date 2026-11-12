package utilities;

import org.openqa.selenium.By;

import static utilities.Find_Elements_And_Attributes.find_Element;
import static utilities.Js_Injection.js_Click;
import static utilities.Js_Injection.scrollTo_Highlight;
import static utilities.Waits.wait_Element_Clickable;

public class User_Actions {

    /******************************************USER_ACTIONS**************************************/
    /**
     * 1) Waits up to 60 seconds for the element to be present in the DOM, then scrolls the webpage so the element is
     * centered in the window and sets its background-color to green.
     * 2) try code; waits up to 40 seconds for the element to be clickable (visible & enabled), then clicks it exactly as
     * shown on the UI.
     * 3) catch code; if the element is not clickable in time or the native click fails (e.g. covered by an overlay or
     * has style-property as opacity of value 0), clicks it from the DOM using JS and prints the failure reason.
     * @param locator the By locator of the target element
     */
    public static void click_WebElement(By locator)
    {
        scrollTo_Highlight(locator, "green");
        try {
            wait_Element_Clickable(locator, 40).click();
        }
        catch (Exception e) {
            js_Click(locator);
            System.out.println("Click failed (" + e.getClass().getSimpleName() + "), using JS click on " + locator);
        }
    }

    /**
     * 1) Uses find_Element() which waits for element visibility (up to 30 seconds).
     * 2) If visible, the webpage will be scrolled to the target element, and will have background-color as yellow &
     * borders as black.
     * 3) Send text to the Target element.
     * @param locator the By locator of the target element
     * @param text the text that shall be written in the target element
     */
    public static void write_Text(By locator, String text)
    {
        scrollTo_Highlight(locator,"yellow");
        find_Element(locator).sendKeys(text);
    }

    public static String get_Text(By locator)
    {
        return find_Element(locator).getText();
    }

}
