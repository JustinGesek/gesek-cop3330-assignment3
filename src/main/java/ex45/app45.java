package ex45;
/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Justin Gesek
 */
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
//Example Output
//Given the input file of
//
//One should never utilize the word "utilize" in writing. Use "use" instead.
//For example, "She uses an IDE to write her Java programs" instead of "She
//utilizes an IDE to write her Java programs".
//The program should generate
//
//One should never use the word "use" in writing. Use "use" instead.
//For example, "She uses an IDE to write her Java programs" instead of "She
//uses an IDE to write her Java programs".
//Constraints
//Prompt for the name of the output file.
//Write the output to a new file.
public class app45 {
    public static String replaceAllUtilize(String line){
        Pattern pattern = Pattern.compile("\\butilize");
        Matcher match = pattern.matcher(line);
        line = match.replaceAll("use");
        return line;
    }
    public static void main(String[] args) {
        try {
            //open input and an output file
            FileReader input = new FileReader("C:\\Users\\Justin Gesek\\IdeaProjects\\BookExample1\\temt\\gesek-cop3330-assignment3\\src\\main\\java\\ex45\\exercise45_input.txt");
            Scanner scanner = new Scanner(input);
            FileWriter out = new FileWriter("C:\\Users\\Justin Gesek\\IdeaProjects\\BookExample1\\temt\\gesek-cop3330-assignment3\\src\\main\\java\\ex45\\exercise45_output.txt");
            while (scanner.hasNext()) {
                // for each line look for matches to any word that starts with utilize and replace it with use.
                String line = replaceAllUtilize(scanner.nextLine());

                // write the updated line to the output.
                out.write(line + "\n");
            }
            out.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("FileNotFoundException");
        }
        catch (IOException e)
        {
            System.out.println("IOException");
        }

    }
}
