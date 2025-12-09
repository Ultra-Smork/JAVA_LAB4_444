package ScriptingJav.Objects;

import ScriptingJav.Objects.abstraction.PropertyInterface;
import ScriptingJav.Objects.abstraction.Size;
import ScriptingJav.Objects.abstraction.State;

// Data record

public class MonasteryOFsaintAug implements PropertyInterface {
    private MonasteryData data;
    
    public MonasteryOFsaintAug() {
        this.data = MonasteryData.createRandom();
    }
    
    public MonasteryOFsaintAug(MonasteryData data) {
        this.data = data;
    }

    @Override
    public void getInvested() {
        double investment = 500.0 + (Math.random() * 1000);
        this.data = new MonasteryData(
            data.name(), data.size(), data.state(),
            data.treasury() + investment, data.monksCount(), data.pietyLevel()
        );
        System.out.printf("%s получил %.2f в виде пожертвований. Казна: %.2f%n", 
            data.name(), investment, data.treasury());
    }

    @Override
    public void getTaxed() {
        // Монастыри часто имели налоговые льготы, но допустим, они платят уменьшенные налоги
        double taxRate = 0.03; // 3% налог для религиозных учреждений
        double tax = data.treasury() * taxRate;
        this.data = new MonasteryData(
            data.name(), data.size(), data.state(),
            data.treasury() - tax, data.monksCount(), data.pietyLevel()
        );
        System.out.printf("%s заплатил %.2f налогов (ставка %.1f%%). Остаток в казне: %.2f%n", 
            data.name(), tax, taxRate * 100, data.treasury());
    }

    @Override
    public void getIncome() {
        // Доход от пожертвований, служб, аренды земель и т.д.
        double baseIncome = data.monksCount() * 25; // Каждый монах генерирует доход
        double pietyBonus = data.pietyLevel() * 15; // Высшее благочестие = больше пожертвований
        double randomDonations = Math.random() * 200; // Случайные пожертвования
        
        double totalIncome = baseIncome + pietyBonus + randomDonations;
        
        this.data = new MonasteryData(
            data.name(), data.size(), data.state(),
            data.treasury() + totalIncome, data.monksCount(), data.pietyLevel()
        );
        
        System.out.printf("%s сгенерировал доход:%n", data.name());
        System.out.printf("- Монахи (%d): %.2f%n", data.monksCount(), baseIncome);
        System.out.printf("- Бонус благочестия (уровень %d): %.2f%n", data.pietyLevel(), pietyBonus);
        System.out.printf("- Случайные пожертвования: %.2f%n", randomDonations);
        System.out.printf("ОБЩИЙ ДОХОД: %.2f | Новая казна: %.2f%n", 
            totalIncome, data.treasury());
    }


    public void randName() {
        String[] newNames = {
            "Святилище Святого Августина", 
            "Монастырь Святого Ордена",
            "Аббатство Святых Обетов",
            "Клуатр Божественной Благодати"
        };
        String newName = newNames[new java.util.Random().nextInt(newNames.length)];
        this.data = new MonasteryData(
            newName, data.size(), data.state(),
            data.treasury(), data.monksCount(), data.pietyLevel()
        );
        System.out.printf("Переименовано в: %s%n", newName);
    }


    public void randSize() {
        Size newSize = Size.getRandomSize();
        this.data = new MonasteryData(
            data.name(), newSize, data.state(),
            data.treasury(), data.monksCount(), data.pietyLevel()
        );
        System.out.printf("Размер изменен на: %s (Площадь: %d)%n", 
            newSize, newSize.getName());
    }


    public void randState() {
        State newState = State.getRandomState();
        this.data = new MonasteryData(
            data.name(), data.size(), newState,
            data.treasury(), data.monksCount(), data.pietyLevel()
        );
        System.out.printf("Состояние изменено на: %s (Качество: %d/6)%n", 
            newState.getStateName(), newState.getId());
    }
    
    // Дополнительные служебные методы
    public void conductService() {
        System.out.printf("%s проводит религиозную службу...%n", data.name());
        getIncome(); // Службы приносят доход
        // Небольшой шанс получить нового монаха
        if (Math.random() > 0.7) {
            this.data = new MonasteryData(
                data.name(), data.size(), data.state(),
                data.treasury(), data.monksCount() + 1, data.pietyLevel()
            );
            System.out.println("Новый монах присоединился к монастырю!");
        }
    }
    
    public void improvePiety() {
        if (data.pietyLevel() < 10) {
            this.data = new MonasteryData(
                data.name(), data.size(), data.state(),
                data.treasury(), data.monksCount(), data.pietyLevel() + 1
            );
            System.out.printf("Благочестие %s повысилось до уровня %d%n", 
                data.name(), data.pietyLevel());
        } else {
            System.out.printf("%s достиг максимального уровня благочестия!%n", data.name());
        }
    }
    
    // Геттеры
    public MonasteryData getData() { return data; }
    public String getName() { return data.name(); }
    public double getTreasury() { return data.treasury(); }
    public int getMonksCount() { return data.monksCount(); }
    public int getPietyLevel() { return data.pietyLevel(); }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MonasteryOFsaintAug monastery = (MonasteryOFsaintAug) obj;
        return java.util.Objects.equals(data, monastery.data);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(data);
    }

    @Override
    public String toString() {
        return String.format(
            "МонастырьСвАвгустина [%s] | Монахи: %d | Благочестие: %d | Казна: %.2f | Состояние: %s",
            data.name(), data.monksCount(), data.pietyLevel(), data.treasury(), 
            data.state().getStateName()
        );
    }


public record MonasteryData(
    String name,
    Size size,
    State state,
    double treasury,
    int monksCount,
    int pietyLevel
) {
    public static MonasteryData createRandom() {
        String[] names = {
            "Монастырь Святого Августина", 
            "Клуатр Святого Августина", 
            "Августинское Аббатство",
            "Святилище Святого Августина"
        };
        return new MonasteryData(
            names[new java.util.Random().nextInt(names.length)],
            Size.getRandomSize(),
            State.getRandomState(),
            1000.0 + Math.random() * 2000,
            5 + (int)(Math.random() * 20),
            (int)(Math.random() * 10) + 1
        );
    }
}
}