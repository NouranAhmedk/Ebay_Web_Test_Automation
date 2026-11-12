package web_pages.home_page;

import io.qameta.allure.Step;

import static utilities.Common_Assertions.*;
import static utilities.User_Actions.*;

public class Home_Actions extends Home_Locators {

    /****************************************ACTIONS*********************************************/
    @Step("Click on the search bar")
    public void click_On_Search_Bar() {
        click_WebElement(search_Txt);
    }

    @Step("Enter the search item")
    public void enter_The_Search_Item(String search_Item) {
        write_Text(search_Txt, search_Item);
    }

    @Step("Click on Search button")
    public void click_Search_Btn(){
        click_WebElement(search_Btn);
    }

    @Step("Search for item: {search_Item}")
    public void search_For_Item(String search_Item) {
        click_On_Search_Bar();
        enter_The_Search_Item(search_Item);
        click_Search_Btn();
    }

    /**********************************************ASSERTIONS****************************************/
    @Step("validate the redirection to home page")
    public void validate_Redirect_To_Home_Page()
    {
        softAssert_Element_Is_Displayed(logo_Link, "Redirected to home webpage assertion.");
    }

    @Step("Validate the current URL contains the home URL")
    public void validate_The_Current_Url_Contains_The_Home_Url(String home_Url)
    {
        softAssert_Current_Url_Contains_Expected_Url(home_Url, "Home page URL assertion.");
    }
}
