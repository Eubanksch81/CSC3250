import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Animal a = new Animal();
        //Dog d = new Dog();
        //Dog d2 = new Dog("Fido", "Poodle", 3, false);
        //System.out.println(d2.getName());
        //Cat c = new Cat("Binx", "Bombay", 2, true);

        //Polymorphism
        //Animal a2 = new Dog();

        ArrayList<Door> d = new ArrayList<Door>();
        //d.add(new Door());
        d.add(new LockedDoor());
        for (int i = 0; i < d.size(); ++i) {
            System.out.println(d.get(i).toString());
            if (d.get(i) instanceof LockedDoor) {
                ((LockedDoor)(d.get(i))).unlock();
            }
        }

        PasswordDoor pd = new PasswordDoor();
        pd.open();

    }
}
