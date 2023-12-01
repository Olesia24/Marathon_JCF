package practice.school.dao;

import practice.school.model.Person;
import practice.school.model.Student;

import java.util.HashSet;

public class SchoolHashSetImpl implements School{
    private HashSet<Person> personHashSet;
    int capacity;

    public SchoolHashSetImpl(int capacity){
        this.capacity = capacity;
        this.personHashSet = new HashSet<>();
    }
    @Override
    public boolean addPerson(Person person) {
        if (person == null || personHashSet.size()==capacity) {
            return false;
        }
        return personHashSet.add(person);
    }

    @Override
    public Person removePerson(int id) {
        Person removed = findPerson(id);
        personHashSet.remove(removed);
        return removed;
    }

    @Override
    public Person findPerson(int id) {
        for (Person person:personHashSet) {
            if (person.getId()==id){
                return person;
            }
        } return null;
    }

    @Override
    public int quantity() {
        return personHashSet.size();
    }

    @Override
    public int quantityOfStudents() {
        int sum = 0;
        for (Person person:personHashSet) {
            if (person instanceof Student){
                sum ++;
            }
        } return sum;
    }

    @Override
    public void printPerson() {
        for (Person person:personHashSet) {
            System.out.println(person);
        }
    }

    @Override
    public double totalGrades() {
        double sum = 0;
        for (Person person: personHashSet) {
            if (person instanceof Student ) {
                sum += ((Student) person).getAverageGrade();
            }
        } return sum/quantityOfStudents();
    }
}
