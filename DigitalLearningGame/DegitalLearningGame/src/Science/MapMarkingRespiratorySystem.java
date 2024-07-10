/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Science;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author mmaam
 */
public class MapMarkingRespiratorySystem extends javax.swing.JFrame {

    /**
     * Creates new form MapMarkingRespiratorySystem
     */
     String RegisterId;
    int marks = 0;
    int health = 3;
    int completed = 0;
    JLabel selectedPictureBox;
    JButton selectedAnswerBox;

    public MapMarkingRespiratorySystem() {
        initComponents();
        disableAnswerBox();
        lblMessageBox.setVisible(false);
    }
    
    public void Setdata(String ID) {
        RegisterId = ID;
        
        //set user marks
        try {
            Connection con = Database.db.getConnection();
            String sql = "SELECT mapMarkingDignestiveSystem_marks,mapMarkingDignestiveSystem_completed,mapMarkingUrinarySystem_marks,mapMarkingUrinarySystem_completed FROM digital_learning_game.science where stdRegisterId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String diagestiveSystemComplete = rs.getString("mapMarkingDignestiveSystem_completed");
                String diagestiveSystemMarks = rs.getString("mapMarkingDignestiveSystem_marks");

                String urinarySystemComplete = rs.getString("mapMarkingUrinarySystem_completed");
                String urinarySystemMarks = rs.getString("mapMarkingUrinarySystem_marks");

                //Set data
                lblSidePnlDiagestiveSystemComplete.setText("Completed : " + diagestiveSystemComplete + "%");
                lblSidePnlDiagestiveSystemMarks.setText("Score : " + diagestiveSystemMarks);

                lblSidePnlUrinarySystemComplete.setText("Completed : " + urinarySystemComplete + "%");
                lblSidePnlUrinarySystemMarks.setText("Score : " + urinarySystemMarks);

            }
        } catch (SQLException ex) {
            Logger.getLogger(MapMarkingDigestiveSystem.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Set User datails
        try {
            Connection con = Database.db.getConnection();
            String sql = "SELECT stdFirstName,stdLastName,stdUsername FROM digital_learning_game.register where stdRegisterId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String fName = rs.getString("stdFirstName");
                String lName = rs.getString("stdLastName");
                String username = rs.getString("stdUsername");
                
                //Set Data
                lblSidePnlWelcomeName.setText("HI, "+fName+" "+lName);
                lblSidePnlUsername.setText(username);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MapMarkingDigestiveSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sendDataToDatabase(){
        try {
            // create connection to database
            Connection con = Database.db.getConnection();
            // Create prepared statement with the sql query
            PreparedStatement st1 = con.prepareStatement("UPDATE `digital_learning_game`.`science` SET `mapMarkingRespiratorySystem_marks` = '"+marks+"', `mapMarkingRespiratorySystem_completed` = '"+completed+"' WHERE (`stdRegisterId` = "+RegisterId+");");
            // execute query
            st1.executeUpdate();
            
            // show success message
            //JOptionPane.showMessageDialog(this, "Successfully Inserted...");
        } catch (SQLException ex) {
            Logger.getLogger(MapMarkingDigestiveSystem.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void disableAnswerBox() {
        btnAnswerBox_Bronchioles.setEnabled(false);
        btnAnswerBox_Bronchus.setEnabled(false);
        btnAnswerBox_BuccalCavity.setEnabled(false);
        btnAnswerBox_Diaphragm.setEnabled(false);
        btnAnswerBox_Larynx.setEnabled(false);
        btnAnswerBox_NasalCavity.setEnabled(false);
        btnAnswerBox_Pharynx.setEnabled(false);
        btnAnswerBox_Ribs.setEnabled(false);
        btnAnswerBox_Sternum.setEnabled(false);
        btnAnswerBox_Trachea.setEnabled(false);
    }

    public void enableAnswerBox() {
        btnAnswerBox_Bronchioles.setEnabled(true);
        btnAnswerBox_Bronchus.setEnabled(true);
        btnAnswerBox_BuccalCavity.setEnabled(true);
        btnAnswerBox_Diaphragm.setEnabled(true);
        btnAnswerBox_Larynx.setEnabled(true);
        btnAnswerBox_NasalCavity.setEnabled(true);
        btnAnswerBox_Pharynx.setEnabled(true);
        btnAnswerBox_Ribs.setEnabled(true);
        btnAnswerBox_Sternum.setEnabled(true);
        btnAnswerBox_Trachea.setEnabled(true);
    }

    public void disbalePictureBox() {
        lblPictureBox_Bronchioles.setEnabled(false);
        lblPictureBox_Bronchus.setEnabled(false);
        lblPictureBox_BuccalCavity.setEnabled(false);
        lblPictureBox_Diaphragm.setEnabled(false);
        lblPictureBox_Larynx.setEnabled(false);
        lblPictureBox_NasalCavity.setEnabled(false);
        lblPictureBox_Pharynx.setEnabled(false);
        lblPictureBox_Ribs.setEnabled(false);
        lblPictureBox_Sternum.setEnabled(false);
        lblPictureBox_Trachea.setEnabled(false);
    }

    public void enablePictureBox() {
        lblPictureBox_Bronchioles.setEnabled(true);
        lblPictureBox_Bronchus.setEnabled(true);
        lblPictureBox_BuccalCavity.setEnabled(true);
        lblPictureBox_Diaphragm.setEnabled(true);
        lblPictureBox_Larynx.setEnabled(true);
        lblPictureBox_NasalCavity.setEnabled(true);
        lblPictureBox_Pharynx.setEnabled(true);
        lblPictureBox_Ribs.setEnabled(true);
        lblPictureBox_Sternum.setEnabled(true);
        lblPictureBox_Trachea.setEnabled(true);
    }

    public void selectPictureBox() {
        disbalePictureBox();
        enableAnswerBox();
        selectedPictureBox.setForeground(Color.red);
        selectedPictureBox.setEnabled(true);
    }

    public void selectedAnswerBox() {
        disableAnswerBox();
        enablePictureBox();
        String selectedAnswer = selectedAnswerBox.getText();
        selectedPictureBox.setForeground(Color.black);
        selectedPictureBox.setText(selectedAnswer);
        selectedAnswerBox.setVisible(false);

        completed = completed + 10;
        lblCompletedDisplay.setText("Completed : " + completed + "%");
    }

    public void returnButton() {
        String selectedPictureBoxName = selectedPictureBox.getText();
        if (selectedPictureBoxName.equals("Bronchioles")) {
            btnAnswerBox_Bronchioles.setVisible(true);
        } else if (selectedPictureBoxName.equals("Bronchus")) {
            btnAnswerBox_Bronchus.setVisible(true);
        } else if (selectedPictureBoxName.equals("Buccal cavity")) {
            btnAnswerBox_BuccalCavity.setVisible(true);
        } else if (selectedPictureBoxName.equals("Diaphragm")) {
            btnAnswerBox_Diaphragm.setVisible(true);
        } else if (selectedPictureBoxName.equals("Larynx")) {
            btnAnswerBox_Larynx.setVisible(true);
        } else if (selectedPictureBoxName.equals("Nasal cavity")) {
            btnAnswerBox_NasalCavity.setVisible(true);
        } else if (selectedPictureBoxName.equals("Pharynx")) {
            btnAnswerBox_Pharynx.setVisible(true);
        } else if (selectedPictureBoxName.equals("Ribs")) {
            btnAnswerBox_Ribs.setVisible(true);
        } else if (selectedPictureBoxName.equals("Sternum")) {
            btnAnswerBox_Sternum.setVisible(true);
        } else if (selectedPictureBoxName.equals("Trachea")) {
            btnAnswerBox_Trachea.setVisible(true);
        }

        selectedPictureBox.setText("? ? ?");
        completed = completed - 10;
        lblCompletedDisplay.setText("Completed : " + completed + "%");
    }

    public void setBlackFontColor() {
        lblPictureBox_Bronchioles.setForeground(Color.black);
        lblPictureBox_Bronchus.setForeground(Color.black);
        lblPictureBox_BuccalCavity.setForeground(Color.black);
        lblPictureBox_Diaphragm.setForeground(Color.black);
        lblPictureBox_Larynx.setForeground(Color.black);
        lblPictureBox_NasalCavity.setForeground(Color.black);
        lblPictureBox_Pharynx.setForeground(Color.black);
        lblPictureBox_Ribs.setForeground(Color.black);
        lblPictureBox_Sternum.setForeground(Color.black);
        lblPictureBox_Trachea.setForeground(Color.black);
    }

    public void check() {
        lblMessageBox.setForeground(new Color(204, 0, 51));
        marks = 0;
        // Bronchioles
        if (lblPictureBox_Bronchioles.getText().equals("Bronchioles")) {
            marks = marks + 10;
            lblPictureBox_Bronchioles.setForeground(Color.green);
        } else {
            lblPictureBox_Bronchioles.setForeground(Color.red);
        }

        // Bronchus
        if (lblPictureBox_Bronchus.getText().equals("Bronchus")) {
            marks = marks + 10;
            lblPictureBox_Bronchus.setForeground(Color.green);
        } else {
            lblPictureBox_Bronchus.setForeground(Color.red);
        }

        // Buccal cavity
        if (lblPictureBox_BuccalCavity.getText().equals("Buccal cavity")) {
            marks = marks + 10;
            lblPictureBox_BuccalCavity.setForeground(Color.green);
        } else {
            lblPictureBox_BuccalCavity.setForeground(Color.red);
        }

        // Diaphragm
        if (lblPictureBox_Diaphragm.getText().equals("Diaphragm")) {
            marks = marks + 10;
            lblPictureBox_Diaphragm.setForeground(Color.green);
        } else {
            lblPictureBox_Diaphragm.setForeground(Color.red);
        }

        // Larynx
        if (lblPictureBox_Larynx.getText().equals("Larynx")) {
            marks = marks + 10;
            lblPictureBox_Larynx.setForeground(Color.green);
        } else {
            lblPictureBox_Larynx.setForeground(Color.red);
        }

        // Nasal cavity
        if (lblPictureBox_NasalCavity.getText().equals("Nasal cavity")) {
            marks = marks + 10;
            lblPictureBox_NasalCavity.setForeground(Color.green);
        } else {
            lblPictureBox_NasalCavity.setForeground(Color.red);
        }

        // Pharynx
        if (lblPictureBox_Pharynx.getText().equals("Pharynx")) {
            marks = marks + 10;
            lblPictureBox_Pharynx.setForeground(Color.green);
        } else {
            lblPictureBox_Pharynx.setForeground(Color.red);
        }

        // Ribs
        if (lblPictureBox_Ribs.getText().equals("Ribs")) {
            marks = marks + 10;
            lblPictureBox_Ribs.setForeground(Color.green);
        } else {
            lblPictureBox_Ribs.setForeground(Color.red);
        }

        // Sternum
        if (lblPictureBox_Sternum.getText().equals("Sternum")) {
            marks = marks + 10;
            lblPictureBox_Sternum.setForeground(Color.green);
        } else {
            lblPictureBox_Sternum.setForeground(Color.red);
        }

        // Trachea
        if (lblPictureBox_Trachea.getText().equals("Trachea")) {
            marks = marks + 10;
            lblPictureBox_Trachea.setForeground(Color.green);
        } else {
            lblPictureBox_Trachea.setForeground(Color.red);
        }

        marksSet();
        sendDataToDatabase();
    }

    public void marksSet() {
        if (marks >= 100) {
            lblMessageBox.setVisible(true);
            lblMessageBox.setText("You Pass The game");
            lblMessageBox.setForeground(Color.green);
        } else {
            health = health - 1;
            lblMessageBox.setVisible(true);
            lblMessageBox.setText("Try Again!");
        }
        lblMarks.setText(marks + "");
        healthSet();
    }

    public void healthSet() {
        if (health == 3) {
            lblHealth1.setVisible(true);
            lblHealth2.setVisible(true);
            lblHealth3.setVisible(true);
        } else if (health == 2) {
            lblHealth1.setVisible(true);
            lblHealth2.setVisible(true);
            lblHealth3.setVisible(false);
        } else if (health == 1) {
            lblHealth1.setVisible(true);
            lblHealth2.setVisible(false);
            lblHealth3.setVisible(false);
        } else if (health == 0) {
            lblHealth1.setVisible(false);
            lblHealth2.setVisible(false);
            lblHealth3.setVisible(false);
        } else {
            disableAnswerBox();
            disbalePictureBox();
            btnCheck.setEnabled(false);

            lblMessageBox.setVisible(true);
            lblMessageBox.setText("You Loose the game, Pls Reset");
        }
    }

    public void resetGame() {
        marks = 0;
        health = 3;
        completed = 0;
        disableAnswerBox();
        setBlackFontColor();
        lblMessageBox.setVisible(false);
        btnCheck.setEnabled(true);

        lblPictureBox_Bronchioles.setText("? ? ?");
        lblPictureBox_Bronchus.setText("? ? ?");
        lblPictureBox_BuccalCavity.setText("? ? ?");
        lblPictureBox_Diaphragm.setText("? ? ?");
        lblPictureBox_Larynx.setText("? ? ?");
        lblPictureBox_NasalCavity.setText("? ? ?");
        lblPictureBox_Pharynx.setText("? ? ?");
        lblPictureBox_Ribs.setText("? ? ?");
        lblPictureBox_Sternum.setText("? ? ?");
        lblPictureBox_Trachea.setText("? ? ?");

        btnAnswerBox_Bronchioles.setVisible(true);
        btnAnswerBox_Bronchus.setVisible(true);
        btnAnswerBox_BuccalCavity.setVisible(true);
        btnAnswerBox_Diaphragm.setVisible(true);
        btnAnswerBox_Larynx.setVisible(true);
        btnAnswerBox_NasalCavity.setVisible(true);
        btnAnswerBox_Pharynx.setVisible(true);
        btnAnswerBox_Ribs.setVisible(true);
        btnAnswerBox_Sternum.setVisible(true);
        btnAnswerBox_Trachea.setVisible(true);

        lblMarks.setText("00");
        lblCompletedDisplay.setText("Completed : 0%");
        lblHealth1.setVisible(true);
        lblHealth2.setVisible(true);
        lblHealth3.setVisible(true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblMarks = new javax.swing.JLabel();
        lblHealth1 = new javax.swing.JLabel();
        lblHealth2 = new javax.swing.JLabel();
        lblHealth3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        btnAnswerBox_Bronchioles = new javax.swing.JButton();
        btnAnswerBox_Bronchus = new javax.swing.JButton();
        btnAnswerBox_BuccalCavity = new javax.swing.JButton();
        btnAnswerBox_Diaphragm = new javax.swing.JButton();
        btnAnswerBox_Larynx = new javax.swing.JButton();
        btnAnswerBox_NasalCavity = new javax.swing.JButton();
        btnAnswerBox_Pharynx = new javax.swing.JButton();
        btnAnswerBox_Ribs = new javax.swing.JButton();
        btnAnswerBox_Sternum = new javax.swing.JButton();
        btnAnswerBox_Trachea = new javax.swing.JButton();
        lblCompletedDisplay = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        btnCheck = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        lblMessageBox = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lblPictureBox_Ribs = new javax.swing.JLabel();
        lblPictureBox_NasalCavity = new javax.swing.JLabel();
        lblPictureBox_BuccalCavity = new javax.swing.JLabel();
        lblPictureBox_Larynx = new javax.swing.JLabel();
        lblPictureBox_Diaphragm = new javax.swing.JLabel();
        lblPictureBox_Pharynx = new javax.swing.JLabel();
        lblPictureBox_Trachea = new javax.swing.JLabel();
        lblPictureBox_Sternum = new javax.swing.JLabel();
        lblPictureBox_Bronchus = new javax.swing.JLabel();
        lblPictureBox_Bronchioles = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        lblSidePnlDiagestiveSystemComplete = new javax.swing.JLabel();
        lblSidePnlDiagestiveSystemMarks = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jProgressBar2 = new javax.swing.JProgressBar();
        lblSidePnlUrinarySystemComplete = new javax.swing.JLabel();
        lblSidePnlUrinarySystemMarks = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        lblSidePnlWelcomeName = new javax.swing.JLabel();
        lblSidePnlUsername = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Biological Processes in  Human Body");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Respiratory System");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Health");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Marks");

        lblMarks.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblMarks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMarks.setText("00");

        lblHealth1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Health.png"))); // NOI18N

        lblHealth2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Health.png"))); // NOI18N

        lblHealth3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Health.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblHealth1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblHealth2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblHealth3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMarks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(lblMarks))
                    .addComponent(lblHealth1)
                    .addComponent(lblHealth2)
                    .addComponent(lblHealth3))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Answer Box");

        btnAnswerBox_Bronchioles.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnAnswerBox_Bronchioles.setText("Bronchioles");
        btnAnswerBox_Bronchioles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswerBox_BronchiolesActionPerformed(evt);
            }
        });

        btnAnswerBox_Bronchus.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnAnswerBox_Bronchus.setText("Bronchus");
        btnAnswerBox_Bronchus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswerBox_BronchusActionPerformed(evt);
            }
        });

        btnAnswerBox_BuccalCavity.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnAnswerBox_BuccalCavity.setText("Buccal cavity");
        btnAnswerBox_BuccalCavity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswerBox_BuccalCavityActionPerformed(evt);
            }
        });

        btnAnswerBox_Diaphragm.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnAnswerBox_Diaphragm.setText("Diaphragm");
        btnAnswerBox_Diaphragm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswerBox_DiaphragmActionPerformed(evt);
            }
        });

        btnAnswerBox_Larynx.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnAnswerBox_Larynx.setText("Larynx");
        btnAnswerBox_Larynx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswerBox_LarynxActionPerformed(evt);
            }
        });

        btnAnswerBox_NasalCavity.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnAnswerBox_NasalCavity.setText("Nasal cavity");
        btnAnswerBox_NasalCavity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswerBox_NasalCavityActionPerformed(evt);
            }
        });

        btnAnswerBox_Pharynx.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnAnswerBox_Pharynx.setText("Pharynx");
        btnAnswerBox_Pharynx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswerBox_PharynxActionPerformed(evt);
            }
        });

        btnAnswerBox_Ribs.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnAnswerBox_Ribs.setText("Ribs");
        btnAnswerBox_Ribs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswerBox_RibsActionPerformed(evt);
            }
        });

        btnAnswerBox_Sternum.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnAnswerBox_Sternum.setText("Sternum");
        btnAnswerBox_Sternum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswerBox_SternumActionPerformed(evt);
            }
        });

        btnAnswerBox_Trachea.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnAnswerBox_Trachea.setText("Trachea");
        btnAnswerBox_Trachea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswerBox_TracheaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(btnAnswerBox_Bronchioles, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAnswerBox_Bronchus, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(btnAnswerBox_BuccalCavity, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAnswerBox_Diaphragm, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(btnAnswerBox_Larynx, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAnswerBox_NasalCavity, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(btnAnswerBox_Pharynx, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAnswerBox_Ribs, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(btnAnswerBox_Sternum, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAnswerBox_Trachea, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAnswerBox_Bronchioles)
                    .addComponent(btnAnswerBox_Bronchus))
                .addGap(11, 11, 11)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAnswerBox_BuccalCavity)
                    .addComponent(btnAnswerBox_Diaphragm))
                .addGap(11, 11, 11)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAnswerBox_Larynx)
                    .addComponent(btnAnswerBox_NasalCavity))
                .addGap(11, 11, 11)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAnswerBox_Pharynx)
                    .addComponent(btnAnswerBox_Ribs))
                .addGap(11, 11, 11)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAnswerBox_Sternum)
                    .addComponent(btnAnswerBox_Trachea))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblCompletedDisplay.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblCompletedDisplay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCompletedDisplay.setText("Completed : 0%");

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        btnCheck.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnCheck.setText("Check");
        btnCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnReset.setForeground(new java.awt.Color(102, 102, 102));
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCheck, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                    .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReset)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        lblMessageBox.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblMessageBox.setForeground(new java.awt.Color(204, 0, 51));
        lblMessageBox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMessageBox.setText("jLabel9");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCompletedDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMessageBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCompletedDisplay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127)
                .addComponent(lblMessageBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Picture Box");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPictureBox_Ribs.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPictureBox_Ribs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPictureBox_Ribs.setText("? ? ?");
        lblPictureBox_Ribs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPictureBox_RibsMouseClicked(evt);
            }
        });
        jPanel6.add(lblPictureBox_Ribs, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 310, 110, -1));

        lblPictureBox_NasalCavity.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPictureBox_NasalCavity.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPictureBox_NasalCavity.setText("? ? ?");
        lblPictureBox_NasalCavity.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPictureBox_NasalCavityMouseClicked(evt);
            }
        });
        jPanel6.add(lblPictureBox_NasalCavity, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 120, -1));

        lblPictureBox_BuccalCavity.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPictureBox_BuccalCavity.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPictureBox_BuccalCavity.setText("? ? ?");
        lblPictureBox_BuccalCavity.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPictureBox_BuccalCavityMouseClicked(evt);
            }
        });
        jPanel6.add(lblPictureBox_BuccalCavity, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 120, -1));

        lblPictureBox_Larynx.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPictureBox_Larynx.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPictureBox_Larynx.setText("? ? ?");
        lblPictureBox_Larynx.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPictureBox_LarynxMouseClicked(evt);
            }
        });
        jPanel6.add(lblPictureBox_Larynx, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 130, -1));

        lblPictureBox_Diaphragm.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPictureBox_Diaphragm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPictureBox_Diaphragm.setText("? ? ?");
        lblPictureBox_Diaphragm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPictureBox_DiaphragmMouseClicked(evt);
            }
        });
        jPanel6.add(lblPictureBox_Diaphragm, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 380, 110, -1));

        lblPictureBox_Pharynx.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPictureBox_Pharynx.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPictureBox_Pharynx.setText("? ? ?");
        lblPictureBox_Pharynx.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPictureBox_PharynxMouseClicked(evt);
            }
        });
        jPanel6.add(lblPictureBox_Pharynx, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 110, -1));

        lblPictureBox_Trachea.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPictureBox_Trachea.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPictureBox_Trachea.setText("? ? ?");
        lblPictureBox_Trachea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPictureBox_TracheaMouseClicked(evt);
            }
        });
        jPanel6.add(lblPictureBox_Trachea, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, 120, -1));

        lblPictureBox_Sternum.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPictureBox_Sternum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPictureBox_Sternum.setText("? ? ?");
        lblPictureBox_Sternum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPictureBox_SternumMouseClicked(evt);
            }
        });
        jPanel6.add(lblPictureBox_Sternum, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, 120, -1));

        lblPictureBox_Bronchus.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPictureBox_Bronchus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPictureBox_Bronchus.setText("? ? ?");
        lblPictureBox_Bronchus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPictureBox_BronchusMouseClicked(evt);
            }
        });
        jPanel6.add(lblPictureBox_Bronchus, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, 110, -1));

        lblPictureBox_Bronchioles.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPictureBox_Bronchioles.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPictureBox_Bronchioles.setText("? ? ?");
        lblPictureBox_Bronchioles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPictureBox_BronchiolesMouseClicked(evt);
            }
        });
        jPanel6.add(lblPictureBox_Bronchioles, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 350, 110, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MapMarking_RespiractorySystem.png"))); // NOI18N
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 470));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Match the parts of the Digestive System To Answer Box");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Diagestive System");

        lblSidePnlDiagestiveSystemComplete.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblSidePnlDiagestiveSystemComplete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSidePnlDiagestiveSystemComplete.setText("Completed : 0%");

        lblSidePnlDiagestiveSystemMarks.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSidePnlDiagestiveSystemMarks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSidePnlDiagestiveSystemMarks.setText("Score : 00");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(lblSidePnlDiagestiveSystemComplete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSidePnlDiagestiveSystemMarks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSidePnlDiagestiveSystemComplete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSidePnlDiagestiveSystemMarks)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Other Scores");

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Urinary System");

        lblSidePnlUrinarySystemComplete.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblSidePnlUrinarySystemComplete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSidePnlUrinarySystemComplete.setText("Completed : 0%");

        lblSidePnlUrinarySystemMarks.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSidePnlUrinarySystemMarks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSidePnlUrinarySystemMarks.setText("Score : 00");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jProgressBar2, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(lblSidePnlUrinarySystemComplete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSidePnlUrinarySystemMarks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSidePnlUrinarySystemComplete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSidePnlUrinarySystemMarks)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(242, 235, 231));

        lblSidePnlWelcomeName.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        lblSidePnlWelcomeName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSidePnlWelcomeName.setText("HI, Admin Admin");

        lblSidePnlUsername.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSidePnlUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSidePnlUsername.setText("admin_admin");

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/profile.png"))); // NOI18N

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSidePnlWelcomeName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSidePnlUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel13Layout.createSequentialGroup()
                        .addComponent(lblSidePnlWelcomeName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSidePnlUsername)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
     // ====================== Code to Picture box Buttons ====================//
    private void lblPictureBox_NasalCavityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPictureBox_NasalCavityMouseClicked
        // TODO add your handling code here:
        setBlackFontColor();
        selectedPictureBox = lblPictureBox_NasalCavity;
        if (selectedPictureBox.getText().equals("? ? ?")) {
            selectPictureBox();
        } else {
            returnButton();
        }
    }//GEN-LAST:event_lblPictureBox_NasalCavityMouseClicked

    private void lblPictureBox_BuccalCavityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPictureBox_BuccalCavityMouseClicked
        // TODO add your handling code here:
        setBlackFontColor();
        selectedPictureBox = lblPictureBox_BuccalCavity;
        if (selectedPictureBox.getText().equals("? ? ?")) {
            selectPictureBox();
        } else {
            returnButton();
        }
    }//GEN-LAST:event_lblPictureBox_BuccalCavityMouseClicked

    private void lblPictureBox_LarynxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPictureBox_LarynxMouseClicked
        // TODO add your handling code here:
        setBlackFontColor();
        selectedPictureBox = lblPictureBox_Larynx;
        if (selectedPictureBox.getText().equals("? ? ?")) {
            selectPictureBox();
        } else {
            returnButton();
        }
    }//GEN-LAST:event_lblPictureBox_LarynxMouseClicked

    private void lblPictureBox_PharynxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPictureBox_PharynxMouseClicked
        // TODO add your handling code here:
        setBlackFontColor();
        selectedPictureBox = lblPictureBox_Pharynx;
        if (selectedPictureBox.getText().equals("? ? ?")) {
            selectPictureBox();
        } else {
            returnButton();
        }
    }//GEN-LAST:event_lblPictureBox_PharynxMouseClicked

    private void lblPictureBox_TracheaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPictureBox_TracheaMouseClicked
        // TODO add your handling code here:
        setBlackFontColor();
        selectedPictureBox = lblPictureBox_Trachea;
        if (selectedPictureBox.getText().equals("? ? ?")) {
            selectPictureBox();
        } else {
            returnButton();
        }
    }//GEN-LAST:event_lblPictureBox_TracheaMouseClicked

    private void lblPictureBox_SternumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPictureBox_SternumMouseClicked
        // TODO add your handling code here:
        setBlackFontColor();
        selectedPictureBox = lblPictureBox_Sternum;
        if (selectedPictureBox.getText().equals("? ? ?")) {
            selectPictureBox();
        } else {
            returnButton();
        }
    }//GEN-LAST:event_lblPictureBox_SternumMouseClicked

    private void lblPictureBox_BronchusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPictureBox_BronchusMouseClicked
        // TODO add your handling code here:
        setBlackFontColor();
        selectedPictureBox = lblPictureBox_Bronchus;
        if (selectedPictureBox.getText().equals("? ? ?")) {
            selectPictureBox();
        } else {
            returnButton();
        }
    }//GEN-LAST:event_lblPictureBox_BronchusMouseClicked

    private void lblPictureBox_RibsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPictureBox_RibsMouseClicked
        // TODO add your handling code here:
        setBlackFontColor();
        selectedPictureBox = lblPictureBox_Ribs;
        if (selectedPictureBox.getText().equals("? ? ?")) {
            selectPictureBox();
        } else {
            returnButton();
        }
    }//GEN-LAST:event_lblPictureBox_RibsMouseClicked

    private void lblPictureBox_BronchiolesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPictureBox_BronchiolesMouseClicked
        // TODO add your handling code here:
        setBlackFontColor();
        selectedPictureBox = lblPictureBox_Bronchioles;
        if (selectedPictureBox.getText().equals("? ? ?")) {
            selectPictureBox();
        } else {
            returnButton();
        }
    }//GEN-LAST:event_lblPictureBox_BronchiolesMouseClicked

    private void lblPictureBox_DiaphragmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPictureBox_DiaphragmMouseClicked
        // TODO add your handling code here:
        setBlackFontColor();
        selectedPictureBox = lblPictureBox_Diaphragm;
        if (selectedPictureBox.getText().equals("? ? ?")) {
            selectPictureBox();
        } else {
            returnButton();
        }
    }//GEN-LAST:event_lblPictureBox_DiaphragmMouseClicked

    // ========================= Code to Anser box Buttons =====================//
    private void btnAnswerBox_BronchiolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswerBox_BronchiolesActionPerformed
        // TODO add your handling code here:
        selectedAnswerBox = btnAnswerBox_Bronchioles;
        selectedAnswerBox();
    }//GEN-LAST:event_btnAnswerBox_BronchiolesActionPerformed

    private void btnAnswerBox_BronchusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswerBox_BronchusActionPerformed
        // TODO add your handling code here:
        selectedAnswerBox = btnAnswerBox_Bronchus;
        selectedAnswerBox();
    }//GEN-LAST:event_btnAnswerBox_BronchusActionPerformed

    private void btnAnswerBox_BuccalCavityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswerBox_BuccalCavityActionPerformed
        // TODO add your handling code here:
        selectedAnswerBox = btnAnswerBox_BuccalCavity;
        selectedAnswerBox();
    }//GEN-LAST:event_btnAnswerBox_BuccalCavityActionPerformed

    private void btnAnswerBox_DiaphragmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswerBox_DiaphragmActionPerformed
        // TODO add your handling code here:
        selectedAnswerBox = btnAnswerBox_Diaphragm;
        selectedAnswerBox();
    }//GEN-LAST:event_btnAnswerBox_DiaphragmActionPerformed

    private void btnAnswerBox_LarynxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswerBox_LarynxActionPerformed
        // TODO add your handling code here:
        selectedAnswerBox = btnAnswerBox_Larynx;
        selectedAnswerBox();
    }//GEN-LAST:event_btnAnswerBox_LarynxActionPerformed

    private void btnAnswerBox_NasalCavityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswerBox_NasalCavityActionPerformed
        // TODO add your handling code here:
        selectedAnswerBox = btnAnswerBox_NasalCavity;
        selectedAnswerBox();
    }//GEN-LAST:event_btnAnswerBox_NasalCavityActionPerformed

    private void btnAnswerBox_PharynxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswerBox_PharynxActionPerformed
        // TODO add your handling code here:
        selectedAnswerBox = btnAnswerBox_Pharynx;
        selectedAnswerBox();
    }//GEN-LAST:event_btnAnswerBox_PharynxActionPerformed

    private void btnAnswerBox_RibsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswerBox_RibsActionPerformed
        // TODO add your handling code here:
        selectedAnswerBox = btnAnswerBox_Ribs;
        selectedAnswerBox();
    }//GEN-LAST:event_btnAnswerBox_RibsActionPerformed

    private void btnAnswerBox_SternumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswerBox_SternumActionPerformed
        // TODO add your handling code here:
        selectedAnswerBox = btnAnswerBox_Sternum;
        selectedAnswerBox();
    }//GEN-LAST:event_btnAnswerBox_SternumActionPerformed

    private void btnAnswerBox_TracheaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswerBox_TracheaActionPerformed
        // TODO add your handling code here:
        selectedAnswerBox = btnAnswerBox_Trachea;
        selectedAnswerBox();
    }//GEN-LAST:event_btnAnswerBox_TracheaActionPerformed

    //buttons
    private void btnCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckActionPerformed
        // TODO add your handling code here:
        check();
    }//GEN-LAST:event_btnCheckActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        resetGame();
    }//GEN-LAST:event_btnResetActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        MapMaking mm = new MapMaking();
        mm.Setdata(RegisterId);
        
        mm.show();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
    
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
            java.util.logging.Logger.getLogger(MapMarkingRespiratorySystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MapMarkingRespiratorySystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MapMarkingRespiratorySystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MapMarkingRespiratorySystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MapMarkingRespiratorySystem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnswerBox_Bronchioles;
    private javax.swing.JButton btnAnswerBox_Bronchus;
    private javax.swing.JButton btnAnswerBox_BuccalCavity;
    private javax.swing.JButton btnAnswerBox_Diaphragm;
    private javax.swing.JButton btnAnswerBox_Larynx;
    private javax.swing.JButton btnAnswerBox_NasalCavity;
    private javax.swing.JButton btnAnswerBox_Pharynx;
    private javax.swing.JButton btnAnswerBox_Ribs;
    private javax.swing.JButton btnAnswerBox_Sternum;
    private javax.swing.JButton btnAnswerBox_Trachea;
    private javax.swing.JButton btnCheck;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCompletedDisplay;
    private javax.swing.JLabel lblHealth1;
    private javax.swing.JLabel lblHealth2;
    private javax.swing.JLabel lblHealth3;
    private javax.swing.JLabel lblMarks;
    private javax.swing.JLabel lblMessageBox;
    private javax.swing.JLabel lblPictureBox_Bronchioles;
    private javax.swing.JLabel lblPictureBox_Bronchus;
    private javax.swing.JLabel lblPictureBox_BuccalCavity;
    private javax.swing.JLabel lblPictureBox_Diaphragm;
    private javax.swing.JLabel lblPictureBox_Larynx;
    private javax.swing.JLabel lblPictureBox_NasalCavity;
    private javax.swing.JLabel lblPictureBox_Pharynx;
    private javax.swing.JLabel lblPictureBox_Ribs;
    private javax.swing.JLabel lblPictureBox_Sternum;
    private javax.swing.JLabel lblPictureBox_Trachea;
    private javax.swing.JLabel lblSidePnlDiagestiveSystemComplete;
    private javax.swing.JLabel lblSidePnlDiagestiveSystemMarks;
    private javax.swing.JLabel lblSidePnlUrinarySystemComplete;
    private javax.swing.JLabel lblSidePnlUrinarySystemMarks;
    private javax.swing.JLabel lblSidePnlUsername;
    private javax.swing.JLabel lblSidePnlWelcomeName;
    // End of variables declaration//GEN-END:variables
}
