package com.company;

import com.mysql.cj.Query;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import com.mysql.cj.x.protobuf.MysqlxPrepare;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class ConnectionDB {
    SignUpOyna oyna;
    LoginOyna loginOyna;
    Connection con;
    PreparedStatement statement;
    Query query;
    MysqlxCrud.Update update;
   // MysqlxPrepare.Execute execute;

    public ConnectionDB(SignUpOyna oyna, LoginOyna loginOyna) {
        this.oyna = oyna;
        this.loginOyna = loginOyna;

    }

    public void DB_Connect() {
        String url = "INSERT INTO `gullar`(`Ism`, `Familya`, `Username`, `Email`, `Password`, `Conifrm Password`)  VALUES (?,?,?,?,?,?)";
            oyna.signButton.addActionListener(hodisa -> {
                boolean qanaqa = oyna.rostlikkaTekshir();
                    try {
//                      con = DriverManager.getConnection("jdbc:mysql://localhost/talabalar", "root", "");
//                    statement = con.prepareStatement(url);
//                    statement.setString(1, oyna.txtFirst.getText());
//                    statement.setString(2, oyna.txtLast.getText());
//                    statement.setString(3, oyna.txtUser.getText());
//                    statement.setString(4, oyna.txtEmail.getText());
//                    statement.setString(5, oyna.txtPass.getText());
//                    statement.setString(6, oyna.txtConfiPass.getText());
                        if (qanaqa) {
                            oyna.success.setText("Login Successfully");
                            oyna.success.setFont(new Font("Tahoma", 0, 14));
                            oyna.success.setForeground(Color.ORANGE.brighter());
                            //statement.executeQuery();
                            new asosiyOyna().setVisible(true);

                        } else {
                            oyna.success.setText("Yulduzchali maydonlarni to'ldiring");
                            oyna.success.setForeground(Color.RED);
                            oyna.success.setFont(new Font("Arial", 0, 12));
                            oyna.success.setRequestFocusEnabled(true);
                        }
                          //  JOptionPane.showMessageDialog(null,"Ma'lumotlar Bazaga Joylandi");
                    } catch (Exception e) {
                        //JOptionPane.showMessageDialog(null,e.getMessage());
                       e.printStackTrace();
                    }

            });
    }
}
