package java8.ocp.sg2.chapter7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteExample {
	public static void main(String[] args) {

		List<Integer> listA = new ArrayList<>(Arrays.asList(1, 2, 3));

		for (Integer item : listA) {
			System.out.print(item + " ");
			// listA.add(9); // produces
			// java.util.ConcurrentModificationException runtime exception
		}

		System.out.println();

		List<Integer> list = new CopyOnWriteArrayList<>(Arrays.asList(4, 3, 52));
		for (Integer item : list) { // only those elements in the collection at
									// the time the for() loop was created were
									// accessed
			System.out.print(item + " ");
			list.add(9);
		}
		System.out.println();
		System.out.println("Size: " + list.size());

		for (Integer item : list) {
			System.out.print(item + " ");
			list.add(10);
		}
		System.out.println();
		System.out.println("Size: " + list.size());

		for (Integer item : list) {
			System.out.print(item + " ");
		}
		System.out.println();
		System.out.println("Size: " + list.size());

		/*
		 * The CopyOnWrite classes can use a lot of memory, since a new
		 * collection structure needs be allocated anytime the collection is
		 * modifi ed. They are commonly used in multi-threaded environment
		 * situations where reads are far more common than writes.
		 */

	}
}
