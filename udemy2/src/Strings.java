class ToStrTest {

    private String name;

    public ToStrTest(String name) {
        this.name = name;
    }

    public String toString() {
        return String.format("Class representation string: %s", name);
    }
}

public class Strings {

    public static void stringBuilder() {
        //strings are immutable
        String test = " dd ";
        test += " asdasd"; //actually creates a new string
        //Not efficient if done very very frequently

        // can use string builder to make this update more efficient

        StringBuilder sb = new StringBuilder("");

        sb.append("asdasd");

        System.out.println(sb);

        sb.append("   ttttt");
        System.out.println(sb);
        sb.insert(0, "lll ");
        System.out.println(sb);

        //string builder returns a ref to the object. so can be used for chaining

        sb.append("oooo ").append("  ssss");
        System.out.println(sb.toString());

    }

    public static void strFormatting() {

        //%10d => 10 wide integer
        System.out.printf("total %10d, %.2f \n", 55555555, 5.5);  //.2f => how many decimal places you want
        System.out.printf("total %51.2f \n", 5.5); //width plus precision
        for (int i=0; i < 15; i++) {
            System.out.printf("%-2d: number\n", i); //left formatting with width
        }



    }



    public static void main(String[] args) {

//        strFormatting();
        Object o = new Object();
        System.out.println(o.toString());
        System.out.println(o.hashCode());

        ToStrTest st = new ToStrTest("kkkk");
        System.out.println(st);
    }
}
