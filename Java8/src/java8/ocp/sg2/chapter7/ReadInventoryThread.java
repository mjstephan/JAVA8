/**
 *
 */
package java8.ocp.sg2.chapter7;

/**
 * @author pche0001
 *
 */
public class ReadInventoryThread extends Thread {

	public void run() {
		System.out.println("Printing zoo inventory");
	}

	public static void main(String[] args) {
		(new ReadInventoryThread()).start();
	}

}
