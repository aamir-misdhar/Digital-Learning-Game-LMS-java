/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Login;

import java.awt.Color;
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
public class Register extends javax.swing.JFrame {

    /**
     * Creates new form Register
     */
    public Register() {
        initComponents();
        lblErrorMessage.setVisible(false);
        btnRegister.requestFocus();
    }

    public void registerStudent() {
        lblErrorMessage.setForeground(new Color(204,0,51));
        String firstName = txtFirstName.getText();
        String LastName = txtLastName.getText();
        String username = txtUsername.getText();
        String contect = txtContect.getText();
        if (contect.equals("Enter Email or mobile Number")) {
            contect = "";
        }
        String password = txtPassword.getText();
        String confirmPassword = txtConfirmPassword.getText();

        if ((firstName.equals("") || LastName.equals("") || username.equals("") || password.equals("") || confirmPassword.equals(""))
                || (firstName.equals("Enter First Name") || LastName.equals("Enter Last Name") || username.equals("Enter Username (Required)") || password.equals("Enter Password (Required)") || confirmPassword.equals("Re - Enter Password (Required)"))) {
            lblErrorMessage.setVisible(true);
            lblErrorMessage.setText("Some Required Feilds are Empty, Chack it out");
        } else {
            lblErrorMessage.setVisible(false);
            if (password.equals(confirmPassword)) {
                try {
                    Connection con = Database.db.getConnection();
                    String sql = "SELECT stdUsername FROM digital_learning_game.register where stdUsername=?;";
                    PreparedStatement st = con.prepareStatement(sql);
                    st.setString(1, username);
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        lblErrorMessage.setVisible(true);
                        lblErrorMessage.setText("The username is already Used");
                    } else {
                        // create connection to database
                        String sqlQuary = "INSERT INTO `digital_learning_game`.`register` (`stdFirstName`, `stdLastName`, `stdUsername`, `stdContect`, `stdPassword`) VALUES (?, ?, ?, ?, ?);";
                        PreparedStatement st1 = con.prepareStatement(sqlQuary);
                        st1.setString(1, firstName);
                        st1.setString(2, LastName);
                        st1.setString(3, username);
                        st1.setString(4, contect);
                        st1.setString(5, password);
                        // execute query
                        st1.executeUpdate();
                        subjectSQL(username);
                        // show success message
                        //JOptionPane.showMessageDialog(this, "Successfully Inserted...");
                        lblErrorMessage.setText("Successfully Registerd");
                        lblErrorMessage.setForeground(new Color(0,153,0));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                lblErrorMessage.setVisible(true);
                lblErrorMessage.setText("Your password and Confirm passwerd are not match");
            }
        }

    }

    public void subjectSQL(String username) {

        String regId = "";
        try {
            Connection con = Database.db.getConnection();
            String sql = "SELECT stdRegisterId FROM digital_learning_game.register where stdUsername=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                regId = rs.getString("stdRegisterId");

            }
        } catch (SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Set data into other tables
        try {
            // create connection to database
            Connection con = Database.db.getConnection();
            // Create prepared statement with the sql query
            PreparedStatement st1 = con.prepareStatement("INSERT INTO `digital_learning_game`.`science` (`stdRegisterId`) VALUES (?);");
            st1.setString(1, regId);

            PreparedStatement st2 = con.prepareStatement("INSERT INTO `digital_learning_game`.`maths` (`stdRegisterId`) VALUES (?);");
            st2.setString(1, regId);

            PreparedStatement st3 = con.prepareStatement("INSERT INTO `digital_learning_game`.`ict` (`stdRegisterId`) VALUES (?);");
            st3.setString(1, regId);

            PreparedStatement st4 = con.prepareStatement("INSERT INTO `digital_learning_game`.`history` (`stdRegisterId`) VALUES (?);");
            st4.setString(1, regId);
            // execute query
            st1.executeUpdate();
            st2.executeUpdate();
            st3.executeUpdate();
            st4.executeUpdate();

            // show success message
            //JOptionPane.showMessageDialog(this, "Successfully Inserted...");
        } catch (SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtContect = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        txtConfirmPassword = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        btnRegister = new javax.swing.JButton();
        lblErrorMessage = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 102));
        jLabel2.setText("Register");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 460, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("First Name*");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, -1, 30));

        txtFirstName.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtFirstName.setForeground(new java.awt.Color(153, 153, 153));
        txtFirstName.setText("Enter First Name");
        txtFirstName.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtFirstName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFirstNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFirstNameFocusLost(evt);
            }
        });
        txtFirstName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFirstNameKeyReleased(evt);
            }
        });
        jPanel1.add(txtFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 150, 30));

        txtLastName.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtLastName.setForeground(new java.awt.Color(153, 153, 153));
        txtLastName.setText("Enter Last Name");
        txtLastName.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtLastName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtLastNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLastNameFocusLost(evt);
            }
        });
        jPanel1.add(txtLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 150, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Last Name*");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, -1, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Username*");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, -1, 30));

        txtUsername.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(153, 153, 153));
        txtUsername.setText("Enter Username (Required)");
        txtUsername.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsernameFocusLost(evt);
            }
        });
        jPanel1.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 250, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Contect");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, -1, 30));

        txtContect.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtContect.setForeground(new java.awt.Color(153, 153, 153));
        txtContect.setText("Enter Email or mobile Number");
        txtContect.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtContect.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtContectFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtContectFocusLost(evt);
            }
        });
        jPanel1.add(txtContect, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 360, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Password*");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, -1, 30));

        txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(153, 153, 153));
        txtPassword.setText("Enter Password (Required)");
        txtPassword.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPasswordFocusLost(evt);
            }
        });
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 250, 30));

        txtConfirmPassword.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtConfirmPassword.setForeground(new java.awt.Color(153, 153, 153));
        txtConfirmPassword.setText("Re - Enter Password (Required)");
        txtConfirmPassword.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtConfirmPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtConfirmPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtConfirmPasswordFocusLost(evt);
            }
        });
        jPanel1.add(txtConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 250, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Confirm*");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, -1, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("I Already have an Account");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 520, -1));

        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(102, 0, 102));
        btnLogin.setText("Back to Login");
        btnLogin.setBorder(null);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 480, -1, -1));

        btnRegister.setBackground(new java.awt.Color(102, 0, 102));
        btnRegister.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRegister.setForeground(new java.awt.Color(255, 255, 255));
        btnRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/RegisterButton.png"))); // NOI18N
        btnRegister.setContentAreaFilled(false);
        btnRegister.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/RegisterButton_Hover.png"))); // NOI18N
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, 230, 40));

        lblErrorMessage.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblErrorMessage.setForeground(new java.awt.Color(204, 0, 51));
        lblErrorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblErrorMessage.setText("Error Message");
        jPanel1.add(lblErrorMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, 480, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, 500, 10));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 490, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/RegisterBackgroundImage.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        // TODO add your handling code here:
        registerStudent();
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void txtFirstNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFirstNameFocusGained
        // TODO add your handling code here:      
        if (txtFirstName.getText().equals("Enter First Name")) {
            txtFirstName.setText("");
            txtFirstName.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtFirstNameFocusGained

    private void txtFirstNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFirstNameFocusLost
        // TODO add your handling code here:
        if (txtFirstName.getText().equals("")) {
            txtFirstName.setText("Enter First Name");
            txtFirstName.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtFirstNameFocusLost

    private void txtLastNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLastNameFocusGained
        // TODO add your handling code here:
        if (txtLastName.getText().equals("Enter Last Name")) {
            txtLastName.setText("");
            txtLastName.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtLastNameFocusGained

    private void txtLastNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLastNameFocusLost
        // TODO add your handling code here:
        if (txtLastName.getText().equals("")) {
            txtLastName.setText("Enter Last Name");
            txtLastName.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtLastNameFocusLost

    private void txtUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusGained
        // TODO add your handling code here:
        if (txtUsername.getText().equals("Enter Username (Required)")) {
            txtUsername.setText("");
            txtUsername.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtUsernameFocusGained

    private void txtUsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusLost
        // TODO add your handling code here:
        if (txtUsername.getText().equals("")) {
            txtUsername.setText("Enter Username (Required)");
            txtUsername.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtUsernameFocusLost

    private void txtContectFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContectFocusGained
        // TODO add your handling code here:
        if (txtContect.getText().equals("Enter Email or mobile Number")) {
            txtContect.setText("");
            txtContect.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtContectFocusGained

    private void txtContectFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContectFocusLost
        // TODO add your handling code here:
        if (txtContect.getText().equals("")) {
            txtContect.setText("Enter Email or mobile Number");
            txtContect.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtContectFocusLost

    private void txtPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusGained
        // TODO add your handling code here:
        if (txtPassword.getText().equals("Enter Password (Required)")) {
            txtPassword.setText("");
            txtPassword.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtPasswordFocusGained

    private void txtPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusLost
        // TODO add your handling code here:
        if (txtPassword.getText().equals("")) {
            txtPassword.setText("Enter Password (Required)");
            txtPassword.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtPasswordFocusLost

    private void txtConfirmPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtConfirmPasswordFocusGained
        // TODO add your handling code here:
        if (txtConfirmPassword.getText().equals("Re - Enter Password (Required)")) {
            txtConfirmPassword.setText("");
            txtConfirmPassword.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtConfirmPasswordFocusGained

    private void txtConfirmPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtConfirmPasswordFocusLost
        // TODO add your handling code here:
        if (txtConfirmPassword.getText().equals("")) {
            txtConfirmPassword.setText("Re - Enter Password (Required)");
            txtConfirmPassword.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtConfirmPasswordFocusLost

    private void txtFirstNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFirstNameKeyReleased
        // TODO add your handling code here:
        if (!Global.Validations.isValidName(txtFirstName.getText())) {
            lblErrorMessage.setVisible(true);
            lblErrorMessage.setText("Wrong firat name");
        } else {
            lblErrorMessage.setVisible(false);
        }
    }//GEN-LAST:event_txtFirstNameKeyReleased

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        Login log = new Login();
        log.show();
        this.dispose();
    }//GEN-LAST:event_btnLoginActionPerformed

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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblErrorMessage;
    private javax.swing.JTextField txtConfirmPassword;
    private javax.swing.JTextField txtContect;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
