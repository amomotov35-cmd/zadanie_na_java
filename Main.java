import java.time.LocalDateTime;
import java.util.ArrayList;

// 1. Класс Product (товар)
class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s — %.1f руб.", name, price);
    }
}

// 2. Класс Cart (корзина) с логированием операций
class Cart {
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<LogEntry> log = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
        log.add(new LogEntry("Добавление товара",
                String.format("Добавлен товар: %s (%.1f руб.)", p.getName(), p.getPrice())));
    }

    public boolean removeProduct(String name) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equalsIgnoreCase(name)) {
                Product removed = products.remove(i);
                log.add(new LogEntry("Удаление товара",
                        String.format("Удален товар: %s (%.1f руб.)", removed.getName(), removed.getPrice())));
                return true;
            }
        }
        log.add(new LogEntry("Удаление товара",
                String.format("Не удалось найти товар: %s", name)));
        return false;
    }

    public double getTotal() {
        double total = 0;
        for (Product p : products) {
            total += p.getPrice();
        }
        return total;
    }

    public void printCart() {
        System.out.println("=== Корзина ===");
        if (products.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            for (int i = 0; i < products.size(); i++) {
                System.out.printf("%d. %s%n", i + 1, products.get(i));
            }
        }
        System.out.printf("Итого: %.1f руб.%n%n", getTotal());
    }

    public void printLog() {
        System.out.println("=== Журнал операций ===");
        for (LogEntry entry : log) {
            System.out.println(entry);
        }
        System.out.println();
    }
}

// Класс для логирования (из Library)
class LogEntry {
    private String operationType;
    private LocalDateTime timestamp;
    private String description;

    public LogEntry(String operationType, String description) {
        this.operationType = operationType;
        this.description = description;
        this.timestamp = LocalDateTime.now();
    }

    public String getOperationType() {
        return operationType;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s: %s",
                timestamp, operationType, description);
    }
}

// 3. Класс Main
public class Main {
    public static void main(String[] args) {
        // Создаем несколько товаров
        Product laptop = new Product("Ноутбук", 75000.0);
        Product mouse = new Product("Мышка", 1500.0);
        Product keyboard = new Product("Клавиатура", 3000.0);

        // Создаем корзину
        Cart cart = new Cart();

        // Добавляем товары в корзину
        cart.addProduct(laptop);
        cart.addProduct(mouse);
        cart.addProduct(keyboard);

        // Показываем корзину
        cart.printCart();

        // Удаляем товар
        System.out.println("Удаляем: Мышка");
        cart.removeProduct("Мышка");
        cart.printCart();

        // Показываем журнал операций
        cart.printLog();
    }
}