package com.company;

/**
 * The com.company.Student class represents a student in a student administration system.
 * It holds the student details relevant in our context.
 *
 * @author Hamidreza
 * @version 0.0
 */
public class Student {
    //    fields
    //the student’s first name
    private String firstName;

    // the student’s last name
    private String lastName;

    // the student ID
    private String id;

    //the grade
    private int grade;

//    constructors

    /**
     * Create a new student with a given name and ID number.
     *
     * @param fName first name of student
     * @param lName last name of student
     * @param sID   student ID
     */
    public Student(String fName, String lName, String sID) {
        firstName = fName;
        lastName = lName;
        id = sID;
//        grade = 0;
    }


    /**
     * get the first name of student
     *
     * @return firstName field
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param fName the first name of student
     */
    public void setFirstName(String fName) {
        firstName = fName;
    }


    /**
     * @param lName the last name of student
     */
    public void setLastName(String lName) {
        lastName = lName;
    }

    /**
     * get the last name of student
     *
     * @return lastName field
     */
    public String getLastName() {
        return lastName;
    }


    /**
     * @param sID the ID of student
     */
    public void setId(String sID) {
        id = sID;
    }

    /**
     * get the ID of student
     *
     * @return id field
     */
    public String getId() {
        return id;
    }


    /**
     * @param grade the ID of student
     */
    public void setGrade(int grade) {
        if (0 <= grade && grade <= 20) {
            this.grade = grade;
        } else {
            System.out.println("the entered grade is NOT correct!");
        }
    }

    /**
     * get the grade of student
     *
     * @return grade field
     */
    public int getGrade() {
        return grade;
    }


    /**
     * Print the student’s last name and ID number to the output terminal.
     */
    public void print() {
        System.out.println(lastName + ", student ID: " + id + ", grade: " + grade);
    }


//    methods
}
