package ScriptingJav.Alive;

import java.util.Random;

import ScriptingJav.Alive.abstraction.AliveInterface;
import ScriptingJav.Alive.abstraction.Job;
import ScriptingJav.Alive.abstraction.MoneyOwner;
import ScriptingJav.Alive.abstraction.Person;
import ScriptingJav.Alive.abstraction.Vibe;

public class Official extends Person implements AliveInterface, MoneyOwner {

    public Official() {
        this.job = Job.Official;
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

    public void enact(String context){
        System.out.println(this.name + " " + this.job.getFormOfAddress() + " " + this.job + " Постанавляет: " + context);
    }

    public void requestReport(Person p, String context){
        System.out.println(this.name + " " + this.job.getFormOfAddress() + " " + this.job + " Требует отчёт от " + p.name + 
        "(" + p.job + ") об: " + context);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Official official = (Official) obj;
        return age == official.age &&
               java.util.Objects.equals(name, official.name) &&
               java.util.Objects.equals(job, official.job) &&
               java.util.Objects.equals(vibe, official.vibe);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, age, job, vibe);
    }

    @Override
    public String toString() {
        return String.format("Official{name='%s', age=%d, job=%s, vibe=%s}", 
            name, age, job, vibe);
    }
}
