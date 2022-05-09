package by.epam.unit_5.task_2;

import java.util.ArrayList;
import java.util.List;

public class Payment {
    private double totalPrice;
    List<Goods> goods;

    public Payment() {
        this.goods = new ArrayList<>();
    }

    public Goods createGoods(String title, String manufacturer, double price) {
        return new Goods(title, manufacturer, price);
    }

    //    добавление в корзину
    public void putToCart(String title, String manufacturer, double price) {
        this.goods.add(new Goods(title, manufacturer, price));
    }

    //    добавление в корзину
    public void putToCart(Goods goods) {
        this.goods.add(goods);
        countTotalPrice();
    }

    //    формирование корзины заказов
    public void formShoppingCart() {
        printGoods();
        System.out.println(this);
    }

    private void printGoods() {
        System.out.println("Корзина товаров:");
        goods.forEach(System.out::println);
    }

    private void countTotalPrice() {
        totalPrice = goods.stream()
                .mapToDouble(Goods::getPrice)
                .sum();
    }

    public class Goods {
        private String title;
        private String manufacturer;
        private double price;

        private Goods(String title, String manufacturer, double price) {
            this.title = title;
            this.manufacturer = manufacturer;
            this.price = price;
        }

        public String getTitle() {
            return title;
        }

        public String getManufacturer() {
            return manufacturer;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return String.format("%s %s - %.2f y.e.", title, manufacturer, price);
        }
    }

    @Override
    public String toString() {
        return String.format("Итого: %.2f y.e.", totalPrice);
    }
}
