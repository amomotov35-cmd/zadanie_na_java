/**
 * Класс, представляющий товар
 */
public class Product {
    private String name;
    private double price;

    /**
     * Конструктор товара
     * @param name название товара
     * @param price цена товара
     */
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Получить название товара
     * @return название товара
     */
    public String getName() {
        return name;
    }

    /**
     * Получить цену товара
     * @return цена товара
     */
    public double getPrice() {
        return price;
    }

    /**
     * Строковое представление товара
     * @return отформатированная строка с информацией о товаре
     */
    @Override
    public String toString() {
        return name + " — " + price + " руб.";
    }
}