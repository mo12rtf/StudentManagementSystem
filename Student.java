package com.ejada.studentmanagement;


import java.util.ArrayList;

public class Student {

    private int studentId;
    private String name;
    private int age;
    private ArrayList<Integer> marks;

    public Student(int studentId, String name, int age) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.marks = new ArrayList<>();
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public ArrayList<Integer> getMarks() {
        return marks;
    }

    public void addMark(int mark) {
        marks.add(mark);
    }

    public double calculateAverage() {

        if (marks.isEmpty()) {
            return 0;
        }

        int sum = 0;

        for (int mark : marks) {
            sum += mark;
        }

        return (double) sum / marks.size();
    }

    public String calculateGrade() {

        double average = calculateAverage();

        if (average >= 90)
            return "A";
        else if (average >= 80)
            return "B";
        else if (average >= 70)
            return "C";
        else if (average >= 60)
            return "D";
        else
            return "F";
    }

    public void printInfo() {

        System.out.println("ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Number of Marks: " + marks.size());
        System.out.println("Average: " + calculateAverage());
        System.out.println("Grade: " + calculateGrade());
        System.out.println("-------------------------");
    }
}

