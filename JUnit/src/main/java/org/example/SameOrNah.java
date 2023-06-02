package org.example;

public class SameOrNah {

import java.util.Scanner;
        public boolean compareWords(String wordOne, String wordTwo) {
            if (wordOne == null || wordTwo == null) {
                throw new IllegalArgumentException("Input words should not be null");
            }

            if (wordOne.equalsIgnoreCase(wordTwo)) {
                System.out.println("The strings are the same.");
                return true;
            } else {
                System.out.println("The strings are different.");
                return false;
            }
        }
    }
