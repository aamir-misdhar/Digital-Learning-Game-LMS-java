/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ICT;

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
public class NumberSystem extends javax.swing.JFrame {

    /**
     * Creates new form NumberSystem
     */
    String RegisterId;

    public NumberSystem() {
        initComponents();
    }

    public void Setdata(String ID) {
        RegisterId = ID;
        setRegisterDetails(ID);
        setSubjectDetails(ID);
        setSidePnlData();

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
            Logger.getLogger(NumberSystem.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void setSubjectDetails(String ID) {
        try {
            Connection con = Database.db.getConnection();
            String sql = "SELECT numberSystemAddition10_marks,numberSystemAddition10_complete,numberSystemAddition8_marks,numberSystemAddition8_complete,numberSystemAddition16_marks,numberSystemAddition16_complete,numberSystemAddition2_marks,numberSystemAddition2_complete FROM digital_learning_game.ict where stdRegisterId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                // get data from database
                int numberSystemAddition10_complete = rs.getInt("numberSystemAddition10_complete");
                int numberSystemAddition10_marks = rs.getInt("numberSystemAddition10_marks");

                int numberSystemAddition8_complete = rs.getInt("numberSystemAddition8_complete");
                int numberSystemAddition8_marks = rs.getInt("numberSystemAddition8_marks");

                int numberSystemAddition16_complete = rs.getInt("numberSystemAddition16_complete");
                int numberSystemAddition16_marks = rs.getInt("numberSystemAddition16_marks");

                int numberSystemAddition2_complete = rs.getInt("numberSystemAddition2_complete");
                int numberSystemAddition2_marks = rs.getInt("numberSystemAddition2_marks");

                int complete = numberSystemAddition10_complete + numberSystemAddition8_complete + numberSystemAddition16_complete + numberSystemAddition2_complete;
                int marks = numberSystemAddition10_marks + numberSystemAddition8_marks + numberSystemAddition16_marks + numberSystemAddition2_marks;

                //Set data to form
                lblBase10Complete.setText("Completed : " + numberSystemAddition10_complete + "%");
                lblBase10Marks.setText("Marks : " + numberSystemAddition10_marks);

                lblBase8Complete.setText("Completed : " + numberSystemAddition8_complete + "%");
                lblBase8Marks.setText("Marks : " + numberSystemAddition8_marks);

                lblbase16Complete.setText("Completed : " + numberSystemAddition16_complete + "%");
                lblBase16Marks.setText("Marks : " + numberSystemAddition16_marks);

                lblBase2Complete.setText("Completed : " + numberSystemAddition2_complete + "%");
                lblBase2Marks.setText("Marks : " + numberSystemAddition2_marks);

                lblComplete.setText("Completed : " + complete / 4 + "%");
                lblMarks.setText("Marks : " + marks);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NumberSystem.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void setSidePnlData() {

        try {
            Connection con = Database.db.getConnection();
            String sql = "SELECT (ictMCQ_marks+ictFillInTheBlanks_marks),((ictMCQ_marks+ictFillInTheBlanks_completed)/2),(fundamentalsOfcompSysMCQ_marks+fundamentalsOfcompSysFillInTheBlanks_marks),((fundamentalsOfcompSysMCQ_complete+fundamentalsOfcompSysFillInTheBlanks_completed)/2),(basicLogicGates_marks+advanceLogicGates_BooleanMap_marks),((basicLogicGates_complete+advanceLogicGates_BooleanMap_complete)/2) FROM digital_learning_game.ict where stdRegisterId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, RegisterId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                
                // get data from database
                int ictComplete = rs.getInt("((ictMCQ_marks+ictFillInTheBlanks_completed)/2)");
                int ictMarks = rs.getInt("(ictMCQ_marks+ictFillInTheBlanks_marks)");
                
                int fandamentalsComplete = rs.getInt("((fundamentalsOfcompSysMCQ_complete+fundamentalsOfcompSysFillInTheBlanks_completed)/2)");
                int fandamentalsMarks = rs.getInt("(fundamentalsOfcompSysMCQ_marks+fundamentalsOfcompSysFillInTheBlanks_marks)");
                
                int logicGatesComplete = rs.getInt("((basicLogicGates_complete+advanceLogicGates_BooleanMap_complete)/2)");
                int logicGatesMarks = rs.getInt("(basicLogicGates_marks+advanceLogicGates_BooleanMap_marks)");
                
                //Set data to form
                lblSidePnlIctComplete.setText("Completed : " + ictComplete + "%");
                lblSidePnlIctMarks.setText("Marks : " + ictMarks);
                
                lblSidePnlFundamentalsComplete.setText("Completed : " + fandamentalsComplete + "%");
                lblSidePnlFundamentalsMarks.setText("Marks : " + fandamentalsMarks);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NumberSystem.class.getName()).log(Level.SEVERE, null, ex);
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
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblSidePnlIctComplete = new javax.swing.JLabel();
        lblSidePnlIctMarks = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblSidePnlFundamentalsComplete = new javax.swing.JLabel();
        lblSidePnlFundamentalsMarks = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblWelcomeName = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        lblUsername = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnBase10 = new javax.swing.JButton();
        lblBase10Complete = new javax.swing.JLabel();
        lblBase10Marks = new javax.swing.JLabel();
        lblComplete = new javax.swing.JLabel();
        lblMarks = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel7 = new javax.swing.JPanel();
        btnBase8 = new javax.swing.JButton();
        lblBase8Complete = new javax.swing.JLabel();
        lblBase8Marks = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        btnBase2 = new javax.swing.JButton();
        lblBase2Complete = new javax.swing.JLabel();
        lblBase2Marks = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        btnBase16 = new javax.swing.JButton();
        lblbase16Complete = new javax.swing.JLabel();
        lblBase16Marks = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_Back.png"))); // NOI18N
        btnBack.setText("Back to ICT");
        btnBack.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_Back_Hover.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Other Scores");

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Information & Communication");

        lblSidePnlIctComplete.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblSidePnlIctComplete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSidePnlIctComplete.setText("Completed : 0%");

        lblSidePnlIctMarks.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSidePnlIctMarks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSidePnlIctMarks.setText("Marks : 00");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Technology");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                    .addComponent(lblSidePnlIctComplete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSidePnlIctMarks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator3))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSidePnlIctComplete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSidePnlIctMarks)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Fundamentals of a");

        lblSidePnlFundamentalsComplete.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblSidePnlFundamentalsComplete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSidePnlFundamentalsComplete.setText("Completed : 0%");

        lblSidePnlFundamentalsMarks.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSidePnlFundamentalsMarks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSidePnlFundamentalsMarks.setText("Marks : 00");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Computer System");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSidePnlFundamentalsComplete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSidePnlFundamentalsMarks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator4))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSidePnlFundamentalsComplete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSidePnlFundamentalsMarks)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Number System");

        lblWelcomeName.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblWelcomeName.setText("Welcome Admin");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/profile.png"))); // NOI18N
        jButton3.setContentAreaFilled(false);
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/profile_Hover.png"))); // NOI18N

        lblUsername.setFont(new java.awt.Font("Segoe UI", 3, 16)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(102, 102, 102));
        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUsername.setText("Admin_Admin");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblWelcomeName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblWelcomeName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(40, 40, 40))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        btnBase10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_NumberSystem_Base10.png"))); // NOI18N
        btnBase10.setContentAreaFilled(false);
        btnBase10.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_NumberSystem_Base10_Hover.png"))); // NOI18N
        btnBase10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBase10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(btnBase10, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBase10, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        lblBase10Complete.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblBase10Complete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBase10Complete.setText("Completed : 0%");

        lblBase10Marks.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblBase10Marks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBase10Marks.setText("Marks : 0");

        lblComplete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblComplete.setForeground(new java.awt.Color(102, 102, 102));
        lblComplete.setText("Completed : 0%");

        lblMarks.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMarks.setForeground(new java.awt.Color(102, 102, 102));
        lblMarks.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMarks.setText("Marks : 00");

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        btnBase8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_NumberSystem_Base8.png"))); // NOI18N
        btnBase8.setContentAreaFilled(false);
        btnBase8.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_NumberSystem_Base8_Hover.png"))); // NOI18N
        btnBase8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBase8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(btnBase8, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBase8, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        lblBase8Complete.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblBase8Complete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBase8Complete.setText("Completed : 0%");

        lblBase8Marks.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblBase8Marks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBase8Marks.setText("Marks : 0");

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        btnBase2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_NumberSystem_Base2.png"))); // NOI18N
        btnBase2.setContentAreaFilled(false);
        btnBase2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_NumberSystem_Base2_Hover.png"))); // NOI18N
        btnBase2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBase2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(btnBase2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBase2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        lblBase2Complete.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblBase2Complete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBase2Complete.setText("Completed : 0%");

        lblBase2Marks.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblBase2Marks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBase2Marks.setText("Marks : 0");

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        btnBase16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_NumberSystem_Base16.png"))); // NOI18N
        btnBase16.setContentAreaFilled(false);
        btnBase16.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_NumberSystem_Base16_Hover.png"))); // NOI18N
        btnBase16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBase16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(btnBase16, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBase16, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        lblbase16Complete.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblbase16Complete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblbase16Complete.setText("Completed : 0%");

        lblBase16Marks.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblBase16Marks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBase16Marks.setText("Marks : 0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblComplete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblMarks)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblBase10Complete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblBase10Marks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblBase8Complete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblBase8Marks, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblbase16Complete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblBase16Marks, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblBase2Complete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblBase2Marks, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblComplete)
                    .addComponent(lblMarks))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblBase10Complete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblBase10Marks))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblBase2Complete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblBase2Marks)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblBase8Complete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblBase8Marks))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblbase16Complete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblBase16Marks)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(7, 7, 7))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        IctMain ictMain = new IctMain();
        ictMain.Setdata(RegisterId);
        ictMain.show();
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnBase10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBase10ActionPerformed
        // TODO add your handling code here:
        NumberSystemAdditionBase10 base10 = new NumberSystemAdditionBase10();
        base10.Setdata(RegisterId);
        base10.show();
        this.dispose();
    }//GEN-LAST:event_btnBase10ActionPerformed

    private void btnBase8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBase8ActionPerformed
        // TODO add your handling code here:
        NumberSystemAdditionBase8 base8 = new NumberSystemAdditionBase8();
        base8.Setdata(RegisterId);
        base8.show();
        this.dispose();
    }//GEN-LAST:event_btnBase8ActionPerformed

    private void btnBase2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBase2ActionPerformed
        // TODO add your handling code here:
        NumberSystemAdditionBase2 base2 = new NumberSystemAdditionBase2();
        base2.Setdata(RegisterId);
        base2.show();
        this.dispose();
    }//GEN-LAST:event_btnBase2ActionPerformed

    private void btnBase16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBase16ActionPerformed
        // TODO add your handling code here:
        NumberSystemAdditionBase16 base16 = new NumberSystemAdditionBase16();
        base16.Setdata(RegisterId);
        base16.show();
        this.dispose();
    }//GEN-LAST:event_btnBase16ActionPerformed

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
            java.util.logging.Logger.getLogger(NumberSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NumberSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NumberSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NumberSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NumberSystem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBase10;
    private javax.swing.JButton btnBase16;
    private javax.swing.JButton btnBase2;
    private javax.swing.JButton btnBase8;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblBase10Complete;
    private javax.swing.JLabel lblBase10Marks;
    private javax.swing.JLabel lblBase16Marks;
    private javax.swing.JLabel lblBase2Complete;
    private javax.swing.JLabel lblBase2Marks;
    private javax.swing.JLabel lblBase8Complete;
    private javax.swing.JLabel lblBase8Marks;
    private javax.swing.JLabel lblComplete;
    private javax.swing.JLabel lblMarks;
    private javax.swing.JLabel lblSidePnlFundamentalsComplete;
    private javax.swing.JLabel lblSidePnlFundamentalsMarks;
    private javax.swing.JLabel lblSidePnlIctComplete;
    private javax.swing.JLabel lblSidePnlIctMarks;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblWelcomeName;
    private javax.swing.JLabel lblbase16Complete;
    // End of variables declaration//GEN-END:variables
}
