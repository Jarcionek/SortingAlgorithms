package sorts;

public class MergeSort extends SortingAlgorithm {

	@Override
	public void sort(int[] array) {
		System.arraycopy(split(array), 0, array, 0, array.length);
	}

	private int[] split(int[] array) {
		int halfOne = array.length / 2;
		int halfTwo = array.length / 2 + (array.length & 1);

		int[] one = copyOf(array, 0, halfOne);
		int[] two = copyOf(array, halfOne, halfTwo);

		if (one.length > 1) {
			one = split(one);
		}
		if (two.length > 1) {
			two = split(two);
		}
		return merge(one, two);
	}

	private int[] copyOf(int[] array, int srcPosition, int length) {
		int[] copy = new int[length];
		System.arraycopy(array, srcPosition, copy, 0, length);
		return copy;
	}

	private int[] merge(int[] one, int[] two) {
		int[] result = new int[one.length + two.length];
		int i = 0;
		int j = 0;
		for (int k = 0; k < result.length; k++) {
			if (i == one.length) {
				result[k] = two[j++];
			} else if (j == two.length) {
				result[k] = one[i++];
			} else if (one[i] < two[j]) {
				result[k] = one[i++];
			} else {
				result[k] = two[j++];
			}
		}
		return result;
	}

}
