import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;


class Temp implements AutoCloseable {


    @Override
    public void close() throws Exception {
        System.out.println("Closing");
    }
}
public class app {
    public static void main(String[] args) {
        File file = new File("test.txt");
        try {
            testException(); // This function can throw the FileNotFoundException. So the calling function can either handle it or throw it in turn
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        testRuntime();

        System.out.println("Finished");
    }

    public static void testException() throws FileNotFoundException {
        // This function can either handle the exception within the function or throw it
        File file = new File("test.txt");
        FileReader fr = new FileReader(file);
    }

    public static void testMultipleException() {
        Test test = new Test();
        /*
        Exception catch chaining. Order of exception is important subclasses should come before its base classes
        try {
            test.run();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        */
        // Java 7 multicatch
        try {
            test.run();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

    }

    public static void testRuntime() {

        int val = 7;
        val = val/0; // This will cause / by Zero runtime exception. As you can see we dont have to add exception handlers for run time exceptions.
        // THis is because RTE are real code issue in your programs and there may not be a way to recover from them

        String text = null;
        text.length(); //This will cause NullPointException. easy to fix once found.

        // you can catch the RTE exceptions but you are not forced to by Java
        try {
            String[] texts = {"one"};
            String x = texts[3]; //Index out of bound

        } catch (RuntimeException e) {
            System.out.println(e.toString());
        }

    }

    public static void testTryWithResources(){
        //Try with resources
        // this is a Java 7 feature.. reduces the try catch chaining

        Temp temp = new Temp();

        //normal old way of try catch
        try {
            temp.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try(Temp temp1 = new Temp()){ //this should be autocloseable object
            // close is automatically called
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
