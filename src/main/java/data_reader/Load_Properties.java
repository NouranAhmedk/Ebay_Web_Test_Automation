package data_reader;

import lombok.SneakyThrows;

import java.io.FileReader;
import java.util.Properties;

/**
 * @author Nouran Ahmed
 * This class is built to read data from different properties files
 */
public class Load_Properties
{

    /**
     * Loads properties from the specified file path
     * @param properties_File_Path the path to the properties file
     * @return Properties object containing the loaded properties
     */
    @SneakyThrows
    private static Properties load_Properties_Data(String properties_File_Path) {
        FileReader fr = new FileReader(properties_File_Path);
        Properties pro = new Properties();
        pro.load(fr);
        return pro;
    }

    /*=================================== CONFIG ===================================*/
    public static Properties environment_Data =
            load_Properties_Data("src/test/resources/Config/Properties/Environment_Data.properties");

    /*=================================== TEST DATA =================================*/
    public static Properties Home_Module_Data =
            load_Properties_Data("src/test/resources/Files_To_Read_From/Properties/Home_Module_Data.properties");

}
