package sorts;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static utils.Matchers.sameArrayAs;
import static utils.Matchers.sortedArray;

public abstract class BaseTest {

	private static final int TIMEOUT = 100;

	protected SortingAlgorithm sortingAlgorithm;

	@Test(timeout = TIMEOUT)
	public void doesNotFailWhenArrayIsEmpty() {
		assertThat(sorted(array()), is(sameArrayAs(array())));
	}

	@Test(timeout = TIMEOUT)
	public void doesNotFailWhenArrayHasLengthOne() {
		assertThat(sorted(array(1)), is(sameArrayAs(array(1))));
	}

	@Test(timeout = TIMEOUT)
	public void doesNotChangeAlreadySortedArrayOfLengthTwo() {
		assertThat(sorted(array(1, 2)), is(sameArrayAs(array(1, 2))));
	}

	@Test(timeout = TIMEOUT)
	public void sortsArrayOfLengthTwo() {
		assertThat(sorted(array(2, 1)), is(sameArrayAs(array(1, 2))));
	}

	@Test(timeout = TIMEOUT)
	public void sortsArrayOfLengthThree() {
		assertThat(sorted(array(3, 2, 1)), is(sameArrayAs(array(1, 2, 3))));
	}

	@Test(timeout = TIMEOUT)
	public void sortsArrayOfLengthEight() {
		assertThat(sorted(array(8, 7, 6, 5, 4, 3, 2, 1)), is(sameArrayAs(array(1, 2, 3, 4, 5, 6, 7, 8))));
	}

	@Test(timeout = TIMEOUT)
	public void sortsArrayOfLengthElevenWithRepeatingElements() {
		assertThat(sorted(array(7, 4, 9, 4, 6, 2, 1, 4, 6, 2, 5)), is(sameArrayAs(array(1, 2, 2, 4, 4, 4, 5, 6, 6, 7, 9))));
	}

	@Test(timeout = TIMEOUT)
	public void sortsArrayOfLengthTwelveWithRepeatingElements() {
		assertThat(sorted(array(7, 4, 9, 4, 6, 5, 0, 1, 4, 6, 2, 2)), is(sameArrayAs(array(0, 1, 2, 2, 4, 4, 4, 5, 6, 6, 7, 9))));
	}

	@Test(timeout = 50 * TIMEOUT)
	public void sortsOneThousandRandomArrays() {
		for (int i = 0; i < 1000; i++) {
			int[] randomArray = randomArray();

			int[] algorithmSorted = Arrays.copyOf(randomArray, randomArray.length);
			sorted(algorithmSorted);

			int[] correctlySorted = Arrays.copyOf(randomArray, randomArray.length);
			Arrays.sort(correctlySorted);

			if (!sortedArray().matches(algorithmSorted)) {
				System.out.println(Arrays.toString(randomArray));
			}
			assertThat(algorithmSorted, is(sameArrayAs(correctlySorted)));
		}
	}

	private int[] randomArray() {
		int length = new Random().nextInt(100);
		int[] array = new int[length];
		for (int i = 0; i < array.length; i++) {
			array[i] = new Random().nextInt(150) - 50;
		}
		return array;
	}

	private int[] sorted(int[] array) {
		sortingAlgorithm.sort(array);
		return array;
	}

	private int[] array(int... elements) {
		return elements;
	}

}
