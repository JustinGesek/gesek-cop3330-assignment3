package ex43;

import org.junit.jupiter.api.Test;

import static ex43.app43.createSite;
import static org.junit.jupiter.api.Assertions.*;

import ex43.app43;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
//Site name: awesomeco
//Author: Max Power
//Do you want a folder for JavaScript? y
//Do you want a folder for CSS? y
public @interface test43 {
    class testapp43 {

        //  private final Calculator calculator = new Calculator();
        @Test
        void testCreateSiteName() {
           createSite("awesomeco", "Max Power", true, true);
           File js = new File("./js");
           assertTrue(js.exists());
            File css = new File("./css");
            assertTrue(css.exists());
            File indexHtml = new File("./index.html");
            assertTrue(indexHtml.exists());
        }
    }
}
