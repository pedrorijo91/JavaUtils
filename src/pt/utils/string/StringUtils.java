package pt.utils.string;

import java.util.List;

public class StringUtils {

    public static String removeWhiteSpace(String string) {
        return string.replaceAll("\\s+", "");
    }

    public static String makeString(List<String> list, String sep) {

        String[] array = list.toArray(new String[0]);
        return makeString(array, sep);
    }

    public static String makeString(String[] list, String sep) {
        boolean first = true;

        StringBuilder sb = new StringBuilder();

        for (String s : list) {
            if (first) {
                sb.append(s);
                first = false;
            } else {
                sb.append(sep + s);
            }
        }

        return sb.toString();
    }

    public static String removeLastChar(String s) {
        if (s != null) {
            s = s.substring(0, s.length() - 1);
        }
        return s;
    }
}
