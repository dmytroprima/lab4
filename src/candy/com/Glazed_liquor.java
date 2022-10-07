package candy.com;

public class Glazed_liquor extends Candy{
    private int amount_of_liquor;

    public Glazed_liquor(String name, int weight, int sugar_content, int price, int amount_of_liquor) {
        super(name, weight, sugar_content, price);
        this.amount_of_liquor = amount_of_liquor;
    }
}
