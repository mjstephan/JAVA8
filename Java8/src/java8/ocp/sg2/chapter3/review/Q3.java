package java8.ocp.sg2.chapter3.review;

import java.util.ArrayList;
import java.util.List;

public class Q3 {

	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("one");
		list.add("two");
		list.add(7);
		 for (String s: list)
		 System.out.print(s);

	}

}
