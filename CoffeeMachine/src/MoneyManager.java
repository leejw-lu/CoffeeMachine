public class MoneyManager {

    int cash;
    int selection, price;
    int change;
    public static int totalMoney = 5000;
    String statusMoney;

    public void inputMoneyinfo(int cash) {
        this.cash = cash;
    }

    public void inputSelectinfo(int selection, int price) {
        this.selection = selection;
        this.price = price;
    }

    public String checkForChanage(){
        if (cash != price) {
            statusMoney="잔돈발생";
            change= cash-price;
        } else {
            statusMoney="가격동일";
        }
        return statusMoney;
    }

    public boolean minustotalMoney(int change) {
        if(totalMoney>change) {
            totalMoney -= change;
            return true;
        }
        else return false;
    }

    public int getChange() {
        return change;
    }
}
