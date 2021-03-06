/**
 *
 */
package java8.ocp.sg2.appendix_c;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author pche0001
 *
 */
public class DuplicateLocks {

	private static int birdCount;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * The result is that the unlock() method must be called the same number
		 * of times as the lock() method in order to release the lock.
		 * Therefore, this code outputs Unavailable , since the lock is still
		 * maintained by the original thread.
		 */

		Lock lock = new ReentrantLock(true); //<< fairness is enabled and the longest waiting thread is guaranteed to obtain the lock the next time it is released
		try {
			lock.lock();
			lock.lock();
			++birdCount;
		} finally {
			lock.unlock();
			//lock.unlock();
		}

		new Thread(() -> {
			if (lock.tryLock()) {
				try {
					System.out.println("Acquired");
				} finally {
					lock.unlock();
				}
			} else {
				System.out.println("Unavailable");
			}
		}).start();

	}

}
