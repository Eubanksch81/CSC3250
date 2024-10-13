public class KeywordCount implements CountBehavior{
    public Integer count(String feed, String keywrd){
        String[] wrds;
        Integer ctr = 0;
        wrds = feed.split(" ", 0);
        for(int i = 0; i< wrds.length; i++){
            if(wrds[i].equals(keywrd))
                ctr++;
        }
        return ctr;
    }
}