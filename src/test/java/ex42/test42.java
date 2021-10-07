package ex42;

import org.junit.jupiter.api.Test;

import static ex41.app41.scanAndSort;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import ex41.app41;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public @interface test42 {
    class testapp42 {

        //  private final Calculator calculator = new Calculator();
        @Test
        void testScanAndSort() {
            String file = "Ling,Mai,55900\n" +
                    "Johnson,Jim,56500\n" +
                    "Jones,Aaron,46000\n" +
                    "Jones,Chris,34500\n" +
                    "Swift,Geoffrey,14200\n" +
                    "Xiong,Fong,65000\n" +
                    "Zarnecki,Sabrina,51500\n";
            String expectedText =
                    "Johnson,Jim,56500\n" +
                    "Jones,Aaron,46000\n" +
                    "Jones,Chris,34500\n" +
                    "Ling,Mai,55900\n" +
                    "Swift,Geoffrey,14200\n" +
                    "Xiong,Fong,65000\n" +
                    "Zarnecki,Sabrina,51500\n";
            Scanner scanner = new Scanner(file);
            ArrayList<String> expected = new ArrayList<String>(Arrays.asList(expectedText.split("\n")));
            assertEquals(expected, scanAndSort(scanner));
        }
    }
}
