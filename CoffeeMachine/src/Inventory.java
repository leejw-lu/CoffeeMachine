public class Inventory {

    CupManager cm= new CupManager();
    IngredientManager im=new IngredientManager();

    public static int water = 5000;
    int cup=cm.getRemainCup();
    int coffee=im.getCountCoffee();
    int sugar=im.getAmountOfSugar();
    int cream=im.getAmountOfCream();
    int yulmu=im.getAmountOfYulmu();
    int hongtea=im.getAmountOfHongTea();
    int cocoa=im.getAmountOfCoCoa();

    private boolean ingredientStatus;
    private String inventoryState ;

    public Boolean checkWater(){
        return water >= 100;     //커피 및 음료제작시 물 100필요
    }
    public Boolean checkCup(){
        return cup > 0;      //컵 1개이상이어야 제조가능
    }
    public boolean checkIngredient(int type) {
        switch (type) {
            //일반커피 재료확인
            case 1 -> ingredientStatus = coffee > 0;
            //true
            //일반설탕커피 재료확인
            case 2 -> ingredientStatus = coffee > 0 && sugar >= 20;
            //일반설탕크림커피 재료확인
            case 3 -> ingredientStatus = coffee > 0 && sugar >= 20 && cream >= 10;
            //율무차 재료확인
            case 4 -> ingredientStatus = yulmu > 0;
            //홍차 재료확인
            case 5 -> ingredientStatus = hongtea > 0;
            //코코아 재료확인
            case 6 -> ingredientStatus = cocoa > 0;
        }
        return ingredientStatus;
    }

    public String InventoryStatus() {
        if(checkWater()){
            if(checkCup()){
                if(checkIngredient(UserPanel.selection)){
                    inventoryState="재고만족";
                }
                else{
                    inventoryState="커피&음료 재료부족";
                }
            }
            else{
                inventoryState="컵부족";
            }
        }
        else{
            inventoryState="물부족";
        }
        return inventoryState;
    }

    public void displayInventory() {
        System.out.println("===========재고현황 조사==============");
        System.out.println("현재 남은 물의 양은 "+ water + "ml 입니다.");
        CupManager.displayCupOfCup();
        System.out.println("현재 남은 커피의 개수는 "+ coffee+ "개 입니다.");
        System.out.println("현재 남은 설탕의 양은 "+ sugar+ "입니다.");
        System.out.println("현재 남은 크림의 양은 "+ cream+ "입니다.");
        System.out.println("현재 남은 율무차의 개수는 "+ yulmu+ "개 입니다.");
        System.out.println("현재 남은 홍차의 개수는 "+ hongtea+ "개 입니다.");
        System.out.println("현재 남은 코코아의 개수는 "+ cocoa+ "개 입니다.");
    }
}
