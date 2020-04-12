class Machine1 {

    private String type = "Mac1";

    String name = "Base machine";

    protected int power = 100;

    public void start() {
        System.out.println("Started");
    }

    public void stop() {
        System.out.println("Stopped");
    }



}

class Car extends Machine1 {

//    private String name = "Car"; //DONT Override variable.. very bad practice
    private String newname = "Car";

    public void wipe() {
        System.out.println("Wiping");
    }

    //override base class method
    @Override  // This annotation checks if you are realy overriding a method in base class. Optional
    public void start() {
        System.out.println("Car started");
    }

    public void showInfo() {
//        System.out.printf("Name: %s, Type: %s\n", name, type); //You can access base class private variable in derived
        System.out.printf("Name: %s, NewName: %s\n", name, newname);

        // protected members can be accessed by the derived class
        System.out.printf("Name: %s, pwer: %d\n", name, power);
    }
}
public class Inheritence {

    public static void main(String[] args) {
        Machine1 m1 = new Machine1();

        m1.start();
        m1.stop();

        Car c1 = new Car();
        c1.start();
        c1.wipe();

        c1.showInfo();
    }
}
