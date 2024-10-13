public class FeedCount implements CountBehavior {
    public Integer count(String feed, String keywrd){
        String[] wrds;
        Integer ctr = 0, idx = 0;
        Boolean found = false;
        wrds = feed.split(" ", 0);
        while(idx< wrds.length && !found){
            if(wrds[idx].equals(keywrd)) {
                ctr++;
                found = true;
            }
            ++idx;
        }
        return ctr;
    }
}
