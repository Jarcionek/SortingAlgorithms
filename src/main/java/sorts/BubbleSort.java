package sorts;

public class BubbleSort extends SortingAlgorithm {

	@Override
	public void sort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				if (array[j] > array[i]) {
					swap(array, i, j);
				}
			}
		}
	}

}
