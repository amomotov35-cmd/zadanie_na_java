public class Main {
    public static void main(String[] args) {
        // Создаем товары
        Product laptop = new Product("Ноутбук", 75000.0);
        Product mouse = new Product("Мышка", 1500.0);
        Product keyboard = new Product("Клавиатура", 3000.0);
        Product headphones = new Product("Наушники", 5000.0);

        Cart cart = new Cart();

        System.out.println("Добавляем товары в корзину...");
        cart.addProduct(laptop);
        cart.addProduct(mouse);
        cart.addProduct(keyboard);
        cart.addProduct(headphones);

        cart.printCart();

        System.out.println("Удаляем: Мышка");
        cart.removeProduct("Мышка");

        cart.printCart();

        System.out.println("Пытаемся удалить несуществующий товар...");
        cart.removeProduct("Монитор");

        cart.printLog();

        System.out.println("Добавляем еще один товар...");
        cart.addProduct(new Product("Веб-камера", 2500.0));

        cart.printCart();
        cart.printLog();
    }
}