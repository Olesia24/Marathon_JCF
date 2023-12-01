package practice.supermarket.model;

public abstract class Food implements Comparable<Food> {
    protected int barCode;
    protected String name;
    protected double price;
    protected long expDate;

    public Food(int barCode, String name, double price, long expDate) {
        this.barCode = barCode;
        this.name = name;
        this.price = price;
        this.expDate = expDate;
    }

    public int getBarCode() {
        return barCode;
    }

    public void setBarCode(int barCode) {
        this.barCode = barCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getExpDate() {
        return expDate;
    }

    public void setExpDate(long expDate) {
        this.expDate = expDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Food food = (Food) o;

        return barCode == food.barCode;
    }

    @Override
    public int hashCode() {
        return barCode;
    }

    @Override
    public String toString() {
        return "Food{" +
                "barCode=" + barCode +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", expDate=" + expDate +
                '}';
    }
}
