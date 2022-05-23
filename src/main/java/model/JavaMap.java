package model;

import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.input.CenterMapListener;

import java.util.HashMap;
import java.util.Map;

public class JavaMap extends JXMapViewer {
    Map map;
    HashMap <String,Integer> hashMap;
    JXMapViewer mapViewer;
    CenterMapListener mapListener;
    public JavaMap(){
        mapListener=new CenterMapListener(this);
        hashMap.put("Salom",1);

    }

    public static void main(String[] args) {

    }
    
}
