package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

public class asosiyOyna extends JFrame {
    JPanel panelBosh;
    JPanel panelPastki;
    JPanel panelChetgi;
    JButton btnTaxi,btnPiyoda;
    JLabel rasmLabel;
    public JLabel yangiLabel;
    JLabel tanlangan;
    public JTextArea matnYozuvchi;
    public Timer timer;
    String[] obidalar={"Registon","Go'ri Amir","Shoxi Zinda","BibiXonim","Other..."};

    JComboBox<String> historicalBox;
    JComboBox<String> hotelBox;
    Brauzer brauzer;
    tugmalarHarakati harakat=new tugmalarHarakati(this);
    JScrollPane pane=new JScrollPane();
    int x=0;
    String[] list ={
            "src/ShaxarRasmlari/rasmlar/korinishi.jpg","src/ShaxarRasmlari/rasmlar/registan.jpg",
            "src/ShaxarRasmlari/rasmlar/samarqand.jpg","src/ShaxarRasmlari/rasmlar/yoni.jpg",
            "src/ShaxarRasmlari/rasmlar/shoxizinda.jpg"
    };

    private final String[] hotels={"Bek","Amir Xan","Diyora","Other..."};

    public asosiyOyna(){
        {
            setTitle("Samarqand");
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            setVisible(true);
            setLocationRelativeTo(null);
            setSize(350, 630);
            setLayout(null);
            setResizable(false);
        }
        brauzer=new Brauzer(this);
        yangiLabel=new JLabel();
        yangiLabel.setBounds(0,0,140,140);

        matnYozuvchi=new JTextArea();
        matnYozuvchi.setText("Salom");

        pane.add(matnYozuvchi);
        //pane.createVerticalScrollBar();
        pane.setBounds(145,0,170,140);
           //  add(new JScrollPane(matnYozuvchi).createVerticalScrollBar());
        matnYozuvchi.setLineWrap(true);
        matnYozuvchi.setWrapStyleWord(true);
        matnYozuvchi.setEditable(false);
        Font font=new Font("Consolas",Font.ITALIC,14);
        tanlangan=new JLabel();
        tanlangan.setBounds(0,200,180,40);
        tanlangan.setFont(font);

        panelBosh=new JPanel();
        panelBosh.setBounds(0,0,350,630);
        panelBosh.setBackground(Color.GRAY.brighter());
        panelBosh.setLayout(null);
        add(panelBosh);

        rasmLabel=new JLabel();
        rasmLabel.setBounds(0,0,350,240);
        panelBosh.add(rasmLabel);
        timer=new Timer(2000,event->{
            rasmOrnat(x);
            x++;
            if (x>=list.length){
                x=0;
            }
        });
        timer.start();

        panelChetgi=new JPanel();
        panelChetgi.setBounds(0,240,350,160);
        panelChetgi.setBackground(new Color(0x111167).brighter());
        panelChetgi.setLayout(null);
        panelChetgi.add(tanlangan);
        panelBosh.add(panelChetgi);

        panelPastki=new JPanel();
        panelPastki.setLayout(null);
        panelPastki.setBounds(0,400,350,230);
        panelPastki.setBackground(new Color(0x056F83));

        btnTaxi=new JButton("Taxida Borish");
        btnTaxi.setBackground(new Color(0xCB0DE8));
        btnTaxi.setForeground(new Color(0x023425));
        btnTaxi.setBounds(10,150,150,30);
        btnTaxi.addActionListener(event-> harakat.actionPerformed(event));
        panelPastki.add(btnTaxi);

        btnPiyoda=new JButton("Piyoda Borish");
        btnPiyoda.setBounds(170,150,150,30);
        btnPiyoda.setBackground(new Color(0xCB0DE8));
        btnPiyoda.setForeground(new Color(0x023425));
        btnPiyoda.addActionListener(e -> harakat.actionPerformed(e));
        panelPastki.add(btnPiyoda);

        brauzer.registon();
        brauzer.timer_registon.start();
        panelPastki.add(yangiLabel);
        panelPastki.add(pane);
        panelBosh.add(panelPastki);

        obidaOrnatuvchi();
        //registonOrnat();
        historicalBox.addItemListener(event-> brauzer.obidaOrbatuvchi(event));


    }

    public void obidaOrnatuvchi(){
        historicalBox=new JComboBox<>(obidalar);
        historicalBox.setBounds(5,10,120,30);
        historicalBox.setEditable(true);
        historicalBox.addItemListener(this::handle);
        panelChetgi.add(historicalBox);

        hotelBox=new JComboBox<>(hotels);
        hotelBox.setBounds(135,10,100,30);
        panelChetgi.add(hotelBox);
    }

    public void handle(ItemEvent event){

        }


    public void rasmOrnat(int i){
        ImageIcon imageIcon=new ImageIcon(list[i]);
        Image image=imageIcon.getImage();
        Image yangiImage=image.getScaledInstance(350,240,Image.SCALE_REPLICATE);
        ImageIcon icon=new ImageIcon(yangiImage);
        rasmLabel.setIcon(icon);
    }
}
