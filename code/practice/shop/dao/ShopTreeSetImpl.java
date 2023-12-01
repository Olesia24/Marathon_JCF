package practice.shop.dao;

import practice.shop.model.Product;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class ShopTreeSetImpl implements Shop {
    private Set<Product> productTreeSet;
    int capacity;

    public ShopTreeSetImpl(int capacity){
        this.capacity = capacity;
        this.productTreeSet = new TreeSet<>();
    }

    @Override
    public boolean addProduct(Product product) {
        return product != null && productTreeSet.size()<capacity ? productTreeSet.add(product) : false;
    }

    @Override
    public Product removeProduct(int barCode) {
        Product removed = findProduct(barCode);
        return productTreeSet.removeIf(p ->p.getBarCode()==barCode) ? removed : null;
    }

    @Override
    public Product findProduct(int barCode) {
        return productTreeSet.stream()
                .filter(p -> p.getBarCode()==barCode)
                .findFirst()
                .orElse(null);
    }

    @Override
    public int quantity() {
        return productTreeSet.size();
    }

    @Override
    public double totalSum() {
        return productTreeSet.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }

    @Override
    public int saleBlackFriday() {
        return productTreeSet.stream()
                .filter(Objects::nonNull)
                .mapToInt(Product::getSaleBlackFriday)
                .sum();
    }

    @Override
    public double totalSalaryPrice() {
        return productTreeSet.stream()
                .filter(Objects::nonNull)
                .mapToDouble(p -> p.getPrice() * p.getSaleBlackFriday() / 100.0)
                .sum();
    }
}
