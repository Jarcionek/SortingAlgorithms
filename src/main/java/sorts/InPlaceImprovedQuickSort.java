package sorts;

/**
 * In-place quick sort. Reduced number of swaps compared to {@link InPlaceSimpleQuickSort}
 * Space complexity: O(logn)
 */
public class InPlaceImprovedQuickSort extends SortingAlgorithm {

	@Override
	public void sort(int[] array) {
		if (array.length > 1) {
			sort(array, 0, array.length - 1);
		}
	}

	private void sort(int[] array, final int orgLeft, final int orgRight) {
		int pivot = array[orgRight];
		int left = orgLeft;
		int right = orgRight;

		while (left <= right) {
			while (array[left] < pivot) {
				left++;
			}
			while (array[right] > pivot) {
				right--;
			}
			if (left <= right) {
				swap(array, left++, right--);
			}
		}

		if (orgLeft < right) {
			sort(array, orgLeft, right);
		}
		if (left < orgRight) {
			sort(array, right + 1, orgRight);
		}
	}

}
