package java8.ocp.sg2.chapter3;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class GenericMethodsExample {

	public static <T> Crate<T> ship(T t) { // The method parameter is the
											// generic type T. The return type
											// is a Crate<T>. Before the return
											// type, we declare the formal type
											// parameter of <T>.
		System.out.println("Preparing " + t);
		return new Crate<T>();
	}

	public static <T> void sink(T t) {
	}

	public static <T> T identity(T t) {
		return t;
	}

	public static T noGood(T t) {
		return t;
	} // DOES NOT COMPILE omits the formal parameter type, and therefore it does not compile.


	public static void main(String[] args) {

		//Optional Syntax for Invoking a Generic Method
		// call a generic method normally
		GenericMethodsExample.identity("PETE");
		GenericMethodsExample.identity(Arrays.asList(new String[]{"q", "r", "s"}));
		// or you can specify the type explicitly to make it obvious what the type is
		GenericMethodsExample.<String>identity("PETE");
		GenericMethodsExample.<List<String>>identity(Arrays.asList(new String[]{"q", "r", "s"}));


	}



}
