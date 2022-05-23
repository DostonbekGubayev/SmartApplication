package com.company;

import javax.swing.*;
import java.awt.*;

public class LoginOyna extends JFrame {
    private JLabel rasmLabel,usernameLabel,passLabel,successLabel;
    private JTextField textUser,textPass;
    private JButton loginButton;
    private ImageIcon rasmIcon;
    Timer timer;
    JPanel contentPane;
    String[] list ={
            "src/ShaxarRasmlari/rasmlar/korinishi.jpg","src/ShaxarRasmlari/rasmlar/registan.jpg",
            "src/ShaxarRasmlari/rasmlar/samarqand.jpg","src/ShaxarRasmlari/rasmlar/yoni.jpg",
            "src/ShaxarRasmlari/rasmlar/shoxizinda.jpg"
    };
    int x=0;
    Main main;
    TilOrnatuvchi ornatuvchi;
   public LoginOyna(TilOrnatuvchi ornatuvchi,Main main){
       super("Login");
      this.ornatuvchi=ornatuvchi;
      this.main=main;

       {
           setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
           setVisible(true);
           setSize(350, 630);
           setLocationRelativeTo(null);
           getContentPane().setLayout(null);
           setResizable(false);
       }
       contentPane=new JPanel();
       contentPane.setBounds(0,0,350,630);
       contentPane.setLayout(null);
       contentPane.setBackground(Color.BLACK);
       add(contentPane);
       rasmLabel=new JLabel();
       rasmLabel.setBounds(0,0,350,240);
       contentPane.add(rasmLabel);
       timer=new Timer(2000,event->{
           rasmOrnat(x);
           x++;
           if (x>=list.length){
               x=0;
           }
       });
       timer.start();
       Font font=new Font("Consolas",Font.ITALIC,18);

       usernameLabel=new JLabel("Username*");
       usernameLabel.setFont(font);
       usernameLabel.setBounds(10,360,200,30);
       usernameLabel.setForeground(Color.CYAN);
       contentPane.add(usernameLabel);

       textUser=new JTextField();
       textUser.setBounds(10,395,190,30);
       textUser.setFont(new Font("Arial",Font.ITALIC,16));
       contentPane.add(textUser);

       passLabel=new JLabel("Password*");
       passLabel.setFont(font);
       passLabel.setForeground(Color.CYAN);
       passLabel.setBounds(10,430,160,30);
       contentPane.add(passLabel);

       textPass=new JTextField();
       textPass.setBounds(10,465,190,30);
       textPass.setFont(new Font("Tahoma",Font.ITALIC,16));
       contentPane.add(textPass);

       successLabel=new JLabel();
       successLabel.setBounds(10,505,240,30);
       successLabel.setFont(font);
       contentPane.add(successLabel);

       loginButton=new JButton("Login In");
       loginButton.setBounds(60,545,200,35);
       loginButton.setBackground(Color.MAGENTA.darker());
       loginButton.setForeground(Color.WHITE);
       loginButton.setFont(new Font("Consolas",0,16));
       contentPane.add(loginButton);

       loginButton.addActionListener(event -> {

           boolean mantiqiy=rostlikkaTekshir();
           if (mantiqiy){
               successLabel.setText("Login Succsessfully");
               successLabel.setForeground(Color.ORANGE);
               new asosiyOyna().setVisible(true);
           }else {
               successLabel.setText("Login not Inserted");
               successLabel.setForeground(Color.RED);
           }
       });
       if (main.languageBox.getSelectedItem().equals("Uzbek")){
           ozbekTili();
       }if (main.languageBox.getSelectedItem().equals("English")){
           inglizTili();
       }if (main.languageBox.getSelectedItem().equals("Russian")){
           rusTili();
       }

   }


   public void rasmOrnat(int i){
       ImageIcon imageIcon=new ImageIcon(list[i]);
       Image image=imageIcon.getImage();
       Image yangiImage=image.getScaledInstance(350,240,Image.SCALE_REPLICATE);
       ImageIcon icon=new ImageIcon(yangiImage);
       rasmLabel.setIcon(icon);
   }

   public boolean rostlikkaTekshir(){
       boolean rostmi=true;
       if (textUser.getText().isEmpty()){
           rostmi=false;
       }if (textPass.getText().isEmpty()){
           rostmi=false;
       }
       return rostmi;
   }
   public void ozbekTili(){
       if (ornatuvchi.ozbekTiliOrnat()){
               usernameLabel.setText("Foydalanuvchi Nomi*");
               passLabel.setText("Parol*");
               loginButton.setText("Tizimga Kirish");
           }
   }
   public void rusTili(){
       if (ornatuvchi.rusTiliOrnat()){
           usernameLabel.setText("Имя Ползавателя*");
           passLabel.setText("Парол*");

       }
   }
   public void inglizTili(){
       if (ornatuvchi.inglizTiliOrnat()){
           usernameLabel.setText("Username*");
           passLabel.setText("Password*");
       }
   }


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginOyna(new TilOrnatuvchi(new Main()),new Main());
            }
        });
    }
}
