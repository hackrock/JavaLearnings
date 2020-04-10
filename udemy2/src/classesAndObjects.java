import sun.jvm.hotspot.utilities.RBColor;

// non public class
class Person {
    String name;
    int age;

    void intro() {
        System.out.println("My name is " + name + " and my age is " + age);
    }

    int calcYearsToRetirement() {
        return 65 - age;
    }

    int getAge() {
        return age;
    }

    void setAge(int age1) {
        age = age1;
    }
}

class Robot {

    private String name; // use private for encapsulation

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public void move(double distance, String direction) {

        System.out.println("Moving " + distance + " in direction " + direction);

    }

}

public class classesAndObjects {

    public static void main(String[] args){
        Person p1 = new Person();
        p1.name = "ajax";
        p1.age = 1;

        System.out.println(p1.name);
        p1.intro();

        int years = p1.calcYearsToRetirement();
        System.out.println("Years to retirement is " + years);

        int age = p1.getAge();
        System.out.println("Age is " + age);

        p1.setAge(10);
        age = p1.getAge();
        System.out.println("Age is " + age);

        Robot r = new Robot();
        r.setName("balboa");
        System.out.println("Robit name is " + r.getName());
        r.move(123, "west");

    }
}
