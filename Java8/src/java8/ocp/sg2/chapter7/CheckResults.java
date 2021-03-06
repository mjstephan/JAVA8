/**
 *
 */
package java8.ocp.sg2.chapter7;

/**
 * @author pche0001
 *
 */
public class CheckResults {

	private static int counter = 0;

	public static void main(String[] args) throws InterruptedException {
		new Thread(() -> {
			for (int i = 0; i < 500; i++)
				CheckResults.counter++;
		}).start();
		while (CheckResults.counter < 100) {
			System.out.println("Not reached yet");
		}
		System.out.println("Reached!");

		CheckResults.counter = 0;

		/*
		 * How many times does the while() loop execute in this revised class?
		 * Still unknown! While polling does prevent the CPU from being
		 * overwhelmed with a potentially infinite loop, it does not guarantee
		 * when the loop will terminate. For example, the separate thread could
		 * be losing CPU time to a higher-priority process, resulting in
		 * multiple executions of the while() loop before it finishes.
		 */

		new Thread(() -> {
			for (int i = 0; i < 50000; i++)
				CheckResults.counter++;
		}).start();

		while (CheckResults.counter < 49999) {
			System.out.println("Not reached yet");
			Thread.sleep(1000); // 1 SECOND
		}
		System.out.println("Reached!");

	}

}
