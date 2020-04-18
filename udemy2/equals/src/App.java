import java.util.Objects;

class Person {

    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return id == person.id &&
                name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

public class App {
    public static void main(String[] args) {
        Person p1 = new Person(5, "bob");
        Person p2 = new Person(6, "ss");
        Person p3 = new Person(6, "ss");
        Person p4 = new Person(6, "ss");

        System.out.println(p1 == p2);
        System.out.println(p3 == p2); // it will be still false  because they are different object
        // == nly checks if 2 references are pointing to same memory location or object

        p2 = p1;
        System.out.println(p1 == p2); // now true

        // this is why we use .equals which is inherited from superclass 'Object'
        System.out.println(p4.equals(p3));

        String s1 = "aaaaa";
        String s2 = "aaaaa";

        System.out.println(s1 == s2); // this is come out as equal because Java optimizes and reuse the same object. Dont rely on this equality operation.


        // hashcode

        System.out.println(p1.hashCode());

    }
}
