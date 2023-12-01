package practice.shop.dao;

import practice.shop.model.Product;

import java.util.LinkedList;

public class ShopLinkedListImpl implements Shop {

    private LinkedList<Product> productList;
    private int capacity;

    public ShopLinkedListImpl(int capacity){
        this.capacity = capacity;
        this.productList = new LinkedList<>();
    }

    @Override
    public boolean addProduct(Product product) {
        if (product ==null || productList.size()==capacity || findProduct(product.getBarCode())!= null ){
            return false;
        }
        productList.add(product);
        return true;
    }

    @Override
    public Product removeProduct(int barCode) {
        Product foundProduct = findProduct(barCode);
        if (foundProduct != null){
            productList.remove(foundProduct);
        }return foundProduct;
    }

    @Override
    public Product findProduct(int barCode) {
        for (Product p: productList) {
            if (p.getBarCode()==barCode){
                return p;
            }
        } return null;
    }

    @Override
    public int quantity() {
        return productList.size();
    }

    @Override
    public double totalSum() {
        double sum = 0;
        for (Product product: productList) {
            if (product != null){
                sum += product.getPrice();
            }
        } return sum;
    }

    @Override
    public int saleBlackFriday() {
        int sum = 0;
        for (Product product:productList) {
            if (product != null){
                sum += product.getSaleBlackFriday();
            }
        } return sum;
    }

    @Override
    public double totalSalaryPrice() {
        double sum = 0;
        for (Product product:productList) {
            if (product != null){
                sum += product.getPrice()*product.getSaleBlackFriday()/100;
            }
        }return sum;
    }
}
