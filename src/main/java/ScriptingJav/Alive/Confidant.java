package ScriptingJav.Alive;

import java.util.Random;

import ScriptingJav.Alive.abstraction.AliveInterface;
import ScriptingJav.Alive.abstraction.Job;
import ScriptingJav.Alive.abstraction.Person;
import ScriptingJav.Alive.abstraction.Vibe;

public final class Confidant extends Person implements AliveInterface{

    // @Override
    // protected void genInteraction() {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'genInteraction'");
    // }

    public Confidant(){
        this.job = Job.Confidant;
        genAge();
        genName();
        genVibe();
    }


    @Override
        protected void genAge() {
        // this.religion = newReligion.strip(); // Trim and assign
        int newAge = (int) (30 + Math.random() * 60);
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
    public void die() {
        System.out.println(this.name + " Доверенный умер в возрасте "+ this.age);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Confidant confidant = (Confidant) obj;
        return age == confidant.age &&
               java.util.Objects.equals(name, confidant.name) &&
               java.util.Objects.equals(job, confidant.job) &&
               java.util.Objects.equals(vibe, confidant.vibe);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, age, job, vibe);
    }

    @Override
    public String toString() {
        return String.format("Confidant{name='%s', age=%d, job=%s, vibe=%s}", 
            name, age, job, vibe);
    }
}
