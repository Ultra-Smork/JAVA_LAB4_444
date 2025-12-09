package ScriptingJav.Alive.abstraction;

public abstract class Person {
    public String name;
    public int age;
    public Job job;
    public Vibe vibe;

    public void ask(Person p1, Person p2, String context){
        switch (vibe.getVIBE()) {
            case "Official" -> System.out.println(
                p1.job.getFormOfAddress() + " " + p1.name + " (" + p1.job.getJobName() + ") осведомляется у " + 
                p2.job.getFormOfAddress() + " " + p2.name + " (" + p2.job.getJobName() + ") касательно " + context
            );
            case "Practical" -> System.out.println(
                p1.name + " (" + p1.job.getJobName() + ") прямо спрашивает у " + p2.name + 
                " (" + p2.job.getJobName() + "): " + context
            );
            case "Dramatic" -> System.out.println(
                "С трепетом в голосе " + p1.name + " (" + p1.job.getJobName() + ") вопрошает к " + p2.name + 
                " (" + p2.job.getJobName() + ") о " + context
            );
            case "Comfy" -> System.out.println(
                p1.name + " (" + p1.job.getJobName() + ") по-дружески интересуется у " + p2.name + 
                " (" + p2.job.getJobName() + ") насчёт " + context
            );
        }
    };

    public void tell(Person p1, Person p2, String context){
        switch (vibe.getVIBE()) {
            case "Official" -> System.out.println(
                p1.job.getFormOfAddress() + " " + p1.name + " (" + p1.job.getJobName() + ") официально сообщает " + 
                p2.job.getFormOfAddress() + " " + p2.name + " (" + p2.job.getJobName() + "): " + context
            );
            case "Practical" -> System.out.println(
                p1.name + " (" + p1.job.getJobName() + ") чётко излагает " + p2.name + 
                " (" + p2.job.getJobName() + "): " + context
            );
            case "Dramatic" -> System.out.println(
                "С придыханием " + p1.name + " (" + p1.job.getJobName() + ") повествует " + p2.name + 
                " (" + p2.job.getJobName() + ") о том, как " + context
            );
            case "Comfy" -> System.out.println(
                p1.name + " (" + p1.job.getJobName() + ") по-соседски рассказывает " + p2.name + 
                " (" + p2.job.getJobName() + "): " + context
            );
        }
    };

    public void give(Person p1, Person p2, String context){
        switch (vibe.getVIBE()) {
            case "Official" -> System.out.println(
                p1.job.getFormOfAddress() + " " + p1.name + " (" + p1.job.getJobName() + ") препровождает " + 
                context + " в распоряжение " + p2.job.getFormOfAddress() + " " + p2.name + " (" + p2.job.getJobName() + ")"
            );
            case "Practical" -> System.out.println(
                p1.name + " (" + p1.job.getJobName() + ") передаёт " + context + " " + p2.name + 
                " (" + p2.job.getJobName() + ") без лишних слов"
            );
            case "Dramatic" -> System.out.println(
                "С торжественным видом " + p1.name + " (" + p1.job.getJobName() + ") вручает " + context + 
                " " + p2.name + " (" + p2.job.getJobName() + ")"
            );
            case "Comfy" -> System.out.println(
                p1.name + " (" + p1.job.getJobName() + ") приносит " + context + " " + p2.name + 
                " (" + p2.job.getJobName() + ") по-дружески"
            );
        }
    };

    public void lookafter(Person p1, Person p2, String context){
        switch (vibe.getVIBE()) {
            case "Official" -> System.out.println(
                p1.job.getFormOfAddress() + " " + p1.name + " (" + p1.job.getJobName() + ") принимает на себя надзор за " + 
                context + " в отношении " + p2.job.getFormOfAddress() + " " + p2.name + " (" + p2.job.getJobName() + ")"
            );
            case "Practical" -> System.out.println(
                p1.name + " (" + p1.job.getJobName() + ") берёт под присмотр " + context + " для " + p2.name + 
                " (" + p2.job.getJobName() + ")"
            );
            case "Dramatic" -> System.out.println(
                "С чувством ответственности " + p1.name + " (" + p1.job.getJobName() + ") опекает " + 
                context + " ради " + p2.name + " (" + p2.job.getJobName() + ")"
            );
            case "Comfy" -> System.out.println(
                p1.name + " (" + p1.job.getJobName() + ") присматривает за " + context + " для " + p2.name + 
                " (" + p2.job.getJobName() + ") по-добрососедски"
            );
        }
    };

