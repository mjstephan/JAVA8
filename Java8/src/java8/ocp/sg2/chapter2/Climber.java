package java8.ocp.sg2.chapter2;

public class Climber {

	public static void main(String[] args) {
		check((h, l) -> h < 30, 5); // x1
	}

	private static void check(Climb climb, int height) {
		if (climb.isTooHigh(height, 10)) // x2
			System.out.println("too high");
		else
			System.out.println("ok");
	}

}
