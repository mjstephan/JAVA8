package java8.ocp.sg2.chapter3.review;

public class Q22 {

	public static T identity(T t) {
		return t;
	}

	public static <T> T correctIdentity(T t) {
		return t;
	}

}
