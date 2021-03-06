/**
 *
 */
package java8.ocp.sg2.chapter2;

/**
 * @author pche0001
 *
 */
public class LlamaTrainer {


	public static void main(String[] args) {
		feedLlamas(10);
	}


	public static boolean feedLlamas(int numberOfLlamas) {
		int amountNeeded = 5 * numberOfLlamas;
		HayStorage hayStorage = HayStorage.getInstance();

		System.out.println("Hay Quantity :" +hayStorage.getHayQuantity());

		if (hayStorage.getHayQuantity() < amountNeeded) {
			System.out.println("Amount needed :" +amountNeeded);
			System.out.println("Adding needed :" +String.valueOf(amountNeeded+10));
			hayStorage.addHay(amountNeeded + 10);
		}

		System.out.println("Hay Quantity before feeding :" +hayStorage.getHayQuantity());

		boolean fed = hayStorage.removeHay(amountNeeded);

		System.out.println("Hay Quantity after feeding :" +hayStorage.getHayQuantity());

		if (fed)
			System.out.println("Llamas have been fed");

		return fed;
	}
}
