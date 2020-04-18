public class App {
    public static void main(String[] args) {

        Animal animal = Animal.CAT;

        switch (animal) {

            case CAT: // Dont have to have Animal.CAT inside a switch
                System.out.println("Switch CAT ");
                break;
            case DOG:
                System.out.println("Switch dog");
                break;
            case BIRD:
                System.out.println("Switch bird");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + animal);
        }

        System.out.println(Animal.DOG); // will output DOG
        System.out.println(Animal.DOG.getClass()); // class Animal

        System.out.println(Animal.DOG instanceof Enum); //true
        System.out.println(Animal.DOG instanceof Object); //true

        //////// Animal2

        System.out.println(Animal2.DOG); // getName of enum object is called. outputs pluto
        System.out.println(Animal2.DOG.name()); // this is give the actual Enum object name which is DOG.
        // USe enum names for storign in DB




    }
}
