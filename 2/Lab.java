package com.company;


public class Lab {
    private Student[] students;
    private Student[] queue;
    private int avg;
    private String day;
    private int capacity;
    private int currentSize;
    private int queueCap;
    private int queueCurrent;

    /**
     * @param cap capacity of Lab
     * @param d   day of Lab
     */
    public Lab(int cap, String d) {
        capacity = cap;
        students = new Student[cap];
        day = d;
        currentSize = 0;
        queueCap = 20;
        queue = new Student[queueCap];
    }

    /**
     * @param std get one student and enroll if lab is not full
     */
    public void enrollStudent(Student std) {
        if (currentSize < capacity) {
            students[currentSize] = std;
            currentSize++;
        } else {
            System.out.println("Lab is full!!!");
            setQueue(std);
        }
    }

    /**
     * @param std send student to lab Queue list
     */
    private void setQueue(Student std) {
        if (queueCurrent < queueCap) {
            queue[queueCurrent] = std;
            queueCurrent++;
        } else {
            System.out.println("Lab's queue is also full.!");
        }
    }

    /**
     * remove the first student and update queue
     */
    private void updateQueue() {
        if (queueCurrent - 1 >= 0) System.arraycopy(queue, 1, queue, 0, queueCurrent - 1);
        queue[queueCurrent] = null;
    }

    /**
     * @param std take an student and unEnrollStudent that student
     */
    public void unEnrollStudent(Student std) {
        int stdNumber = -1;
        for (int i = 0; i < students.length; i++) {
            if (students[i] == std) {
                stdNumber = i;
            }
            if (stdNumber >= 0) {
                if (i == students.length - 1) {
                    if (queueCurrent > 0) {
                        students[i] = queue[0];
                        updateQueue();
                        queueCurrent--;

                    } else {
                        students[i] = null;
                        currentSize--;
                    }
                    break;
                }
                students[i] = students[i + 1];
            }
        }
    }


    /**
     * Print avg then the student
     */
    public void print() {
        System.out.println("this lab is held on: " + day + " and its capacity is: " + capacity);
        System.out.println("the number of enrolled students is: " + currentSize);
        calculateAvg();
        System.out.println("This is the grade of students: " + avg);
        for (int i = 0; i < currentSize; i++) {
            students[i].print();
        }
        if (queueCurrent > 0) {
            System.out.println("This is the queue of Lab: ");
            System.out.println(queueCurrent + "student(s) are in the queue.");
            for (int i = 0; i < queueCurrent; i++) {
                queue[i].print();
            }
        }
    }

    /**
     * @return the students of Lab
     */
    public Student[] getStudents() {
        return students;
    }

    /**
     * @param students array of students can set
     */
    public void setStudents(Student[] students) {
        for (Student student : students) enrollStudent(student);
    }

    /**
     * @return average
     */
    public int getAvg() {
        calculateAvg();
        return avg;
    }

    /**
     * calculate average
     */
    public void calculateAvg() {
        avg = 0;
        for (int i = 0; i < currentSize; i++) {
            avg += students[i].getGrade();
        }
        avg = avg / currentSize;
    }

    /**
     * @return the day of lab
     */
    public String getDay() {
        return day;
    }

    /**
     * @param day change the day of lab
     */
    public void setDay(String day) {
        this.day = day;
    }

    /**
     * @return capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @param capacity change the capacity of Lab
     */
    public void setCapacity(int capacity) {
        if (capacity > 0) {
            this.capacity = capacity;
        } else {
            System.out.println("you can NOT enter 0 for the capacity of Lab");
        }
    }


}
