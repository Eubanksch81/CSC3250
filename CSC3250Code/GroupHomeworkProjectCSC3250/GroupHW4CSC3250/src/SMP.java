import java.util.ArrayList;

public class SMP {
    private String _name;
    private Double _updateRate;
    private ArrayList<String> _feedHistory;

    //constructors
    public SMP() {
        _name = "";
        _updateRate = 0.0;
        _feedHistory = new ArrayList<String>();
    }

    public SMP(String name, Double updateRate) {
        _name = name;
        _updateRate = updateRate;
        _feedHistory = new ArrayList<String>();
    }

    //SMP methods
    public String getName() {
        return _name;
    }

    public Double getUpdateRate() {
        return _updateRate;
    }

    public void setName(String name) {
        _name = name;
    }

    public void setUpdateRate(Double rate) {
        _updateRate = rate;
    }

    public void addFeed(String feed) {
        _feedHistory.add(feed);
    }

    public void removeFeed(String feed) {
        _feedHistory.remove(feed);
    }

    public String getFeed(int index) {
        return _feedHistory.get(index);
    }
    public int feedSize() {
        return _feedHistory.size();
    }
    public String toString() {
        return "Name: " + _name + " Update rate: " + _updateRate;
    }

    public Integer count(CountBehavior cb, String keyword) {
        ArrayList<String> feedCopy = _feedHistory;
        Integer ctr = 0;
        for (int i = 0; i < feedCopy.size(); i++) {
            feedCopy.set(i, feedCopy.get(i).replace('.', ' '));
            feedCopy.set(i, feedCopy.get(i).replace(';', ' '));
            feedCopy.set(i, feedCopy.get(i).replace('"', ' '));
            feedCopy.set(i, feedCopy.get(i).replace('-', ' '));
            ctr += cb.count(feedCopy.get(i), keyword);
        }
        return ctr;
    }
}
