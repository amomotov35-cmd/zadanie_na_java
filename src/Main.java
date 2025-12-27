/**
 * Главный класс приложения для демонстрации работы корзины
 */
public class Main {
    public static void main(String[] args) {
        // Создание товаров
        Product laptop = new Product("Ноутбук", 75000.0);
        Product mouse = new Product("Мышка", 1500.0);
        Product keyboard = new Product("Клавиатура", 3000.0);
        Product headphones = new Product("Наушники", 5000.0);

        // Создание корзины
        Cart cart = new Cart();

        // Добавление товаров в корзину
        System.out.println("Добавляем товары в корзину...\n");
        cart.addProduct(laptop);
        cart.addProduct(mouse);
        cart.addProduct(keyboard);
        cart.addProduct(headphones);

        // Вывод содержимого корзины
        cart.printCart();

        // Удаление товара из корзины
        System.out.println("Удаляем: Мышка\n");
        cart.removeProduct("Мышка");

        // Вывод обновленной корзины
        cart.printCart();

        // Дополнительная демонстрация
        System.out.println("Добавляем еще один товар...\n");
        Product monitor = new Product("Монитор", 25000.0);
        cart.addProduct(monitor);

        cart.printCart();

        System.out.println("Пытаемся удалить несуществующий товар...\n");
        boolean removed = cart.removeProduct("Планшет");
        if (!removed) {
            System.out.println("Товар не найден в корзине\n");
        }

        // Финальный вид корзины
        cart.printCart();
    }
}