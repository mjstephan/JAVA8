package java8.ocp.sg2.chapter3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DiamondOperator {
	public static void main(String[] args) {

		List namesJava5 = new ArrayList();
		List<String> namesJava7 = new ArrayList<String>();
		List<String> namesJava8 = new ArrayList<>();

		HashMap<String, HashMap<String, String>> map1 = new HashMap<String, HashMap<String, String>>();

		// Java 8
		HashMap<String, HashMap<String, String>> map2 = new HashMap<>();

	}
}
