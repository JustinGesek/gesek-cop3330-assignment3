package ex41;
/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Justin Gesek
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.lang.Math;
//Create a program that reads in the following list of names from a file called `exercise41_input.txt` and sorts the list alphabetically:
//
//Ling, Mai
//Johnson, Jim
//Zarnecki, Sabrina
//Jones, Chris
//Jones, Aaron
//Swift, Geoffrey
//Xiong, Fong
//Then print the sorted list to a file called `exercise41_output.txt` that looks like the following example output.
//
//Example Output
//Total of 7 names
//-----------------
//Johnson, Jim
//Jones, Aaron
//Jones, Chris
//Ling, Mai
//Swift, Geoffrey
//Xiong, Fong
//Zarnecki, Sabrina
//Constraint
//Don't hard-code the number of names.
public class app41 {
    public static ArrayList<String> scanAndSort(Scanner scanner)
    {
        //read input and save the result
        ArrayList<String>names=new ArrayList<String>();
        while(scanner.hasNext())
        {
            names.add(scanner.nextLine());
        }
        //sort the input
        Collections.sort(names);
        return names;
    }
    public static void main(String[] args) {
        //set up a scanner and file to read input.
        Scanner scanner;
        File file;
        try {
            file = new File("C:\\Users\\Justin Gesek\\IdeaProjects\\BookExample1\\temt\\gesek-cop3330-assignment3\\src\\main\\java\\ex41\\exercise41_output.txt");
            scanner = new Scanner(file);

        }catch (FileNotFoundException e)
        {
            System.out.println("Unable to open input file.");
            return;
        }
        ArrayList<String> names = scanAndSort(scanner);
        //write the input formatted as a table
        System.out.printf("Total of %d names.\n", names.size());
        System.out.println("-----------------");
        for (String name: names)
        {
            System.out.println(name);
        }
    }
}
