/*
         用This模拟this自引用
 */

package week2.CreateMarket.supermaket;

public class Merchandise2_MockThis {
    public String name;
    public String id;
    public int count;
    public double soldPrice;
    public double purchasePrice;

    public void describe(week2.CreateMarket.supermaket.Merchandise2_MockThis This) {
        System.out.println("商品名字叫做" + This.name + "，id是" + This.id + "。 商品售价是" + This.soldPrice
                + "。商品进价是" + This.purchasePrice + "。商品库存量是" + This.count +
                "。销售一个的毛利润是" + (This.soldPrice - This.purchasePrice));
    }

    public double calculateProfit() {
        double profit = soldPrice - purchasePrice;
        return profit;
    }

    public void duplicateName(int count) {

    }

    public int getCount(week2.CreateMarket.supermaket.Merchandise2_MockThis This) {
        return This.count;
    }

    public void addCount(week2.CreateMarket.supermaket.Merchandise2_MockThis This, int count) {
        This.count += count;
    }

    public boolean hasEnoughCountFor(week2.CreateMarket.supermaket.Merchandise2_MockThis This, int count) {
        return This.count >= count;
    }
    public boolean haveEnoughCountFor(int count) {
        return this.count >= count;
    }

    public void makeEnoughFor(week2.CreateMarket.supermaket.Merchandise2_MockThis This, int count) {
        boolean hasEnough = This.hasEnoughCountFor(This, count);
        if (!hasEnough) {
            int toBeAdd = count - This.count;
            This.addCount(This, toBeAdd);
        }
    }
    //>> TODO 递归调用
    public void makeEnoughForOneByOne(int count) {
        boolean hasEnough = this.haveEnoughCountFor(count);
        if (!hasEnough) {
            this.addCount(1);
            makeEnoughForOneByOne(count);
        }
    }
    public void addCount(int count){
        this.count += count;
        System.out.println("Merchandise2.add_count使用的对象是:"+this);
    }
}


