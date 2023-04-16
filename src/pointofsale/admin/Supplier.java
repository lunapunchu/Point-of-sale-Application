/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pointofsale.admin;

import UI.Message.Message2;
import UI.Message.Message5;
import UI.Message.Message7;
import pointofsale.menu.*;
import goods.Product;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import javaswingdev.drawer.Drawer;
import javaswingdev.drawer.DrawerController;
import javaswingdev.drawer.DrawerItem;
import javaswingdev.drawer.EventDrawer;
import user.Login;


public class Supplier extends javax.swing.JFrame {
    Connection c1;
    Statement s1;
    ResultSet r1;
    
    private DrawerController drawer;
    public Supplier() {
        initComponents();
        LoadSupplier();
        init();
        setBackground(new Color(0,0,0,0));
    }

    public void LoadSupplier(){
         try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c1 = DriverManager.getConnection("jdbc:mysql://localhost/sellingdb","root", "0F3E71E5");
            s1 = c1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            r1 = s1.executeQuery("Select * from suporder");
            int rec=0;
            while(r1.next()){
                rec++;
            }
            String[][] datatable = new String[rec][7];
            String[] head = {"SupOrderID", "ProductID","Name", "SupplierID", "Price", "Amount", "TotalPrice"};
            int count=0;
            r1.first();  
            datatable[count][0] = r1.getString("spOrder_id");
            datatable[count][1] = r1.getString("p_id");
            datatable[count][2] = r1.getString("p_name");
            datatable[count][3] = r1.getString("sp_id");
            datatable[count][4] = r1.getString("price");
            datatable[count][5] = r1.getString("amount");
            datatable[count][6] = r1.getString("total_price");
            count++;
            while (r1.next()){
                    datatable[count][0] = r1.getString("spOrder_id");
                    datatable[count][1] = r1.getString("p_id");
                    datatable[count][2] = r1.getString("p_name");
                    datatable[count][3] = r1.getString("sp_id");
                    datatable[count][4] = r1.getString("price");
                    datatable[count][5] = r1.getString("amount");
                    datatable[count][6] = r1.getString("total_price");
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
                c1 = DriverManager.getConnection("jdbc:mysql://localhost/sellingdb", "root", "0F3E71E5");
                s1 = c1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                r1= s1.executeQuery("Select * from suporder where spOrder_id="+Integer.parseInt(FormSearch.getText()));
                int rec=0;
                while(r1.next()){
                    rec++;
                }
                String[][] datatable = new String[rec][7];
                String[] head = {"SupOrderID", "ProductID","Name", "SupplierID", "Price", "Amount", "TotalPrice"};
                int count=0;
                r1.first();  
                datatable[count][0] = r1.getString("spOrder_id");
                datatable[count][1] = r1.getString("p_id");
                datatable[count][2] = r1.getString("p_name");
                datatable[count][3] = r1.getString("sp_id");
                datatable[count][4] = r1.getString("price");
                datatable[count][5] = r1.getString("amount");
                datatable[count][6] = r1.getString("total_price");
                count++;
                while (r1.next()){
                        datatable[count][0] = r1.getString("spOrder_id");
                        datatable[count][1] = r1.getString("p_id");
                        datatable[count][2] = r1.getString("p_name");
                        datatable[count][3] = r1.getString("sp_id");
                        datatable[count][4] = r1.getString("price");
                        datatable[count][5] = r1.getString("amount");
                        datatable[count][6] = r1.getString("total_price");
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
        B3 = new javax.swing.JLabel();
        B5 = new javax.swing.JLabel();
        B7 = new javax.swing.JLabel();
        B8 = new javax.swing.JLabel();
        B9 = new javax.swing.JLabel();
        B2 = new javax.swing.JLabel();
        frameColor12 = new UI.FrameColor1();
        B4 = new javax.swing.JLabel();
        panelColor21 = new UI.PanelColor2();
        panelColor31 = new UI.PanelColor3();
        jLabel2 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        panelColor32 = new UI.PanelColor3();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new UI.Table.Table();
        FormSearch = new UI.Table.TextFieldSuggestion();
        Button = new UI.Button();
        Button4 = new UI.Button();
        Button5 = new UI.Button();
        Button6 = new UI.Button();

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

        B3.setBackground(new java.awt.Color(255, 255, 255));
        B3.setForeground(new java.awt.Color(255, 255, 255));
        B3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/program/icon18.png"))); // NOI18N
        B3.setText("   Dailysale");
        B3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        B3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B3MouseClicked(evt);
            }
        });

