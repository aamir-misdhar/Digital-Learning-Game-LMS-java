/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Maths;

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
public class MathsMain extends javax.swing.JFrame {

    /**
     * Creates new form MathsMain
     */
    String RegisterId = "";

    public MathsMain() {
        initComponents();
    }

    public void Setdata(String ID) {
        RegisterId = ID;
        setRegisterDetails(ID);
        setSubjectTotalDetails(ID);
        setMathsSubjectDetails(ID);
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
            String sql = "SELECT mathsTotalMarks,mathsTotalComplete FROM digital_learning_game.maths where stdRegisterId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String mathsCompleted = rs.getString("mathsTotalComplete");
                String mathsMarks = rs.getString("mathsTotalMarks");

                lblMathsCompleted.setText("Completed : " + mathsCompleted + "%");
                lblMathsMarks.setText("Marks : " + mathsMarks);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MathsMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Set Subject Details
    public void setMathsSubjectDetails(String ID) {
        setBasicMathsDetails(ID);
        setPerimeterAndAreaDetails(ID);

    }
    
    public void setBasicMathsDetails(String ID){
        try {
            Connection con = Database.db.getConnection();
            String sql = "SELECT basicMathsLevel1_Marks,basicMathsLevel1_Complete,basicMathsLevel2_Marks,basicMathsLevel2_Complete,basicMathsLevel3_Marks,basicMathsLevel3_Complete,basicMathsLevel4_Marks,basicMathsLevel4_Complete FROM digital_learning_game.maths where stdRegisterId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                // get data from database
                String basicMathsLevel1Complete = rs.getString("basicMathsLevel1_Complete");
                String basicMathsLevel1Marks = rs.getString("basicMathsLevel1_Marks");
                String basicMathsLevel2Complete = rs.getString("basicMathsLevel2_Complete");
                String basicMathsLevel2Marks = rs.getString("basicMathsLevel2_Marks");
                String basicMathsLevel3Complete = rs.getString("basicMathsLevel3_Complete");
                String basicMathsLevel3Marks = rs.getString("basicMathsLevel3_Marks");
                String basicMathsLevel4Complete = rs.getString("basicMathsLevel4_Complete");
                String basicMathsLevel4Marks = rs.getString("basicMathsLevel4_Marks");

                int completeLvl1 = Integer.valueOf(basicMathsLevel1Complete);
                int completeLvl2 = Integer.valueOf(basicMathsLevel2Complete);
                int completeLvl3 = Integer.valueOf(basicMathsLevel3Complete);
                int completeLvl4 = Integer.valueOf(basicMathsLevel4Complete);
                int complete = completeLvl1 + completeLvl2+completeLvl3+completeLvl4;

                int marksLvl1 = Integer.valueOf(basicMathsLevel1Marks);
                int marksLvl2 = Integer.valueOf(basicMathsLevel2Marks);
                int marksLvl3 = Integer.valueOf(basicMathsLevel3Marks);
                int marksLvl4 = Integer.valueOf(basicMathsLevel4Marks);
                int marks = marksLvl1 + marksLvl2+marksLvl3+marksLvl4;

                //Set data to form           
                lblBasicMathsCompleted.setText("Completed : " + complete / 4 + "%");
                lblBasicMathsMarks.setText("Marks : " + marks + "/400");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MathsMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setPerimeterAndAreaDetails(String ID){
       try {
            Connection con = Database.db.getConnection();
            String sql = "SELECT perimeterAndAreaRectangle_Marks,perimeterAndAreaRectangle_Complete,perimeterAndAreaSquare_Marks,perimeterAndAreaSquare_Complete,perimeterAndAreaTriangle_Marks,perimeterAndAreaTriangle_Complete,perimeterAndAreaCircle_Marks,perimeterAndAreaCircle_Complete FROM digital_learning_game.maths where stdRegisterId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                // get data from database
                int perimeterAndAreaRectangleComplete = rs.getInt("perimeterAndAreaRectangle_Complete");
                int perimeterAndAreaRectangleMarks = rs.getInt("perimeterAndAreaRectangle_Marks");
                
                int perimeterAndAreaSquareComplete = rs.getInt("perimeterAndAreaSquare_Complete");
                int perimeterAndAreaSquareMarks = rs.getInt("perimeterAndAreaSquare_Marks");
                
                int perimeterAndAreaTriangleComplete = rs.getInt("perimeterAndAreaTriangle_Complete");
                int perimeterAndAreaTriangleMarks = rs.getInt("perimeterAndAreaTriangle_Marks");
                
                int perimeterAndAreaCircleComplete = rs.getInt("perimeterAndAreaCircle_Complete");
                int perimeterAndAreaCircleMarks = rs.getInt("perimeterAndAreaCircle_Marks");
                
                int complete = perimeterAndAreaRectangleComplete + perimeterAndAreaSquareComplete + perimeterAndAreaTriangleComplete + perimeterAndAreaCircleComplete;
                int marks = perimeterAndAreaRectangleMarks + perimeterAndAreaSquareMarks + perimeterAndAreaTriangleMarks + perimeterAndAreaCircleMarks;


                //Set data to form           
                lblPerimeterAndAreaCompleted.setText("Completed : " + complete / 4 + "%");
                lblPerimeterAndAreaMarks.setText("Marks : " + marks + "/400");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MathsMain.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    // Set Side Panal Details
    public void setSidePanalDetails(String ID) {

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
            Logger.getLogger(MathsMain.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MathsMain.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel4 = new javax.swing.JLabel();
        lblWelcomeName = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblBasicMathsMarks = new javax.swing.JLabel();
        lblBasicMathsCompleted = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblMathsCompleted = new javax.swing.JLabel();
        lblMathsMarks = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel10 = new javax.swing.JPanel();
        lblPerimeterAndAreaMarks = new javax.swing.JLabel();
        lblPerimeterAndAreaCompleted = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        lblSidePnlScienceMarks = new javax.swing.JLabel();
        lblSidePnlScienceCompleted = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        lblSidePnlIctCompleted = new javax.swing.JLabel();
        lblSidePnlIctMarks = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        lblTotalMarks = new javax.swing.JLabel();
        lblTotalComplete = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("MATHEMATICS");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 320, -1));

        lblWelcomeName.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblWelcomeName.setForeground(new java.awt.Color(255, 255, 255));
        lblWelcomeName.setText("Welcome Admin");
        jPanel1.add(lblWelcomeName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 320, -1));

        lblUsername.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(102, 102, 102));
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
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pnlMathematicsHeader.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 667, 95));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBasicMathsMarks.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblBasicMathsMarks.setForeground(new java.awt.Color(102, 102, 102));
        lblBasicMathsMarks.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblBasicMathsMarks.setText("Marks: 80/400");
        jPanel3.add(lblBasicMathsMarks, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 130, -1));

