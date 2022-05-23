package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MatnlarToplami {

    public String Registon(){
        String matn = null;
        try {
            Scanner scanner=new Scanner(new File("Malumotlar/registon.txt"));
            while (scanner.hasNext()){
               matn= scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return matn;
    }
    public String GoriAmir(){
        String matn = null;
        try {
            Scanner scanner=new Scanner(new File("Malumotlar/guriamir.txt"));
            while (scanner.hasNext()){
                matn= scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return matn;
    }
    public String ShoxiZinda(){
        String matn = null;
        try {
            Scanner scanner=new Scanner(new File("Malumotlar/shoxizinda.txt"));
            while (scanner.hasNext()){
                matn= scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return matn;
    }
    public String BibiXonim(){
        String matn = null;
        try {
            Scanner scanner=new Scanner(new File("Malumotlar/bibxonim.txt"));
            while (scanner.hasNext()){
                matn= scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return matn;
    }
    public String Ulugbek(){
        String matn;
        return "";
    }

    public static void main(String[] args) {
        File file=new File("Malumotlar");
        file.mkdir();
        File file1=new File("Malumotlar/ulugbek.txt");
        try {
            file1.createNewFile();
        }catch (Exception e){

        }
    }
}
