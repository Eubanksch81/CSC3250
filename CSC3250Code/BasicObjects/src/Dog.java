import java.util.*;
import java.io.*;

public class Dog {
    private String name;
    private String breed;
    private int age;

    public Dog() {
        name = "";
        breed = "";
        age = 0;
    }
    public Dog(String p_name, String p_breed, int p_age) {
        name = p_name;
        breed = p_breed;
        age = p_age;
    }
    public void setName (String p_name) {
        name = p_name;
    }
    public String getName() {
        return name;
    }
    public void setBreed(String p_breed) {
        breed = p_breed;
    }
    public String getBreed() {
        return breed;
    }
    public void setAge(int p_age) {
        age = p_age;
    }
    public int getAge() {
        return age;
    }

}

