public class Controller {
    private int cash;

    MoneyManager mm= new MoneyManager();
    DataManager dm= new DataManager();
    Inventory iv=new Inventory();

    public void inputMoney(int cash) {
        this.cash=cash;
        mm.inputMoneyinfo(this.cash);
    }

    public void inputSelect(int selection, int price) {
        mm.inputSelectinfo(selection, price);
    }

    public void control() {
        int change;
        if(mm.checkForChanage().equals("가격동일")){
            UserPanel.panelState="물,컵,재료 재고를 확인합니다.";
            UserPanel.displayPrompt(UserPanel.panelState);

            if(getCheckInventory()) {
                MoneyManager.totalMoney+=cash;
                //데이터메니저에서 선택한 음료 재료 세팅하기.
                dm.setToMakeCoffee();
                iv=new Inventory();
                iv.displayInventory();
                UserPanel.receiveCoffee(UserPanel.selection);
            }
            else{
                //change =cash;
                UserPanel.panelState="재고부족으로 ";
                UserPanel.displayPrompt(UserPanel.panelState);
                UserPanel.returnCash(cash);   //돈 반환
                iv.displayInventory();
            }
        }
        else{   //잔돈발생
            change =mm.getChange();
            if(mm.minustotalMoney(change)){   //toalMoney: 거스러줄 돈 있음
                UserPanel.panelState="물,컵,재료 재고를 확인합니다.";
                UserPanel.displayPrompt(UserPanel.panelState);

                if(getCheckInventory()) {
                    MoneyManager.totalMoney+=cash;
                    UserPanel.panelState="잔돈이 있어 ";
                    UserPanel.displayPrompt(UserPanel.panelState);
                    UserPanel.returnCash(change);   //돈 반환
                    //데이터메니저에서 선택한 음료 재료 세팅하기.
                    dm.setToMakeCoffee();
                    iv=new Inventory();
                    iv.displayInventory();
                    UserPanel.receiveCoffee(UserPanel.selection);
                }
                else {
                    UserPanel.panelState="재고부족으로 ";
                    UserPanel.displayPrompt(UserPanel.panelState);
                    UserPanel.returnCash(cash);   //돈 반환
                    iv.displayInventory();
                }
            }
            else{ //toalMoney: 거스러줄 돈 없음
                UserPanel.panelState="거스러줄 돈이 부족합니다.";
                UserPanel.displayPrompt(UserPanel.panelState);
                UserPanel.returnCash(cash);   //돈 반환
            }
        }
    }

    public boolean getCheckInventory() {
        switch (iv.InventoryStatus()) {
            case "재고만족" -> {
                UserPanel.panelState = "재고만족-> 커피&음료 제작 준비";
                UserPanel.displayPrompt(UserPanel.panelState);
                return true;
            }
            case "물부족" -> {
                UserPanel.panelState = "사유: 물부족";
                UserPanel.displayPrompt(UserPanel.panelState);
                return false;
            }
            case "컵부족" -> {
                UserPanel.panelState = "사유: 컵부족";
                UserPanel.displayPrompt(UserPanel.panelState);
                return false;
            }
            default -> {
                UserPanel.panelState = "사유: 커피&음료 재료부족";
                UserPanel.displayPrompt(UserPanel.panelState);
                return false;
            }
        }

    }


}