    public void lookafter(Person p2, String context){
        switch (vibe.getVIBE()) {
            case "Official" -> System.out.println(
                this.job.getFormOfAddress() + " " + this.name + " (" + this.job.getJobName() + ") принимает на себя надзор за " + 
                context + " в отношении " + p2.job.getFormOfAddress() + " " + p2.name + " (" + p2.job.getJobName() + ")"
            );
            case "Practical" -> System.out.println(
                this.name + " (" + this.job.getJobName() + ") берёт под присмотр " + context + " для " + p2.name + 
                " (" + p2.job.getJobName() + ")"
            );
            case "Dramatic" -> System.out.println(
                "С чувством ответственности " + this.name + " (" + this.job.getJobName() + ") опекает " + 
                context + " ради " + p2.name + " (" + p2.job.getJobName() + ")"
            );
            case "Comfy" -> System.out.println(
                this.name + " (" + this.job.getJobName() + ") присматривает за " + context + " для " + p2.name + 
                " (" + p2.job.getJobName() + ") по-добрососедски"
            );
        }
    }

    public void lookafter(String context){
        switch (vibe.getVIBE()) {
            case "Official" -> System.out.println(
                this.job.getFormOfAddress() + " " + this.name + " (" + this.job.getJobName() + ") осуществляет надзор за " + context
            );
            case "Practical" -> System.out.println(
                this.name + " (" + this.job.getJobName() + ") присматривает за " + context
            );
            case "Dramatic" -> System.out.println(
                "С особым вниманием " + this.name + " (" + this.job.getJobName() + ") заботится о " + context
            );
            case "Comfy" -> System.out.println(
                this.name + " (" + this.job.getJobName() + ") заботливо ухаживает за " + context
            );
        }
    }

    public void hug(Person p1, Person p2){
        switch (vibe.getVIBE()) {
            case "Official" -> System.out.println(
                p1.job.getFormOfAddress() + " " + p1.name + " (" + p1.job.getJobName() + ") обменивается церемонным рукопожатием с " + 
                p2.job.getFormOfAddress() + " " + p2.name + " (" + p2.job.getJobName() + ")"
            );
            case "Practical" -> System.out.println(
                p1.name + " (" + p1.job.getJobName() + ") обменивается крепким рукопожатием с " + p2.name + 
                " (" + p2.job.getJobName() + ")"
            );
            case "Dramatic" -> System.out.println(
                p1.name + " (" + p1.job.getJobName() + ") порывисто обнимает " + p2.name + 
                " (" + p2.job.getJobName() + ") с избытком чувств"
            );
            case "Comfy" -> System.out.println(
                p1.name + " (" + p1.job.getJobName() + ") тепло обнимает " + p2.name + 
                " (" + p2.job.getJobName() + ") по-приятельски"
            );
        }
    };

    public void report(Person p1, Person p2, String context){
        switch (vibe.getVIBE()) {
            case "Official" -> System.out.println(
                p1.job.getFormOfAddress() + " " + p1.name + " (" + p1.job.getJobName() + ") представляет официальный отчёт по " + 
                context + " для " + p2.job.getFormOfAddress() + " " + p2.name + " (" + p2.job.getJobName() + ")"
            );
            case "Practical" -> System.out.println(
                p1.name + " (" + p1.job.getJobName() + ") докладывает по делу: " + context + " для " + p2.name + 
                " (" + p2.job.getJobName() + ")"
            );
            case "Dramatic" -> System.out.println(
                "С волнением в голосе " + p1.name + " (" + p1.job.getJobName() + ") заявляет " + p2.name + 
                " (" + p2.job.getJobName() + ") о " + context
            );
            case "Comfy" -> System.out.println(
                p1.name + " (" + p1.job.getJobName() + ") по-свойски объясняет " + p2.name + 
                " (" + p2.job.getJobName() + ") про " + context
            );
        }
    };

    public void confiscate(Person p1, Person p2, String property){
        switch (vibe.getVIBE()) {
            case "Official" -> System.out.println(
                p1.job.getFormOfAddress() + " " + p1.name + " (" + p1.job.getJobName() + ") производит конфискацию " + 
                property + " у " + p2.job.getFormOfAddress() + " " + p2.name + " (" + p2.job.getJobName() + 
                ") в соответствии с установленными правилами"
            );
            case "Practical" -> System.out.println(
                p1.name + " (" + p1.job.getJobName() + ") изымает " + property + " у " + p2.name + 
                " (" + p2.job.getJobName() + ") без лишних формальностей"
            );
            case "Dramatic" -> System.out.println(
                "С суровым видом " + p1.name + " (" + p1.job.getJobName() + ") объявляет о конфискации " + 
                property + " у " + p2.name + " (" + p2.job.getJobName() + "), подчеркивая неотвратимость правосудия"
            );
            case "Comfy" -> System.out.println(
                p1.name + " (" + p1.job.getJobName() + ") с сожалением забирает " + property + 
                " у " + p2.name + " (" + p2.job.getJobName() + "), стараясь смягчить ситуацию"
            );
        }
    }

