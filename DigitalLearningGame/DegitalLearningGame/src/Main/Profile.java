/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author mmaam
 */
public class Profile extends javax.swing.JFrame {

    /**
     * Creates new form Profile
     */
    String RegisterId = "";

    public Profile() {
        initComponents();
        pnlManageMyAccout.setVisible(false);
    }

    public void Setdata(String ID) {
        RegisterId = ID;
        setRegisterData();
        setSubjectDetais();
    }

    public void setRegisterData() {
        try {
            Connection con = Database.db.getConnection();
            String sql = "SELECT stdFirstName,stdLastName,stdUsername,stdContect,stdRegDate,stdTotalMarks, stdTotalComplete FROM digital_learning_game.register where stdRegisterId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, RegisterId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String fName = rs.getString("stdFirstName");
                String lName = rs.getString("stdLastName");
                String username = rs.getString("stdUsername");
                String contect = rs.getString("stdContect");
                Date regDate = rs.getDate("stdRegDate");
                String marks = rs.getString("stdTotalMarks");
                String complete = rs.getString("stdTotalComplete");

                //Set data
                lblNameHeader.setText(fName + " " + lName);
                lblUsernameHeader.setText(username);

                //setdata 2
                lblRegisterId.setText(RegisterId);
                lblName.setText(fName + " " + lName);
                lblUsername.setText(username);
                lblContect.setText(contect);
                lblRegisterDate.setText(regDate + "");
                
                //setdata3
                lblComplete.setText("Completed : "+complete+"%");
                lblMarks.setText("Total Marks : "+marks);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setSubjectDetais(){
        try {
            Connection con = Database.db.getConnection();
            String sqlMaths = "SELECT mathsTotalMarks,mathsTotalComplete FROM digital_learning_game.maths where stdRegisterId=?;";
            String sqlScience = "SELECT scienceTotalMarks,scienceTotalComplete FROM digital_learning_game.science where stdRegisterId=?;";
            String sqlIct = "SELECT ictTotalMarks,ictTotalComplete FROM digital_learning_game.ict where stdRegisterId=?;";
            
            PreparedStatement stMaths = con.prepareStatement(sqlMaths);
            PreparedStatement stScience = con.prepareStatement(sqlScience);
            PreparedStatement stIct = con.prepareStatement(sqlIct);
            
            stMaths.setString(1,RegisterId);
            stScience.setString(1,RegisterId);
            stIct.setString(1,RegisterId);
            
            ResultSet rsMaths = stMaths.executeQuery();
            ResultSet rsScience = stScience.executeQuery();
            ResultSet rsIct = stIct.executeQuery();
            while (rsMaths.next()) {                
                String mathsMarks = rsMaths.getString("mathsTotalMarks");
                String mathsComplete = rsMaths.getString("mathsTotalComplete");
                
                lblMathsMarks.setText("Marks : "+mathsMarks);
                lblMathsComplete.setText("Completed : "+mathsComplete+"%");
            }
            
            while (rsScience.next()) {                
                String scienceMarks = rsScience.getString("scienceTotalMarks");
                String scienceComplete = rsScience.getString("scienceTotalComplete");
                
                 lblScienceMarks.setText("Marks : "+scienceMarks);
                lblScienceComplete.setText("Completed : "+scienceComplete+"%");
            }
            
            while (rsIct.next()) {                
                String ictMarks = rsIct.getString("ictTotalMarks");
                String ictComplete = rsIct.getString("ictTotalComplete");
                
                lblIctMarks.setText("Marks : "+ictMarks);
                lblIctComplete.setText("Completed : "+ictComplete+"%");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //EditDetails
    public void setDataToTextBox() {
        try {
            Connection con = Database.db.getConnection();
            String sql = "SELECT stdFirstName,stdLastName,stdContect,stdPassword FROM digital_learning_game.register where stdRegisterId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, RegisterId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String fName = rs.getString("stdFirstName");
                String lName = rs.getString("stdLastName");
                String contect = rs.getString("stdContect");
                String password = rs.getString("stdPassword");

                //setdata 2
                txtFirstName.setText(fName);
                txtLastName.setText(lName);
                txtContect.setText(contect);
                txtPassword.setText(password);
                txtConfirmPassword.setText(password);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saveDetails() {
        String fname = txtFirstName.getText();
        String lname = txtLastName.getText();
        String contect = txtContect.getText();
        String password = txtPassword.getText();
        String confirmPassword = txtConfirmPassword.getText();

        if (fname.equals("") || lname.equals("") || password.equals("") || confirmPassword.equals("")) {
            JOptionPane.showMessageDialog(this, "some Feilds are Emplty");
        } else {
            if (password.equals(confirmPassword)) {
                try {
                    // create connection to database
                    Connection con = Database.db.getConnection();
                    // Create prepared statement with the sql query
                    String sql = "UPDATE `digital_learning_game`.`register` SET `stdFirstName` = ?, `stdLastName` = ?, `stdContect` = ?, `stdPassword` = ? WHERE (`stdRegisterId` = '" + RegisterId + "');";
                    PreparedStatement st1 = con.prepareStatement(sql);
                    st1.setString(1, fname);
                    st1.setString(2, lname);
                    st1.setString(3, contect);
                    st1.setString(4, password);
                    // execute query
                    st1.executeUpdate();

                    // show success message
                    JOptionPane.showMessageDialog(this, "Successfully Updated");
                    pnlManageMyAccout.setVisible(false);
                    pnlMyProfileInformation.setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Password and confirm password is not match");
            }
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblNameHeader = new javax.swing.JLabel();
        lblUsernameHeader = new javax.swing.JLabel();
        pnlMyProfileInformation = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblRegisterId = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblContect = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblRegisterDate = new javax.swing.JLabel();
        btnEditDetails = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        lblMathsComplete = new javax.swing.JLabel();
        lblMathsMarks = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        lblScienceComplete = new javax.swing.JLabel();
        lblScienceMarks = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        lblIctComplete = new javax.swing.JLabel();
        lblIctMarks = new javax.swing.JLabel();
        lblComplete = new javax.swing.JLabel();
        lblMarks = new javax.swing.JLabel();
        pnlManageMyAccout = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtContect = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        txtConfirmPassword = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        btnSaveDetails = new javax.swing.JButton();
        btnSaveDetails1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 102));
        jLabel1.setText("PROFILE");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Digital Learning Game");

        lblNameHeader.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblNameHeader.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNameHeader.setText("Admin Admin");

        lblUsernameHeader.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblUsernameHeader.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUsernameHeader.setText("admin_admin");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNameHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                    .addComponent(lblUsernameHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblNameHeader)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUsernameHeader)))
                .addGap(16, 16, 16))
        );

        pnlMyProfileInformation.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setText("My Profile Information");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Register Id :");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Student Name :");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Student Username :");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Student Contect :");

        lblRegisterId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblRegisterId.setText("000");

        lblName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblName.setText("Admin Admin");

        lblUsername.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblUsername.setText("admin_admin");

        lblContect.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblContect.setText("adminadmin@gmail.com");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Register Date :");

        lblRegisterDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblRegisterDate.setText("0000/00/00");

        btnEditDetails.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnEditDetails.setForeground(new java.awt.Color(153, 0, 153));
        btnEditDetails.setText("Edit Details");
        btnEditDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditDetailsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMyProfileInformationLayout = new javax.swing.GroupLayout(pnlMyProfileInformation);
        pnlMyProfileInformation.setLayout(pnlMyProfileInformationLayout);
        pnlMyProfileInformationLayout.setHorizontalGroup(
            pnlMyProfileInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMyProfileInformationLayout.createSequentialGroup()
                .addGroup(pnlMyProfileInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMyProfileInformationLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(pnlMyProfileInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlMyProfileInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlMyProfileInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlMyProfileInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblRegisterId, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lblContect, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblRegisterDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlMyProfileInformationLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addGroup(pnlMyProfileInformationLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnEditDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlMyProfileInformationLayout.setVerticalGroup(
            pnlMyProfileInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMyProfileInformationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMyProfileInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRegisterId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMyProfileInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMyProfileInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMyProfileInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblContect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMyProfileInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRegisterDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addComponent(btnEditDetails)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setText("My Score");

        jPanel4.setBackground(new java.awt.Color(245, 245, 245));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 0, 102));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Mathametics");

        lblMathsComplete.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblMathsComplete.setText("Completed : 0%");

        lblMathsMarks.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblMathsMarks.setText("Marks : 000");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblMathsComplete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12)
                        .addComponent(lblMathsMarks)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMathsMarks)
                    .addComponent(lblMathsComplete))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(245, 245, 245));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 0, 102));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Science");

        lblScienceComplete.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblScienceComplete.setText("Completed : 0%");

        lblScienceMarks.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblScienceMarks.setText("Marks : 000");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lblScienceComplete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12)
                        .addComponent(lblScienceMarks)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel20)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblScienceMarks)
                    .addComponent(lblScienceComplete))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(245, 245, 245));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 0, 102));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Information Technology");

        lblIctComplete.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblIctComplete.setText("Completed : 0%");

        lblIctMarks.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblIctMarks.setText("Marks : 000");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lblIctComplete, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                        .addGap(12, 12, 12)
                        .addComponent(lblIctMarks)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel23)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIctMarks)
                    .addComponent(lblIctComplete))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        lblComplete.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblComplete.setForeground(new java.awt.Color(102, 102, 102));
        lblComplete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblComplete.setText("Completed : ");

        lblMarks.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblMarks.setForeground(new java.awt.Color(102, 102, 102));
        lblMarks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMarks.setText("Marks :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(lblComplete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMarks, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(lblComplete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMarks)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        pnlManageMyAccout.setBackground(new java.awt.Color(255, 255, 255));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel28.setText("Manage My Account");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel29.setText("First Name :");

        txtFirstName.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtFirstName.setText("jTextField1");

        txtLastName.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtLastName.setText("jTextField1");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel30.setText("Last Name :");

        txtContect.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtContect.setText("jTextField1");

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel31.setText("Contect :");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel32.setText("Password :");

        txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtPassword.setText("jTextField1");

        txtConfirmPassword.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtConfirmPassword.setText("jTextField1");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel33.setText("Confirm Password :");

        btnSaveDetails.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnSaveDetails.setForeground(new java.awt.Color(102, 0, 102));
        btnSaveDetails.setText("Update");
        btnSaveDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveDetailsActionPerformed(evt);
            }
        });

        btnSaveDetails1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnSaveDetails1.setForeground(new java.awt.Color(102, 102, 102));
        btnSaveDetails1.setText("Reset Default");
        btnSaveDetails1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 2, true));
        btnSaveDetails1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveDetails1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlManageMyAccoutLayout = new javax.swing.GroupLayout(pnlManageMyAccout);
        pnlManageMyAccout.setLayout(pnlManageMyAccoutLayout);
        pnlManageMyAccoutLayout.setHorizontalGroup(
            pnlManageMyAccoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlManageMyAccoutLayout.createSequentialGroup()
                .addGroup(pnlManageMyAccoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlManageMyAccoutLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlManageMyAccoutLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlManageMyAccoutLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlManageMyAccoutLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtContect, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlManageMyAccoutLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlManageMyAccoutLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlManageMyAccoutLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSaveDetails1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSaveDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlManageMyAccoutLayout.setVerticalGroup(
            pnlManageMyAccoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlManageMyAccoutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlManageMyAccoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlManageMyAccoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlManageMyAccoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txtContect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlManageMyAccoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlManageMyAccoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(txtConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 28, Short.MAX_VALUE)
                .addGroup(pnlManageMyAccoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSaveDetails, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSaveDetails1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlMyProfileInformation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlManageMyAccout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlMyProfileInformation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlManageMyAccout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditDetailsActionPerformed
        // TODO add your handling code here:
        pnlManageMyAccout.setVisible(true);
        pnlMyProfileInformation.setVisible(false);
        setDataToTextBox();
    }//GEN-LAST:event_btnEditDetailsActionPerformed

    private void btnSaveDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveDetailsActionPerformed
        // TODO add your handling code here:
        saveDetails();
        Setdata(RegisterId);


    }//GEN-LAST:event_btnSaveDetailsActionPerformed

    private void btnSaveDetails1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveDetails1ActionPerformed
        // TODO add your handling code here:
        setDataToTextBox();
    }//GEN-LAST:event_btnSaveDetails1ActionPerformed

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
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Profile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditDetails;
    private javax.swing.JButton btnSaveDetails;
    private javax.swing.JButton btnSaveDetails1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblComplete;
    private javax.swing.JLabel lblContect;
    private javax.swing.JLabel lblIctComplete;
    private javax.swing.JLabel lblIctMarks;
    private javax.swing.JLabel lblMarks;
    private javax.swing.JLabel lblMathsComplete;
    private javax.swing.JLabel lblMathsMarks;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNameHeader;
    private javax.swing.JLabel lblRegisterDate;
    private javax.swing.JLabel lblRegisterId;
    private javax.swing.JLabel lblScienceComplete;
    private javax.swing.JLabel lblScienceMarks;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblUsernameHeader;
    private javax.swing.JPanel pnlManageMyAccout;
    private javax.swing.JPanel pnlMyProfileInformation;
    private javax.swing.JTextField txtConfirmPassword;
    private javax.swing.JTextField txtContect;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtPassword;
    // End of variables declaration//GEN-END:variables
}
