/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;

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
public class Subjects extends javax.swing.JFrame {

    /**
     * Creates new form Subjects
     */
    String RegisterId = "";

    public Subjects() {
        initComponents();
    }

    public void Setdata(String ID) {

        RegisterId = ID;
        setRegisterDetails(ID);
        setSubjectDetails(ID);
        Database.totalDatabse dbTtl = new Database.totalDatabse();
        dbTtl.updateData(ID);
        setRankDetails(ID);
    }

    public void setRegisterDetails(String ID) {
        try {
            Connection con = Database.db.getConnection();
            String sql = "SELECT stdFirstName,stdLastName,stdUsername,stdTotalMarks,stdTotalComplete FROM digital_learning_game.register where stdRegisterId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String firstName = rs.getString("stdFirstName");
                String lastName = rs.getString("stdLastName");
                String userName = rs.getString("stdUsername");
                String ttlComplete = rs.getString("stdTotalComplete");
                String ttlMarks = rs.getString("stdTotalMarks");

                lblHeaderName.setText(firstName + " " + lastName);
                lblUsername.setText(userName);
                lblMyComplete.setText("Completed : "+ttlComplete+"%");
                lblMyMarks.setText("Marks : "+ttlMarks);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Subjects.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

// Set Subject Details
    public void setSubjectDetails(String ID) {
        setMathsDetails(ID);
        setScienceDetails(ID);
        setIctDetails(ID);
    }

    public void setMathsDetails(String ID) {
        try {
            Connection con = Database.db.getConnection();
            String sql = "SELECT mathsTotalMarks,mathsTotalComplete FROM digital_learning_game.maths where stdRegisterId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String mathsMarks = rs.getString("mathsTotalMarks");
                String mathsComplete = rs.getString("mathsTotalComplete");

                lblMathsMarks.setText("Marks : " + mathsMarks + " / 800");
                lblMathsCompleted.setText("Completed : " + mathsComplete + "%");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Subjects.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setScienceDetails(String ID) {
        try {
            Connection con = Database.db.getConnection();
            String sql = "SELECT scienceTotalMarks,scienceTotalComplete  FROM digital_learning_game.science where stdRegisterId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String scienceMarks = rs.getString("scienceTotalMarks");
                String scienceComplete = rs.getString("scienceTotalComplete");

                lblScienceMarks.setText("Marks : " + scienceMarks + " / 500");
                lblScienceCompleted.setText("Completed : " + scienceComplete + "%");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Subjects.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setIctDetails(String ID) {
        try {
            Connection con = Database.db.getConnection();
            String sql = "SELECT ictTotalMarks,ictTotalComplete FROM digital_learning_game.ict where stdRegisterId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String ictMarks = rs.getString("ictTotalMarks");
                String ictComplete = rs.getString("ictTotalComplete");

                lblIctMarks.setText("Marks : " + ictMarks + " / 1000");
                lblIctCompleted.setText("Completed : " + ictComplete + "%");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Subjects.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//Set Rank Details
    public void setRankDetails(String ID) {
        setRankDetails1(ID);
        setRankDetails2(ID);
        setRankDetails3(ID);
        setRankDetails4(ID);
    }

    public void setRankDetails1(String ID) {
        try {
            Connection con = Database.db.getConnection();
            String sql = "SELECT stdRegisterId, stdUsername, stdTotalComplete, CAST(stdTotalMarks AS UNSIGNED) AS firstMaxScore\n"
                    + "FROM (\n"
                    + "    SELECT stdRegisterId, stdUsername, stdTotalComplete, stdTotalMarks,\n"
                    + "           RANK() OVER (ORDER BY CAST(stdTotalMarks AS UNSIGNED) DESC) AS rnk\n"
                    + "    FROM digital_learning_game.register\n"
                    + ") AS ranked\n"
                    + "WHERE rnk = 1;";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String username1 = rs.getString("stdUsername");
                String complete1 = rs.getString("stdTotalComplete");
                String marks1 = rs.getString("firstMaxScore");

                lblUsername1.setText(username1);
                lblComplete1.setText("Completed : " + complete1 + "%");
                lblMarks1.setText("Marks : " + marks1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Subjects.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setRankDetails2(String ID) {
        try {
            Connection con = Database.db.getConnection();
            String sql = "SELECT stdRegisterId, stdUsername, stdTotalComplete, CAST(stdTotalMarks AS UNSIGNED) AS secondMaxScore\n"
                    + "FROM (\n"
                    + "    SELECT stdRegisterId, stdUsername, stdTotalComplete, stdTotalMarks,\n"
                    + "           RANK() OVER (ORDER BY CAST(stdTotalMarks AS UNSIGNED) DESC) AS rnk\n"
                    + "    FROM digital_learning_game.register\n"
                    + ") AS ranked\n"
                    + "WHERE rnk = 2;";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String username2 = rs.getString("stdUsername");
                String complete2 = rs.getString("stdTotalComplete");
                String marks2 = rs.getString("secondMaxScore");

                lblUsername2.setText(username2);
                lblComplete2.setText("Completed : " + complete2 + "%");
                lblMarks2.setText("Marks : " + marks2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Subjects.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setRankDetails3(String ID) {
        try {
            Connection con = Database.db.getConnection();
            String sql = "SELECT stdRegisterId, stdUsername, stdTotalComplete, CAST(stdTotalMarks AS UNSIGNED) AS thirdMaxScore\n"
                    + "FROM (\n"
                    + "    SELECT stdRegisterId, stdUsername, stdTotalComplete, stdTotalMarks,\n"
                    + "           RANK() OVER (ORDER BY CAST(stdTotalMarks AS UNSIGNED) DESC) AS rnk\n"
                    + "    FROM digital_learning_game.register\n"
                    + ") AS ranked\n"
                    + "WHERE rnk = 3;";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String username3 = rs.getString("stdUsername");
                String complete3 = rs.getString("stdTotalComplete");
                String marks3 = rs.getString("thirdMaxScore");

                lblUsername3.setText(username3);
                lblComplete3.setText("Completed : " + complete3 + "%");
                lblMarks3.setText("Marks : " + marks3);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Subjects.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setRankDetails4(String ID) {
        try {
            Connection con = Database.db.getConnection();
            String sql = "SELECT stdRegisterId, stdUsername, stdTotalComplete, CAST(stdTotalMarks AS UNSIGNED) AS fourthMaxScore\n"
                    + "FROM (\n"
                    + "    SELECT stdRegisterId, stdUsername, stdTotalComplete, stdTotalMarks,\n"
                    + "           RANK() OVER (ORDER BY CAST(stdTotalMarks AS UNSIGNED) DESC) AS rnk\n"
                    + "    FROM digital_learning_game.register\n"
                    + ") AS ranked\n"
                    + "WHERE rnk = 4;";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String username4 = rs.getString("stdUsername");
                String complete4 = rs.getString("stdTotalComplete");
                String marks4 = rs.getString("fourthMaxScore");

                lblUsername4.setText(username4);
                lblComplete4.setText("Completed : " + complete4 + "%");
                lblMarks4.setText("Marks : " + marks4);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Subjects.class.getName()).log(Level.SEVERE, null, ex);
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
        pnlBackgroundHeader = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        BackgroundHeader = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnICT = new javax.swing.JButton();
        btnMaths = new javax.swing.JButton();
        btnScience = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        lblScienceCompleted = new javax.swing.JLabel();
        lblIctCompleted = new javax.swing.JLabel();
        lblIctMarks = new javax.swing.JLabel();
        btnOtherGames = new javax.swing.JButton();
        lblMathsCompleted = new javax.swing.JLabel();
        lblMathsMarks = new javax.swing.JLabel();
        lblScienceMarks = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lblUsername1 = new javax.swing.JLabel();
        lblMarks1 = new javax.swing.JLabel();
        lblComplete1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        lblUsername2 = new javax.swing.JLabel();
        lblComplete2 = new javax.swing.JLabel();
        lblMarks2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        lblUsername3 = new javax.swing.JLabel();
        lblComplete3 = new javax.swing.JLabel();
        lblMarks3 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        lblUsername4 = new javax.swing.JLabel();
        lblComplete4 = new javax.swing.JLabel();
        lblMarks4 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnSeeAll = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel6 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        lblHeaderName = new javax.swing.JLabel();
        btnPrfil = new javax.swing.JButton();
        lblUsername = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel7 = new javax.swing.JPanel();
        lblMyMarks = new javax.swing.JLabel();
        lblMyComplete = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        pnlBackgroundHeader.setBackground(new java.awt.Color(255, 255, 255));
        pnlBackgroundHeader.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 102));
        jLabel3.setText("Digital Learning Game");
        pnlBackgroundHeader.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/about.png"))); // NOI18N
        jButton5.setContentAreaFilled(false);
        pnlBackgroundHeader.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 20, 60, 60));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Improve Your Knowladge with us.");
        pnlBackgroundHeader.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        BackgroundHeader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MainBackgroundHeader.png"))); // NOI18N
        pnlBackgroundHeader.add(BackgroundHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 100));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 0, 102));
        jLabel6.setText("Select Subject");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        btnICT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_Ict.png"))); // NOI18N
        btnICT.setContentAreaFilled(false);
        btnICT.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_Ict_Hover.png"))); // NOI18N
        btnICT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnICTActionPerformed(evt);
            }
        });
        jPanel2.add(btnICT, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 280, 170));

        btnMaths.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_Mathametics.png"))); // NOI18N
        btnMaths.setContentAreaFilled(false);
        btnMaths.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_Mathametics_Hover.png"))); // NOI18N
        btnMaths.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMathsActionPerformed(evt);
            }
        });
        jPanel2.add(btnMaths, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 280, 170));

        btnScience.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_Science.png"))); // NOI18N
        btnScience.setContentAreaFilled(false);
        btnScience.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_Science_Hover.png"))); // NOI18N
        btnScience.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScienceActionPerformed(evt);
            }
        });
        jPanel2.add(btnScience, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 280, 170));

        jSeparator1.setForeground(new java.awt.Color(102, 0, 102));
        jSeparator1.setAlignmentY(1.0F);
        jSeparator1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 590, 10));

        lblScienceCompleted.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblScienceCompleted.setForeground(new java.awt.Color(102, 102, 102));
        lblScienceCompleted.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblScienceCompleted.setText("Completed : 0%");
        jPanel2.add(lblScienceCompleted, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, 130, -1));

        lblIctCompleted.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblIctCompleted.setForeground(new java.awt.Color(102, 102, 102));
        lblIctCompleted.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblIctCompleted.setText("Completed : 0%");
        jPanel2.add(lblIctCompleted, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 130, -1));

        lblIctMarks.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblIctMarks.setForeground(new java.awt.Color(102, 0, 102));
        lblIctMarks.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIctMarks.setText("Marks : 00 / 300");
        jPanel2.add(lblIctMarks, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 490, 130, -1));

        btnOtherGames.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_EntertainmentsGames.png"))); // NOI18N
        btnOtherGames.setContentAreaFilled(false);
        btnOtherGames.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_EntertainmentsGames_Hover.png"))); // NOI18N
        btnOtherGames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtherGamesActionPerformed(evt);
            }
        });
        jPanel2.add(btnOtherGames, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 310, 280, 170));

        lblMathsCompleted.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblMathsCompleted.setForeground(new java.awt.Color(102, 102, 102));
        lblMathsCompleted.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMathsCompleted.setText("Completed : 0%");
        jPanel2.add(lblMathsCompleted, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 130, -1));

        lblMathsMarks.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblMathsMarks.setForeground(new java.awt.Color(102, 0, 102));
        lblMathsMarks.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMathsMarks.setText("Marks : 00 / 400");
        jPanel2.add(lblMathsMarks, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 130, -1));

        lblScienceMarks.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblScienceMarks.setForeground(new java.awt.Color(102, 0, 102));
        lblScienceMarks.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblScienceMarks.setText("Marks : 00 / 500");
        jPanel2.add(lblScienceMarks, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, 130, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MainBackgroundSubject.png"))); // NOI18N
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 0, 640, 560));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Score");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUsername1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblUsername1.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsername1.setText("Username");
        jPanel5.add(lblUsername1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 190, -1));

        lblMarks1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblMarks1.setForeground(new java.awt.Color(255, 255, 255));
        lblMarks1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMarks1.setText("Marks : 000");
        jPanel5.add(lblMarks1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 190, -1));

        lblComplete1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblComplete1.setForeground(new java.awt.Color(255, 255, 255));
        lblComplete1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblComplete1.setText("Completed : 0%");
        jPanel5.add(lblComplete1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 190, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1stPlace.png"))); // NOI18N
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 296, 100));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUsername2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblUsername2.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsername2.setText("Username");
        jPanel9.add(lblUsername2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 190, -1));

        lblComplete2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblComplete2.setForeground(new java.awt.Color(255, 255, 255));
        lblComplete2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblComplete2.setText("Completed : 0%");
        jPanel9.add(lblComplete2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 190, -1));

        lblMarks2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblMarks2.setForeground(new java.awt.Color(255, 255, 255));
        lblMarks2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMarks2.setText("Marks : 000");
        jPanel9.add(lblMarks2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 190, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/2ndPlace.png"))); // NOI18N
        jLabel14.setText("jLabel14");
        jPanel9.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 296, 100));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUsername3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblUsername3.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsername3.setText("Username");
        jPanel11.add(lblUsername3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 190, -1));

        lblComplete3.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblComplete3.setForeground(new java.awt.Color(255, 255, 255));
        lblComplete3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblComplete3.setText("Completed : 0%");
        jPanel11.add(lblComplete3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 190, -1));

        lblMarks3.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblMarks3.setForeground(new java.awt.Color(255, 255, 255));
        lblMarks3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMarks3.setText("Marks : 000");
        jPanel11.add(lblMarks3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 190, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/3rdPlace.png"))); // NOI18N
        jPanel11.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 296, 100));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUsername4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblUsername4.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsername4.setText("Username");
        jPanel12.add(lblUsername4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 190, -1));

        lblComplete4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblComplete4.setForeground(new java.awt.Color(255, 255, 255));
        lblComplete4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblComplete4.setText("Completed : 0%");
        jPanel12.add(lblComplete4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 190, -1));

        lblMarks4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblMarks4.setForeground(new java.awt.Color(255, 255, 255));
        lblMarks4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMarks4.setText("Marks : 000");
        jPanel12.add(lblMarks4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 190, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/4thPlace.png"))); // NOI18N
        jPanel12.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 296, 100));

        btnSeeAll.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnSeeAll.setForeground(new java.awt.Color(153, 0, 153));
        btnSeeAll.setText("SEE ALL");
        btnSeeAll.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 2, true));
        btnSeeAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeeAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSeeAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSeeAll, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jSeparator3.setForeground(new java.awt.Color(102, 0, 102));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator3))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pnlBackgroundHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBackgroundHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(253, 238, 253));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        lblHeaderName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblHeaderName.setForeground(new java.awt.Color(102, 102, 102));
        lblHeaderName.setText("Welcome admin");
        lblHeaderName.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        btnPrfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/profile.png"))); // NOI18N
        btnPrfil.setContentAreaFilled(false);
        btnPrfil.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/profile_Hover.png"))); // NOI18N
        btnPrfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrfilActionPerformed(evt);
            }
        });

        lblUsername.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(102, 0, 102));
        lblUsername.setText("Username");
        lblUsername.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPrfil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblHeaderName, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                    .addComponent(lblUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPrfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(lblHeaderName, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        btnLogout.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(153, 0, 153));
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Logout-Icon-Hover.png"))); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.setBorder(null);
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(102, 0, 102));
        jSeparator2.setForeground(new java.awt.Color(102, 0, 102));

        jSeparator4.setForeground(new java.awt.Color(102, 0, 102));

        jPanel7.setBackground(new java.awt.Color(253, 238, 253));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMyMarks.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblMyMarks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMyMarks.setText("Marks : 00");
        jPanel7.add(lblMyMarks, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 230, -1));

        lblMyComplete.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblMyComplete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMyComplete.setText("Completed : 0%");
        jPanel7.add(lblMyComplete, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 230, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("My Score");
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 230, -1));

        jSeparator6.setForeground(new java.awt.Color(102, 0, 102));
        jPanel7.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 210, 10));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/myScorePnl.png"))); // NOI18N
        jPanel7.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 249, 160));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jSeparator2))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator4)))
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(2, 2, 2))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMathsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMathsActionPerformed
        // TODO add your handling code here:
        Maths.MathsMain mathsMain = new Maths.MathsMain();
        mathsMain.Setdata(RegisterId);
        mathsMain.show();
        this.dispose();
    }//GEN-LAST:event_btnMathsActionPerformed

    private void btnScienceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScienceActionPerformed
        // TODO add your handling code here:
        Science.ScienceMain scienceMain = new Science.ScienceMain();
        scienceMain.Setdata(RegisterId);
        scienceMain.show();
        this.dispose();
    }//GEN-LAST:event_btnScienceActionPerformed

    private void btnPrfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrfilActionPerformed
        // TODO add your handling code here:
        Profile prfl = new Profile();
        prfl.Setdata(RegisterId);
        prfl.show();
    }//GEN-LAST:event_btnPrfilActionPerformed

    private void btnOtherGamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtherGamesActionPerformed
        // TODO add your handling code here:
        OtherGames.OtherGamesMain otherMain = new OtherGames.OtherGamesMain();
        otherMain.Setdata(RegisterId);
        otherMain.show();
        this.dispose();

    }//GEN-LAST:event_btnOtherGamesActionPerformed

    private void btnICTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnICTActionPerformed
        // TODO add your handling code here:
        ICT.IctMain ictMain = new ICT.IctMain();
        ictMain.Setdata(RegisterId);
        ictMain.show();
        this.dispose();
    }//GEN-LAST:event_btnICTActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        Login.Login log = new Login.Login();
        log.show();
        this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnSeeAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeeAllActionPerformed
        // TODO add your handling code here:
        AllScores allScore = new AllScores();
        allScore.Setdata(RegisterId);
        allScore.show();
    }//GEN-LAST:event_btnSeeAllActionPerformed

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
            java.util.logging.Logger.getLogger(Subjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Subjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Subjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Subjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Subjects().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackgroundHeader;
    private javax.swing.JButton btnICT;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMaths;
    private javax.swing.JButton btnOtherGames;
    private javax.swing.JButton btnPrfil;
    private javax.swing.JButton btnScience;
    private javax.swing.JButton btnSeeAll;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel lblComplete1;
    private javax.swing.JLabel lblComplete2;
    private javax.swing.JLabel lblComplete3;
    private javax.swing.JLabel lblComplete4;
    private javax.swing.JLabel lblHeaderName;
    private javax.swing.JLabel lblIctCompleted;
    private javax.swing.JLabel lblIctMarks;
    private javax.swing.JLabel lblMarks1;
    private javax.swing.JLabel lblMarks2;
    private javax.swing.JLabel lblMarks3;
    private javax.swing.JLabel lblMarks4;
    private javax.swing.JLabel lblMathsCompleted;
    private javax.swing.JLabel lblMathsMarks;
    private javax.swing.JLabel lblMyComplete;
    private javax.swing.JLabel lblMyMarks;
    private javax.swing.JLabel lblScienceCompleted;
    private javax.swing.JLabel lblScienceMarks;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblUsername1;
    private javax.swing.JLabel lblUsername2;
    private javax.swing.JLabel lblUsername3;
    private javax.swing.JLabel lblUsername4;
    private javax.swing.JPanel pnlBackgroundHeader;
    // End of variables declaration//GEN-END:variables
}
