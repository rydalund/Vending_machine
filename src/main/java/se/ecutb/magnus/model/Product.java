package se.ecutb.magnus.model;

public abstract class Product {
    int productNumber;
    String productName;
    double productPrice;

    Product(int productNumber, String productName, double productPrice) {
        this.productNumber = productNumber;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    String getProductName() {
        return productName;
    }

    double getProductPrice() {
        return productPrice;
    }

    public String examine(){
        return "Product number = " + productNumber + ", Name = " + productName + ", Price = " + productPrice;
    }
    public String use(){
        return "This " + productName;
    }

}
