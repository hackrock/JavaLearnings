import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class app {
    public static void main(String[] args) {
        File file = new File("test.txt");
        try {
            testException(); // This function can throw the FileNotFoundException. So the calling function can either handle it or throw it in turn
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

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
}