        lblBasicMathsCompleted.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblBasicMathsCompleted.setForeground(new java.awt.Color(102, 102, 102));
        lblBasicMathsCompleted.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblBasicMathsCompleted.setText("Completed: 100%");
        jPanel3.add(lblBasicMathsCompleted, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 131, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("Basic Maths");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 140, -1));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 102, 102));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_BasicMaths.png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_BasicMaths_Hover.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 120));

        lblMathsCompleted.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblMathsCompleted.setForeground(new java.awt.Color(102, 102, 102));
        lblMathsCompleted.setText("Completed : 0%");

        lblMathsMarks.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblMathsMarks.setForeground(new java.awt.Color(102, 102, 102));
        lblMathsMarks.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMathsMarks.setText("Marks : 00");

        jSeparator2.setForeground(new java.awt.Color(76, 142, 80));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPerimeterAndAreaMarks.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPerimeterAndAreaMarks.setForeground(new java.awt.Color(102, 102, 102));
        lblPerimeterAndAreaMarks.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPerimeterAndAreaMarks.setText("Marks: 80/400");
        jPanel10.add(lblPerimeterAndAreaMarks, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 130, -1));

        lblPerimeterAndAreaCompleted.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblPerimeterAndAreaCompleted.setForeground(new java.awt.Color(102, 102, 102));
        lblPerimeterAndAreaCompleted.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPerimeterAndAreaCompleted.setText("Completed: 100%");
        jPanel10.add(lblPerimeterAndAreaCompleted, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 131, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel9.setText("Perimeter And Area");
        jPanel10.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 190, -1));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton2.setForeground(new java.awt.Color(102, 102, 102));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_BasicMaths.png"))); // NOI18N
        jButton2.setContentAreaFilled(false);
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_BasicMaths_Hover.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 120));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblMathsCompleted, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblMathsMarks, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(25, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMathsCompleted)
                    .addComponent(lblMathsMarks))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(330, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(190, 190, 190)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(202, Short.MAX_VALUE)))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_BackToHome.png"))); // NOI18N
        btnHome.setContentAreaFilled(false);
        btnHome.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_BackToHome_Hover.png"))); // NOI18N
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jSeparator1.setForeground(new java.awt.Color(51, 102, 0));

        jPanel6.setBackground(new java.awt.Color(248, 248, 248));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Science");
        jPanel7.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 140, -1));

        lblSidePnlScienceMarks.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblSidePnlScienceMarks.setForeground(new java.awt.Color(255, 255, 255));
        lblSidePnlScienceMarks.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSidePnlScienceMarks.setText("Marks : 00");
        jPanel7.add(lblSidePnlScienceMarks, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 70, 160, -1));

        lblSidePnlScienceCompleted.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblSidePnlScienceCompleted.setForeground(new java.awt.Color(255, 255, 255));
        lblSidePnlScienceCompleted.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSidePnlScienceCompleted.setText("Completed : 0%");
        jPanel7.add(lblSidePnlScienceCompleted, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 40, 160, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SidePnlScience.png"))); // NOI18N
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Other Subject Scores");

        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Information Tech");
        jPanel9.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 150, -1));

        lblSidePnlIctCompleted.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblSidePnlIctCompleted.setForeground(new java.awt.Color(255, 255, 255));
        lblSidePnlIctCompleted.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSidePnlIctCompleted.setText("Completed : 0%");
        jPanel9.add(lblSidePnlIctCompleted, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 40, 170, -1));

        lblSidePnlIctMarks.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblSidePnlIctMarks.setForeground(new java.awt.Color(255, 255, 255));
        lblSidePnlIctMarks.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSidePnlIctMarks.setText("Marks : 00");
        jPanel9.add(lblSidePnlIctMarks, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 70, 170, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SidePnlICT.png"))); // NOI18N
        jPanel9.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("My Total Score");
        jPanel8.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 180, -1));

        jSeparator5.setForeground(new java.awt.Color(102, 0, 102));
        jPanel8.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 190, 10));

        lblTotalMarks.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        lblTotalMarks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalMarks.setText("Marks  : 00");
        jPanel8.add(lblTotalMarks, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 200, -1));

        lblTotalComplete.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        lblTotalComplete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalComplete.setText("Completed : 0%");
        jPanel8.add(lblTotalComplete, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 200, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pnlFor MainMyScore.png"))); // NOI18N
        jPanel8.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 150));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jSeparator4)
                .addContainerGap())
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(180, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(328, 328, 328)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(22, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        Main.Subjects m = new Main.Subjects();
        m.Setdata(RegisterId);
        m.show();
        this.dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Main.Profile prfl = new Main.Profile();
        prfl.Setdata(RegisterId);
        prfl.show();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        BasicMaths bm = new BasicMaths();
        bm.Setdata(RegisterId);
        bm.show();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        PerimeterAndArea periArea = new PerimeterAndArea();
        periArea.Setdata(RegisterId);
        periArea.show();
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(MathsMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MathsMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MathsMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MathsMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MathsMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHome;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
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
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lblBasicMathsCompleted;
    private javax.swing.JLabel lblBasicMathsMarks;
    private javax.swing.JLabel lblMathsCompleted;
    private javax.swing.JLabel lblMathsMarks;
    private javax.swing.JLabel lblPerimeterAndAreaCompleted;
    private javax.swing.JLabel lblPerimeterAndAreaMarks;
    private javax.swing.JLabel lblSidePnlIctCompleted;
    private javax.swing.JLabel lblSidePnlIctMarks;
    private javax.swing.JLabel lblSidePnlScienceCompleted;
    private javax.swing.JLabel lblSidePnlScienceMarks;
    private javax.swing.JLabel lblTotalComplete;
    private javax.swing.JLabel lblTotalMarks;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblWelcomeName;
    // End of variables declaration//GEN-END:variables
}
