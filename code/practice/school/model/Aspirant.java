package practice.school.model;

public class Aspirant extends Person {
    int experience;

    public Aspirant(int id, String name, String lastName, int age, int experience) {
        super(id, name, lastName, age);
        this.experience = experience;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public int compareTo(Person o) {
        return this.id - o.id;
    }
}
