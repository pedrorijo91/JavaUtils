package pt.utils.string;

import java.util.List;

public class StringUtils {

    public static String removeWhiteSpace(String string) {
        return string.replaceAll("\\s+", "");
    }

    public static String makeString(List<Object> list, String sep) {

        Object[] array = list.toArray(new Object[0]);
        return makeString(array, sep);
    }


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
    
    
    public static String removeLastChar(String s) {
        if (s != null) {
            s = s.substring(0, s.length() - 1);
        }
        return s;
    }
}
