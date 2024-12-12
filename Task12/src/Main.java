import java.util.ArrayList;
import java.util.List;

// Интерфейс для компонентов банковского аккаунта
interface BankAccountComponent {
    void add(BankAccountComponent component);
    void remove(BankAccountComponent component);
    BankAccountComponent getChild(int index);
    String getName();
    double getBalance();
    void print();
}

// Класс для банковского счета
class BankAccount implements BankAccountComponent {
    private String name;
    private double balance;

    public BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    @Override
    public void add(BankAccountComponent component) {
        throw new UnsupportedOperationException("Cannot add to a bank account");
    }

    @Override
    public void remove(BankAccountComponent component) {
        throw new UnsupportedOperationException("Cannot remove from a bank account");
    }

    @Override
    public BankAccountComponent getChild(int index) {
        throw new UnsupportedOperationException("Cannot get child from a bank account");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void print() {
        System.out.println("Account: " + name + ", Balance: " + balance);
    }
}

// Класс для композиции банковских счетов
class BankAccountComposite implements BankAccountComponent {
    private String name;
    private List<BankAccountComponent> children = new ArrayList<>();

    public BankAccountComposite(String name) {
        this.name = name;
    }

    @Override
    public void add(BankAccountComponent component) {
        children.add(component);
    }

    @Override
    public void remove(BankAccountComponent component) {
        children.remove(component);
    }

    @Override
    public BankAccountComponent getChild(int index) {
        return children.get(index);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getBalance() {
        double totalBalance = 0;
        for (BankAccountComponent component : children) {
            totalBalance += component.getBalance();
        }
        return totalBalance;
    }

    @Override
    public void print() {
        System.out.println("Composite: " + name);
        for (BankAccountComponent component : children) {
            component.print();
        }
    }
}

// Основной класс для демонстрации
public class Main {
    public static void main(String[] args) {
        BankAccountComponent account1 = new BankAccount("Account 1", 1000);
        BankAccountComponent account2 = new BankAccount("Account 2", 2000);
        BankAccountComponent account3 = new BankAccount("Account 3", 3000);

        BankAccountComposite composite1 = new BankAccountComposite("Composite 1");
        composite1.add(account1);
        composite1.add(account2);

        BankAccountComposite composite2 = new BankAccountComposite("Composite 2");
        composite2.add(account3);
        composite2.add(composite1);

        composite2.print();
        System.out.println("Total Balance: " + composite2.getBalance());
    }
}
