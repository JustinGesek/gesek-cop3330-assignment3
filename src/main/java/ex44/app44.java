package ex44;
/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Justin Gesek
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
//Print out the product name, price, and quantity if the product is found. If no product matches the search, state that no product was found and start over.
//
//Example Output
//What is the product name? iPad
//Sorry, that product was not found in our inventory.
//What is the product name? Galaxy
//Sorry, that product was not found in our inventory.
//What is the product name? Thing
//Name: Thing
//Price: 15.00
//Quantity: 5
//Constraints
//The file is in the JSON format. Use a JSON parser to pull the values out of the file (e.g. https://github.com/google/gson (Links to an external site.)).
//If no record is found, prompt again.
public class app44 {
    public static void main(String[] args) {
        try {
            // use a jsonparser to read the input
            JSONParser parser = new JSONParser();
            JSONObject a = (JSONObject) parser.parse(new FileReader("C:\\Users\\Justin Gesek\\IdeaProjects\\BookExample1\\temt\\gesek-cop3330-assignment3\\src\\main\\java\\ex44\\exercise44_input.json"));

            JSONArray products = (JSONArray) a.get("products");
            Scanner scanner = new Scanner(System.in);
            boolean found = false;
            //ask for a product name and search for it until we find a match.
            while(!found)
            {
                //ask for product name
                System.out.print("What is the product name? ");
                String productName = scanner.nextLine().trim();
                //search products for name.
                for (Object p : products)
                {
                    JSONObject product = (JSONObject) p;
//try to match given name to product name.
                    String name = (String) product.get("name");
                    if (productName.equalsIgnoreCase(name))
                    {
                        //names match so write the name, price and quantity and remember we found a match.
                        System.out.println("Name: "+name);

                        double price = (double) product.get("price");
                        System.out.println("Price: "+price);

                        long quantity = (long) product.get("quantity");
                        System.out.println("Quantity: "+quantity);
                        found = true;
                        break;
                    }
                }
                //we found a match we are done
                if (found)
                {
                    break;
                }
                //we didn't find a match tell the user.
                System.out.println("Sorry, that product was not found in our inventory. ");
            }
        }catch (FileNotFoundException e)
        {
            System.out.println("FileNotFoundException");

            return;
        }
        catch (IOException e)
        {
            System.out.println("IOException");

            return;
        }
        catch (ParseException e)
        {
            System.out.println("ParseException");
            return;
        }
    }
}
