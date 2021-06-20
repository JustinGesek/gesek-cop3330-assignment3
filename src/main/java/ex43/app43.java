package ex43;
/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Justin Gesek
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
//Create a program that generates a website skeleton with the following specifications:
//
//Prompt for the name of the site.
//Prompt for the author of the site.
//Ask if the user wants a folder for JavaScript files.
//Ask if the user wants a folder for CSS files.
//Generate an index.html file that contains the name of the site inside the <title> tag and the author in a <meta> tag.
//Example Output
//Site name: awesomeco
//Author: Max Power
//Do you want a folder for JavaScript? y
//Do you want a folder for CSS? y
//Created ./website/awesomeco
//Created ./website/awesomeco/index.html
//Created ./website/awesomeco/js/
//Created ./website/awesomeco/css/
//The user should then find these files and directories created in the working directory of your program.
public class app43 {
    public static void main(String[] args) {
        //ask user for name and author of the site.
        Scanner scanner = new Scanner(System.in);
       System.out.print("Please provide the name of the site: ");
       String siteName = scanner.nextLine().trim().toLowerCase(Locale.ROOT);
        System.out.print("Please provide the author of the site: ");
        String authorName = scanner.nextLine().trim();
        //Site name: awesomeco
        System.out.println("Site name: " +siteName);
        //Author: Max Power
        System.out.println("Author: "+authorName);
        //ask whether js folder is requested, and create it if so.
        System.out.print("Do you want a javascript folder? ");
        String jsFolderResponse = scanner.nextLine().trim().toLowerCase(Locale.ROOT);
        boolean createJsFolder = jsFolderResponse.charAt(0) == 'y';
        if (createJsFolder)
        {
            File JsFolder = new File("C:\\Users\\Justin Gesek\\IdeaProjects\\BookExample1\\temt\\gesek-cop3330-assignment3\\src\\main\\java\\ex43\\js");
            if (!JsFolder.exists())
            {
                JsFolder.mkdir();
            }
        }
        //ask whether css folder is requested, and create it if so.
        System.out.print("Do you want a CSS folder? ");
        String CSSFolderResponse = scanner.nextLine().trim().toLowerCase(Locale.ROOT);
        boolean createCSSFolder = CSSFolderResponse.charAt(0) == 'y';
        if (createCSSFolder)
        {
            File CSSFolder = new File("C:\\Users\\Justin Gesek\\IdeaProjects\\BookExample1\\temt\\gesek-cop3330-assignment3\\src\\main\\java\\ex43\\css");
            if (!CSSFolder.exists())
            {
                CSSFolder.mkdir();
            }
        }
        //create the index file
        try {
            FileWriter index = new FileWriter("C:\\Users\\Justin Gesek\\IdeaProjects\\BookExample1\\temt\\gesek-cop3330-assignment3\\src\\main\\java\\ex43\\index.html");
            index.write("<title>" + siteName + "</title>\n");
            index.write("<meta>" + authorName + "</meta>\n");
        }catch (IOException e)
        {
            System.out.println("Unable to open or write index.html");
            return;
        }
    }
}
