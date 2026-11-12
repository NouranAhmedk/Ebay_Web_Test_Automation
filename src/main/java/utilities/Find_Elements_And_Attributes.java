package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import static utilities.Js_Injection.scrollTo_Highlight;
import static utilities.Waits.wait_Element_Presence_In_DOM_Only;
import static utilities.Waits.wait_Element_Visibility_In_DOM_And_UI;

public class Find_Elements_And_Attributes {

    /**
     * Waits until the element is visible, scrolling it into view first.
     * If it never becomes visible, falls back to presence in the DOM.
     * @param locator locator carrying a By selector
     * @return the located element
     */
    public static WebElement find_Element(By locator)
    {
        scrollTo_Highlight(locator,"yellow");
        try {
            return wait_Element_Visibility_In_DOM_And_UI(locator,30);
        }
        catch (TimeoutException e)
        {
            return wait_Element_Presence_In_DOM_Only(locator,30);
        }
    }
}
