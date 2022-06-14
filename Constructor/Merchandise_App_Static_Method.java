package week2.Constructor;

import week2.Constructor.Market.Merchandise_Static_Method;

import static week2.Constructor.Market.Merchandise_Static_Method.getVIPDiscount;

public class Merchandise_App_Static_Method {
    public static void main(String[] args) {
        Merchandise_Static_Method merchandise = new Merchandise_Static_Method
                ("小乌龟", "998996", 40, 10, 7);

        merchandise.describe();

        // >> TODO 使用import static来引入一个静态方法，就可以直接用静态变量名访问了
        //    TODO import static也可以使用通配符*来引入一个类里所有静态变量
        System.out.println(getVIPDiscount());

    }
}
