package ScriptingJav.Alive;

import java.util.Random;

import ScriptingJav.Alive.abstraction.AliveInterface;
import ScriptingJav.Alive.abstraction.Job;
import ScriptingJav.Alive.abstraction.Person;
import ScriptingJav.Alive.abstraction.Vibe;

public final class Poor extends Person implements AliveInterface{

    public Poor(){
        this.job = Job.Poor;
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

    public void getDonated(){
        System.out.println(this.job.getFormOfAddress() + this.name + " Получают пожертвование от монастыря");
    }

    protected void genVibe(){
        this.vibe = Vibe.getrandVibe();
    }

    private void beg(Person p){
        System.out.println();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Poor poor = (Poor) obj;
        return age == poor.age &&
               java.util.Objects.equals(name, poor.name) &&
               java.util.Objects.equals(job, poor.job) &&
               java.util.Objects.equals(vibe, poor.vibe);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, age, job, vibe);
    }

    @Override
    public String toString() {
        return String.format("Poor{name='%s', age=%d, job=%s, vibe=%s}", 
            name, age, job, vibe);
    }
}
