import ocean.Fish;
import ocean.plants.Seaweed;

//Usually packages names are not this simple. Simple pnames like this may lead to collisions when distributed.
//Indored to avoid that, package name are made uniques by adding reversed website appened to it
//eg com.rocky.ocean
public class Package_App {

    public static void main(String[] args) {
        Fish f = new Fish();
        Seaweed s = new Seaweed();
    }

}
