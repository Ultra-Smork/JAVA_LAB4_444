package ScriptingJav.Alive.abstraction;

public enum Job {
    Captain("Капитан", 1, "господин капитан"),
    Confidant("Доверенный", 2, "господин доверенный"),
    Companion("Компаньон", 3, "господин компаньон"),
    Official("Министр", 4, "ваше превосходительство"),
    Indian("Индеец", 5, "почтенный индеец"),
    MonasticHousekeeper("Монастырский эконом", 6, "господин эконом"),
    Narrator("Рассказчик", 7, "господин рассказчик"),
    Custodian("Опекун", 8, "господин опекун"),
    Oldman("Старик", 9, "почтенный старик"),
    Poor("Бедный", 10, "почтенный бедняк"),
    PLACEHOLDER("PLACEHOLDER", 0, "неизвестный");
   
    private final int ID;
    private final String JOB;
    private final String FORM_OF_ADDRESS;
    
    Job(String job_name, int id, String formOfAddress){
        this.ID = id;
        this.JOB = job_name;
        this.FORM_OF_ADDRESS = formOfAddress;
    }

    public String getJobName(){
        return this.JOB;
    }

    public int getId(){
        return this.ID;
    }
    
    public String getFormOfAddress(){
        return this.FORM_OF_ADDRESS;
    }
}