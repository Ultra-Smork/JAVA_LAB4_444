package ScriptingJav.Objects.abstraction;

import java.util.Random;

public enum Size {
    Small("Small", 0),
    Medium("Medium", 1),
    Large("Large", 2),
    Enormous("Enormous", 3),
    Humongous("Humongous", 4);
    private final String SIZE;
    private final int ID;
    private static final Random RANDOM = new Random();
    private static final Size[] VALUES = values();
    Size(String size, int id){
        this.SIZE = size;
        this.ID = id;
    }

    public String getName() {
        return SIZE;
    }

    public int getId() {
        return ID;
    }

    public static Size getRandomSize(){
        return VALUES[RANDOM.nextInt(VALUES.length)];
    }

    public Object getArea() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getArea'");
    }


}
