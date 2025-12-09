package ScriptingJav.Alive.abstraction;

import ScriptingJav.Objects.abstraction.Size;

public interface MoneyOwner {
    public default void moneyGive(Person sender, Person reciever, Size amount){
        System.out.println(sender.job+ " " + sender.name + " Отдал деньги " + reciever.job+ " " + reciever.name + " в размере: " + amount.getName()  );
    }
    public default void moneyInvest(Person p1){
        System.out.println(p1.job+ " " + p1.name + " Вложил деньги в собственность" );
    }
}
