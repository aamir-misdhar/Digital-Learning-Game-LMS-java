/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ICT;

import Main.Subjects;
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
public class IctMain extends javax.swing.JFrame {

    /**
     * Creates new form IctMain
     */
    String RegisterId = "";

    public IctMain() {
        initComponents();
    }

    public void Setdata(String ID) {
        RegisterId = ID;
        setRegisterDetails(ID);
        setSubjectTotalDetails(ID);
        setIctSubjectDetails(ID);
        setFundementalsOfCompSysSubjectDetails(ID);
        setLogicGatesSubjectDetails(ID);
        setNumberSystemDetails(ID);
        setSidePanalDetails(ID);

        Database.totalDatabse dbTtl = new Database.totalDatabse();
        dbTtl.updateData(ID);
    }

    public void setRegisterDetails(String ID) {
        try {
            Connection con = Database.db.getConnection();
            String sql = "SELECT stdFirstName,stdLastName,stdUsername, stdTotalMarks, stdTotalComplete FROM digital_learning_game.register where stdRegisterId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String firstName = rs.getString("stdFirstName");
                String lastName = rs.getString("stdLastName");
                String username = rs.getString("stdUsername");
                String ttlMarks = rs.getString("stdTotalMarks");
                String ttlComplete = rs.getString("stdTotalComplete");

                lblWelcomeName.setText("Welcome " + firstName + " " + lastName);
                lblUsername.setText(username);
                lblTotalComplete.setText("Completed : "+ttlComplete+"%");
                lblTotalMarks.setText("Marks : "+ttlMarks);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Subjects.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setSubjectTotalDetails(String ID) {
        try {
            Connection con = Database.db.getConnection();
            String sql = "SELECT ictTotalMarks,ictTotalComplete FROM digital_learning_game.ict where stdRegisterId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {                
                String IctCompleted = rs.getString("ictTotalComplete");
                String IctMarks = rs.getString("ictTotalMarks");
                
                lblIctCompleted.setText("Completed : "+IctCompleted+"%");
                lblIctMarks.setText("Marks : "+IctMarks);
            }
        } catch (SQLException ex) {
            Logger.getLogger(IctMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Set Subject Details
    public void setIctSubjectDetails(String ID) {
        try {
            Connection con = Database.db.getConnection();
            String sql = "SELECT (ictMCQ_marks+ictFillInTheBlanks_marks), (ictMCQ_complete+ictFillInTheBlanks_completed) FROM digital_learning_game.ict where stdRegisterId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, RegisterId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                // get data from database
                int ictMCQComplete = rs.getInt("(ictMCQ_complete+ictFillInTheBlanks_completed)");
                int ictMCQMarks = rs.getInt("(ictMCQ_marks+ictFillInTheBlanks_marks)");

                //Set data to form           
                lblIctMcqCompleted.setText("Completed : " + ictMCQComplete/2 + "%");
                lblIctMcqMarks.setText("Marks : " + ictMCQMarks + "/200");
            }

        } catch (SQLException ex) {
            Logger.getLogger(IctMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setFundementalsOfCompSysSubjectDetails(String ID) {
        try {
            Connection con = Database.db.getConnection();
            String sql = "SELECT stdRegisterId, (fundamentalsOfcompSysMCQ_marks+fundamentalsOfcompSysFillInTheBlanks_marks), (fundamentalsOfcompSysMCQ_complete+fundamentalsOfcompSysFillInTheBlanks_completed) FROM digital_learning_game.ict where stdRegisterId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, RegisterId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                // get data from database
                int fundementalsOfCompSysComplete = rs.getInt("(fundamentalsOfcompSysMCQ_complete+fundamentalsOfcompSysFillInTheBlanks_completed)");
                int fundementalsOfCompSysMarks = rs.getInt("(fundamentalsOfcompSysMCQ_marks+fundamentalsOfcompSysFillInTheBlanks_marks)");

                //Set data to form           
                lblFundamentalsOfComputerSystemCompleted.setText("Completed : " + fundementalsOfCompSysComplete/2 + "%");
                lblFundamentalsOfComputerSystemMarks.setText("Marks : " + fundementalsOfCompSysMarks + "/200");
            }

        } catch (SQLException ex) {
            Logger.getLogger(IctMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setLogicGatesSubjectDetails(String ID) {
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
                lblLogicGateCompleted.setText("Completed : " + complete / 2 + "%");
                lblLogicGateMarks.setText("Marks : " + marks + "/200");
            }
        } catch (SQLException ex) {
            Logger.getLogger(IctMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setNumberSystemDetails(String ID) {
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
                lblNumberSystemCompleted.setText("Completed : " + complete / 4 + "%");
                lblNumberSystemMarks.setText("Marks : " + marks + "/400");
            }
        } catch (SQLException ex) {
            Logger.getLogger(IctMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Set Side Panal Details
    public void setSidePanalDetails(String ID) {

        //Maths Details
        try {
            Connection con = Database.db.getConnection();
            String sql = "SELECT mathsTotalMarks,mathsTotalComplete FROM digital_learning_game.maths where stdRegisterId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String mathsTotalMarks = rs.getString("mathsTotalMarks");
                String mathsTotalComplete = rs.getString("mathsTotalComplete");

                lblSidePnlMathsMarks.setText("Marks : " + mathsTotalMarks);
                lblSidePnlMathsCompleted.setText("Completed : " + mathsTotalComplete + "%");
            }
        } catch (SQLException ex) {
            Logger.getLogger(IctMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Science Details
        try {
            Connection con = Database.db.getConnection();
            String sql = "SELECT scienceTotalMarks,scienceTotalComplete  FROM digital_learning_game.science where stdRegisterId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String scienceTotalMarks = rs.getString("scienceTotalMarks");
                String scienceTotalComplete = rs.getString("scienceTotalComplete");

                lblSidePnlScienceMarks.setText("Marks : " + scienceTotalMarks);
                lblSidePnlScienceCompleted.setText("Completed : " + scienceTotalComplete + "%");
            }
        } catch (SQLException ex) {
            Logger.getLogger(IctMain.class.getName()).log(Level.SEVERE, null, ex);
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
        lblWelcomeName = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblIctMcqCompleted = new javax.swing.JLabel();
        lblIctMcqMarks = new javax.swing.JLabel();
        lblIctMcq = new javax.swing.JLabel();
        btnIctMcq = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        lblLogicGateMarks = new javax.swing.JLabel();
        lblLogicGateCompleted = new javax.swing.JLabel();
        lblLogicGates = new javax.swing.JLabel();
        btnLogicGates = new javax.swing.JButton();
        lblIctCompleted = new javax.swing.JLabel();
        lblIctMarks = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel12 = new javax.swing.JPanel();
        lblFundamentalsOfComputerSystemMarks = new javax.swing.JLabel();
        lblFundamentalsOfComputerSystemCompleted = new javax.swing.JLabel();
        lblLogicGates1 = new javax.swing.JLabel();
        btnLogicGates1 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        lblNumberSystemMarks = new javax.swing.JLabel();
        lblNumberSystemCompleted = new javax.swing.JLabel();
        lblNumberSystem = new javax.swing.JLabel();
        btnLogicGates2 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        btnHome1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        lblSidePnlMathsMarks = new javax.swing.JLabel();
        lblSidePnlMathsCompleted = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        lblSidePnlScienceCompleted = new javax.swing.JLabel();
        lblSidePnlScienceMarks = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        lblTotalMarks = new javax.swing.JLabel();
        lblTotalComplete = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblWelcomeName.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblWelcomeName.setForeground(new java.awt.Color(255, 255, 255));
        lblWelcomeName.setText("Welcome Admin");
        jPanel1.add(lblWelcomeName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 320, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Information Technology");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 320, -1));

        lblUsername.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(76, 78, 142));
        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUsername.setText("admin_admin");
        jPanel1.add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 250, 90));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/profile.png"))); // NOI18N
        jButton3.setContentAreaFilled(false);
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/profile_Hover.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, -1, 90));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pnlIctHeader.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 667, 95));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIctMcqCompleted.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblIctMcqCompleted.setForeground(new java.awt.Color(102, 102, 102));
        lblIctMcqCompleted.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIctMcqCompleted.setText("Completed: 100%");
        jPanel3.add(lblIctMcqCompleted, new org.netbeans.lib.awtextra.AbsoluteConstraints(472, 10, 130, -1));

        lblIctMcqMarks.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblIctMcqMarks.setForeground(new java.awt.Color(102, 102, 102));
        lblIctMcqMarks.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIctMcqMarks.setText("Marks: 80/100");
        jPanel3.add(lblIctMcqMarks, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 80, 130, -1));

        lblIctMcq.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblIctMcq.setForeground(new java.awt.Color(0, 51, 51));
        lblIctMcq.setText("Information and Communication Technology");
        lblIctMcq.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblIctMcqMouseClicked(evt);
            }
        });
        jPanel3.add(lblIctMcq, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 350, 30));

        btnIctMcq.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnIctMcq.setForeground(new java.awt.Color(102, 102, 102));
        btnIctMcq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_IctMcqs.png"))); // NOI18N
        btnIctMcq.setContentAreaFilled(false);
        btnIctMcq.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_IctMcqs_Hover.png"))); // NOI18N
        btnIctMcq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIctMcqActionPerformed(evt);
            }
        });
        jPanel3.add(btnIctMcq, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -1, 630, 110));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogicGateMarks.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLogicGateMarks.setForeground(new java.awt.Color(102, 102, 102));
        lblLogicGateMarks.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblLogicGateMarks.setText("Marks: 80/100");
        jPanel8.add(lblLogicGateMarks, new org.netbeans.lib.awtextra.AbsoluteConstraints(461, 80, 140, -1));

        lblLogicGateCompleted.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblLogicGateCompleted.setForeground(new java.awt.Color(102, 102, 102));
        lblLogicGateCompleted.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblLogicGateCompleted.setText("Completed: 100%");
        jPanel8.add(lblLogicGateCompleted, new org.netbeans.lib.awtextra.AbsoluteConstraints(472, 10, 130, -1));

        lblLogicGates.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblLogicGates.setForeground(new java.awt.Color(0, 51, 51));
        lblLogicGates.setText("Logic Gates");
        jPanel8.add(lblLogicGates, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 270, 40));

        btnLogicGates.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnLogicGates.setForeground(new java.awt.Color(102, 102, 102));
        btnLogicGates.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_LogicGates.png"))); // NOI18N
        btnLogicGates.setContentAreaFilled(false);
        btnLogicGates.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_LogicGates_Hover.png"))); // NOI18N
        btnLogicGates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogicGatesActionPerformed(evt);
            }
        });
        jPanel8.add(btnLogicGates, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 630, 110));

        lblIctCompleted.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblIctCompleted.setForeground(new java.awt.Color(102, 102, 102));
        lblIctCompleted.setText("Completed : 0%");

        lblIctMarks.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblIctMarks.setForeground(new java.awt.Color(102, 102, 102));
        lblIctMarks.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIctMarks.setText("Marks : 00");

        jSeparator2.setForeground(new java.awt.Color(76, 78, 142));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFundamentalsOfComputerSystemMarks.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblFundamentalsOfComputerSystemMarks.setForeground(new java.awt.Color(102, 102, 102));
        lblFundamentalsOfComputerSystemMarks.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFundamentalsOfComputerSystemMarks.setText("Marks: 80/100");
        jPanel12.add(lblFundamentalsOfComputerSystemMarks, new org.netbeans.lib.awtextra.AbsoluteConstraints(461, 80, 140, -1));

        lblFundamentalsOfComputerSystemCompleted.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblFundamentalsOfComputerSystemCompleted.setForeground(new java.awt.Color(102, 102, 102));
        lblFundamentalsOfComputerSystemCompleted.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFundamentalsOfComputerSystemCompleted.setText("Completed: 100%");
        jPanel12.add(lblFundamentalsOfComputerSystemCompleted, new org.netbeans.lib.awtextra.AbsoluteConstraints(472, 10, 130, -1));

        lblLogicGates1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblLogicGates1.setForeground(new java.awt.Color(0, 51, 51));
        lblLogicGates1.setText("Fundamentals of a computer  system");
        jPanel12.add(lblLogicGates1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 290, 40));

        btnLogicGates1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnLogicGates1.setForeground(new java.awt.Color(102, 102, 102));
        btnLogicGates1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_LogicGates.png"))); // NOI18N
        btnLogicGates1.setContentAreaFilled(false);
        btnLogicGates1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_LogicGates_Hover.png"))); // NOI18N
        btnLogicGates1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogicGates1ActionPerformed(evt);
            }
        });
        jPanel12.add(btnLogicGates1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 630, 110));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNumberSystemMarks.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNumberSystemMarks.setForeground(new java.awt.Color(102, 102, 102));
        lblNumberSystemMarks.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNumberSystemMarks.setText("Marks: 80/100");
        jPanel13.add(lblNumberSystemMarks, new org.netbeans.lib.awtextra.AbsoluteConstraints(461, 80, 140, -1));

        lblNumberSystemCompleted.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblNumberSystemCompleted.setForeground(new java.awt.Color(102, 102, 102));
        lblNumberSystemCompleted.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNumberSystemCompleted.setText("Completed: 100%");
        jPanel13.add(lblNumberSystemCompleted, new org.netbeans.lib.awtextra.AbsoluteConstraints(472, 10, 130, -1));

        lblNumberSystem.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblNumberSystem.setForeground(new java.awt.Color(0, 51, 51));
        lblNumberSystem.setText("Number System");
        jPanel13.add(lblNumberSystem, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 270, 40));

        btnLogicGates2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnLogicGates2.setForeground(new java.awt.Color(102, 102, 102));
        btnLogicGates2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_LogicGates.png"))); // NOI18N
        btnLogicGates2.setContentAreaFilled(false);
        btnLogicGates2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_LogicGates_Hover.png"))); // NOI18N
        btnLogicGates2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogicGates2ActionPerformed(evt);
            }
        });
        jPanel13.add(btnLogicGates2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 630, 110));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblIctCompleted, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 298, Short.MAX_VALUE)
                                .addComponent(lblIctMarks, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIctCompleted)
                    .addComponent(lblIctMarks))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        btnHome1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_BackToHome.png"))); // NOI18N
        btnHome1.setContentAreaFilled(false);
        btnHome1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_BackToHome_Hover.png"))); // NOI18N
        btnHome1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHome1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(btnHome1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(btnHome1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jSeparator1.setForeground(new java.awt.Color(0, 51, 153));

        jPanel9.setBackground(new java.awt.Color(248, 248, 248));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("Methametics");
        jPanel10.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 140, -1));

        lblSidePnlMathsMarks.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblSidePnlMathsMarks.setForeground(new java.awt.Color(102, 102, 102));
        lblSidePnlMathsMarks.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSidePnlMathsMarks.setText("Marks : 00");
        jPanel10.add(lblSidePnlMathsMarks, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 70, 160, -1));

        lblSidePnlMathsCompleted.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblSidePnlMathsCompleted.setForeground(new java.awt.Color(102, 102, 102));
        lblSidePnlMathsCompleted.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSidePnlMathsCompleted.setText("Completed : 0%");
        jPanel10.add(lblSidePnlMathsCompleted, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 40, 160, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SidePnlMathametics.png"))); // NOI18N
        jPanel10.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Other Subject Scores");

        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 102, 102));
        jLabel24.setText("Science");
        jPanel11.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 140, -1));

        lblSidePnlScienceCompleted.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblSidePnlScienceCompleted.setForeground(new java.awt.Color(102, 102, 102));
        lblSidePnlScienceCompleted.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSidePnlScienceCompleted.setText("Completed : 0%");
        jPanel11.add(lblSidePnlScienceCompleted, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 40, 160, -1));

        lblSidePnlScienceMarks.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblSidePnlScienceMarks.setForeground(new java.awt.Color(102, 102, 102));
        lblSidePnlScienceMarks.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSidePnlScienceMarks.setText("Marks : 00");
        jPanel11.add(lblSidePnlScienceMarks, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 70, 160, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SidePnlScience.png"))); // NOI18N
        jPanel11.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("My Total Score");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 180, -1));

        jSeparator5.setForeground(new java.awt.Color(102, 0, 102));
        jPanel4.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 190, 10));

        lblTotalMarks.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        lblTotalMarks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalMarks.setText("Marks  : 00");
        jPanel4.add(lblTotalMarks, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 200, -1));

        lblTotalComplete.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        lblTotalComplete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalComplete.setText("Completed : 0%");
        jPanel4.add(lblTotalComplete, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 200, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pnlFor MainMyScore.png"))); // NOI18N
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 150));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator4)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5)
                            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblIctMcqMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIctMcqMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_lblIctMcqMouseClicked

    private void btnHome1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHome1ActionPerformed
        // TODO add your handling code here:
        Main.Subjects m = new Main.Subjects();
        m.Setdata(RegisterId);
        m.show();
        this.dispose();
    }//GEN-LAST:event_btnHome1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Main.Profile prfl = new Main.Profile();
        prfl.Setdata(RegisterId);
        prfl.show();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnLogicGatesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogicGatesActionPerformed
        // TODO add your handling code here:
        LogicGates logicGates = new LogicGates();
        logicGates.Setdata(RegisterId);
        logicGates.show();
        this.dispose();
    }//GEN-LAST:event_btnLogicGatesActionPerformed

    private void btnIctMcqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIctMcqActionPerformed
        // TODO add your handling code here:
        InformationAndCommunicationTechnology ict = new InformationAndCommunicationTechnology();
        ict.Setdata(RegisterId);
        ict.show();
        this.dispose();
    }//GEN-LAST:event_btnIctMcqActionPerformed

    private void btnLogicGates1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogicGates1ActionPerformed
        // TODO add your handling code here:
        FundamentalsOfComputerSystem fundamentalsOfComp = new FundamentalsOfComputerSystem();
        fundamentalsOfComp.Setdata(RegisterId);
        fundamentalsOfComp.show();
        this.dispose();
    }//GEN-LAST:event_btnLogicGates1ActionPerformed

    private void btnLogicGates2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogicGates2ActionPerformed
        // TODO add your handling code here:
        NumberSystem numSys = new NumberSystem();
        numSys.Setdata(RegisterId);
        numSys.show();
        this.dispose();
    }//GEN-LAST:event_btnLogicGates2ActionPerformed

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
            java.util.logging.Logger.getLogger(IctMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IctMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IctMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IctMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IctMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHome1;
    private javax.swing.JButton btnIctMcq;
    private javax.swing.JButton btnLogicGates;
    private javax.swing.JButton btnLogicGates1;
    private javax.swing.JButton btnLogicGates2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lblFundamentalsOfComputerSystemCompleted;
    private javax.swing.JLabel lblFundamentalsOfComputerSystemMarks;
    private javax.swing.JLabel lblIctCompleted;
    private javax.swing.JLabel lblIctMarks;
    private javax.swing.JLabel lblIctMcq;
    private javax.swing.JLabel lblIctMcqCompleted;
    private javax.swing.JLabel lblIctMcqMarks;
    private javax.swing.JLabel lblLogicGateCompleted;
    private javax.swing.JLabel lblLogicGateMarks;
    private javax.swing.JLabel lblLogicGates;
    private javax.swing.JLabel lblLogicGates1;
    private javax.swing.JLabel lblNumberSystem;
    private javax.swing.JLabel lblNumberSystemCompleted;
    private javax.swing.JLabel lblNumberSystemMarks;
    private javax.swing.JLabel lblSidePnlMathsCompleted;
    private javax.swing.JLabel lblSidePnlMathsMarks;
    private javax.swing.JLabel lblSidePnlScienceCompleted;
    private javax.swing.JLabel lblSidePnlScienceMarks;
    private javax.swing.JLabel lblTotalComplete;
    private javax.swing.JLabel lblTotalMarks;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblWelcomeName;
    // End of variables declaration//GEN-END:variables
}
