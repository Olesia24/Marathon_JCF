package practice.supermarket.dao;

import practice.supermarket.model.Food;

import java.util.HashSet;

public class SupermHashSetImpl implements Supermarket {
    private HashSet<Food> foods;
    int capacity;

    public SupermHashSetImpl(int capacity){
        this.capacity = capacity;
        this.foods = new HashSet<>();
    }
    @Override
    public boolean addFood(Food food) {
        if (food == null || foods.size()== capacity){
            return false;
        }
        return foods.add(food);
    }

    @Override
    public Food findFood(int barCode) {
        for (Food food:foods) {
            if (food.getBarCode()==barCode){
                return food;
            }
        } return null;
    }

    @Override
    public Food findExpDate(long expDate) {
        for (Food food:foods) {
            if (food.getExpDate()==expDate){
                return food;
            }
        }return null;
    }

    @Override
    public Food removeFood(int barCode) {
        Food removed = findFood(barCode);
        foods.remove(removed);
        return removed;
    }

    @Override
    public int quantity() {
        return foods.size();
    }

    @Override
    public double totalPrice() {
        double sum = 0;
        for (Food food: foods) {
            sum += food.getPrice();
        }
        return sum;
    }
}
