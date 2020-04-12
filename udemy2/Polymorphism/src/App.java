/*
Polymorphism is the ability to replace with subclass where ever the base class is expected
 */
public class App {

    public static void main(String [] args) {
        Plant p = new Plant();
        Tree t = new Tree();

        Plant p2 = t; // this works because t is subclass of Plant hence of type Plant

        p2.grow(); // this wil be calling the tree grow because the method is overridden in Tree
        p2.growBranch(); // this will call the Plant method because tree does not override it

        //p2.shedLeaves(); //this wont work because this method is not present in Plant class

        growBranch(t); // you can pass tree object to this method which is expecting plant object as argument

    }

    private static void growBranch(Plant plant) {
        plant.growBranch();
    }
}
