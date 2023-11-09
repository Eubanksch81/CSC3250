/*
Charles Eubanks
Assignment #2
Takes capitalized letters from user input and converts them to morse, and vice versa.
 */

import java.util.Scanner;
import java.io.IOException;
import java.io.File;

public class Morse {
    public static void main(String[] args) throws IOException {
        MorseCode morseCode = new MorseCode();
        Scanner inFile = new Scanner(new File("data.txt"));
        Scanner scnr = new Scanner(System.in);
        int menuVal = -1;

        while (inFile.hasNextLine()) { //Loads data into file
            String fileInput = inFile.nextLine();
            morseCode.add(fileInput.charAt(0), fileInput.substring(fileInput.indexOf(' ') + 1));
        }

        while (menuVal != 3) { //Menu begins here
            printOptions();
            menuVal = scnr.nextInt();

            if (menuVal == 1) { //Convert alphabet to morse
                convertToMorse(scnr, morseCode);
            }
            else if (menuVal == 2) { //Convert morse to alphabet
                convertToLetter(scnr, morseCode);

            }
            else if (menuVal < 1 || menuVal > 3) { //Invalid input
                System.out.println("Invalid input");
            }
        }
    }

    private static void printOptions() {
        System.out.println("Press 1 to convert alphabet to morse");
        System.out.println("Press 2 to convert morse to alphabet");
        System.out.println("Press 3 to exit");
    }

    private static void convertToLetter(Scanner scnr, MorseCode morseCode) {
        String morseList[];
        String input;

        System.out.println("Input Morse: ");
        input = scnr.nextLine();
        morseList = input.split(" ");

        for (int m = 0; m < morseList.length; ++m) { //Converts to letter
            int index = morseCode.findLetter(morseList[m]);
            System.out.print(morseCode.getLetter(index));
        }
        System.out.println();
    }

    private static void convertToMorse(Scanner scnr, MorseCode morseCode) {
        boolean goodStringInput = false;
        String input = "";

        System.out.println("Input Letters: ");
        input = scnr.nextLine();
        while (!goodStringInput) {
            boolean isInvalid = false;
            int j = 0;

            while (j < input.length() && !isInvalid) {
                if (Character.isLowerCase(input.charAt(j))) {
                    System.out.println("Invalid input: Please use upper case only.");
                    System.out.println("Input Letters: ");
                    isInvalid = true;
                }
                else if (input.charAt(j) == ' ') {
                    System.out.println("Invalid input: Please remove any spaces.");
                    System.out.println("Input Letters: ");
                    isInvalid = true;
                }
                ++j;
            }
            if (!isInvalid) {
                goodStringInput = true;
            }
            else {
                input = scnr.nextLine();
            }
        }

        for (int m = 0; m < input.length(); ++m) { //Converts to morse
            int index = morseCode.findMorse(input.charAt(m));
            System.out.print(morseCode.getMorse(index) + " ");
        }
        System.out.println();
    }
}

class MorseCode {
    MorseLetter[] morse; //Forgot to make this private
    private int size;

    public MorseCode() {
        morse = new MorseLetter[26];
        size = 0;
    }
    public MorseCode(int size) {
        morse = new MorseLetter[size];
        size = 0;
    }

    public boolean add(char p_letter, String p_morse) {
        boolean isAdded = false;
        int i = 0;

        while(i < morse.length && !isAdded) { //Forgot to remove isAdded when we switched out of the index add
            if (morse[i] == null) {
                morse[i] = new MorseLetter(p_letter, p_morse);
                isAdded = true;
                ++size;
            }
            ++i;
        }
        return isAdded;

    }

    public boolean removeLast() {
        try {
            morse[size - 1] = null;
            --size;
            return true;
        }
        catch (Exception excpt) {
            return false;
        }
    }

    public boolean modifyMorse(String p_oldMorse, String p_newMorse) {
        boolean isModified = false;
        int i = 0;

        while (i < morse.length && !isModified) {
            if (morse[i].getMorse().equals(p_oldMorse)) { //She wanted us to use our find() methods here.
                morse[i].setMorse(p_newMorse);
                isModified = true;
            }
        }

        return isModified;
    }

    public boolean modifyLetter(String p_oldLetter, String p_newLetter) {
        boolean isModified = false;
        int i = 0;

        while (i < morse.length && !isModified) {
            if (morse[i].getMorse().equals(p_oldLetter)) { //She wanted us to use our find() methods here.
                morse[i].setMorse(p_newLetter);
                isModified = true;
            }
        }

        return isModified;
    }

    public int size() {
        return size;
    }

    public int findMorse(char p_letter) { //Made these public, they should be private
        for (int i = 0; i < morse.length; ++i) {
            if (morse[i].getLetter() == p_letter) {
                return i; //This return statement was based on a misunderstanding.
                //Just remember you can't do a return while within a loop.
            }
        }
        return -1;
    }

    public int findLetter(String p_morse) {
        for (int i = 0; i < morse.length; ++i) {
            if (morse[i].getMorse().equals(p_morse)) {
                return i;
            }
        }
        return -1;
    }

    public String getMorse(int index) {
        return morse[index].getMorse();
    }

    public char getLetter(int index) {
        return morse[index].getLetter();
    }

}

class MorseLetter { //This class converts to morse
    private String morse;
    private char letter;

    public MorseLetter() {
        morse = "";
        letter = ' ';
    }
    public MorseLetter(char p_letter, String p_morse) {
        morse = p_morse;
        letter = p_letter;
    }

    public String getMorse() {
        return morse;
    }
    public void setMorse(String p_morse) {
        morse = p_morse;
    }

    public char getLetter() {
        return letter;
    }
    public void setLetter(char p_letter) {
        letter = p_letter;
    }

}