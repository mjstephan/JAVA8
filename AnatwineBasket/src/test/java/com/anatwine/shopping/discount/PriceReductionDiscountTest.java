/**
 * 
 */
package com.anatwine.shopping.discount;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.anatwine.shopping.Utils;
import com.anatwine.shopping.basket.AnatwineBasket;
import com.anatwine.shopping.basket.Product;
import com.anatwine.shopping.catalogue.ProductCatalogue;

/**
 * @author Pete
 *
 */
public class PriceReductionDiscountTest {

	private static final String TROUSERS = "Trousers";
	private static final String JACKET = "Jacket";
	private static final String TIE = "Tie";
	private static final String SHIRTS = "Shirts";
	private GenericReductionDiscount priceReductionDiscount;
	private ProductCatalogue sourceProduct;
	private ProductCatalogue destinationProduct;
	private Integer qualifyingQuantity;
	private Double percentageOff;
	private AnatwineBasket mockAnatwineBasket;
	private HashMap<String, BigDecimal> discounts;

	@Before
	public void setUp() throws Exception {

		// class we are testing
		sourceProduct = ProductCatalogue.Trousers;
		destinationProduct = ProductCatalogue.Trousers;
		qualifyingQuantity = 1;
		percentageOff = 0.1D;

		priceReductionDiscount = spy(
				new GenericReductionDiscount(sourceProduct, destinationProduct, qualifyingQuantity, percentageOff));

		mockAnatwineBasket = mock(AnatwineBasket.class);
		discounts = new HashMap<>();
		when(mockAnatwineBasket.getDiscounts()).thenReturn(discounts);

	}

	@Test
	public void testReturnNoDiscountWhenTwoShirtsPurchased() {
		// given

		Map<Product, Integer> basketProducts = new HashMap<>();
		basketProducts.put(new Product(SHIRTS, ProductCatalogue.Shirt), new Integer(1));
		basketProducts.put(new Product(TIE, ProductCatalogue.Tie), new Integer(2));
		basketProducts.put(new Product(JACKET, ProductCatalogue.Jacket), new Integer(2));
		doReturn(basketProducts).when(mockAnatwineBasket).getBasketProducts();

		// when
		priceReductionDiscount.applyDiscountRule(mockAnatwineBasket);

		// then
		for (String key : discounts.keySet()) {
			assertEquals("Trousers 10.0% Off ", key);
			assertEquals(Utils.formatAmount(new BigDecimal("-7.10")), Utils.formatAmount(discounts.get(key)));
		}
	}

	@Test
	public void testReturnTrouserDiscountWhenOneTrousersPurchased() {
		// given

		Map<Product, Integer> basketProducts = new HashMap<>();
		basketProducts.put(new Product(TROUSERS, ProductCatalogue.Trousers), new Integer(1));
		basketProducts.put(new Product(SHIRTS, ProductCatalogue.Shirt), new Integer(1));
		basketProducts.put(new Product(TIE, ProductCatalogue.Tie), new Integer(2));
		basketProducts.put(new Product(JACKET, ProductCatalogue.Jacket), new Integer(2));
		doReturn(basketProducts).when(mockAnatwineBasket).getBasketProducts();

		// when
		priceReductionDiscount.applyDiscountRule(mockAnatwineBasket);

		// then
		for (String key : discounts.keySet()) {
			assertEquals("Trousers 10.0% Off ", key);
			assertEquals(Utils.formatAmount(new BigDecimal("-3.55")), Utils.formatAmount(discounts.get(key)));
		}
	}

	@Test
	public void testReturnTrouserDiscountWhenTwoTrousersPurchased() {
		// given

		Map<Product, Integer> basketProducts = new HashMap<>();
		basketProducts.put(new Product(TROUSERS, ProductCatalogue.Trousers), new Integer(2));
		basketProducts.put(new Product(SHIRTS, ProductCatalogue.Shirt), new Integer(1));
		basketProducts.put(new Product(TIE, ProductCatalogue.Tie), new Integer(2));
		basketProducts.put(new Product(JACKET, ProductCatalogue.Jacket), new Integer(2));
		doReturn(basketProducts).when(mockAnatwineBasket).getBasketProducts();

		// when
		priceReductionDiscount.applyDiscountRule(mockAnatwineBasket);

		// then
		for (String key : discounts.keySet()) {
			assertEquals("Trousers 10.0% Off ", key);
			assertEquals(Utils.formatAmount(new BigDecimal("-7.10")), Utils.formatAmount(discounts.get(key)));
		}
	}

