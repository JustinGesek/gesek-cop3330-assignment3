package ex45;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import static ex45.app45.replaceAllUtilize;
import static org.junit.jupiter.api.Assertions.*;

import ex45.app45;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public @interface test45 {
    class testapp45 {

        //  private final Calculator calculator = new Calculator();
        @Test
        void testCreateSiteName() throws ParseException {
            String original = "One should never utilize the word \"utilize\" in writing. Use \"use\" instead.\n";
            String replaced = replaceAllUtilize(original);
            String expected = "One should never use the word \"use\" in writing. Use \"use\" instead.\n";
            assertEquals(expected, replaced);
        }
    }
}
