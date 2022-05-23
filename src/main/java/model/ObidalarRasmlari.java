package model;

import com.company.asosiyOyna;

import javax.swing.*;
import java.awt.*;

public class ObidalarRasmlari {

    asosiyOyna oyna;
    public String[]guriAmir={"src/Rasmlar/GuriAmir/amir1.jpg"
            ,"src/Rasmlar/GuriAmir/amir2.jpg","src/Rasmlar/GuriAmir/amir3.jpg",
            "src/Rasmlar/GuriAmir/amir4.jpg","src/Rasmlar/GuriAmir/amir5.jpg",
            "src/Rasmlar/GuriAmir/amir6.jpg","src/Rasmlar/GuriAmir/amir7.jpg"};

    public String []bibixonim={"src/Rasmlar/Bibixonim/bibixonim1.jpg"
            ,"src/Rasmlar/Bibixonim/bibixonim2.jpg","src/Rasmlar/Bibixonim/bibixonim3.jpg",
            "src/Rasmlar/Bibixonim/bibixonim4.jpg","src/Rasmlar/Bibixonim/bibixonim5.jpg",
            "src/Rasmlar/Bibixonim/bibixonim6.jpg","src/Rasmlar/Registon/registon7.jpg"};

    public String[]registon={"src/Rasmlar/Registon/registon1.jpg"
            ,"src/Rasmlar/Registon/registon2.jpg","src/Rasmlar/Registon/registon3.jpg",
            "src/Rasmlar/Registon/registon4.jpg","src/Rasmlar/Registon/registon5.jpg",
            "src/Rasmlar/Registon/registon6.jpg","src/Rasmlar/Registon/registon7.jpg"};

    public String []shoxizinda={"src/Rasmlar/ShoxiZinda/shoxizinda1.jpg"
            ,"src/Rasmlar/ShoxiZinda/shoxizinda2.jpg","src/Rasmlar/ShoxiZinda/shoxizinda3.jpg",
            "src/Rasmlar/ShoxiZinda/shoxizinda4.jpg","src/Rasmlar/ShoxiZinda/shoxizinda5.jpg",
            "src/Rasmlar/ShoxiZinda/shoxizinda6.jpg","src/Rasmlar/Registon/registon7.jpg"};


//    public String guriAmir[]={};

    int x=0;
    public ObidalarRasmlari(asosiyOyna oyna){
        this.oyna=oyna;
    }





    public void registon() {
        oyna.matnYozuvchi.setText("Yaxshiman");

    }
}
