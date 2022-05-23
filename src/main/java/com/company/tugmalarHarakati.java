package com.company;

import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.input.MapClickListener;
import org.jxmapviewer.viewer.GeoPosition;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class tugmalarHarakati extends JXMapViewer implements ActionListener {

    asosiyOyna oyna;
    MapClickListener mapClickListener=new MapClickListener() {
        @Override
        public void mapClicked(GeoPosition geoPosition) {
            
        }
    };



    public tugmalarHarakati(asosiyOyna oyna) {
        this.oyna = oyna;
    }

    public void taksidaBorish(){
        oyna.btnTaxi.addActionListener(hodisa->{

        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(oyna.btnTaxi)){
            int x;
            x= JOptionPane.showConfirmDialog(null,"Joylashuv " +
                    "ma'lumotlaringizni yuborishga rozimisiz?");
            if (x==JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(null,"Biz map plaginlarini keyingi versiyada qo'shamiz");
            }
        }else if (e.getSource().equals(oyna.btnPiyoda)){
            JOptionPane.showMessageDialog(null,"Sizga maroqli sayohat tilaymiz");
        }
    }
}
