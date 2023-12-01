package practice.shop.dao;

//- добавить товар
///- найти товар
//- кол-во товар
//- напечатать товаров
//- удалить товар
//- сумма товаров

import practice.shop.model.Product;

public interface Shop {
    boolean addProduct(Product product);
    Product removeProduct (int barCode);
    Product findProduct (int barCode);
    int quantity();
    double totalSum();
    int saleBlackFriday();
    double totalSalaryPrice();

}
