package java8.ocp.sg2.chapter2;

public class NamesExample {
	public static void main(String[] args) {
	       myName((String n) -> System.out.println("My name is " + n), "Pete");
	    }

	private static void myName(Names nameInstance, String name) {
		nameInstance.sayName(name);
	}
}
