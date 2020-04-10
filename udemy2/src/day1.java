
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

    public static  void main(String[] args) {
        System.out.println(("Hello World"));

        primitiveTypes();
        nonPrimitive();
    }
}
