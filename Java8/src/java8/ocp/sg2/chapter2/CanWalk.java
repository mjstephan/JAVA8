package java8.ocp.sg2.chapter2;

public interface CanWalk {
	default void walk() {
		System.out.println("Walking");
	}
}
