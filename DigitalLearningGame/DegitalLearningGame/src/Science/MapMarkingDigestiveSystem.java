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
public class MapMarkingDigestiveSystem extends javax.swing.JFrame {

    /**
     * Creates new form MapMarkingDigestiveSystem
     */
    String RegisterId;
    int marks = 0;
    int health = 3;
    int completed = 0;
    JLabel selectedPictureBox;
    JButton selectedAnswerBox;

    public MapMarkingDigestiveSystem() {
        initComponents();
        disableAnswerBox();
        lblMessageBox.setVisible(false);
    }

    public void Setdata(String ID) {
        RegisterId = ID;

        //set user marks
        try {
            Connection con = Database.db.getConnection();
            String sql = "SELECT mapMarkingRespiratorySystem_marks,mapMarkingRespiratorySystem_completed,mapMarkingUrinarySystem_marks,mapMarkingUrinarySystem_completed FROM digital_learning_game.science where stdRegisterId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String respiratorySystemComplete = rs.getString("mapMarkingRespiratorySystem_completed");
                String respiratorySystemMarks = rs.getString("mapMarkingRespiratorySystem_marks");

                String urinarySystemComplete = rs.getString("mapMarkingUrinarySystem_completed");
                String urinarySystemMarks = rs.getString("mapMarkingUrinarySystem_marks");

                //Set data
                lblSidePnlRespiratorySystemComplete.setText("Completed : " + respiratorySystemComplete + "%");
                lblSidePnlRespiratorySystemMarks.setText("Score : " + respiratorySystemMarks);

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

    public void sendDataToDatabase() {
        try {
            // create connection to database
            Connection con = Database.db.getConnection();
            // Create prepared statement with the sql query
            PreparedStatement st1 = con.prepareStatement("UPDATE `digital_learning_game`.`science` SET `mapMarkingDignestiveSystem_marks` = '" + marks + "', `mapMarkingDignestiveSystem_completed` = '" + completed + "' WHERE (`stdRegisterId` = " + RegisterId + ");");
            // execute query
            st1.executeUpdate();

            // show success message
            //JOptionPane.showMessageDialog(this, "Successfully Inserted...");
        } catch (SQLException ex) {
            Logger.getLogger(MapMarkingDigestiveSystem.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void disableAnswerBox() {
        btnAnswerBox_Anus.setEnabled(false);
        btnAnswerBox_Appendix.setEnabled(false);
        btnAnswerBox_Liver.setEnabled(false);
        btnAnswerBox_Caecum.setEnabled(false);
        btnAnswerBox_Diaphragm.setEnabled(false);
        btnAnswerBox_Epiglottis.setEnabled(false);
        btnAnswerBox_GallBladder.setEnabled(false);
        btnAnswerBox_Pancreas.setEnabled(false);
        btnAnswerBox_BuccalCavity.setEnabled(false);
        btnAnswerBox_Oesophagus.setEnabled(false);
        btnAnswerBox_LargeIntestine.setEnabled(false);
        btnAnswerBox_Rectum.setEnabled(false);
        btnAnswerBox_SalivaryGlands.setEnabled(false);
        btnAnswerBox_SmallIntestine.setEnabled(false);
        btnAnswerBox_Stomach.setEnabled(false);
    }

    public void enableAnswerBox() {
        btnAnswerBox_Anus.setEnabled(true);
        btnAnswerBox_Appendix.setEnabled(true);
        btnAnswerBox_Liver.setEnabled(true);
        btnAnswerBox_Caecum.setEnabled(true);
        btnAnswerBox_Diaphragm.setEnabled(true);
        btnAnswerBox_Epiglottis.setEnabled(true);
        btnAnswerBox_GallBladder.setEnabled(true);
        btnAnswerBox_Pancreas.setEnabled(true);
        btnAnswerBox_BuccalCavity.setEnabled(true);
        btnAnswerBox_Oesophagus.setEnabled(true);
        btnAnswerBox_LargeIntestine.setEnabled(true);
        btnAnswerBox_Rectum.setEnabled(true);
        btnAnswerBox_SalivaryGlands.setEnabled(true);
        btnAnswerBox_SmallIntestine.setEnabled(true);
        btnAnswerBox_Stomach.setEnabled(true);

    }

    public void disbalePictureBox() {
        lblPictureBox_Anus.setEnabled(false);
        lblPictureBox_Appendix.setEnabled(false);
        lblPictureBox_Liver.setEnabled(false);
        lblPictureBox_Caecum.setEnabled(false);
        lblPictureBox_Diaphragm.setEnabled(false);
        lblPictureBox_Epiglottis.setEnabled(false);
        lblPictureBox_GallBladder.setEnabled(false);
        lblPictureBox_Pancreas.setEnabled(false);
        lblPictureBox_BuccalCavity.setEnabled(false);
        lblPictureBox_Oesophagus.setEnabled(false);
        lblPictureBox_LargeIntestine.setEnabled(false);
        lblPictureBox_Rectum.setEnabled(false);
        lblPictureBox_SalivaryGlands.setEnabled(false);
        lblPictureBox_SmallIntestine.setEnabled(false);
        lblPictureBox_Stomach.setEnabled(false);
    }

    public void enablePictureBox() {
        lblPictureBox_Anus.setEnabled(true);
        lblPictureBox_Appendix.setEnabled(true);
        lblPictureBox_Liver.setEnabled(true);
        lblPictureBox_Caecum.setEnabled(true);
        lblPictureBox_Diaphragm.setEnabled(true);
        lblPictureBox_Epiglottis.setEnabled(true);
        lblPictureBox_GallBladder.setEnabled(true);
        lblPictureBox_Pancreas.setEnabled(true);
        lblPictureBox_BuccalCavity.setEnabled(true);
        lblPictureBox_Oesophagus.setEnabled(true);
        lblPictureBox_LargeIntestine.setEnabled(true);
        lblPictureBox_Rectum.setEnabled(true);
        lblPictureBox_SalivaryGlands.setEnabled(true);
        lblPictureBox_SmallIntestine.setEnabled(true);
        lblPictureBox_Stomach.setEnabled(true);
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

        completed = completed + 6;
        lblCompletedDisplay.setText("Completed : " + completed + "%");
    }

    public void returnButton() {
        String selectedPictureBoxName = selectedPictureBox.getText();
        if (selectedPictureBoxName.equals("Anus")) {
            btnAnswerBox_Anus.setVisible(true);
        } else if (selectedPictureBoxName.equals("Appendix")) {
            btnAnswerBox_Appendix.setVisible(true);
        } else if (selectedPictureBoxName.equals("Buccal cavity")) {
            btnAnswerBox_BuccalCavity.setVisible(true);
        } else if (selectedPictureBoxName.equals("Caecum")) {
            btnAnswerBox_Caecum.setVisible(true);
        } else if (selectedPictureBoxName.equals("Diaphragm")) {
            btnAnswerBox_Diaphragm.setVisible(true);
        } else if (selectedPictureBoxName.equals("Epiglottis")) {
            btnAnswerBox_Epiglottis.setVisible(true);
        } else if (selectedPictureBoxName.equals("Gall bladder")) {
            btnAnswerBox_GallBladder.setVisible(true);
        } else if (selectedPictureBoxName.equals("Large intestine")) {
            btnAnswerBox_LargeIntestine.setVisible(true);
        } else if (selectedPictureBoxName.equals("Liver")) {
            btnAnswerBox_Liver.setVisible(true);
        } else if (selectedPictureBoxName.equals("Oesophagus")) {
            btnAnswerBox_Oesophagus.setVisible(true);
        } else if (selectedPictureBoxName.equals("Pancreas")) {
            btnAnswerBox_Pancreas.setVisible(true);
        } else if (selectedPictureBoxName.equals("Rectum")) {
            btnAnswerBox_Rectum.setVisible(true);
        } else if (selectedPictureBoxName.equals("Salivary glands")) {
            btnAnswerBox_SalivaryGlands.setVisible(true);
        } else if (selectedPictureBoxName.equals("Small intestine")) {
            btnAnswerBox_SmallIntestine.setVisible(true);
        } else if (selectedPictureBoxName.equals("Stomach")) {
            btnAnswerBox_Stomach.setVisible(true);
        }

        selectedPictureBox.setText("? ? ?");
        completed = completed - 6;
        lblCompletedDisplay.setText("Completed : " + completed + "%");
    }

    public void setBlackFontColor() {
        lblPictureBox_Anus.setForeground(Color.black);
        lblPictureBox_Appendix.setForeground(Color.black);
        lblPictureBox_Liver.setForeground(Color.black);
        lblPictureBox_Caecum.setForeground(Color.black);
        lblPictureBox_Diaphragm.setForeground(Color.black);
        lblPictureBox_Epiglottis.setForeground(Color.black);
        lblPictureBox_GallBladder.setForeground(Color.black);
        lblPictureBox_Pancreas.setForeground(Color.black);
        lblPictureBox_BuccalCavity.setForeground(Color.black);
        lblPictureBox_Oesophagus.setForeground(Color.black);
        lblPictureBox_LargeIntestine.setForeground(Color.black);
        lblPictureBox_Rectum.setForeground(Color.black);
        lblPictureBox_SalivaryGlands.setForeground(Color.black);
        lblPictureBox_SmallIntestine.setForeground(Color.black);
        lblPictureBox_Stomach.setForeground(Color.black);
    }

    public void check() {
        lblMessageBox.setForeground(new Color(204, 0, 51));
        marks = 0;
        // Anus
        if (lblPictureBox_Anus.getText().equals("Anus")) {
            marks = marks + 6;
            lblPictureBox_Anus.setForeground(Color.green);
        } else {
            lblPictureBox_Anus.setForeground(Color.red);
        }

        // Appendix
        if (lblPictureBox_Appendix.getText().equals("Appendix")) {
            marks = marks + 6;
            lblPictureBox_Appendix.setForeground(Color.green);
        } else {
            lblPictureBox_Appendix.setForeground(Color.red);
        }

        // Buccal cavity
        if (lblPictureBox_BuccalCavity.getText().equals("Buccal cavity")) {
            marks = marks + 6;
            lblPictureBox_BuccalCavity.setForeground(Color.green);
        } else {
            lblPictureBox_BuccalCavity.setForeground(Color.red);
        }

        // Caecum
        if (lblPictureBox_Caecum.getText().equals("Caecum")) {
            marks = marks + 6;
            lblPictureBox_Caecum.setForeground(Color.green);
        } else {
            lblPictureBox_Caecum.setForeground(Color.red);
        }

        // Diaphragm
        if (lblPictureBox_Diaphragm.getText().equals("Diaphragm")) {
            marks = marks + 6;
            lblPictureBox_Diaphragm.setForeground(Color.green);
        } else {
            lblPictureBox_Diaphragm.setForeground(Color.red);
        }

        // Epiglottis
        if (lblPictureBox_Epiglottis.getText().equals("Epiglottis")) {
            marks = marks + 6;
            lblPictureBox_Epiglottis.setForeground(Color.green);
        } else {
            lblPictureBox_Epiglottis.setForeground(Color.red);
        }

        // Gall bladder
        if (lblPictureBox_GallBladder.getText().equals("Gall bladder")) {
            marks = marks + 6;
            lblPictureBox_GallBladder.setForeground(Color.green);
        } else {
            lblPictureBox_GallBladder.setForeground(Color.red);
        }

        // Large intestine
        if (lblPictureBox_LargeIntestine.getText().equals("Large intestine")) {
            marks = marks + 6;
            lblPictureBox_LargeIntestine.setForeground(Color.green);
        } else {
            lblPictureBox_LargeIntestine.setForeground(Color.red);
        }

        // Liver
        if (lblPictureBox_Liver.getText().equals("Liver")) {
            marks = marks + 6;
            lblPictureBox_Liver.setForeground(Color.green);
        } else {
            lblPictureBox_Liver.setForeground(Color.red);
        }

        // Oesophagus
        if (lblPictureBox_Oesophagus.getText().equals("Oesophagus")) {
            marks = marks + 6;
            lblPictureBox_Oesophagus.setForeground(Color.green);
        } else {
            lblPictureBox_Oesophagus.setForeground(Color.red);
        }

        // Pancreas
        if (lblPictureBox_Pancreas.getText().equals("Pancreas")) {
            marks = marks + 6;
            lblPictureBox_Pancreas.setForeground(Color.green);
        } else {
            lblPictureBox_Pancreas.setForeground(Color.red);
        }

        // Rectum
        if (lblPictureBox_Rectum.getText().equals("Rectum")) {
            marks = marks + 6;
            lblPictureBox_Rectum.setForeground(Color.green);
        } else {
            lblPictureBox_Rectum.setForeground(Color.red);
        }

        // Salivary glands
        if (lblPictureBox_SalivaryGlands.getText().equals("Salivary glands")) {
            marks = marks + 6;
            lblPictureBox_SalivaryGlands.setForeground(Color.green);
        } else {
            lblPictureBox_SalivaryGlands.setForeground(Color.red);
        }

        // Small intestine
        if (lblPictureBox_SmallIntestine.getText().equals("Small intestine")) {
            marks = marks + 6;
            lblPictureBox_SmallIntestine.setForeground(Color.green);
        } else {
            lblPictureBox_SmallIntestine.setForeground(Color.red);
        }

        // Stomach
        if (lblPictureBox_Stomach.getText().equals("Stomach")) {
            marks = marks + 6;
            lblPictureBox_Stomach.setForeground(Color.green);
        } else {
            lblPictureBox_Stomach.setForeground(Color.red);
        }

        marksSet();
        sendDataToDatabase();
    }

    public void marksSet() {
        if (marks >= 90) {
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

        lblPictureBox_Anus.setText("? ? ?");
        lblPictureBox_Appendix.setText("? ? ?");
        lblPictureBox_Liver.setText("? ? ?");
        lblPictureBox_Caecum.setText("? ? ?");
        lblPictureBox_Diaphragm.setText("? ? ?");
        lblPictureBox_Epiglottis.setText("? ? ?");
        lblPictureBox_GallBladder.setText("? ? ?");
        lblPictureBox_Pancreas.setText("? ? ?");
        lblPictureBox_BuccalCavity.setText("? ? ?");
        lblPictureBox_Oesophagus.setText("? ? ?");
        lblPictureBox_LargeIntestine.setText("? ? ?");
        lblPictureBox_Rectum.setText("? ? ?");
        lblPictureBox_SalivaryGlands.setText("? ? ?");
        lblPictureBox_SmallIntestine.setText("? ? ?");
        lblPictureBox_Stomach.setText("? ? ?");

        btnAnswerBox_Anus.setVisible(true);
        btnAnswerBox_Appendix.setVisible(true);
        btnAnswerBox_Liver.setVisible(true);
        btnAnswerBox_Caecum.setVisible(true);
        btnAnswerBox_Diaphragm.setVisible(true);
        btnAnswerBox_Epiglottis.setVisible(true);
        btnAnswerBox_GallBladder.setVisible(true);
        btnAnswerBox_Pancreas.setVisible(true);
        btnAnswerBox_BuccalCavity.setVisible(true);
        btnAnswerBox_Oesophagus.setVisible(true);
        btnAnswerBox_LargeIntestine.setVisible(true);
        btnAnswerBox_Rectum.setVisible(true);
        btnAnswerBox_SalivaryGlands.setVisible(true);
        btnAnswerBox_SmallIntestine.setVisible(true);
        btnAnswerBox_Stomach.setVisible(true);

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
        btnAnswerBox_Anus = new javax.swing.JButton();
        btnAnswerBox_Appendix = new javax.swing.JButton();
        btnAnswerBox_Liver = new javax.swing.JButton();
        btnAnswerBox_Caecum = new javax.swing.JButton();
        btnAnswerBox_Diaphragm = new javax.swing.JButton();
        btnAnswerBox_Epiglottis = new javax.swing.JButton();
        btnAnswerBox_GallBladder = new javax.swing.JButton();
        btnAnswerBox_Pancreas = new javax.swing.JButton();
        btnAnswerBox_BuccalCavity = new javax.swing.JButton();
        btnAnswerBox_Oesophagus = new javax.swing.JButton();
        btnAnswerBox_LargeIntestine = new javax.swing.JButton();
        btnAnswerBox_Rectum = new javax.swing.JButton();
        btnAnswerBox_SalivaryGlands = new javax.swing.JButton();
        btnAnswerBox_SmallIntestine = new javax.swing.JButton();
        btnAnswerBox_Stomach = new javax.swing.JButton();
        lblCompletedDisplay = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        btnCheck = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        lblMessageBox = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lblPictureBox_Anus = new javax.swing.JLabel();
        lblPictureBox_BuccalCavity = new javax.swing.JLabel();
        lblPictureBox_Liver = new javax.swing.JLabel();
        lblPictureBox_GallBladder = new javax.swing.JLabel();
        lblPictureBox_LargeIntestine = new javax.swing.JLabel();
        lblPictureBox_Caecum = new javax.swing.JLabel();
        lblPictureBox_Appendix = new javax.swing.JLabel();
        lblPictureBox_SalivaryGlands = new javax.swing.JLabel();
        lblPictureBox_Epiglottis = new javax.swing.JLabel();
        lblPictureBox_Oesophagus = new javax.swing.JLabel();
        lblPictureBox_Diaphragm = new javax.swing.JLabel();
        lblPictureBox_Stomach = new javax.swing.JLabel();
        lblPictureBox_Pancreas = new javax.swing.JLabel();
        lblPictureBox_SmallIntestine = new javax.swing.JLabel();
        lblPictureBox_Rectum = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        lblSidePnlRespiratorySystemComplete = new javax.swing.JLabel();
        lblSidePnlRespiratorySystemMarks = new javax.swing.JLabel();
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
        jLabel2.setText("Digestive  System");

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

        btnAnswerBox_Anus.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnAnswerBox_Anus.setText("Anus");
        btnAnswerBox_Anus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswerBox_AnusActionPerformed(evt);
            }
        });

        btnAnswerBox_Appendix.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnAnswerBox_Appendix.setText("Appendix");
        btnAnswerBox_Appendix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswerBox_AppendixActionPerformed(evt);
            }
        });

        btnAnswerBox_Liver.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnAnswerBox_Liver.setText("Liver");
        btnAnswerBox_Liver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswerBox_LiverActionPerformed(evt);
            }
        });

        btnAnswerBox_Caecum.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnAnswerBox_Caecum.setText("Caecum");
        btnAnswerBox_Caecum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswerBox_CaecumActionPerformed(evt);
            }
        });

        btnAnswerBox_Diaphragm.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnAnswerBox_Diaphragm.setText("Diaphragm");
        btnAnswerBox_Diaphragm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswerBox_DiaphragmActionPerformed(evt);
            }
        });

        btnAnswerBox_Epiglottis.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnAnswerBox_Epiglottis.setText("Epiglottis");
        btnAnswerBox_Epiglottis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswerBox_EpiglottisActionPerformed(evt);
            }
        });

        btnAnswerBox_GallBladder.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnAnswerBox_GallBladder.setText("Gall bladder");
        btnAnswerBox_GallBladder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswerBox_GallBladderActionPerformed(evt);
            }
        });

        btnAnswerBox_Pancreas.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnAnswerBox_Pancreas.setText("Pancreas");
        btnAnswerBox_Pancreas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswerBox_PancreasActionPerformed(evt);
            }
        });

        btnAnswerBox_BuccalCavity.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnAnswerBox_BuccalCavity.setText("Buccal cavity");
        btnAnswerBox_BuccalCavity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswerBox_BuccalCavityActionPerformed(evt);
            }
        });

        btnAnswerBox_Oesophagus.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnAnswerBox_Oesophagus.setText("Oesophagus");
        btnAnswerBox_Oesophagus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswerBox_OesophagusActionPerformed(evt);
            }
        });

        btnAnswerBox_LargeIntestine.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnAnswerBox_LargeIntestine.setText("Large intestine");
        btnAnswerBox_LargeIntestine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswerBox_LargeIntestineActionPerformed(evt);
            }
        });

        btnAnswerBox_Rectum.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnAnswerBox_Rectum.setText("Rectum");
        btnAnswerBox_Rectum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswerBox_RectumActionPerformed(evt);
            }
        });

        btnAnswerBox_SalivaryGlands.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnAnswerBox_SalivaryGlands.setText("Salivary glands");
        btnAnswerBox_SalivaryGlands.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswerBox_SalivaryGlandsActionPerformed(evt);
            }
        });

        btnAnswerBox_SmallIntestine.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnAnswerBox_SmallIntestine.setText("Small intestine");
        btnAnswerBox_SmallIntestine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswerBox_SmallIntestineActionPerformed(evt);
            }
        });

        btnAnswerBox_Stomach.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnAnswerBox_Stomach.setText("Stomach");
        btnAnswerBox_Stomach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswerBox_StomachActionPerformed(evt);
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
                        .addComponent(btnAnswerBox_Anus, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAnswerBox_Appendix, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(btnAnswerBox_Liver, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAnswerBox_Caecum, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(btnAnswerBox_Diaphragm, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAnswerBox_Epiglottis, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(btnAnswerBox_GallBladder, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAnswerBox_Pancreas, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(btnAnswerBox_BuccalCavity, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAnswerBox_Oesophagus, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(btnAnswerBox_LargeIntestine, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAnswerBox_Rectum, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(btnAnswerBox_SalivaryGlands, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAnswerBox_SmallIntestine, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAnswerBox_Stomach, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAnswerBox_Anus)
                    .addComponent(btnAnswerBox_Appendix))
                .addGap(11, 11, 11)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAnswerBox_Liver)
                    .addComponent(btnAnswerBox_Caecum))
                .addGap(11, 11, 11)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAnswerBox_Diaphragm)
                    .addComponent(btnAnswerBox_Epiglottis))
                .addGap(11, 11, 11)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAnswerBox_GallBladder)
                    .addComponent(btnAnswerBox_Pancreas))
                .addGap(11, 11, 11)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAnswerBox_BuccalCavity)
                    .addComponent(btnAnswerBox_Oesophagus))
                .addGap(11, 11, 11)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAnswerBox_LargeIntestine)
                    .addComponent(btnAnswerBox_Rectum))
                .addGap(11, 11, 11)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAnswerBox_SalivaryGlands)
                    .addComponent(btnAnswerBox_SmallIntestine))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAnswerBox_Stomach)
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
                    .addComponent(btnCheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCompletedDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMessageBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Picture Box");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPictureBox_Anus.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPictureBox_Anus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPictureBox_Anus.setText("? ? ?");
        lblPictureBox_Anus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPictureBox_AnusMouseClicked(evt);
            }
        });
        jPanel6.add(lblPictureBox_Anus, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 440, 150, -1));

        lblPictureBox_BuccalCavity.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPictureBox_BuccalCavity.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPictureBox_BuccalCavity.setText("? ? ?");
        lblPictureBox_BuccalCavity.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPictureBox_BuccalCavityMouseClicked(evt);
            }
        });
        jPanel6.add(lblPictureBox_BuccalCavity, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 150, -1));

        lblPictureBox_Liver.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPictureBox_Liver.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPictureBox_Liver.setText("? ? ?");
        lblPictureBox_Liver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPictureBox_LiverMouseClicked(evt);
            }
        });
        jPanel6.add(lblPictureBox_Liver, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 150, -1));

        lblPictureBox_GallBladder.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPictureBox_GallBladder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPictureBox_GallBladder.setText("? ? ?");
        lblPictureBox_GallBladder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPictureBox_GallBladderMouseClicked(evt);
            }
        });
        jPanel6.add(lblPictureBox_GallBladder, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 150, -1));

        lblPictureBox_LargeIntestine.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPictureBox_LargeIntestine.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPictureBox_LargeIntestine.setText("? ? ?");
        lblPictureBox_LargeIntestine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPictureBox_LargeIntestineMouseClicked(evt);
            }
        });
        jPanel6.add(lblPictureBox_LargeIntestine, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 150, -1));

        lblPictureBox_Caecum.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPictureBox_Caecum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPictureBox_Caecum.setText("? ? ?");
        lblPictureBox_Caecum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPictureBox_CaecumMouseClicked(evt);
            }
        });
        jPanel6.add(lblPictureBox_Caecum, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 150, -1));

        lblPictureBox_Appendix.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPictureBox_Appendix.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPictureBox_Appendix.setText("? ? ?");
        lblPictureBox_Appendix.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPictureBox_AppendixMouseClicked(evt);
            }
        });
        jPanel6.add(lblPictureBox_Appendix, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 150, -1));

        lblPictureBox_SalivaryGlands.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPictureBox_SalivaryGlands.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPictureBox_SalivaryGlands.setText("? ? ?");
        lblPictureBox_SalivaryGlands.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPictureBox_SalivaryGlandsMouseClicked(evt);
            }
        });
        jPanel6.add(lblPictureBox_SalivaryGlands, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 150, -1));

        lblPictureBox_Epiglottis.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPictureBox_Epiglottis.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPictureBox_Epiglottis.setText("? ? ?");
        lblPictureBox_Epiglottis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPictureBox_EpiglottisMouseClicked(evt);
            }
        });
        jPanel6.add(lblPictureBox_Epiglottis, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, 150, -1));

        lblPictureBox_Oesophagus.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPictureBox_Oesophagus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPictureBox_Oesophagus.setText("? ? ?");
        lblPictureBox_Oesophagus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPictureBox_OesophagusMouseClicked(evt);
            }
        });
        jPanel6.add(lblPictureBox_Oesophagus, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, 150, -1));

        lblPictureBox_Diaphragm.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPictureBox_Diaphragm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPictureBox_Diaphragm.setText("? ? ?");
        lblPictureBox_Diaphragm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPictureBox_DiaphragmMouseClicked(evt);
            }
        });
        jPanel6.add(lblPictureBox_Diaphragm, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 150, -1));

        lblPictureBox_Stomach.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPictureBox_Stomach.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPictureBox_Stomach.setText("? ? ?");
        lblPictureBox_Stomach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPictureBox_StomachMouseClicked(evt);
            }
        });
        jPanel6.add(lblPictureBox_Stomach, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, 150, -1));

        lblPictureBox_Pancreas.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPictureBox_Pancreas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPictureBox_Pancreas.setText("? ? ?");
        lblPictureBox_Pancreas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPictureBox_PancreasMouseClicked(evt);
            }
        });
        jPanel6.add(lblPictureBox_Pancreas, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, 150, -1));

        lblPictureBox_SmallIntestine.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPictureBox_SmallIntestine.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPictureBox_SmallIntestine.setText("? ? ?");
        lblPictureBox_SmallIntestine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPictureBox_SmallIntestineMouseClicked(evt);
            }
        });
        jPanel6.add(lblPictureBox_SmallIntestine, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 370, 150, -1));

        lblPictureBox_Rectum.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPictureBox_Rectum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPictureBox_Rectum.setText("? ? ?");
        lblPictureBox_Rectum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPictureBox_RectumMouseClicked(evt);
            }
        });
        jPanel6.add(lblPictureBox_Rectum, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 410, 150, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MapMarking_DigestiveSystem.png"))); // NOI18N
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
                .addContainerGap(20, Short.MAX_VALUE))
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
        jLabel9.setText("Respiratory System");

        lblSidePnlRespiratorySystemComplete.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblSidePnlRespiratorySystemComplete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSidePnlRespiratorySystemComplete.setText("Completed : 0%");

        lblSidePnlRespiratorySystemMarks.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSidePnlRespiratorySystemMarks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSidePnlRespiratorySystemMarks.setText("Score : 00");

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
                    .addComponent(lblSidePnlRespiratorySystemComplete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSidePnlRespiratorySystemMarks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(lblSidePnlRespiratorySystemComplete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSidePnlRespiratorySystemMarks)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

    private void lblPictureBox_LiverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPictureBox_LiverMouseClicked
        // TODO add your handling code here:
        setBlackFontColor();
        selectedPictureBox = lblPictureBox_Liver;
        if (selectedPictureBox.getText().equals("? ? ?")) {
            selectPictureBox();
        } else {
            returnButton();
        }
    }//GEN-LAST:event_lblPictureBox_LiverMouseClicked

    private void lblPictureBox_GallBladderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPictureBox_GallBladderMouseClicked
        // TODO add your handling code here:
        setBlackFontColor();
        selectedPictureBox = lblPictureBox_GallBladder;
        if (selectedPictureBox.getText().equals("? ? ?")) {
            selectPictureBox();
        } else {
            returnButton();
        }
    }//GEN-LAST:event_lblPictureBox_GallBladderMouseClicked

    private void lblPictureBox_LargeIntestineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPictureBox_LargeIntestineMouseClicked
        // TODO add your handling code here:
        setBlackFontColor();
        selectedPictureBox = lblPictureBox_LargeIntestine;
        if (selectedPictureBox.getText().equals("? ? ?")) {
            selectPictureBox();
        } else {
            returnButton();
        }
    }//GEN-LAST:event_lblPictureBox_LargeIntestineMouseClicked

    private void lblPictureBox_CaecumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPictureBox_CaecumMouseClicked
        // TODO add your handling code here:
        setBlackFontColor();
        selectedPictureBox = lblPictureBox_Caecum;
        if (selectedPictureBox.getText().equals("? ? ?")) {
            selectPictureBox();
        } else {
            returnButton();
        }
    }//GEN-LAST:event_lblPictureBox_CaecumMouseClicked

    private void lblPictureBox_AppendixMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPictureBox_AppendixMouseClicked
        // TODO add your handling code here:
        setBlackFontColor();
        selectedPictureBox = lblPictureBox_Appendix;
        if (selectedPictureBox.getText().equals("? ? ?")) {
            selectPictureBox();
        } else {
            returnButton();
        }
    }//GEN-LAST:event_lblPictureBox_AppendixMouseClicked

    private void lblPictureBox_SalivaryGlandsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPictureBox_SalivaryGlandsMouseClicked
        // TODO add your handling code here:
        setBlackFontColor();
        selectedPictureBox = lblPictureBox_SalivaryGlands;
        if (selectedPictureBox.getText().equals("? ? ?")) {
            selectPictureBox();
        } else {
            returnButton();
        }
    }//GEN-LAST:event_lblPictureBox_SalivaryGlandsMouseClicked

    private void lblPictureBox_EpiglottisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPictureBox_EpiglottisMouseClicked
        // TODO add your handling code here:
        setBlackFontColor();
        selectedPictureBox = lblPictureBox_Epiglottis;
        if (selectedPictureBox.getText().equals("? ? ?")) {
            selectPictureBox();
        } else {
            returnButton();
        }
    }//GEN-LAST:event_lblPictureBox_EpiglottisMouseClicked

    private void lblPictureBox_OesophagusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPictureBox_OesophagusMouseClicked
        // TODO add your handling code here:
        setBlackFontColor();
        selectedPictureBox = lblPictureBox_Oesophagus;
        if (selectedPictureBox.getText().equals("? ? ?")) {
            selectPictureBox();
        } else {
            returnButton();
        }
    }//GEN-LAST:event_lblPictureBox_OesophagusMouseClicked

    private void lblPictureBox_StomachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPictureBox_StomachMouseClicked
        // TODO add your handling code here:
        setBlackFontColor();
        selectedPictureBox = lblPictureBox_Stomach;
        if (selectedPictureBox.getText().equals("? ? ?")) {
            selectPictureBox();
        } else {
            returnButton();
        }
    }//GEN-LAST:event_lblPictureBox_StomachMouseClicked

    private void lblPictureBox_PancreasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPictureBox_PancreasMouseClicked
        // TODO add your handling code here:
        setBlackFontColor();
        selectedPictureBox = lblPictureBox_Pancreas;
        if (selectedPictureBox.getText().equals("? ? ?")) {
            selectPictureBox();
        } else {
            returnButton();
        }
    }//GEN-LAST:event_lblPictureBox_PancreasMouseClicked

    private void lblPictureBox_SmallIntestineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPictureBox_SmallIntestineMouseClicked
        // TODO add your handling code here:
        setBlackFontColor();
        selectedPictureBox = lblPictureBox_SmallIntestine;
        if (selectedPictureBox.getText().equals("? ? ?")) {
            selectPictureBox();
        } else {
            returnButton();
        }
    }//GEN-LAST:event_lblPictureBox_SmallIntestineMouseClicked

    private void lblPictureBox_RectumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPictureBox_RectumMouseClicked
        // TODO add your handling code here:
        setBlackFontColor();
        selectedPictureBox = lblPictureBox_Rectum;
        if (selectedPictureBox.getText().equals("? ? ?")) {
            selectPictureBox();
        } else {
            returnButton();
        }
    }//GEN-LAST:event_lblPictureBox_RectumMouseClicked

    private void lblPictureBox_AnusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPictureBox_AnusMouseClicked
        // TODO add your handling code here:
        setBlackFontColor();
        selectedPictureBox = lblPictureBox_Anus;
        if (selectedPictureBox.getText().equals("? ? ?")) {
            selectPictureBox();
        } else {
            returnButton();
        }
    }//GEN-LAST:event_lblPictureBox_AnusMouseClicked

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
    private void btnAnswerBox_AnusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswerBox_AnusActionPerformed
        // TODO add your handling code here:
        selectedAnswerBox = btnAnswerBox_Anus;
        selectedAnswerBox();
    }//GEN-LAST:event_btnAnswerBox_AnusActionPerformed

    private void btnAnswerBox_AppendixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswerBox_AppendixActionPerformed
        // TODO add your handling code here:
        selectedAnswerBox = btnAnswerBox_Appendix;
        selectedAnswerBox();
    }//GEN-LAST:event_btnAnswerBox_AppendixActionPerformed

    private void btnAnswerBox_LiverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswerBox_LiverActionPerformed
        // TODO add your handling code here:
        selectedAnswerBox = btnAnswerBox_Liver;
        selectedAnswerBox();
    }//GEN-LAST:event_btnAnswerBox_LiverActionPerformed

    private void btnAnswerBox_CaecumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswerBox_CaecumActionPerformed
        // TODO add your handling code here:
        selectedAnswerBox = btnAnswerBox_Caecum;
        selectedAnswerBox();
    }//GEN-LAST:event_btnAnswerBox_CaecumActionPerformed

    private void btnAnswerBox_DiaphragmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswerBox_DiaphragmActionPerformed
        // TODO add your handling code here:
        selectedAnswerBox = btnAnswerBox_Diaphragm;
        selectedAnswerBox();
    }//GEN-LAST:event_btnAnswerBox_DiaphragmActionPerformed

    private void btnAnswerBox_EpiglottisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswerBox_EpiglottisActionPerformed
        // TODO add your handling code here:
        selectedAnswerBox = btnAnswerBox_Epiglottis;
        selectedAnswerBox();
    }//GEN-LAST:event_btnAnswerBox_EpiglottisActionPerformed

    private void btnAnswerBox_GallBladderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswerBox_GallBladderActionPerformed
        // TODO add your handling code here:
        selectedAnswerBox = btnAnswerBox_GallBladder;
        selectedAnswerBox();
    }//GEN-LAST:event_btnAnswerBox_GallBladderActionPerformed

    private void btnAnswerBox_PancreasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswerBox_PancreasActionPerformed
        // TODO add your handling code here:
        selectedAnswerBox = btnAnswerBox_Pancreas;
        selectedAnswerBox();
    }//GEN-LAST:event_btnAnswerBox_PancreasActionPerformed

    private void btnAnswerBox_BuccalCavityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswerBox_BuccalCavityActionPerformed
        // TODO add your handling code here:
        selectedAnswerBox = btnAnswerBox_BuccalCavity;
        selectedAnswerBox();
    }//GEN-LAST:event_btnAnswerBox_BuccalCavityActionPerformed

    private void btnAnswerBox_OesophagusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswerBox_OesophagusActionPerformed
        // TODO add your handling code here:
        selectedAnswerBox = btnAnswerBox_Oesophagus;
        selectedAnswerBox();
    }//GEN-LAST:event_btnAnswerBox_OesophagusActionPerformed

    private void btnAnswerBox_LargeIntestineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswerBox_LargeIntestineActionPerformed
        // TODO add your handling code here:
        selectedAnswerBox = btnAnswerBox_LargeIntestine;
        selectedAnswerBox();
    }//GEN-LAST:event_btnAnswerBox_LargeIntestineActionPerformed

    private void btnAnswerBox_RectumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswerBox_RectumActionPerformed
        // TODO add your handling code here:
        selectedAnswerBox = btnAnswerBox_Rectum;
        selectedAnswerBox();
    }//GEN-LAST:event_btnAnswerBox_RectumActionPerformed

    private void btnAnswerBox_SalivaryGlandsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswerBox_SalivaryGlandsActionPerformed
        // TODO add your handling code here:
        selectedAnswerBox = btnAnswerBox_SalivaryGlands;
        selectedAnswerBox();
    }//GEN-LAST:event_btnAnswerBox_SalivaryGlandsActionPerformed

    private void btnAnswerBox_SmallIntestineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswerBox_SmallIntestineActionPerformed
        // TODO add your handling code here:
        selectedAnswerBox = btnAnswerBox_SmallIntestine;
        selectedAnswerBox();
    }//GEN-LAST:event_btnAnswerBox_SmallIntestineActionPerformed

    private void btnAnswerBox_StomachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswerBox_StomachActionPerformed
        // TODO add your handling code here:
        selectedAnswerBox = btnAnswerBox_Stomach;
        selectedAnswerBox();
    }//GEN-LAST:event_btnAnswerBox_StomachActionPerformed

    // Button
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
            java.util.logging.Logger.getLogger(MapMarkingDigestiveSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MapMarkingDigestiveSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MapMarkingDigestiveSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MapMarkingDigestiveSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MapMarkingDigestiveSystem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnswerBox_Anus;
    private javax.swing.JButton btnAnswerBox_Appendix;
    private javax.swing.JButton btnAnswerBox_BuccalCavity;
    private javax.swing.JButton btnAnswerBox_Caecum;
    private javax.swing.JButton btnAnswerBox_Diaphragm;
    private javax.swing.JButton btnAnswerBox_Epiglottis;
    private javax.swing.JButton btnAnswerBox_GallBladder;
    private javax.swing.JButton btnAnswerBox_LargeIntestine;
    private javax.swing.JButton btnAnswerBox_Liver;
    private javax.swing.JButton btnAnswerBox_Oesophagus;
    private javax.swing.JButton btnAnswerBox_Pancreas;
    private javax.swing.JButton btnAnswerBox_Rectum;
    private javax.swing.JButton btnAnswerBox_SalivaryGlands;
    private javax.swing.JButton btnAnswerBox_SmallIntestine;
    private javax.swing.JButton btnAnswerBox_Stomach;
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
    private javax.swing.JLabel lblPictureBox_Anus;
    private javax.swing.JLabel lblPictureBox_Appendix;
    private javax.swing.JLabel lblPictureBox_BuccalCavity;
    private javax.swing.JLabel lblPictureBox_Caecum;
    private javax.swing.JLabel lblPictureBox_Diaphragm;
    private javax.swing.JLabel lblPictureBox_Epiglottis;
    private javax.swing.JLabel lblPictureBox_GallBladder;
    private javax.swing.JLabel lblPictureBox_LargeIntestine;
    private javax.swing.JLabel lblPictureBox_Liver;
    private javax.swing.JLabel lblPictureBox_Oesophagus;
    private javax.swing.JLabel lblPictureBox_Pancreas;
    private javax.swing.JLabel lblPictureBox_Rectum;
    private javax.swing.JLabel lblPictureBox_SalivaryGlands;
    private javax.swing.JLabel lblPictureBox_SmallIntestine;
    private javax.swing.JLabel lblPictureBox_Stomach;
    private javax.swing.JLabel lblSidePnlRespiratorySystemComplete;
    private javax.swing.JLabel lblSidePnlRespiratorySystemMarks;
    private javax.swing.JLabel lblSidePnlUrinarySystemComplete;
    private javax.swing.JLabel lblSidePnlUrinarySystemMarks;
    private javax.swing.JLabel lblSidePnlUsername;
    private javax.swing.JLabel lblSidePnlWelcomeName;
    // End of variables declaration//GEN-END:variables
}
