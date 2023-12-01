package practice.school.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.school.dao.School;
import practice.school.dao.SchoolTreeSetImpl;
import practice.school.model.Aspirant;
import practice.school.model.Person;
import practice.school.model.Professor;
import practice.school.model.Student;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SchoolImplTest {
    School school;
    Person[] people;

    @BeforeEach
    void setUp() {
        school = new SchoolTreeSetImpl(9);
        people = new Person[8];
        people[0] = new Student(1002, "John", "Smith", 19, 2);
        people[1] = new Student(3402, "Marc", "Smith", 17, 1);
        people[2] = new Student(6702, "Steve", "Smith", 22, 3);
        people[3] = new Student(4302, "Anna", "Smith", 20, 4);
        people[4] = new Aspirant(1112, "Elke", "Smith", 30, 5);
        people[5] = new Aspirant(2221, "Maria", "Smith", 40, 15);
        people[6] = new Professor(4565, "Stephen", "Smith", 50, 20);
        people[7] = new Professor(9856, "Alex", "Smith", 46, 14);

        for (int i = 0; i <people.length ; i++) {
            school.addPerson(people[i]);
        }
    }
    @Test
    void addPersonTest() {
        assertFalse(school.addPerson(null));
        assertFalse(school.addPerson(people[0]));
        Person person = new Student(9998, "Valentin", "Smith", 25, 1);
        assertTrue(school.addPerson(person));
        Person person2 = new Student(3452, "Valentin", "Smith", 25, 1);
        assertFalse(school.addPerson(person2));
        assertEquals(9, school.quantity() );
    }
    @Test
    void removePersonTest() {
        assertEquals(people[1], school.removePerson(3402));
        assertEquals(7, school.quantity());
    }

    @Test
    void findPersonTest() {
    assertEquals(people[0], school.findPerson(1002) );
        System.out.println(people[0]);
    }

    @Test
    void quantityTest() {
        assertEquals(8, school.quantity());
    }
    @Test
    void quantityOfStudentsTest(){
        assertEquals(4, school.quantityOfStudents());
    }
    @Test
    void totalGradesTest() {
        school.totalGrades();
        System.out.println(school.totalGrades());
    }
    @Test
    void sortPersonByIdTest(){
        Arrays.sort(people, (p1, p2)-> Integer.compare(p1.getId(), p2.getId()));
        printArray(people);
    }
    @Test
    void sortPersonByLastName(){
        Arrays.sort(people, (p1, p2)-> p1.getName().compareTo(p2.getName()));
        printArray(people);
    }
    private void printArray(Object[] arr){
        for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]);
        }
    }

}