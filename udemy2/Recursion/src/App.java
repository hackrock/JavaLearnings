public class App {
    public static void main(String[] args) {
       int value = 4;
       calculate(value);
       System.out.println(value);
    }

    private static void calculate(int value) {
        if (value < 0){
            return;
        }

        System.out.println(value);
        calculate(value - 1);

    }
}
