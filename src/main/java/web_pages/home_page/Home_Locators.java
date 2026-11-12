package web_pages.home_page;

import org.openqa.selenium.By;

public class Home_Locators {
    /****************************************WEB-ELEMENTS*********************************************/
    /**
     * Names-Suffix Notes:
     * <li>Txt:TextBox;
     * <li> Btn:Button;
     */
    protected By search_Txt = By.cssSelector("input[title='Search']");
    protected By logo_Link = By.cssSelector("a[href='https://www.ebay.com']");
    protected By search_Btn = By.cssSelector("button[value='Search']");


}
