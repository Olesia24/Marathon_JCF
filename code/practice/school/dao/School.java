package practice.school.dao;

import practice.school.model.Person;

public interface School {
    boolean addPerson(Person person);
    Person removePerson(int id);
    Person findPerson(int id);
    int quantity();
    int quantityOfStudents();
    void printPerson();

    double totalGrades();
}
