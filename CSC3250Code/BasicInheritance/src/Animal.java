import java.sql.SQLOutput;

public class Animal {
    private String _name;
    private String _breed;
    private int _age;

    public Animal() {
        System.out.println("In animal default");
    }
    public Animal (String s1, String s2, int x) {
        System.out.println("In animal n-arg");
        _name = s1;
        _breed = s2;
        _age = x;
    }
    public void setName(String n) {
        _name = n;
    }
    public void setBreed(String b) {
        _breed = b;
    }
    public void setAge(int x) {
        _age = x;
    }
    public String getName() {
        return _name;
    }
    public String getBreed() {
        return _breed;
    }
    public int getAge() {
        return _age;
    }
}

class Dog extends Animal {
    private boolean _guard;

    public Dog() {
        System.out.println("in Dog default");
    }
    public Dog(String s1, String s2, int x, boolean g){
        super(s1, s2, x);
        System.out.println("in Dog n-arg");
        _guard = g;
    }
    public void setGuard(boolean g) {
        _guard = g;
    }
    public boolean getGuard(){
        return _guard;
    }
}

class Cat extends Animal {
    private boolean vaxxed;

    public Cat() {
        super();
        System.out.println("In cat default");
    }
    public Cat(String s1, String s2, int x, boolean v) {
        super(s1, s2, x);
        vaxxed = v;
        System.out.println("In cat n-arg");
    }

    public void setVaxxed(boolean v) {
        vaxxed = v;
    }
    public boolean getVaxxed() {
        return vaxxed;
    }

}