	@Test
	public void testReturnTrouserDiscountWhenThreeTrousersPurchased() {
		// given

		Map<Product, Integer> basketProducts = new HashMap<>();
		basketProducts.put(new Product(TROUSERS, ProductCatalogue.Trousers), new Integer(3));

		basketProducts.put(new Product(SHIRTS, ProductCatalogue.Shirt), new Integer(1));
		basketProducts.put(new Product(TIE, ProductCatalogue.Tie), new Integer(2));
		basketProducts.put(new Product(JACKET, ProductCatalogue.Jacket), new Integer(2));
		doReturn(basketProducts).when(mockAnatwineBasket).getBasketProducts();

		// when
		priceReductionDiscount.applyDiscountRule(mockAnatwineBasket);

		// then
		for (String key : discounts.keySet()) {
			assertEquals("Trousers 10.0% Off ", key);
			assertEquals(Utils.formatAmount(new BigDecimal("-10.65")), Utils.formatAmount(discounts.get(key)));
		}
	}

	@Test
	public void testReturnTrouserDiscountWhenOneHundredTrousersPurchased() {
		// given

		Map<Product, Integer> basketProducts = new HashMap<>();
		basketProducts.put(new Product(TROUSERS, ProductCatalogue.Trousers), new Integer(100));

		basketProducts.put(new Product(SHIRTS, ProductCatalogue.Shirt), new Integer(1));
		basketProducts.put(new Product(TIE, ProductCatalogue.Tie), new Integer(2));
		basketProducts.put(new Product(JACKET, ProductCatalogue.Jacket), new Integer(2));
		doReturn(basketProducts).when(mockAnatwineBasket).getBasketProducts();

		// when
		priceReductionDiscount.applyDiscountRule(mockAnatwineBasket);

		// then
		for (String key : discounts.keySet()) {
			assertEquals("Trousers 10.0% Off ", key);
			assertEquals(Utils.formatAmount(new BigDecimal("-355.00")), Utils.formatAmount(discounts.get(key)));
		}
	}

	@Test
	public void testBuyOneGetOneFree_FutureDiscountScenario() {

		Map<Product, Integer> basketProducts = new HashMap<>();
		basketProducts.put(new Product(TROUSERS, ProductCatalogue.Trousers), new Integer(2));
		doReturn(basketProducts).when(mockAnatwineBasket).getBasketProducts();

		priceReductionDiscount = spy(new GenericReductionDiscount(sourceProduct, destinationProduct, 2, 1D));

		// when
		priceReductionDiscount.applyDiscountRule(mockAnatwineBasket);

		// then
		for (String key : discounts.keySet()) {
			assertEquals("Trousers 100.0% Off ", key);
			assertEquals(Utils.formatAmount(new BigDecimal("-35.50")), Utils.formatAmount(discounts.get(key)));
		}

	}

	@Test
	public void testBuyTwoGetTwoFree_FutureDiscountScenario() {

		Map<Product, Integer> basketProducts = new HashMap<>();
		basketProducts.put(new Product(TROUSERS, ProductCatalogue.Trousers), new Integer(4));
		doReturn(basketProducts).when(mockAnatwineBasket).getBasketProducts();

		priceReductionDiscount = spy(new GenericReductionDiscount(sourceProduct, destinationProduct, 2, 1D));

		// when
		priceReductionDiscount.applyDiscountRule(mockAnatwineBasket);

		// then
		for (String key : discounts.keySet()) {
			assertEquals("Trousers 100.0% Off ", key);
			assertEquals(Utils.formatAmount(new BigDecimal("-71.00")), Utils.formatAmount(discounts.get(key)));
		}

	}

}