    public void order(Person p1, Person p2, String command){
        switch (vibe.getVIBE()) {
            case "Official" -> System.out.println(
                p1.job.getFormOfAddress() + " " + p1.name + " (" + p1.job.getJobName() + ") отдает официальное распоряжение " + 
                p2.job.getFormOfAddress() + " " + p2.name + " (" + p2.job.getJobName() + "): " + command
            );
            case "Practical" -> System.out.println(
                p1.name + " (" + p1.job.getJobName() + ") четко приказывает " + p2.name + 
                " (" + p2.job.getJobName() + "): " + command
            );
            case "Dramatic" -> System.out.println(
                "С властным жестом " + p1.name + " (" + p1.job.getJobName() + ") восклицает, обращаясь к " + 
                p2.name + " (" + p2.job.getJobName() + "): \"" + command + "!\""
            );
            case "Comfy" -> System.out.println(
                p1.name + " (" + p1.job.getJobName() + ") мягко просит " + p2.name + 
                " (" + p2.job.getJobName() + "): " + command
            );
        }
    }
    public void ask(Person p1, Person p2, String context, Vibe vibe){
        switch (vibe.getVIBE()) {
            case "Official" -> System.out.println(
                p1.job.getFormOfAddress() + " " + p1.name + " (" + p1.job.getJobName() + ") осведомляется у " + 
                p2.job.getFormOfAddress() + " " + p2.name + " (" + p2.job.getJobName() + ") касательно " + context
            );
            case "Practical" -> System.out.println(
                p1.name + " (" + p1.job.getJobName() + ") прямо спрашивает у " + p2.name + 
                " (" + p2.job.getJobName() + "): " + context
            );
            case "Dramatic" -> System.out.println(
                "С трепетом в голосе " + p1.name + " (" + p1.job.getJobName() + ") вопрошает к " + p2.name + 
                " (" + p2.job.getJobName() + ") о " + context
            );
            case "Comfy" -> System.out.println(
                p1.name + " (" + p1.job.getJobName() + ") по-дружески интересуется у " + p2.name + 
                " (" + p2.job.getJobName() + ") насчёт " + context
            );
        }
    };

    public void tell(Person p1, Person p2, String context, Vibe vibe){
        switch (vibe.getVIBE()) {
            case "Official" -> System.out.println(
                p1.job.getFormOfAddress() + " " + p1.name + " (" + p1.job.getJobName() + ") официально сообщает " + 
                p2.job.getFormOfAddress() + " " + p2.name + " (" + p2.job.getJobName() + "): " + context
            );
            case "Practical" -> System.out.println(
                p1.name + " (" + p1.job.getJobName() + ") чётко излагает " + p2.name + 
                " (" + p2.job.getJobName() + "): " + context
            );
            case "Dramatic" -> System.out.println(
                "С придыханием " + p1.name + " (" + p1.job.getJobName() + ") повествует " + p2.name + 
                " (" + p2.job.getJobName() + ") о том, как " + context
            );
            case "Comfy" -> System.out.println(
                p1.name + " (" + p1.job.getJobName() + ") по-соседски рассказывает " + p2.name + 
                " (" + p2.job.getJobName() + "): " + context
            );
        }
    };

    public void give(Person p1, Person p2, String context, Vibe vibe){
        switch (vibe.getVIBE()) {
            case "Official" -> System.out.println(
                p1.job.getFormOfAddress() + " " + p1.name + " (" + p1.job.getJobName() + ") препровождает " + 
                context + " в распоряжение " + p2.job.getFormOfAddress() + " " + p2.name + " (" + p2.job.getJobName() + ")"
            );
            case "Practical" -> System.out.println(
                p1.name + " (" + p1.job.getJobName() + ") передаёт " + context + " " + p2.name + 
                " (" + p2.job.getJobName() + ") без лишних слов"
            );
            case "Dramatic" -> System.out.println(
                "С торжественным видом " + p1.name + " (" + p1.job.getJobName() + ") вручает " + context + 
                " " + p2.name + " (" + p2.job.getJobName() + ")"
            );
            case "Comfy" -> System.out.println(
                p1.name + " (" + p1.job.getJobName() + ") приносит " + context + " " + p2.name + 
                " (" + p2.job.getJobName() + ") по-дружески"
            );
        }
    };

