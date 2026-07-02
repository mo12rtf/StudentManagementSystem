package com.ejada.studentmanagement;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementApp {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Add Mark");
            System.out.println("3. Display Students");
            System.out.println("4. Search Student");
            System.out.println("5. Top Student");
            System.out.println("6. Exit");

            System.out.print("Enter Choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    addMark();
                    break;

                case 3:
                    displayStudents();
                    break;

                case 4:
                    searchStudent();
                    break;

                case 5:
                    showTopStudent();
                    break;

                case 6:
                    System.out.println("Application Closed.");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

        } while (choice != 6);
    }

    public static void addStudent() {

        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();

        scanner.nextLine();

        for (Student s : students) {

            if (s.getStudentId() == id) {
                System.out.println("Student ID already exists.");
                return;
            }
        }

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        if (name == null || name.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();

        if (age <= 0) {
            System.out.println("Age must be greater than 0.");
            return;
        }

        students.add(new Student(id, name, age));

        System.out.println("Student Added Successfully.");
    }

    public static void addMark() {

        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();

        Student student = findStudent(id);

        if (student == null) {
            System.out.println("Student Not Found.");
            return;
        }

        System.out.print("Enter Mark: ");
        int mark = scanner.nextInt();

        if (mark < 0 || mark > 100) {
            System.out.println("Mark must be between 0 and 100.");
            return;
        }

        student.addMark(mark);

        System.out.println("Mark Added Successfully.");
    }

    public static void displayStudents() {

        if (students.isEmpty()) {
            System.out.println("No Students Found.");
            return;
        }

        for (Student s : students) {
            s.printInfo();
        }
    }

    public static void searchStudent() {

        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();

        Student student = findStudent(id);

        if (student == null)
            System.out.println("Student Not Found.");
        else
            student.printInfo();
    }

    public static void showTopStudent() {

        if (students.isEmpty()) {
            System.out.println("No Students Available.");
            return;
        }

        Student topStudent = students.get(0);

        for (Student s : students) {

            if (s.calculateAverage() > topStudent.calculateAverage()) {
                topStudent = s;
            }
        }

        System.out.println("Top Student:");
        topStudent.printInfo();
    }

    public static Student findStudent(int id) {

        for (Student s : students) {

            if (s.getStudentId() == id) {
                return s;
            }
        }

        return null;
    }
}