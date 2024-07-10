/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Science;

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
public class ElectronicConfiguration extends javax.swing.JFrame {

    /**
     * Creates new form ElectronicConfiguration
     */
    String RegisterId;
    ElectronicConfigurationLevel1 lvl1;
    ElectronicConfigurationLevel2 lvl2;
    ElectronicConfigurationLevel2_II lvl2_II;

    public ElectronicConfiguration() {
        initComponents();
        lvl1 = new ElectronicConfigurationLevel1();
        lvl2 = new ElectronicConfigurationLevel2();
        lvl2_II = new ElectronicConfigurationLevel2_II();

        pnlDesktop.add(lvl1);
        pnlDesktop.add(lvl2);
        pnlDesktop.add(lvl2_II);
       
        
    }

    public void Setdata(String ID) {
        RegisterId = ID;
        setRegisterDetails(ID);
        setSubjectDetails(ID);
        
        lvl1.setVisible(true);
        lvl1.Setdata(RegisterId);
        try {
            lvl1.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(ElectronicConfiguration.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Database.totalDatabse dbTtl = new Database.totalDatabse();
        dbTtl.updateData(ID);
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

    public void setSubjectDetails(String ID){
        try {
            Connection con = Database.db.getConnection();
            String sql = "SELECT electronicConfigurationLevel1_marks,electronicConfigurationLevel1_completed,electronicConfigurationLevel2_marks,electronicConfigurationLevel2_completed,electronicConfigurationLevel2_marks_II,electronicConfigurationLevel2_complete_II FROM digital_learning_game.science where stdRegisterId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String electronicConfigLevel1Marks = rs.getString("electronicConfigurationLevel1_marks");
                String electronicConfigLevel1Complete = rs.getString("electronicConfigurationLevel1_completed");
                
                String electronicConfigLevel2_IMarks = rs.getString("electronicConfigurationLevel2_marks");
                String electronicConfigLevel2_IComplete = rs.getString("electronicConfigurationLevel2_completed");
                
                String electronicConfigLevel2_IIMarks = rs.getString("electronicConfigurationLevel2_marks_II");
                String electronicConfigLevel2_IIComplete = rs.getString("electronicConfigurationLevel2_complete_II");
                
                int level2_IMarks = Integer.valueOf(electronicConfigLevel2_IMarks);
                int level2_IComplete = Integer.valueOf(electronicConfigLevel2_IComplete);
                int level2_IIMarks = Integer.valueOf(electronicConfigLevel2_IIMarks);
                int level2_IIComplete = Integer.valueOf(electronicConfigLevel2_IIComplete);
                //Set Data
                lblLevel1Complete.setText("Complete : "+electronicConfigLevel1Complete+"%");
                lblLevel1Marks.setText("Marks : "+electronicConfigLevel1Marks);
                
                lblLevel2Complete.setText("Complete : "+((level2_IComplete+level2_IIComplete)/2)+"%");
                lblLevel2Marks.setText("Complete : "+((level2_IMarks+level2_IIMarks)/2)+"%");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Subjects.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void openElectronicConfigurationLevel2() {
        lvl1.setVisible(false);
        lvl2_II.setVisible(false);
        lvl2.setVisible(true);
        lvl2.Setdata(RegisterId);
        try {
            lvl2.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(ElectronicConfiguration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void openElectronicConfigurationLevel2_II() {
        lvl2_II.setVisible(true);
        lvl2_II.Setdata(RegisterId);
        try {
            lvl2_II.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(ElectronicConfiguration.class.getName()).log(Level.SEVERE, null, ex);
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
        jSeparator1 = new javax.swing.JSeparator();
        btnBack = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblLevel1Complete = new javax.swing.JLabel();
        btnLevel1 = new javax.swing.JButton();
        lblLevel1Marks = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnLevel2 = new javax.swing.JButton();
        lblLevel2Marks = new javax.swing.JLabel();
        lblLevel2Complete = new javax.swing.JLabel();
        pnlDesktop = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        lblWelcomeName = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        lblUsername = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblLevel1Complete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblLevel1Complete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLevel1Complete.setText("Complete : 0%");

        btnLevel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnLevel1.setText("Periodic Table");
        btnLevel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLevel1ActionPerformed(evt);
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
                    .addComponent(btnLevel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblLevel1Complete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblLevel1Marks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLevel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLevel1Complete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLevel1Marks)
                .addContainerGap())
        );

        btnLevel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnLevel2.setText("Electronic Configuration");
        btnLevel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLevel2ActionPerformed(evt);
            }
        });

        lblLevel2Marks.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblLevel2Marks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLevel2Marks.setText("Marks : 00");

        lblLevel2Complete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblLevel2Complete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLevel2Complete.setText("Complete : 0%");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLevel2, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                    .addComponent(lblLevel2Complete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblLevel2Marks, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLevel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLevel2Complete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLevel2Marks)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(364, 364, 364))
        );

        javax.swing.GroupLayout pnlDesktopLayout = new javax.swing.GroupLayout(pnlDesktop);
        pnlDesktop.setLayout(pnlDesktopLayout);
        pnlDesktopLayout.setHorizontalGroup(
            pnlDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1004, Short.MAX_VALUE)
        );
        pnlDesktopLayout.setVerticalGroup(
            pnlDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lblWelcomeName.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblWelcomeName.setText("Welcome Admin Admin");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/profile.png"))); // NOI18N
        jButton2.setContentAreaFilled(false);

        lblUsername.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(102, 102, 102));
        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUsername.setText("admin_admin");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Electronic Configuration - Science");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblWelcomeName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblUsername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblWelcomeName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlDesktop)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDesktop)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLevel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLevel1ActionPerformed
        // TODO add your handling code here:
        lvl2.setVisible(false);
        lvl2_II.setVisible(false);
        lvl1.setVisible(true);
        lvl1.Setdata(RegisterId);
        try {
            lvl1.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(ElectronicConfiguration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLevel1ActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        ScienceMain scienceMain = new ScienceMain();
        scienceMain.Setdata(RegisterId);
        scienceMain.show();
        this.dispose();


    }//GEN-LAST:event_btnBackActionPerformed

    private void btnLevel2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLevel2ActionPerformed
        // TODO add your handling code here:
        openElectronicConfigurationLevel2();
    }//GEN-LAST:event_btnLevel2ActionPerformed

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
            java.util.logging.Logger.getLogger(ElectronicConfiguration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ElectronicConfiguration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ElectronicConfiguration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ElectronicConfiguration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ElectronicConfiguration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnLevel1;
    private javax.swing.JButton btnLevel2;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblLevel1Complete;
    private javax.swing.JLabel lblLevel1Marks;
    private javax.swing.JLabel lblLevel2Complete;
    private javax.swing.JLabel lblLevel2Marks;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblWelcomeName;
    private javax.swing.JDesktopPane pnlDesktop;
    // End of variables declaration//GEN-END:variables
}
