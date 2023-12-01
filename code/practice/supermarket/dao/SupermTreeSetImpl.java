package practice.supermarket.dao;

import practice.supermarket.model.Food;

import java.util.TreeSet;

public class SupermTreeSetImpl implements Supermarket {
    private TreeSet<Food> foodTreeSet;
    int capacity;

    public SupermTreeSetImpl(int capacity){
        this.capacity = capacity;
        this.foodTreeSet = new TreeSet<>();
    }
    public SupermTreeSetImpl() {
        this.foodTreeSet = new TreeSet<>();
    }

    @Override
    public boolean addFood(Food food) {
        return food != null && foodTreeSet.size()< capacity ? foodTreeSet.add(food) : false;
    }

    @Override
    public Food findFood(int barCode) {
        return foodTreeSet.stream()
                .filter(p -> p.getBarCode()== barCode)
                .findFirst()
                .orElse(null);
    }
    @Override
    public Food findExpDate(long expDate) {
        return foodTreeSet.stream()
                .filter(p -> p.getExpDate()==expDate)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Food removeFood(int barCode) {
        Food removed = findFood(barCode);
        return foodTreeSet.removeIf(f ->f.getBarCode()==barCode) ? removed : null;
    }

    @Override
    public int quantity() {
        return foodTreeSet.size();
    }

    @Override
    public double totalPrice() {
        return foodTreeSet.stream()
                .mapToDouble(Food::getPrice)
                .sum();
    }
}
