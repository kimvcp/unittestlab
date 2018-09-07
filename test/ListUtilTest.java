import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Test methods for ListUtil class using JUnit 4.
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
		assertEquals(4, ListUtil.countUnique(temp));
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
}
