package by.epam.unit_5.task_2;

/*
task_2: Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать покупку из
нескольких товаров.
 */

public class Main {
    public static void main(String[] args) {
        Payment payment = new Payment();
        payment.putToCart("macbook", "apple", 3990);
        payment.putToCart("car", "vw passat b8", 28400);
        Payment.Goods goods = payment.createGoods("tv", "samsung", 1590);
        payment.putToCart(goods);

        payment.formShoppingCart();
    }
}
