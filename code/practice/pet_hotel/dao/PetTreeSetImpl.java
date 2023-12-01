package practice.pet_hotel.dao;

import practice.pet_hotel.model.Pet;

import java.util.TreeSet;

public class PetTreeSetImpl implements PetHotel {

    private TreeSet<Pet> petTreeSet;
    int capacity;

    public PetTreeSetImpl(int capacity){
        this.capacity = capacity;
        this.petTreeSet = new TreeSet<>();
    }

    @Override
    public boolean addPet(Pet pet) {
        return pet != null && petTreeSet.size()<capacity ? petTreeSet.add(pet) : false;
    }

    @Override
    public Pet removePet(int id) {
        Pet removed = findPet(id);
        return petTreeSet.removeIf(p ->p.getId()==id) ? removed : null;
    }

    @Override
    public Pet findPet(int id) {
        return petTreeSet.stream()
                .filter(p -> p.getId()==id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public int quantity() {
        return petTreeSet.size();
    }

    @Override
    public void printPets() {
        petTreeSet.stream()
                .forEach(System.out::println);
    }

    @Override
    public double totalPrice() {
        return petTreeSet.stream()
                .mapToDouble(Pet::getPricePerDay)
                .sum();
    }
}
