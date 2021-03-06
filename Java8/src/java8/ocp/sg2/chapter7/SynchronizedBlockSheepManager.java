/**
 *
 */
package java8.ocp.sg2.chapter7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author pche0001
 *
 */
public class SynchronizedBlockSheepManager {

	private int sheepCount = 0; // Since synchronized blocks allow only one
								// thread to enter, we're not gaining any
								// improvement by using an atomic variable

	private void incrementAndReport() {
		synchronized (this) { // Although all threads are still created and
								// executed at the same time, they each wait at
			// the synchronized block for the worker to increment and report the
			// result before entering.
			System.out.print(" \n " + ++sheepCount);
		}
	}

	public static void main(String[] args) {
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(20);
			SynchronizedBlockSheepManager manager = new SynchronizedBlockSheepManager();
			// synchronized(manager) { // synchronized block ... synchronized
			// the creation of the threads but not the execution of the threads, so no change
			for (int i = 0; i < 10; i++)
				service.submit(() -> manager.incrementAndReport());
			// }
		} finally {
			if (service != null)
				service.shutdown();
		}
	}

}
