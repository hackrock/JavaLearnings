import java.util.ArrayList;
/*
Generics was added mainly to provide compile time type checking when casting classes to avoid ClassCastException
Generics class or method or interface can work with any class types and you specify the class types when you instantiate them. Once instantiated you can use only those class types with your generic object. eg: ArrayList.
Compiler takes care of type checking during compile time thereby avoiding runtime errors. So type casting during runtime.
The whole collection library was rewritten to use generics to avoid such type cast errors during runtime
 */
public class App {


    public static void main(String[] args) {
        // Old way without generics
        ArrayList al = new ArrayList();
        al.add("AAAAA");
        al.add("BBBB");
        al.add(22); //Now arraylist contains both String and integers. So if you are not careful with typecasting you will end up with RTEs

        String x;
        x = (String) al.get(0);
        x = (String) al.get(1);
        // x = (String) al.get(2); // ClassCastException: java.lang.Integer cannot be cast to java.lang.String
        //for(String value: al) { //This wont work because there is no explicit casting of Object type in list to String.
        //    System.out.println(value);
        //}

        // New way of using collections using generics

        ArrayList<String> alnew = new ArrayList<String>(); //ArrayList is a generic class. When you instantiate it you must specify the type. Here we are specifying type
        alnew.add("AAAA");
        alnew.add("BBB");
        //alnew.add(12); //THis will throw compile time error because ArrayList here can only contain string objects.
        for(String value: alnew) { // this will work because compiler compare the type of ArrayList to type of val
            System.out.println(value);
        }

        String y;
        y = alnew.get(0); // No type casting is required to extract list object. Compiler makes sure they are same.
        y = alnew.get(1);


    }
}
