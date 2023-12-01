package practice.supermarket.dao;

import practice.supermarket.model.Food;

import java.util.LinkedList;

public class SupermLinkedListImpl implements Supermarket{
    private LinkedList<Food> foodList;
    private int capacity;

    public SupermLinkedListImpl(int capacity){
        this.capacity = capacity;
        this.foodList = new LinkedList<>();
    }

    @Override
    public boolean addFood(Food food) {
        if (food ==null || foodList.size()==capacity || findFood(food.getBarCode()) !=null){
            return false;
        }
        foodList.add(food);
        return true;
    }
    @Override
    public Food removeFood(int barCode) {
        Food foundFood = findFood(barCode);
        if (foundFood != null){
            foodList.remove(foundFood);
        }return foundFood;
    }

    @Override
    public Food findFood(int barCode) {
        for (Food food:foodList) {
            if (food.getBarCode()==barCode){
                return food;
            }
        }return null;
    }

    @Override
    public Food findExpDate(long expDate) {
        for (Food food:foodList) {
            if (food.getExpDate()==expDate){
                return food;
            }
        } return null;
    }

    @Override
    public int quantity() {
        return foodList.size();
    }

    @Override
    public double totalPrice() {
        double total = 0;
        for (Food f:foodList) {
            total += f.getPrice();
        }
        return total;
    }
}
