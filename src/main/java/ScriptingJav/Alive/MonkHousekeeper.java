package ScriptingJav.Alive;

import java.util.Random;

import ScriptingJav.Alive.abstraction.AliveInterface;
import ScriptingJav.Alive.abstraction.Job;
import ScriptingJav.Alive.abstraction.Person;
import ScriptingJav.Alive.abstraction.Vibe;

public final class MonkHousekeeper extends Person implements AliveInterface{


    public MonkHousekeeper(){
        this.job = Job.MonasticHousekeeper;
        genAge();
        genName();
        genVibe();
    }
    @Override
        protected void genAge() {
        // this.religion = newReligion.strip(); // Trim and assign
        int newAge = (int) (20 + Math.random() * 60);
        this.age = newAge;
    }
    @Override
        protected void genName() {
        Random random = new Random();
        int randomindex = random.nextInt(Names.length);
        this.name = Names[randomindex];
    }

    protected void genVibe(){
        this.vibe = Vibe.getrandVibe();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MonkHousekeeper monkHousekeeper = (MonkHousekeeper) obj;
        return age == monkHousekeeper.age &&
               java.util.Objects.equals(name, monkHousekeeper.name) &&
               java.util.Objects.equals(job, monkHousekeeper.job) &&
               java.util.Objects.equals(vibe, monkHousekeeper.vibe);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, age, job, vibe);
    }

    @Override
    public String toString() {
        return String.format("MonkHousekeeper{name='%s', age=%d, job=%s, vibe=%s}", 
            name, age, job, vibe);
    }
}
