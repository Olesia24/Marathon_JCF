package practice.shop.dao;

import practice.shop.model.Product;

public class ShopImpl implements Shop  {
    private Product[] products;
    private int size;

    public ShopImpl(int capacity) {
        products = new Product[capacity];
    }

    @Override
    public boolean addProduct(Product product) {
        if (product == null || size == products.length || findProduct(product.getBarCode()) != null) {
            return false;
        }
        products[size] = product;
        size++;
        return true;
    }

    @Override
    public Product removeProduct(int barCode) {
        for (int i = 0; i < size; i++) {
            if (products[i].getBarCode() == barCode) {
                Product victim = products[i];
                products[i] = products[size - 1];
                products[size - 1] = null;
                size--;
                return victim;
            }
        }
        return null;
    }

    @Override
    public Product findProduct(int id) {
        for (int i = 0; i < size; i++) {
            if (products[i].getBarCode() == id) {
                return products[i];
            }
        } return null;
    }

    @Override
    public int quantity() {
        return size;
    }

    @Override
    public double totalSum() {
        double sum = 0;
        for (int i = 0; i < size; i++) {
            if (products[i] != null) {
                sum += products[i].getPrice();
            }
        }
        return sum;
    }

    @Override
    public int saleBlackFriday() {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            if (products[i].getSaleBlackFriday() != 0) {
                sum += products[i].getSaleBlackFriday();

            }
        }
        return sum;
    }
    @Override
    public double totalSalaryPrice() {
        double sum = 0;
        for (int i = 0; i < size; i++) {
            if (products[i] != null) {
                sum += ((products[i].getPrice() * products[i].getSaleBlackFriday()) / 100);
            }
        }return sum;
    }
}

