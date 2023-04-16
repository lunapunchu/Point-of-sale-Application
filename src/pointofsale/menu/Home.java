/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pointofsale.menu;

import UI.Message.Message2;
import UI.Message.Message3;
import goods.Product;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javaswingdev.drawer.Drawer;
import javaswingdev.drawer.DrawerController;
import javaswingdev.drawer.DrawerItem;
import javaswingdev.drawer.EventDrawer;
import pointofsale.admin.Admin;
import user.Login;


public class Home extends javax.swing.JFrame {
    Connection c1;
    Statement s1;
    ResultSet r1;
    Connection c2;
    Statement s2;
    ResultSet r2;
    
    private DrawerController drawer;
    public Home() {
        initComponents();
        total_money();
        daily_sales();
        total_expenses();
        stock();
        order_supplier();
        product();
        setBackground(new Color(0,0,0,0));
    }
    
    private void total_money(){
        try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                c1 = DriverManager.getConnection("jdbc:mysql://localhost/sellingdb", "root", "0F3E71E5");
                s1 = c1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                r1 = s1.executeQuery("Select * from budget");
                r1.next();
                text1.setText(r1.getString("money"));
        } catch (Exception e) {
                Message2 myapp  = new Message2();
                myapp.setVisible(true);
         }
    }
    
    private void daily_sales(){
        try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                c1 = DriverManager.getConnection("jdbc:mysql://localhost/warehouse", "root", "0F3E71E5");
                s1 = c1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                r1 = s1.executeQuery("Select * from curorder");
                    int rec=0;
                    while(r1.next()){
                        rec++;
                    }
                    float  price = 0;
                    
                    int count=0;
                    r1.first();                     
                    price = price + Float.parseFloat(r1.getString("total_price"));
                    count++;
                    while (r1.next()){ 
                       price = price + Float.parseFloat(r1.getString("total_price"));
                       count++;
                    }
                    text2.setText(String.valueOf(price));
                    text5.setText(String.valueOf(count));
        } catch (Exception e) {
                Message2 myapp  = new Message2();
                myapp.setVisible(true);
         }
    }
    
    private void total_expenses(){
        try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                c1 = DriverManager.getConnection("jdbc:mysql://localhost/sellingdb", "root", "0F3E71E5");
                s1 = c1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                r1 = s1.executeQuery("Select * from expense");
                    int rec=0;
                    while(r1.next()){
                        rec++;
                    }
                    float  price = 0;
                    int count=0;
                    r1.first();                     
                    price = price + Float.parseFloat(r1.getString("price"));
                    count++;
                    while (r1.next()){ 
                       price = price + Float.parseFloat(r1.getString("price"));
                       count++;
                    }
                    text3.setText(String.valueOf(price));
        } catch (Exception e) {
                Message2 myapp  = new Message2();
                myapp.setVisible(true);
         }
    }
    
    private void stock(){
        try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                c1 = DriverManager.getConnection("jdbc:mysql://localhost/warehouse", "root", "0F3E71E5");
                s1 = c1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                r1 = s1.executeQuery("Select * from stock");
                    int rec=0;
                    while(r1.next()){
                        rec++;
                    }
                    int count=0;
                    r1.first();                     
                    count++;
                    while (r1.next()){ 
                       count++;
                    }
                    text4.setText(String.valueOf(count));
        } catch (Exception e) {
                Message2 myapp  = new Message2();
                myapp.setVisible(true);
         }
    }
    
    private void order_supplier(){
        try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                c1 = DriverManager.getConnection("jdbc:mysql://localhost/sellingdb", "root", "0F3E71E5");
                s1 = c1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                r1 = s1.executeQuery("Select * from suporder");
                    int rec=0;
                    while(r1.next()){
                        rec++;
                    }
                    int count=0;
                    r1.first();                     
                    count++;
                    while (r1.next()){ 
                       count++;
                    }
                    text6.setText(String.valueOf(count));
        } catch (Exception e) {
                Message2 myapp  = new Message2();
                myapp.setVisible(true);
         }
    }
    
    private void product(){
        try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                c1 = DriverManager.getConnection("jdbc:mysql://localhost/goods", "root", "0F3E71E5");
                s1 = c1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                r1 = s1.executeQuery("Select * from product"); 
                    int rec=0;
                    while(r1.next()){
                        rec++;
                    }
                    int count=0;
                    r1.first();                     
                    count++;
                    while (r1.next()){ 
                       count++;
                    }
                    text7.setText(String.valueOf(count));
        } catch (Exception e) {
                Message2 myapp  = new Message2();
                myapp.setVisible(true);
         }
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
        frameColor11 = new UI.FrameColor1();
        B1 = new javax.swing.JLabel();
        B2 = new javax.swing.JLabel();
        B3 = new javax.swing.JLabel();
        B4 = new javax.swing.JLabel();
        B5 = new javax.swing.JLabel();
        B6 = new javax.swing.JLabel();
        B7 = new javax.swing.JLabel();
        panelColor21 = new UI.PanelColor2();
        panelColor31 = new UI.PanelColor3();
        jLabel2 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        text2 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        text1 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        text3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        text4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        text5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        text6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        text7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

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

        B1.setBackground(new java.awt.Color(255, 255, 255));
        B1.setForeground(new java.awt.Color(255, 255, 255));
        B1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Program/icon6.png"))); // NOI18N
        B1.setText("   Home");
        B1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout frameColor11Layout = new javax.swing.GroupLayout(frameColor11);
        frameColor11.setLayout(frameColor11Layout);
        frameColor11Layout.setHorizontalGroup(
            frameColor11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frameColor11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(B1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
        );
        frameColor11Layout.setVerticalGroup(
            frameColor11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frameColor11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(B1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        B3.setBackground(new java.awt.Color(255, 255, 255));
        B3.setForeground(new java.awt.Color(255, 255, 255));
        B3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Program/icon3.png"))); // NOI18N
        B3.setText("   Product");
        B3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        B3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B3MouseClicked(evt);
            }
        });

        B4.setBackground(new java.awt.Color(255, 255, 255));
        B4.setForeground(new java.awt.Color(255, 255, 255));
        B4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Program/icon1.png"))); // NOI18N
        B4.setText("   Order");
        B4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        B4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B4MouseClicked(evt);
            }
        });

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
                .addGap(13, 13, 13)
                .addComponent(frameColor11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelColor3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(B2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelColor3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(B3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelColor3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(B4, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(12, 12, 12)
                .addComponent(frameColor11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(B2)
                .addGap(18, 18, 18)
                .addComponent(B3)
                .addGap(18, 18, 18)
                .addComponent(B4)
                .addGap(18, 18, 18)
                .addComponent(B5)
                .addGap(18, 18, 18)
                .addComponent(B6)
                .addGap(39, 39, 39)
                .addComponent(B7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(panelColor3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 500));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Home");

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
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        panelColor31Layout.setVerticalGroup(
            panelColor31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 167, 185));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Program/icon10.png"))); // NOI18N
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 59, 53));

        jPanel5.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 70));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Daily Sales");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 85, -1));

        text2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        text2.setText("0");
        jPanel5.add(text2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 91, -1));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(254, 217, 183));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Program/icon9.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 59, 53));

        jPanel8.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 63));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Total Money");
        jPanel8.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 91, -1));

        text1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        text1.setText("0");
        jPanel8.add(text1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 91, -1));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel13.setBackground(new java.awt.Color(240, 113, 103));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Program/icon11.png"))); // NOI18N
        jPanel13.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 59, 52));

        jPanel12.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 70));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Total Expenses");
        jPanel12.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 95, -1));

        text3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        text3.setText("0");
        jPanel12.add(text3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 91, -1));

        jPanel2.setBackground(new java.awt.Color(240, 113, 103));

        jPanel15.setBackground(new java.awt.Color(211, 99, 90));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 332, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        text4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        text4.setForeground(new java.awt.Color(255, 255, 255));
        text4.setText("0");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Stock");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Program/icon12.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(text4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.setBackground(new java.awt.Color(254, 217, 183));

        jPanel16.setBackground(new java.awt.Color(229, 191, 154));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 331, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Order Selling");

        text5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        text5.setForeground(new java.awt.Color(255, 255, 255));
        text5.setText("0");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Program/icon13.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text5, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(text5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel16))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel9.setBackground(new java.awt.Color(0, 167, 185));

        jPanel17.setBackground(new java.awt.Color(4, 131, 145));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 332, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Order Supplier");

        text6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        text6.setForeground(new java.awt.Color(255, 255, 255));
        text6.setText("0");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Program/icon14.png"))); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text6, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(text6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel20)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel14.setBackground(new java.awt.Color(0, 129, 167));

        jPanel18.setBackground(new java.awt.Color(5, 111, 142));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 331, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Product");

        text7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        text7.setForeground(new java.awt.Color(255, 255, 255));
        text7.setText("0");

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Program/icon15.png"))); // NOI18N

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text7, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(text7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel22)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout panelColor21Layout = new javax.swing.GroupLayout(panelColor21);
        panelColor21.setLayout(panelColor21Layout);
        panelColor21Layout.setHorizontalGroup(
            panelColor21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelColor21Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelColor21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelColor21Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelColor21Layout.createSequentialGroup()
                        .addGroup(panelColor21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(31, 31, 31)
                        .addGroup(panelColor21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(16, 16, 16))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelColor21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelColor31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelColor21Layout.setVerticalGroup(
            panelColor21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelColor21Layout.createSequentialGroup()
                .addComponent(panelColor31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(panelColor21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addGroup(panelColor21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelColor21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        getContentPane().add(panelColor21, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 740, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        this.setExtendedState(Home.ICONIFIED);
    }//GEN-LAST:event_jLabel18MouseClicked

    private void B2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B2MouseClicked
       Selling myapp  = new Selling();
       myapp.setVisible(true);
       myapp.ID.setText(ID.getText());
       myapp.Username.setText(Username.getText());
       this.dispose();
    }//GEN-LAST:event_B2MouseClicked

    private void B3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B3MouseClicked
       Product myapp  = new Product();
       myapp.setVisible(true);
       myapp.ID.setText(ID.getText());
       myapp.Username.setText(Username.getText());
       this.dispose();
    }//GEN-LAST:event_B3MouseClicked

    private void B4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B4MouseClicked
       Order myapp  = new Order();
       myapp.setVisible(true);
       myapp.ID.setText(ID.getText());
       myapp.Username.setText(Username.getText());
       this.dispose();
    }//GEN-LAST:event_B4MouseClicked

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel B1;
    private javax.swing.JLabel B2;
    private javax.swing.JLabel B3;
    private javax.swing.JLabel B4;
    private javax.swing.JLabel B5;
    private javax.swing.JLabel B6;
    private javax.swing.JLabel B7;
    public static transient javax.swing.JLabel ID;
    public static transient javax.swing.JLabel Username;
    private UI.FrameColor1 frameColor11;
    public static transient test.ImageAvatar imageAvatar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private UI.PanelColor2 panelColor21;
    private UI.PanelColor panelColor3;
    private UI.PanelColor3 panelColor31;
    private javax.swing.JLabel text1;
    private javax.swing.JLabel text2;
    private javax.swing.JLabel text3;
    private javax.swing.JLabel text4;
    private javax.swing.JLabel text5;
    private javax.swing.JLabel text6;
    private javax.swing.JLabel text7;
    // End of variables declaration//GEN-END:variables

}
