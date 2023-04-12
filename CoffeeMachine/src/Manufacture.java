public class Manufacture {
    public void makeCoffee(int water,int coffee, int sugar, int cream, int yulmu, int hongtea, int cocoa) {
        System.out.println("===========커피&음료 제작 과정==============");
        putCup();
        fill_water(water);
        fill_ingredient(coffee,sugar,cream,yulmu,hongtea,cocoa);
    }

    public void putCup() {
        CupManager.countOfCup-=1;
        UserPanel.panelState="컵이 1개 떨어집니다.";
        UserPanel.displayPrompt(UserPanel.panelState);
    }
    public void fill_water(int water) {
        Inventory.water-=water;
        UserPanel.panelState="물이 채워집니다.";
        UserPanel.displayPrompt(UserPanel.panelState);
    }
    public void fill_ingredient(int coffee, int sugar, int cream, int yulmu, int hongtea, int cocoa) {
        IngredientManager.countCoffee-=coffee;
        IngredientManager.amountOfSugar-=sugar;
        IngredientManager.amountOfCream-=cream;
        IngredientManager.amountOfYulmu-=yulmu;
        IngredientManager.amountOfHongTea-=hongtea;
        IngredientManager.amountOfCoCoa-=cocoa;
        UserPanel.panelState="재료를 섞어줍니다.";
        UserPanel.displayPrompt(UserPanel.panelState);
    }
}