    public void lookafter(Person p1, Person p2, String context, Vibe vibe){
        switch (vibe.getVIBE()) {
            case "Official" -> System.out.println(
                p1.job.getFormOfAddress() + " " + p1.name + " (" + p1.job.getJobName() + ") принимает на себя надзор за " + 
                context + " в отношении " + p2.job.getFormOfAddress() + " " + p2.name + " (" + p2.job.getJobName() + ")"
            );
            case "Practical" -> System.out.println(
                p1.name + " (" + p1.job.getJobName() + ") берёт под присмотр " + context + " для " + p2.name + 
                " (" + p2.job.getJobName() + ")"
            );
            case "Dramatic" -> System.out.println(
                "С чувством ответственности " + p1.name + " (" + p1.job.getJobName() + ") опекает " + 
                context + " ради " + p2.name + " (" + p2.job.getJobName() + ")"
            );
            case "Comfy" -> System.out.println(
                p1.name + " (" + p1.job.getJobName() + ") присматривает за " + context + " для " + p2.name + 
                " (" + p2.job.getJobName() + ") по-добрососедски"
            );
        }
    };

    public void lookafter(Person p2, String context, Vibe vibe){
        switch (vibe.getVIBE()) {
            case "Official" -> System.out.println(
                this.job.getFormOfAddress() + " " + this.name + " (" + this.job.getJobName() + ") принимает на себя надзор за " + 
                context + " в отношении " + p2.job.getFormOfAddress() + " " + p2.name + " (" + p2.job.getJobName() + ")"
            );
            case "Practical" -> System.out.println(
                this.name + " (" + this.job.getJobName() + ") берёт под присмотр " + context + " для " + p2.name + 
                " (" + p2.job.getJobName() + ")"
            );
            case "Dramatic" -> System.out.println(
                "С чувством ответственности " + this.name + " (" + this.job.getJobName() + ") опекает " + 
                context + " ради " + p2.name + " (" + p2.job.getJobName() + ")"
            );
            case "Comfy" -> System.out.println(
                this.name + " (" + this.job.getJobName() + ") присматривает за " + context + " для " + p2.name + 
                " (" + p2.job.getJobName() + ") по-добрососедски"
            );
        }
    }

    public void lookafter(String context, Vibe vibe){
        switch (vibe.getVIBE()) {
            case "Official" -> System.out.println(
                this.job.getFormOfAddress() + " " + this.name + " (" + this.job.getJobName() + ") осуществляет надзор за " + context
            );
            case "Practical" -> System.out.println(
                this.name + " (" + this.job.getJobName() + ") присматривает за " + context
            );
            case "Dramatic" -> System.out.println(
                "С особым вниманием " + this.name + " (" + this.job.getJobName() + ") заботится о " + context
            );
            case "Comfy" -> System.out.println(
                this.name + " (" + this.job.getJobName() + ") заботливо ухаживает за " + context
            );
        }
    }

    public void hug(Person p1, Person p2, Vibe vibe){
        switch (vibe.getVIBE()) {
            case "Official" -> System.out.println(
                p1.job.getFormOfAddress() + " " + p1.name + " (" + p1.job.getJobName() + ") обменивается церемонным рукопожатием с " + 
                p2.job.getFormOfAddress() + " " + p2.name + " (" + p2.job.getJobName() + ")"
            );
            case "Practical" -> System.out.println(
                p1.name + " (" + p1.job.getJobName() + ") обменивается крепким рукопожатием с " + p2.name + 
                " (" + p2.job.getJobName() + ")"
            );
            case "Dramatic" -> System.out.println(
                p1.name + " (" + p1.job.getJobName() + ") порывисто обнимает " + p2.name + 
                " (" + p2.job.getJobName() + ") с избытком чувств"
            );
            case "Comfy" -> System.out.println(
                p1.name + " (" + p1.job.getJobName() + ") тепло обнимает " + p2.name + 
                " (" + p2.job.getJobName() + ") по-приятельски"
            );
        }
    };

