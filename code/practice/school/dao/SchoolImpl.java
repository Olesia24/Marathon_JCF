package practice.school.dao;

import practice.school.model.Person;
import practice.school.model.Student;

public class SchoolImpl implements School{

    private Person[] people;
    private int size;

    public SchoolImpl(int capacity){
        people = new Person[capacity];
    }
    @Override
    public boolean addPerson(Person person) {
        if (person == null || size == people.length || findPerson(person.getId()) != null){
            return false;
        }
        people[size] = person;
        size++;
        return true;
    }

    @Override
    public Person removePerson(int id) {
        for (int i = 0; i <size ; i++) {
            if (people[i].getId()==id){
                Person victim = people[i];
                people[i] = people[size-1];
                people[size-1] = null;
                size--;
                return victim;
            }
        } return null;
    }

    @Override
    public Person findPerson(int id) {
        for (int i = 0; i <size ; i++) {
            if (people[i].getId()==id){
                return people[i];
            }
        } return null;
    }

    @Override
    public int quantity() {
        return size;
    }

    @Override
    public int quantityOfStudents() {
        int sum = 0;
        for (int i = 0; i <size ; i++) {
            if (people[i] instanceof Student){
                sum++;
            }
        }
        return sum;
    }
    @Override
    public void printPerson() {
        for (int i = 0; i <size ; i++) {
            System.out.println(people[i]);
        }
    }

    @Override
    public double totalGrades() {
        double sum = 0;
        for (int i = 0; i <size ; i++) {
            if (people[i] instanceof Student student){
                sum += student.getAverageGrade();
            }
        } return sum/quantityOfStudents();
    }
}
