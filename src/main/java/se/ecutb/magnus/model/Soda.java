package se.ecutb.magnus.model;

public class Soda extends Product{
    private String mainIngredient;

    public Soda(int productNumber, String productName, double productPrice, String mainIngredient) {
        super(productNumber, productName, productPrice);
        this.mainIngredient = mainIngredient;
    }

    @Override
    public String examine() {
        return super.examine() + ", Main Ingredient = " + mainIngredient;
    }

    @Override
    public String use() {
        return super.use() + " helps with your thirst";
    }
}
