package pt.pedrorijo91.utils.string;

/**
 * Collection of methods useful for string operations
 *
 * @author pedrorijo
 *
 */
public class StringUtils {

    /**
     * Removes whitespaces existent in the string
     *
     * @param string to remove whitespaces
     * @return the string with the whitespaces removed
     */
    public static String removeWhiteSpace(String string) {
        return string.replaceAll("\\s+", "");
    }

    /**
     * Creates a string from a list of Objects.
     * Depends on the implementation of toString() method for provided Objects
     *
     * @param list list of objects to concatenate in a string
     * @param sep separator of each object in the final string
     * @return a string containing all objects separated by provided separator
     */
    public static String makeString(Object[] list, String sep) {

        boolean first = true;

        StringBuilder sb = new StringBuilder();

        for (Object obj : list) {
            if (first) {
                sb.append(obj.toString());
                first = false;
            } else {
                sb.append(sep + obj.toString());
            }
        }

        return sb.toString();
    }

    /**
     * Removes a string last char
     *
     * @param s String to remove last char
     * @return provided string without the last char
     */
    public static String removeLastChar(String s) {

        if (s != null) {
            s = s.substring(0, s.length() - 1);
        }

        return s;
    }
}
