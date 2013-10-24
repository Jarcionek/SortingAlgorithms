package utils;

public class ArrayUtils {
	public static String arrayAsString(int[] array) {
		String string = "[";
		for (int i = 0; i < array.length; i++) {
			string += array[i];
			if (i < array.length - 1) {
				string += ", ";
			}
		}
		return string + "]";
	}
}
