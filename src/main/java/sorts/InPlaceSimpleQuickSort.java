package sorts;

/**
 * In-place quick sort.
 * Space complexity: O(logn)
 */
public class InPlaceSimpleQuickSort extends SortingAlgorithm {

	@Override
	public void sort(int[] array) {
		sort(array, 0, array.length - 1);
	}

	private void sort(int[] array, int left, int right) {
		if (left < right) {
			int middle = partition(array, left, right);
			sort(array, left, middle - 1);
			sort(array, middle + 1, right);
		}
	}

	private int partition(int[] array, int left, int right) {
		int middle = left;
		for (int i = left; i < right; i++) {
			if (array[i] < array[right]) {
				swap(array, i, middle++);
			}
		}
		swap(array, middle, right);
		return middle;
	}

}
