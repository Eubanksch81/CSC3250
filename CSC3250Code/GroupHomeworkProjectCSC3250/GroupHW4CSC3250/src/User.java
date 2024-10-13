import java.util.HashMap;
import java.util.ArrayList;

public class User implements Observer{
    private HashMap <String, ArrayList<String>> smpFeeds;
    private ArrayList<String> hashKeys;
    private Subject subj;

    public User(Subject subject) {
        smpFeeds = new HashMap<String, ArrayList<String>>();
        hashKeys = new ArrayList<String>();
        subj = subject;
        subj.subscribe(this);
    }

    public void update(String smpName, String feedLine) { //Receives info from allSMPs and adds it to the hashMap
        if (smpExists(smpName)) {
            addFeedToSMP(smpName, feedLine);
        }
        else {
            addSMP(smpName);
            addFeedToSMP(smpName, feedLine);
        }
    }

    public void addSMP(String smpName) {
        smpFeeds.put(smpName, new ArrayList<String>());
        hashKeys.add(smpName);
    }
    public void addFeedToSMP(String smpName, String feedLine) {
        smpFeeds.get(smpName).add(feedLine);
    }
    public void removeFeedFromSMP(String smpName, String feedLine) {
        smpFeeds.get(smpName).remove(feedLine);
    }
    public void removeSMP(String smpName) {
        smpFeeds.remove(smpName);
        hashKeys.remove(smpName);
    }
    public String getFeedFromSMP(String smpName, int index) {
        return smpFeeds.get(smpName).get(index);
    }
    public int smpFeedSize(String smpName) {
        if (smpExists(smpName)) {
            return smpFeeds.get(smpName).size();
        }
        else {
            return 0;
        }
    }
    public boolean smpExists(String smpName) {
        int i = 0;
        boolean isFound = false;
        while (i < hashKeys.size() && !isFound) {
            if (hashKeys.get(i).equals(smpName)) {
                isFound = true;
            }
            ++i;
        }
        return isFound;
    }
}

// AddSMP, addFeedToSMP, removeFeedFromSMP, removeSMP, getFeedFromSMP, smpFeedSize, smpExists. HashMap methods
//update. Observer pattern
//feedCount, keywordCount, keywordAnalyze. Strategy pattern
// If there are any other methods that should be added, type them here.
