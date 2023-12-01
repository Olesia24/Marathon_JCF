package practice.shop.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.shop.dao.Shop;
import practice.shop.dao.ShopTreeSetImpl;
import practice.shop.model.Laptop;
import practice.shop.model.Product;
import practice.shop.model.Smartphone;
import practice.shop.model.Tablet;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
class ShopImplTest {
    Shop shop;
    Product[] products;

    @BeforeEach
    void setUp() {
        shop = new ShopTreeSetImpl(7);
        products = new Product[6];
       products[0] = new Smartphone(567, "Google", 850, 5, 13, 25, "Google");
       products[1] = new Smartphone(654, "Samsung", 550, 10, 13, 25, "Google");
       products[2] = new Laptop(123, "HP",1000, 0, 4, 1);
       products[3] = new Laptop(234, "Fujitsu",500, 15, 4, 1);
       products[4] = new Tablet(356,"Apple", 800, 10, 12, 512);
       products[5] = new Tablet(456,"Xiomi", 300, 0,  12, 512);
        for (int i = 0; i < products.length ; i++) {
            shop.addProduct(products[i]);
        }
    }

    @Test
    void addProductTest() {
        assertFalse(shop.addProduct(null));
        assertFalse(shop.addProduct(products[0]));
        Product product6 = new Smartphone(700, "Apple", 1000, 12, 10,20, "Google");
        assertTrue(shop.addProduct(product6));
        Product product7 = new Smartphone(710, "Appleу", 1001, 13, 11,21, "Googleу");
        assertFalse(shop.addProduct(product7));
        assertEquals(7, shop.quantity());
    }

    @Test
    void removeProductTest() {
        assertEquals(products[1], shop.removeProduct(654));
        assertEquals(5, shop.quantity());
        //assertEquals(products[1], shop.removeProduct(200));
    }

    @Test
    void findProductTest() {
        assertEquals(products[1], shop.findProduct(654));
        assertEquals(products[0], shop.findProduct(567));

    }

    @Test
    void quantityTest() {
        assertEquals(6, shop.quantity());
    }

    @Test
    void totalSumTest(){
        assertEquals(4000, shop.totalSum());
    }

    @Test
    void saleBlackFridayTest(){
        assertEquals(40, shop.saleBlackFriday());
    }
    @Test
    void totalSalaryPriceTest(){
        assertEquals(252.5, shop.totalSalaryPrice());
        System.out.println("Total salary price: " + shop.totalSalaryPrice() + " Euro");
    }
    @Test
    void sortShopByBarCodeTest(){
        Arrays.sort(products, (p1, p2)-> Integer.compare(p1.getBarCode(), p2.getBarCode()));
        printArray(products);
    }
    @Test
    void sortByPriceTest(){
        Arrays.sort(products, (p1, p2)-> Double.compare(p1.getPrice(), p2.getPrice()));
        printArray(products);
    }
    @Test
    void sortByNameTest(){
        Arrays.sort(products, (p1, p2)-> p1.getName().compareTo(p2.getName()) );
        printArray(products);
    }
    private void printArray(Object[] arr){
        for (int i = 0; i < arr.length ; i++) {
            System.out.println(arr[i]);
        }
    }
}