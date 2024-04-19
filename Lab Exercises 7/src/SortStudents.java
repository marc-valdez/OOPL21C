/*
 * Author: Marc Valdez
 * Section: C231_CS
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Student {
    static Scanner sc = new Scanner(System.in);
    private final String name;
    private double score;

    public Student(int i) {
        System.out.print("Enter student " + (i + 1) + "'s name >> ");
        this.name = sc.nextLine().trim();
        while (true) {
            System.out.print("Enter student " + (i + 1) + "'s score >> ");
            String buffer = sc.nextLine().trim();
            try {
                this.score = Double.parseDouble(buffer);
                break;
            } catch (Exception e) {
                System.out.println("! Input is NaN. Please try again.");
            }
        }
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }
}

public class SortStudents {
    static final int MIN_STUDENTS = 10;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int numStudents;
        while (true) {
            System.out.print("Enter the number of students (minimum 10) >> ");
            String buffer = sc.nextLine().trim();
            try {
                numStudents = Integer.parseInt(buffer);
                if (numStudents < MIN_STUDENTS) {
                    System.out.println("! Input must be at least {" + MIN_STUDENTS + "}. Please try again.");
                }
                break;
            } catch (Exception e) {
                System.out.println("! Invalid input. Please try again.");
            }
        }

        List<Student> students = new ArrayList<>(numStudents);
        for (int i = 0; i < numStudents; i++) {
            students.add(new Student(i));
        }

        students.sort(Comparator.comparingDouble(Student::getScore).reversed());

        System.out.println("Students sorted by decreasing score:");
        for (int i = 0; i < numStudents; i++) {
            System.out.println(students.get(i).getScore() + "\t| " + students.get(i).getName());
        }
    }
}