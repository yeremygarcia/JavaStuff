package org.example;

public class TestScores {
public class TestScores {
    public String calculateGrade(int grade) {

        // Create Scanner to read User Input
//            Scanner scanner = new Scanner(System.in);

        // Number input
//            System.out.println("Name a number between 0 and 100");

        // The number provided by the user will be assigned to the grade variable
        // Scanner will read the input
//            grade = Integer.valueOf(scanner.nextLine());

        if (grade >= 0 && grade < 60) {
            System.out.println("Your grade is an F");
            return "F";
        } else if (grade >= 60 && grade < 70) {
            System.out.println("Your grade is a D");
            return "D";
        } else if (grade >= 70 && grade < 80) {
            System.out.println("Your grade is a C");
            return "C";
        } else if (grade >= 80 && grade < 90) {
            System.out.println("Your grade is a B");
            return "B";
        } else if (grade >= 90) {
            System.out.println("Your grade is an A");
            return "A";
        }
        return null;
    }
}
