
/*
As you see Machine and Person have nothing in common and cannot be derived from a base class.
But what if you want both the classes to implement similar functionality. eg: ShowINfo.
This is where interfaces come in. You can make disparate classes implements a particular functionality using interfaces

a class can implement multiple interfaces unlike a class extending only one base class (JAVA has no multiple inheritance ).

An interface can be used just like a class but cannot be instantiated
 */
public class App {

    public static void main(String[] args) {
        Person p = new Person("SSS");
        p.greet();
        p.showInfo();

        Machine m = new Machine();
        m.start();
        m.showInfo();

        //An interface can be used just like a class but cannot be instantiated.
        // But interface references can point to class objects that implements them.
        Info machineInfo = new Machine();
        machineInfo.showInfo(); //machineInfo can access only methods in the interface and not other methods of class Machine
        //Above is useful you pass disparate objects to functions with interfaces as arguments as show below
        printInfo(p);
        printInfo(m);
        printInfo(machineInfo);


    }

    private static void printInfo(Info infoObject) {
        infoObject.showInfo();
    }
}
