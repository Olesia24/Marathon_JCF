package practice.pet_hotel.model;

public class Cats extends Pet {
    public Cats(int id, String name, int age, String breed, int days, double pricePerDay) {
        super(id, name, age, breed, days, pricePerDay);
    }

    @Override
    public int compareTo(Pet o) {
        return this.getId()-o.getId();
    }
}
