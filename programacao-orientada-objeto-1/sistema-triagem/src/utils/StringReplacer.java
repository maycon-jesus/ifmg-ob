package utils;

public class StringReplacer {
	public static String dbLineMaker(String originalString, String[] replacements) {
		for (int i = 0; i < replacements.length; i++) {
			originalString = originalString.replace("{" + i + "}", replacements[i]);
		}

		return originalString;
	}
}
