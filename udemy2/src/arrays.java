public class arrays {

    public static void intArray() {
        int[] values; //this is a reference

        values = new int[3]; // refer to a new mem location that can hold 3 int.

        System.out.println(values[0]); //java initializes the values to a default of 0

        values[0] = 234;

        System.out.println(values[0]);

        //System.out.println(values[3]); //IndexOutofBoundsException


        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }


        int[] numbers = {3, 4, 5};

        System.out.println(numbers); //prints the reference
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }

    public static void stringArray() {
        String[] words = new String[3];

        words[0] = "Hello";

        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }

        String[] fruits = {"apple", "banana"};
        for (int i = 0; i < fruits.length; i++) {
            System.out.println(fruits[i]);
        }


        int value = 123;

        String text = "hellow"; //This is a class. test is a reference . default value of ref is a null. text refers to the address in mem containing hellow

    }

    public static void multiDimArray() {
        int[][] grid = {
                {1, 2, 3, 4},
                {2, 4},
                {1, 2, 3, 5, 6}

        };

        System.out.println(grid[1][1]);
        grid[1][1] = 9;
        System.out.println(grid[1][1]);

        String[][] texts = new String[2][3];
        System.out.println(texts[0][0]);

        for (int i=0; i < grid.length; i++){
            for (int j=0; j < grid[i].length; j++){
                System.out.print(grid[i][j] + "\t");
            }
            System.out.println();
        }

        String[][] words = new String[2][]; //2 rows .cols not set

        System.out.println(words[0]);

        words[0] = new String[3];

        words[0][1] = "hi there";

        for (int i=0; i < words.length; i++){
            for (int j=0; j < words[i].length; j++){
                System.out.print(words[i][j] + "\t");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
//        intArray();
//        stringArray();
        multiDimArray();

    }

}
