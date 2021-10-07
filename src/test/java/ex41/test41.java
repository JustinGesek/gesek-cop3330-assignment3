package ex41;

import org.junit.jupiter.api.Test;

import static ex41.app41.scanAndSort;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import ex41.app41;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public @interface test41 {
    class testapp24 {

        //  private final Calculator calculator = new Calculator();
        @Test
        void testScanAndSort() {
            String file = "Ling, Mai\n" +
                    "Johnson, Jim\n" +
                    "Zarnecki, Sabrina\n" +
                    "Jones, Chris\n" +
                    "Jones, Aaron\n" +
                    "Swift, Geoffrey\n" +
                    "Xiong, Fong\n";
            String expectedText = "Johnson, Jim\n" +
                    "Jones, Aaron\n" +
                    "Jones, Chris\n" +
                    "Ling, Mai\n" +
                    "Swift, Geoffrey\n" +
                    "Xiong, Fong\n" +
                    "Zarnecki, Sabrina\n";
            Scanner scanner = new Scanner(file);
            ArrayList<String> expected = new ArrayList<String>(Arrays.asList(expectedText.split("\n")));
            assertEquals(expected, scanAndSort(scanner));
        }
    }
}
