package practice.supermarket.dao;

import practice.supermarket.model.Food;

public interface Supermarket {
    boolean addFood(Food food);
    Food findFood(int barCode);
    Food findExpDate(long expDate);
    Food removeFood(int barCode);
    int quantity();
    double totalPrice();
}
