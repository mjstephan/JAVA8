/**
 *
 */
package java8.ocp.sg2.chapter3.review;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author pche0001
 *
 */
public class Q7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Set<Number> numbers = new HashSet<>(); // unordered unique values
		System.out.println(numbers.add(new Integer(86)));
		System.out.println(numbers.add(75)); //
		System.out.println(numbers.add(new Integer(86))); // returns false
		System.out.println(numbers.add(null));
		System.out.println(numbers.add(309L));
		Iterator<Number> iter = numbers.iterator();
		while (iter.hasNext())
			System.out.print(iter.next());

	}

}
