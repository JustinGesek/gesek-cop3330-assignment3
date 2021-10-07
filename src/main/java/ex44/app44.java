package ex44;
/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
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
    public static class Product{
        Boolean found;
        String name;
        Double price;
        long quantity;

    }
    public static Product searchForProduct(JSONArray products, String productName)
    {
        Product result = new Product();
        result.found = false;
            //search products for name.
            for (Object p : products)
            {
                JSONObject product = (JSONObject) p;
//try to match given name to product name.
                String name = (String) product.get("name");
                if (productName.equalsIgnoreCase(name))
                {
                    //names match so write the name, price and quantity and remember we found a match.
                    result.found = true;
                    result.name = name;
                    result.price = (double) product.get("price");
                    result.quantity = (long) product.get("quantity");
                    return result;
                }
            }
        return result;
    }
    public static void main(String[] args) {
        try {
            // use a jsonparser to read the input
            JSONParser parser = new JSONParser();
            JSONObject a = (JSONObject) parser.parse(new FileReader("C:\\Users\\Justin Gesek\\IdeaProjects\\BookExample1\\temt\\gesek-cop3330-assignment3\\src\\main\\java\\ex44\\exercise44_input.json"));

            JSONArray products = (JSONArray) a.get("products");
            Scanner scanner = new Scanner(System.in);
            //ask for a product name and search for it until we find a match.
            while(true)
            {
                //ask for product name
                System.out.print("What is the product name? ");
                String productName = scanner.nextLine().trim();
                //search products for name.
                Product product = searchForProduct(products, productName);
                if (product.found){
                    //we found a match we are done

                    System.out.println("Name: "+product.name);
                    System.out.println("Price: "+product.price);
                    System.out.println("Quantity: "+product.quantity);
                        break;
                }
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
