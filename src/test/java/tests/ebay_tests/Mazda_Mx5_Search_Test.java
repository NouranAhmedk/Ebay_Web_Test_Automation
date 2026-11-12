package tests.ebay_tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import listeners.IRetryAnalyzer_Listener;
import org.testng.annotations.Test;
import test_bases.Ebay_TestBase;
import web_pages.car_page.Car_Actions;
import web_pages.home_page.Home_Actions;

import static utilities.Common_Assertions.softAssert_Validate_All_SoftAssertions;

public class Mazda_Mx5_Search_Test extends Ebay_TestBase {

    /**********************************OBJECTS_DECLARATIONS/INSTANTIONS*******************************************/
    private Home_Actions ha;
    private Car_Actions ca;

    /****************************************TEST_CASES**********************************************************/
    @Feature("Mazda MX-5 Search")
    @Description("Search Mazda MX-5, log results count, and filter Transmission to Manual")
    @Test(testName = "Search Mazda MX-5, Log Results Count, And Filter Transmission To Manual", groups = {"Regression"} ,retryAnalyzer = IRetryAnalyzer_Listener.class)
    public void search_Mazda_Mx5_Log_Results_Count_And_Filter_Transmission_To_Manual()
    {
        ha = new Home_Actions();
        ca = new Car_Actions();

        ha.validate_Redirect_To_Home_Page();
        ha.validate_The_Current_Url_Contains_The_Home_Url(url);
        ha.search_For_Item(search_Item);
        ca.validate_The_Header_Of_The_Title_Of_Page_Is_Displayed();
        ca.validate_The_Header_Contains_The_Search_Item(search_Item);
        ca.validate_The_Search_Results_Count_Is_Greater_Than_Zero();
        ca.log_Search_Results_Count();
        ca.click_Transmission_DDL();
        ca.click_Manual_Checkbox();
        ca.validate_Manual_Transmission_Filter_Applied();
        softAssert_Validate_All_SoftAssertions();
    }
}
