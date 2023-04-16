/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pointofsale.admin;

import UI.Message.Message1;
import UI.Message.Message2;
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


public class AddProfile extends javax.swing.JFrame {
    Connection c1;
    Statement s1;
    ResultSet r1;
    Connection c2;
    Statement s2;
    ResultSet r2;
    Connection c3;
    Statement s3;
    ResultSet r3;
    Connection c4;
    Statement s4;
    ResultSet r4;
    int number[];
    String data[];
    int number2[];
    String data2[];
    int number3[];
    String data3[];
    int number4[];
    String data4[];
    int value;
    int value2;
    int value3;
    int value4;
    
    private DrawerController drawer;
    public AddProfile() {
        initComponents();
        LoadTitle();
        LoadProvince();
        LoadGraduate();
        setBackground(new Color(0,0,0,0));
    }

    public void LoadTitle(){
         try{
          Class.forName("com.mysql.cj.jdbc.Driver");
         c1 = DriverManager.getConnection("jdbc:mysql://localhost/personel","root", "0F3E71E5");
         s1 = c1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
         r1 = s1.executeQuery("Select * from firstname");
         int rec=0;
         while(r1.next()){
             rec++;
         }
         number =new int[rec];
         data= new String[rec]; 
         int count=0;
         r1.first();  
         number[count] = r1.getInt("id");
         data[count]=r1.getString("name");
         count++;
         while (r1.next()){
             number[count] = r1.getInt("id");
             data[count]=r1.getString("name");
             count++;
         }
         jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(data));
        }catch(Exception e){
            Message2 myapp  = new Message2();
            myapp.setVisible(true);
        }
    }
        
    public void LoadProvince(){
        try{
          Class.forName("com.mysql.cj.jdbc.Driver");
         c2 = DriverManager.getConnection("jdbc:mysql://localhost/personel","root", "0F3E71E5");
         s2 = c2.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
         r2 = s2.executeQuery("Select * from province order by name");
         int rec=0;
         while(r2.next()){
             rec++;
         }
         number2=new int[rec];
         data2=new String[rec];       
         int count=0;
         r2.first();  
         number2[count] = r2.getInt("id");
         data2[count]=r2.getString("name");
         count++;
         while (r2.next()){
             number2[count] = r2.getInt("id");
             data2[count]=r2.getString("name");
             count++;
         }
         jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(data2));
        }catch(Exception e){
            Message2 myapp  = new Message2();
            myapp.setVisible(true);
        }
    }
    
    public void LoadAumpher(int p_id){
        try{
          Class.forName("com.mysql.cj.jdbc.Driver");
         c3 = DriverManager.getConnection("jdbc:mysql://localhost/personel","root", "0F3E71E5");
         s3 = c3.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
         r3 = s3.executeQuery("Select * from aumpher where p_id ="+p_id+" order by name");
         int rec=0;
         while(r3.next()){
             rec++;
         }
         number3=new int[rec];
         data3=new String[rec];       
         int count=0;
         r3.first();  
         number3[count] = r3.getInt("id");
         data3[count]=r3.getString("name");
         count++;
         while (r3.next()){
             number3[count] = r3.getInt("id");
             data3[count]=r3.getString("name");
             count++;
         }
         jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(data3));
        }catch(Exception e){
            Message2 myapp  = new Message2();
            myapp.setVisible(true);
        }
    }
    
    public void LoadGraduate(){
        try{
          Class.forName("com.mysql.cj.jdbc.Driver");
         c4 = DriverManager.getConnection("jdbc:mysql://localhost/personel","root", "0F3E71E5");
         s4 = c4.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
         r4 = s4.executeQuery("Select * from graduate");
         int rec=0;
         while(r4.next()){
             rec++;
         }
         number4 =new int[rec];
         data4 = new String[rec]; 
         int count=0;
         r4.first();  
         number4[count] = r4.getInt("id");
         data4[count]=r4.getString("name");
         count++;
         while (r4.next()){
             number4[count] = r4.getInt("id");
             data4[count]=r4.getString("name");
             count++;
         }
         jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(data4));
        }catch(Exception e){System.out.println(e);}
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
        B9 = new javax.swing.JLabel();
        B2 = new javax.swing.JLabel();
        B4 = new javax.swing.JLabel();
        frameColor12 = new UI.FrameColor1();
        B8 = new javax.swing.JLabel();
        panelColor21 = new UI.PanelColor2();
        panelColor31 = new UI.PanelColor3();
        jLabel2 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        arrow = new javax.swing.JLabel();
        panelColor32 = new UI.PanelColor3();
        jLabel3 = new javax.swing.JLabel();
        Form1 = new UI.Table.TextFieldSuggestion();
        jLabel5 = new javax.swing.JLabel();
        Form3 = new UI.Table.TextFieldSuggestion();
        Form4 = new UI.Table.TextFieldSuggestion();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Form5 = new UI.Table.TextFieldSuggestion();
        jLabel8 = new javax.swing.JLabel();
        Form6 = new UI.Table.TextFieldSuggestion();
        Form7 = new UI.Table.TextFieldSuggestion();
        jLabel10 = new javax.swing.JLabel();
        Form8 = new UI.Table.TextFieldSuggestion();
        jLabel11 = new javax.swing.JLabel();
        Form9 = new UI.Table.TextFieldSuggestion();
        jLabel13 = new javax.swing.JLabel();
        Form2 = new UI.Table.TextFieldSuggestion();
        jLabel9 = new javax.swing.JLabel();
        Form10 = new UI.Table.TextFieldSuggestion();
        jLabel14 = new javax.swing.JLabel();
        Button2 = new UI.Button();
        jComboBox1 = new combo_suggestion.ComboBoxSuggestion();
        jComboBox2 = new combo_suggestion.ComboBoxSuggestion();
        jComboBox3 = new combo_suggestion.ComboBoxSuggestion();
        jComboBox4 = new combo_suggestion.ComboBoxSuggestion();

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

        javax.swing.GroupLayout frameColor12Layout = new javax.swing.GroupLayout(frameColor12);
        frameColor12.setLayout(frameColor12Layout);
        frameColor12Layout.setHorizontalGroup(
            frameColor12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frameColor12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(B8, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        frameColor12Layout.setVerticalGroup(
            frameColor12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frameColor12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(B8)
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
                .addGap(19, 19, 19)
                .addComponent(B4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelColor3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(B5, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelColor3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(frameColor12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(18, 18, 18)
                .addComponent(B4)
                .addGap(18, 18, 18)
                .addComponent(B5)
                .addGap(16, 16, 16)
                .addComponent(frameColor12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(B7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(panelColor3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 500));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Add New Profile");

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
                .addGap(18, 18, 18)
                .addComponent(arrow, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        panelColor31Layout.setVerticalGroup(
            panelColor31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelColor31Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelColor31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(arrow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("ProFile ID : ");

        Form1.setFont(new java.awt.Font("TH SarabunPSK", 0, 18)); // NOI18N
        Form1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Form1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("FNmae  : ");

        Form3.setFont(new java.awt.Font("TH SarabunPSK", 0, 18)); // NOI18N
        Form3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Form3ActionPerformed(evt);
            }
        });

        Form4.setFont(new java.awt.Font("TH SarabunPSK", 0, 18)); // NOI18N
        Form4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Form4ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("LNmae  : ");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Email  : ");

        Form5.setFont(new java.awt.Font("TH SarabunPSK", 0, 18)); // NOI18N
        Form5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Form5ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Tel  : ");

        Form6.setFont(new java.awt.Font("TH SarabunPSK", 0, 18)); // NOI18N
        Form6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Form6ActionPerformed(evt);
            }
        });

        Form7.setFont(new java.awt.Font("TH SarabunPSK", 0, 18)); // NOI18N
        Form7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Form7ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Role  : ");

        Form8.setFont(new java.awt.Font("TH SarabunPSK", 0, 18)); // NOI18N
        Form8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Form8ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Province  : ");

        Form9.setFont(new java.awt.Font("TH SarabunPSK", 0, 18)); // NOI18N
        Form9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Form9ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Aumpher  : ");

        Form2.setFont(new java.awt.Font("TH SarabunPSK", 0, 18)); // NOI18N
        Form2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Form2ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Title : ");

        Form10.setFont(new java.awt.Font("TH SarabunPSK", 0, 18)); // NOI18N
        Form10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Form10ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Graduate  : ");

        Button2.setBackground(new java.awt.Color(240, 113, 103));
        Button2.setForeground(new java.awt.Color(255, 255, 255));
        Button2.setText("Save");
        Button2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button2ActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("TH SarabunPSK", 0, 16)); // NOI18N
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setFont(new java.awt.Font("TH SarabunPSK", 0, 14)); // NOI18N
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jComboBox3.setFont(new java.awt.Font("TH SarabunPSK", 0, 14)); // NOI18N
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jComboBox4.setFont(new java.awt.Font("TH SarabunPSK", 0, 14)); // NOI18N
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelColor32Layout = new javax.swing.GroupLayout(panelColor32);
        panelColor32.setLayout(panelColor32Layout);
        panelColor32Layout.setHorizontalGroup(
            panelColor32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelColor32Layout.createSequentialGroup()
                .addGroup(panelColor32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelColor32Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel3)
                        .addGap(12, 12, 12)
                        .addComponent(Form1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(147, 147, 147)
                        .addComponent(jLabel9)
                        .addGap(12, 12, 12)
                        .addComponent(Form2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelColor32Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel5)
                        .addGap(15, 15, 15)
                        .addComponent(Form3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125)
                        .addComponent(jLabel6)
                        .addGap(12, 12, 12)
                        .addComponent(Form4, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelColor32Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(Form5, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(148, 148, 148)
                        .addComponent(jLabel8)
                        .addGap(12, 12, 12)
                        .addComponent(Form6, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelColor32Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel10)
                        .addGap(24, 24, 24)
                        .addComponent(Form7, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112)
                        .addComponent(jLabel11)
                        .addGap(12, 12, 12)
                        .addComponent(Form8, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelColor32Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(Form9, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelColor32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelColor32Layout.createSequentialGroup()
                                .addGap(256, 256, 256)
                                .addComponent(Button2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelColor32Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel14)
                                .addGap(12, 12, 12)
                                .addComponent(Form10, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(12, 12, 12))
        );
        panelColor32Layout.setVerticalGroup(
            panelColor32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelColor32Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelColor32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelColor32Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3))
                    .addComponent(Form1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelColor32Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel9))
                    .addGroup(panelColor32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Form2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panelColor32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Form3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Form4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelColor32Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panelColor32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))))
                .addGap(18, 18, 18)
                .addGroup(panelColor32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Form5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Form6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelColor32Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panelColor32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))))
                .addGap(18, 18, 18)
                .addGroup(panelColor32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelColor32Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel10))
                    .addComponent(Form7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelColor32Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel11))
                    .addGroup(panelColor32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Form8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panelColor32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelColor32Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel13))
                    .addGroup(panelColor32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Form9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelColor32Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel14))
                    .addGroup(panelColor32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Form10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addComponent(Button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelColor21Layout = new javax.swing.GroupLayout(panelColor21);
        panelColor21.setLayout(panelColor21Layout);
        panelColor21Layout.setHorizontalGroup(
            panelColor21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelColor21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelColor31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelColor21Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(panelColor32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        panelColor21Layout.setVerticalGroup(
            panelColor21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelColor21Layout.createSequentialGroup()
                .addComponent(panelColor31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelColor32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        getContentPane().add(panelColor21, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 740, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        this.setExtendedState(AddProfile.ICONIFIED);
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
       Supplier myapp  = new Supplier();
       myapp.setVisible(true);
       myapp.ID.setText(ID.getText());
       myapp.Username.setText(Username.getText());
       this.dispose();
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
        // TODO add your handling code here:
    }//GEN-LAST:event_B8MouseClicked

    private void B9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B9MouseClicked
        Admin myapp  = new Admin();
        myapp.setVisible(true);
        myapp.ID.setText(ID.getText());
        myapp.Username.setText(Username.getText());
        this.dispose();
    }//GEN-LAST:event_B9MouseClicked

    private void arrowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_arrowMouseClicked
        Person myapp  = new Person();
        myapp.setVisible(true);
        myapp.ID.setText(ID.getText());
        myapp.Username.setText(Username.getText());
        this.dispose();
    }//GEN-LAST:event_arrowMouseClicked

    private void Form1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Form1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Form1ActionPerformed

    private void Form3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Form3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Form3ActionPerformed

    private void Form4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Form4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Form4ActionPerformed

    private void Form5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Form5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Form5ActionPerformed

    private void Form6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Form6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Form6ActionPerformed

    private void Form7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Form7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Form7ActionPerformed

    private void Form8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Form8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Form8ActionPerformed

    private void Form9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Form9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Form9ActionPerformed

    private void Form2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Form2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Form2ActionPerformed

    private void Form10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Form10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Form10ActionPerformed

    private void Button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button2ActionPerformed
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            Message2 myapp  = new Message2();
            myapp.setVisible(true);
        }
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/personel", "root", "0F3E71E5");
            String sql = "INSERT INTO profile(id, fname, lname, email, tel, role, id_aumpher, id_graduate, id_title, id_province) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = c.prepareStatement(sql);
            preparedStmt.setString(1, Form1.getText());
            preparedStmt.setString(2, Form3.getText());
            preparedStmt.setString(3, Form4.getText());
            preparedStmt.setString(4, Form5.getText());
            preparedStmt.setString(5, Form6.getText());
            preparedStmt.setString(6, Form7.getText());
            preparedStmt.setString(7, Form9.getText());
            preparedStmt.setString(8, Form10.getText());
            preparedStmt.setString(9, Form2.getText());
            preparedStmt.setString(10, Form8.getText());
            preparedStmt.execute();
            Form1.setText("");
            Form3.setText("");
            Form4.setText("");
            c.close();
            Message1 myapp  = new Message1();
            myapp.setVisible(true);
        } catch (SQLException e) {
            Message2 myapp  = new Message2();
            myapp.setVisible(true);
        }
    }//GEN-LAST:event_Button2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        value  = number[jComboBox1.getSelectedIndex()];
        Form2.setText(""+value);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        value2  = number2[jComboBox2.getSelectedIndex()];
        Form8.setText(""+value2);
        LoadAumpher(value2);
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        value3  = number3[jComboBox3.getSelectedIndex()];
        Form9.setText(""+value3);
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        value4  = number4[jComboBox4.getSelectedIndex()];
        Form10.setText(""+value4);
    }//GEN-LAST:event_jComboBox4ActionPerformed

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
            java.util.logging.Logger.getLogger(AddProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new AddProfile().setVisible(true);
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
    private UI.Button Button2;
    private UI.Table.TextFieldSuggestion Form1;
    private UI.Table.TextFieldSuggestion Form10;
    private UI.Table.TextFieldSuggestion Form2;
    private UI.Table.TextFieldSuggestion Form3;
    private UI.Table.TextFieldSuggestion Form4;
    private UI.Table.TextFieldSuggestion Form5;
    private UI.Table.TextFieldSuggestion Form6;
    private UI.Table.TextFieldSuggestion Form7;
    private UI.Table.TextFieldSuggestion Form8;
    private UI.Table.TextFieldSuggestion Form9;
    public static transient javax.swing.JLabel ID;
    public static transient javax.swing.JLabel Username;
    private javax.swing.JLabel arrow;
    private UI.FrameColor1 frameColor12;
    public static transient test.ImageAvatar imageAvatar1;
    private combo_suggestion.ComboBoxSuggestion jComboBox1;
    private combo_suggestion.ComboBoxSuggestion jComboBox2;
    private combo_suggestion.ComboBoxSuggestion jComboBox3;
    private combo_suggestion.ComboBoxSuggestion jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private UI.PanelColor2 panelColor21;
    private UI.PanelColor panelColor3;
    private UI.PanelColor3 panelColor31;
    private UI.PanelColor3 panelColor32;
    // End of variables declaration//GEN-END:variables

}
