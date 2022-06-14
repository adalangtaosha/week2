package week2.CreateMarket;

import week2.CreateMarket.supermaket.LittleMarket2;
import week2.CreateMarket.supermaket.Merchandise2;

import java.util.Scanner;

public class RunMarket2 {
    public static void main(String[] args) {
        // 创建小超市类
        LittleMarket2 littleMarket = new LittleMarket2();
        // 为超市名字、地址、停车位数量、超市商品的种类数、统计卖出商品对应的数量   赋值
        littleMarket.address = "文汇路800弄";
        littleMarket.Market_name = "登灵超市";
        littleMarket.park_count = 50;
        littleMarket.merchandises = new Merchandise2[200];
        littleMarket.merchandise_sold = new int[littleMarket.merchandises.length];

        // 为使用方便，创建数组引用all，和littleMarket.merchandises指向同一个对象
        Merchandise2[] all = littleMarket.merchandises;
        // 遍历200种商品，为id、name、购买价格、卖出价格赋值
        for (int i = 0; i < all.length; i++) {
            // 创建商品，并给属性赋值
            Merchandise2 m = new Merchandise2();
            m.count = 200;
            m.id = "ID" + i;
            m.name = "商品" + i;
            m.buy_price = Math.random() * 200;
            m.sold_price = m.buy_price*(1 + Math.random());
            m.made_in = "China";
            //  用创建的商品，给商品数组all的第i个引用赋值
            all[i] = m;
        }
        System.out.println("LittleMarket2方法使用的对象是:" + littleMarket);
        System.out.println("利润最高的商品具体信息:");
//        littleMarket.get_biggest_profit_merchandise().describe();
        Merchandise2 m = littleMarket.get_biggest_profit_merchandise();
        m.describe();
        System.out.println("利润最高的Merchandise2对象是:"+m);
        if (!m.has_enough_count(500)){
            System.out.println("补充库存");
            int to_add = 500;
            littleMarket.incoming_sum-= to_add*m.buy_price;
            m.add_count(to_add);
        }

    }

}
