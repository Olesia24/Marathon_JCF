package practice.shop.model;

public abstract class Product implements Comparable<Product> {
    protected final int barCode;
    protected String name;
    protected double price;
    protected  int saleBlackFriday; //процент скидки

    public Product(int barCode, String name, double price, int saleBlackFriday) {
        this.barCode = barCode;
        this.name = name;
        this.price = price;
        this.saleBlackFriday = saleBlackFriday;
    }

    public int getBarCode() {
        return barCode;
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

    public int getSaleBlackFriday() {
        return saleBlackFriday;
    }

    public void setSaleBlackFriday(int saleBlackFriday) {
        this.saleBlackFriday = saleBlackFriday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return barCode == product.barCode;
    }

    @Override
    public int hashCode() {
        return barCode;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + barCode +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", saleBlackFriday=" + saleBlackFriday +
                '}';
    }
}
