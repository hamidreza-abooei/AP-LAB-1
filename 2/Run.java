package com.company;

import java.util.Arrays;

public class Run {

    public static void main(String[] args) {
        // write your code here
        Student std1 = new Student("Ehsan", "Edalat", "9031066");
        Student std2 = new Student("Seyed", "AhmadPanah", "9031806");
        Student std3 = new Student("Ahmad", "Asad", "9031054");
        Student std4 = new Student("Hamidreza", "Abooei", "9731303");
        Student std5 = new Student("Hamidreza1", "Abooei1", "9733002");
        Student[] stds = new Student[2];

        std1.print();
        std1.setGrade(15);
        std1.print();

        std2.print();
        std2.setGrade(11);
        std2.print();

        std3.print();
        std3.setGrade(15);
        std3.setLastName("Asadi");
        std3.print();

        std4.setGrade(18);
        std5.setGrade(16);
        stds[0] = std4;
        stds[1] = std5;

        System.out.println("");

        Lab lab1 = new Lab(4, "2021/march/8");
        for (com.company.Student student : Arrays.asList(std1, std2, std3)) {
            lab1.enrollStudent(student);
        }
        lab1.setStudents(stds);
        lab1.print();
        System.out.println("");
        lab1.unEnrollStudent(std2);

        lab1.print();

    }
}
