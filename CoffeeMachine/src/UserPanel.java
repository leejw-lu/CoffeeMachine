import java.util.List;
import java.util.Scanner;

public class UserPanel {

    public static int cash;        //투입한 돈
    public static int selection;   //버튼 position
    public static int price;     // (선택한)커피가격
    public static List<Button> btn;
    public static Controller ctr;
    public static String panelState;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = "yes";
        while(!input.equals("no")){
            btn= Button.buttons;

            System.out.println("===========자판기 Panel==============");
            displayButtons(btn);

            System.out.println("========자판기에 돈을 투입해주세요.========");
            System.out.print("돈 투입: ");
            cash= sc.nextInt();
            acceptMoney(cash);

            if(availablebuttons(btn)>0) {
                System.out.println(">>>선택할 수 있는 커피&음료 버튼입니다.");
                System.out.print("커피 번호 선택: ");
                selection=sc.nextInt();
                accept(selection);

                ctr.control();
            }
            else {
                System.out.println("=======선택할 수 있는 버튼이 없습니다.=====");
                returnCash(cash);
            }
            System.out.println("=계속 커피&음료를 뽑으실거면 yes 종료할꺼면 no를 입력하세요=");
            System.out.print("계속 뽑겠습니까? : ");
            input =sc.next();
        }
    }

    //method
    public static void displayPrompt(String panelState){
        System.out.println(panelState);
    }

    public static void displayButtons(List<Button> buttons){
        for(Button btn: buttons)
            System.out.println(btn.getBtn_position()+"번 "+ btn.getPrice()+"원" +"\t"+ btn.getBtn_name());
    }

    public static int availablebuttons(List<Button> buttons){
        int count=0;
        for(Button btn: buttons) {
            if(cash>=btn.getPrice()) {
                System.out.println(btn.getBtn_position()+"번 "+ btn.getPrice()+"원" +"\t"+ btn.getBtn_name());
                count++;
            }
        }
        return count;
    }

    public static void acceptMoney(int cash) {
        System.out.println(cash + "원을 투입하였습니다.");

        ctr = new Controller();
        ctr.inputMoney(cash);
    }

    public static void accept(int selection) {
        List<Button> buttons=Button.buttons;
        for(Button btn: buttons ) {
            if (btn.getBtn_position()==selection){
                price= btn.getPrice();
                break;
            }
        }
        switch (selection) {
            case 1 -> System.out.println(price + "원 일반커피를 선택하였습니다.");
            case 2 -> System.out.println(price + "원 일반설탕커피를 선택하였습니다.");
            case 3 -> System.out.println(price + "원 일반설탕크림커피를 선택하였습니다.");
            case 4 -> System.out.println(price + "원 율무차를 선택하였습니다.");
            case 5 -> System.out.println(price + "원 홍차를 선택하였습니다.");
            case 6 -> System.out.println(price + "원 코코아를 선택하였습니다.");
        }
        ctr.inputSelect(selection, price);
    }

    public static void receiveCoffee(int selection) {
        System.out.println("===========제작 완료되었습니다.==============");
        switch (selection) {
            case 1 -> System.out.println("선택한 일반커피가 나왔습니다.");
            case 2 -> System.out.println("선택한 일반설탕커피가 나왔습니다.");
            case 3 -> System.out.println("선택한 일반설탕크림커피가 나왔습니다.");
            case 4 -> System.out.println("선택한 율무차가 나왔습니다.");
            case 5 -> System.out.println("선택한 홍차가 나왔습니다.");
            case 6 -> System.out.println("선택한 코코아가 나왔습니다.");
        }
        System.out.println("=========================================");
    }

    public static void returnCash(int cash){
        System.out.println(cash+"원을 반환합니다.");
    }
}
