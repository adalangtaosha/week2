package week2.CreateMarket;

import week2.CreateMarket.person.customer;
import week2.CreateMarket.supermaket.LittleMarket;
import week2.CreateMarket.supermaket.Merchandise;

import java.util.Scanner;

public class RunMarket {
    public static void main(String[] args) {
        LittleMarket littleMarket = new LittleMarket();
        littleMarket.address = "文汇路800弄";
        littleMarket.Market_name = "登灵超市";
        littleMarket.park_count = 1;
        littleMarket.merchandises = new Merchandise[200];
        littleMarket.merchandise_sold = new int[littleMarket.merchandises.length];

        Merchandise[] all = littleMarket.merchandises;

        for (int i = 0; i < all.length; i++) {
            Merchandise m = new Merchandise();
            m.count = 200;
            m.id = "ID" + i;
            m.name = "商品" + i;
            m.buy_price = Math.random() * 200;
            m.sold_price = (1 + Math.random())* 200;
            all[i] = m;
        }
        System.out.println("登灵超市解封啦！");
        boolean open = true;
        Scanner scanner = new Scanner(System.in);

        while (open) {
            System.out.println("本店是" + littleMarket.Market_name);
            System.out.println("本店地址" + littleMarket.address);
            System.out.println("共有停车位" + littleMarket.park_count + "个");
            System.out.println("今天的营业额为" + littleMarket.incoming_sum);
            System.out.println("共有商品" + littleMarket.merchandises.length + "种");

            customer cus = new customer();
            cus.name = "顾客编号" + ((int) (Math.random() * 10000));
            cus.money = (1 + Math.random()) * 1000;
            cus.is_drivingCar = Math.random() > 0.5;

            if (cus.is_drivingCar) {
                if (littleMarket.park_count > 0) {
                    System.out.println("欢迎" + cus.name + "驾车而来，有车位，车位编号为" +
                            littleMarket.park_count);
                    littleMarket.park_count--;
                } else {
                    System.out.println("抱歉，车位已满，欢迎下次光临");
                    continue;
                }
            } else {
                System.out.println("欢迎" + cus.name + "光临小店");
            }
            double total_cost = 0;
            while (true) {
                System.out.println("本店提供" + all.length + "种商品，欢迎选购，请输入商品编号");
                int index = scanner.nextInt();
                if (index < 0) {
                    break;
                }
                if (index >= all.length) {
                    System.out.println("本店没这种商品，请输入编号在0到" + (all.length - 1) + "范围内的商品编号");
                    continue;
                }
                Merchandise m = all[index];
                System.out.println("您选购的商品名字"+m.name+",单价是"+m.sold_price+",请问您买多少个？");
                int num_buy = scanner.nextInt();

                if (num_buy<=0){
                    System.out.println("买不买没关系，进屋里瞧一瞧");
                    continue;
                }
                if (num_buy>m.count){
                    System.out.println("本店库存不足，请减量购买");
                    continue;
                }
                if (num_buy*m.sold_price+total_cost>cus.money){
                    System.out.println("您的余额不足，少买点吧");
                    continue;
                }
                total_cost += num_buy*m.sold_price;
                m.count -= num_buy;
                littleMarket.merchandise_sold[index]+=num_buy;
            }
            cus.money-=total_cost;
//            if (cus.is_drivingCar){
//                littleMarket.park_count++;
//            }
            System.out.println("顾客"+cus.name+"共消费了"+total_cost);
            littleMarket.incoming_sum+=total_cost;
            System.out.println("是否继续营业");
            open = scanner.nextBoolean();
        }
        System.out.println("登灵超市关门啦！");
        System.out.println("今天的营业额为"+littleMarket.incoming_sum+"营业情况如下:");
        for (int i=0;i<littleMarket.merchandise_sold.length;i++){
            Merchandise m = all[i];
            int num_sold = littleMarket.merchandise_sold[i];
            if (num_sold>0){
                double income = m.sold_price*num_sold;
                double net_income = (m.sold_price-m.buy_price)*num_sold;
                System.out.println(m.name+"售出"+num_sold+"个，总销售额为"+income+",净利润为"+net_income);
            }
        }
    }
}
