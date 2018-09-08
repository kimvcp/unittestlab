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

	@Test
	public void testEmptyList() {
		List<?> temp = new ArrayList<>();
		assertEquals(0, ListUtil.countUnique(temp));
	}

	@Test
	public void testTypicalList() {
		List<?> temp = Arrays.asList("a", "a", "b", "c", "d");
		List<?> temp2 = Arrays.asList(12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12);
		assertEquals(4, ListUtil.countUnique(temp));
		assertEquals(1, ListUtil.countUnique(temp2));

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
		assertEquals(99, ListUtil.countUnique(temp));
	}

	// Test binarySearch methods

	@Test
	public void testEmptyArray() {
		String[] number = {};
		int index = ListUtil.binarySearch(number, "");
		assertEquals(-1, index);
	}

	@Test
	public void testNoElementArray() {
		String[] text = { "a", "b", "c" };
		int sortArray = ListUtil.binarySearch(text, "dfg");
		assertEquals(-1, sortArray);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNullElement() {
		Integer[] array = { 1, 2 };
		int index = ListUtil.binarySearch(array, null);
	}
	
	@Test
	public void testSortedArray() {
		Integer[] number = { 3, 2, 6 };
		assertEquals(0, ListUtil.binarySearch(number, 2));
		assertEquals(1, ListUtil.binarySearch(number, 3));
		assertEquals(2, ListUtil.binarySearch(number, 6));
	}

}
