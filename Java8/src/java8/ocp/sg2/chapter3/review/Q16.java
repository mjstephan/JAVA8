package java8.ocp.sg2.chapter3.review;

import java.util.Comparator;

public class Q16 {

	// old styleee
	Comparator<String> myComparator = new Comparator<String>() {
		@Override
		public int compare(String s1, String s2) { // compare() is in the Comparator interface, compare() takes two method parameters.
			return s1.compareTo(s2);
		}
	};


	// lambda equivalent
	Comparator<String> myStringComparator = (s1, s2) -> s1.compareTo(s2);


	/* Comparator is in the java.util package. */


	public class MyComparable implements java.lang.Comparable<String> { // Comparable is in the java.lang package (no need to import)

		String name;

		public int compareTo(String s) {
			return name.compareTo(s);
		}

	}



}
