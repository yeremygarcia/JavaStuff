package org.example;

import java.util.Scanner;
public class Calculations {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number:");

        int num1 = Integer.valueOf(scanner.nextLine());

        System.out.println("Enter another number: ");

        int num2 = Integer.valueOf(scanner.nextLine());


        int addition = num1 + num2;
        int subtraction = num1 - num2;
        int multiplication = num1 * num2;
        double division = Double.valueOf(num1) / Double.valueOf(num2);
        int modulus = num1 % num2;

        System.out.println(num1 + " + " + num2 + " = " + addition);
        System.out.println(num1 + " - " + num2 + " = " + subtraction);
        System.out.println(num1 + " * " + num2 + " = " + multiplication);
        System.out.println(num1 + " / " + num2 + " = " + division);
        System.out.println(num1 + " % " + num2 + " = " + modulus);
    }

    public int add(int num1, int num2) {
        return num1 + num2;
    }

    public int sub(int num1, int num2) {
        return num1 - num2;
    }

    public int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public double divide(int num1, int num2) {
        return num1 / num2;
    }

    public double modulus(int num1, int num2) {
        return num1 % num2;
    }
}
