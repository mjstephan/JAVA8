package java8.ocp.sg2.chapter2;

public interface CanRun {
	public default void walk() {
		System.out.println("Walking");
	}

	public abstract void run();
}
