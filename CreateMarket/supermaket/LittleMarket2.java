package week2.CreateMarket.supermaket;

public class LittleMarket2 {
    public String Market_name;                //超市名
    public String address;                    //地址
    public int park_count;                    //停车数
    public double incoming_sum;               //收入总额
    public Merchandise2[] merchandises;        //商品列表
    public int[] merchandise_sold;           //对应商品卖了多少个

    //>> 返回值类型可以是类名，此时实际返回的值就是这个类的引用，curr返回的是Merchandise2
    // 求最大收益商品 写法1
    public Merchandise2 get_biggest_profit_merchandise() {
        System.out.println("LittleMarket2.get_biggest_profit_merchandise方法使用的对象是:" + this);
        Merchandise2 curr = null;//当前最大收益的为null
        for (int i = 0; i < merchandises.length; i++) {
            Merchandise2 m = merchandises[i];
            if (curr == null) {
                curr = m;
                continue;
            }
            //调用Merchandise2中定义的方法，不同的实例调用相同的方法，代码相同，但实例内部数据不同，返回值也不同
            double curr_profit = curr.calculate_profit();
            double new_profit = m.calculate_profit();
            if (curr_profit < new_profit) {
                curr = m;
            }
        }
        return curr;
    }

    // 求最大收益商品 写法2，感觉更符合思维习惯
    public Merchandise2 get_biggest_profit_merchandise2() {
        Merchandise2 curr = null;//当前最大收益的为null
        for (int i = 0; i < merchandises.length; i++) {
            Merchandise2 m = merchandises[i];
            if (curr == null) {
                curr = m;
            } else {
                if (curr.calculate_profit() < m.calculate_profit()) {
                    curr = m;
                }
            }
        }
        return curr;
    }

}
