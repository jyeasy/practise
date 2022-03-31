package jiang.action.strategy;

import java.math.BigDecimal;

public class CashRebate extends CashSuper {
    private double moneyRebate = 1d;

    public CashRebate(double moneyRebate) {
        this.moneyRebate = moneyRebate;
    }

    @Override
    public double acceptCash(double money) {
        BigDecimal rebateDecimal = new BigDecimal(Double.toString(moneyRebate));
        BigDecimal moneyDecimal = new BigDecimal(Double.toString(money));
        BigDecimal multiply = rebateDecimal.multiply(moneyDecimal);
        return multiply.doubleValue();
    }
}
