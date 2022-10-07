package candy.com;

public class Chocolate_with_fillings extends Candy{
    private String fillings_type;

    public Chocolate_with_fillings(String name, int weight, int sugar_content, int price, String fillings_type) {
        super(name, weight, sugar_content, price);
        this.fillings_type = fillings_type;
    }
}