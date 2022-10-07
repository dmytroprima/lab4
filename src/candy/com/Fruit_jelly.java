package candy.com;

public class Fruit_jelly extends Candy{
    private String fruit_type;

    public Fruit_jelly(String name, int weight, int sugar_content, int price, String fruit_type) {
        super(name, weight, sugar_content, price);
        this.fruit_type = fruit_type;
    }
}
