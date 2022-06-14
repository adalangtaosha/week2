package week2.CreateMarket;

import week2.CreateMarket.supermaket.LittleMarket2;
import week2.CreateMarket.supermaket.Merchandise2;

import java.util.Scanner;

public class RunMarket3 {
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
            m.sold_price = m.buy_price * (1 + Math.random());
            m.made_in = "China";
            //  用创建的商品，给商品数组all的第i个引用赋值
            all[i] = m;
        }

        /*
           顾客端1_方法内无参数，输出商品总价
         */

//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            System.out.println("今日超市所有商品第二件半价！选择要购买的商品索引：");
//            int index = scanner.nextInt(); //输入要买的商品索引
//            if (index < 0) {
//                System.out.println("慢走，欢迎下次光临");
//                break;
//            }
//            if (index >= all.length) {
//                System.out.println("商品索引超出界限,请输入[0," + all.length + ")范围的索引");
//                continue;
//            }
//            Merchandise2 m = all[index];//前面m已经用完了，因此这里用m不冲突
//            System.out.println("商品" + m.name + "售价为" + m.sold_price + ",请问您购买的数量为？");
//            int num_buy = scanner.nextInt();//输入要买的商品数量
//            if (num_buy>m.count){
//                System.out.println("库存不足");
//                continue;
//            }
//            int full_price_count = num_buy / 2 + num_buy % 2;
//            int half_price_count = num_buy - full_price_count;
//            double total_price = full_price_count*m.sold_price+(half_price_count*m.sold_price/2);
//            m.count -= num_buy;
//            System.out.println("选购的商品总价为"+total_price);

        /*
           顾客端2_方法内有参数，输出商品总价
         */

//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            System.out.println("今日超市所有商品第二件半价！选择要购买的商品索引，范围是[0,"+all.length+")");
//            int index = scanner.nextInt(); //输入要买的商品索引
//            if (index < 0) {
//                System.out.println("慢走，欢迎下次光临");
//                break;
//            }
//            if (index >= all.length) {
//                System.out.println("商品索引超出界限,请输入[0," + all.length + ")范围的索引");
//                continue;
//            }
//            System.out.println("请问您购买的数量为？");
//            int num_buy = scanner.nextInt();//输入要买的商品数量
//            Merchandise2 m = littleMarket.merchandises[index];
//            double total_price = m.buy(num_buy);
//            System.out.println("选购的商品总价为"+total_price);
//        }

        /*
           顾客端3_方法内有多个参数，返回输出商品总价和剩余库存
         */

//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            System.out.println("今日超市所有商品第二件半价！选择要购买的商品索引，范围是[0,"+all.length+")");
//            int index = scanner.nextInt(); //输入要买的商品索引
//            if (index < 0) {
//                System.out.println("慢走，欢迎下次光临");
//                break;
//            }
//            if (index >= all.length) {
//                System.out.println("商品索引超出界限,请输入[0," + all.length + ")范围的索引");
//                continue;
//            }
//            System.out.println("请问您购买的数量为？");
//            int num_buy = scanner.nextInt();//输入要买的商品数量
//            Merchandise2 m = littleMarket.merchandises[index];
//            double total_price = m.buy_and_left_count(num_buy,true);
//            System.out.println("选购的商品总价为"+total_price);
//        }

        /*
           顾客端4_方法内有自定义参数，返回用户选择的商品是否是超市里最贵的，以及商品总价
         */

        Scanner scanner = new Scanner(System.in);
        Merchandise2 n = all[6]; //与第7个商品做比较
        while (true) {
            System.out.println("今日超市所有商品第二件半价！选择要购买的商品索引，范围是[0," + all.length + ")");
            int index = scanner.nextInt(); //输入要买的商品索引
            if (index < 0) {
                System.out.println("慢走，欢迎下次光临");
                break;
            }
            if (index >= all.length) {
                System.out.println("商品索引超出界限,请输入[0," + all.length + ")范围的索引");
                continue;
            }
            System.out.println("请问您购买的数量为？");
            int num_buy = scanner.nextInt();//输入要买的商品数量
            Merchandise2 m = littleMarket.merchandises[index];
            System.out.println("用户选择的商品是超市里最贵的" + m.isTheBiggestTotalValueOne(littleMarket));
            double total_price = m.buy_and_left_count(num_buy, true);
            boolean nBiggerThan = n.totalValueBiggerThan(m);//按进价的第7个商品的价值是否比用户选的商品价值大
            System.out.println("第7个商品的总价值比用户选择的大:" + nBiggerThan);
            System.out.println("选购的商品总价为" + total_price);
        }

    }

}
