package ex42;
/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Justin Gesek
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
//Sometimes data comes in as a structured format that you have to break down and turn into records so you can process them. CSV, or comma-separated values, is a common standard for doing this.
//
//Construct a program that reads in the following data file (you will need to create this data file yourself; name it `exercise42_input.txt`):
//
//Ling,Mai,55900
//Johnson,Jim,56500
//Jones,Aaron,46000
//Jones,Chris,34500
//Swift,Geoffrey,14200
//Xiong,Fong,65000
//Zarnecki,Sabrina,51500
//Process the records and display the results formatted as a table, evenly spaced, as shown in the example output.
//
//Example Output
//Last      First     Salary
//--------------------------
//Ling      Mai       55900
//Johnson   Jim       56500
//Jones     Aaron     46000
//Jones     Chris     34500
//Swift     Geoffrey  14200
//Xiong     Fong      65000
//Zarnecki  Sabrina   51500
//Constraints
//Write your own code to parse the data. Don't use a CSV parser.
public class app42 {
    public static void main(String[] args) {
        //set up a scanner and file to read input.
        Scanner scanner;
        File file;
        try {
            file = new File("C:\\Users\\Justin Gesek\\IdeaProjects\\BookExample1\\temt\\gesek-cop3330-assignment3\\src\\main\\java\\ex42\\exercise42_input.txt");
            scanner = new Scanner(file);

        }catch (FileNotFoundException e)
        {
            System.out.println("Unable to open input file.");
            return;
        }
        //read input and save the result
        ArrayList<String>names=new ArrayList<String>();
        while(scanner.hasNext())
        {
            names.add(scanner.nextLine());
        }
        //sort the input
        Collections.sort(names);
        //write the input formatted as a table
        System.out.println("Last      First     Salary");
        System.out.println("--------------------------");
        //for each line fo input split at commas and write a formatted entry.
        for (String name: names)
        {
            String [] parts = name.split(",", 0);
            System.out.printf("%-10s%-10s%5s\n", parts[0], parts[1], parts[2]);
        }
    }
}
