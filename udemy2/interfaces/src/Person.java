public class Person implements Info {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void greet() {
        System.out.println("Hellow all");
    }

    @Override
    public void showInfo() {
        System.out.println("Name is :" + name);
    }
}
