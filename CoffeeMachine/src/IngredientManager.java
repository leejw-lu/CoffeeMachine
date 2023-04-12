public class IngredientManager {

    public static int countCoffee= 100;     //일반커피 <일반커피=일반커피
    public static int amountOfSugar= 200;    //설탕   <일반설탕커피=일반커피+설탕
    public static int amountOfCream= 100;    //크림   <일반설탕크림커피=일반커피+설탕+크림

    public static int amountOfYulmu= 50;
    public static int amountOfHongTea= 50;
    public static int amountOfCoCoa= 50;

    public int getCountCoffee() {
        return countCoffee;
    }

    public int getAmountOfSugar() {
        return amountOfSugar;
    }

    public int getAmountOfCream() {
        return amountOfCream;
    }

    public int getAmountOfYulmu() {
        return amountOfYulmu;
    }

    public int getAmountOfHongTea() {
        return amountOfHongTea;
    }

    public int getAmountOfCoCoa() {
        return amountOfCoCoa;
    }

}
