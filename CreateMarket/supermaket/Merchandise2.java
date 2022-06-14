package week2.CreateMarket.supermaket;

public class Merchandise2 {
    public String name;
    public String id;
    public int count;
    public double sold_price;        //售价
    public double buy_price;         //进价
    public String made_in;
    //>>TODO 方法定义
    //>>TODO 返回值类型：无需返回值void，void是关键字。
    //>>TODO 方法体内部的变量叫做局部变量
    public void describe(){
        double net_income = sold_price-buy_price;
        System.out.println("商品名字叫做"+name+",制造地为"+made_in+",id是" +id+",商品售价为"+sold_price+
                ",商品进价为"+buy_price+",商品库存量为"+count+",销售一个的毛利润是"+net_income);
    }
    //>>TODO 在方法定义中指定方法的返回值类型
    //>>TODO 无需返回值，用void
    //>>TODO 定义返回值，用return
    //>>TODO 返回值给返回值类型的变量赋值

    public double calculate_profit(){
        double profit = sold_price-buy_price;
        if (profit<=0){
            return 0;
        }
        return profit;//一个方法可以有多个返回语句
    }

    public double get_count(){
        return count;
    }
    public int get_sold_price(){
        return (int)sold_price;
    }
    // >> TODO 参数是定义在方法名字后面的括号里的
    // >> TODO 参数定义的规范和变量一样，  类型名+参数名。
    // >> TODO 方法体中可使用参数
    // >> TODO 参数的值在调用方法的时给出，也叫实参。方法定义里的参数，叫做形参
    // 如果返回值是负数，库存不足
    public double buy(int count_ToBuy) {
        if (count < count_ToBuy) {
            System.out.println("商品库存不够");
            return -1;
        }
        System.out.println("商品单价为" + sold_price);

        int fullPriceCount = count_ToBuy / 2 + count_ToBuy % 2;
        int halfPriceCount = count_ToBuy - fullPriceCount;
        double totalCost = sold_price * fullPriceCount + halfPriceCount * sold_price / 2;

        count -= count_ToBuy;

        return totalCost;
    }

    // >> TODO 一个方法可以有多个参数，多个参数之间用逗号隔开
    public double buy_and_left_count(int count_ToBuy, boolean left_count) {
        if (count < count_ToBuy) {
            System.out.println("商品库存不够");
            if (left_count) {
                System.out.println("商品剩余库存为" + count);
            }
            return -1;
        }
        System.out.println("商品单价为" + sold_price);

        int fullPriceCount = count_ToBuy / 2 + count_ToBuy % 2;
        int halfPriceCount = count_ToBuy - fullPriceCount;
        double totalCost = sold_price * fullPriceCount + halfPriceCount * sold_price / 2;

        count -= count_ToBuy;

        if (left_count) {
            System.out.println("商品剩余库存为：" + count);
        }

        return totalCost;
    }

    // >> TODO 参数可以是任何类型，包括自定义类型，甚至是自己的类型都没问题
    // 比较
    public boolean totalValueBiggerThan(Merchandise2 merchandise) {
        double print1=count * buy_price;                        //原来的
        double print2=merchandise.buy_price * merchandise.count;//传进来参数的
        return count * buy_price > merchandise.buy_price * merchandise.count;
    }

    // >> TODO 参数可以是任何类型，包括自定义类型
    public boolean isTheBiggestTotalValueOne(LittleMarket2 littleMarket) {
        double totalValue = count * buy_price;
        for (int i = 0; i < littleMarket.merchandises.length; i++) {
            Merchandise2 m = littleMarket.merchandises[i];
            double newTotalValue = m.count * m.buy_price;
            if (totalValue < newTotalValue) {
                // 执行到return的时候，方法直接结束，不管是不是在循环中，是在第几层循环中。
                return false;
            }
        }
        return true;
    }

    // >> TODO this自引用，this.成员变量
    public void test(int name){
        System.out.println(this.name = "abc");
        name  = 12;
    }
    public void add_count(int count){
        this.count += count;
        System.out.println("Merchandise2.add_count使用的对象是:"+this);
    }
    public boolean has_enough_count(int count){
        System.out.println("Merchandise2.has_enough_count使用的对象是:"+this);
        return this.count >= count;
    }
}
