import java.util.ArrayList;

public class AllSMPs implements Subject {
    //Class Header
    private ArrayList<SMP> _allSmps;
    private ArrayList<Observer> _allObservers;

    public AllSMPs() {
        _allSmps = new ArrayList<SMP>();
        _allObservers = new ArrayList<Observer>();
    }

    public void addSMP(SMP newSMP) {
        _allSmps.add(newSMP);
    }
    public void removeSMP(int index) {
        _allSmps.remove(index);
    }
    public void modifySMPName(int index, String name) {
        _allSmps.get(index).setName(name);
    }
    public void modifySMPUpdateRate(int index, double updateRate) {
        _allSmps.get(index).setUpdateRate(updateRate);
    }
    public int size() {
        return _allSmps.size();
    }
    public double getUpdateRate(int i) {
        return _allSmps.get(i).getUpdateRate();
    }
    public String getName(int i) {
        return _allSmps.get(i).getName();
    }
    public int findSMP(String name) {
        int i = 0;
        boolean isFound = false;
        while (i < _allSmps.size() && !isFound) {
            if (_allSmps.get(i).getName().equals(name)) {
                isFound = true;
            }
            else {
                ++i;
            }
        }
        return i;
    }
    public Integer getSMPFeedCount(int idx, String keywrd){
        return _allSmps.get(idx).count(new FeedCount(), keywrd);
    }
    public Integer getSMPKeywordCount(int idx, String keywrd){
        return _allSmps.get(idx).count(new KeywordCount(), keywrd);
    }

    public String toString() {
        String feed = "";
        for (int i = 0; i < _allSmps.size(); ++i) {
            feed += _allSmps.get(i).toString();
            feed += "\n";
        }
        return feed;
    }

    public void subscribe(Observer obs) {
        _allObservers.add(obs);
    }
    public void unsubscribe(Observer obs) {
        _allObservers.remove(obs);
    }
    public void notifyObservers(String smpName, String feedLine) {
        for (int i = 0; i < _allObservers.size(); ++i) {
            _allObservers.get(i).update(smpName, feedLine);
        }
    }
    public void addFeed(int index, String feedLine) { //Adds new feedline to specified SMP
        _allSmps.get(index).addFeed(feedLine);
        notifyObservers(_allSmps.get(index).getName(), feedLine);
    }

    //AddSMP, removeSMP, modifySMPName, modifySMPUpdateRate, size, getUpdateRate, getName, findSMP, toString. General methods
    //Subscribe, unsubscribe, notifyObservers. Observer methods
    //addFeed(). Simulation
    //If there are any other methods that should be added, type them here.
}
