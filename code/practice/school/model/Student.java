package practice.school.model;

public class Student extends Person {
    int averageGrade;

    public Student(int id, String name, String lastName, int age, int averageGrade) {
        super(id, name, lastName, age);
        this.averageGrade = averageGrade;
    }

    public int getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(int averageGrade) {
        this.averageGrade = averageGrade;
    }

    @Override
    public int compareTo(Person o) {
        return this.id-o.id;
    }
}
