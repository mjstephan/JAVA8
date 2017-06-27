/**
 *
 */
package java8.ocp.sg2.chapter2;

/**
 * @author pche0001
 *
 */
public class Duck extends Animal {

	/**
	 * @param speciesName
	 * @param hopper
	 * @param swimmer
	 */
	public Duck(String speciesName, boolean hopper, boolean swimmer) {
		super(speciesName, hopper, swimmer);

	}


	public Boolean quack(Animal a, Duck d){
		return true;
	}

}
