/*
Charles Eubanks, Emma Camp, Nicolas Ruiz
Assignment #4
Use the Strategy Pattern, Observer Pattern, and Factory Pattern to simulate a system in which
a user can subscribe to multiple Social Media Platforms (SMPs) that
potentially update with new feed information from a file.
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.util.Random;

public class Main {
    public static void populateAllSMPs(AllSMPs allSMPs) {
        Factory fact;
        fact = new CreateSMPFactory();
        for (int i = 0; i < 5; ++i) {
            allSMPs.addSMP((SMP) fact.createObject());
        }
    }

    public static void populateUpdateRates(AllSMPs allSMPs) {
        for (int i = 0; i < 5; ++i) {
            Random randGen = new Random();
            double updateRate = randGen.nextDouble(0.5);
            allSMPs.modifySMPUpdateRate(i, updateRate);
        }
    }

    public static void runSimulation(AllSMPs allSMPs, ArrayList<String> feedLines) {
        Random randGen = new Random();

        for (int simTime = 0; simTime < 60; simTime++) { //For 60 minutes
            for (int smpIndex = 0; smpIndex < allSMPs.size(); ++smpIndex) { //For the length of AllSMPs
                double randomInput = randGen.nextDouble(0, 1);

                if (randomInput < allSMPs.getUpdateRate(smpIndex)) { //If SMP at smpIndex updates
                    int randFeedIndex = randGen.nextInt(feedLines.size());
                    allSMPs.addFeed(smpIndex, feedLines.get(randFeedIndex));
                }
            }
        }
    }

    public static ArrayList<String> getFileData() throws IOException {
        ArrayList<String> feedLines = new ArrayList<String>(); //Lines will be delimited when read from the arrayList.
        // Allows us to use a hashmap to store data in User.
        Scanner inFile = new Scanner(new File("data.txt"));

        while (inFile.hasNextLine()) { //Storing data from file
            feedLines.add(inFile.nextLine());
        }
        inFile.close();

        return feedLines;
    }

    public static void outputFile(AllSMPs allSMPs, User user, String fileName) throws IOException {
        String str = " ";
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.append(str);
        for (int i = 0; i < allSMPs.size(); i++) { //For each SMP
            writer.write(("SMP Name: ") + allSMPs.getName(i) + " " + "\n");
            writer.write(("Feed Size: ") + user.smpFeedSize(allSMPs.getName(i)) + " " + "\n");
            for (int m = 0; m < user.smpFeedSize(allSMPs.getName(i)); ++m) { //For each line in the SMP
                String feed = user.getFeedFromSMP(allSMPs.getName(i), m);
                String[] feedlines = feed.split(";");
                for (int j = 0; j < feedlines.length; j++) { //Delimits the title and description
                    writer.write(feedlines[j] + "\n");
                }
                writer.write("\n");
            }
        }
        writer.close();
    }

    public static void outputSMPAnalytics(AllSMPs smpList1, AllSMPs smpList2){
        Scanner scan = new Scanner(System.in);
        //asks for user input to search for and count in each SMP's feeds.
        System.out.println("Please enter the first keyword: ");
        String keyword1 = scan.nextLine();
        System.out.println("Please enter a second keyword: ");
        String keyword2 = scan.nextLine();
        int feedCtr1 = 0;
        int feedCtr2 = 0;
        int keywordCtr1 = 0;
        int keywordCtr2 = 0;
        for (int i = 0; i < smpList1.size(); i++) {
            feedCtr1 += smpList1.getSMPFeedCount(i, keyword1);
            keywordCtr1 += smpList1.getSMPKeywordCount(i, keyword1);
            feedCtr2 += smpList1.getSMPFeedCount(i, keyword2);
            keywordCtr2 += smpList1.getSMPKeywordCount(i, keyword2);
        }
        for (int i = 0; i < smpList2.size(); i++) {
            feedCtr1 += smpList2.getSMPFeedCount(i, keyword1);
            keywordCtr1 += smpList2.getSMPKeywordCount(i, keyword1);
            feedCtr2 += smpList2.getSMPFeedCount(i, keyword2);
            keywordCtr2 += smpList2.getSMPKeywordCount(i, keyword2);
        }
        System.out.println("Total number of '" + keyword1 + "' appearances in all feeds is " + keywordCtr1);
        System.out.println("Total number of feeds with '" + keyword1 + "' is " + feedCtr1);
        System.out.println("Total number of '" + keyword2 + "' appearances in all feeds is " + keywordCtr2);
        System.out.println("Total number of feeds with '" + keyword2 + "' is " + feedCtr2);
    }

    public static void main (String[]args) throws IOException{
        ArrayList<String> feedLines = getFileData();
        AllSMPs smpList1 = new AllSMPs(); //Initialize values
        User user1 = new User(smpList1);

        AllSMPs smpList2 = new AllSMPs();
        User user2 = new User(smpList2);

        populateAllSMPs(smpList1);
        smpList1.modifySMPName(0, "Facebook");
        smpList1.modifySMPName(1, "Instagram");
        smpList1.modifySMPName(2, "Threads");
        smpList1.modifySMPName(3, "X");
        smpList1.modifySMPName(4, "ABC News");
        populateUpdateRates(smpList1);
        populateAllSMPs(smpList2);
        smpList2.modifySMPName(0, "Twitter");
        smpList2.modifySMPName(1, "MySpace");
        smpList2.modifySMPName(2, "Tumblr");
        smpList2.modifySMPName(3, "Snapchat");
        smpList2.modifySMPName(4, "Yahoo News");
        populateUpdateRates(smpList2);

        runSimulation(smpList1, feedLines);
        runSimulation(smpList2, feedLines);
        outputFile(smpList1, user1, "output.txt");
        outputFile(smpList2, user2, "output2.txt");
        outputSMPAnalytics(smpList1, smpList2);
    }
}