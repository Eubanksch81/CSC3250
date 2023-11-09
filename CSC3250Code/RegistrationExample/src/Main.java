/*import java.util.*;
class Address{
    private String _street;
    private String _city;
    private String _state;
    private String _zip;
    public Address(){}
    public Address(String s, String c, String st, String z){
        _street = s;  _city = c; _state = st; _zip = z;
    }
    public void setStreet(String s){_street = s;}
    public void setCity(String c){_city = c;}
    public void setState(String st){_state = st;}
    public void setZip(String z){_zip = z;}
    public String getStreet(){return _street;}
    public String getCity(){return _city;}
    public String getState(){return _state;}
    public String getZip(){return _zip;}

    @Override
    public String toString() {
        return "Street: " + _street +
                "\nCity: " + _city +
                "\nState: " + _state +
                "\nZip: " + _zip;
    }
}
class Student{
    // _sid is a unique identifier for a student
    private String _sid;
    private Address _addr;
    public Student(){}
    public Student(String d, String s, String c, String st, String z){
        _sid = d;
        _addr = new Address(s, c, st, z);
    }
    public void setID(String id){_sid = id;}
    public String getID(){return _sid;}
    public void setStreet(String s){_addr.setStreet(s);}
    public String getStreet(){return _addr.getStreet();}
    public void setCity(String s){_addr.setCity(s);}
    public String getCity(){return _addr.getCity();}
    public void setState(String s){_addr.setState(s);}
    public String getState(){return _addr.getState();}
    public void setZip(String s){_addr.setZip(s);}
    public String getZip(){return _addr.getZip();}

    public String toString() {
        return _addr.toString() + "\nStudent ID: " + _sid;
    }
}
class Course{
    // _cnum is a unique identifier for a course
    private String _cnum;
    private int _credits;
    public Course(){}
    public Course(String num, int cred){
        _cnum = num;  _credits = cred;
    }
    public void setNumber(String num){_cnum = num;}
    public void setCredits(int cred){_credits = cred;}
    public String getNumber(){return _cnum;}
    public int getCredits(){return _credits;}
}
class Enrollment{
    private HashMap<String, ArrayList<String>> _enroll;
    public Enrollment(){
        _enroll = new HashMap<String, ArrayList<String>>();
    }
    public void addCourseToStudent(String id, String c){
        ArrayList<String> t = _enroll.get(id);
        if (t == null)  // student not in enroll
            t = new ArrayList<String>();
        t.add(c);
        _enroll.put(id, t);
    }
    public void dropStudent(String id) {
        _enroll.remove(id);
    }
    public void dropCourse(String id, String courseName) {
        int i = 0;
        boolean found = false;
        ArrayList<String> t = _enroll.get(id);

        while (i < t.size() && !found) {
            if (t.get(i).equals(courseName)) {
                t.remove(i);
                found = true;
            }
            ++i;
        }
        _enroll.put(id, t);
    }
}
class AllStudents{
    private ArrayList<Student> _students;
    public AllStudents(){
        _students = new ArrayList<Student>();
    }
    public void addStudent(String id, String s, String c, String st, String z){
        _students.add(new Student(id, s, c, st, z));
    }
    public boolean studentExists(String id){
        int i=0;
        boolean found = false;
        while (i<_students.size() && !found){
            if (_students.get(i).getID().equals(id))
                found = true;
            else
                i++;
        }
        return found;
    }
    public void removeStudent(String id){
        int i = 0;
        boolean found = false;

        while (i < _students.size() && !found) {
            if (_students.get(i).getID().equals(id)) {
                _students.remove(i);
                found = true;
            }
            else {
                ++i;
            }
        }

    }

    public int size() {
        return _students.size();
    }

    public void print(){  // testing purposes only
        for (int i=0; i<_students.size(); i++){
            System.out.println(_students.get(i).getID());
        }
    }
}
class AllCourses{
    private ArrayList<Course> _courses;
    public AllCourses(){
        _courses = new ArrayList<Course>();
    }
    public void addCourse(String id, int c){
        _courses.add(new Course(id, c));
    }
    public boolean courseExists(String id){
        int i=0;
        boolean found = false;
        while (i<_courses.size() && !found){
            if (_courses.get(i).getNumber().equals(id))
                found = true;
            else
                i++;
        }
        return found;
    }
    public void removeCourse(String id){
        int i = 0;
        boolean found = false;

        while (i < _courses.size() && !found) {
            if (_courses.get(i).getNumber().equals(id)) {
                _courses.remove(i);
                found = true;
            }
            else {
                ++i;
            }
        }
    }
    public void print(){  // testing purposes only
        for (int i=0; i<_courses.size(); i++){
            System.out.println(_courses.get(i).getNumber());
        }
    }
}
class Singleton{
    private AllStudents _allStud;
    private AllCourses _allCrs;
    private Enrollment _enroll;
    public Singleton(){
        _allStud = new AllStudents();
        _allCrs = new AllCourses();
        _enroll = new Enrollment();
    }

    public void addStudent(String id, String s, String c, String st, String z){
        _allStud.addStudent(id, s, c, st, z);
    }

    public void removeStudent(String id) {
        _allStud.removeStudent(id);
    }

    public void addCourse(String c, int cr) {
        _allCrs.addCourse(c, cr);
    }

    public boolean addEnrollment(String id, String cnum){
        // check if course and student exist
        if (_allCrs.courseExists(cnum) && _allStud.studentExists(id)){
            _enroll.addCourseToStudent(id, cnum);
            return true;
        }
        return false;
    }

    public void dropStudentFromCourse(String id, String cnum) {
        _enroll.dropCourse(id, cnum);
    }
}

public class Main {
    public static void main(String[] args) {
        Singleton s = new Singleton();
        s.addCourse("CSC3250", 4);
        s.addCourse("CSC1700", 4);
        s.addCourse("MTH3270", 4);
        s.addStudent("100", "1 Elm", "Aurora", "IL", "60506");
        s.addStudent("200", "1 Elm", "Aurora", "IL", "60506");
        System.out.println(s.addEnrollment("100", "CSC3250"));
        System.out.println(s.addEnrollment("200", "CSC3250"));
    }
} */

