package practice.shop.model;

public class Tablet extends Product{
    private int ram;
    private int ssd;
    String brand;

    public Tablet(int barCode, String name, double price, int saleBlackFriday, int ram, int ssd) {
        super(barCode, name, price, saleBlackFriday);
        this.ram = ram;
        this.ssd = ssd;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getSsd() {
        return ssd;
    }

    public void setSsd(int ssd) {
        this.ssd = ssd;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public int compareTo(Product o) {
        return this.barCode - o.barCode;
    }
}
