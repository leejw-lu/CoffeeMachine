import java.util.Arrays;
import java.util.List;

public class Button {
    private int btn_position;
    private String btn_name;
    private int price;

    public Button(int btn_position, String btn_name,int price){
        this.btn_position=btn_position;
        this.btn_name=btn_name;
        this.price=price;
    }
    public int getBtn_position(){return btn_position;}
    public String getBtn_name(){return btn_name;}
    public int getPrice(){return price;}

    public static final List<Button> buttons= Arrays.asList(
            new Button(1, "일반커피",400),
            new Button(2, "일반설탕커피",500),
            new Button(3, "일반설탕크림커피",600),
            new Button(4, "율무차",300),
            new Button(5, "홍차",300),
            new Button(6, "코코아",300)
    );
}
