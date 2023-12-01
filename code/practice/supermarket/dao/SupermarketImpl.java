package practice.supermarket.dao;

import practice.supermarket.model.Food;

public class SupermarketImpl implements Supermarket {
    private Food[] foods;
    private int size;

    public SupermarketImpl(int capacity) {
        foods = new Food[capacity];
    }

    @Override
    public boolean addFood(Food food) {
        if (food == null || size == foods.length || findFood(food.getBarCode()) != null) {
            return false;
        }
        foods[size] = food;
        size++;
        return true;
    }

    @Override
    public Food findFood(int barCode) {
        for (int i = 0; i < size; i++) {
            if (foods[i].getBarCode() == barCode) {
                return foods[i];
            }
        }
        return null;
    }
    @Override
    public Food findExpDate(long expDate) {
        for (int i = 0; i < size; i++) {
            if (foods[i].getExpDate() == expDate) {
                return foods[i];
            }
        }
        return null;
    }

    @Override
    public Food removeFood(int barCode) {
        for (int i = 0; i < size; i++) {
            if (foods[i].getBarCode() == barCode) {
                Food victim = foods[i];
                foods[i] = foods[size - 1];
                foods[size - 1] = null;
                size--;
                return victim;
            }
        }
        return null;
    }

    @Override
    public int quantity() {
        return size;
    }

    @Override
    public double totalPrice() {
        double res = 0;
        for (int i = 0; i < size; i++) {
            res += foods[i].getPrice();
        } return res;
    }
}
