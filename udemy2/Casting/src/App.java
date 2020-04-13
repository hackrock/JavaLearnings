public class App {

    public static void main(String [] args) {

        Machine machine = new Machine();
        Motor motor = new Motor();

        machine.start();
        motor.start();

        // Polymorphism is ability to use a subclass  where base class is expected. This UPCASTING
        //Upcasting is casting to a type which is up in the class hierarchy

        machine = motor; //machine which is of type Machine can refer to ab instance of type Motor
        machine.start();

        // Downcasting is passing a  reference of type baseclass to a reference which is of subclass type. The baseclass reference should be referring to an instance of subclass for this to work
        // Downcasting is explicit because of possibility of run time errors. This is to make sure you know what you are doing

        Machine machine3 = new Machine();
        //Motor motor3 = (Motor) machine3; // This wont work because you can downcast an instance of type baseclass to subclass

        Machine machine4 = new Motor(); // Baseclass reference to a subclass object because polymorphism works
        //machine4.stop(); //cannot access stop method

        Motor motor4 = (Motor) machine4; // Downcasting
        motor4.stop(); // Works

    }
}
