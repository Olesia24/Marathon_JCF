package practice.school.dao;

import practice.school.model.Person;
import practice.school.model.Student;

import java.util.LinkedList;

public class SchoolLinkedListImpl implements School {
    private LinkedList<Person> schoolsList;
    private int capacity;

    public SchoolLinkedListImpl(int capacity){
        this.capacity = capacity;
        this.schoolsList = new LinkedList<>();
    }

    @Override
    public boolean addPerson(Person person) {
        if (person == null || schoolsList.size() == capacity || findPerson(person.getId()) != null) {
            return false;
        }
        schoolsList.add(person);
        return true;
    }

    @Override
    public Person removePerson(int id) {
        Person foundPerson = findPerson(id);
        if (foundPerson != null){
            schoolsList.remove(foundPerson);
        }
        return foundPerson;
    }

    @Override
    public Person findPerson(int id) {
        for (Person p: schoolsList) {
            if (p.getId()==id){
                return p;
            }
        } return null;
    }

    @Override
    public int quantity() {
        return schoolsList.size();
    }

    @Override
    public int quantityOfStudents() {
        int sum = 0;
        for (Person person:schoolsList) {
            if (person instanceof Student){
                sum++;
            }
        }return sum;
    }

    @Override
    public void printPerson() {
        for (Person person:schoolsList) {
            System.out.println(person);
        }
    }

    @Override
    public double totalGrades() {
        double sum = 0;
        for (Person person: schoolsList) {
            if (person instanceof Student){
                sum += ((Student) person).getAverageGrade();
            }
        } return sum/quantityOfStudents();
    }
}
