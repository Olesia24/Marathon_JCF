package practice.pet_hotel.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.pet_hotel.dao.PetHotel;
import practice.pet_hotel.dao.PetTreeSetImpl;
import practice.pet_hotel.model.Cats;
import practice.pet_hotel.model.Dogs;
import practice.pet_hotel.model.Pet;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PetHotelImplTest {
    PetHotel petHotel;
    Pet[] pets;

    @BeforeEach
    void setUp() {
        petHotel= new PetTreeSetImpl(6);
        pets = new Pet[5];
        pets[0] = new Cats(1998, "Bella", 8, "Persian cat", 10, 20.5);
        pets[1] = new Cats(6312, "Luna", 3, "British cat", 3, 20.5);
        pets[2] = new Cats(3456, "Lily", 5, "Siamese cat", 14, 20.5);
        pets[3] = new Dogs(9467, "Poppi", 8, "Labrador", 7, 40.5);
        pets[4] = new Dogs(8756, "Molly", 1, "Bulldog", 5, 40.50);
        for (int i = 0; i <pets.length ; i++) {
            petHotel.addPet(pets[i]);
        }
    }

    @Test
    void addPetTest() {
        assertFalse(petHotel.addPet(null));
        assertFalse(petHotel.addPet(pets[0]));
        Pet pet1 = new Dogs(7564, "Tilly", 5, "-", 3, 15 );
        assertTrue(petHotel.addPet(pet1));
        Pet pet2 = new Cats(2378, "Cat", 13, "No name", 2, 20);
        assertFalse(petHotel.addPet(pet2));
        assertEquals(6, petHotel.quantity());
    }

    @Test
    void removePetTest() {
        assertEquals(pets[0], petHotel.removePet(1998));
        assertEquals(4, petHotel.quantity());
    }

    @Test
    void findPetTest() {
        assertEquals(pets[0], petHotel.findPet(1998));
        System.out.println(petHotel.findPet(1998));
    }

    @Test
    void quantityTest() {
        assertEquals(5, petHotel.quantity());
    }
    @Test
    void printPetsByIdTest() {
        petHotel.printPets();
    }
    @Test
    void totalPriceTest() {
        assertEquals(142.5, petHotel.totalPrice());
    }
    @Test
    void sortPetsById(){
        Arrays.sort(pets, (p1, p2)-> Integer.compare(p1.getId(), p2.getId()));
        printArr(pets);
    }
    @Test
    void sortPetsByBreed(){
        Arrays.sort(pets, (p1, p2)-> p1.getBreed().compareTo(p2.getBreed()));
        printArr(pets);
    }
    private static void printArr(Object[] arr){
        for (int i = 0; i < arr.length ; i++) {
            System.out.println(arr[i]);
        }
    }
}