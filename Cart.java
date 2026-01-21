import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private ArrayList<Product> products;
    private ArrayList<LogEntry> log;

    public Cart() {
        products = new ArrayList<>();
        log = new ArrayList<>();
    }

    public void addProduct(Product p) {
        products.add(p);
        log.add(new LogEntry("ADD", LocalDateTime.now(),
                String.format("Добавлен товар: %s", p.getName())));
    }

    public void removeProduct(String name) {
        Product toRemove = null;
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(name)) {
                toRemove = p;
                break;
            }
        }

        if (toRemove != null) {
            products.remove(toRemove);
            log.add(new LogEntry("REMOVE", LocalDateTime.now(),
                    String.format("Удален товар: %s", name)));
        } else {
            log.add(new LogEntry("REMOVE_FAILED", LocalDateTime.now(),
                    String.format("Товар не найден: %s", name)));
        }
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
            System.out.printf("Итого: %.1f руб.%n", getTotal());
        }
        System.out.println();
    }

    public void printLog() {
        System.out.println("=== Журнал операций ===");
        for (LogEntry entry : log) {
            System.out.println(entry);
        }
        System.out.println();
    }

    // Вложенный класс LogEntry
    public static class LogEntry {
        private String operationType;
        private LocalDateTime timestamp;
        private String description;

        public LogEntry(String operationType, LocalDateTime timestamp, String description) {
            this.operationType = operationType;
            this.timestamp = timestamp;
            this.description = description;
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
            return String.format("Операция '%s' выполнена в %s: %s",
                    operationType, timestamp, description);
        }
    }
}