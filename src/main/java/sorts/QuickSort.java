package sorts;

public class QuickSort extends SortingAlgorithm {

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
