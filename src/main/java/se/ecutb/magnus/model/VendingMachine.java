package se.ecutb.magnus.model;

public interface VendingMachine {
    void addCurrency (Currency currency); //Lägga till i insättningspool moneyPool
    int request (int productNumber);//array?
    int endSession (); //ge tillbaka växel och avsluta sessionen
    String getDescription (int productNumber); //Produktbeskrivning
    double getBalance(); //returnera inställningspoolen
    String [] getProducts(); //returnerar alla produkters namn och produktnummer
    void setProducts();
}
