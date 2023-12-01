package practice.pet_hotel.dao;

import practice.pet_hotel.model.Pet;

public interface PetHotel {
    boolean addPet(Pet pet);
    Pet removePet(int id);
    Pet findPet(int id);
    int quantity();
    void printPets();
    double totalPrice();
}
