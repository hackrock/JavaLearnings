public enum Animal2 {
    // The enum values are not strings or constants codes. They are special objects.
    // you can specify some properties of the object by defining the constructor here
    CAT("tom"), DOG("pluto"), BIRD("chirpy");

    private String name;
    Animal2(String name) { // this means each enum object needs to be initialized with a string
        this.name = name;
    }

    public String getName() { // get the name of each Enum object
        return this.name;
    }

    public String toString() {
        return "this animal is called " + name;
    }
}
