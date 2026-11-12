package utilities;

import static drivers_and_browsers_setup.Web_Driver_Manager.get_Web_Driver;

public class Window_Navigation {

    public static String get_Current_Url()
    {
        return get_Web_Driver().getCurrentUrl();
    }
}
