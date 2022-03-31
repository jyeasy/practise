package jiang.action;

import jiang.action.good.Apple;
import jiang.action.good.Fruit;
import jiang.action.good.Mango;
import jiang.action.good.Strawberry;
import jiang.action.strategy.CashContext;

import java.math.BigDecimal;

public class client {
    private static Apple apple = new Apple("苹果", 13d);

    private static Strawberry strawberry = new Strawberry("草莓", 8d);

    private static Mango mango = new Mango("芒果", 20d);
    // 8折优惠
    private static CashContext cashRebateContext = new CashContext("1");
    // 满100返回10元优惠
    private static CashContext cashReturnContext = new CashContext("2");
    // 没有优惠
    private static CashContext cashNormalContext = new CashContext();

    public static void main(String[] args) {
        int appleNum = 13;
        int mangoNum = 15;
        int StrawberryNum = 12;

        double applePrise = getFruitPrise(apple, cashNormalContext, appleNum);

        // 没有优惠
        // double strawberryPrise = getFruitPrise(strawberry, cashNormalContext, StrawberryNum);
        // 8折优惠
        double strawberryPrise = getFruitPrise(strawberry, cashRebateContext, StrawberryNum);

        double mangoPrise = getFruitPrise(mango, cashNormalContext, mangoNum);

        double totalPrise = applePrise + strawberryPrise + mangoPrise;

        // 没有活动的总价。
        // double result = cashNormalContext.getResult(totalPrise);
        // 100返回10元活动后的总价。
        double result = cashReturnContext.getResult(totalPrise);
        System.out.println("总价：" + result);
    }

    /**
     * @param fruit       水果类型
     * @param cashContext 优惠类型
     * @param fruitNum    水果数量
     * @return 当前水果价格
     */
    private static double getFruitPrise(Fruit fruit, CashContext cashContext, int fruitNum) {
        BigDecimal unitPrice = new BigDecimal(fruit.getUnitPrice());
        BigDecimal num = new BigDecimal(Double.toString(fruitNum));
        double money = unitPrice.multiply(num).doubleValue();
        double result = cashContext.getResult(money);
        System.out.println(fruit.getName() + "：" + result + "元");
        return result;
    }
}
