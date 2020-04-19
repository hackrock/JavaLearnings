import java.io.Serializable;

public class Person implements Serializable {

    private int id;
    private String name;

    // Some variables of class need not be serialized. You can mark those variables as transient
    // These variables take default values on deserialization. eg int takes the value 0
    private transient int tempId;
    // Static variables are NOT included during serialization. They also take default values
    private static String tempName;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + " tempId=" + tempId + " tempName=" + tempName+'\'' +
                '}';
    }

    public Person(int id, String name) {
       this.id = id;
       this.name = name;
    }

}
