package se.ecutb.magnus.model;
import java.lang.Math;


public class ImplementingVendingMachine implements VendingMachine {
    private double moneyPool = 0;
    private Product[] products = new Product[8];
    private Soda soda1 = new Soda(1, "Pepsi", 10.5, "Sugar");
    private Soda soda2 = new Soda(2, "DrCoffee", 29, "Coffee");
    private Food food1 = new Food(3, "Sausage", 39.5, "Pork");
    private Food food2 = new Food(4, "Hamburger", 55, "Beef");
    private Food food3 = new Food(5, "Falafel", 35, "Vegetables");
    private Snack snack1 = new Snack(6, "Chocolate", 10, "Cocoa");
    private Snack snack2 = new Snack(7, "Crisps", 9.5, "Potatoes");
    private Snack snack3 = new Snack(8, "Polkagris", 8, "Sugar");


    @Override
    public void addCurrency(Currency currency) {
        moneyPool = moneyPool + (double)currency.value;
    }

    @Override
    public int request(int productNumber) {
        if (moneyPool < products[productNumber].getProductPrice()){
            System.out.println("Balance is too low, first insert more money");
        } else {
            System.out.println("Thank you for your purchase of " + products[productNumber].getProductName());
            moneyPool = moneyPool - products[productNumber].getProductPrice();
        }
        return productNumber;
    }

    @Override
    public int endSession() {
        System.out.println("---Returning outstanding balance: " + Math.round(getBalance()));
        moneyPool = 0;
        return (int)  moneyPool; //stod att det skulle vara int
    }

    @Override
    public String getDescription(int productNumber) {
        System.out.print("Enter product number to get description: ");

        System.out.println(products[productNumber].examine() + ", " + products[productNumber].use());
        return products[productNumber].productName; //för att kunna testa
    }

    @Override
    public double getBalance() {
        return moneyPool;
    }

    @Override
    public String[] getProducts() {
        String [] returnProduct = new String [8];
        returnProduct[0] = (products[0].productNumber + " " + products[0].productName + " " + products[0].productPrice + "kr");
        returnProduct[1] = (products[1].productNumber + " " + products[1].productName + " " + products[1].productPrice + "kr");
        returnProduct[2] = (products[2].productNumber + " " + products[2].productName + " " + products[2].productPrice + "kr");
        returnProduct[3] = (products[3].productNumber + " " + products[3].productName + " " + products[3].productPrice + "kr");
        returnProduct[4] = (products[4].productNumber + " " + products[4].productName + " " + products[4].productPrice + "kr");
        returnProduct[5] = (products[5].productNumber + " " + products[5].productName + " " + products[5].productPrice + "kr");
        returnProduct[6] = (products[6].productNumber + " " + products[6].productName + " " + products[6].productPrice + "kr");
        returnProduct[7] = (products[7].productNumber + " " + products[7].productName + " " + products[7].productPrice + "kr");
        return returnProduct;
    }

    @Override
    public void setProducts() {
        products [0] = soda1;
        products [1] = soda2;
        products [2] = food1;
        products [3] = food2;
        products [4] = food3;
        products [5] = snack1;
        products [6] = snack2;
        products [7] = snack3;
    }
}