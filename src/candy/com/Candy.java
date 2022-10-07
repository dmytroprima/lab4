package candy.com;

public class Candy {
    protected String name;
    protected int weight;
    protected int sugarContent;
    protected int price;

    public Candy(String name, int weight, int sugar_content, int price){
        this.name = name;
        this.price = price;
        this.sugarContent = sugar_content;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getSugarContent() {
        return sugarContent;
    }
}