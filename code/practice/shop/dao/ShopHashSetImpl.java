package practice.shop.dao;

import practice.shop.model.Product;

import java.util.HashSet;

public class ShopHashSetImpl implements Shop {
    private HashSet<Product> productHashSet;
    int capacity;

    public ShopHashSetImpl(int capacity){
        this.capacity = capacity;
        this.productHashSet = new HashSet<>();
    }

    @Override
    public boolean addProduct(Product product) {
        if (product ==null || productHashSet.size()==capacity){
            return false;
        }
        return productHashSet.add(product);
    }

    @Override
    public Product removeProduct(int barCode) {
        Product removed = findProduct(barCode);
        productHashSet.remove(removed);
        return removed;
    }

    @Override
    public Product findProduct(int barCode) {
        for (Product product:productHashSet) {
            if (product.getBarCode()==barCode){
                return product;
            }
        } return null;
    }

    @Override
    public int quantity() {
        return productHashSet.size();
    }

    @Override
    public double totalSum() {
        double sum = 0;
        for (Product product:productHashSet) {
            sum += product.getPrice();
        }
        return sum;
    }

    @Override
    public int saleBlackFriday() {
        int sum = 0;
        for (Product product:productHashSet) {
            sum += product.getSaleBlackFriday();
        }
        return sum;
    }

    @Override
    public double totalSalaryPrice() {
        double sum = 0;
        for (Product product : productHashSet) {
            sum += product.getPrice()*product.getSaleBlackFriday()/100;
        }
        return sum;
    }
}
