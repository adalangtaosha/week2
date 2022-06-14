package week2.Constructor;

import week2.Constructor.Market.Merchandise;

public class Merchandise_App {
    public static void main(String[] args) {
//        Merchandise merchandise = new Merchandise();
        Merchandise merchandise = new Merchandise("小乌龟","998996",100,10);
        merchandise.describe();
    }
}
