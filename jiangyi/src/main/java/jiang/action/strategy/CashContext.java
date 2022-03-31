package jiang.action.strategy;

public class CashContext {
    private CashSuper cashSuper;

    public CashContext() {
        this.cashSuper = new CashNormal();
    }

    public CashContext(String type) {
        if (type.equals("1")) {
            this.cashSuper = new CashRebate(0.8);
        } else if (type.equals("2")) {
            this.cashSuper = new CashReturn(100, 10);
        } else {
            this.cashSuper = new CashNormal();
        }
    }

    public double getResult(double money) {
        return cashSuper.acceptCash(money);
    }
}
