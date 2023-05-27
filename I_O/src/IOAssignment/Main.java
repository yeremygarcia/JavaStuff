package IOAssignment;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader input1 = new BufferedReader(new FileReader("src/IOAssignment/input1.txt"));
            BufferedReader input2 = new BufferedReader(new FileReader("src/IOAssignment/input2.txt"));
            BufferedWriter merged = new BufferedWriter(new FileWriter("src/IOAssignment/merged.txt"));

            mergeBothFiles(input1, input2, merged);
            printNumbersInConsole();
            commonIntegers();


        } catch (
                FileNotFoundException e) {
            System.err.println("One or more input files not found! Please ensure the file is located in the selected directory.");
        } catch (IOException e) {
            System.err.println("An error occurred while reading/writing the files. Please troubleshoot further why this is occurring.");
        } catch (NumberFormatException e) {
            System.err.println("One or more files contain invalid integers. If a space is taking a line, remove the space. Only integers should be in this file.");
        }
    }

    private static void mergeBothFiles(BufferedReader input1, BufferedReader input2, BufferedWriter merged) {
        String first;
        String second;

        try {
            while (true) {
                first = input1.readLine();
                second = input2.readLine();

                if (first == null && second == null) {
                    break;
                }

                if (first != null) {
                    int number1 = Integer.parseInt(first);
                    merged.write(first);
                    merged.newLine();
                }

                if (second != null) {
                    int number2 = Integer.parseInt(second);
                    merged.write(second);
                    merged.newLine();
                }
            }
            System.out.println("Input1.txt and Input2.txt have been merged!");
            input1.close();
            input2.close();
            merged.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("One or more files contain invalid integers. If a space is taking a line, remove the space. Only integers should be in this file.");
        }

    }


    private static void commonIntegers() {
        try {
            BufferedReader input1 = new BufferedReader(new FileReader("src/IOAssignment/input1.txt"));
            BufferedReader input2 = new BufferedReader(new FileReader("src/IOAssignment/input2.txt"));
            BufferedWriter common = new BufferedWriter(new FileWriter("src/IOAssignment/common.txt"));

            Set<Integer> commonIntegers = new HashSet<>();

            String line;
            while ((line = input1.readLine()) != null) {
                int number = Integer.parseInt(line);
                commonIntegers.add(number);
            }


            while ((line = input2.readLine()) != null) {
                int number = Integer.parseInt(line);
                if (commonIntegers.contains(number)) {
                    common.write(Integer.toString(number));
                    common.newLine();
                }
            }
            System.out.println(" ");
            System.out.println("Common Integers from both txt files have been added to the common.txt file!");
            input1.close();
            input2.close();
            common.close();

        } catch (FileNotFoundException e) {
            System.err.println("One or more input files not found! Please ensure the file is located in the selected directory.");
        } catch (IOException e) {
            System.err.println("An error occurred while reading/writing the files. Please troubleshoot further why this is occurring.");
        } catch (NumberFormatException e) {
            System.err.println("One or more files contain invalid integers. If a space is taking a line, remove the space. Only integers should be in this file.");
        }
    }

    private static void printNumbersInConsole() {
        try {
            BufferedReader input1 = new BufferedReader(new FileReader("src/IOAssignment/input1.txt"));
            BufferedReader input2 = new BufferedReader(new FileReader("src/IOAssignment/input2.txt"));

            String consoleLine;

            System.out.println(" ");
            System.out.println("Integers inside input1.txt:");
            while ((consoleLine = input1.readLine()) != null) {
                System.out.println(consoleLine);
            }

            System.out.println(" ");
            System.out.println("Integers inside input2.txt:");
            while ((consoleLine = input2.readLine()) != null) {
                System.out.println(consoleLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

