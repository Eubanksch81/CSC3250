import java.util.ArrayList;

public class DoggyDaycare {
    private ArrayList<Dog> dogs;
    private static DoggyDaycare uniqueInstance;
    private int next;

    private DoggyDaycare() {
        dogs = new ArrayList();
    }
    private DoggyDaycare(int size){
        dogs = new ArrayList<Dog>(size);
    }

    public static DoggyDaycare getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new DoggyDaycare();
        return uniqueInstance;
    }

    public static DoggyDaycare getInstance(int size){
        if (uniqueInstance == null)
            uniqueInstance = new DoggyDaycare(size);
        return uniqueInstance;
    }

    public void addDog(String p_name, String p_breed, int p_age) {
        dogs.add(new Dog(p_name, p_breed, p_age));
    }
    public boolean removeDog(String p_name) {
        boolean isRemoved = false;
        int i = 0;

        while (i < dogs.size() && !isRemoved) {
            if (dogs.get(i).getName().equals(p_name)) {
                dogs.remove(i);
                isRemoved = true;
            }
            ++i;
        }

        return isRemoved;
    }

    public boolean modifyName(String p_oldName, String p_newName) {
        int x = findPosition(p_oldName);
        if (x == -1) {
                return false;
        }
        else {
            dogs.get(x).setName(p_newName);
            return true;
        }
    }

    public boolean modifyAge(String p_dogName, int p_newAge) {
        int x = findPosition(p_dogName);
        if (x == -1) {
            return false;
        }
        else {
            dogs.get(x).setAge(p_newAge);
            return true;
        }
    }

    private int findPosition(String p_name) {
        boolean found = false;
        int i = 0;

        while (i < dogs.size() && !found) {
            if (dogs.get(i).getName().equals(p_name)) {
                found = true;
            }
            else {
                ++i;
            }
        }
        if (!found) {
            return -1;
        }
        else {
            return i;
        }
    }
    public int size() {
        return dogs.size();
    }

    public String getName(int index) {
        return dogs.get(index).getName();
    }
    public String getBreed(int index) {
        return dogs.get(index).getBreed();
    }
    public int getAge(int index) {
        return dogs.get(index).getAge();
    }

    public void start() {
        next = 0;
    }
    public String next() {
        if (next < dogs.size()) {
            String name = dogs.get(next).getName();
            ++next;
            return name;
        }
        else {
            return "";
        }
    }
    public boolean hasNext() {
        if (next < dogs.size()) {
            return true;
        }
        else {
            return false;
        }
    }
}
