package practice.supermarket.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.supermarket.dao.SupermTreeSetImpl;
import practice.supermarket.dao.Supermarket;
import practice.supermarket.model.Food;
import practice.supermarket.model.MeatFood;
import practice.supermarket.model.MilkFood;
import practice.supermarket.model.Vegetable;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SupermarketImplTest {

    Supermarket supermarket;
    Food[] foods;

    @BeforeEach
    void setUp() {
        supermarket = new SupermTreeSetImpl(5);
        foods= new Food[4];
        foods[0] = new MeatFood(1010, "Salami", 9.5, 111023);
        foods[1] = new MeatFood(1128, "Meat", 15.5, 102523);
        foods[2] = new MilkFood(9454, "Milk", 2.5, 113023);
        foods[3] = new Vegetable(3941, "Apple", 2.5, 113023);
        for (int i = 0; i <foods.length ; i++) {
            supermarket.addFood(foods[i]);
        }
    }
    @Test
    void addFoodTest() {
        assertFalse(supermarket.addFood(null));
        assertFalse(supermarket.addFood(foods[0]));
        Food food5 = new Vegetable(123,"Salat", 3, 112323);
        assertTrue(supermarket.addFood(food5));
        Food food6 = new MeatFood(3045, "Name", 3.4, 12112023);
        assertFalse(supermarket.addFood(food6));
        assertEquals(5, supermarket.quantity());

    }
    @Test
    void findFoodTest() {
        assertEquals(foods[0], supermarket.findFood(1010));
        System.out.println(supermarket.findFood(1010));
    }

    @Test
    void findExpDateTest() {
        assertEquals(foods[0], supermarket.findExpDate(111023));
        System.out.println(supermarket.findExpDate(111023));
    }

    @Test
    void removeFoodTest() {
        assertEquals(foods[2], supermarket.removeFood(9454));
        assertEquals(3, supermarket.quantity());
        System.out.println(supermarket.quantity());
    }

    @Test
    void quantityTest() {
        assertEquals(4, supermarket.quantity());
        System.out.println(supermarket.quantity());
    }

    @Test
    void totalPriceTest() {
        assertEquals(30, supermarket.totalPrice());
        System.out.println("Total Price: " + supermarket.totalPrice());
    }
    @Test
    void sortFoodByBarcode(){
        Arrays.sort(foods, (f1, f2) -> Integer.compare(f1.getBarCode(), f2.getBarCode()));
        printFood(foods);
    }
    @Test
    void sortFoodByExpDate(){
        Arrays.sort(foods, (f1, f2) ->Long.compare(f1.getExpDate(), f2.getExpDate()));
        printFood(foods);
    }
    @Test
    void sortByName(){
        Arrays.sort(foods, (f1, f2)-> f1.getName().compareTo(f2.getName()));
        printFood(foods);
    }
    private void printFood(Object[] arr){
        for (int i = 0; i < arr.length ; i++) {
            System.out.println(arr[i]);
        }
    }
}