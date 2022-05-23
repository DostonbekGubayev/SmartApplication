package com.company;

import javax.swing.*;
import javax.swing.plaf.metal.MetalComboBoxUI;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class Main extends JFrame implements ActionListener {
    ImageIcon icon;
    JLabel label;
    JPanel panel;
     JTextArea matnYozuvchi;
    JButton btnLogin,btnSignup;
     JLabel english,uzbek,rus,kazak;
     JComboBox languageBox,monumentBox;
   private JMenuItem[] tillar=new JMenuItem[3];
    private String[] obidalar={"Registon","Go'ri Amir","Shohi Zinda","Bibi Xonim"};
    Timer timer;
    String[] list ={
      "src/ShaxarRasmlari/rasmlar/korinishi.jpg","src/ShaxarRasmlari/rasmlar/registan.jpg",
            "src/ShaxarRasmlari/rasmlar/samarqand.jpg","src/ShaxarRasmlari/rasmlar/yoni.jpg",
            "src/ShaxarRasmlari/rasmlar/shoxizinda.jpg"
    };

        int i=0;
    Main(){
        {  setDefaultCloseOperation(3);
            setVisible(true);
            setSize(350,630);
            setLocationRelativeTo(null);
            getContentPane().setLayout(null);
            setBackground(Color.MAGENTA);
            setResizable(false);
            this.setBackground(Color.BLACK);
            panel=new JPanel();
            panel.setBackground(Color.BLACK);
            panel.setBounds(0,0,350,630);
            panel.setLayout(null);
            add(panel);
        }

      label=new JLabel();
      metod();
        timer=new Timer(1000,e -> {
            rasmOzgartiruvchi(i);
            i++;
            if (i>=list.length)
                i=0;
        });
        label.setBounds(0,0,335,240);
        panel.add(label);
        matnYozuvchi=new JTextArea();
        matnYozuvchi.setBounds(10,260,310,150);
        matnYozuvchi.setForeground(Color.ORANGE);
        matnYozuvchi.setLineWrap(true);
        matnYozuvchi.setWrapStyleWord(true);
        matnYozuvchi.setEditable(false);
        try {
            Scanner scanner=new Scanner(new File("src/Izohlar/izohEng.txt"));
            while (scanner.hasNext()){
                String qator= scanner.nextLine();
                matnYozuvchi.setText(qator);
            }
        } catch (FileNotFoundException e) {

        }
        panel.add(matnYozuvchi);

        btnLogin=new JButton("Login");
        btnLogin.setBounds(40,440,200,35);
        btnLogin.addActionListener(event->{
            new LoginOyna(new TilOrnatuvchi(this),this).setVisible(true);
        });
        panel.add(btnLogin);

        btnSignup=new JButton("SignUp");
        btnSignup.setBounds(40,490,200,35);
        btnSignup.addActionListener(event->{
            new SignUpOyna(this,new TilOrnatuvchi(this)).setVisible(true);
        });
        panel.add(btnSignup);
        languageBox=new JComboBox();
       languageBox.setBounds(10,560,100,40);
        panel.add(languageBox);

        english=new JLabel("English");
        uzbek=new JLabel("Uzbek");
        rus=new JLabel("Russian");
        kazak=new JLabel("Kazak");

        languageBox.addItem(english.getText());
        languageBox.addItem(rus.getText());
        languageBox.addItem(uzbek.getText());
        languageBox.addItem(kazak.getText());
        JMenuItem item=new JMenuItem("Item");
        item.setActionCommand("item");
        languageBox.addItem(item.getText());
    languageBox.addActionListener(this);

       TilOrnatuvchi tilOrnatuvchi= new TilOrnatuvchi(this);
      languageBox.addItemListener(event->{
          if (languageBox.getSelectedItem().equals("English")){
              tilOrnatuvchi.inglizTiliOrnat();
          }else if (languageBox.getSelectedItem().equals("Russian")){
              tilOrnatuvchi.rusTiliOrnat();
          }else if (languageBox.getSelectedItem().equals("Uzbek")){
              tilOrnatuvchi.ozbekTiliOrnat();
          }
      });
    }



    //Rasm O'zgartiruvchi
    public void rasmOzgartiruvchi(int i){

        ImageIcon icon=new ImageIcon(list[i]);
        Image image=icon.getImage();
       Image newImg=image.getScaledInstance(360,280,Image.SCALE_REPLICATE);
        ImageIcon newImgIcon=new ImageIcon(newImg);
        label.setIcon(newImgIcon);
    }
    void metod(){
        Timer timer=new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rasmOzgartiruvchi(i);
                i++;
                if (i>=list.length){
                    i=0;
                }
            }
        });
        timer.start();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==languageBox){
          //  if (languageBox.getSelectedItem()=="Item");
            if (languageBox.getSelectedItem().equals("Item")){
                btnLogin.setText("Kirish");
                System.out.println("Item");
            }
        }
    }







    public static void main(String[] args) throws IOException {
        new Main();
        //new SignUpOyna();
        //new asosiyOyna();
        File file=new File("src/ShaxarRasmlari");
        file.mkdir();

        String qalam="example@gmail.com";
        System.out.println(qalam.endsWith("@gmail.com"));
    }
}
