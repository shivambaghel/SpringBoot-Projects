package org.prateek.Basics.UML;

// Teacher class
class Teacher {
    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void teach(Student student) {
        System.out.println(name + " is teaching " + student.getName());
    }
}

// Student class
class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class AssociationExample {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Miss Neha");
        Student student = new Student("Rahul");

        // Association between teacher and student
        teacher.teach(student); // Output: Mr. Smith is teaching John
    }
}