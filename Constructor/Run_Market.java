package week2.Constructor;

import week2.Constructor.Market.Little_Market;

public class Run_Market {
    public static void main(String[] args) {
        // 创建一个小超市类
        Little_Market littleSuperMarket = new Little_Market(
                "登灵超市", "文汇路800弄",
                100, 200, 200);

        System.out.println("下面请利润最高的商品自我介绍：");
        littleSuperMarket.getBiggestProfitMerchandise().describe();
    }
}
