package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {

    public BasketTest() {

    }

    @Test
    public void testCreateBasketAndAddProducts() {
        Basket b = new Basket();
        Bagel onion = new OnionBagel();
        Filling salmon = new SmokedSalmonFilling();
        b.addProduct(onion);
        b.addProduct(salmon);

        Assertions.assertEquals("FILS", b.getBasket().get(1).getSKU());
    }

    @Test
    public void testAddProductsToBasketOverCapacity() {
        Basket basket = new Basket(); // Has max capacity of 5 from beginning

        Bagel b1 = new OnionBagel();
        Bagel b2 = new OnionBagel();
        Bagel b3 = new OnionBagel();
        Bagel b4 = new OnionBagel();
        Bagel b5 = new OnionBagel();
        Bagel b6 = new OnionBagel();

        basket.addProduct(b1);
        basket.addProduct(b2);
        basket.addProduct(b3);
        basket.addProduct(b4);
        basket.addProduct(b5);

        Assertions.assertTrue(basket.isFull());
        Assertions.assertFalse(basket.addProduct(b6));
    }

    @Test
    public void testRemoveProductFromBasketTest() {
        Basket basket = new Basket();

        Bagel onionBagel = new OnionBagel();

        basket.addProduct(onionBagel);

        basket.remove(onionBagel);

        Assertions.assertTrue(basket.getBasket().isEmpty());
    }

    @Test
    public void testRemoveProductFromMBasketThatDoesNotExist() {
        Basket basket = new Basket();

        Bagel onionBagel = new OnionBagel();

        // basket.addProduct(onionBagel); don't add

        Assertions.assertFalse(basket.remove(onionBagel));
        Assertions.assertTrue(basket.getBasket().isEmpty());

    }

}
