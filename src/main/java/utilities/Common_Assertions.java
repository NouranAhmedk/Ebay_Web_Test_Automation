package utilities;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static utilities.Data_Types_Conversions.convert_String_To_Integer;
import static utilities.Find_Elements_And_Attributes.find_Element;
import static utilities.Js_Injection.scrollTo_Highlight;
import static utilities.String_Manipulation.replace_String_With_Regex;
import static utilities.User_Actions.get_Text;
import static utilities.Window_Navigation.get_Current_Url;

public class Common_Assertions {

    /**********************************************DECLARATIONS/INSTANTIATIONS*******************************************************/
    public static SoftAssert soft_Assert = new SoftAssert();

    /******************************************HARD_ASSERTIONS*************************************/
    /**
     * This method asserts that a web element located by the given locator is displayed on the UI, neglecting
     * its "style" attribute to be parsed
     *
     * @param locator           The By locator of the target web element.
     * @param assertion_Message The message to be displayed if the assertion fails.
     */
    public static void assert_WebElement_Is_Displayed(By locator, String assertion_Message)
    {
        scrollTo_Highlight(locator,"yellow");
        Assert.assertTrue(find_Element(locator).isDisplayed(),assertion_Message);
    }

    public static void assert_Current_Url_Contains_Expected_Url(String expected_Url, String assertion_Message)
    {
        Assert.assertTrue(get_Current_Url().contains(expected_Url), assertion_Message);
    }

    public static void assert_Actual_Text_Contains_Expected_Text(String text, By actual_Text_Locator, String assertion_Message)
    {
        Assert.assertTrue(get_Text(actual_Text_Locator).contains(text),assertion_Message);
    }

    public static void assert_Actual_Number_Value_Is_Greater_Than_Zero(By locator, String assertion_Message)
    {
        int actual_Number = convert_String_To_Integer(replace_String_With_Regex(get_Text(locator), "[^0-9]", ""));
        Assert.assertTrue(actual_Number > 0, assertion_Message);
    }

    /******************************************SOFT_ASSERTIONS*************************************/
    public static void softAssert_Element_Is_Displayed(By locator, String assertion_Message)
    {
        soft_Assert.assertTrue(find_Element(locator).isDisplayed(),assertion_Message);
    }

    public static void softAssert_Current_Url_Contains_Expected_Url(String expected_Url, String assertion_Message)
    {
        soft_Assert.assertTrue(get_Current_Url().contains(expected_Url), assertion_Message);
    }

    public static void softAssert_Actual_Text_Contains_Expected_Text(String text, By actual_Text_Locator, String assertion_Message)
    {
        soft_Assert.assertTrue(get_Text(actual_Text_Locator).contains(text),assertion_Message);
    }

    public static void softAssert_Actual_Number_Value_Is_Greater_Than_Zero(By locator, String assertion_Message)
    {
        int actual_Number = convert_String_To_Integer(replace_String_With_Regex(get_Text(locator), "[^0-9]", ""));
        soft_Assert.assertTrue(actual_Number > 0, assertion_Message);
    }

    /**
     * Evaluates all accumulated soft assertions and resets the {@code soft_Assert} instance
     * for the next test. Must be called at the end of any test that uses soft assertions.
     *
     * <p>{@code assertAll()} throws an {@link AssertionError} when any soft assertion has failed.
     * If the reset were written as a sequential statement after {@code assertAll()}, it would
     * never execute on failure — the exception propagates up and skips it, leaving
     * {@code soft_Assert} full of stale assertions that bleed into the next test.
     * The {@code try/finally} guarantees the reset runs regardless of whether
     * {@code assertAll()} throws or not.</p>
     */
    public static void softAssert_Validate_All_SoftAssertions()
    {
        try {
            soft_Assert.assertAll();
        } finally {
            soft_Assert = new SoftAssert();
        }
    }
}
