package com.company;

import javax.swing.*;
import java.awt.*;
import java.nio.charset.StandardCharsets;

public class SignUpOyna extends JFrame{
    private JLabel firstName,lastName,username,password,confipass,email,imageLabel;
    JLabel success;
    JLabel[] labellar =new JLabel[7];
     JTextField txtFirst,txtLast,txtUser,txtPass,txtConfiPass,txtEmail;
     JButton signButton;
    private ImageIcon icon;
    JPanel contentPane;
       String[] ozbekTili ={"Ism","Familiya","Nom","Email","Parol","Parolni takrorlang"};
    String[] inglizTili ={"First Name","Last Name","Username","Email","Password","Conifrm Password"};
    String[] rusTili ={"Имя","Фамилия","Username","Email","Парол","Подвертить Парол"};
    Timer timer;
    int x=0;
    String[] list ={
            "src/ShaxarRasmlari/rasmlar/korinishi.jpg","src/ShaxarRasmlari/rasmlar/registan.jpg",
            "src/ShaxarRasmlari/rasmlar/samarqand.jpg","src/ShaxarRasmlari/rasmlar/yoni.jpg",
            "src/ShaxarRasmlari/rasmlar/shoxizinda.jpg"
    };
   // JLabel[]labels=new JLabel[6];
    JTextField [] fields=new JTextField[7];
    Font font;
    Color color=Color.WHITE.brighter();
    Main main;
    TilOrnatuvchi ornatuvchi;
    ConnectionDB connectionDB;
    LoginOyna oyna;
    //Constructor
    public SignUpOyna (Main main,TilOrnatuvchi ornatuvchi){
        this.main=main;
        this.ornatuvchi=ornatuvchi;
        connectionDB=new ConnectionDB(this,oyna);
      setTitle("SignUp");
      setSize(350,630);
      setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
      setLocationRelativeTo(null);
      setVisible(true);
      setLayout(null);
      setResizable(false);
      imageLabel=new JLabel();
      imageLabel.setBounds(0,0,350,220);
        timer=new Timer(1000,e -> {
            rasmOrnat(x);
            x++;
            if (x>=list.length)
                x=0;
        });
        timer.start();
      contentPane=new JPanel();
      contentPane.setBackground(Color.MAGENTA.darker().darker().brighter());
      contentPane.setLayout(null);
      contentPane.setBounds(0,0,350,630);
      add(contentPane);
      contentPane.add(imageLabel);

      JPanel panel=new JPanel();
      panel.setBounds(0,220,350,380);
      panel.setBackground(Color.getHSBColor(60,90,60));
      panel.setLayout(null);
      panel.setBackground(new Color(10,20,10).brighter());
      contentPane.add(panel);

        font= new Font("Consolas",Font.ITALIC,16);
          //labelMetodi();
      firstName=new JLabel("First Name*");
      firstName.setBounds(10,5,140,25);
      firstName.setForeground(color);
      firstName.setFont(font);
      panel.add(firstName);;

      txtFirst=new JTextField();
      txtFirst.setBounds(10,28,190,25);
      panel.add(txtFirst);

        lastName=new JLabel("Last Name*");
        lastName.setBounds(10,56,140,25);
        lastName.setForeground(color);
        lastName.setFont(font);
        panel.add( lastName);

        txtLast=new JTextField();
        txtLast.setBounds(10,84,190,25);
        panel.add(txtLast);


        username=new JLabel("Username*");
        username.setBounds(10,112,200,25);
        username.setForeground(color);
        username.setFont(font);
        panel.add( username);

        txtUser=new JTextField();
        txtUser.setBounds(10,140,190,25);
        panel.add(txtUser);

        email=new JLabel("Email*");
        email.setBounds(10,168,140,25);
        email.setForeground(color);
        email.setFont(font);
        panel.add( email);

        txtEmail=new JTextField();
        txtEmail.setBounds(10,194,190,25);
        panel.add(txtEmail);

        password=new JLabel("Password*");
        password.setBounds(10,222,140,25);
        password.setForeground(color);
        password.setFont(font);
        panel.add( password);

        txtPass=new JTextField();
        txtPass.setBounds(10,250,190,25);
        panel.add(txtPass);

        confipass=new JLabel(" Conifrom Password*");
        confipass.setBounds(5,278,210,25);
        confipass.setForeground(color);
        confipass.setFont(font);
        panel.add(  confipass);

        txtConfiPass=new JTextField();
        txtConfiPass.setBounds(10,306,190,25);
        panel.add(txtConfiPass);

        success=new JLabel();
        success.setBounds(10,335,210,25);
        success.setForeground(color);
        success.setFont(font);
        panel.add(success);

        signButton=new JButton("Sign Up");
        signButton.setBounds(160,335,150,30);
       connectionDB.DB_Connect();
        panel.add(signButton);

        {
            fields[0] = txtFirst;
            fields[1] = txtLast;
            fields[2] = txtUser;
            fields[3] = txtEmail;
            fields[4] = txtPass;
            fields[5] = txtConfiPass;
        }
        {
            labellar[0]=firstName;
            labellar[1]=firstName;
            labellar[2]=firstName;
            labellar[3]=firstName;
            labellar[4]=firstName;
            labellar[5]=firstName;
            labellar[6]=firstName;
        }

        if (main.languageBox.getSelectedItem().equals("Uzbek")){
            ozbekTiliOrnat();
        }if (main.languageBox.getSelectedItem().equals("Russian")){
            rusTiliOrnat();
        }if (main.languageBox.getSelectedItem().equals("English")){
           inglizTiliOrnat();
        }
    }

    public void rasmOrnat(int i){
        ImageIcon imageIcon=new ImageIcon(list[i]);
        Image image=imageIcon.getImage();
        Image yangiImage=image.getScaledInstance(imageLabel.getWidth(),imageLabel.getHeight(),Image.SCALE_REPLICATE);
        ImageIcon icon=new ImageIcon(yangiImage);
        imageLabel.setIcon(icon);
    }

    public boolean rostlikkaTekshir(){
        boolean rostmi=true;
        if (txtFirst.getText().isEmpty()){
            rostmi=false;
        }if (txtLast.getText().isEmpty()){
            rostmi=false;
        }if (txtUser.getText().isEmpty()){
            rostmi=false;
        }if (txtEmail.getText().isEmpty()){
            rostmi=false;
        }if (txtPass.getText().isEmpty()){
            rostmi=false;
        }if (txtConfiPass.getText().isEmpty()){
            rostmi=false;
        }

        return rostmi;

    }


    public void ozbekTiliOrnat(){
        if (ornatuvchi.ozbekTiliOrnat()){
            firstName.setText("Ism");
            lastName.setText("Familiya");
            username.setText("Foydalanuvch Nomi");
            email.setText("Email");
            password.setText("Parol");
            confipass.setText("Parolni Tasdiqlang");
        }
    }
    public void rusTiliOrnat(){
        firstName.setText("Имя*");
        lastName.setText("Фамилия*");
        username.setText("Имя Ползавателя*");
        email.setText("Э-маил*");
        password.setText("Парол*");
        confipass.setText("Подвертить Парол*");

    }
    public void inglizTiliOrnat(){
        firstName.setText("First Name*");
        lastName.setText("Last Name*");
        username.setText("Username*");
        email.setText("Email*");
        password.setText("Password*");
        confipass.setText("Conifrm Password*");
    }


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SignUpOyna(new Main(),new TilOrnatuvchi(new Main()));
            }
        });
    }
}
