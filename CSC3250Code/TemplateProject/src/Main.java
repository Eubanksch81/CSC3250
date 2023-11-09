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

    public <S> S convertThing() {
        if (_thing instanceof Integer) {
            return (S)String.valueOf((Integer)_thing);
        }
        else if (_thing instanceof String) {
            return (S)Integer.valueOf((String)_thing);
        }
        else {
            return (S)_thing;
        }
    }

}

class Student{
    // _sid is a unique identifier for a student
    private String _sid;

    public Student(){}
    public Student(String d){
        _sid = d;
    }

    public void setID(String id){
        _sid = id;
    }
    public String getID(){
        return _sid;
    }

    public String toString(){
        return _sid;
    }
}

public class Main {
    public static void main(String[] args) {
        Stuff<String> s1 = new Stuff<String>();
        s1.set_thing("Word");
        System.out.println(s1.get_thing());

        Stuff<Integer> s2 = new Stuff<Integer>();
        s2.set_thing(34);
        System.out.println(s2.get_thing());

        Stuff<Student> s3 = new Stuff<Student>();
        s3.set_thing(new Student("1"));
        System.out.println(s3.get_thing().toString());
        s3.get_thing().setID("2");
        System.out.println(s3.get_thing().toString());

        String x = s2.convertThing();
        System.out.println(x);

    }
}