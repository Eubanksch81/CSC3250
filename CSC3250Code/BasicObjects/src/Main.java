import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        //ArrayList<Dog> stuff = new ArrayList<Dog>();
        Scanner inLine = new Scanner(new File("doggydata.txt"));
        //DoggyDaycare daycare = new DoggyDaycare();
        DoggyDaycare daycare = DoggyDaycare.getInstance();


        while (inLine.hasNextLine()) {
            String breed = inLine.nextLine();
            String name = inLine.nextLine();
            int age = Integer.parseInt(inLine.nextLine());
            //Could also use nextInt for age, but have to make sure to do a nextLine afterwords before continuing.
            daycare.addDog(name, breed, age);
        }

        //printDaycare(daycare);
        DoggyDaycare daycare2 = DoggyDaycare.getInstance();
        //printDaycare(daycare2);

        System.out.println(daycare);
        System.out.println(daycare2);
    }

    public static void printDaycare(DoggyDaycare daycare) {
        //Use getSize, getName, getBreed, and getAge. Print from there on Wednesday.
        for (int i = 0; i < daycare.size(); ++i) {
            System.out.println("Name: " + daycare.getName(i));
            System.out.println("Breed: " + daycare.getBreed(i));
            System.out.println("Age: " + daycare.getAge(i));
            System.out.println();
        }
    }
}
