package sorts;

import java.util.LinkedList;
import java.util.List;

/**
 * List based quick sort.
 * Space complexity: O(n)
 */
public class SimpleQuickSort extends SortingAlgorithm {

	@Override
	public void sort(int[] array) {
		List<Integer> list = new LinkedList<>();
		for (int i : array) {
			list.add(i);
		}
		list = sort(list);
		int i = 0;
		for (Integer element : list) {
			array[i++] = element;
		}
	}

	private List<Integer> sort(List<Integer> list) {
		if (list.size() < 2) {
			return list;
		}
		List<Integer> smaller = new LinkedList<>();
		List<Integer> greater = new LinkedList<>();
		final int pivot = list.remove(0);
		while (!list.isEmpty()) {
			int element = list.remove(0);
			if (element < pivot) {
				smaller.add(element);
			} else {
				greater.add(element);
			}
		}
		return concatenate(sort(smaller), list(pivot), sort(greater));
	}

	@SafeVarargs
	private final List<Integer> concatenate(List<Integer>... lists) {
		List<Integer> result = new LinkedList<>();
		for (List<Integer> list : lists) {
			while (!list.isEmpty()) {
				result.add(list.remove(0));
			}
		}
		return result;
	}

	private List<Integer> list(int element) {
		List<Integer> list = new LinkedList<>();
		list.add(element);
		return list;
	}

}
