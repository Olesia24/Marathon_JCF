package practice.pet_hotel.dao;

import practice.pet_hotel.model.Pet;

public class PetHotelImpl implements PetHotel {
    private Pet[] pets;
    private int size;

    public PetHotelImpl(int capacity){
        pets = new Pet[capacity];
    }

    @Override
    public boolean addPet(Pet pet) {
        if (pet == null || size == pets.length || findPet(pet.getId()) != null) {
            return false;
        }
        pets[size] = pet;
        size++;
        return true;
    }

    @Override
    public Pet removePet(int id) {
        for (int i = 0; i <size ; i++) {
            if (pets[i].getId()==id){
                Pet victim = pets[i];
                pets[i]= pets[size-1];
                pets[size-1]= null;
                size--;
                return victim;
            }
        }
        return null;
    }

    @Override
    public Pet findPet(int id) {
        for (int i = 0; i <size ; i++) {
            if (pets[i].getId()==id){
                return pets[i];
            }
        } return null;
    }

    @Override
    public int quantity() {
        return size;
    }

    @Override
    public void printPets() {
        for (int i = 0; i <size ; i++) {
            System.out.println(pets[i]);
        }
    }
    @Override
    public double totalPrice() {
        double sum = 0;
        for (int i = 0; i <size ; i++) {
            if (pets[i].getPricePerDay() !=0){
                sum+= pets[i].getPricePerDay();
            }
        }
        return sum;
    }
}
