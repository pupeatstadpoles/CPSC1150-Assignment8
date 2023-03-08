
/**
 * Program Name: Records
 * Author: Pup Abdulgapul
 * Student ID: 100362791
 * Date: Nov 4, 2022
 * Course: CPSC1150-03
 * Professor: Hengameh Hamavand
 */

import java.io.*;
import java.util.*;

public class Records { // Program to facilitate access to student records
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in); // user input
        String name;
        int choice;
        File record = new File("classList.txt"); // the file we are checking

        boolean running = true;

        do {
            System.out.println(
                    "\nPlease choose an option: \n1. To display a specific student's record\n2. To calculate the final exam average\n3. To find a student with the highest score on the final exam\n4. To copy the students' records to another file\n5. To terminate the program");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("\nPlease enter the student's full name.");
                    name = input.nextLine();
                    display(record, name);
                    break;
                case 2:
                    average(record);
                    break;
                case 3:
                    highest(record);
                    break;
                case 4:
                    System.out.print("Please enter the file name with the file extension (eg. example.txt). ");
                    String output = input.nextLine();
                    copier(output, record);
                    break;
                case 5:
                    System.out.println("\nTerminating program.");
                    running = false;
                    break;
                default:
                    System.out.println("\nError: invalid input. Please make a choice from 1-5.");
            }
        } while (running);
    }

    /**
     * Displays the records of a certain student
     * 
     * @param scan is the scanner attached to the class list
     * @param n    is the user inputted student name
     */
    public static void display(File f, String n) throws FileNotFoundException {
        String result = "No match.";
        Scanner scan = new Scanner(f);
        while (scan.hasNextLine()) {
            String student = scan.nextLine(); // string made from that student's record
            if (student.length() > 13) {
                String sub = student.substring(9, student.lastIndexOf(':')); // get name only
                if (n.equalsIgnoreCase(sub)) { // if the names are the same, print out their details
                    result = student;
                    System.out.println("\nName: " + n);
                    System.out.println("ID: " + result.substring(0, 8));
                    System.out.println("Final: " + result.substring(result.lastIndexOf(':') + 1));
                }
            }
        }
        if (result.equalsIgnoreCase("No match.")) { // print if no match was found (ie. result never changed to the
                                                    // student match)
            System.out.println(result);
        }
        scan.close();
    }

    /**
     * Calculates the average of the scores in the file
     * 
     * @param scan is a scanner attached to the file of students
     */
    public static void average(File f) throws FileNotFoundException {
        Scanner scan = new Scanner(f);
        String s = "\nThe final exam average is: ";
        double sum = 0.0, a;
        int count = 0; // number of students in the file
        while (scan.hasNextLine()) {
            String score = scan.nextLine(); // string made from that student's record
            if (score.length() > 13) {
                count++;
                score = score.substring(score.lastIndexOf(':') + 1);
                double scoreD = Double.parseDouble(score); // get the score and convert to a double
                sum += scoreD;
            }
        }
        a = sum / count; // calculate the average
        System.out.println(s + a);
        scan.close();
    }

    /**
     * Calculates the student with the highest score in the file given
     * 
     * @param f is the class list being passed through
     */
    public static void highest(File f) throws FileNotFoundException {
        Scanner scan = new Scanner(f);
        String s = "\nThe student with the highest score to the final exam: ";
        int max = 0;
        String student = "", top = "";
        while (scan.hasNextLine()) {
            student = scan.nextLine(); // string made from that student's record
            if (student.length() > 13) { // if the current line is not empty and contains a student record
                String sub = student.substring(9, student.lastIndexOf(':')); // get name only
                String score = student.substring(student.lastIndexOf(':') + 1);
                int sc = Integer.parseInt(score); // s score the student got
                if (sc > max) { // if their score is the highest so far
                    max = sc;
                    top = sub;
                }
            }
        }
        System.out.println(s);
        display(f, top);
        scan.close();
    }

    /**
     * Copies the given file to a new file
     * 
     * @param s is the name of the output file as specified by the user
     * @param f is the file to be copied
     * @throws FileNotFoundException
     */
    public static void copier(String s, File f) throws FileNotFoundException {
        Scanner scan = new Scanner(f);
        File outputFile = new File(s); // make a new file for the output
        PrintWriter outFile = new PrintWriter(outputFile); // attach the printwriter to that output file
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            outFile.println(line);
        }
        outFile.close();
        scan.close();
    }
}
