import java.util.ArrayList;

/**
 * Класс, представляющий корзину покупок
 */
public class Cart {
    private ArrayList<Product> products;

    /**
     * Конструктор корзины
     */
    public Cart() {
        this.products = new ArrayList<>();
    }

    /**
     * Добавить товар в корзину
     * @param product товар для добавления
     */
    public void addProduct(Product product) {
        products.add(product);
    }

    /**
     * Удалить товар из корзины по названию
     * @param name название товара для удаления
     * @return true если товар был найден и удален, false в противном случае
     */
    public boolean removeProduct(String name) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equalsIgnoreCase(name)) {
                products.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Рассчитать общую сумму товаров в корзине
     * @return общая стоимость товаров
     */
    public double getTotal() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    /**
     * Вывести содержимое корзины в консоль
     */
    public void printCart() {
        System.out.println("Корзина:");
        if (products.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            for (int i = 0; i < products.size(); i++) {
                System.out.println((i + 1) + ". " + products.get(i));
            }
            System.out.printf("Итого: %.1f руб.%n", getTotal());
        }
        System.out.println();
    }

    /**
     * Получить список товаров в корзине
     * @return список товаров
     */
    public ArrayList<Product> getProducts() {
        return products;
    }
}