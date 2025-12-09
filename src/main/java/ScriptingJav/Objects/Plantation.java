package ScriptingJav.Objects;

import ScriptingJav.Objects.abstraction.PropertyInterface;
import ScriptingJav.Objects.abstraction.Size;
import ScriptingJav.Objects.abstraction.State;

public class Plantation implements PropertyInterface {
    private PlantationData data;
    
    public Plantation() {
        this.data = PlantationData.createRandom();
    }
    
    public Plantation(PlantationData data) {
        this.data = data;
    }

    public void getInvested() {
        double investment = 800.0 + (Math.random() * 1200);
        this.data = new PlantationData(
            data.name(), data.size(), data.state(), data.cropType(),
            data.yieldPerAcre(), data.workersCount(), data.wealth() + investment
        );
        System.out.printf("%s получил %.2f инвестиций для выращивания %s. Общее состояние: %.2f%n", 
            data.name(), investment, data.cropType(), data.wealth());
    }

    public void getTaxed() {
        double taxRate = 0.08; // 8% налог для плантаций
        double tax = data.wealth() * taxRate;
        this.data = new PlantationData(
            data.name(), data.size(), data.state(), data.cropType(),
            data.yieldPerAcre(), data.workersCount(), data.wealth() - tax
        );
        System.out.printf("%s заплатил %.2f налогов (ставка %.1f%%). Остаток состояния: %.2f%n", 
            data.name(), tax, taxRate * 100, data.wealth());
    }

    public void getIncome() {
        double workerEfficiency = data.workersCount() * 15;
        double stateBonus = data.state().getId() * 50; // Лучшее состояние = больший доход
        
        double totalIncome =  workerEfficiency + stateBonus;
        
        this.data = new PlantationData(
            data.name(), data.size(), data.state(), data.cropType(),
            data.yieldPerAcre(), data.workersCount(), data.wealth() + totalIncome
        );
        
        System.out.printf("%s собрал урожай %s:%n", data.name(), data.cropType());
        System.out.printf("- Эффективность рабочих (%d рабочих): %.2f%n", data.workersCount(), workerEfficiency);
        System.out.printf("- Состояние фермы (%s): %.2f%n", data.state().getStateName(), stateBonus);
        System.out.printf("ОБЩИЙ ДОХОД: %.2f | Новое состояние: %.2f%n", 
            totalIncome, data.wealth());
    }

    public void randName() {
        String[] newNames = {
            "Плантация 'Восходящее Солнце'", 
            "Ферма 'Речной Изгиб'",
            "Наследие Урожая",
            "Щедрая Жатва"
        };
        String newName = newNames[new java.util.Random().nextInt(newNames.length)];
        this.data = new PlantationData(
            newName, data.size(), data.state(), data.cropType(),
            data.yieldPerAcre(), data.workersCount(), data.wealth()
        );
        System.out.printf("Переименовано в: %s%n", newName);
    }

    public void randSize() {
        Size newSize = Size.getRandomSize();
        this.data = new PlantationData(
            data.name(), newSize, data.state(), data.cropType(),
            data.yieldPerAcre(), data.workersCount(), data.wealth()
        );
        System.out.printf("Размер плантации изменен на: %s (Площадь: %d)%n", 
            newSize, newSize.getArea());
    }


    public void randState() {
        State newState = State.getRandomState();
        this.data = new PlantationData(
            data.name(), data.size(), newState, data.cropType(),
            data.yieldPerAcre(), data.workersCount(), data.wealth()
        );
        System.out.printf("Состояние плантации изменено на: %s (Качество: %d/6)%n", 
            newState.getStateName(), newState.getId());
    }
    
    // Специфичные для плантации методы
    public void changeCrop() {
        String[] newCrops = {"Ячмень", "Рис", "Сахарный тростник", "Кофе", "Чай", "Индиго"};
        String newCrop = newCrops[new java.util.Random().nextInt(newCrops.length)];
        this.data = new PlantationData(
            data.name(), data.size(), data.state(), newCrop,
            data.yieldPerAcre(), data.workersCount(), data.wealth()
        );
        System.out.printf("🌱 Изменена культура на: %s%n", newCrop);
    }
    
    public void hireWorkers(int count) {
        this.data = new PlantationData(
            data.name(), data.size(), data.state(), data.cropType(),
            data.yieldPerAcre(), data.workersCount() + count, data.wealth()
        );
        System.out.printf("Нанято %d рабочих. Всего рабочих: %d%n", count, data.workersCount());
    }
    
    public void improveYield() {
        double newYield = data.yieldPerAcre() * 1.1; // 10% улучшение
        this.data = new PlantationData(
            data.name(), data.size(), data.state(), data.cropType(),
            newYield, data.workersCount(), data.wealth()
        );
        System.out.printf("Урожайность улучшена до %.1f с акра%n", newYield);
    }
    
    // Геттеры
    public PlantationData getData() { return data; }
    public String getName() { return data.name(); }
    public String getCropType() { return data.cropType(); }
    public double getWealth() { return data.wealth(); }
    public int getWorkersCount() { return data.workersCount(); }
    public double getYieldPerAcre() { return data.yieldPerAcre(); }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Plantation plantation = (Plantation) obj;
        return java.util.Objects.equals(data, plantation.data);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(data);
    }

    @Override
    public String toString() {
        return String.format(
            "🌾 Плантация [%s] | Культура: %s | Рабочие: %d | Урожайность: %.1f/акр | Состояние: %.2f | Статус: %s",
            data.name(), data.cropType(), data.workersCount(), data.yieldPerAcre(), 
            data.wealth(), data.state().getStateName()
        );
    }
    
    public record PlantationData(
        String name,
        Size size,
        State state,
        String cropType,
        double yieldPerAcre,
        int workersCount,
        double wealth
    ) {
        public static PlantationData createRandom() {
            String[] names = {
                "Плантация 'Дубовая Долина'", 
                "Ферма 'Зеленые Просторы'", 
                "Поля Урожая",
                "Поместье 'Золотые Посевы'"
            };
            String[] cropTypes = {"Пшеница", "Кукуруза", "Хлопок", "Табак", "Виноград", "Оливки"};
            
            return new PlantationData(
                names[new java.util.Random().nextInt(names.length)],
                Size.getRandomSize(),
                State.getRandomState(),
                cropTypes[new java.util.Random().nextInt(cropTypes.length)],
                50.0 + Math.random() * 150,
                10 + (int)(Math.random() * 50),
                2000.0 + Math.random() * 3000
            );
        }
    }
}