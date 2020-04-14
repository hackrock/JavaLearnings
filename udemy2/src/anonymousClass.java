
class Machine3 {
    public void start(){
        System.out.println("Machine started");
    }
}

interface Paint {
    void paint();
    //void spray();
}

public class anonymousClass {

    public static void main(String[] args) {

        Machine3 m = new Machine3() {
            @Override
            public void start() {
                System.out.println("Overriding start ");
            }
        };

        m.start(); //Here the method is overrided without creating a explicit subclass.
        System.out.println(m.getClass()); // will give  anonymousClass$1


        //You can also use interfaces with Anonymous class.

        Paint p = new Paint() {
            public void paint() {
                System.out.println("Painting house");
            }
        };

        p.paint(); // Here p is an anonymous class implementing the interface Paint

    }

}
