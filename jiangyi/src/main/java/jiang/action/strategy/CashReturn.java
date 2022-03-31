package jiang.action.strategy;

import java.math.BigDecimal;

public class CashReturn extends CashSuper {
    private double moneyCondition = 1.0d;
    private double moneyReturn = 0.0d;

    public CashReturn(double moneyCondition, double moneyReturn) {
        this.moneyCondition = moneyCondition;
        this.moneyReturn = moneyReturn;
    }

    @Override
    public double acceptCash(double money) {
        if(money > moneyCondition) {
            double returnMoney = Math.floor(money / moneyCondition) * moneyReturn;
            BigDecimal returnMoneyDecimal = new BigDecimal(Double.toString(returnMoney));
            BigDecimal moneyDecimal = new BigDecimal(Double.toString(money));
            return moneyDecimal.subtract(returnMoneyDecimal).doubleValue();
        }
        return money;
    }
}
