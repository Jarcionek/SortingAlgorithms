package sorts;

public abstract class SortingAlgorithm {
	abstract public void sort(int[] array);

	protected void swap(int[] array, int i, int j) {
		int t = array[i];
		array[i] = array[j];
		array[j] = t;
	}
}
