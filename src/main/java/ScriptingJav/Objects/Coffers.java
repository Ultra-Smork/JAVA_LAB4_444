package ScriptingJav.Objects;

import ScriptingJav.Objects.abstraction.PropertyInterface;
import ScriptingJav.Objects.abstraction.Size;
import ScriptingJav.Objects.abstraction.State;

// Data record for Coffers

public class Coffers implements PropertyInterface {
    private CoffersData data;
    
    public Coffers() {
        this.data = CoffersData.createRandom();
    }
    
    public Coffers(CoffersData data) {
        this.data = data;
    }

    @Override
    public void getInvested() {
        double investment = 1000.0 + (Math.random() * 2000);
        this.data = new CoffersData(
            data.name(), data.size(), data.state(),
            data.goldAmount() + investment, data.securityLevel(), data.isLocked()
        );
        System.out.printf("%s получил %.2f золотых инвестиций. Всего: %.2f%n", 
            data.name(), investment, data.goldAmount());
    }

    @Override
    public void getTaxed() {
        // Казну не облагают налогами - она сама собирает налоги!
        System.out.printf("%s собирает налоги, а не платит их!%n", data.name());
    }

    @Override
    public void getIncome() {
        // Доход казны от налогов, торговли и т.д.
        double taxIncome = 800.0 + (Math.random() * 1200);
        double tradeIncome = 300.0 + (Math.random() * 700);
        double totalIncome = taxIncome + tradeIncome;
        
        this.data = new CoffersData(
            data.name(), data.size(), data.state(),
            data.goldAmount() + totalIncome, data.securityLevel(), data.isLocked()
        );
        
        System.out.printf("%s сгенерировал доход:%n", data.name());
        System.out.printf("- Налоговые поступления: %.2f%n", taxIncome);
        System.out.printf("- Торговые поступления: %.2f%n", tradeIncome);
        System.out.printf("ОБЩИЙ ДОХОД: %.2f | Новый итог: %.2f%n", 
            totalIncome, data.goldAmount());
    }

    public void randName() {
        String[] newNames = {
            "Национальная Казна", 
            "Королевское Хранилище",
            "Имперский Резерв",
            "Государственная Казнь"
        };
        String newName = newNames[new java.util.Random().nextInt(newNames.length)];
        this.data = new CoffersData(
            newName, data.size(), data.state(),
            data.goldAmount(), data.securityLevel(), data.isLocked()
        );
        System.out.printf("Переименовано в: %s%n", newName);
    }

    public void randSize() {
        // Казнь имеет фиксированный размер, но мы можем создать вариации
        Size newSize = Size.getRandomSize();
        this.data = new CoffersData(
            data.name(), newSize, data.state(),
            data.goldAmount(), data.securityLevel(), data.isLocked()
        );
        System.out.printf("Размер хранилища изменен на: %s%n", newSize);
    }

    public void randState() {
        // Казнь всегда в идеальном состоянии, но мы можем изменить безопасность
        String[] securityLevels = {"Низкий", "Средний", "Высокий", "Максимальный", "Укрепленный"};
        String newSecurity = securityLevels[new java.util.Random().nextInt(securityLevels.length)];
        this.data = new CoffersData(
            data.name(), data.size(), data.state(),
            data.goldAmount(), newSecurity, data.isLocked()
        );
        System.out.printf("Уровень безопасности изменен на: %s%n", newSecurity);
    }

    public void withdraw(double amount) {
        if (data.isLocked()) {
            System.out.printf("%s заперта! Нельзя снять средства.%n", data.name());
            return;
        }
        if (amount > data.goldAmount()) {
            System.out.printf("Недостаточно средств! Доступно: %.2f%n", data.goldAmount());
            return;
        }
        this.data = new CoffersData(
            data.name(), data.size(), data.state(),
            data.goldAmount() - amount, data.securityLevel(), data.isLocked()
        );
        System.out.printf("Снято %.2f из %s. Остаток: %.2f%n", 
            amount, data.name(), data.goldAmount());
    }
    
    public void deposit(double amount) {
        this.data = new CoffersData(
            data.name(), data.size(), data.state(),
            data.goldAmount() + amount, data.securityLevel(), data.isLocked()
        );
        System.out.printf("Внесено %.2f в %s. Новый итог: %.2f%n", 
            amount, data.name(), data.goldAmount());
    }
    
    // Геттеры
    public CoffersData getData() { return data; }
    public String getName() { return data.name(); }
    public double getGoldAmount() { return data.goldAmount(); }
    public String getSecurityLevel() { return data.securityLevel(); }
    public boolean isLocked() { return data.isLocked(); }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Coffers coffers = (Coffers) obj;
        return java.util.Objects.equals(data, coffers.data);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(data);
    }

    @Override
    public String toString() {
        return String.format(
            "Казнь [%s] | Золото: %.2f | Безопасность: %s | %s",
            data.name(), data.goldAmount(), data.securityLevel(), 
            data.isLocked() ? "Заперта" : "Открыта"
        );
    }

    public record CoffersData(
        String name,
        Size size,
        State state,
        double goldAmount,
        String securityLevel,
        boolean isLocked
    ) {
        public static CoffersData createRandom() {
            String[] names = {
                "Королевская Сокровищница", 
                "Хранилище Королевства", 
                "Имперская Казнь",
                "Государственная Сокровищница"
            };
            String[] securityLevels = {"Низкий", "Средний", "Высокий", "Максимальный"};
            
            return new CoffersData(
                names[new java.util.Random().nextInt(names.length)],
                Size.getRandomSize(), // Фиксированный размер для казны
                State.getRandomState(),      // Казнь всегда в идеальном состоянии
                5000.0 + Math.random() * 10000,
                securityLevels[new java.util.Random().nextInt(securityLevels.length)],
                true
            );
        }
    }
}