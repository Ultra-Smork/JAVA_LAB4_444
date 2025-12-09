package ScriptingJav;

import ScriptingJav.Objects.*;
import ScriptingJav.Alive.*;

// javac -encoding UTF-8 -d out My_SRC\Main.java My_SRC\Alive\*.java My_SRC\Objects\*.java
//java -cp out My_SRC/Main
public class Main {
    public static void main(String[] args){
        Plantation plantation = new Plantation();
        // Coffers coffers = new Coffers();
        // MonasteryOFsaintAug monastery = new MonasteryOFsaintAug();
        Captain captain = new Captain();
        Companion companion = new Companion();
        Confidant confidant = new Confidant();
        Custodian custodian = new Custodian();
        Indian indian = new Indian();
        MonkHousekeeper monkHousekeeper = new MonkHousekeeper();
        Narrator narrator = new Narrator();
        Official official = new Official();
        Oldman oldman = new Oldman();
        Poor poor = new Poor();
        
        // Вывод информации о плантации
        
        // Можно также вывести информацию о других объектах при необходимости
        // System.out.println(coffers.toString());
        // System.out.println(monastery.toString());

        
        narrator.order(narrator, confidant, "следить за плантацией");
        plantation.getIncome();
        confidant.lookafter(narrator, "за плантацией рассказчика");
        confidant.die();
        narrator.dissappear();
        official.requestReport(custodian, "Доходности плантации");
        custodian.report(custodian, official, " отчёт о Доходности плантации");
        official.enact(String.format("если %s (%s) не вернётся - конфисковать всю собственность и одну треть доходов с нее отчислять в казну, а две трети в монастырь св. Августина на бедных и на обращение индейцев в католичество.", narrator.name, narrator.job));
        official.lookafter(official, companion, " Чтобы отчёт о доходах казны поступал ежемесячно");
        monkHousekeeper.lookafter(monkHousekeeper, companion, " Чтобы отчисления в казну с плантации были такими какие прописаны в указе");
        companion.report(companion, official, "Доходность плантации");
        indian.acceptReligion("Католичество");
        poor.getDonated();
        companion.moneyInvest(companion);
        plantation.getInvested();
        oldman.hug(oldman, narrator);
        narrator.ask(narrator, oldman, " О жизни, плантации, компаньоне рассказчика");
        oldman.tell(oldman, narrator, " *поговорили о жизни и о последних событиях* ");
        oldman.tell(oldman, narrator, " Что он может получить самые точные сведения о своей плантации и про изведенных на ней улучшениях у капитана ");
        narrator.ask(narrator, captain, " Как он может вернуть свою плантацию");
        narrator.report(narrator, official, " О том что он вернулся и ему положено вернуть плантацию");
        official.transferOwnership(narrator, official, "Плантация");

        // coffers.deposit(plantation.getWealth() / 3);
        // monastery.getInvested();
        
        // Демонстрация обработки unchecked исключения
        System.out.println("\n=== Демонстрация обработки unchecked исключения ===");
        try {
            // Попытка нанять отрицательное количество рабочих вызовет IllegalArgumentException
            plantation.hireWorkers(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Обработано unchecked исключение: " + e.getMessage());
            System.out.println("Попытка нанять невалидное количество рабочих предотвращена.");
        }
        
        // Попытка нанять нулевое количество рабочих
        try {
            plantation.hireWorkers(0);
        } catch (IllegalArgumentException e) {
            System.out.println("Обработано unchecked исключение: " + e.getMessage());
        }
        
        // Успешный вызов с валидным значением
        try {
            plantation.hireWorkers(10);
            System.out.println("Успешно нанято 10 рабочих.");
        } catch (IllegalArgumentException e) {
            System.out.println("Неожиданное исключение: " + e.getMessage());
        }
    }
}