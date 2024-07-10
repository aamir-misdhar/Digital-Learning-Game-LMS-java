/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Science;

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
public class ScienceMain extends javax.swing.JFrame {

    /**
     * Creates new form ScienceMain
     */
    String RegisterId = "";

    public ScienceMain() {
        initComponents();
    }

    public void Setdata(String ID) {
        RegisterId = ID;
        setRegisterDetails(ID);
        setSubjectTotalDetails(ID);
        setElectronicConfigurationSubjectDetails(ID);
        setMapMarkingSubjectDetails(ID);
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
            String sql = "SELECT scienceTotalMarks,scienceTotalComplete  FROM digital_learning_game.science where stdRegisterId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String scienceCompleted = rs.getString("scienceTotalComplete");
                String scienceMarks = rs.getString("scienceTotalMarks");

                lblScienceCompleted.setText("Completed : " + scienceCompleted + "%");
                lblScienceMarks.setText("Marks : " + scienceMarks);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ScienceMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Set Subject Details
    public void setMapMarkingSubjectDetails(String ID) {
        try {
            Connection con = Database.db.getConnection();
            String sql = "SELECT mapMarkingDignestiveSystem_marks,mapMarkingDignestiveSystem_completed,mapMarkingRespiratorySystem_marks,mapMarkingRespiratorySystem_completed,mapMarkingUrinarySystem_marks,mapMarkingUrinarySystem_completed FROM digital_learning_game.science where stdRegisterId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                // get data from database
                String digestiveSystemComplete = rs.getString("mapMarkingDignestiveSystem_completed");
                String digestiveSystemMarks = rs.getString("mapMarkingDignestiveSystem_marks");

                String respiratorySystemComplete = rs.getString("mapMarkingRespiratorySystem_completed");
                String respiratorySystemMarks = rs.getString("mapMarkingRespiratorySystem_marks");

                String urinarySystemComplete = rs.getString("mapMarkingUrinarySystem_completed");
                String urinarySystemMarks = rs.getString("mapMarkingUrinarySystem_marks");

                int completeDig = Integer.valueOf(digestiveSystemComplete);
                int completeRes = Integer.valueOf(respiratorySystemComplete);
                int completeUri = Integer.valueOf(urinarySystemComplete);
                int complete = completeDig + completeRes + completeUri;

                int marksDig = Integer.valueOf(digestiveSystemMarks);
                int marksRes = Integer.valueOf(respiratorySystemMarks);
                int marksUri = Integer.valueOf(urinarySystemMarks);
                int marks = marksDig + marksRes + marksUri;

                //Set data to form           
                lblMapMarkingCompleted.setText("Completed : " + complete / 3 + "%");
                lblMapMarkingMarks.setText("Marks : " + marks + "/300");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MapMaking.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setElectronicConfigurationSubjectDetails(String ID) {
        try {
            Connection con = Database.db.getConnection();
            String sql = "SELECT electronicConfigurationLevel1_marks,electronicConfigurationLevel1_completed,electronicConfigurationLevel2_marks,electronicConfigurationLevel2_completed,electronicConfigurationLevel2_marks_II,electronicConfigurationLevel2_complete_II FROM digital_learning_game.science where stdRegisterId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                // get data from database
                String electronicConfigurationLevel1Completed = rs.getString("electronicConfigurationLevel1_completed");
                String electronicConfigurationLevel1Marks = rs.getString("electronicConfigurationLevel1_marks");

                String electronicConfigurationLevel2Completed = rs.getString("electronicConfigurationLevel2_completed");
                String electronicConfigurationLevel2Marks = rs.getString("electronicConfigurationLevel2_marks");

                String electronicConfigurationLevel2Complete_II = rs.getString("electronicConfigurationLevel2_complete_II");
                String electronicConfigurationLevel2Marks_II = rs.getString("electronicConfigurationLevel2_marks_II");

                int completeLvl1 = Integer.valueOf(electronicConfigurationLevel1Completed);
                int completeLvl2 = Integer.valueOf(electronicConfigurationLevel2Completed);
                int completeLvl2_II = Integer.valueOf(electronicConfigurationLevel2Complete_II);
                int completeLvl2F = (completeLvl2_II + completeLvl2) / 2;
                int complete = completeLvl1 + completeLvl2F;

                int marksLvl1 = Integer.valueOf(electronicConfigurationLevel1Marks);
                int marksLvl2 = Integer.valueOf(electronicConfigurationLevel2Marks);
                int marksLvl2_II = Integer.valueOf(electronicConfigurationLevel2Marks_II);
                int marksLvl2F = (marksLvl2 + marksLvl2_II) / 2;
                int marks = marksLvl1 + marksLvl2F;

                //Set data to form           
                lblElectronicConfigurationCompleted.setText("Completed : " + complete / 2 + "%");
                lblElectronicConfigurationMarks.setText("Marks : " + marks + "/200");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MapMaking.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ScienceMain.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ScienceMain.class.getName()).log(Level.SEVERE, null, ex);
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
        jButton3 = new javax.swing.JButton();
        lblUsername = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblElectronicConfiguration = new javax.swing.JLabel();
        lblElectronicConfigurationCompleted = new javax.swing.JLabel();
        lblElectronicConfigurationMarks = new javax.swing.JLabel();
        btnElectronicConfiguration = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        lblMapMarking = new javax.swing.JLabel();
        lblMapMarkingMarks = new javax.swing.JLabel();
        lblMapMarkingCompleted = new javax.swing.JLabel();
        btnMapMarking = new javax.swing.JButton();
        lblScienceCompleted = new javax.swing.JLabel();
        lblScienceMarks = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        lblSidePnlMathsMarks = new javax.swing.JLabel();
        lblSidePnlMathsCompleted = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        lblSidePnlIctCompleted = new javax.swing.JLabel();
        lblSidePnlIctMarks = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel10 = new javax.swing.JPanel();
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
        jLabel4.setText("SCIENCE");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 320, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/profile.png"))); // NOI18N
        jButton3.setContentAreaFilled(false);
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/profile_Hover.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, -1, 90));

        lblUsername.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(76, 141, 142));
        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUsername.setText("admin_admin");
        jPanel1.add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 250, 90));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pnlScienceHeader.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 667, 95));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblElectronicConfiguration.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblElectronicConfiguration.setText("Electronic Configuration");
        jPanel3.add(lblElectronicConfiguration, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 30, 200, 40));

        lblElectronicConfigurationCompleted.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblElectronicConfigurationCompleted.setForeground(new java.awt.Color(102, 102, 102));
        lblElectronicConfigurationCompleted.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblElectronicConfigurationCompleted.setText("Completed: 100%");
        jPanel3.add(lblElectronicConfigurationCompleted, new org.netbeans.lib.awtextra.AbsoluteConstraints(472, 10, 130, -1));

        lblElectronicConfigurationMarks.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblElectronicConfigurationMarks.setForeground(new java.awt.Color(102, 102, 102));
        lblElectronicConfigurationMarks.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblElectronicConfigurationMarks.setText("Marks: 80/100");
        jPanel3.add(lblElectronicConfigurationMarks, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 80, 130, -1));

        btnElectronicConfiguration.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnElectronicConfiguration.setForeground(new java.awt.Color(255, 255, 255));
        btnElectronicConfiguration.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_Electroic Configuration.png"))); // NOI18N
        btnElectronicConfiguration.setContentAreaFilled(false);
        btnElectronicConfiguration.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_Electroic Configuration_Hover.png"))); // NOI18N
        btnElectronicConfiguration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElectronicConfigurationActionPerformed(evt);
            }
        });
        jPanel3.add(btnElectronicConfiguration, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, -1, 640, 110));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMapMarking.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblMapMarking.setText("Biological Processes in  Human Body");
        jPanel8.add(lblMapMarking, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 300, 40));

        lblMapMarkingMarks.setBackground(new java.awt.Color(204, 204, 204));
        lblMapMarkingMarks.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMapMarkingMarks.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMapMarkingMarks.setText("Marks: 80/100");
        jPanel8.add(lblMapMarkingMarks, new org.netbeans.lib.awtextra.AbsoluteConstraints(461, 80, 140, -1));

        lblMapMarkingCompleted.setBackground(new java.awt.Color(204, 204, 204));
        lblMapMarkingCompleted.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblMapMarkingCompleted.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMapMarkingCompleted.setText("Completed: 100%");
        jPanel8.add(lblMapMarkingCompleted, new org.netbeans.lib.awtextra.AbsoluteConstraints(472, 10, 130, -1));

        btnMapMarking.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnMapMarking.setForeground(new java.awt.Color(51, 51, 51));
        btnMapMarking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_MapMarking.png"))); // NOI18N
        btnMapMarking.setContentAreaFilled(false);
        btnMapMarking.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_MapMarking_Hover.png"))); // NOI18N
        btnMapMarking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMapMarkingActionPerformed(evt);
            }
        });
        jPanel8.add(btnMapMarking, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 110));

        lblScienceCompleted.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblScienceCompleted.setForeground(new java.awt.Color(102, 102, 102));
        lblScienceCompleted.setText("Completed : 0%");

        lblScienceMarks.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblScienceMarks.setForeground(new java.awt.Color(102, 102, 102));
        lblScienceMarks.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblScienceMarks.setText("Marks : 00");

        jSeparator2.setForeground(new java.awt.Color(76, 141, 142));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblScienceCompleted, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(293, 293, 293)
                                .addComponent(lblScienceMarks, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblScienceCompleted)
                    .addComponent(lblScienceMarks))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 276, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jSeparator1.setForeground(new java.awt.Color(0, 102, 102));

        jPanel6.setBackground(new java.awt.Color(248, 248, 248));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("Methametics");
        jPanel7.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 140, -1));

        lblSidePnlMathsMarks.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblSidePnlMathsMarks.setForeground(new java.awt.Color(102, 102, 102));
        lblSidePnlMathsMarks.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSidePnlMathsMarks.setText("Marks : 00");
        jPanel7.add(lblSidePnlMathsMarks, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 70, 160, -1));

        lblSidePnlMathsCompleted.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblSidePnlMathsCompleted.setForeground(new java.awt.Color(102, 102, 102));
        lblSidePnlMathsCompleted.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSidePnlMathsCompleted.setText("Completd : 0%");
        jPanel7.add(lblSidePnlMathsCompleted, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 40, 160, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SidePnlMathametics.png"))); // NOI18N
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("Other Subject Scores");

        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(204, 204, 204));
        jLabel24.setText("Information Tech");
        jPanel9.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 160, -1));

        lblSidePnlIctCompleted.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblSidePnlIctCompleted.setForeground(new java.awt.Color(204, 204, 204));
        lblSidePnlIctCompleted.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSidePnlIctCompleted.setText("Completed : 0%");
        jPanel9.add(lblSidePnlIctCompleted, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 40, 180, -1));

        lblSidePnlIctMarks.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblSidePnlIctMarks.setForeground(new java.awt.Color(204, 204, 204));
        lblSidePnlIctMarks.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSidePnlIctMarks.setText("Marks : 00");
        jPanel9.add(lblSidePnlIctMarks, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 70, 180, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SidePnlICT.png"))); // NOI18N
        jPanel9.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("My Total Score");
        jPanel10.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 180, -1));

        jSeparator5.setForeground(new java.awt.Color(102, 0, 102));
        jPanel10.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 190, 10));

        lblTotalMarks.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        lblTotalMarks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalMarks.setText("Marks  : 00");
        jPanel10.add(lblTotalMarks, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 200, -1));

        lblTotalComplete.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        lblTotalComplete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalComplete.setText("Completed : 0%");
        jPanel10.add(lblTotalComplete, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 200, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pnlFor MainMyScore.png"))); // NOI18N
        jPanel10.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 150));

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
                    .addComponent(jSeparator3)
                    .addComponent(jSeparator4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addGap(324, 324, 324)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(26, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnElectronicConfigurationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElectronicConfigurationActionPerformed
        // TODO add your handling code here:
        ElectronicConfiguration ec = new ElectronicConfiguration();
        ec.Setdata(RegisterId);

        ec.show();
        this.dispose();
    }//GEN-LAST:event_btnElectronicConfigurationActionPerformed

    private void btnMapMarkingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMapMarkingActionPerformed
        // TODO add your handling code here:
        MapMaking mm = new MapMaking();
        mm.Setdata(RegisterId);

        mm.show();
        this.dispose();
    }//GEN-LAST:event_btnMapMarkingActionPerformed

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
            java.util.logging.Logger.getLogger(ScienceMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScienceMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScienceMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScienceMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScienceMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnElectronicConfiguration;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnMapMarking;
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
    private javax.swing.JLabel lblElectronicConfiguration;
    private javax.swing.JLabel lblElectronicConfigurationCompleted;
    private javax.swing.JLabel lblElectronicConfigurationMarks;
    private javax.swing.JLabel lblMapMarking;
    private javax.swing.JLabel lblMapMarkingCompleted;
    private javax.swing.JLabel lblMapMarkingMarks;
    private javax.swing.JLabel lblScienceCompleted;
    private javax.swing.JLabel lblScienceMarks;
    private javax.swing.JLabel lblSidePnlIctCompleted;
    private javax.swing.JLabel lblSidePnlIctMarks;
    private javax.swing.JLabel lblSidePnlMathsCompleted;
    private javax.swing.JLabel lblSidePnlMathsMarks;
    private javax.swing.JLabel lblTotalComplete;
    private javax.swing.JLabel lblTotalMarks;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblWelcomeName;
    // End of variables declaration//GEN-END:variables
}
