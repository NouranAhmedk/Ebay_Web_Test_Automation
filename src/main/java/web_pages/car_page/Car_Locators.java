package web_pages.car_page;

import org.openqa.selenium.By;

public class Car_Locators {

    /****************************************WEB-ELEMENTS*********************************************/
    /**
     * Names-Suffix Notes:
     * <li>Txt:TextBox;
     * <li>Btn:Button;
     * <li>DDL:Dropdown;
     * <li>CHK:Checkbox;
     */
    protected By header_Name = By.id("srp-results-heading");
    protected By result_Count = By.xpath("//h1/span[1]");
    protected By transmission_DDL = By.xpath("(//details/summary/span[1])[3]");
    protected By manual_CHK = By.xpath("((//details)[3]//span)[3]");
    protected By Manual_filter = By.xpath("//ul[@class='carousel__list']/li/div/a/div[text()='Manual']");
}
