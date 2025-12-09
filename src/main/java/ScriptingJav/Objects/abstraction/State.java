package ScriptingJav.Objects.abstraction;

import java.util.Random;

public enum State {
    RUSTY("Rusty", 1),
    SHALLOW("Shallow", 2),
    NORMAL("Normal", 3),  // Fixed typo: "Noraml" → "Normal"
    OKAY("Okay", 4),
    GOOD("Good", 5),
    PERFECT("Perfect", 6);

    private final String stateName;  // Better name - avoid same as class
    private final int id;
    private static final Random RANDOM = new Random();
    private static final State[] VALUES = values();

    State(String stateName, int id) {
        this.stateName = stateName;
        this.id = id;
    }

    public String getStateName() {  // Better method name
        return this.stateName;
    }

    public int getId() {  // Consistent naming
        return this.id;
    }

    public static State getRandomState() {  // Better method name
        return VALUES[RANDOM.nextInt(VALUES.length)];
    }
}