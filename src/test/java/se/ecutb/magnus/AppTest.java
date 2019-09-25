package se.ecutb.magnus;

import se.ecutb.magnus.model.*;
import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class AppTest 
{
    private VendingMachine vendingTest = new ImplementingVendingMachine();

    @Test
    public void test_Vending_created_successfully() {
        String [] testReturnProduct;
        vendingTest.setProducts();
        testReturnProduct = vendingTest.getProducts();
        String stringExpected = ("5 Falafel 35.0kr");

        assertEquals(stringExpected, testReturnProduct[4]);
    }

    @Test
    public void testAddCurrency(){
        Currency test1 = Currency.TUSENLAPP;
        Currency test2 = Currency.ENKRONA;
        vendingTest.addCurrency(test1);
        vendingTest.addCurrency(test2);
        double moneyPoolExpected = 1001;

        assertEquals(moneyPoolExpected, vendingTest.getBalance());
    }

    @Test
    public void test_Vending_request() {
        vendingTest.setProducts();
        vendingTest.addCurrency(Currency.TUSENLAPP);
        int foo = 4;

        assertEquals(foo, vendingTest.request(foo));
    }

    @Test
    public void test_Vending_getDescription_snack() {
        int foo = 7;
        String stringExpected = "Polkagris";
        vendingTest.setProducts();

        assertEquals(stringExpected, vendingTest.getDescription(foo));
    }

    @Test
    public void test_Vending_getDescription_food() {
        int foo = 2;
        String stringExpected = "Sausage";
        vendingTest.setProducts();

        assertEquals(stringExpected, vendingTest.getDescription(foo));
    }

    @Test
    public void test_Vending_getDescription_soda() {
        int foo = 1;
        String stringExpected = "DrCoffee";
        vendingTest.setProducts();

        assertEquals(stringExpected, vendingTest.getDescription(foo));
    }

    @Test
    public void test_Vending_endSession() {
        vendingTest.setProducts();
        vendingTest.addCurrency(Currency.TUSENLAPP);
        int moneyPoolExpected = 0;

        assertEquals(moneyPoolExpected, vendingTest.endSession());
    }
}

