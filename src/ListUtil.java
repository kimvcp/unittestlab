import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * A class containing methods for practicing java.
 * 
 * @author Vichaphol Thamsuthikul
 *
 */
public class ListUtil {
	/**
	 * Count the number of distinct elements in a list. The list may be empty but
	 * not null.
	 *
	 * @param list a list of elements
	 * @return the number of distinct elements in list
	 * @throws NullPointerException if the list is null
	 */
	public static int countUnique(List<?> list) {
		if (list == null)
			throw new NullPointerException("The list must not be null");
		List<? super Object> temp = new ArrayList<>();
		for (Object obj : list) {
			if (!temp.contains(obj)) {
				temp.add(obj);
			}
		}
		return temp.size();
	}

	/**
	 * A method that searches for an element in an array, where the array or list
	 * contents are already sorted.
	 * 
	 * @param array   of the elements
	 * @param element to find the index
	 * @return index of the matching element or -1 if the search element is not in
	 *         the list/array.
	 * @throws IllegalArgumentException if the element is null
	 */
	public static <T extends Comparable<? super T>> int binarySearch(T[] array, T element) {
		if (element == null)
			throw new IllegalArgumentException("Search element must not be null");
		Collections.sort(Arrays.asList(array));
		int lower = 0;
		int upper = array.length - 1;
		int mid;
		while (lower <= upper) {
			mid = (upper + lower) / 2;
			if (array[mid].compareTo(element) > 0) {
				upper = mid - 1;
			} else if (array[mid].compareTo(element) < 0) {
				lower = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;

	}
}