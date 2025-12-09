package ScriptingJav.Alive;

import java.util.Random;

import ScriptingJav.Alive.abstraction.AliveInterface;
import ScriptingJav.Alive.abstraction.Job;
import ScriptingJav.Alive.abstraction.MoneyOwner;
import ScriptingJav.Alive.abstraction.Person;
import ScriptingJav.Alive.abstraction.Vibe;

public final class Companion extends Person implements AliveInterface, MoneyOwner{

    // @Override
    // protected void genInteraction() {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'genInteraction'");
    // }

    public Companion(){
        this.job = Job.Companion;
        genAge();
        genName();
        genVibe();
    }
    @Override
        protected void genAge() {
        // this.religion = newReligion.strip(); // Trim and assign
        int newAge = (int) (10 + Math.random() * 60);
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
        Companion companion = (Companion) obj;
        return age == companion.age &&
               java.util.Objects.equals(name, companion.name) &&
               java.util.Objects.equals(job, companion.job) &&
               java.util.Objects.equals(vibe, companion.vibe);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, age, job, vibe);
    }

    @Override
    public String toString() {
        return String.format("Companion{name='%s', age=%d, job=%s, vibe=%s}", 
            name, age, job, vibe);
    }
}
