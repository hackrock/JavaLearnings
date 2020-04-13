public class Motor extends Machine {


    @Override
    public void start() {
        System.out.println("Motor starting");
    }

    public void stop() {
        System.out.println("Motor stopping");
    }
}
