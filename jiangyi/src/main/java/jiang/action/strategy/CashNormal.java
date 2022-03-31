package jiang.action.strategy;

public class CashNormal extends CashSuper {
    public CashNormal() {
    }

    @Override
    public double acceptCash(double money) {
        return money;
    }
}
