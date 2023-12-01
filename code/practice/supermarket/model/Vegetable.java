package practice.supermarket.model;

public class Vegetable extends Food {
    public Vegetable(int barCode, String name, double price, long expDate) {
        super(barCode, name, price, expDate);
    }


    @Override
    public int compareTo(Food o) {
        return this.barCode - o.barCode;
    }
}
