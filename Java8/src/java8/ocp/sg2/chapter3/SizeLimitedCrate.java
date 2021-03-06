/**
 *
 */
package java8.ocp.sg2.chapter3;

/**
 * @author pche0001
 *
 */
public class SizeLimitedCrate<T, U> { //Generic classes aren’t limited to having a single type parameter

	private T contents;
	private U sizeLimit;

	public SizeLimitedCrate(T contents, U sizeLimit) {
		this.contents = contents;
		this.sizeLimit = sizeLimit;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Doggies doggy = new Doggies();
		Integer numPounds = 150;
		SizeLimitedCrate<Doggies, Integer> c1 = new SizeLimitedCrate<>(doggy, numPounds);


		Elephant elephant = new Elephant();
		Integer numPounds2 = 15_000;
		SizeLimitedCrate<Elephant, Integer> c2 = new SizeLimitedCrate<>(elephant,
		numPounds2);

	}

}
