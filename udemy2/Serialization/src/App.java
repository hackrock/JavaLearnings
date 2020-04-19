import javax.print.attribute.standard.PresentationDirection;
import javax.tools.FileObject;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        writeToFile();
        readFromFile();
        writeArrayToFile();
        readPersonArrayFromFile();
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


    public static void writeArrayToFile() {
        Person[] personList = {new Person(1,"qqq"), new Person(2, "eee")};

        // You can also write serialized ArrayList as well
        ArrayList<Person> personArrayList = new ArrayList<Person>(Arrays.asList(personList));

        try(FileOutputStream fos = new FileOutputStream("test.txt")){

            try (ObjectOutputStream os = new ObjectOutputStream(fos)) { // this is one way where we do not have to have worry about closing OR NOT closing on an exception
//                os.close();
                System.out.println("Writing Person array to file :" + personList);
                os.writeObject(personList); // Writing the whole list in one go .. similarly read back in whole. We are not writing Person object by object here

                System.out.println("writing  ArrayList :" + personArrayList);
                os.writeObject(personArrayList);

                // You can also write object by object. Just put a sentinel value to indicate how may objects are written so that you can de-serialize
                System.out.println("Writing object by object");
                int num = personList.length;
                os.writeInt(num);
                for (Person p: personList) {
                    os.writeObject(p);
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void readPersonArrayFromFile(){

        try(FileInputStream fis = new FileInputStream("test.txt");
            ObjectInputStream os = new ObjectInputStream(fis);){  // You can add os in the initially try too. This way you dont have to worry about closing os.
//            ObjectInputStream os = new ObjectInputStream(fis);
            Person[] personList = (Person[]) os.readObject(); // it is reading the whole array object and casting to appropriate array type
            for (Person person: personList) {
                System.out.println("Read person array" + person);
            }
            // Next read we should get the arraylist object

            ArrayList<Person> personArrayList = (ArrayList<Person>) os.readObject();
            System.out.println("Read the arraylist :" + personArrayList);

            System.out.println("Read person object by object");
            int numObjects = os.readInt();
            for (; numObjects>0; numObjects--){
                Person p = (Person) os.readObject();
                System.out.println(p);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
