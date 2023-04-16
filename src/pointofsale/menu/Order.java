/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pointofsale.menu;

import UI.Message.Message2;
import UI.Message.Message3;
import UI.Message.Message5;
import goods.*;
import pointofsale.menu.*;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javaswingdev.drawer.Drawer;
import javaswingdev.drawer.DrawerController;
import javaswingdev.drawer.DrawerItem;
import javaswingdev.drawer.EventDrawer;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pointofsale.admin.Admin;
import user.Login;


public class Order extends javax.swing.JFrame {
    Connection c1;
    Statement s1;
    ResultSet r1;
    
    private DrawerController drawer;
    public Order() {
        initComponents();
        LoadOrder();
        init();
        setBackground(new Color(0,0,0,0));
    }
    
    public void LoadOrder(){
         try{
          Class.forName("com.mysql.cj.jdbc.Driver");
         c1 = DriverManager.getConnection("jdbc:mysql://localhost/warehouse","root", "0F3E71E5");
         s1 = c1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
         r1 = s1.executeQuery("Select * from curorder");
         int rec=0;
         while(r1.next()){
             rec++;
         }
         String[][] datatable = new String[rec][11];
         String[] head = {"CurID", "ProID", "Name", "Unit", "SupID", "Price", "Amount", "Total", "Discount", "Order", "Sent"};
         int count=0;
         r1.first();  
         datatable[count][0] = r1.getString("cur_id");
         datatable[count][1] = r1.getString("p_id");
         datatable[count][2] = r1.getString("p_name");
         datatable[count][3] = r1.getString("id_unit");
         datatable[count][4] = r1.getString("sp_id");
         datatable[count][5] = r1.getString("price");
         datatable[count][6] = r1.getString("cur_amount");
         datatable[count][7] = r1.getString("total_price");
         datatable[count][8] = r1.getString("cur_discount");
         datatable[count][9] = r1.getString("date_order");
         datatable[count][10] = r1.getString("date_sent");
         count++;
         while (r1.next()){
             datatable[count][0] = r1.getString("cur_id");
            datatable[count][1] = r1.getString("p_id");
            datatable[count][2] = r1.getString("p_name");
            datatable[count][3] = r1.getString("id_unit");
            datatable[count][4] = r1.getString("sp_id");
            datatable[count][5] = r1.getString("price");
            datatable[count][6] = r1.getString("cur_amount");
            datatable[count][7] = r1.getString("total_price");
            datatable[count][8] = r1.getString("cur_discount");
            datatable[count][9] = r1.getString("date_order");
            datatable[count][10] = r1.getString("date_sent");
             count++;
         }
          Table.setModel(new javax.swing.table.DefaultTableModel(datatable,head));
        }catch(Exception e){
                Message2 myapp  = new Message2();
                myapp.setVisible(true);
        }
    }

