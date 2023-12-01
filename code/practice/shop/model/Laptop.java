package practice.shop.model;

public class Laptop extends Product {
    private double hours;
    private double weight;

    public Laptop(int barCode, String name, double price, int saleBlackFriday, double hours, double weight) {
        super(barCode, name, price, saleBlackFriday);
        this.hours = hours;
        this.weight = weight;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Product o) {
        return this.barCode - o.barCode;
    }
}
