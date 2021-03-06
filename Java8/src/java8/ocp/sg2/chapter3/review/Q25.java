package java8.ocp.sg2.chapter3.review;

import java.util.HashMap;
import java.util.Map;

public class Q25 {

	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(1, 10);
		map.put(2, 20);
		map.put(3, null);
		System.out.println(map);


		map.merge(1, 3, (a,b) -> a + b);

		System.out.println(map);


		map.merge(3, 3, (a,b) -> a + b);
		System.out.println(map);



	}

}
