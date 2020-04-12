public class Tree extends Plant {


    @Override
    public void grow() {
//        super.grow(); // this is calling the base method
        System.out.println("Tree growing!!");
    }


    public void shedLeaves() {
        System.out.println("Tree shedding leaves");
    }


}
