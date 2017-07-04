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
		
		Set<Number> numbers = new HashSet<>();
		numbers.add(new Integer(86)); //[86]
		numbers.add(75); //
		numbers.add(new Integer(86));
		numbers.add(null);
		numbers.add(309L);
		Iterator iter = numbers.iterator();
		while (iter.hasNext())
			System.out.print(iter.next());

	}

}
