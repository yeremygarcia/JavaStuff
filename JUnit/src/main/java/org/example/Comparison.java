package org.example;
public class Comparison {
    public boolean compareNumbers(int num1, int num2) {
        if (num1 == num2) {
            System.out.println("The numbers are equal.");
            return true;
        } else if (num1 > num2) {
                System.out.println("The first number is larger than the second number.");return false;
        } else {
                System.out.println("The second number is larger than the first number.");
                return false;
            }
        }
    }
