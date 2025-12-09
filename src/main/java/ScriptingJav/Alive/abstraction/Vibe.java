package ScriptingJav.Alive.abstraction;

import java.util.Random;

public enum Vibe {
    Official("Official", 1),
    Practical("Practical", 2),
    Dramatic("Dramatic", 3),
    Comfy("Comfy", 4);
   
    private final int ID;
    private final String VIBE;
    private final static Random RANDOM = new Random();
    private final static Vibe[] VALUES = values();
    Vibe(String vibe_name, int id){
        this.ID = id;
        this.VIBE = vibe_name;
    }

    public static Vibe getrandVibe(){
        return VALUES[RANDOM.nextInt(VALUES.length)];
    }

    public String getVIBE() {
        return VIBE;
    }

    public int getID() {
        return ID;
    }


}
