package se.ecutb.magnus.model;

public class Food extends Product{
    private String mainIngredient;

    public Food(int productNumber, String productName, double productPrice, String mainIngredient) {
        super(productNumber, productName, productPrice);
        this.mainIngredient = mainIngredient;
    }

    @Override
    public String examine() {
        return super.examine() + ", Main Ingredient = " + mainIngredient;
    }

    @Override
    public String use() {
        return super.use() + " makes you satisfied";
    }
}

