import java.util.*;

class Course{
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
class Student{
    private String _sid;
    public Student(){}
    public Student(String d){_sid = d;}
    public void setID(String id){_sid = id;}
    public String getID(){return _sid;}
    public String toString(){return _sid;}
}
interface SearchBehavior<T, S> {
    //T is the object, S is the value
    boolean search(T object, S value);
}
class StudentSearch implements SearchBehavior<Student, String> {
    @Override
    public boolean search(Student object, String value) {
        return object.getID().equals(value);
    }
}
class CourseSearch implements SearchBehavior<Course, String> {
    @Override
    public boolean search(Course object, String value) {
        return object.getNumber().equals(value);
    }
}

class CnumSearch implements SearchBehavior<String, String> {
    @Override
    public boolean search(String value1, String value2) {
        return value1.equals(value2);
    }
}

class AllItems<T> {
    private ArrayList<T> items;

    public AllItems(){
        items = new ArrayList<T>();
    }
    public AllItems(int size){
        items = new ArrayList<T>(size);
    }

    public void addItem(T item) {
        items.add(item);
    }
    public void removeItem(int i) {
        if (i != -1 && i < items.size()) {
            items.remove(i);
        }
    }

    /*public <S> boolean isItem(S v, SearchBehavior<T, S> searchBehavior) {
        for (T item : items) { //Allowed to use a non-exhaustive while loop instead.
            if (searchBehavior.search(item, v)) {
                return true; //BREAKING OUT OF A LOOP? EWWWWWWWWW
            }
        }
        return false;
    }*/

    public <S> int findItem(S v, SearchBehavior<T, S> sb) {
        for (int i = 0; i < items.size(); ++i) { //Allowed to use a non-exhaustive while loop instead.
            if (sb.search(items.get(i), v)) {
                return i; //BREAKING OUT OF A LOOP? EWWWWWWWWW
            }
        }
        return -1;
        /*
            int i = 0; //Non-exhaustive version
            boolean isFound = false;


            while (i < items.size() && !isFound) {
                if (searchBehavior.search(items.get(i), v)) {
                    isFound = true;
                }
            }

            return isFound;
        */
    }

    public int size() {
        return items.size();
    }

    public T getItem(int i) {
        return items.get(i);
    }
}
class AllStudents{
    private AllItems<Student> _students;

    public AllStudents(){
        _students = new AllItems<Student>();
    }

    public AllStudents(int size) {
        _students = new AllItems<Student>(size);
    }

    public void addStudent(String id){
        _students.addItem(new Student(id));
    }

    public boolean isStudent(String id){
        if (_students.findItem(id, new StudentSearch()) != -1) {
            return true;
        }
        else {
            return false;
        }
    }
    public int findStudent(String id){
        return _students.findItem(id, new StudentSearch());
    }
    public void removeStudent(String id){
        int i = findStudent(id);
        _students.removeItem(i);
    }
    public int size() {
        return _students.size();
    }
    public void modifySID(String oldID, String newID) {
        int i = findStudent(oldID);
        _students.getItem(i).setID(newID);
    }

    public String toString() {
        String s = "Students:\n";
        for (int i=0; i<_students.size(); i++)
            s += (_students.getItem(i).toString() + "\n");
        return s;
    }
}
class AllCourses{
    private AllItems<Course> _courses;

    public AllCourses(){
        _courses = new AllItems<Course>();
    }

    public AllCourses(int size) {
        _courses = new AllItems<Course>(size);
    }

    public void addCourse(String cnum, int c){
        _courses.addItem(new Course(cnum, c));
    }
    public boolean isCourse(String cnum){
        int i = _courses.findItem(cnum, new CourseSearch());
        if (i == -1) {
            return false;
        }
        else {
            return true;
        }
    }
    public int findCourse(String cnum){
        return _courses.findItem(cnum, new CourseSearch());
    }
    public void removeCourse(String cnum){
        int i = _courses.findItem(cnum, new CourseSearch());
        _courses.removeItem(i);
    }
    public void modifyCnum(String oldNum, String newNum) {
        int i = _courses.findItem(oldNum, new CourseSearch());
        _courses.getItem(i).setNumber(newNum);
    }
    public int size() {
        return _courses.size();
    }
    public String toString(){
        String s = "Courses:\n";
        for (int i=0; i<_courses.size(); i++)
            s += (_courses.getItem(i).toString() + "\n");
        return s;
    }
}

class Enrollment {
    private HashMap<String, AllItems<String>> _enroll;

    public Enrollment () {
        _enroll = new HashMap<String, AllItems<String>>();
    }

    public boolean dropStudentFromCourse(String id, String cnum) {
        // Drops the course from the student's set of courses
        // If no other courses exist for the student, drop the student from the hashmap.
        AllItems<String> t = _enroll.get(id);
        int i = t.findItem(cnum, new CnumSearch());
        if (i == -1) {
            return false;
        }
        else {
            t.removeItem(i);
            if (t.size() == 0) {
                _enroll.remove(id);
            }
            return true;
        }
    }

    public boolean dropCourseFromAllStudents(String cnum) {

        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        AllStudents as = new AllStudents();
        AllCourses ac = new AllCourses();
        as.addStudent("100");
        as.addStudent("200");
        as.addStudent("300");
        ac.addCourse("CSC3250", 4);
        ac.addCourse("CSC1700", 4);
        ac.addCourse("MTH3270", 4);
        System.out.println(as);
        System.out.println(ac);
        System.out.println("Is Student 300: " + as.isStudent("300"));
        System.out.println("Find Student 300: " + as.findStudent("300"));
        System.out.println("Is Course CSC3250: " + ac.isCourse("CSC3250") );
        System.out.println("Find Course CSC3250: " + ac.findCourse("CSC3250"));
        as.removeStudent("300");
        System.out.println("\nAfter removing student 300");
        as.removeStudent("300");
        System.out.println(as);
        System.out.println("Is Student 300: " + as.isStudent("300"));
        System.out.println("Find Student 300: " + as.findStudent("300"));
        System.out.println("\nAfter removing course 3250");
        ac.removeCourse("CSC3250");
        System.out.println(ac);
        System.out.println("Is Course CSC3250: " + ac.isCourse("CSC3250") );
        System.out.println("Find Course CSC3250: " + ac.findCourse("CSC3250"));
    }
}