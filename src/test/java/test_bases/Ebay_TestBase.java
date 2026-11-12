package test_bases;

import static data_reader.Load_Properties.*;
import org.testng.annotations.BeforeMethod;

public class Ebay_TestBase extends TestBase {

    protected String search_Item;

    @BeforeMethod(alwaysRun = true)
    public void set_Data_And_Environment_Home() {
        setUp_Environment();
        search_Item = Home_Module_Data.getProperty("search_Item");
    }
}
