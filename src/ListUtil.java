import java.util.ArrayList;
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
		List<Object> temp = new ArrayList<>();
		for (Object obj : list) {
			if (!temp.contains(obj)) {
				temp.add(obj);
			}
		}
		return temp.size();
	}

	/**
	 * 
	 * @param array of the elements
	 * @param element to find the index
	 * @return the index of the element
	 * @throws IllegalArgumentException if the element is null
	 */
	public static <T extends Comparable<? super T>> int binarySearch(T[] array, T element) {

		return -1;

	}
}