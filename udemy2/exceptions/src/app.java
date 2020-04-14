import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

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
}
