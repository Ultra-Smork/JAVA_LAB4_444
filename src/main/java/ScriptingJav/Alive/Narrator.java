package ScriptingJav.Alive;

import java.util.Random;

import ScriptingJav.Alive.abstraction.AliveInterface;
import ScriptingJav.Alive.abstraction.Job;
import ScriptingJav.Alive.abstraction.MoneyOwner;
import ScriptingJav.Alive.abstraction.Person;
import ScriptingJav.Alive.abstraction.Vibe;
import ScriptingJav.Objects.abstraction.PlantationHandling;

public class Narrator extends Person implements AliveInterface, MoneyOwner, PlantationHandling{

    public Narrator(){
        this.job = Job.Narrator;
        genAge();
        genName();
        genVibe();
    }

    public static void die(){
        
    }

    // Not complete realization
    // @Override
    // protected void genInteraction() {
    //     vibeInteraction();
    // }

    public void dissappear(){
        System.out.println(this.name + " (Рассказчик) пропал безвести");
    }
    public void comeback(){
        System.out.println(this.name + " (Рассказчик) вернулся и во всём городе говорят об этом");
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
        Narrator narrator = (Narrator) obj;
        return age == narrator.age &&
               java.util.Objects.equals(name, narrator.name) &&
               java.util.Objects.equals(job, narrator.job) &&
               java.util.Objects.equals(vibe, narrator.vibe);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, age, job, vibe);
    }

    @Override
    public String toString() {
        return String.format("Narrator{name='%s', age=%d, job=%s, vibe=%s}", 
            name, age, job, vibe);
    }
}
