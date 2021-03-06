/**
 *
 */
package java8.ocp.sg2.chapter3.review;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author pche0001
 *
 */
public class Q23 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			List<String> list = new ArrayList<>();

			list.add("Pete");
			list.add("Amar");
			list.add("Matt");
			list.add("Nancy");
			list.add("Mark");
			System.out.println(list);

			list.removeIf(s -> s.startsWith("M"));

			System.out.println(list);

			Comparator<String> c = (s1, s2) -> s1.compareTo(s2);

			Collections.sort(list, c);

			System.out.println(list);




	}

}
