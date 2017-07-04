package java8.ocp.sg2.chapter3.review;

public class Q6 {

	public class Hello<T> {
		T t;

		public Hello(T t) {
			this.t = t;
		}

		public String toString() {
			return t.toString();
		}
	}


	public static void main(String[] args) {
		System.out.print(new Q6().new Hello<String>("hi"));
		System.out.print(new Q6().new Hello("there"));
	}


}
