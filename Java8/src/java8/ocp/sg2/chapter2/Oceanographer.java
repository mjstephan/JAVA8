/**
 *
 */
package java8.ocp.sg2.chapter2;

/**
 * @author pche0001
 *
 */
public class Oceanographer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Oceanographer o = new Oceanographer();
		o.checkSound(new Dolphin());
		o.checkSound(new Whale());

	}

	private void checkSound(LivesInOcean animal) {
		animal.makeSound();

	}

}
