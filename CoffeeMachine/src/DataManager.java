public class DataManager {

    Manufacture mf= new Manufacture();

    public void setToMakeCoffee(){          //재료setting하기
        if (UserPanel.selection==1){         //일반커피
            mf.makeCoffee(100,1,0,0,0,0,0);
        }
        else if (UserPanel.selection==2){    //일반설탕커피
            mf.makeCoffee(100,1,20,0,0,0,0);
        }
        else if (UserPanel.selection==3){    //일반설탕크림커피
            mf.makeCoffee(100,1,20,10,0,0,0);
        }
        else if (UserPanel.selection==4){    //율무차
            mf.makeCoffee(100,0,0,0,1,0,0);
        }
        else if (UserPanel.selection==5){    //홍차
            mf.makeCoffee(100,0,0,0,0,1,0);
        }
        else if (UserPanel.selection==6){    //코코아
            mf.makeCoffee(100,0,0,0,0,0,1);
        }
    }

}
