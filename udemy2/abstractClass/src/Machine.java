/*
Abstract class cannot be instantiated
If there are abstract methods in the abstract class, then it must be implemented in the subclass.

Abstract class is used for class hierarchy where some common methods may be implemented in the base class.
Implementing interface just means that class has to implement a set of methods. A class can implement more than 1 interface.

 */
public abstract class Machine {
    public void start() {
        System.out.println("Machine started");
    }

    public abstract void stop();
    //private abstract void stepUp(); ///Abstract method cannot be private
}

interface Info {
    void showInfo();
}

class Motor extends Machine implements Info {

    public void stop() {
        System.out.println("Motor stops");
    }


    @Override
    public void showInfo() {
        System.out.println("THis is a camera");
    }
}
