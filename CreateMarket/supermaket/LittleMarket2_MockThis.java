package week2.CreateMarket.supermaket;

public class LittleMarket2_MockThis {
    public String superMarketName;
    public String address;
    public int parkingCount;
    public double incomingSum;
    public Merchandise2_MockThis[] merchandises;
    public int[] merchandiseSold;

    public Merchandise2_MockThis getBiggestProfitMerchandise(week2.CreateMarket.supermaket.LittleMarket2_MockThis This) {
        System.out.println("LittleSuperMarket的getBiggestProfitMerchandise方法使用的对象是：" + This);
        Merchandise2_MockThis curr = null;
        for (int i = 0; i < This.merchandises.length; i++) {
            Merchandise2_MockThis m = This.merchandises[i];
            if (curr == null || curr.calculateProfit() < m.calculateProfit()) {
                curr = m;
            }
        }
        return curr;
    }
}
