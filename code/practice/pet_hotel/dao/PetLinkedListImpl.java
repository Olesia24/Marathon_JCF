package practice.pet_hotel.dao;

import practice.pet_hotel.model.Pet;

import java.util.LinkedList;

public class PetLinkedListImpl implements PetHotel {
    private LinkedList<Pet> petHotelsList;
    private int capacity;

    public PetLinkedListImpl(int capacity){
        this.capacity = capacity;
        this.petHotelsList = new LinkedList<>();
    }

    @Override
    public boolean addPet(Pet pet) {
        if (pet == null || petHotelsList.size() == capacity || findPet(pet.getId()) != null) {
            return false;
        }
        petHotelsList.add(pet);
        return true;
    }

    @Override
    public Pet removePet(int id) {
        Pet foundPet = findPet(id);
        if (foundPet != null){
            petHotelsList.remove(foundPet);
        }
        return foundPet;
    }

    @Override
    public Pet findPet(int id) {
        for (Pet pet: petHotelsList) {
            if (pet.getId()==id){
                return pet;
            }
        } return null;
    }

    @Override
    public int quantity() {
        return petHotelsList.size();
    }

    @Override
    public void printPets() {
        for (Pet pet:petHotelsList) {
            System.out.println(pet);
        }
    }

    @Override
    public double totalPrice() {
        double sum = 0;
        for (Pet pet:petHotelsList) {
            sum += pet.getPricePerDay();
        }
        return sum;
    }
}
