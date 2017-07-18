/**
 *
 */
package com.anatwine.shopping.basket;

import java.util.Scanner;

import com.anatwine.shopping.Constants;
import com.anatwine.shopping.view.BasketView;

/**
 *
 *
 * @author Pete
 *
 */
public class BasketController {

	private Basket basket;
	private BasketView view;

	/**
	 * @param basket
	 * @param view
	 */
	public BasketController(Basket basket, BasketView view) {
		this.basket = basket;
		this.view = view;
	}

	/**
	 * Get the user entry and add to basket and print the receipt.
	 */
	public void processUserEntry() {
		String[] enteredProducts = getInput();
		basket.processProducts(enteredProducts);
		view.printReceipt(basket);
	}

	/**
	 * Return user input as String array
	 *
	 * @return String array
	 */
	private static String[] getInput() {
		System.out.print("AnatwineBasket ");
		Scanner stdin = new Scanner(System.in);
		String text = stdin.nextLine();
		stdin.close();

		if (text == null || text.trim().equals("")) {
			System.err.println(Constants.NO_ITEMS_ENTERED_MSG);
			throw new IllegalArgumentException(Constants.NO_ITEMS_ENTERED_MSG);
		}

		return text.split(" ");
	}

}