import java.util.*;
class Address{
    private String _street;
    private String _city;
    private String _state;
    private String _zip;
    public Address(){}
    public Address(String s, String c, String st, String z){
        _street = s;  _city = c; _state = st; _zip = z;
    }
    public void setStreet(String s){_street = s;}
    public void setCity(String c){_city = c;}
    public void setState(String st){_state = st;}
    public void setZip(String z){_zip = z;}
    public String getStreet(){return _street;}
    public String getCity(){return _city;}
    public String getState(){return _state;}
    public String getZip(){return _zip;}
    public String toString(){return _street + " " + _city
            + " " + _state + " " + _zip;}
}
class Student{
    // _sid is a unique identifier for a student
    private String _sid;
    private Address _addr;
    public Student(){}
    public Student(String d, String s, String c, String st, String z){
        _sid = d;
        _addr = new Address(s, c, st, z);
    }
    public void setID(String id){_sid = id;}
    public String getID(){return _sid;}
    public void setStreet(String s){_addr.setStreet(s);}
    public String getStreet(){return _addr.getStreet();}
    public void setCity(String s){_addr.setCity(s);}
    public String getCity(){return _addr.getCity();}
    public void setState(String s){_addr.setState(s);}
    public String getState(){return _addr.getState();}
    public void setZip(String s){_addr.setZip(s);}
    public String getZip(){return _addr.getZip();}
    public String toString(){return _sid + " " + _addr.toString();}
}
class Course{
    // _cnum is a unique identifier for a course
    private String _cnum;
    private int _credits;
    public Course(){}
    public Course(String num, int cred){
        _cnum = num;  _credits = cred;
    }
    public void setNumber(String num){_cnum = num;}
    public void setCredits(int cred){_credits = cred;}
    public String getNumber(){return _cnum;}
    public int getCredits(){return _credits;}
    public String toString(){return _cnum + " " + _credits;}
}
class Enrollment{
    private HashMap<String, ArrayList<String>> _enroll;
    public Enrollment(){
        _enroll = new HashMap<String, ArrayList<String>>();
    }
    public void addCourseToStudent(String id, String c){
        ArrayList<String> t = _enroll.get(id);
        if (t == null)  // student not in enroll
            t = new ArrayList<String>();
        t.add(c);
        _enroll.put(id, t);
    }

    public boolean dropStudentFromCourse(String id, String cnum){
        // drops a student from a course
        ArrayList<String> t = _enroll.get(id);
        boolean found = false;
        if (t != null){
            int i=0;
            while (i<t.size() && !found){
                if (t.get(i).equals(cnum)) {
                    t.remove(i);
                    //_enroll.put(id, t); Don't need? Ask later.
                    found = true;
                }
                else
                    i++;
            }
        }
        return found;
    }
    public boolean dropCourseFromEnrollment(String cnum){
        boolean found = false;
        ArrayList<String> kt = new ArrayList<String>();
        Set keys = _enroll.keySet();
        Iterator itr = keys.iterator();
        while (itr.hasNext()) { //Iterates through students
            found = false;
            String k = (String)itr.next();
            ArrayList<String> t = _enroll.get(k);
            if (t != null) { //Iterates through a student
                int i = 0;
                while (i < t.size() && !found) {
                    if (t.get(i).equals(cnum)) {
                        t.remove(i);
                        found = true;
                    } else
                        i++;
                }
            }
            if (t.isEmpty()) {
                kt.add(k);
            }

        }

        for (int i = 0; i < kt.size(); ++i) {
            _enroll.remove(kt.get(i));
        }
        return found;
    }

