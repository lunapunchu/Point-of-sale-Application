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
import java.text.SimpleDateFormat;
import java.util.Date;
import javaswingdev.drawer.Drawer;
import javaswingdev.drawer.DrawerController;
import javaswingdev.drawer.DrawerItem;
import javaswingdev.drawer.EventDrawer;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pointofsale.Get.GetProduct;
import pointofsale.Get.GetUnit;
import pointofsale.admin.Admin;
import user.Login;


public class Inventory2 extends javax.swing.JFrame {
    Connection c1;
    Statement s1;
    ResultSet r1;
    Connection c2;
    Statement s2;
    ResultSet r2;
     Connection c3;
    Statement s3;
    ResultSet r3;
    
    private DrawerController drawer;
    public Inventory2() {
        initComponents();
        init();
        LoadOrder();
        LoadStock();
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
         String[] head = {"CurID", "P_ID", "Name", "Unit", "SpID", "Price", "Amount", "TotalPrice", "Discount", "Date Order", "Date Sent"};
         int count=0;
         r1.first();  
         datatable[count][0] = r1.getString("cur_id");
         datatable[count][1] =r1.getString("p_id");
         datatable[count][2] =r1.getString("p_name");
         datatable[count][3] =r1.getString("id_unit");
         datatable[count][4] =r1.getString("sp_id");
         datatable[count][5] =r1.getString("price");
         datatable[count][6] =r1.getString("cur_amount");
         datatable[count][7] =r1.getString("total_price");
         datatable[count][8] =r1.getString("cur_discount");
         datatable[count][9] =r1.getString("date_order");
         datatable[count][10] =r1.getString("date_sent");
         count++;
         while (r1.next()){
             datatable[count][0] = r1.getString("cur_id");
            datatable[count][1] =r1.getString("p_id");
            datatable[count][2] =r1.getString("p_name");
            datatable[count][3] =r1.getString("id_unit");
            datatable[count][4] =r1.getString("sp_id");
            datatable[count][5] =r1.getString("price");
            datatable[count][6] =r1.getString("cur_amount");
            datatable[count][7] =r1.getString("total_price");
            datatable[count][8] =r1.getString("cur_discount");
            datatable[count][9] =r1.getString("date_order");
            datatable[count][10] =r1.getString("date_sent");
             count++;
         }
         
          Table1.setModel(new javax.swing.table.DefaultTableModel(datatable,head));
        }catch(Exception e){
                Message2 myapp  = new Message2();
                myapp.setVisible(true);
        }
    }
    public void LoadStock(){
        try{
          Class.forName("com.mysql.cj.jdbc.Driver");
         c1 = DriverManager.getConnection("jdbc:mysql://localhost/warehouse","root", "0F3E71E5");
         s1 = c1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
         r1 = s1.executeQuery("Select * from stock");
         int rec=0;
         while(r1.next()){
             rec++;
         }
         
         String[][] datatable = new String[rec][7];
         String[] head = {"StockID", "ProductID", "Name", "Unit", "SupplierID", "Price", "Amount"};
         int count=0;
         r1.first();  
         datatable[count][0] = r1.getString("st_id");
         datatable[count][1] =r1.getString("p_id");
         datatable[count][2] =r1.getString("p_name");
         datatable[count][3] =r1.getString("id_unit");
         datatable[count][4] =r1.getString("sp_id");
         datatable[count][5] =r1.getString("price");
         datatable[count][6] =r1.getString("amount");
         count++;
         while (r1.next()){
             datatable[count][0] = r1.getString("st_id");
            datatable[count][1] =r1.getString("p_id");
            datatable[count][2] =r1.getString("p_name");
            datatable[count][3] =r1.getString("id_unit");
            datatable[count][4] =r1.getString("sp_id");
            datatable[count][5] =r1.getString("price");
            datatable[count][6] =r1.getString("amount");
             count++;
         }
         
          Table2.setModel(new javax.swing.table.DefaultTableModel(datatable,head));
        }catch(Exception e){
                Message2 myapp  = new Message2();
                myapp.setVisible(true);
        }
    }
    
   private void init(){
        Table1.fixTable(jScrollPane1);
        Table2.fixTable(jScrollPane2);
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
        B6 = new javax.swing.JLabel();
        B7 = new javax.swing.JLabel();
        B1 = new javax.swing.JLabel();
        B2 = new javax.swing.JLabel();
        B9 = new javax.swing.JLabel();
        B4 = new javax.swing.JLabel();
        frameColor11 = new UI.FrameColor1();
        B5 = new javax.swing.JLabel();
        panelColor21 = new UI.PanelColor2();
        panelColor31 = new UI.PanelColor3();
        jLabel2 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        arrow = new javax.swing.JLabel();
        panelColor32 = new UI.PanelColor3();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table1 = new UI.Table.Table();
        panelColor33 = new UI.PanelColor3();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table2 = new UI.Table.Table();
        Button = new UI.Button();

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

        B5.setBackground(new java.awt.Color(255, 255, 255));
        B5.setForeground(new java.awt.Color(255, 255, 255));
        B5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Program/icon4.png"))); // NOI18N
        B5.setText("   Stock");
        B5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout frameColor11Layout = new javax.swing.GroupLayout(frameColor11);
        frameColor11.setLayout(frameColor11Layout);
        frameColor11Layout.setHorizontalGroup(
            frameColor11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frameColor11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(B5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );
        frameColor11Layout.setVerticalGroup(
            frameColor11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frameColor11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(B5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(19, 19, 19)
                .addComponent(B4))
            .addGroup(panelColor3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(frameColor11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(18, 18, 18)
                .addComponent(B4)
                .addGap(14, 14, 14)
                .addComponent(frameColor11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(B6)
                .addGap(39, 39, 39)
                .addComponent(B7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(panelColor3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 500));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Inventory");

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

        arrow.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        arrow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        arrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Program/arrorw.png"))); // NOI18N
        arrow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        arrow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                arrowMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelColor31Layout = new javax.swing.GroupLayout(panelColor31);
        panelColor31.setLayout(panelColor31Layout);
        panelColor31Layout.setHorizontalGroup(
            panelColor31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelColor31Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(arrow, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        panelColor31Layout.setVerticalGroup(
            panelColor31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelColor31Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(arrow, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Table1.setModel(new javax.swing.table.DefaultTableModel(
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
        Table1.setFont(new java.awt.Font("TH SarabunPSK", 1, 15)); // NOI18N
        jScrollPane2.setViewportView(Table1);

        javax.swing.GroupLayout panelColor32Layout = new javax.swing.GroupLayout(panelColor32);
        panelColor32.setLayout(panelColor32Layout);
        panelColor32Layout.setHorizontalGroup(
            panelColor32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelColor32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        panelColor32Layout.setVerticalGroup(
            panelColor32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelColor32Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        Table2.setModel(new javax.swing.table.DefaultTableModel(
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
        Table2.setFont(new java.awt.Font("TH SarabunPSK", 1, 15)); // NOI18N
        jScrollPane1.setViewportView(Table2);

        javax.swing.GroupLayout panelColor33Layout = new javax.swing.GroupLayout(panelColor33);
        panelColor33.setLayout(panelColor33Layout);
        panelColor33Layout.setHorizontalGroup(
            panelColor33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelColor33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelColor33Layout.setVerticalGroup(
            panelColor33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelColor33Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        Button.setBackground(new java.awt.Color(240, 113, 103));
        Button.setForeground(new java.awt.Color(255, 255, 255));
        Button.setText("Move Order to Stock");
        Button.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelColor21Layout = new javax.swing.GroupLayout(panelColor21);
        panelColor21.setLayout(panelColor21Layout);
        panelColor21Layout.setHorizontalGroup(
            panelColor21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelColor21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelColor31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelColor21Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelColor21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelColor32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelColor33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 13, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelColor21Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Button, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(289, 289, 289))
        );
        panelColor21Layout.setVerticalGroup(
            panelColor21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelColor21Layout.createSequentialGroup()
                .addComponent(panelColor31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelColor32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(panelColor33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        getContentPane().add(panelColor21, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 740, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        this.setExtendedState(Inventory2.ICONIFIED);
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

    private void arrowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_arrowMouseClicked
        Stock myapp  = new Stock();
        myapp.setVisible(true);
        myapp.ID.setText(ID.getText());
        myapp.Username.setText(Username.getText());
        this.dispose();
    }//GEN-LAST:event_arrowMouseClicked

    private void ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonActionPerformed
        String cur_id = Table1.getValueAt(Table1.getSelectedRow(), 0).toString();
        String p_id = Table1.getValueAt(Table1.getSelectedRow(), 1).toString();
        String p_name = Table1.getValueAt(Table1.getSelectedRow(), 2).toString();
        String id_unit = Table1.getValueAt(Table1.getSelectedRow(),3).toString();
        String sp_id = Table1.getValueAt(Table1.getSelectedRow(), 4).toString();
        String price = Table1.getValueAt(Table1.getSelectedRow(), 5).toString();
        String cur_amount = Table1.getValueAt(Table1.getSelectedRow(), 6).toString();
        String total_price = Table1.getValueAt(Table1.getSelectedRow(), 7).toString();
        String cur_discount = Table1.getValueAt(Table1.getSelectedRow(), 8).toString();
        String data_order = Table1.getValueAt(Table1.getSelectedRow(), 9).toString();
        String date_sent = Table1.getValueAt(Table1.getSelectedRow(), 10).toString();
        
        //Charge
         int id = Integer.parseInt( Table1.getValueAt(Table1.getSelectedRow(), 1).toString());
         Connection c1 = null, c2 = null, c3 = null;
         int idOrder = Integer.parseInt(Table1.getValueAt(Table1.getSelectedRow(), 6).toString());
         int idStock = Integer.parseInt(Table2.getValueAt(id, 6).toString());
         idStock = idStock - idOrder; 
         float total_price2 = Float.parseFloat(Table1.getValueAt(Table1.getSelectedRow(), 7).toString());
         
         //Update Stock
         try{
             try {
                c1 = DriverManager.getConnection("jdbc:mysql://localhost/warehouse", "root", "0F3E71E5");
                c1.setAutoCommit(false);        
                    String sql = "update warehouse.stock SET amount ="+ idStock +
                        " WHERE p_id="+Integer.parseInt(Table1.getValueAt(Table1.getSelectedRow(), 1).toString());
                    PreparedStatement preparedStmt = c1.prepareStatement(sql);
                    preparedStmt.executeUpdate();
               c3 = DriverManager.getConnection("jdbc:mysql://localhost/sellingdb", "root", "0F3E71E5");
               s3 = c3.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
               r3 = s3.executeQuery("Select * from budget");
               r3.next();
               float money =  Float.parseFloat(r3.getString("money"));
               money = money + total_price2;
               String sql2 = "update sellingdb.budget SET money ="+ money + " WHERE id="+ 1;
               PreparedStatement preparedStmt2 = c3.prepareStatement(sql2);
               preparedStmt2.executeUpdate();
               c1.commit();
            } catch (Exception e1) {
                Message2 myapp  = new Message2();
                myapp.setVisible(true);
            }
            
             //Delete Order
            try{
                c2 = DriverManager.getConnection("jdbc:mysql://localhost/warehouse", "root", "0F3E71E5");
                String sql2 = "DELETE FROM curorder WHERE cur_id="+cur_id;
                PreparedStatement preparedStmt2 = c2.prepareStatement(sql2);
                c2.setAutoCommit(false);
                preparedStmt2.execute();
            }catch (SQLException e1) {
                Message2 myapp  = new Message2();
                myapp.setVisible(true);
            }
            c2.commit();
            c2.close();
           Message5 myapp  = new Message5();
            myapp.setVisible(true);
            DefaultTableModel model = (DefaultTableModel) Table1.getModel();
            DefaultTableModel model2 = (DefaultTableModel) Table2.getModel();
            model.setRowCount(0);
            model2.setRowCount(0);
            LoadOrder();
            LoadStock();
            }catch(Exception e) {
                Message2 myapp  = new Message2();
                myapp.setVisible(true);
            try{
                c2.rollback();
            }catch(Exception e1){
                Message2 myapp2  = new Message2();
                myapp2.setVisible(true);
            }
       }
    }//GEN-LAST:event_ButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Inventory2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventory2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventory2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventory2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new Inventory2().setVisible(true);
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
    public static transient javax.swing.JLabel ID;
    private UI.Table.Table Table1;
    private UI.Table.Table Table2;
    public static transient javax.swing.JLabel Username;
    private javax.swing.JLabel arrow;
    private UI.FrameColor1 frameColor11;
    public static transient test.ImageAvatar imageAvatar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private UI.PanelColor2 panelColor21;
    private UI.PanelColor panelColor3;
    private UI.PanelColor3 panelColor31;
    private UI.PanelColor3 panelColor32;
    private UI.PanelColor3 panelColor33;
    // End of variables declaration//GEN-END:variables

}
