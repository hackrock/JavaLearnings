import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class readingFile {

    public static void main(String[] args) {

        String fileName = "sampleText";

        File textFile = new File(fileName);

        try {
            Scanner in = new Scanner(textFile);
            while (in.hasNext()) {
                String line = in.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}

