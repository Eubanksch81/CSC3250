import java.util.ArrayList;

interface Subject {
    public void subscribe(Observer observer);
    public void unsubscribe(Observer observer);
    public void notifyAdd(int index);
    public void notifyRemove(int index);
}

interface Observer {
    public void updateAdd(int index);
    public void updateRemove(int index);
}
interface SortBehavior <T> {
    boolean sort(T value1, T value2);
}

class PriceSort implements SortBehavior<Integer> {
    @Override
    public boolean sort(Integer price1, Integer price2) {
        if (price1 <= price2) {
            return true;
        }
        else {
            return false;
        }

    }
}

class NameSort implements SortBehavior<String> {
    @Override
    public boolean sort(String name1, String name2) {
        if (name1.compareTo(name2) <= 0) {
            return true;
        }
        else {
            return false;
        }
    }
}

class AllItems<T> {
    private ArrayList<T> items;

    public AllItems() {
        items = new ArrayList<T>();
    }

    public void addItem(T object) {
        items.add(object);
    }

    public void removeItem(T object) {
        items.remove(object);
    }

    public int size() {
        return items.size();
    }

    public T getItem(int index) {
        return items.get(index);
    }

    public void sortItems(SortBehavior<T> sortBehavior) {
        int smallIndex;
        T tempVar;

        for (int i = 0; i < size() - 1; ++i) { //Selection Sort
            smallIndex = i;
            for (int j = i + 1; j < size(); ++j) {
                if (sortBehavior.sort(items.get(j), items.get(smallIndex))) {
                    smallIndex = j;
                }
            }
            tempVar = items.get(i);
            items.set(i, items.get(smallIndex));
            items.set(smallIndex, tempVar);

        }
    }
}

class PriceList implements Observer{
    AllItems<Integer> priceList;

    public PriceList() {
        priceList = new AllItems<Integer>();
    }

    public void updateAdd(int index) {

    }
    public void updateRemove(int index) {

    }
}

class Store implements Subject {
    AllItems<String> namesList;
    ArrayList<Observer> observerList;

    public Store() {
        namesList = new AllItems<String>();
        observerList = new ArrayList<Observer>();
    }

    public void subscribe(Observer observer) {
        observerList.add(observer);
    }

    public void unsubscribe(Observer observer) {
        observerList.remove(observer);
    }

    public void notifyAdd(int index) {
        for (Observer observer : observerList) {
            observer.updateAdd(index);
        }
    }

    public void notifyRemove(int index) {
        for (Observer observer : observerList) {
            observer.updateRemove(index);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        AllItems<String> nameList = new AllItems<String>();
        AllItems<Integer> priceList = new AllItems<Integer>();

        nameList.addItem("Beth");
        nameList.addItem("Aaron");
        nameList.addItem("Suzy");
        nameList.addItem("Daniel");

        nameList.sortItems(new NameSort());

        priceList.addItem(1);
        priceList.addItem(5);
        priceList.addItem(7);
        priceList.addItem(2);

        priceList.sortItems(new PriceSort());

    }
}