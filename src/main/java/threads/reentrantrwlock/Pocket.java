package threads.reentrantrwlock;

public class Pocket {
    private int money;

    // constructor
    public Pocket(int money) {
        this.money = money;
    }

    // getter, setter
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}