/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ICT;

import Main.Subjects;
import Science.MapMaking;
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
public class LogicGates extends javax.swing.JFrame {

    /**
     * Creates new form LogicGates
     */
    String RegisterId;

    public LogicGates() {
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
            Logger.getLogger(Subjects.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setSubjectDetails(String ID) {
        try {
            Connection con = Database.db.getConnection();
            String sql = "SELECT basicLogicGates_marks,basicLogicGates_complete,advanceLogicGates_BooleanMap_marks,advanceLogicGates_BooleanMap_complete FROM digital_learning_game.ict where stdRegisterId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                // get data from database
                String basicLogicGatesComplete = rs.getString("basicLogicGates_complete");
                String basicLogicGatesMarks = rs.getString("basicLogicGates_marks");

                String advanceLogicGates_BooleanMapComplete = rs.getString("advanceLogicGates_BooleanMap_complete");
                String advanceLogicGates_BooleanMapMarks = rs.getString("advanceLogicGates_BooleanMap_marks");

                int completeBasicLogic = Integer.valueOf(basicLogicGatesComplete);
                int completeAdvanceLogic = Integer.valueOf(advanceLogicGates_BooleanMapComplete);
                int complete = completeBasicLogic + completeAdvanceLogic;

                int marksBasicLogic = Integer.valueOf(basicLogicGatesMarks);
                int marksAdvanceLogic = Integer.valueOf(advanceLogicGates_BooleanMapMarks);
                int marks = marksBasicLogic + marksAdvanceLogic;

                //Set data to form
                lblBasicLogicGateComplete.setText("Completed : " + basicLogicGatesComplete + "%");
                lblBasicLogicGateMarks.setText("Marks : " + basicLogicGatesMarks);

                lblBooleanToMapComplete.setText("Completed : " + advanceLogicGates_BooleanMapComplete + "%");
                lblBooleanToMapMarks.setText("Marks : " + advanceLogicGates_BooleanMapMarks);

                lblComplete.setText("Completed : " + complete / 2 + "%");
                lblMarks.setText("Marks : " + marks);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MapMaking.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(LogicGates.class.getName()).log(Level.SEVERE, null, ex);
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
        btnBasicLogicGates = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        btnBooleanToMap = new javax.swing.JButton();
        lblBasicLogicGateComplete = new javax.swing.JLabel();
        lblBasicLogicGateMarks = new javax.swing.JLabel();
        lblBooleanToMapComplete = new javax.swing.JLabel();
        lblBooleanToMapMarks = new javax.swing.JLabel();
        lblComplete = new javax.swing.JLabel();
        lblMarks = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();

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
        jLabel1.setText("Logic Gates");

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
                .addComponent(lblUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        btnBasicLogicGates.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Btn_BasicLogicGate.png"))); // NOI18N
        btnBasicLogicGates.setContentAreaFilled(false);
        btnBasicLogicGates.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Btn_BasicLogicGate_Hover.png"))); // NOI18N
        btnBasicLogicGates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBasicLogicGatesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBasicLogicGates, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBasicLogicGates, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        btnBooleanToMap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Btn_BooleanToMap.png"))); // NOI18N
        btnBooleanToMap.setContentAreaFilled(false);
        btnBooleanToMap.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Btn_BooleanToMap_Hover.png"))); // NOI18N
        btnBooleanToMap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBooleanToMapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBooleanToMap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBooleanToMap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        lblBasicLogicGateComplete.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblBasicLogicGateComplete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBasicLogicGateComplete.setText("Completed : 0%");

        lblBasicLogicGateMarks.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblBasicLogicGateMarks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBasicLogicGateMarks.setText("Marks : 0");

        lblBooleanToMapComplete.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblBooleanToMapComplete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBooleanToMapComplete.setText("Completed : 0%");

        lblBooleanToMapMarks.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblBooleanToMapMarks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBooleanToMapMarks.setText("Marks : 0");

        lblComplete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblComplete.setForeground(new java.awt.Color(102, 102, 102));
        lblComplete.setText("Completed : 0%");

        lblMarks.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMarks.setForeground(new java.awt.Color(102, 102, 102));
        lblMarks.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMarks.setText("Marks : 00");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblBasicLogicGateComplete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblBasicLogicGateMarks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblBooleanToMapComplete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblBooleanToMapMarks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblComplete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblMarks)))
                .addContainerGap())
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
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblBasicLogicGateComplete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblBasicLogicGateMarks))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblBooleanToMapComplete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblBooleanToMapMarks)))
                .addContainerGap(114, Short.MAX_VALUE))
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
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void btnBasicLogicGatesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBasicLogicGatesActionPerformed
        // TODO add your handling code here:
        BasicLogicGates basicLogicGates = new BasicLogicGates();
        basicLogicGates.Setdata(RegisterId);
        basicLogicGates.show();
        this.dispose();
    }//GEN-LAST:event_btnBasicLogicGatesActionPerformed

    private void btnBooleanToMapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBooleanToMapActionPerformed
        // TODO add your handling code here:
        AdvanceLogicGates_BooleanToMap booleanToMap = new AdvanceLogicGates_BooleanToMap();
        booleanToMap.Setdata(RegisterId);
        booleanToMap.show();
        this.dispose();
    }//GEN-LAST:event_btnBooleanToMapActionPerformed

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
            java.util.logging.Logger.getLogger(LogicGates.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogicGates.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogicGates.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogicGates.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogicGates().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBasicLogicGates;
    private javax.swing.JButton btnBooleanToMap;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblBasicLogicGateComplete;
    private javax.swing.JLabel lblBasicLogicGateMarks;
    private javax.swing.JLabel lblBooleanToMapComplete;
    private javax.swing.JLabel lblBooleanToMapMarks;
    private javax.swing.JLabel lblComplete;
    private javax.swing.JLabel lblMarks;
    private javax.swing.JLabel lblSidePnlFundamentalsComplete;
    private javax.swing.JLabel lblSidePnlFundamentalsMarks;
    private javax.swing.JLabel lblSidePnlIctComplete;
    private javax.swing.JLabel lblSidePnlIctMarks;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblWelcomeName;
    // End of variables declaration//GEN-END:variables
}
