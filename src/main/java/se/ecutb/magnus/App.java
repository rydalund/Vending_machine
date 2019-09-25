package se.ecutb.magnus;

import se.ecutb.magnus.model.Currency;
import se.ecutb.magnus.model.ImplementingVendingMachine;
import se.ecutb.magnus.model.VendingMachine;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    private static VendingMachine vendingMachine = new ImplementingVendingMachine();
    private static Scanner scanner = new Scanner(System.in);
    private static boolean keepAlive = true;
    private static boolean keepAliveTemp;
    private static int foo;


    public static void main( String[] args ) {
        vendingMachine.setProducts();
        System.out.println("---SUPER VENDING MACHINE---");
        while (keepAlive){
            vendingMenu();
        }
        System.out.println("---Have a nice day!---");
    }

    private static void vendingMenu() {
        System.out.println("---1-Add money-------------");
        System.out.println("---2-Balance---------------");
        System.out.println("---3-View products---------");
        System.out.println("---4-Buy products----------");
        System.out.println("---5-Product info----------");
        System.out.println("---6-Quit------------------");
        System.out.print("---Please make a choice: ");

        switch (Integer.parseInt(scanner.nextLine())){
            case 1:
                do {
                    System.out.println("---------Add money---------");
                    insertMoney();
                    printBalance();
                    System.out.println("To add more money press 1\nTo return to main menu press 2\nPlease make a choice: ");
                    evaluateChoice();
                }
                while (keepAliveTemp);
                break;
            case 2:
                printBalance();
                break;
            case 3:
                System.out.println("The following products are available");
                String[] productsTemp;
                productsTemp = vendingMachine.getProducts();
                System.out.println((Arrays.toString(productsTemp)));
                System.out.println("Press enter to return to main menu...");
                try{
                    System.in.read();}
                catch(Exception e){	e.printStackTrace();}
                break;
            case 4:
                do {
                    System.out.println("To purchase product, enter product number: ");
                    foo = productFromUser();
                    vendingMachine.request(foo);
                    System.out.println("Continue shopping press 1\nTo return to main menu press 2\nPlease make a choice: ");
                    evaluateChoice();
                }
                while (keepAliveTemp);
                break;
            case 5:
                do {
                    System.out.println("For information, enter product number: ");
                    foo = productFromUser();
                    vendingMachine.getDescription(foo);
                    System.out.println("For information about another product press 1\nTo return to main menu press 2\nPlease make a choice: ");
                    evaluateChoice();
                }
                while (keepAliveTemp);
                break;
            case 6:
                vendingMachine.endSession();
                keepAlive = false;
                break;
        }
    }
    static void insertMoney(){ //Blev inte så bra, tänkte att enum skulle vara praktiskt, men ville ändå behålla
        System.out.println("ENKRONA or type 1");
        System.out.println("FEMKRONA or type 5");
        System.out.println("TIA or type 10");
        System.out.println("TJUGA or type 20");
        System.out.println("FEMTILAPP or type 50");
        System.out.println("HUNDRALAPP or type 100");
        System.out.println("TVAHUNDRALAPP or type 200");
        System.out.println("FEMHUNDRALAPP or type 500");
        System.out.println("TUSENLAPP or type 1000");
        System.out.print("Insert money or type nr: ");
        System.out.print("");

        switch (Integer.parseInt(scanner.nextLine())){
            case 1:
                vendingMachine.addCurrency(Currency.ENKRONA);
                break;
            case 5:
                vendingMachine.addCurrency(Currency.FEMKRONA);
                break;
            case 10:
                vendingMachine.addCurrency(Currency.TIA);
                break;
            case 20:
                vendingMachine.addCurrency(Currency.TJUGA);
                break;
            case 50:
                vendingMachine.addCurrency(Currency.FEMTILAPP);
                break;
            case 100:
                vendingMachine.addCurrency(Currency.HUNDRALAPP);
                break;
            case 200:
                vendingMachine.addCurrency(Currency.TVAHUNDRALAPP);
                break;
            case 500:
                vendingMachine.addCurrency(Currency.FEMHUNDRALAPP);
                break;
            case 1000:
                vendingMachine.addCurrency(Currency.TUSENLAPP);
                break;
        }
    }
    private static void printBalance(){
        System.out.println("Balance: " + vendingMachine.getBalance());
    }
    private static int productFromUser (){
        return Integer.parseInt(scanner.nextLine())-1;
    }
    private static void evaluateChoice(){
        switch (Integer.parseInt(scanner.nextLine())){
            case 1:
                keepAliveTemp = true;
                break;
            case 2:
                keepAliveTemp = false;
                break;
        }
    }
}
