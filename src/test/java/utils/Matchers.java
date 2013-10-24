package utils;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

import static utils.ArrayUtils.arrayAsString;

public class Matchers {

	public static Matcher<int[]> sameArrayAs(final int[] expected) {
		return new TypeSafeDiagnosingMatcher<int[]>() {

			@Override
			protected boolean matchesSafely(int[] actual, Description description) {
				if (actual.length != expected.length) {
					description.appendText("was " + arrayAsString(actual));
					description.appendText("\n\tlength mismatch");
					return false;
				}

				for (int i = 0; i < actual.length; i++) {
					if (expected[i] != actual[i]) {
						description.appendText("was " + arrayAsString(actual));
						description.appendText("\n\tdifferent at index " + i + ": was " + actual[i] + ", but " + expected[i] + " expected");
						return false;
					}
				}
				return true;
			}

			@Override
			public void describeTo(Description description) {
				description.appendText(arrayAsString(expected));
			}
		};
	}

	public static Matcher<int[]> sortedArray() {
		return new TypeSafeDiagnosingMatcher<int[]>() {
			@Override
			protected boolean matchesSafely(int[] actual, Description description) {
				description.appendText("was " + arrayAsString(actual));
				for (int i = 1; i < actual.length; i++) {
					if (actual[i - 1] > actual[i]) {
						description.appendText("\n\tmismatch at index " + i + ", value = " + actual[i]);
						return false;
					}
				}
				return true;
			}

			@Override
			public void describeTo(Description description) {
				description.appendText("sorted array");
			}
		};
	}

}
