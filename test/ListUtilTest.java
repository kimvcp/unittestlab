import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Test methods for ListUtil class using JUnit.
 *
 * @author Vichaphol Thamsuthikul
 *
 */
public class ListUtilTest {
	/** A small tolerance for floating point round-off (precision) error. */
	static final double TOL = 1.0E-6;

	@Test
	public void testEmptyList() {
		List<?> temp = new ArrayList<>();
		assertEquals(0, ListUtil.countUnique(temp));
	}

	@Test
	public void testTypicalList() {
		List<?> temp = Arrays.asList("a", "a", "b", "c", "d");
		List<?> temp2 = Arrays.asList(12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12);
		assertEquals(4, ListUtil.countUnique(temp), TOL);
		assertEquals(1, ListUtil.countUnique(temp2), TOL);

	}

	@Test(expected = NullPointerException.class)
	public void testNullList() {
		List<?> temp = null;
		ListUtil.countUnique(temp);
	}

	@Test
	public void testHugeList() {
		String[] text = new String[99];
		for (int i = 0; i < text.length; i++) {
			text[i] = i * 99 + "";
		}
		List<String> temp = new ArrayList<String>();
		temp.addAll(Arrays.asList(text));
		assertEquals(99, ListUtil.countUnique(temp), TOL);
	}

	// Test binarySearch methods

	@Test
	public void testEmptyArray() {
		String[] number = {};
		int index = ListUtil.binarySearch(number, "");
		assertEquals(-1, index, TOL);
	}

	@Test
	public void testNoElementArray() {
		String[] text = { "a", "b", "c" };
		assertEquals(-1, ListUtil.binarySearch(text, "defg"), TOL);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNullElement() {
		Integer[] array = { 1, 2 };
		int index = ListUtil.binarySearch(array, null);
	}

	@Test
	public void testSortedArray() {
		Integer[] number = { 5, 4, 3, 2, 1, 0 };
		for (int i = 0; i < number.length; i++) {
			assertEquals(i, ListUtil.binarySearch(number, i), TOL);
		}
	}

	@Test
	public void testHugeArray() {
		String[] text = new String[999];
		for (int i = 0; i < text.length; i++) {
			text[i] = i + "";
		}
		assertEquals(998, ListUtil.binarySearch(text, "998"));
	}

}
