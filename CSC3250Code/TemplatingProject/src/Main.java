class Stuff<T> {
    private T _thing;

    public Stuff() {}
    public Stuff(T t) {
        _thing = t;
    }
    public void set_thing(T p_thing) {
        _thing = p_thing;
    }
    public T get_thing() {
        return _thing;
    }
}

public class Main {
    public static void main(String[] args) {
        Stuff<String> s1 = new Stuff<String>();
        s1.set_thing("Word!");
        System.out.println(s1.get_thing());
        Stuff<Integer> s2 = new Stuff<Integer>();
        s2.set_thing(34);
        System.out.println(s2.get_thing());
    }
}