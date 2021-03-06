/**
 *
 */
package java8.ocp.sg2.chapter7;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author pche0001
 *
 */
public class WaitingforAllTaskstoFinish {
	private static int counter = 0;

	/**
	 * @param args
	 * @throws ExecutionException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService service = null;
		Future<?> result = null;
		try {
			service = Executors.newSingleThreadExecutor();
			result = service.submit(() -> {
				for (int i = 0; i < 500000; i++)
					WaitingforAllTaskstoFinish.counter++;
			});
		} finally {
			if (service != null)
				service.shutdown();
		}

		if (service != null) {
			service.awaitTermination(1, TimeUnit.MILLISECONDS);
			// Check whether all tasks are finished
			if (service.isTerminated())
				System.out.println("All tasks finished; " + result.isDone());
			else
				System.out.println("At least one task is still running");
		}

	}

}
