import java.util.*;

interface DoorInterface {
    public void open();
    public void close();
}
abstract class Door {
    private boolean _open;
    public Door(){
        System.out.println("in Door default constructor");
        _open = true;
    }
    public Door(boolean b){
        System.out.println("in Door n-arg constructor");
        _open = b;
    }
    public abstract void open();

    public void setOpen(boolean p_open) {
        _open = p_open;
    }
    public boolean getOpen() {
        return _open;
    }

    public void close(){
        System.out.println("in door close");
        _open = false;
    }
    public boolean isOpen(){
        return _open;
    }
    public String toString(){
        return "Open: " + Boolean.toString(_open);
    }
    public boolean equals(Object obj){
        if(((Door) obj)._open == _open)
            return true;
        else
            return false;
    }
}

/**
 * Door can't be locked unless closed.
 */
class LockedDoor extends Door implements DoorInterface{
    private boolean _locked;
    public LockedDoor(){
        System.out.println("in Locked Door default constructor");
        _locked = false;
    }
    public LockedDoor(boolean lock){
        System.out.println("In LockedDoor n-arg constructor");
        _locked = lock;
        // if setting door to locked, then close door
        // this can be handled in other ways
        if (lock && isOpen()){
            close();
        }
    }
    public void open(){
        // Overriding base open method
        System.out.println("in locked door open");
        // Option 1
        _locked = false;
        super.setOpen(true);
        //super.open();
        // Option 2
        //if (_locked)
        //    System.out.println("must unlock door first");
        //else
        //    super.open();
    }
    public void lock(){
        // Option 1
        if (isOpen()) {
            System.out.println("must close door first");
        }
        else {
            _locked = true;
            System.out.println("door is locked");
        }
        // Option 2
        //close();
        //_locked = true;
    }
    public void unlock(){
        System.out.println("unlocking door");
        _locked = false;
    }
    public boolean isLocked(){
        return _locked;
    }

    public String toString(){
        return super.toString() + " Locked: " + Boolean.toString(_locked);
    }

    public boolean equals(Object obj){
        if(((LockedDoor) obj)._locked == _locked && super.equals(obj))
            return true;
        else
            return false;
    }
}
class PasswordDoor extends LockedDoor implements DoorInterface{
    private String _password;
    public PasswordDoor(){
        super(true);
        _password = "password";
        System.out.println("in Password Door default constructor");
    }
    public PasswordDoor(boolean lock, String pw){
        super(lock);
        _password = pw;
        System.out.println("in Password Door n-arg constructor");
    }

    //Overloading the base open (locked door)
    public void open(String pw) {
        System.out.println("In overloaded open of password");

        if (_password.equals(pw)) {
            super.unlock();
            super.open();
        }
    }

    @Override
    public void open() {

    }

    //@Override
    //public void open() {
      //  System.out.println("In overridden open");
    //}

}

/*
class Door {
    private boolean _open;
    public Door(){
        System.out.println("in Door default constructor");
        _open = true;
    }
    public Door(boolean b){
        System.out.println("in Door n-arg constructor");
        _open = b;
    }
    public void open(){
        System.out.println("in door open");
        _open = true;
    }
    public void close(){
        System.out.println("in door close");
        _open = false;
    }
    public boolean isOpen(){
        return _open;
    }
    public String toString(){
        return "Open: " + Boolean.toString(_open);
    }
    public boolean equals(Object obj){
        if(((Door) obj)._open == _open)
            return true;
        else
            return false;
    }
}
 */

/*
class LockedDoor extends Door{
    private boolean _locked;
    public LockedDoor(){
        System.out.println("in Locked Door default constructor");
        _locked = false;
    }
    public LockedDoor(boolean lock){
        System.out.println("In LockedDoor n-arg constructor");
        _locked = lock;
        // if setting door to locked, then close door
        // this can be handled in other ways
        if (lock && isOpen()){
            close();
        }
    }
    public void open(){
        // Overriding base open method
        System.out.println("in locked door open");
        // Option 1
        _locked = false;
        super.open();
        // Option 2
        //if (_locked)
        //    System.out.println("must unlock door first");
        //else
        //    super.open();
    }
    public void lock(){
        // Option 1
        if (isOpen()) {
            System.out.println("must close door first");
        }
        else {
            _locked = true;
            System.out.println("door is locked");
        }
        // Option 2
        //close();
        //_locked = true;
    }
    public void unlock(){
        System.out.println("unlocking door");
        _locked = false;
    }
    public boolean isLocked(){
        return _locked;
    }

    public String toString(){
        return super.toString() + " Locked: " + Boolean.toString(_locked);
    }

    public boolean equals(Object obj){
        if(((LockedDoor) obj)._locked == _locked && super.equals(obj))
            return true;
        else
            return false;
    }
}
class PasswordDoor extends LockedDoor{
    private String _password;
    public PasswordDoor(){
        super(true);
        _password = "password";
        System.out.println("in Password Door default constructor");
    }
    public PasswordDoor(boolean lock, String pw){
        super(lock);
        _password = pw;
        System.out.println("in Password Door n-arg constructor");
    }

    //Overloading the base open (locked door)
    public void open(String pw) {
        System.out.println("In overloaded open of password");

        if (_password.equals(pw)) {
            super.unlock();
            super.open();
        }
    }

    @Override
    public void open() {
        System.out.println("In overridden open");
    }

}
 */