package java8.ocp.sg2.chapter3.review;

import java.util.Arrays;
import java.util.Comparator;

public class Q10 {

	public class MyComparator implements Comparator<String> {
		public int compare(String a, String b) {

			int comparisonResult = b.toLowerCase().compareTo(a.toLowerCase());
	        System.out.println("The result of the comparison was " + comparisonResult);

	        System.out.print("This means that \"" + a.toLowerCase() + "\" ");
	        if(comparisonResult < 0){
	            System.out.println("lexicographically precedes \"" + b.toLowerCase() + "\".");
	        }else if(comparisonResult > 0){
	            System.out.println("lexicographically follows \"" + b.toLowerCase() + "\".");
	        }else{
	            System.out.println("equals \"" + b.toLowerCase() + "\".");
	        }
	        System.out.println();



		//	System.out.println("Comparing "+ b.toLowerCase() + " to " + a.toLowerCase());
		//	System.out.println(b.toLowerCase().compareTo(a.toLowerCase()));

			return comparisonResult;
			//return b.toLowerCase().compareTo(a.toLowerCase());
		}
	}

	public static void main(String[] args) {
		String[] values = { "123", "Abb", "aab" };
		Arrays.sort(values, new Q10().new MyComparator());
		for (String s : values)
			System.out.print(s + " "); // Abb, aab 123
	}

}
