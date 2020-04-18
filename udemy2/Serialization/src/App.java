import javax.print.attribute.standard.PresentationDirection;
import java.io.*;

public class App {
    public static void main(String[] args) {
        writeToFile();
        readFromFile();
    }

    public static void writeToFile() {
        Person p1 = new Person(2, "django");
        Person p2 = new Person(3, "bruno");

        try (FileOutputStream fos = new FileOutputStream("tempFile.txt") ){
            ObjectOutputStream os = new ObjectOutputStream(fos);

            os.writeObject(p1);
            os.writeObject(p2);

            os.close(); // fos gets closed automatically because it is withing try with resources.. This has to done explicitly

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFromFile() {

        try (FileInputStream fis = new FileInputStream("tempFile.txt") ) {
            ObjectInputStream os = new ObjectInputStream(fis);

            Person p1 = (Person) os.readObject();
            Person p2 = (Person) os.readObject();

            System.out.println(p1.toString());
            System.out.println(p2.toString());

            os.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {  // When you cast to Person if there is a mismatch then it will come here
            e.printStackTrace();
        }
    }
}
