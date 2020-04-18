public class Robot {

    private int id;
    private Battery battery;

    private class Brain {
        // this will have access to id of robot class
        // it is used for logical grouping within a class.
        // it is not usually accessed outside of the class but it is possible to do so.
        private int brainPower;

        //private static int test; //Inner class cannot have static variables

        private void think(){
            System.out.println("Robot " + id + " is thinking ");
        }
    }

    //static class
    // Static classes is used for in place of normal classes but we need it to be grouped with a parent class
    // eg: Battery in a Robot. Battery in a robot can be replaced.
    // Also Battery is independent of the Robot variables .. Hence Static
    public static class Battery {
        private int chargeLevel;

        public Battery(int chargeLevel) {
            this.chargeLevel = chargeLevel;
        }

        public void charge(){
            System.out.println("Charging battery");
        }

    }

    public Robot(int id) {
        this.id = id;
    }

    public void start() {
        System.out.println("Starting robot");

        Brain b = new Brain();
        b.think();
    }

    public void replaceBattery(Battery battery){

        this.battery = battery;
        System.out.println("Robot has a new battery");
    }
}