        B5.setBackground(new java.awt.Color(255, 255, 255));
        B5.setForeground(new java.awt.Color(255, 255, 255));
        B5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/program/icon21.png"))); // NOI18N
        B5.setText("   Promotion");
        B5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        B5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B5MouseClicked(evt);
            }
        });

        B7.setBackground(new java.awt.Color(255, 255, 255));
        B7.setForeground(new java.awt.Color(255, 255, 255));
        B7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/program/icon6.png"))); // NOI18N
        B7.setText("   Home");
        B7.setAutoscrolls(true);
        B7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        B7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B7MouseClicked(evt);
            }
        });

        B8.setBackground(new java.awt.Color(255, 255, 255));
        B8.setForeground(new java.awt.Color(255, 255, 255));
        B8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/program/icon23.png"))); // NOI18N
        B8.setText("   Person");
        B8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        B8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B8MouseClicked(evt);
            }
        });

        B9.setBackground(new java.awt.Color(255, 255, 255));
        B9.setForeground(new java.awt.Color(255, 255, 255));
        B9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Program/icon5.png"))); // NOI18N
        B9.setText("   Admin");
        B9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        B9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B9MouseClicked(evt);
            }
        });

        B2.setBackground(new java.awt.Color(255, 255, 255));
        B2.setForeground(new java.awt.Color(255, 255, 255));
        B2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/program/icon26.png"))); // NOI18N
        B2.setText("   Expenses");
        B2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        B2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B2MouseClicked(evt);
            }
        });

        B4.setBackground(new java.awt.Color(255, 255, 255));
        B4.setForeground(new java.awt.Color(255, 255, 255));
        B4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/program/icon20.png"))); // NOI18N
        B4.setText("   Supplier");
        B4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        B4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout frameColor12Layout = new javax.swing.GroupLayout(frameColor12);
        frameColor12.setLayout(frameColor12Layout);
        frameColor12Layout.setHorizontalGroup(
            frameColor12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frameColor12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(B4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        frameColor12Layout.setVerticalGroup(
            frameColor12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frameColor12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(B4)
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
                .addComponent(B9, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelColor3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(B2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelColor3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(B3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelColor3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(frameColor12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelColor3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(B5, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelColor3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(B8, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(B9)
                .addGap(18, 18, 18)
                .addComponent(B2)
                .addGap(18, 18, 18)
                .addComponent(B3)
                .addGap(12, 12, 12)
                .addComponent(frameColor12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(B5)
                .addGap(18, 18, 18)
                .addComponent(B8)
                .addGap(39, 39, 39)
                .addComponent(B7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(panelColor3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 500));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Supplier");

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
                .addGap(23, 23, 23)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        );

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

        Button4.setBackground(new java.awt.Color(240, 113, 103));
        Button4.setForeground(new java.awt.Color(255, 255, 255));
        Button4.setText("Delete");
        Button4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button4ActionPerformed(evt);
            }
        });

        Button5.setBackground(new java.awt.Color(0, 129, 167));
        Button5.setForeground(new java.awt.Color(255, 255, 255));
        Button5.setText("Add Order Supplier");
        Button5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button5ActionPerformed(evt);
            }
        });

        Button6.setBackground(new java.awt.Color(0, 167, 185));
        Button6.setForeground(new java.awt.Color(255, 255, 255));
        Button6.setText("Move Order to Stock");
        Button6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelColor32Layout = new javax.swing.GroupLayout(panelColor32);
        panelColor32.setLayout(panelColor32Layout);
        panelColor32Layout.setHorizontalGroup(
            panelColor32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelColor32Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelColor32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelColor32Layout.createSequentialGroup()
                        .addComponent(Button4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Button6, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(272, 272, 272)
                        .addComponent(Button5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelColor32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelColor32Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(FormSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(Button, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        panelColor32Layout.setVerticalGroup(
            panelColor32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelColor32Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelColor32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FormSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelColor32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout panelColor21Layout = new javax.swing.GroupLayout(panelColor21);
        panelColor21.setLayout(panelColor21Layout);
        panelColor21Layout.setHorizontalGroup(
            panelColor21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelColor21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelColor31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelColor21Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(panelColor32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );
        panelColor21Layout.setVerticalGroup(
            panelColor21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelColor21Layout.createSequentialGroup()
                .addComponent(panelColor31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelColor32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        getContentPane().add(panelColor21, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 740, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        this.setExtendedState(Supplier.ICONIFIED);
    }//GEN-LAST:event_jLabel18MouseClicked

    private void B2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B2MouseClicked
       Expenses myapp  = new Expenses();
       myapp.setVisible(true);
       myapp.ID.setText(ID.getText());
       myapp.Username.setText(Username.getText());
       this.dispose();
    }//GEN-LAST:event_B2MouseClicked

    private void B3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B3MouseClicked
       Dailysale myapp  = new Dailysale();
       myapp.setVisible(true);
       myapp.ID.setText(ID.getText());
       myapp.Username.setText(Username.getText());
       this.dispose();
    }//GEN-LAST:event_B3MouseClicked

    private void B4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B4MouseClicked

    }//GEN-LAST:event_B4MouseClicked

    private void B5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B5MouseClicked
       Promotion myapp  = new Promotion();
       myapp.setVisible(true);
       myapp.ID.setText(ID.getText());
       myapp.Username.setText(Username.getText());
       this.dispose();
    }//GEN-LAST:event_B5MouseClicked

    private void B7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B7MouseClicked
       Home myapp  = new Home();
       myapp.setVisible(true);
       myapp.ID.setText(ID.getText());
       myapp.Username.setText(Username.getText());
       this.dispose();
    }//GEN-LAST:event_B7MouseClicked

    private void B8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B8MouseClicked
       Person myapp  = new Person();
       myapp.setVisible(true);
       myapp.ID.setText(ID.getText());
       myapp.Username.setText(Username.getText());
       this.dispose();
    }//GEN-LAST:event_B8MouseClicked

    private void ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonActionPerformed
        Search();
    }//GEN-LAST:event_ButtonActionPerformed

    private void B9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B9MouseClicked
        Admin myapp  = new Admin();
        myapp.setVisible(true);
        myapp.ID.setText(ID.getText());
        myapp.Username.setText(Username.getText());
        this.dispose();
    }//GEN-LAST:event_B9MouseClicked

    private void Button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button4ActionPerformed
        String id = Table.getValueAt(Table.getSelectedRow(), 0).toString();
        Connection c1 = null;
        try{
            try{
                c1 = DriverManager.getConnection("jdbc:mysql://localhost/sellingdb", "root", "0F3E71E5");
                String sql = "DELETE FROM suporder WHERE sup_id="+id;
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

            LoadSupplier();

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
    }//GEN-LAST:event_Button4ActionPerformed

    private void Button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button5ActionPerformed
        AddSupOrder myapp  = new AddSupOrder();
        myapp.setVisible(true);
        myapp.ID.setText(ID.getText());
        myapp.Username.setText(Username.getText());
        this.dispose();
    }//GEN-LAST:event_Button5ActionPerformed

    private void Button6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button6ActionPerformed
        int idOrder;
        int idStock = 0;
        float money = 0;
        String sub_id = Table.getValueAt(Table.getSelectedRow(), 0).toString();
        try {
                Connection c1 = null, c3 = null;
                Class.forName("com.mysql.cj.jdbc.Driver");
                c1 = DriverManager.getConnection("jdbc:mysql://localhost/sellingdb", "root", "0F3E71E5");
                s1 = c1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                r1 = s1.executeQuery("Select * from budget");
                r1.next();
                
                Connection c2 = DriverManager.getConnection("jdbc:mysql://localhost/warehouse", "root", "0F3E71E5");
                Statement s2 = c2.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                c2.setAutoCommit(false);    
                money =  Float.parseFloat(r1.getString("money"));
                money = money - Float.parseFloat(Table.getValueAt(Table.getSelectedRow(), 6).toString());
                String sql = "update sellingdb.budget SET money ="+ money + " WHERE id="+ 1;
                PreparedStatement preparedStmt = c1.prepareStatement(sql);
                preparedStmt.executeUpdate();
                
                idOrder = Integer.parseInt(Table.getValueAt(Table.getSelectedRow(), 5).toString());
                ResultSet r2 = s2.executeQuery("Select * from stock where p_id="+Integer.parseInt(Table.getValueAt(Table.getSelectedRow(), 1).toString()));
                r2.next();
                idStock = Integer.parseInt(r2.getString("amount"));
                idStock = idStock + idOrder;     
                String sql2 = "update warehouse.stock SET amount ="+ idStock +
                        " WHERE p_id="+ Integer.parseInt(Table.getValueAt(Table.getSelectedRow(), 1).toString());
                PreparedStatement preparedStmt2 = c2.prepareStatement(sql2);
                preparedStmt2.executeUpdate();
                c2.commit();
                
                 try{
                        try{
                            c3 = DriverManager.getConnection("jdbc:mysql://localhost/sellingdb", "root", "0F3E71E5");
                                String sql3 = "DELETE FROM suporder  WHERE spOrder_id="+ sub_id;
                                PreparedStatement preparedStmt3 = c3.prepareStatement(sql3);
                                c3.setAutoCommit(false);
                                preparedStmt3.execute();
                        }catch (SQLException e1) {
                                Message2 myapp  = new Message2();
                                myapp.setVisible(true);
                        }
                        c3.commit();
                        c3.close();
                                Message7 myapp  = new Message7();
                                myapp.setVisible(true);
                        DefaultTableModel model = (DefaultTableModel) Table.getModel();
                        model.setRowCount(0);
                        LoadSupplier();
                        }catch(Exception e) {
                                Message2 myapp  = new Message2();
                                myapp.setVisible(true);
                        try{
                            c3.rollback();
                        }catch(Exception e1){
                               Message2 myapp2  = new Message2();
                               myapp2.setVisible(true);
                        }
                   }       
                
        }catch (Exception e) {
                        Message2 myapp  = new Message2();
                        myapp.setVisible(true);
         }
    }//GEN-LAST:event_Button6ActionPerformed

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
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Supplier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel B2;
    private javax.swing.JLabel B3;
    private javax.swing.JLabel B4;
    private javax.swing.JLabel B5;
    private javax.swing.JLabel B7;
    private javax.swing.JLabel B8;
    private javax.swing.JLabel B9;
    private UI.Button Button;
    private UI.Button Button4;
    private UI.Button Button5;
    private UI.Button Button6;
    private UI.Table.TextFieldSuggestion FormSearch;
    public static transient javax.swing.JLabel ID;
    private UI.Table.Table Table;
    public static transient javax.swing.JLabel Username;
    private UI.FrameColor1 frameColor12;
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
