package ex46;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import static ex46.app46.countWords;
import static org.junit.jupiter.api.Assertions.*;

import ex45.app45;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public @interface test46 {
    class testapp46 {

        //  private final Calculator calculator = new Calculator();
        @Test
        void testNames() throws ParseException {
            String input = "badger badger badger\n" +
                    "badger mushroom\n" +
                    "mushroom snake badger badger\n" +
                    "badger\n";
            Scanner scanner = new Scanner(input);
            Map<String, Long> words = countWords(scanner);
            assertEquals(7,words.get("badger"));
        }
    }
}
