package week2.Constructor;

import week2.Constructor.Market.Merchandise_Static;

import static week2.Constructor.Market.Merchandise_Static.DISCOUNT_FOR_VIP;
//import static week2.Constructor.Market.Merchandise_Static.*;

public class Merchandise_App_Static {
    public static void main(String[] args) {
        Merchandise_Static merchandise = new Merchandise_Static
                ("小乌龟", "998996", 100, 10, 7);

        merchandise.describe();

        // >> TODO 使用import static来引入一个静态变量，就可以直接用静态变量名访问了
        //    TODO import static也可以使用通配符*来引入一个类里所有静态变量
        System.out.println(DISCOUNT_FOR_VIP);
    }
}
