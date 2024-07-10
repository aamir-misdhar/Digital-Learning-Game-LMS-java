/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package OtherGames;

import ICT.IctMain;
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
public class OtherGamesMain extends javax.swing.JFrame {

    /**
     * Creates new form OtherGamesMain
     */
    String RegisterId = "";

    public OtherGamesMain() {
        initComponents();
    }

    public void Setdata(String ID) {
        RegisterId = ID;
        setRegisterDetails(ID);
//        setSubjectTotalDetails(ID);
//        setIctSubjectDetails(ID);
//        setFundementalsOfCompSysSubjectDetails(ID);
//        setLogicGatesSubjectDetails(ID);
        setSidePanalDetails(ID);

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
//                lblTotalComplete.setText("Completed : "+ttlComplete+"%");
//                lblTotalMarks.setText("Marks : "+ttlMarks);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Subjects.class.getName()).log(Level.SEVERE, null, ex);
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

        //It Details
        try {
            Connection con = Database.db.getConnection();
            String sql = "SELECT ictTotalMarks,ictTotalComplete FROM digital_learning_game.ict where stdRegisterId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String ictTotalMarks = rs.getString("ictTotalMarks");
                String ictTotalComplete = rs.getString("ictTotalComplete");

                lblSidePnlIctMarks.setText("Marks : " + ictTotalMarks);
                lblSidePnlIctCompleted.setText("Completed : " + ictTotalComplete + "%");
            }

        } catch (SQLException ex) {
            Logger.getLogger(OtherGamesMain.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnOddEvenGame = new javax.swing.JButton();
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
        jPanel12 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        lblSidePnlIctCompleted = new javax.swing.JLabel();
        lblSidePnlIctMarks = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblWelcomeName.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblWelcomeName.setForeground(new java.awt.Color(255, 255, 255));
        lblWelcomeName.setText("Welcome Admin");
        jPanel1.add(lblWelcomeName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 320, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Entertainment Games");
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
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pnlOtherGameHeader.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 667, 95));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("These games Scores are not going to be save in database");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("These games are just for fun...!");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btnTicTacTeo.png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btnTicTacTeo_Hover.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnOddEvenGame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btnOddEven.jpg"))); // NOI18N
        btnOddEvenGame.setContentAreaFilled(false);
        btnOddEvenGame.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btnOddEven_Hover.png"))); // NOI18N
        btnOddEvenGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOddEvenGameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnOddEvenGame)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOddEvenGame, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(274, Short.MAX_VALUE))
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

        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Information Tech");
        jPanel12.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 150, -1));

        lblSidePnlIctCompleted.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblSidePnlIctCompleted.setForeground(new java.awt.Color(255, 255, 255));
        lblSidePnlIctCompleted.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSidePnlIctCompleted.setText("Completed : 0%");
        jPanel12.add(lblSidePnlIctCompleted, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 40, 170, -1));

        lblSidePnlIctMarks.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblSidePnlIctMarks.setForeground(new java.awt.Color(255, 255, 255));
        lblSidePnlIctMarks.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSidePnlIctMarks.setText("Marks : 00");
        jPanel12.add(lblSidePnlIctMarks, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 70, 170, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SidePnlICT.png"))); // NOI18N
        jPanel12.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator4)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(306, 306, 306)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(87, Short.MAX_VALUE)))
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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Main.Profile prfl = new Main.Profile();
        prfl.Setdata(RegisterId);
        prfl.show();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnHome1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHome1ActionPerformed
        // TODO add your handling code here:
        Main.Subjects m = new Main.Subjects();
        m.Setdata(RegisterId);
        m.show();
        this.dispose();
    }//GEN-LAST:event_btnHome1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        frmTicTacToe ticTacTeo = new frmTicTacToe();
        ticTacTeo.Setdata(RegisterId);
        ticTacTeo.show();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnOddEvenGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOddEvenGameActionPerformed
        // TODO add your handling code here:
        OddEven oddEven = new OddEven();
        oddEven.setData(RegisterId);
        oddEven.show();
        this.dispose();
    }//GEN-LAST:event_btnOddEvenGameActionPerformed

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
            java.util.logging.Logger.getLogger(OtherGamesMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OtherGamesMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OtherGamesMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OtherGamesMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OtherGamesMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHome1;
    private javax.swing.JButton btnOddEvenGame;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblSidePnlIctCompleted;
    private javax.swing.JLabel lblSidePnlIctMarks;
    private javax.swing.JLabel lblSidePnlMathsCompleted;
    private javax.swing.JLabel lblSidePnlMathsMarks;
    private javax.swing.JLabel lblSidePnlScienceCompleted;
    private javax.swing.JLabel lblSidePnlScienceMarks;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblWelcomeName;
    // End of variables declaration//GEN-END:variables
}