    public void report(Person p1, Person p2, String context, Vibe vibe){
        switch (vibe.getVIBE()) {
            case "Official" -> System.out.println(
                p1.job.getFormOfAddress() + " " + p1.name + " (" + p1.job.getJobName() + ") представляет официальный отчёт по " + 
                context + " для " + p2.job.getFormOfAddress() + " " + p2.name + " (" + p2.job.getJobName() + ")"
            );
            case "Practical" -> System.out.println(
                p1.name + " (" + p1.job.getJobName() + ") докладывает по делу: " + context + " для " + p2.name + 
                " (" + p2.job.getJobName() + ")"
            );
            case "Dramatic" -> System.out.println(
                "С волнением в голосе " + p1.name + " (" + p1.job.getJobName() + ") заявляет " + p2.name + 
                " (" + p2.job.getJobName() + ") о " + context
            );
            case "Comfy" -> System.out.println(
                p1.name + " (" + p1.job.getJobName() + ") по-свойски объясняет " + p2.name + 
                " (" + p2.job.getJobName() + ") про " + context
            );
        }
    };

    public void confiscate(Person p1, Person p2, String property, Vibe vibe){
        switch (vibe.getVIBE()) {
            case "Official" -> System.out.println(
                p1.job.getFormOfAddress() + " " + p1.name + " (" + p1.job.getJobName() + ") производит конфискацию " + 
                property + " у " + p2.job.getFormOfAddress() + " " + p2.name + " (" + p2.job.getJobName() + 
                ") в соответствии с установленными правилами"
            );
            case "Practical" -> System.out.println(
                p1.name + " (" + p1.job.getJobName() + ") изымает " + property + " у " + p2.name + 
                " (" + p2.job.getJobName() + ") без лишних формальностей"
            );
            case "Dramatic" -> System.out.println(
                "С суровым видом " + p1.name + " (" + p1.job.getJobName() + ") объявляет о конфискации " + 
                property + " у " + p2.name + " (" + p2.job.getJobName() + "), подчеркивая неотвратимость правосудия"
            );
            case "Comfy" -> System.out.println(
                p1.name + " (" + p1.job.getJobName() + ") с сожалением забирает " + property + 
                " у " + p2.name + " (" + p2.job.getJobName() + "), стараясь смягчить ситуацию"
            );
        }
    }

    public void order(Person p1, Person p2, String command, Vibe vibe){
        switch (vibe.getVIBE()) {
            case "Official" -> System.out.println(
                p1.job.getFormOfAddress() + " " + p1.name + " (" + p1.job.getJobName() + ") отдает официальное распоряжение " + 
                p2.job.getFormOfAddress() + " " + p2.name + " (" + p2.job.getJobName() + "): " + command
            );
            case "Practical" -> System.out.println(
                p1.name + " (" + p1.job.getJobName() + ") четко приказывает " + p2.name + 
                " (" + p2.job.getJobName() + "): " + command
            );
            case "Dramatic" -> System.out.println(
                "С властным жестом " + p1.name + " (" + p1.job.getJobName() + ") восклицает, обращаясь к " + 
                p2.name + " (" + p2.job.getJobName() + "): \"" + command + "!\""
            );
            case "Comfy" -> System.out.println(
                p1.name + " (" + p1.job.getJobName() + ") мягко просит " + p2.name + 
                " (" + p2.job.getJobName() + "): " + command
            );
        }
    }
    
    public void transferOwnership(Person newOwner, Person previousOwner, String asset) {
    switch (vibe.getVIBE()) {
        case "Official" -> System.out.println(
            "На основании решения от " + previousOwner.job.getFormOfAddress() + " " + "Чиновник" +previousOwner.name + 
            " право собственности на " + asset + " переходит к " + 
            newOwner.job.getFormOfAddress() + " " + newOwner.name + " с момента подписания"
        );
        case "Practical" -> System.out.println(
            "Чиновник" +previousOwner.name + " передаёт документы на " + asset + " " + newOwner.job.getFormOfAddress() +
            newOwner.name + ": \" Теперь это пренадлежит тебе \""
        );
        case "Dramatic" -> System.out.println(
            "Исторический момент! " + "Чиновник" +previousOwner.name + " со слезами на глазах передаёт " + 
            "символический ключ от " + asset + " " + newOwner.job.getFormOfAddress() +newOwner.name
        );
        case "Comfy" -> System.out.println(
            "Чиновник" + previousOwner.name + " кивает: \"" + newOwner.job.getFormOfAddress() + newOwner.name + 
            ", я уверен, " + asset + " в хороших руках. Делай что считаешь нужным\""
        );
    }
}


    protected abstract void genAge();
    protected abstract void genName();
}