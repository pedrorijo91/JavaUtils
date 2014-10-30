package pt.pedrorijo91.utils.string;


public class StringUtils {

	public static String removeWhiteSpace(String string) {

		return string.replaceAll("\\s+", "");
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
