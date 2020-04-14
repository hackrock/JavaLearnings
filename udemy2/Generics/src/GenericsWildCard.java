import java.util.ArrayList;

class Machine {
    @Override
    public String toString() {
        return "Machine instance";
    }

    public void start() {
        System.out.println("Machine started");
    }
}

class Camera extends Machine {
    @Override
    public String toString() {
        return "Camera instance";
    }

    public void snap() {
        System.out.println("Camera snapping");
    }
}

public class GenericsWildCard {


    public static void main(String[] args) {

        ArrayList<Machine> ml = new ArrayList<>();

        ml.add(new Machine());
        ml.add(new Machine());

        printList1(ml);
        System.out.println("######");
        printList2(ml);

        ArrayList<Machine> ml2 = new ArrayList<>();
        ml2.add(new Camera());
        ml2.add(new Camera());

        System.out.println("######");
        printList2(ml2); //This will work because of polymorphism. Camera instance is subclass of baseclass.
        //It works because printList2 is expecting a parameter of type ArrayList<Machine> and that is what is passed

        ArrayList<Camera> ml3 = new ArrayList<>();
        ml3.add(new Camera());
        ml3.add(new Camera());

        //printList2(ml3); //Error:(51, 20) java: incompatible types: java.util.ArrayList<Camera> cannot be converted to java.util.ArrayList<Machine>
        // Polymorphism or upcasting does not work even if generic classes are using objects types which are hierarchical
        // you cannot pass ArrayList<Camera> where ArrayList<Machine> is expected unless method parameter specifies wildcard as shown below

        System.out.println("######");
        printList3(ml3); //In this case explicit casting needs to be done because wild card does not tell the compiler about the types.

        System.out.println("######");
        printList4(ml3);


    }


    public static void printList1(ArrayList list) {

        for (Object value: list) { //Since this method does not know what type of objects the ArrayList have, you have to use the Object class here
            System.out.println(value);
            Machine m = (Machine) value; //Explicit casting needs to done here to access the methods of Machine class. THis can lead to RTE
            m.start();
        }

    }

    public static void printList2(ArrayList<Machine> list) {

        for (Machine value: list) { //Since this method KNOW the type of objects the ArrayList have you can directly use the type. Compiler will do compile time checking.
            System.out.println(value);
            //Machine m = (Machine) value; //No casting needs to be done here to access the methods of Machine class.
            value.start();
        }

    }

    public static void printList3(ArrayList<?> list) {

        for (Object value: list) { //Since this method does not know what type of objects the ArrayList have, you have to use the Object class here
            System.out.println(value);
            Camera c = (Camera) value; //Explicit casting needs to done here to access the methods of Machine class. THis can lead to RTE
            c.snap();
            Machine m = (Machine) value; //Explicit casting needs to done here to access the methods of Machine class. THis can lead to RTE
            m.start();
        }

    }

    public static void printList4(ArrayList<? extends Machine> list) {

        for (Machine value: list) { //Since this method know what type of objects the ArrayList can be only Machine or its subclasses

            //Machine m = (Machine) value; //No casting needs to be done here to access the methods of Machine class.
            value.start(); //But even though we are passing in a ArrayList of Cameras only methods of Machine can be accessed safely without explicit casting.

            Camera c = (Camera) value; //Explicit upcasting can be done but it is not type cast error safe
            c.snap();
        }

    }
}