     public void Search(){
         try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                c1 = DriverManager.getConnection("jdbc:mysql://localhost/warehouse", "root", "0F3E71E5");
                s1 = c1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                r1= s1.executeQuery("Select * from curorder where cur_id="+Integer.parseInt(FormSearch.getText()));
                int rec=0;
                while(r1.next()){
                    rec++;
                }
                String[][] datatable = new String[rec][11];
                String[] head = {"CurID", "P_ID", "Name", "Unit", "SpID", "Price", "Amount", "TotalPrice", "Discount", "Date Order", "Date Sent"};
                int count=0;
                r1.first();  
                datatable[count][0] = r1.getString("cur_id");
                datatable[count][1] = r1.getString("p_id");
                datatable[count][2] = r1.getString("p_name");
                datatable[count][3] = r1.getString("id_unit");
                datatable[count][4] = r1.getString("sp_id");
                datatable[count][5] = r1.getString("price");
                datatable[count][6] = r1.getString("cur_amount");
                datatable[count][7] = r1.getString("total_price");
                datatable[count][8] = r1.getString("cur_discount");
                datatable[count][9] = r1.getString("date_order");
                datatable[count][10] = r1.getString("date_sent");
                count++;
                while (r1.next()){
                    datatable[count][0] = r1.getString("cur_id");
                   datatable[count][1] = r1.getString("p_id");
                   datatable[count][2] = r1.getString("p_name");
                   datatable[count][3] = r1.getString("id_unit");
                   datatable[count][4] = r1.getString("sp_id");
                   datatable[count][5] = r1.getString("price");
                   datatable[count][6] = r1.getString("cur_amount");
                   datatable[count][7] = r1.getString("total_price");
                   datatable[count][8] = r1.getString("cur_discount");
                   datatable[count][9] = r1.getString("date_order");
                   datatable[count][10] = r1.getString("date_sent");
                    count++;
                }
                Table.setModel(new javax.swing.table.DefaultTableModel(datatable,head));
        }catch(Exception e){
                Message2 myapp  = new Message2();
                myapp.setVisible(true);
        }
    }

    private void init(){
        Table.fixTable(jScrollPane1);
    }
    
    private void Admin(){
        int A_ID=  Integer.parseInt(ID.getText());
        int AdminID = 40000;
        if( A_ID == AdminID ){
             Admin myapp  = new Admin();
             myapp.ID.setText(ID.getText());
             myapp.Username.setText(Username.getText());
             myapp.setVisible(true);
             this.dispose();  
        }else{
                Message3 myapp  = new Message3();
                myapp.setVisible(true);
         }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        panelColor3 = new UI.PanelColor();
        Username = new javax.swing.JLabel();
        ID = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        imageAvatar1 = new test.ImageAvatar();
        B5 = new javax.swing.JLabel();
        B6 = new javax.swing.JLabel();
        B7 = new javax.swing.JLabel();
        B1 = new javax.swing.JLabel();
        B2 = new javax.swing.JLabel();
        B9 = new javax.swing.JLabel();
        frameColor11 = new UI.FrameColor1();
        B4 = new javax.swing.JLabel();
        panelColor21 = new UI.PanelColor2();
        panelColor31 = new UI.PanelColor3();
        jLabel2 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        panelColor32 = new UI.PanelColor3();
        FormSearch = new UI.Table.TextFieldSuggestion();
        Button = new UI.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new UI.Table.Table();
        Button4 = new UI.Button();
        Button3 = new UI.Button();
        Button2 = new UI.Button();

        jLabel1.setFont(new java.awt.Font("TH SarabunPSK", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Javaswingdev.com");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Username.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Username.setForeground(new java.awt.Color(255, 255, 255));
        Username.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Username.setText(".");

        ID.setForeground(new java.awt.Color(255, 255, 255));
        ID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ID.setText(".");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Program/pos.png"))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Application");

        imageAvatar1.setBorderSize(3);
        imageAvatar1.setBorderSpace(2);
        imageAvatar1.setGradientColor1(new java.awt.Color(255, 0, 0));
        imageAvatar1.setGradientColor2(new java.awt.Color(27, 0, 255));
        imageAvatar1.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/Program/user1.png"))); // NOI18N

        B5.setBackground(new java.awt.Color(255, 255, 255));
        B5.setForeground(new java.awt.Color(255, 255, 255));
        B5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Program/icon4.png"))); // NOI18N
        B5.setText("   Stock");
        B5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        B5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B5MouseClicked(evt);
            }
        });

        B6.setBackground(new java.awt.Color(255, 255, 255));
        B6.setForeground(new java.awt.Color(255, 255, 255));
        B6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Program/icon5.png"))); // NOI18N
        B6.setText("   Admin");
        B6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        B6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B6MouseClicked(evt);
            }
        });

        B7.setBackground(new java.awt.Color(255, 255, 255));
        B7.setForeground(new java.awt.Color(255, 255, 255));
        B7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Program/exit.png"))); // NOI18N
        B7.setText("   Exit");
        B7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        B7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B7MouseClicked(evt);
            }
        });

        B1.setBackground(new java.awt.Color(255, 255, 255));
        B1.setForeground(new java.awt.Color(255, 255, 255));
        B1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Program/icon6.png"))); // NOI18N
        B1.setText("   Home");
        B1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        B1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B1MouseClicked(evt);
            }
        });

        B2.setBackground(new java.awt.Color(255, 255, 255));
        B2.setForeground(new java.awt.Color(255, 255, 255));
        B2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Program/icon2.png"))); // NOI18N
        B2.setText("   Selling");
        B2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        B2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B2MouseClicked(evt);
            }
        });

        B9.setBackground(new java.awt.Color(255, 255, 255));
        B9.setForeground(new java.awt.Color(255, 255, 255));
        B9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Program/icon3.png"))); // NOI18N
        B9.setText("   Product");
        B9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        B9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B9MouseClicked(evt);
            }
        });

        B4.setBackground(new java.awt.Color(255, 255, 255));
        B4.setForeground(new java.awt.Color(255, 255, 255));
        B4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Program/icon1.png"))); // NOI18N
        B4.setText("   Order");
        B4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout frameColor11Layout = new javax.swing.GroupLayout(frameColor11);
        frameColor11.setLayout(frameColor11Layout);
        frameColor11Layout.setHorizontalGroup(
            frameColor11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frameColor11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(B4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );
        frameColor11Layout.setVerticalGroup(
            frameColor11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frameColor11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(B4)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelColor3Layout = new javax.swing.GroupLayout(panelColor3);
        panelColor3.setLayout(panelColor3Layout);
        panelColor3Layout.setHorizontalGroup(
            panelColor3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelColor3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel12))
            .addGroup(panelColor3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelColor3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelColor3Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelColor3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(B1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelColor3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(B2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelColor3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(B9))
            .addGroup(panelColor3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(frameColor11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelColor3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(B5, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelColor3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(B6, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelColor3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(B7, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelColor3Layout.setVerticalGroup(
            panelColor3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelColor3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelColor3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelColor3Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(ID)
                .addGap(18, 18, 18)
                .addComponent(B1)
                .addGap(18, 18, 18)
                .addComponent(B2)
                .addGap(18, 18, 18)
                .addComponent(B9)
                .addGap(12, 12, 12)
                .addComponent(frameColor11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(B5)
                .addGap(18, 18, 18)
                .addComponent(B6)
                .addGap(39, 39, 39)
                .addComponent(B7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(panelColor3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 500));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Order");

        jLabel18.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Program/icon8.png"))); // NOI18N
        jLabel18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Program/icon7.png"))); // NOI18N
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelColor31Layout = new javax.swing.GroupLayout(panelColor31);
        panelColor31.setLayout(panelColor31Layout);
        panelColor31Layout.setHorizontalGroup(
            panelColor31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelColor31Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        panelColor31Layout.setVerticalGroup(
            panelColor31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        FormSearch.setFont(new java.awt.Font("TH SarabunPSK", 0, 18)); // NOI18N

        Button.setBackground(new java.awt.Color(0, 167, 185));
        Button.setForeground(new java.awt.Color(255, 255, 255));
        Button.setText("Search");
        Button.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonActionPerformed(evt);
            }
        });

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Table.setFont(new java.awt.Font("TH SarabunPSK", 1, 15)); // NOI18N
        jScrollPane1.setViewportView(Table);

        Button4.setBackground(new java.awt.Color(0, 129, 167));
        Button4.setForeground(new java.awt.Color(255, 255, 255));
        Button4.setText("Inventory");
        Button4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button4ActionPerformed(evt);
            }
        });

        Button3.setBackground(new java.awt.Color(0, 167, 185));
        Button3.setForeground(new java.awt.Color(255, 255, 255));
        Button3.setText("Add Order");
        Button3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button3ActionPerformed(evt);
            }
        });

        Button2.setBackground(new java.awt.Color(240, 113, 103));
        Button2.setForeground(new java.awt.Color(255, 255, 255));
        Button2.setText("Delete");
        Button2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelColor32Layout = new javax.swing.GroupLayout(panelColor32);
        panelColor32.setLayout(panelColor32Layout);
        panelColor32Layout.setHorizontalGroup(
            panelColor32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelColor32Layout.createSequentialGroup()
                .addGroup(panelColor32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelColor32Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(panelColor32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelColor32Layout.createSequentialGroup()
                                .addComponent(FormSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Button, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelColor32Layout.createSequentialGroup()
                                .addComponent(Button2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(370, 370, 370)
                                .addComponent(Button3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Button4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelColor32Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        panelColor32Layout.setVerticalGroup(
            panelColor32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelColor32Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelColor32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FormSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelColor32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelColor21Layout = new javax.swing.GroupLayout(panelColor21);
        panelColor21.setLayout(panelColor21Layout);
        panelColor21Layout.setHorizontalGroup(
            panelColor21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelColor21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelColor31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelColor21Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(panelColor32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );
        panelColor21Layout.setVerticalGroup(
            panelColor21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelColor21Layout.createSequentialGroup()
                .addComponent(panelColor31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelColor32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        getContentPane().add(panelColor21, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 740, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        this.setExtendedState(Order.ICONIFIED);
    }//GEN-LAST:event_jLabel18MouseClicked

    private void B1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B1MouseClicked
       Home myapp  = new Home();
       myapp.setVisible(true);
       myapp.ID.setText(ID.getText());
       myapp.Username.setText(Username.getText());
       this.dispose();
    }//GEN-LAST:event_B1MouseClicked

    private void B2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B2MouseClicked
       Selling myapp  = new Selling();
       myapp.setVisible(true);
       myapp.ID.setText(ID.getText());
       myapp.Username.setText(Username.getText());
       this.dispose();
    }//GEN-LAST:event_B2MouseClicked

    private void B9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B9MouseClicked
       Product myapp  = new Product();
       myapp.setVisible(true);
       myapp.ID.setText(ID.getText());
       myapp.Username.setText(Username.getText());
       this.dispose();
    }//GEN-LAST:event_B9MouseClicked

    private void ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonActionPerformed
        Search();
    }//GEN-LAST:event_ButtonActionPerformed

    private void Button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button4ActionPerformed
       Inventory myapp  = new Inventory();
       myapp.setVisible(true);
       myapp.ID.setText(ID.getText());
       myapp.Username.setText(Username.getText());
       this.dispose();
    }//GEN-LAST:event_Button4ActionPerformed

    private void Button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button3ActionPerformed
       AddOrder myapp  = new AddOrder();
       myapp.setVisible(true);
       myapp.ID.setText(ID.getText());
       myapp.Username.setText(Username.getText());
       this.dispose();
    }//GEN-LAST:event_Button3ActionPerformed

    private void Button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button2ActionPerformed
         String cur_id = Table.getValueAt(Table.getSelectedRow(), 0).toString();
         Connection c1 = null;
         try{
            try{
                c1 = DriverManager.getConnection("jdbc:mysql://localhost/warehouse", "root", "0F3E71E5");
                String sql = "DELETE FROM curorder WHERE cur_id="+cur_id;
                PreparedStatement preparedStmt = c1.prepareStatement(sql);
                c1.setAutoCommit(false);
                preparedStmt.execute();
            }catch (SQLException e) {
                Message2 myapp  = new Message2();
                myapp.setVisible(true);
            }
            c1.commit();
            c1.close();
           Message5 myapp  = new Message5();
            myapp.setVisible(true);
            DefaultTableModel model = (DefaultTableModel) Table.getModel();
            model.setRowCount(0);
            LoadOrder();
            }catch(Exception e) {
                Message2 myapp  = new Message2();
                myapp.setVisible(true);
            try{
                c1.rollback();
            }catch(Exception e1){
                Message2 myapp2  = new Message2();
                myapp2.setVisible(true);
            }
       }        
    }//GEN-LAST:event_Button2ActionPerformed

    private void B5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B5MouseClicked
       Stock myapp  = new Stock();
       myapp.setVisible(true);
       myapp.ID.setText(ID.getText());
       myapp.Username.setText(Username.getText());
       this.dispose();
    }//GEN-LAST:event_B5MouseClicked

    private void B7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B7MouseClicked
       Login Login  = new Login();
       Login.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_B7MouseClicked

    private void B6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B6MouseClicked
       Admin();
    }//GEN-LAST:event_B6MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Order().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel B1;
    private javax.swing.JLabel B2;
    private javax.swing.JLabel B4;
    private javax.swing.JLabel B5;
    private javax.swing.JLabel B6;
    private javax.swing.JLabel B7;
    private javax.swing.JLabel B9;
    private UI.Button Button;
    private UI.Button Button2;
    private UI.Button Button3;
    private UI.Button Button4;
    private UI.Table.TextFieldSuggestion FormSearch;
    public static transient javax.swing.JLabel ID;
    private UI.Table.Table Table;
    public static transient javax.swing.JLabel Username;
    private UI.FrameColor1 frameColor11;
    public static transient test.ImageAvatar imageAvatar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private UI.PanelColor2 panelColor21;
    private UI.PanelColor panelColor3;
    private UI.PanelColor3 panelColor31;
    private UI.PanelColor3 panelColor32;
    // End of variables declaration//GEN-END:variables

}
