/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pointofsale.Get;

import UI.Message.Message2;
import goods.*;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import pointofsale.menu.AddOrder;
import pointofsale.menu.Selling;

/**
 *
 * @author Asus
 */
public class GetProduct3 extends javax.swing.JFrame {
        Connection c1;
        Statement s1;
        ResultSet r1;
    /**
     * Creates new form GetGroup
     */
    public GetProduct3() {
        initComponents();
        LoadProduct();
        init();
        setBackground(new Color(0,0,0,0));
    }
    
    public void LoadProduct(){
         try{
          Class.forName("com.mysql.cj.jdbc.Driver");
         c1 = DriverManager.getConnection("jdbc:mysql://localhost/goods","root", "0F3E71E5");
         s1 = c1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
         r1 = s1.executeQuery("Select * from product");
         int rec=0;
         while(r1.next()){
             rec++;
         }        
         String[][] datatable = new String[rec][4];
         String[] head = {"ProductID", "Name", "Price", "PromotionID"};
         int count=0;
         r1.first();  
         datatable[count][0] = r1.getString("p_id");
         datatable[count][1] =r1.getString("p_name");
         datatable[count][2] =r1.getString("price");
         datatable[count][3] =r1.getString("pm_id");
         count++;
         while (r1.next()){
            datatable[count][0] = r1.getString("p_id");
            datatable[count][1] =r1.getString("p_name");
            datatable[count][2] =r1.getString("price");
            datatable[count][3] =r1.getString("pm_id");
             count++;
         }
          Table1.setModel(new javax.swing.table.DefaultTableModel(datatable,head));
        }catch(Exception e){
            Message2 myapp  = new Message2();
            myapp.setVisible(true);
        }
    }
    
    public void Search(){
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
            c1 = DriverManager.getConnection("jdbc:mysql://localhost/goods", "root", "0F3E71E5");
            s1 = c1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            r1 = s1.executeQuery("Select * from product where p_id="+Integer.parseInt(FormSearch.getText()));
           int rec=0;
            while(r1.next()){
                rec++;
            }

            String[][] datatable = new String[rec][4];
            String[] head = {"ProductID", "Name", "Price", "PromotionID"};
            int count=0;
            r1.first();  
            datatable[count][0] = r1.getString("p_id");
            datatable[count][1] =r1.getString("p_name");
            datatable[count][2] =r1.getString("price");
            datatable[count][3] =r1.getString("pm_id");
            count++;
            while (r1.next()){
               datatable[count][0] = r1.getString("p_id");
               datatable[count][1] =r1.getString("p_name");
               datatable[count][2] =r1.getString("price");
               datatable[count][3] =r1.getString("pm_id");
                count++;
            }
         
          Table1.setModel(new javax.swing.table.DefaultTableModel(datatable,head));
      }catch(Exception e){
            Message2 myapp  = new Message2();
            myapp.setVisible(true);
      }
    }
    
    private void init(){
        Table1.fixTable(jScrollPane1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelColor51 = new UI.PanelColor5();
        panelColor32 = new UI.PanelColor3();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table1 = new UI.Table.Table();
        Button1 = new UI.Button();
        panelColor31 = new UI.PanelColor3();
        FormSearch = new UI.Table.TextFieldSuggestion();
        Button = new UI.Button();
        panelColor41 = new UI.PanelColor4();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        Table1.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        jScrollPane1.setViewportView(Table1);

        javax.swing.GroupLayout panelColor32Layout = new javax.swing.GroupLayout(panelColor32);
        panelColor32.setLayout(panelColor32Layout);
        panelColor32Layout.setHorizontalGroup(
            panelColor32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelColor32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelColor32Layout.setVerticalGroup(
            panelColor32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelColor32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                .addContainerGap())
        );

        Button1.setBackground(new java.awt.Color(240, 113, 103));
        Button1.setForeground(new java.awt.Color(255, 255, 255));
        Button1.setText("OK");
        Button1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelColor51Layout = new javax.swing.GroupLayout(panelColor51);
        panelColor51.setLayout(panelColor51Layout);
        panelColor51Layout.setHorizontalGroup(
            panelColor51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelColor51Layout.createSequentialGroup()
                .addGroup(panelColor51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelColor51Layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(Button1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelColor51Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(panelColor32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        panelColor51Layout.setVerticalGroup(
            panelColor51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelColor51Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(panelColor32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        getContentPane().add(panelColor51, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 400, 400));

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

        javax.swing.GroupLayout panelColor31Layout = new javax.swing.GroupLayout(panelColor31);
        panelColor31.setLayout(panelColor31Layout);
        panelColor31Layout.setHorizontalGroup(
            panelColor31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelColor31Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(FormSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Button, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );
        panelColor31Layout.setVerticalGroup(
            panelColor31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelColor31Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panelColor31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FormSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        getContentPane().add(panelColor31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 63, 400, 90));

        jLabel18.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Program/icon17.png"))); // NOI18N
        jLabel18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Program/icon16.png"))); // NOI18N
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Data Product");

        javax.swing.GroupLayout panelColor41Layout = new javax.swing.GroupLayout(panelColor41);
        panelColor41.setLayout(panelColor41Layout);
        panelColor41Layout.setHorizontalGroup(
            panelColor41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelColor41Layout.createSequentialGroup()
                .addContainerGap(153, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        panelColor41Layout.setVerticalGroup(
            panelColor41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelColor41Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelColor41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelColor41Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panelColor41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        getContentPane().add(panelColor41, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 90));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        this.setExtendedState(GetProduct3.ICONIFIED);
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel19MouseClicked

    private void ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonActionPerformed
       Search();
    }//GEN-LAST:event_ButtonActionPerformed

    private void Button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button1ActionPerformed
        String p_id = Table1.getValueAt(Table1.getSelectedRow(), 0).toString();
        String name= Table1.getValueAt(Table1.getSelectedRow(), 1).toString();
        String price = Table1.getValueAt(Table1.getSelectedRow(), 2).toString();
        String pm_id = Table1.getValueAt(Table1.getSelectedRow(), 3).toString();
        Selling.Form2.setText(p_id);
        Selling.Form3.setText(name);
        Selling.Form5.setText(price);
        Selling.Form7.setText(pm_id);
        try{
          Class.forName("com.mysql.cj.jdbc.Driver");
         c1 = DriverManager.getConnection("jdbc:mysql://localhost/goods","root", "0F3E71E5");
         s1 = c1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
         r1 = s1.executeQuery("Select * from promotion where pm_id="+Integer.parseInt(pm_id));
         r1.next();
         Selling.Form7.setText(r1.getString("discount"));
        }catch(Exception e){         
            Message2 myapp  = new Message2();
            myapp.setVisible(true);
        }
         this.dispose();
    }//GEN-LAST:event_Button1ActionPerformed

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
            java.util.logging.Logger.getLogger(GetProduct3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GetProduct3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GetProduct3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GetProduct3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GetProduct3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private UI.Button Button;
    private UI.Button Button1;
    private UI.Table.TextFieldSuggestion FormSearch;
    private UI.Table.Table Table1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private UI.PanelColor3 panelColor31;
    private UI.PanelColor3 panelColor32;
    private UI.PanelColor4 panelColor41;
    private UI.PanelColor5 panelColor51;
    // End of variables declaration//GEN-END:variables
}
