package practice.shop.model;

public class Smartphone extends Product {
    private double diagonal;
    private int camera;
    private String webBrowser;

    public Smartphone(int barCode, String name, double price, int saleBlackFriday, double diagonal, int camera, String webBrowser) {
        super(barCode, name, price, saleBlackFriday);
        this.diagonal = diagonal;
        this.camera = camera;
        this.webBrowser = webBrowser;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(double diagonal) {
        this.diagonal = diagonal;
    }

    public int getCamera() {
        return camera;
    }

    public void setCamera(int camera) {
        this.camera = camera;
    }

    public String getWebBrowser() {
        return webBrowser;
    }

    public void setWebBrowser(String webBrowser) {
        this.webBrowser = webBrowser;
    }

    @Override
    public int compareTo(Product o) {
        return this.barCode - o.barCode;
    }
}
