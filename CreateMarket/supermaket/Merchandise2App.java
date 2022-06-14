package week2.CreateMarket.supermaket;

public class Merchandise2App {
    public static void main(String[] args) {
        Merchandise2 merchandise = new Merchandise2();

        merchandise.name ="鸡腿";
        merchandise.sold_price=10.0;
        merchandise.buy_price = 5.0;
        merchandise.count = 20;
        merchandise.id = "998EKF";
        merchandise.made_in = "China";

        merchandise.describe();
    }
}
