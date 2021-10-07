package ex46;
/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Justin Gesek
 */
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
///Create a program that reads in a file named `exercise46_input.txt` and counts the frequency of words in the file. Then construct a histogram displaying the words and the frequency, and display the histogram to the screen.
//
//Example Output
//Given the text file `exercise46_input.txt` with this content
//
//badger badger badger
//badger mushroom
//mushroom snake badger badger
//badger
//the program would produce the following output:
//
//badger:   *******
//mushroom: **
//snake:    *
//Constraint
//Ensure that the most used word is at the top of the report and the least used words are at the bottom.
public class app46 {
    public static Map<String, Long> countWords(Scanner scanner)
    {
        Pattern pattern = Pattern.compile("\\w+");
        Map<String, Long> words = new TreeMap<String, Long>();
        //read each line and for each line we match a regular expression looking for groups of one or more word characters
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            Matcher match = pattern.matcher(line);
            //for each match we sure there is an entry in the map if there isn't we make one and increment the count.
            while(match.find())
            {
                String word = match.group();
                if(words.containsKey(word))
                {
                    words.put(word, words.get(word) + 1L);
                }
                else
                {
                    words.put(word, 1L);
                }
            }
        }
        return words;
    }
    public static void main(String[] args) {
        try {
            // use a map of string to long, string is a word and long is a count of how many times we saw that word
            FileReader input = new FileReader("C:\\Users\\Justin Gesek\\IdeaProjects\\BookExample1\\temt\\gesek-cop3330-assignment3\\src\\main\\java\\ex46\\exercise46_input.txt");
            Scanner scanner = new Scanner(input);
            Map<String, Long> words = countWords(scanner);
            //for each entry in the map we write the key(word) and then a number of stars based on the count.
            for (Map.Entry<String, Long> word: words.entrySet())
            {
                System.out.printf("%-10s ", word.getKey());
                for (int i = 0; i < word.getValue(); ++i)
                {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("FileNotFoundException");
        }
    }
}