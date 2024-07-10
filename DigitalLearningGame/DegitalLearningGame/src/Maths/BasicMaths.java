/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Maths;

import Main.Subjects;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mmaam
 */
public class BasicMaths extends javax.swing.JFrame {

    /**
     * Creates new form BasicMaths
     */
    String RegisterId;
    BasicMathsLevel1 lvl1;
    BasicMathsLevel2 lvl2;
    BasicMathsLevel3 lvl3;
    BasicMathsLevel4 lvl4;

    public BasicMaths() {
        initComponents();
        lvl1 = new BasicMathsLevel1();
        lvl2 = new BasicMathsLevel2();
        lvl3 = new BasicMathsLevel3();
        lvl4 = new BasicMathsLevel4();

        pnlDesktop.add(lvl1);
        pnlDesktop.add(lvl2);
        pnlDesktop.add(lvl3);
        pnlDesktop.add(lvl4);

        
    }

    public void Setdata(String ID) {
        RegisterId = ID;
        setRegisterDetails(ID);
        setSubjectDetails(ID);
        
        Database.totalDatabse dbTtl = new Database.totalDatabse();
        dbTtl.updateData(ID);
        
        lvl1.setVisible(true);
        lvl1.Setdata(RegisterId);
        try {
            lvl1.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(BasicMaths.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void setRegisterDetails(String ID) {
        try {
            Connection con = Database.db.getConnection();
            String sql = "SELECT stdFirstName,stdLastName,stdUsername FROM digital_learning_game.register where stdRegisterId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String firstName = rs.getString("stdFirstName");
                String lastName = rs.getString("stdLastName");
                String username = rs.getString("stdUsername");

                lblWelcomeName.setText("Welcome " + firstName + " " + lastName);
                lblUsername.setText(username);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Subjects.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setSubjectDetails(String ID) {
        try {
            Connection con = Database.db.getConnection();
            String sql = "SELECT basicMathsLevel1_Marks,basicMathsLevel1_Complete,basicMathsLevel2_Marks,basicMathsLevel2_Complete,basicMathsLevel3_Marks,basicMathsLevel3_Complete,basicMathsLevel4_Marks,basicMathsLevel4_Complete FROM digital_learning_game.maths where stdRegisterId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String basicMathsLevel1Complete = rs.getString("basicMathsLevel1_Complete");
                String basicMathsLevel1Marks = rs.getString("basicMathsLevel1_Marks");
                String basicMathsLevel2Complete = rs.getString("basicMathsLevel2_Complete");
                String basicMathsLevel2Marks = rs.getString("basicMathsLevel2_Marks");
                String basicMathsLevel3Complete = rs.getString("basicMathsLevel3_Complete");
                String basicMathsLevel3Marks = rs.getString("basicMathsLevel3_Marks");
                String basicMathsLevel4Complete = rs.getString("basicMathsLevel4_Complete");
                String basicMathsLevel4Marks = rs.getString("basicMathsLevel4_Marks");

                lblLevel1Complete.setText("Complete : " + basicMathsLevel1Complete + "%");
                lblLevel1Marks.setText("Marks : " + basicMathsLevel1Marks);

                lblLevel2Complete.setText("Complete : " + basicMathsLevel2Complete + "%");
                lblLevel2Marks.setText("Marks : " + basicMathsLevel2Marks);
                
                lblLevel3Complete.setText("Complete : " + basicMathsLevel3Complete + "%");
                lblLevel3Marks.setText("Marks : " + basicMathsLevel3Marks);
                
                lblLevel4Complete.setText("Complete : " + basicMathsLevel4Complete + "%");
                lblLevel4Marks.setText("Marks : " + basicMathsLevel4Marks);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Subjects.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void level2() {
        lvl1.setVisible(false);
        lvl2.setVisible(true);
        try {
            lvl2.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(BasicMaths.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        lblLevel1Complete = new javax.swing.JLabel();
        btnBasicMathsLevel1 = new javax.swing.JButton();
        lblLevel1Marks = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblLevel2Complete = new javax.swing.JLabel();
        lblLevel2Marks = new javax.swing.JLabel();
        btnBasicMathsLevel2 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        lblLevel3Complete = new javax.swing.JLabel();
        btnBasicMathsLevel3 = new javax.swing.JButton();
        lblLevel3Marks = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblLevel4Marks = new javax.swing.JLabel();
        btnBasicMathsLevel4 = new javax.swing.JButton();
        lblLevel4Complete = new javax.swing.JLabel();
        pnlDesktop = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        lblUsername = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        lblWelcomeName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_Back.png"))); // NOI18N
        btnBack.setText("Back");
        btnBack.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_Back_Hover.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblLevel1Complete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblLevel1Complete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLevel1Complete.setText("Complete : 0%");

        btnBasicMathsLevel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnBasicMathsLevel1.setText("Addition");
        btnBasicMathsLevel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBasicMathsLevel1ActionPerformed(evt);
            }
        });

        lblLevel1Marks.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblLevel1Marks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLevel1Marks.setText("Marks : 00");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBasicMathsLevel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                    .addComponent(lblLevel1Complete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblLevel1Marks, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBasicMathsLevel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLevel1Complete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLevel1Marks)
                .addContainerGap())
        );

        lblLevel2Complete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblLevel2Complete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLevel2Complete.setText("Complete : 0%");

        lblLevel2Marks.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblLevel2Marks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLevel2Marks.setText("Marks : 00");

        btnBasicMathsLevel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnBasicMathsLevel2.setText("Subtraction");
        btnBasicMathsLevel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBasicMathsLevel2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBasicMathsLevel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLevel2Complete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblLevel2Marks, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBasicMathsLevel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLevel2Complete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLevel2Marks)
                .addContainerGap())
        );

        lblLevel3Complete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblLevel3Complete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLevel3Complete.setText("Complete : 0%");

        btnBasicMathsLevel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnBasicMathsLevel3.setText("Multiplication");
        btnBasicMathsLevel3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBasicMathsLevel3ActionPerformed(evt);
            }
        });

        lblLevel3Marks.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblLevel3Marks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLevel3Marks.setText("Marks : 00");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLevel3Complete, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                    .addComponent(lblLevel3Marks, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBasicMathsLevel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(btnBasicMathsLevel3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLevel3Complete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLevel3Marks)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblLevel4Marks.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblLevel4Marks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLevel4Marks.setText("Marks : 00");

        btnBasicMathsLevel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnBasicMathsLevel4.setText("Division");
        btnBasicMathsLevel4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBasicMathsLevel4ActionPerformed(evt);
            }
        });

        lblLevel4Complete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblLevel4Complete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLevel4Complete.setText("Complete : 0%");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBasicMathsLevel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLevel4Complete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblLevel4Marks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBasicMathsLevel4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLevel4Complete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLevel4Marks)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(7, 7, 7)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout pnlDesktopLayout = new javax.swing.GroupLayout(pnlDesktop);
        pnlDesktop.setLayout(pnlDesktopLayout);
        pnlDesktopLayout.setHorizontalGroup(
            pnlDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlDesktopLayout.setVerticalGroup(
            pnlDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lblUsername.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(102, 102, 102));
        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUsername.setText("admin_admin");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/profile.png"))); // NOI18N
        jButton3.setContentAreaFilled(false);

        lblWelcomeName.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblWelcomeName.setText("Welcome Admin Admin");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Basic Maths - Maths");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblWelcomeName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 289, Short.MAX_VALUE)
                .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblWelcomeName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblUsername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDesktop))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlDesktop)
                        .addGap(8, 8, 8))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBasicMathsLevel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBasicMathsLevel1ActionPerformed
        // TODO add your handling code here:
        lvl2.setVisible(false);
        lvl3.setVisible(false);
        lvl4.setVisible(false);
        
        lvl1.setVisible(true);
        lvl1.Setdata(RegisterId);
        try {
            lvl1.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(BasicMaths.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBasicMathsLevel1ActionPerformed

    private void btnBasicMathsLevel2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBasicMathsLevel2ActionPerformed
        // TODO add your handling code here:
        lvl1.setVisible(false);
        lvl3.setVisible(false);
        lvl4.setVisible(false);
        
        lvl2.setVisible(true);
        lvl2.Setdata(RegisterId);
        try {
            lvl2.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(BasicMaths.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBasicMathsLevel2ActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        MathsMain mm = new MathsMain();
        mm.Setdata(RegisterId);
        mm.show();
        this.dispose();

    }//GEN-LAST:event_btnBackActionPerformed

    private void btnBasicMathsLevel4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBasicMathsLevel4ActionPerformed
        // TODO add your handling code here:
        lvl1.setVisible(false);
        lvl2.setVisible(false);
        lvl3.setVisible(false);
        
        lvl4.setVisible(true);
        lvl4.Setdata(RegisterId);
        try {
            lvl4.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(BasicMaths.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBasicMathsLevel4ActionPerformed

    private void btnBasicMathsLevel3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBasicMathsLevel3ActionPerformed
        // TODO add your handling code here:
        lvl1.setVisible(false);
        lvl2.setVisible(false);
        lvl4.setVisible(false);
        
        lvl3.setVisible(true);
        lvl3.Setdata(RegisterId);
        try {
            lvl3.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(BasicMaths.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBasicMathsLevel3ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BasicMaths.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BasicMaths.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BasicMaths.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BasicMaths.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BasicMaths().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBasicMathsLevel1;
    public javax.swing.JButton btnBasicMathsLevel2;
    public javax.swing.JButton btnBasicMathsLevel3;
    public javax.swing.JButton btnBasicMathsLevel4;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblLevel1Complete;
    private javax.swing.JLabel lblLevel1Marks;
    private javax.swing.JLabel lblLevel2Complete;
    private javax.swing.JLabel lblLevel2Marks;
    private javax.swing.JLabel lblLevel3Complete;
    private javax.swing.JLabel lblLevel3Marks;
    private javax.swing.JLabel lblLevel4Complete;
    private javax.swing.JLabel lblLevel4Marks;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblWelcomeName;
    private javax.swing.JDesktopPane pnlDesktop;
    // End of variables declaration//GEN-END:variables
}
