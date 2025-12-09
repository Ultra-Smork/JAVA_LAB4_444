package ScriptingJav.Alive;

import java.util.Random;
import ScriptingJav.Alive.abstraction.AliveInterface;
import ScriptingJav.Alive.abstraction.Job;
import ScriptingJav.Alive.abstraction.Person;
import ScriptingJav.Alive.abstraction.Vibe;

public final class Indian extends Person implements AliveInterface{
    private String name = defaultname;
    private boolean alive = defaultalive;
    private Job job;
    private int age = defaultage;
    private String religion = "None";

    public Indian(){
        this.job = Job.Indian;
        genName();
        genAge();
        genVibe();
    }

    public void acceptReligion(String religion){
        System.out.println(this.job.getFormOfAddress() + " " + this.job + " " + this.name + " Принимает " + religion);
    }


    private void die(){
        this.alive = false;
        System.out.println(this.job + " " + this.age + " лет" + " по имени " + this.name + " Умер");
    }

    // @Override
    // public void genInteraction() {
    //     int s = Fast_rand.generate();
    //     switch (s) {
    //         case 1, 2, 3 -> die();
    //         case 4, 5, 6 -> genReligion();
    //         default -> {
    //             genReligion();
    //             die();
    //         }
    //     }
    // }
    
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


    public Job getJob(){
        return this.job;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Indian indian = (Indian) obj;
        return age == indian.age &&
               java.util.Objects.equals(name, indian.name) &&
               java.util.Objects.equals(job, indian.job) &&
               java.util.Objects.equals(vibe, indian.vibe);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, age, job, vibe);
    }

    @Override
    public String toString() {
        return String.format("Indian{name='%s', age=%d, job=%s, vibe=%s}", 
            name, age, job, vibe);
    }
}
