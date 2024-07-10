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
public class MapMarkingUrinarySystem extends javax.swing.JFrame {

    /**
     * Creates new form MapMarkingUrinarySystem
     */
    String RegisterId;
    int marks = 0;
    int health = 3;
    int completed = 0;
    JLabel selectedPictureBox;
    JButton selectedAnswerBox;

    public MapMarkingUrinarySystem() {
        initComponents();
        disableAnswerBox();
        lblMessageBox.setVisible(false);
    }

    public void Setdata(String ID) {
        RegisterId = ID;

        //set user marks
        try {
            Connection con = Database.db.getConnection();
            String sql = "SELECT mapMarkingDignestiveSystem_marks,mapMarkingDignestiveSystem_completed,mapMarkingRespiratorySystem_marks,mapMarkingRespiratorySystem_completed FROM digital_learning_game.science where stdRegisterId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String diagestiveSystemComplete = rs.getString("mapMarkingDignestiveSystem_completed");
                String diagestiveSystemMarks = rs.getString("mapMarkingDignestiveSystem_marks");

                String respiratorySystemComplete = rs.getString("mapMarkingRespiratorySystem_completed");
                String respiratorySysteMarks = rs.getString("mapMarkingRespiratorySystem_marks");

                //Set data
                lblSidePnlDiagestiveSystemComplete.setText("Completed : " + diagestiveSystemComplete + "%");
                lblSidePnlDiagestiveSystemMarks.setText("Score : " + diagestiveSystemMarks);

                lblSidePnlRespiratorySystemComplete.setText("Completed : " + respiratorySystemComplete + "%");
                lblSidePnlRespiratorySystemMarks.setText("Score : " + respiratorySysteMarks);

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

    public void sendDataToDatabase() {
        try {
            // create connection to database
            Connection con = Database.db.getConnection();
            // Create prepared statement with the sql query
            PreparedStatement st1 = con.prepareStatement("UPDATE `digital_learning_game`.`science` SET `mapMarkingUrinarySystem_marks` = '" + marks + "', `mapMarkingUrinarySystem_completed` = '" + completed + "' WHERE (`stdRegisterId` = " + RegisterId + ");");
            // execute query
            st1.executeUpdate();

            // show success message
            //JOptionPane.showMessageDialog(this, "Successfully Inserted...");
        } catch (SQLException ex) {
            Logger.getLogger(MapMarkingDigestiveSystem.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void disableAnswerBox() {
        btnAnswerBox_Bladder.setEnabled(false);
        btnAnswerBox_InferiorVenaCava.setEnabled(false);
        btnAnswerBox_Kidneys.setEnabled(false);
        btnAnswerBox_RenalArtery.setEnabled(false);
        btnAnswerBox_RenalVein.setEnabled(false);
        btnAnswerBox_SystemicArtery.setEnabled(false);
        btnAnswerBox_Ureters.setEnabled(false);
        btnAnswerBox_Urethra.setEnabled(false);
    }

    public void enableAnswerBox() {
        btnAnswerBox_Bladder.setEnabled(true);
        btnAnswerBox_InferiorVenaCava.setEnabled(true);
        btnAnswerBox_Kidneys.setEnabled(true);
        btnAnswerBox_RenalArtery.setEnabled(true);
        btnAnswerBox_RenalVein.setEnabled(true);
        btnAnswerBox_SystemicArtery.setEnabled(true);
        btnAnswerBox_Ureters.setEnabled(true);
        btnAnswerBox_Urethra.setEnabled(true);
    }

    public void disbalePictureBox() {
        lblPictureBox_Bladder.setEnabled(false);
        lblPictureBox_InferiorVenaCava.setEnabled(false);
        lblPictureBox_Kidneys.setEnabled(false);
        lblPictureBox_RenalArtery.setEnabled(false);
        lblPictureBox_RenalVein.setEnabled(false);
        lblPictureBox_SystemicArtery.setEnabled(false);
        lblPictureBox_Ureters.setEnabled(false);
        lblPictureBox_Urethra.setEnabled(false);
    }

    public void enablePictureBox() {
        lblPictureBox_Bladder.setEnabled(true);
        lblPictureBox_InferiorVenaCava.setEnabled(true);
        lblPictureBox_Kidneys.setEnabled(true);
        lblPictureBox_RenalArtery.setEnabled(true);
        lblPictureBox_RenalVein.setEnabled(true);
        lblPictureBox_SystemicArtery.setEnabled(true);
        lblPictureBox_Ureters.setEnabled(true);
        lblPictureBox_Urethra.setEnabled(true);
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

        completed = completed + 12;
        lblCompletedDisplay.setText("Completed : " + completed + "%");
    }

    public void returnButton() {
        String selectedPictureBoxName = selectedPictureBox.getText();
        if (selectedPictureBoxName.equals("Bladder")) {
            btnAnswerBox_Bladder.setVisible(true);
        } else if (selectedPictureBoxName.equals("Inferior vena cava")) {
            btnAnswerBox_InferiorVenaCava.setVisible(true);
        } else if (selectedPictureBoxName.equals("Kidneys")) {
            btnAnswerBox_Kidneys.setVisible(true);
        } else if (selectedPictureBoxName.equals("Renal artery")) {
            btnAnswerBox_RenalArtery.setVisible(true);
        } else if (selectedPictureBoxName.equals("Renal vein")) {
            btnAnswerBox_RenalVein.setVisible(true);
        } else if (selectedPictureBoxName.equals("Systemic artery")) {
            btnAnswerBox_SystemicArtery.setVisible(true);
        } else if (selectedPictureBoxName.equals("Ureters")) {
            btnAnswerBox_Ureters.setVisible(true);
        } else if (selectedPictureBoxName.equals("Urethra")) {
            btnAnswerBox_Urethra.setVisible(true);
        }

        selectedPictureBox.setText("? ? ?");
        completed = completed - 12;
        lblCompletedDisplay.setText("Completed : " + completed + "%");
    }

    public void setBlackFontColor() {
        lblPictureBox_Bladder.setForeground(Color.black);
        lblPictureBox_InferiorVenaCava.setForeground(Color.black);
        lblPictureBox_Kidneys.setForeground(Color.black);
        lblPictureBox_RenalArtery.setForeground(Color.black);
        lblPictureBox_RenalVein.setForeground(Color.black);
        lblPictureBox_SystemicArtery.setForeground(Color.black);
        lblPictureBox_Ureters.setForeground(Color.black);
        lblPictureBox_Urethra.setForeground(Color.black);
    }

    public void check() {
        lblMessageBox.setForeground(new Color(204, 0, 51));
        marks = 0;
        // Bladder
        if (lblPictureBox_Bladder.getText().equals("Bladder")) {
            marks = marks + 12;
            lblPictureBox_Bladder.setForeground(Color.green);
        } else {
            lblPictureBox_Bladder.setForeground(Color.red);
        }

        // Inferior vena cava
        if (lblPictureBox_InferiorVenaCava.getText().equals("Inferior vena cava")) {
            marks = marks + 12;
            lblPictureBox_InferiorVenaCava.setForeground(Color.green);
        } else {
            lblPictureBox_InferiorVenaCava.setForeground(Color.red);
        }

        // Kidneys
        if (lblPictureBox_Kidneys.getText().equals("Kidneys")) {
            marks = marks + 12;
            lblPictureBox_Kidneys.setForeground(Color.green);
        } else {
            lblPictureBox_Kidneys.setForeground(Color.red);
        }

        // Renal artery
        if (lblPictureBox_RenalArtery.getText().equals("Renal artery")) {
            marks = marks + 12;
            lblPictureBox_RenalArtery.setForeground(Color.green);
        } else {
            lblPictureBox_RenalArtery.setForeground(Color.red);
        }

        // Renal vein
        if (lblPictureBox_RenalVein.getText().equals("Renal vein")) {
            marks = marks + 12;
            lblPictureBox_RenalVein.setForeground(Color.green);
        } else {
            lblPictureBox_RenalVein.setForeground(Color.red);
        }

        // Systemic artery
        if (lblPictureBox_SystemicArtery.getText().equals("Systemic artery")) {
            marks = marks + 12;
            lblPictureBox_SystemicArtery.setForeground(Color.green);
        } else {
            lblPictureBox_SystemicArtery.setForeground(Color.red);
        }

        // Ureters
        if (lblPictureBox_Ureters.getText().equals("Ureters")) {
            marks = marks + 12;
            lblPictureBox_Ureters.setForeground(Color.green);
        } else {
            lblPictureBox_Ureters.setForeground(Color.red);
        }

        // Urethra
        if (lblPictureBox_Urethra.getText().equals("Urethra")) {
            marks = marks + 12;
            lblPictureBox_Urethra.setForeground(Color.green);
        } else {
            lblPictureBox_Urethra.setForeground(Color.red);
        }

        marksSet();
        sendDataToDatabase();
    }

    public void marksSet() {
        if (marks >= 96) {
            marks = 100;
            completed = 100;
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

        lblPictureBox_Bladder.setText("? ? ?");
        lblPictureBox_InferiorVenaCava.setText("? ? ?");
        lblPictureBox_Kidneys.setText("? ? ?");
        lblPictureBox_RenalArtery.setText("? ? ?");
        lblPictureBox_RenalVein.setText("? ? ?");
        lblPictureBox_SystemicArtery.setText("? ? ?");
        lblPictureBox_Ureters.setText("? ? ?");
        lblPictureBox_Urethra.setText("? ? ?");

        btnAnswerBox_Bladder.setVisible(true);
        btnAnswerBox_InferiorVenaCava.setVisible(true);
        btnAnswerBox_Kidneys.setVisible(true);
        btnAnswerBox_RenalArtery.setVisible(true);
        btnAnswerBox_RenalVein.setVisible(true);
        btnAnswerBox_SystemicArtery.setVisible(true);
        btnAnswerBox_Ureters.setVisible(true);
        btnAnswerBox_Urethra.setVisible(true);

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
        btnAnswerBox_Bladder = new javax.swing.JButton();
        btnAnswerBox_InferiorVenaCava = new javax.swing.JButton();
        btnAnswerBox_Kidneys = new javax.swing.JButton();
        btnAnswerBox_RenalArtery = new javax.swing.JButton();
        btnAnswerBox_RenalVein = new javax.swing.JButton();
        btnAnswerBox_SystemicArtery = new javax.swing.JButton();
        btnAnswerBox_Ureters = new javax.swing.JButton();
        btnAnswerBox_Urethra = new javax.swing.JButton();
        lblCompletedDisplay = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        btnCheck = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        lblMessageBox = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lblPictureBox_RenalArtery = new javax.swing.JLabel();
        lblPictureBox_RenalVein = new javax.swing.JLabel();
        lblPictureBox_InferiorVenaCava = new javax.swing.JLabel();
        lblPictureBox_Kidneys = new javax.swing.JLabel();
        lblPictureBox_Ureters = new javax.swing.JLabel();
        lblPictureBox_Bladder = new javax.swing.JLabel();
        lblPictureBox_Urethra = new javax.swing.JLabel();
        lblPictureBox_SystemicArtery = new javax.swing.JLabel();
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
        lblSidePnlRespiratorySystemComplete = new javax.swing.JLabel();
        lblSidePnlRespiratorySystemMarks = new javax.swing.JLabel();
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
        jLabel2.setText("Urinary System");

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

        btnAnswerBox_Bladder.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnAnswerBox_Bladder.setText("Bladder");
        btnAnswerBox_Bladder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswerBox_BladderActionPerformed(evt);
            }
        });

        btnAnswerBox_InferiorVenaCava.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnAnswerBox_InferiorVenaCava.setText("Inferior vena cava");
        btnAnswerBox_InferiorVenaCava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswerBox_InferiorVenaCavaActionPerformed(evt);
            }
        });

        btnAnswerBox_Kidneys.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnAnswerBox_Kidneys.setText("Kidneys");
        btnAnswerBox_Kidneys.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswerBox_KidneysActionPerformed(evt);
            }
        });

        btnAnswerBox_RenalArtery.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnAnswerBox_RenalArtery.setText("Renal artery");
        btnAnswerBox_RenalArtery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswerBox_RenalArteryActionPerformed(evt);
            }
        });

        btnAnswerBox_RenalVein.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnAnswerBox_RenalVein.setText("Renal vein");
        btnAnswerBox_RenalVein.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswerBox_RenalVeinActionPerformed(evt);
            }
        });

        btnAnswerBox_SystemicArtery.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnAnswerBox_SystemicArtery.setText("Systemic artery");
        btnAnswerBox_SystemicArtery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswerBox_SystemicArteryActionPerformed(evt);
            }
        });

        btnAnswerBox_Ureters.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnAnswerBox_Ureters.setText("Ureters");
        btnAnswerBox_Ureters.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswerBox_UretersActionPerformed(evt);
            }
        });

        btnAnswerBox_Urethra.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnAnswerBox_Urethra.setText("Urethra");
        btnAnswerBox_Urethra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswerBox_UrethraActionPerformed(evt);
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
                        .addComponent(btnAnswerBox_Bladder, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAnswerBox_InferiorVenaCava, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(btnAnswerBox_Kidneys, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAnswerBox_RenalArtery, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(btnAnswerBox_RenalVein, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAnswerBox_SystemicArtery, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(btnAnswerBox_Ureters, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAnswerBox_Urethra, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAnswerBox_Bladder)
                    .addComponent(btnAnswerBox_InferiorVenaCava))
                .addGap(11, 11, 11)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAnswerBox_Kidneys)
                    .addComponent(btnAnswerBox_RenalArtery))
                .addGap(11, 11, 11)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAnswerBox_RenalVein)
                    .addComponent(btnAnswerBox_SystemicArtery))
                .addGap(11, 11, 11)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAnswerBox_Ureters)
                    .addComponent(btnAnswerBox_Urethra))
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
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCompletedDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Picture Box");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPictureBox_RenalArtery.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPictureBox_RenalArtery.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPictureBox_RenalArtery.setText("? ? ?");
        lblPictureBox_RenalArtery.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPictureBox_RenalArteryMouseClicked(evt);
            }
        });
        jPanel6.add(lblPictureBox_RenalArtery, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 130, -1));

        lblPictureBox_RenalVein.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPictureBox_RenalVein.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPictureBox_RenalVein.setText("? ? ?");
        lblPictureBox_RenalVein.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPictureBox_RenalVeinMouseClicked(evt);
            }
        });
        jPanel6.add(lblPictureBox_RenalVein, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 130, -1));

        lblPictureBox_InferiorVenaCava.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPictureBox_InferiorVenaCava.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPictureBox_InferiorVenaCava.setText("? ? ?");
        lblPictureBox_InferiorVenaCava.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPictureBox_InferiorVenaCavaMouseClicked(evt);
            }
        });
        jPanel6.add(lblPictureBox_InferiorVenaCava, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, 130, -1));

        lblPictureBox_Kidneys.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPictureBox_Kidneys.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPictureBox_Kidneys.setText("? ? ?");
        lblPictureBox_Kidneys.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPictureBox_KidneysMouseClicked(evt);
            }
        });
        jPanel6.add(lblPictureBox_Kidneys, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 120, -1));

        lblPictureBox_Ureters.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPictureBox_Ureters.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPictureBox_Ureters.setText("? ? ?");
        lblPictureBox_Ureters.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPictureBox_UretersMouseClicked(evt);
            }
        });
        jPanel6.add(lblPictureBox_Ureters, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, 120, -1));

        lblPictureBox_Bladder.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPictureBox_Bladder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPictureBox_Bladder.setText("? ? ?");
        lblPictureBox_Bladder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPictureBox_BladderMouseClicked(evt);
            }
        });
        jPanel6.add(lblPictureBox_Bladder, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 380, 120, -1));

        lblPictureBox_Urethra.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPictureBox_Urethra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPictureBox_Urethra.setText("? ? ?");
        lblPictureBox_Urethra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPictureBox_UrethraMouseClicked(evt);
            }
        });
        jPanel6.add(lblPictureBox_Urethra, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 440, 120, -1));

        lblPictureBox_SystemicArtery.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPictureBox_SystemicArtery.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPictureBox_SystemicArtery.setText("? ? ?");
        lblPictureBox_SystemicArtery.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPictureBox_SystemicArteryMouseClicked(evt);
            }
        });
        jPanel6.add(lblPictureBox_SystemicArtery, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 130, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MapMarking_UrinarySystem.png"))); // NOI18N
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        jLabel13.setText("Respiratory System");

        lblSidePnlRespiratorySystemComplete.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblSidePnlRespiratorySystemComplete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSidePnlRespiratorySystemComplete.setText("Completed : 0%");

        lblSidePnlRespiratorySystemMarks.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSidePnlRespiratorySystemMarks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSidePnlRespiratorySystemMarks.setText("Score : 00");

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
                    .addComponent(lblSidePnlRespiratorySystemComplete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSidePnlRespiratorySystemMarks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(lblSidePnlRespiratorySystemComplete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSidePnlRespiratorySystemMarks)
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
                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    private void lblPictureBox_RenalArteryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPictureBox_RenalArteryMouseClicked
        // TODO add your handling code here:
        setBlackFontColor();
        selectedPictureBox = lblPictureBox_RenalArtery;
        if (selectedPictureBox.getText().equals("? ? ?")) {
            selectPictureBox();
        } else {
            returnButton();
        }
    }//GEN-LAST:event_lblPictureBox_RenalArteryMouseClicked

    private void lblPictureBox_KidneysMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPictureBox_KidneysMouseClicked
        // TODO add your handling code here:
        setBlackFontColor();
        selectedPictureBox = lblPictureBox_Kidneys;
        if (selectedPictureBox.getText().equals("? ? ?")) {
            selectPictureBox();
        } else {
            returnButton();
        }
    }//GEN-LAST:event_lblPictureBox_KidneysMouseClicked

    private void lblPictureBox_RenalVeinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPictureBox_RenalVeinMouseClicked
        // TODO add your handling code here:
        setBlackFontColor();
        selectedPictureBox = lblPictureBox_RenalVein;
        if (selectedPictureBox.getText().equals("? ? ?")) {
            selectPictureBox();
        } else {
            returnButton();
        }
    }//GEN-LAST:event_lblPictureBox_RenalVeinMouseClicked

    private void lblPictureBox_SystemicArteryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPictureBox_SystemicArteryMouseClicked
        // TODO add your handling code here:
        setBlackFontColor();
        selectedPictureBox = lblPictureBox_SystemicArtery;
        if (selectedPictureBox.getText().equals("? ? ?")) {
            selectPictureBox();
        } else {
            returnButton();
        }
    }//GEN-LAST:event_lblPictureBox_SystemicArteryMouseClicked

    private void lblPictureBox_InferiorVenaCavaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPictureBox_InferiorVenaCavaMouseClicked
        // TODO add your handling code here:
        setBlackFontColor();
        selectedPictureBox = lblPictureBox_InferiorVenaCava;
        if (selectedPictureBox.getText().equals("? ? ?")) {
            selectPictureBox();
        } else {
            returnButton();
        }
    }//GEN-LAST:event_lblPictureBox_InferiorVenaCavaMouseClicked

    private void lblPictureBox_UretersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPictureBox_UretersMouseClicked
        // TODO add your handling code here:
        setBlackFontColor();
        selectedPictureBox = lblPictureBox_Ureters;
        if (selectedPictureBox.getText().equals("? ? ?")) {
            selectPictureBox();
        } else {
            returnButton();
        }
    }//GEN-LAST:event_lblPictureBox_UretersMouseClicked

    private void lblPictureBox_BladderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPictureBox_BladderMouseClicked
        // TODO add your handling code here:
        setBlackFontColor();
        selectedPictureBox = lblPictureBox_Bladder;
        if (selectedPictureBox.getText().equals("? ? ?")) {
            selectPictureBox();
        } else {
            returnButton();
        }
    }//GEN-LAST:event_lblPictureBox_BladderMouseClicked

    private void lblPictureBox_UrethraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPictureBox_UrethraMouseClicked
        // TODO add your handling code here:
        setBlackFontColor();
        selectedPictureBox = lblPictureBox_Urethra;
        if (selectedPictureBox.getText().equals("? ? ?")) {
            selectPictureBox();
        } else {
            returnButton();
        }
    }//GEN-LAST:event_lblPictureBox_UrethraMouseClicked
    // ========================= Code to Anser box Buttons =====================//
    private void btnAnswerBox_BladderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswerBox_BladderActionPerformed
        // TODO add your handling code here:
        selectedAnswerBox = btnAnswerBox_Bladder;
        selectedAnswerBox();
    }//GEN-LAST:event_btnAnswerBox_BladderActionPerformed

    private void btnAnswerBox_InferiorVenaCavaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswerBox_InferiorVenaCavaActionPerformed
        // TODO add your handling code here:
        selectedAnswerBox = btnAnswerBox_InferiorVenaCava;
        selectedAnswerBox();
    }//GEN-LAST:event_btnAnswerBox_InferiorVenaCavaActionPerformed

    private void btnAnswerBox_KidneysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswerBox_KidneysActionPerformed
        // TODO add your handling code here:
        selectedAnswerBox = btnAnswerBox_Kidneys;
        selectedAnswerBox();
    }//GEN-LAST:event_btnAnswerBox_KidneysActionPerformed

    private void btnAnswerBox_RenalArteryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswerBox_RenalArteryActionPerformed
        // TODO add your handling code here:
        selectedAnswerBox = btnAnswerBox_RenalArtery;
        selectedAnswerBox();
    }//GEN-LAST:event_btnAnswerBox_RenalArteryActionPerformed

    private void btnAnswerBox_RenalVeinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswerBox_RenalVeinActionPerformed
        // TODO add your handling code here:
        selectedAnswerBox = btnAnswerBox_RenalVein;
        selectedAnswerBox();
    }//GEN-LAST:event_btnAnswerBox_RenalVeinActionPerformed

    private void btnAnswerBox_SystemicArteryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswerBox_SystemicArteryActionPerformed
        // TODO add your handling code here:
        selectedAnswerBox = btnAnswerBox_SystemicArtery;
        selectedAnswerBox();
    }//GEN-LAST:event_btnAnswerBox_SystemicArteryActionPerformed

    private void btnAnswerBox_UretersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswerBox_UretersActionPerformed
        // TODO add your handling code here:
        selectedAnswerBox = btnAnswerBox_Ureters;
        selectedAnswerBox();
    }//GEN-LAST:event_btnAnswerBox_UretersActionPerformed

    private void btnAnswerBox_UrethraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswerBox_UrethraActionPerformed
        // TODO add your handling code here:
        selectedAnswerBox = btnAnswerBox_Urethra;
        selectedAnswerBox();
    }//GEN-LAST:event_btnAnswerBox_UrethraActionPerformed

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
            java.util.logging.Logger.getLogger(MapMarkingUrinarySystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MapMarkingUrinarySystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MapMarkingUrinarySystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MapMarkingUrinarySystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MapMarkingUrinarySystem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnswerBox_Bladder;
    private javax.swing.JButton btnAnswerBox_InferiorVenaCava;
    private javax.swing.JButton btnAnswerBox_Kidneys;
    private javax.swing.JButton btnAnswerBox_RenalArtery;
    private javax.swing.JButton btnAnswerBox_RenalVein;
    private javax.swing.JButton btnAnswerBox_SystemicArtery;
    private javax.swing.JButton btnAnswerBox_Ureters;
    private javax.swing.JButton btnAnswerBox_Urethra;
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
    private javax.swing.JLabel lblPictureBox_Bladder;
    private javax.swing.JLabel lblPictureBox_InferiorVenaCava;
    private javax.swing.JLabel lblPictureBox_Kidneys;
    private javax.swing.JLabel lblPictureBox_RenalArtery;
    private javax.swing.JLabel lblPictureBox_RenalVein;
    private javax.swing.JLabel lblPictureBox_SystemicArtery;
    private javax.swing.JLabel lblPictureBox_Ureters;
    private javax.swing.JLabel lblPictureBox_Urethra;
    private javax.swing.JLabel lblSidePnlDiagestiveSystemComplete;
    private javax.swing.JLabel lblSidePnlDiagestiveSystemMarks;
    private javax.swing.JLabel lblSidePnlRespiratorySystemComplete;
    private javax.swing.JLabel lblSidePnlRespiratorySystemMarks;
    private javax.swing.JLabel lblSidePnlUsername;
    private javax.swing.JLabel lblSidePnlWelcomeName;
    // End of variables declaration//GEN-END:variables
}
