public class App {
    public static void main(String[] args) {
        Robot r = new Robot(1);
        r.start();

        Robot.Battery battery = new Robot.Battery(0);
        battery.charge();

        r.replaceBattery(battery);
    }
}
