package practice.pet_hotel.dao;

import practice.pet_hotel.model.Pet;

import java.util.HashSet;

public class PetHashSetImpl implements PetHotel {
    private HashSet<Pet> petHashSet;
    int capacity;

    public PetHashSetImpl(int capacity){
        this.capacity = capacity;
        this.petHashSet = new HashSet<>();
    }
    @Override
    public boolean addPet(Pet pet) {
        if (pet ==null|| petHashSet.size()==capacity) {
            return false;
        }return petHashSet.add(pet);
    }

    @Override
    public Pet removePet(int id) {
        Pet removed = findPet(id);
        petHashSet.remove(removed);
        return removed;
    }

    @Override
    public Pet findPet(int id) {
        for (Pet pet:petHashSet) {
            if (pet.getId()==id){
                return pet;
            }
        } return null;
    }

    @Override
    public int quantity() {
        return petHashSet.size();
    }

    @Override
    public void printPets() {
        for (Pet pet:petHashSet) {
            System.out.println(pet);
        }
    }

    @Override
    public double totalPrice() {
        double sum = 0;
        for (Pet pet:petHashSet) {
            sum += pet.getPricePerDay();
        }
        return sum;
    }
}
