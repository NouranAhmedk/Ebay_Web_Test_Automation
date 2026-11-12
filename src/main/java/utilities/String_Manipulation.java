package utilities;

public class String_Manipulation {

    public static String replace_String_With_Regex(String to_Be_Replaced_Within, String regex, String replacement)
    {
        return to_Be_Replaced_Within.replaceAll(regex, replacement);
    }
}
