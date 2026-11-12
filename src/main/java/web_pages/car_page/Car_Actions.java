package web_pages.car_page;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;

import static utilities.Common_Assertions.*;
import static utilities.Logs_Implementation.info;
import static utilities.User_Actions.click_WebElement;
import static utilities.User_Actions.get_Text;


public class Car_Actions extends Car_Locators {

  /****************************************ACTIONS*********************************************/
  @Step("Click \"Transmission\" dropdown")
  public void click_Transmission_DDL() {
    click_WebElement(transmission_DDL);
  }

  @Step("Click \"Manual\" checkbox")
  public void click_Manual_Checkbox() {
    click_WebElement(manual_CHK);
  }

  /****************************************LOGGING*********************************************/
  @Step("Log the number of obtained search results")
  public void log_Search_Results_Count() {
    String results_Count = get_Text(result_Count).trim();
    info("Number of search results obtained:", results_Count);
    Allure.step("Number of search results obtained: " + results_Count);
  }

  /****************************************ASSERTIONS****************************************/
  @Step("Validate the header of the title of the page displayed")
  public void validate_The_Header_Of_The_Title_Of_Page_Is_Displayed() {
    softAssert_Element_Is_Displayed(header_Name,"Header of the page is displayed assertion");
  }

  @Step("Validate the header contains the search item")
  public void validate_The_Header_Contains_The_Search_Item(String search_Item) {
    softAssert_Actual_Text_Contains_Expected_Text(search_Item, header_Name, "Results heading contains the search item assertion");
  }

  @Step("Validate the number of search results is greater than zero")
  public void validate_The_Search_Results_Count_Is_Greater_Than_Zero() {
    softAssert_Actual_Number_Value_Is_Greater_Than_Zero(result_Count, "Search results count is greater than zero assertion");
  }

  @Step("Validate Manual transmission filter is applied")
  public void validate_Manual_Transmission_Filter_Applied() {
   softAssert_Element_Is_Displayed(Manual_filter,"Manual transmission filter assertion");
  }
}
