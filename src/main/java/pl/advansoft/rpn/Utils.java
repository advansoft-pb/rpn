package pl.advansoft.rpn;

import java.util.ArrayList;
import java.util.List;

public class Utils {
	public static String[] split(String text) {
		return text.split("\\s* \\s*");
	}

	public static List<Value> asValues(String[] strings) {
		List<Value> values = new ArrayList<>(strings.length);

		for (String s : strings) {
			values.add(new Value(s));
		}

		return values;
	}
}
