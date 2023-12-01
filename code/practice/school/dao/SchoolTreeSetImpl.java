package practice.school.dao;

import practice.school.model.Person;
import practice.school.model.Student;

import java.util.TreeSet;

public class SchoolTreeSetImpl implements School {
    private TreeSet<Person> personTreeSet;
    int capacity;
    public SchoolTreeSetImpl(int capacity){
        this.capacity = capacity;
        this.personTreeSet = new TreeSet<>();
    }

    @Override
    public boolean addPerson(Person person) {
        return person != null && personTreeSet.size()<capacity ? personTreeSet.add(person) : false;
    }

    @Override
    public Person removePerson(int id) {
        Person removed = findPerson(id);
        return personTreeSet.removeIf(p -> p.getId()==id) ? removed : null;
    }

    @Override
    public Person findPerson(int id) {
        return personTreeSet.stream()
                .filter(p ->p.getId()==id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public int quantity() {
        return personTreeSet.size();
    }

    @Override
    public int quantityOfStudents() {
        return (int) personTreeSet.stream()
                .filter(p -> p instanceof Student)
                .count();
    }

    @Override
    public void printPerson() {
        personTreeSet.stream()
                .forEach(System.out::println);
    }

    @Override
    public double totalGrades() {
        return personTreeSet.stream()
                .filter(p ->p instanceof Student)
                .mapToDouble(p ->((Student)p).getAverageGrade())
                .average()
                .orElse(0.0);
    }
}
