/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mmaam
 */
public class AllScores extends javax.swing.JFrame {

    /**
     * Creates new form AllScores
     */
    String RegisterId = "";

    public AllScores() {
        initComponents();
        Setdata("1");
    }

    public void Setdata(String ID) {
        RegisterId = ID;
        setMyDetails(ID);
        tableDesign();
        loadTableData();
    }

    public void setMyDetails(String regID) {
        try {
            Connection con = Database.db.getConnection();
            //Reg Details
            String sqlReg = "SELECT stdFirstName,stdLastName,stdUsername,stdTotalMarks, stdTotalComplete FROM digital_learning_game.register where stdRegisterId=?;";
            PreparedStatement stReg = con.prepareStatement(sqlReg);
            stReg.setString(1, regID);
            ResultSet rsReg = stReg.executeQuery();
            while (rsReg.next()) {
                String myFirstName = rsReg.getString("stdFirstName");
                String myLastName = rsReg.getString("stdLastName");
                String myUsername = rsReg.getString("stdUsername");
                String myTtlComplete = rsReg.getString("stdTotalComplete");
                String myTtlMarks = rsReg.getString("stdTotalMarks");
                lblWelcomeName.setText("Welcome "+myFirstName+" "+myLastName);
                lblMyUsername.setText(myUsername);
                lblMyComplete.setText("Completed : " + myTtlComplete + "%");
                lblMyMarks.setText("Marks : " + myTtlMarks);
            }
            //Maths Details
            String sqlMaths = "SELECT mathsTotalMarks,mathsTotalComplete FROM digital_learning_game.maths where stdRegisterId=?;";
            PreparedStatement stMaths = con.prepareStatement(sqlMaths);
            stMaths.setString(1, regID);
            ResultSet rsMaths = stMaths.executeQuery();
            while (rsMaths.next()) {
                String myMathsComplete = rsMaths.getString("mathsTotalComplete");
                String myMathsMarks = rsMaths.getString("mathsTotalMarks");
                lblMyMathsComplete.setText("Completed : " + myMathsComplete + "%");
                lblMyMathsMarks.setText("Marks : " + myMathsMarks);
            }
            //Science Details
            String sqlScience = "SELECT scienceTotalMarks,scienceTotalComplete FROM digital_learning_game.science where stdRegisterId=?;";
            PreparedStatement stScience = con.prepareStatement(sqlScience);
            stScience.setString(1, regID);
            ResultSet rsScience = stScience.executeQuery();
            while (rsScience.next()) {
                String myScienceComplete = rsScience.getString("scienceTotalComplete");
                String myScienceMarks = rsScience.getString("scienceTotalMarks");
                lblMyScienceComplete.setText("Completed : " + myScienceComplete + "%");
                lblMyScienceMarks.setText("Marks : " + myScienceMarks);
            }
            //Ict Details
            String sqlIct = "SELECT ictTotalMarks,ictTotalComplete FROM digital_learning_game.ict where stdRegisterId=?;";
            PreparedStatement stIct = con.prepareStatement(sqlIct);
            stIct.setString(1, regID);
            ResultSet rsIct = stIct.executeQuery();
            while (rsIct.next()) {
                String myIctComplete = rsIct.getString("ictTotalComplete");
                String myIctMarks = rsIct.getString("ictTotalMarks");
                lblMyIctComplete.setText("Completed : " + myIctComplete + "%");
                lblMyIctMarks.setText("Marks : " + myIctMarks);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AllScores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void tableDesign() {
        tblDetails.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        tblDetails.getTableHeader().setOpaque(false);
        tblDetails.getTableHeader().setBackground(new Color(102, 0, 102));
        tblDetails.getTableHeader().setForeground(new Color(255, 255, 255));
        tblDetails.setRowHeight(30);
    }

    public void loadTableData() {
        try {
            int cout  =0;
            Connection con = Database.db.getConnection();
            String sql = "SELECT * FROM digital_learning_game.register order by stdTotalMarks desc;";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            DefaultTableModel tm = (DefaultTableModel) tblDetails.getModel();
            tm.setRowCount(0);
            while (rs.next()) {
                String registerId = rs.getString("stdRegisterId");
                String username = rs.getString("stdUsername");
                String ttlComplete = rs.getString("stdTotalComplete");
                String ttlMarks = rs.getString("stdTotalMarks");
                
                cout++;
                Vector rowData = new Vector<>();
                rowData.add(cout);
                rowData.add(registerId);
                rowData.add(username);
                rowData.add("Completed : " + ttlComplete + "%");
                rowData.add("Marks : " + ttlMarks);
                tm.addRow(rowData);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AllScores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void searchStudent(int searchType, String search) {
        try {
            int cout  =0;
            String sql = "";

            Connection con = Database.db.getConnection();

            if (searchType == 0) {
                sql = "SELECT stdRegisterId,stdUsername,stdTotalComplete,stdTotalMarks FROM digital_learning_game.register where stdRegisterId like '" + search + "%';";
            } else if (searchType == 1) {
                sql = "SELECT stdRegisterId,stdUsername,stdTotalComplete,stdTotalMarks FROM digital_learning_game.register where stdFirstName like '" + search + "%';";
            } else if (searchType == 2) {
                sql = "SELECT stdRegisterId,stdUsername,stdTotalComplete,stdTotalMarks FROM digital_learning_game.register where stdLastName like '" + search + "%';;";
            } else if (searchType == 3) {
                sql = "SELECT stdRegisterId,stdUsername,stdTotalComplete,stdTotalMarks FROM digital_learning_game.register where stdUsername like '" + search + "%';";
            }

            PreparedStatement st = con.prepareStatement(sql);
            //st.setString(1, search);
            ResultSet rs = st.executeQuery();
            DefaultTableModel tm = (DefaultTableModel) tblDetails.getModel();
            tm.setRowCount(0);
            while (rs.next()) {
                cout++;
                String registerId = rs.getString("stdRegisterId");
                String username = rs.getString("stdUsername");
                String ttlComplete = rs.getString("stdTotalComplete");
                String ttlMarks = rs.getString("stdTotalMarks");

                Vector rowData = new Vector<>();
                rowData.add(cout);
                rowData.add(registerId);
                rowData.add(username);
                rowData.add("Completed : " + ttlComplete + "%");
                rowData.add("Marks : " + ttlMarks);
                tm.addRow(rowData);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AllScores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void selectStudent(String regID) {
        pnlDetails.setVisible(true);
        setPersonalDetails(regID);
        setSubjectDetails(regID);
    }

    public void setPersonalDetails(String regID) {
        try {
            Connection con = Database.db.getConnection();
            String sql = "SELECT stdRegisterId,stdFirstName,stdLastName,stdUsername,stdContect,stdRegDate,stdTotalMarks,stdTotalComplete FROM digital_learning_game.register where stdRegisterId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, regID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String registerID = rs.getString("stdRegisterId");
                String firstName = rs.getString("stdFirstName");
                String lastName = rs.getString("stdLastName");
                String username = rs.getString("stdUsername");
                String contect = rs.getString("stdContect");
                Date regDate = rs.getDate("stdRegDate");
                String ttlComplete = rs.getString("stdTotalComplete");
                String ttlMarks = rs.getString("stdTotalMarks");

                lblRegisterID.setText(registerID);
                lblFirstName.setText(firstName);
                lblLastName.setText(lastName);
                lblUsername.setText(username);
                lblContect.setText(contect);
                lblRegisterDate.setText(regDate + "");
                lblTtlComplete.setText("Completed : " + ttlComplete + "%");
                lblTtlMarks.setText("Marks : " + ttlMarks);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AllScores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setSubjectDetails(String regID) {

        try {
            Connection con = Database.db.getConnection();

            // Maths marks
            String sql1 = "SELECT mathsTotalMarks,mathsTotalComplete FROM digital_learning_game.maths where stdRegisterId=?;";
            PreparedStatement st1 = con.prepareStatement(sql1);
            st1.setString(1, regID);
            ResultSet rs1 = st1.executeQuery();
            while (rs1.next()) {
                String mathsCompleted = rs1.getString("mathsTotalComplete");
                String mathsMarks = rs1.getString("mathsTotalMarks");

                lblMathsCompleted.setText("Completed : " + mathsCompleted + "%");
                lblMathsMarks.setText("Marks : " + mathsMarks);
            }

            //Science Marks
            String sql2 = "SELECT scienceTotalMarks,scienceTotalComplete FROM digital_learning_game.science where stdRegisterId=?;";
            PreparedStatement st2 = con.prepareStatement(sql2);
            st2.setString(1, regID);
            ResultSet rs2 = st2.executeQuery();
            while (rs2.next()) {
                String scienceCompleted = rs2.getString("scienceTotalComplete");
                String scienceMarks = rs2.getString("scienceTotalMarks");

                lblScienceCompleted.setText("Completed : " + scienceCompleted + "%");
                lblScienceMarks.setText("Marks : " + scienceMarks);
            }

            //Ict Marks
            String sql3 = "SELECT ictTotalMarks,ictTotalComplete FROM digital_learning_game.ict where stdRegisterId=?;";
            PreparedStatement st3 = con.prepareStatement(sql3);
            st3.setString(1, regID);
            ResultSet rs3 = st3.executeQuery();
            while (rs3.next()) {
                String scienceCompleted = rs3.getString("ictTotalComplete");
                String scienceMarks = rs3.getString("ictTotalMarks");

                lblIctCompleted.setText("Completed : " + scienceCompleted + "%");
                lblIctMarks.setText("Marks : " + scienceMarks);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AllScores.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel7 = new javax.swing.JLabel();
        pnlDetails = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        lblMathsMarks = new javax.swing.JLabel();
        lblMathsCompleted = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        lblIctMarks = new javax.swing.JLabel();
        lblIctCompleted = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        lblScienceMarks = new javax.swing.JLabel();
        lblScienceCompleted = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblRegisterID = new javax.swing.JLabel();
        lblFirstName = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lblContect = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        lblRegisterDate = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        lblTtlComplete = new javax.swing.JLabel();
        lblTtlMarks = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetails = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lblMyMarks = new javax.swing.JLabel();
        lblMyComplete = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel6 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        lblMyMathsMarks = new javax.swing.JLabel();
        lblMyMathsComplete = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        lblMyScienceMarks = new javax.swing.JLabel();
        lblMyScienceComplete = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        lblMyIctMarks = new javax.swing.JLabel();
        lblMyIctComplete = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        cmbSearchType = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        btnClear = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblWelcomeName = new javax.swing.JLabel();
        lblMyUsername = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 0, 102));
        jLabel7.setText("ALL SCORES");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pnlDetails.setBackground(new java.awt.Color(237, 234, 255));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Methametics");
        jPanel10.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 140, -1));

        lblMathsMarks.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblMathsMarks.setForeground(new java.awt.Color(255, 255, 255));
        lblMathsMarks.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMathsMarks.setText("Marks : 00");
        jPanel10.add(lblMathsMarks, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 70, 160, -1));

        lblMathsCompleted.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblMathsCompleted.setForeground(new java.awt.Color(255, 255, 255));
        lblMathsCompleted.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMathsCompleted.setText("Completed : 0%");
        jPanel10.add(lblMathsCompleted, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 40, 160, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SidePnlMathametics.png"))); // NOI18N
        jPanel10.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("ICT");
        jPanel11.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 140, -1));

        lblIctMarks.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblIctMarks.setForeground(new java.awt.Color(255, 255, 255));
        lblIctMarks.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIctMarks.setText("Marks : 00");
        jPanel11.add(lblIctMarks, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 70, 160, -1));

        lblIctCompleted.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblIctCompleted.setForeground(new java.awt.Color(255, 255, 255));
        lblIctCompleted.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIctCompleted.setText("Completed : 0%");
        jPanel11.add(lblIctCompleted, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 40, 160, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SidePnlICT.png"))); // NOI18N
        jPanel11.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Science");
        jPanel12.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 140, -1));

        lblScienceMarks.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblScienceMarks.setForeground(new java.awt.Color(255, 255, 255));
        lblScienceMarks.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblScienceMarks.setText("Marks : 00");
        jPanel12.add(lblScienceMarks, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 70, 160, -1));

        lblScienceCompleted.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblScienceCompleted.setForeground(new java.awt.Color(255, 255, 255));
        lblScienceCompleted.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblScienceCompleted.setText("Completed : 0%");
        jPanel12.add(lblScienceCompleted, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 40, 160, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SidePnlScience.png"))); // NOI18N
        jPanel12.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 833, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(557, Short.MAX_VALUE)))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(557, 557, 557)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(281, 281, 281)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(282, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Personal Details");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel4.setText("Register ID");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel5.setText("First Name");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel6.setText("Last Name");

        lblRegisterID.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblRegisterID.setText("X X X X");

        lblFirstName.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblFirstName.setText("X X X X");

        lblLastName.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblLastName.setText("X X X X");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel10.setText("Username");

        lblUsername.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblUsername.setText("X X X X");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel27.setText("Telephone");

        lblContect.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblContect.setText("X X X X");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel28.setText("Reg Date");

        lblRegisterDate.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblRegisterDate.setText("X X X X");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblLastName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblRegisterID, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblRegisterDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblContect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(lblUsername))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(lblRegisterID)))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblFirstName)
                    .addComponent(jLabel27)
                    .addComponent(lblContect))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel28)
                        .addComponent(lblRegisterDate))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(lblLastName)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Total Score");

        lblTtlComplete.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTtlComplete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTtlComplete.setText("Select a Student");

        lblTtlMarks.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTtlMarks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTtlMarks.setText("To see the marks");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTtlComplete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTtlMarks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator3))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTtlComplete)
                .addGap(18, 18, 18)
                .addComponent(lblTtlMarks)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlDetailsLayout = new javax.swing.GroupLayout(pnlDetails);
        pnlDetails.setLayout(pnlDetailsLayout);
        pnlDetailsLayout.setHorizontalGroup(
            pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDetailsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlDetailsLayout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlDetailsLayout.setVerticalGroup(
            pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tblDetails.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No", "Register ID", "Username", "Total Complete", "Total Marks"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDetails.setOpaque(false);
        tblDetails.setSelectionBackground(new java.awt.Color(153, 153, 153));
        tblDetails.setShowGrid(false);
        tblDetails.setShowHorizontalLines(true);
        tblDetails.setUpdateSelectionOnSort(false);
        tblDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDetailsMouseClicked(evt);
            }
        });
        tblDetails.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblDetailsKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblDetails);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel14.setText("My Score");

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMyMarks.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblMyMarks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMyMarks.setText("Marks : 00");
        jPanel7.add(lblMyMarks, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 230, -1));

        lblMyComplete.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblMyComplete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMyComplete.setText("Completed : 0%");
        jPanel7.add(lblMyComplete, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 230, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("My Score");
        jPanel7.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 230, -1));

        jSeparator6.setForeground(new java.awt.Color(102, 0, 102));
        jPanel7.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 210, 10));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/myScorePnl.png"))); // NOI18N
        jPanel7.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 249, 160));

        jSeparator1.setForeground(new java.awt.Color(102, 0, 102));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Methametics");
        jPanel13.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 140, -1));

        lblMyMathsMarks.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblMyMathsMarks.setForeground(new java.awt.Color(255, 255, 255));
        lblMyMathsMarks.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMyMathsMarks.setText("Marks : 00");
        jPanel13.add(lblMyMathsMarks, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 70, 160, -1));

        lblMyMathsComplete.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblMyMathsComplete.setForeground(new java.awt.Color(255, 255, 255));
        lblMyMathsComplete.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMyMathsComplete.setText("Completed : 0%");
        jPanel13.add(lblMyMathsComplete, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 40, 160, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SidePnlMathametics.png"))); // NOI18N
        jPanel13.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Science");
        jPanel15.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 140, -1));

        lblMyScienceMarks.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblMyScienceMarks.setForeground(new java.awt.Color(255, 255, 255));
        lblMyScienceMarks.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMyScienceMarks.setText("Marks : 00");
        jPanel15.add(lblMyScienceMarks, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 70, 160, -1));

        lblMyScienceComplete.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblMyScienceComplete.setForeground(new java.awt.Color(255, 255, 255));
        lblMyScienceComplete.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMyScienceComplete.setText("Completed : 0%");
        jPanel15.add(lblMyScienceComplete, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 40, 160, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SidePnlScience.png"))); // NOI18N
        jPanel15.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("ICT");
        jPanel14.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 140, -1));

        lblMyIctMarks.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblMyIctMarks.setForeground(new java.awt.Color(255, 255, 255));
        lblMyIctMarks.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMyIctMarks.setText("Marks : 00");
        jPanel14.add(lblMyIctMarks, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 70, 160, -1));

        lblMyIctComplete.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblMyIctComplete.setForeground(new java.awt.Color(255, 255, 255));
        lblMyIctComplete.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMyIctComplete.setText("Completed : 0%");
        jPanel14.add(lblMyIctComplete, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 40, 160, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SidePnlICT.png"))); // NOI18N
        jPanel14.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 282, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 372, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 254, Short.MAX_VALUE)))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(248, 248, 248)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(124, 124, 124)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(130, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap(30, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(15, 15, 15)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(173, 173, 173)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(45, 45, 45)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(399, Short.MAX_VALUE)))
        );

        cmbSearchType.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        cmbSearchType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Register ID", "First Name", "Last Name", "Username" }));

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnClear.setText("X");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton2.setText("Expand / Hide");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lblWelcomeName.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblWelcomeName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWelcomeName.setText("Welcome Admin Admin");

        lblMyUsername.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblMyUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMyUsername.setText("admin_admin");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblWelcomeName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMyUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblWelcomeName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMyUsername)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(pnlDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(cmbSearchType, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbSearchType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnClear)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (pnlDetails.isVisible()) {
            pnlDetails.setVisible(false);
        } else {
            pnlDetails.setVisible(true);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:

        int searchType = cmbSearchType.getSelectedIndex();
        String search = txtSearch.getText();

        pnlDetails.setVisible(false);

        searchStudent(searchType, search);
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        pnlDetails.setVisible(true);
        txtSearch.setText("");
        loadTableData();
    }//GEN-LAST:event_btnClearActionPerformed

    private void tblDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDetailsMouseClicked
        // TODO add your handling code here:

        int row = tblDetails.getSelectedRow();
        String regID = tblDetails.getModel().getValueAt(row, 1).toString();
        selectStudent(regID);
    }//GEN-LAST:event_tblDetailsMouseClicked

    private void tblDetailsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblDetailsKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            //UP arrow key code
            int row = tblDetails.getSelectedRow();
            String regID = tblDetails.getModel().getValueAt(row, 1).toString();
            selectStudent(regID);
        }
    }//GEN-LAST:event_tblDetailsKeyReleased

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
            java.util.logging.Logger.getLogger(AllScores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AllScores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AllScores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AllScores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AllScores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JComboBox<String> cmbSearchType;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel lblContect;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblIctCompleted;
    private javax.swing.JLabel lblIctMarks;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblMathsCompleted;
    private javax.swing.JLabel lblMathsMarks;
    private javax.swing.JLabel lblMyComplete;
    private javax.swing.JLabel lblMyIctComplete;
    private javax.swing.JLabel lblMyIctMarks;
    private javax.swing.JLabel lblMyMarks;
    private javax.swing.JLabel lblMyMathsComplete;
    private javax.swing.JLabel lblMyMathsMarks;
    private javax.swing.JLabel lblMyScienceComplete;
    private javax.swing.JLabel lblMyScienceMarks;
    private javax.swing.JLabel lblMyUsername;
    private javax.swing.JLabel lblRegisterDate;
    private javax.swing.JLabel lblRegisterID;
    private javax.swing.JLabel lblScienceCompleted;
    private javax.swing.JLabel lblScienceMarks;
    private javax.swing.JLabel lblTtlComplete;
    private javax.swing.JLabel lblTtlMarks;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblWelcomeName;
    private javax.swing.JPanel pnlDetails;
    private javax.swing.JTable tblDetails;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
