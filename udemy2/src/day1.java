import java.util.Scanner;

public class day1 {

    public static void primitiveTypes() {
        int myNumber;

        myNumber = 88;

        short myShort = 1;
        long myLong = 12;

        double myDouble = 7.4;
        float myFloat = 3.4f;

        char myChar = 'D';

        boolean myBoolean = true;

        byte myByte = 127; //8bits

        System.out.println(myNumber);
        System.out.println(myByte);

    }

    public static void nonPrimitive() {

        String text = "Hello"; //String is a class not primitive type

        System.out.println(text);

        String blank = " ";

        String name = "Bob";

        String greeting = text + blank + name;

        System.out.println(greeting);

        int myInt = 3;
        System.out.println("Interger is : " + myInt);

    }

    public static void loop() {

        int value = 0;

        while (value < 10) {
            System.out.println("value :" + value);
            value += 1;
        }

        for (value=0; value <10; value++){
            System.out.printf("for value : %d\n", value);
        }
    }

    public static void conditionals() {

        int val = 7;

        if (val < 4) {
            System.out.println("Val is less than 4");
        }
        else if (val == 5) {
            System.out.println("Val is 5");
        }
        else {
            System.out.println("Val greater than 5");
        }

        while (true) {
            System.out.println("inside while loop");
            if (val > 5) {
                break;
            }
        }
    }


    public static void userInput(){

        Scanner input = new Scanner(System.in);


        System.out.println("Enter a line");

        //wait for user to enter a line
        String line = input.nextLine();
        System.out.println("U entered: " + line);

        //use scanner to get other primitives too
        System.out.println("Enter an integer");
        int val = input.nextInt();
        System.out.println("Integer is " + val);


        //use scanner to get other primitives too
        System.out.println("Enter an floating point val");
        double d = input.nextDouble();
        System.out.println("Double is " + d);

    }


    public static void doWhile() {

        Scanner input = new Scanner(System.in);
        int value = 0;

        do {
            System.out.println("Enter an interger");
            value = input.nextInt();
        }
        while (value != 5);

        System.out.println("Entered 5");
    }

    public static void switchStatement() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a command");
        String text  = input.nextLine();

        switch (text) {

            case "start":
                System.out.println("Started prog");
                break;

            case "stop":
                System.out.println("Stopped prog");
                break;

            default:
                System.out.println("Command not found");

        }

    }

    public static  void main(String[] args) {
        System.out.println(("Hello World"));

        primitiveTypes();
        nonPrimitive();
        loop();
        conditionals();
        //userInput();
        //doWhile();
        switchStatement();
    }
}