    public String toString(){
        String s = "Enrollment:\n";
        Set keys = _enroll.keySet();
        Iterator itr = keys.iterator();
        while (itr.hasNext()) {
            String k = (String)itr.next();
            ArrayList<String> t = _enroll.get(k);
            s += (k + " ");
            for (int j=0; j<t.size(); j++)
                s += (t.get(j) + " ");
            s += "\n";
        }
        return s;
    }
}
class AllStudents{
    private ArrayList<Student> _students;
    public AllStudents(){
        _students = new ArrayList<Student>();
    }
    public void addStudent(String id, String s, String c, String st, String z){
        _students.add(new Student(id, s, c, st, z));
    }
    public boolean studentExists(String id){
        int i=0;
        boolean found = false;
        while (i<_students.size() && !found){
            if (_students.get(i).getID().equals(id))
                found = true;
            else
                i++;
        }
        return found;
    }
    public void removeStudent(String id){
        int i=0;
        boolean found = false;
        while (i<_students.size() && !found){
            if (_students.get(i).getID().equals(id))
                found = true;
            else
                i++;
        }
        _students.remove(i);
    }
    //public void print(){  // testing purposes only
    public String toString(){
        String s = "Students:\n";
        for (int i=0; i<_students.size(); i++)
            s += (_students.get(i).toString() + "\n");
        return s;
    }
}
class AllCourses{
    private ArrayList<Course> _courses;
    public AllCourses(){
        _courses = new ArrayList<Course>();
    }
    public void addCourse(String id, int c){
        _courses.add(new Course(id, c));
    }
    public boolean courseExists(String id){
        int i=0;
        boolean found = false;
        while (i<_courses.size() && !found){
            if (_courses.get(i).getNumber().equals(id))
                found = true;
            else
                i++;
        }
        return found;
    }
    public void removeCourse(String id){
        int i=0;
        boolean found = false;
        while (i<_courses.size() && !found){
            if (_courses.get(i).getNumber().equals(id))
                found = true;
            else
                i++;
        }
        _courses.remove(i);
    }
    public String toString(){
        String s = "Courses:\n";
        for (int i=0; i<_courses.size(); i++)
            s += (_courses.get(i).toString() + "\n");
        return s;
    }
}
class Singleton{
    private AllStudents _allStud;
    private AllCourses _allCrs;
    private Enrollment _enroll;
    public Singleton(){
        _allStud = new AllStudents();
        _allCrs = new AllCourses();
        _enroll = new Enrollment();
    }
    public void addStudent(String id, String s, String c, String st, String z){
        _allStud.addStudent(id, s, c, st, z);
    }
    public void addCourse(String c, int cr) {
        _allCrs.addCourse(c, cr);
    }
    public boolean addEnrollment(String id, String cnum){
        // check if course and student exist
        if (_allCrs.courseExists(cnum) && _allStud.studentExists(id)){
            System.out.println("adding");
            _enroll.addCourseToStudent(id, cnum);
            return true;
        }
        return false;
    }
    public void dropCourseFromEnrollment(String cnum){
        // drops a course from enrollment
        _enroll.dropCourseFromEnrollment(cnum);
    }

    public void dropStudentFromCourse(String id, String cnum) {
        _enroll.dropStudentFromCourse(id, cnum);
    }
    public String toString(){
        String s = _allStud.toString() + "\n" +
                _allCrs.toString() + "\n" +
                _enroll.toString();
        return s;
    }
}

public class Main {
    public static void main(String[] args) {
        Singleton s = new Singleton();
        s.addCourse("CSC3250", 4);
        s.addCourse("CSC1700", 4);
        s.addCourse("MTH3270", 4);
        s.addStudent("100", "1 Elm", "Aurora", "IL", "60506");
        s.addStudent("200", "1 Elm", "Aurora", "IL", "60506");
        s.addEnrollment("100", "CSC3250");
        s.addEnrollment("200", "CSC3250");
        s.addEnrollment("200", "CSC1700");
        s.addEnrollment("200", "MTH3270");
        System.out.println(s.toString());
        s.dropCourseFromEnrollment("CSC3250");
        System.out.println(s.toString());
    }
}
