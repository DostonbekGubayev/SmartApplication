package com.company;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class TilOrnatuvchi {
    Main main;
    public TilOrnatuvchi(Main main){
        this.main=main;

    }

    public boolean ozbekTiliOrnat(){
        boolean rosstmi=false;
       main.languageBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (main.languageBox.getSelectedItem().equals("Uzbek")){
                    main.btnLogin.setText("Tizimga Kirish");
                    main.btnSignup.setText("Ro'yxatdan O'tish");
                    try {
                        Scanner scanner=new Scanner(new File("src/Izohlar/izohUzb.txt"));
                        while (scanner.hasNext()){
                            String qator=scanner.nextLine();
                            main.matnYozuvchi.setText(qator);
                            main.matnYozuvchi.setFont(new Font("Arial",0,18));
                            main.matnYozuvchi.setForeground(Color.BLACK);
                        }
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }

                }
            }

        });
        return true;
    }
    public boolean rusTiliOrnat(){
        main.languageBox.addItemListener(hodisa->{
            if(main.languageBox.getSelectedItem().equals("Russian")){
                main.btnLogin.setText("Авторизоваться");
                main.btnSignup.setText("Зарегистироваться");

                try {
                    Scanner scanner=new Scanner(new File("src/Izohlar/izohRus.txt"));
                    while (scanner.hasNext()){
                        String qator=scanner.nextLine();
                        main.matnYozuvchi.setText(qator);
                        main.matnYozuvchi.setFont(new Font("Arial",0,18));
                        main.matnYozuvchi.setForeground(Color.BLACK);
                    }
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        return true;
    }
    public boolean inglizTiliOrnat(){
        main.languageBox.addItemListener(event->{
            main.btnLogin.setText("Login");
            main.btnSignup.setText("Sign Up");

            try {
                Scanner scanner=new Scanner(new File("src/Izohlar/izohEng.txt"));
                while (scanner.hasNext()){
                    String qator=scanner.nextLine();
                    main.matnYozuvchi.setText(qator);
                    main.matnYozuvchi.setFont(new Font("Arial",0,18));
                    main.matnYozuvchi.setForeground(Color.BLACK);
                }
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });
        return true;
    }
}
