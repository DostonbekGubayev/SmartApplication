package com.company;

import model.MatnlarToplami;
import model.ObidalarRasmlari;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.beans.JavaBean;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Brauzer extends JFrame implements ActionListener {
    JEditorPane editorPane;
    Timer timer_registon,timer_shoxizinda,timer_goriamir,timer_bibixonim,timer_ulugbek;
    JTextField field;
    JButton button;
    JavaBean javaBean;
    String webManzil;
    URL sahifa;
    asosiyOyna oyna;
    int x = 0;
   ObidalarRasmlari obidalar=new ObidalarRasmlari(oyna);
   MatnlarToplami toplam=new MatnlarToplami();

    public Brauzer(asosiyOyna oyna) {
        this.oyna = oyna;
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        //  setVisible(true);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        field = new JTextField();
        add(field, BorderLayout.NORTH);
        editorPane = new JEditorPane();
        add(editorPane, BorderLayout.CENTER);
        timer_bibixonim=new Timer(2000,this);
        timer_registon=new Timer(2000,this);
        timer_shoxizinda=new Timer(2000,this);
        timer_goriamir=new Timer(2000,this);
        timer_ulugbek=new Timer(2000,this);

    }

    public void obidaOrbatuvchi(ItemEvent event) {
        if (Objects.equals(oyna.historicalBox.getSelectedItem(), "Other...")) {
            oyna.matnYozuvchi.setText("Qalaysiz");

        } if (oyna.historicalBox.getSelectedItem().equals("BibiXonim")) {

            bibxonim();
            timer_bibixonim.start();
            timer_registon.stop();
            timer_goriamir.stop();
            timer_shoxizinda.stop();
            //timer_ulugbek.stop();

        }  if (oyna.historicalBox.getSelectedItem().equals("Go'ri Amir")) {
               Amir();
            timer_bibixonim.stop();
            timer_registon.stop();
            timer_goriamir.start();
            timer_shoxizinda.stop();
            //timer_ulugbek.stop();
            } if (oyna.historicalBox.getSelectedItem().equals("Registon")) {
                registon();
            timer_bibixonim.stop();
            timer_registon.start();
            timer_goriamir.stop();
            timer_shoxizinda.stop();
            //timer_ulugbek.stop();
            }if (oyna.historicalBox.getSelectedItem().equals("Shoxi Zinda")) {
                shoxizinda();
            timer_bibixonim.stop();
            timer_registon.stop();
            timer_goriamir.stop();
            timer_shoxizinda.start();
            //timer_ulugbek.stop();
            }

        }

    public void registonOrnat(int i){
        ImageIcon imageIcon=new ImageIcon(obidalar.registon[i]);
        Image image=imageIcon.getImage();
        Image yangiImage=image.getScaledInstance(oyna.yangiLabel.getWidth(),oyna.yangiLabel.getHeight(),Image.SCALE_REPLICATE);
        ImageIcon icon=new ImageIcon(yangiImage);
        oyna.yangiLabel.setIcon(icon);

    }
    public void registon(){
        timer_registon=new Timer(2000,hodisa->{
           registonOrnat(x);
           x++;
            if (x>=obidalar.registon.length){
             x=0;
            }
        });
        oyna.matnYozuvchi.setText(toplam.Registon());
    }

    public void GuriAmirOrnat(int i){
        ImageIcon imageIcon=new ImageIcon(obidalar.guriAmir[i]);
        Image image=imageIcon.getImage();
        Image yangiImage=image.getScaledInstance(oyna.yangiLabel.getWidth(),oyna.yangiLabel.getHeight(),Image.SCALE_REPLICATE);
        ImageIcon icon=new ImageIcon(yangiImage);
        oyna.yangiLabel.setIcon(icon);
    }
    public void Amir(){
        timer_goriamir=new Timer(2500,hodisa->{
           GuriAmirOrnat(x);
            x++;
            if (x>=obidalar.registon.length){
                x=0;
            }
        });
        timer_goriamir.start();
        oyna.matnYozuvchi.setText(toplam.GoriAmir());
    }

    public void BibiXonim(int i){
        ImageIcon imageIcon=new ImageIcon(obidalar.bibixonim[i]);
        Image image=imageIcon.getImage();
        Image yangiImage=image.getScaledInstance(oyna.yangiLabel.getWidth(),oyna.yangiLabel.getHeight(),Image.SCALE_REPLICATE);
        ImageIcon icon=new ImageIcon(yangiImage);
        oyna.yangiLabel.setIcon(icon);
    }
    public  void bibxonim(){
        timer_bibixonim=new Timer(2500,hodisa->{
            BibiXonim(x);
            x++;
            if (x>=obidalar.bibixonim.length){
                x=0;
            }
        });
       timer_bibixonim.start();
        oyna.matnYozuvchi.setText(toplam.BibiXonim());
    }
    public void ShoxiZinda(int i){
        ImageIcon imageIcon=new ImageIcon(obidalar.shoxizinda[i]);
        Image image=imageIcon.getImage();
        Image yangiImage=image.getScaledInstance(oyna.yangiLabel.getWidth(),oyna.yangiLabel.getHeight(),Image.SCALE_REPLICATE);
        ImageIcon icon=new ImageIcon(yangiImage);
        oyna.yangiLabel.setIcon(icon);
    }
    public  void shoxizinda(){
        timer_shoxizinda=new Timer(2500,hodisa->{
            ShoxiZinda(x);
            x++;
            if (x>=obidalar.bibixonim.length){
                x=0;
            }
        });
       timer_shoxizinda.start();
        oyna.matnYozuvchi.setText(toplam.ShoxiZinda());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}