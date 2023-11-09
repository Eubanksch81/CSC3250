import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        TestClass test = new TestClass(1);
        System.out.println(test.getnewVar());
        test.setnewVar(3);
        System.out.println(test.getnewVar());
        Scanner inFile = new Scanner(new File("name.txt"));
        System.out.println(inFile.nextLine());
    }
}



/*
Exhaustive Sequential search:
String word = "funny";
        for (int i = 0; i < word.length(); ++i) {
            if (word.charAt(i) == 'n') {
                System.out.println("Ha!");
            }
        }
 */

/*
Sentinel loop pattern
int sentinel = 10;
        int i = 0;

        while (i != sentinel) {
            ++i;
        }
 */

/*
Input validation pattern:
Scanner scnr = new Scanner(System.in);
        int userInput = scnr.nextInt();
        while (userInput < 1 || userInput > 10) {
            System.out.println("Please input a number between 1 - 10.");
            userInput = scnr.nextInt();
        }
        System.out.println("Good job!");
 */

/*
Non-exhaustive sequential search pattern
boolean found = false;
        String word = "laughter";
        int i = 0;

        while (i < word.length() && !found) {
            if (word.charAt(i) == 't') {
                found = true;
                System.out.println("Found!");
            }
            ++i;
        }
        if (!found) {
            System.out.println("Not found.");
        }
 */