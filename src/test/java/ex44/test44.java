package ex44;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import static ex44.app44.searchForProduct;
import static org.junit.jupiter.api.Assertions.*;

import ex44.app44;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
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
public @interface test44 {
    class testapp44 {

        //  private final Calculator calculator = new Calculator();
        @Test
        void testCreateSiteName() throws ParseException {
            String json = "{\n" +
                    "  \"products\" : [\n" +
                    "    {\"name\": \"Widget\", \"price\": 25.00, \"quantity\": 5 },\n" +
                    "    {\"name\": \"Thing\", \"price\": 15.00, \"quantity\": 5 },\n" +
                    "    {\"name\": \"Doodad\", \"price\": 5.00, \"quantity\": 10 }\n" +
                    "  ]\n" +
                    "}\n";
            JSONParser parser = new JSONParser();
            JSONObject a = (JSONObject) parser.parse(json);
            JSONArray products = (JSONArray) a.get("products");
            app44.Product notThere = searchForProduct(products, "iPad");
            assertEquals(false, notThere.found);
            app44.Product there = searchForProduct(products, "Thing");
            assertEquals(true, there.found);
            assertEquals("Thing", there.name);
            assertEquals(15.00, there.price);
            assertEquals(5, there.quantity);
        }
    }
}
