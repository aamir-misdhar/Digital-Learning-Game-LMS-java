/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ICT;

import Science.ElectronicConfigurationLevel1;
import Science.MapMarkingDigestiveSystem;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author mmaam
 */
public class BasicLogicGates extends javax.swing.JFrame {

    /**
     * Creates new form BasicLogicGates
     */
    String RegisterId = "";
    JLabel selectedLabel;

    int question = 1;
    int marks = 0;
    int fMarks = 0;
    int complete = 0;
    int fComplete = 0;
    int health = 3;

    public BasicLogicGates() {
        initComponents();
        btnNext.setEnabled(false);
        //btnCheck.setEnabled(false);
        btn0.setEnabled(false);
        btn1.setEnabled(false);
        lblErrorMessage.setVisible(false);
        btnReset.setVisible(false);
    }

    public void Setdata(String ID) {
        RegisterId = ID;

        //set user marks
        try {
            Connection con = Database.db.getConnection();
            String sql = "SELECT advanceLogicGates_BooleanMap_marks,advanceLogicGates_BooleanMap_complete FROM digital_learning_game.ict where stdRegisterId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String advanceLogicGates_BooleanMapComplete = rs.getString("advanceLogicGates_BooleanMap_complete");
                String advanceLogicGates_BooleanMapMarks = rs.getString("advanceLogicGates_BooleanMap_marks");

                //Set data
                lblSidePnlAdvanceLogicGateComplete.setText("Completed : " + advanceLogicGates_BooleanMapComplete + "%");
                lblSidePnlAdvanceLogicGateMarks.setText("Score : " + advanceLogicGates_BooleanMapMarks);

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
                lblSidePnlWelcomeName.setText("HI, " + fName + " " + lName);
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
            String sql = "UPDATE `digital_learning_game`.`ict` SET `basicLogicGates_marks` = '" + fMarks + "', `basicLogicGates_complete` = '" + fComplete + "' WHERE (`stdRegisterId` = '" + RegisterId + "');";
            PreparedStatement st1 = con.prepareStatement(sql);
            // execute query
            st1.executeUpdate();

            // show success message
            //JOptionPane.showMessageDialog(this, "Successfully Inserted...");
        } catch (SQLException ex) {
            Logger.getLogger(BasicLogicGates.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void setDefaultColor() {
        if (lblTruthTbl_1_1.getText().equals("?")) {
            lblTruthTbl_1_1.setForeground(new Color(153, 153, 153));
        }
        if (lblTruthTbl_1_2.getText().equals("?")) {
            lblTruthTbl_1_2.setForeground(new Color(153, 153, 153));
        }
        if (lblTruthTbl_1_3.getText().equals("?")) {
            lblTruthTbl_1_3.setForeground(new Color(153, 153, 153));
        }
        if (lblTruthTbl_1_4.getText().equals("?")) {
            lblTruthTbl_1_4.setForeground(new Color(153, 153, 153));
        }
        if (lblTruthTbl_2_1.getText().equals("?")) {
            lblTruthTbl_2_1.setForeground(new Color(153, 153, 153));
        }
        if (lblTruthTbl_2_2.getText().equals("?")) {
            lblTruthTbl_2_2.setForeground(new Color(153, 153, 153));
        }
        if (lblTruthTbl_2_3.getText().equals("?")) {
            lblTruthTbl_2_3.setForeground(new Color(153, 153, 153));
        }
        if (lblTruthTbl_2_4.getText().equals("?")) {
            lblTruthTbl_2_4.setForeground(new Color(153, 153, 153));
        }
        if (lblTruthTbl_3_1.getText().equals("?")) {
            lblTruthTbl_3_1.setForeground(new Color(153, 153, 153));
        }
        if (lblTruthTbl_3_2.getText().equals("?")) {
            lblTruthTbl_3_2.setForeground(new Color(153, 153, 153));
        }
        if (lblTruthTbl_3_3.getText().equals("?")) {
            lblTruthTbl_3_3.setForeground(new Color(153, 153, 153));
        }
        if (lblTruthTbl_3_4.getText().equals("?")) {
            lblTruthTbl_3_4.setForeground(new Color(153, 153, 153));
        }
    }

    public void selectLabal() {
        if (selectedLabel.getText().equals("?")) {
            selectedLabel.setForeground(Color.black);
            btn0.setEnabled(true);
            btn1.setEnabled(true);
        } else {

            selectedLabel.setText("?");
            setDefaultColor();
            complete = complete - 7;
            fComplete = complete / 2;
            lblComplete.setText("Complete : " + fComplete + "%");
        }

    }

    public void selectButton() {
        complete = complete + 7;
        if (complete >= 192) {
            complete = 200;
        }
        fComplete = complete / 2;
        lblComplete.setText("Complete : " + fComplete + "%");
    }

    public void clearTruthTable() {
        lblTruthTbl_1_1.setText("?");
        lblTruthTbl_1_2.setText("?");
        lblTruthTbl_1_3.setText("?");
        lblTruthTbl_1_4.setText("?");

        lblTruthTbl_2_1.setText("?");
        lblTruthTbl_2_2.setText("?");
        lblTruthTbl_2_3.setText("?");
        lblTruthTbl_2_4.setText("?");

        lblTruthTbl_3_1.setText("?");
        lblTruthTbl_3_2.setText("?");
        lblTruthTbl_3_3.setText("?");
        lblTruthTbl_3_4.setText("?");

    }

    public void questionChange() {
        if (question == 1) {
            btn0.setEnabled(false);
            btn1.setEnabled(false);
            lblErrorMessage.setVisible(false);

            //question item
            lblGateType.setText("AND");

            ImageIcon icon = new ImageIcon(ElectronicConfigurationLevel1.class.getResource("/Images/AndGate.png"));
            lblPictureBoxGate.setIcon(icon);

            ImageIcon icon1 = new ImageIcon(ElectronicConfigurationLevel1.class.getResource("/Images/TruthTableForAndOrGate.png"));
            lblPictureBoxTruthTable.setIcon(icon1);

            clearTruthTable();
            setDefaultColor();
        }

        if (question == 2) {
            btn0.setEnabled(false);
            btn1.setEnabled(false);
            lblErrorMessage.setVisible(false);

            //question item
            lblGateType.setText("OR");

            ImageIcon icon = new ImageIcon(ElectronicConfigurationLevel1.class.getResource("/Images/OrGate.png"));
            lblPictureBoxGate.setIcon(icon);

            clearTruthTable();
            setDefaultColor();
        } else if (question == 3) {
            btn0.setEnabled(false);
            btn1.setEnabled(false);
            lblErrorMessage.setVisible(false);

            //question item
            lblGateType.setText("NOT");

            ImageIcon icon = new ImageIcon(ElectronicConfigurationLevel1.class.getResource("/Images/NotGate.png"));
            lblPictureBoxGate.setIcon(icon);

            ImageIcon icon1 = new ImageIcon(ElectronicConfigurationLevel1.class.getResource("/Images/TruthTableForNotGate.png"));
            lblPictureBoxTruthTable.setIcon(icon1);

            lblTruthTbl_1_3.setVisible(false);
            lblTruthTbl_1_4.setVisible(false);

            lblTruthTbl_2_3.setVisible(false);
            lblTruthTbl_2_4.setVisible(false);

            lblTruthTbl_3_1.setVisible(false);
            lblTruthTbl_3_2.setVisible(false);
            lblTruthTbl_3_3.setVisible(false);
            lblTruthTbl_3_4.setVisible(false);

            clearTruthTable();
            setDefaultColor();
        } else if (question > 3) {
            btnNext.setEnabled(false);
            btnCheck.setEnabled(false);

            lblErrorMessage.setVisible(true);
            lblErrorMessage.setText("You have completed the Game !");
        }
    }

    public void check() {
        if (question == 1) {
            question1Check();
        } else if (question == 2) {
            question2Check();
        } else if (question == 3) {
            question3Check();
        }

        if (marks >= 192) {
            marks = 200;
        }
        fMarks = marks / 2;
        lblMarks.setText(fMarks + "");
        sendDataToDatabase();
        healthCheck();
    }

    public void question1Check() {

        // first Colomn
        if (lblTruthTbl_1_1.getText().equals("0")) {
            lblTruthTbl_1_1.setForeground(Color.green);
            marks = marks + 7;

        } else {
            lblTruthTbl_1_1.setForeground(Color.red);
            health = health - 1;
        }

        if (lblTruthTbl_1_2.getText().equals("0")) {
            lblTruthTbl_1_2.setForeground(Color.green);
            marks = marks + 7;

        } else {
            lblTruthTbl_1_2.setForeground(Color.red);
            health = health - 1;
        }

        if (lblTruthTbl_1_3.getText().equals("1")) {
            lblTruthTbl_1_3.setForeground(Color.green);
            marks = marks + 7;

        } else {
            lblTruthTbl_1_3.setForeground(Color.red);
            health = health - 1;
        }

        if (lblTruthTbl_1_4.getText().equals("1")) {
            lblTruthTbl_1_4.setForeground(Color.green);
            marks = marks + 7;

        } else {
            lblTruthTbl_1_4.setForeground(Color.red);
            health = health - 1;
        }

        // Second Colomn
        if (lblTruthTbl_2_1.getText().equals("0")) {
            lblTruthTbl_2_1.setForeground(Color.green);
            marks = marks + 7;

        } else {
            lblTruthTbl_2_1.setForeground(Color.red);
            health = health - 1;
        }

        if (lblTruthTbl_2_2.getText().equals("1")) {
            lblTruthTbl_2_2.setForeground(Color.green);
            marks = marks + 7;

        } else {
            lblTruthTbl_2_2.setForeground(Color.red);
            health = health - 1;
        }

        if (lblTruthTbl_2_3.getText().equals("0")) {
            lblTruthTbl_2_3.setForeground(Color.green);
            marks = marks + 7;

        } else {
            lblTruthTbl_2_3.setForeground(Color.red);
            health = health - 1;
        }

        if (lblTruthTbl_2_4.getText().equals("1")) {
            lblTruthTbl_2_4.setForeground(Color.green);
            marks = marks + 7;

        } else {
            lblTruthTbl_2_4.setForeground(Color.red);
            health = health - 1;
        }

        // third Colomn
        if (lblTruthTbl_3_1.getText().equals("0")) {
            lblTruthTbl_3_1.setForeground(Color.green);
            marks = marks + 7;

        } else {
            lblTruthTbl_3_1.setForeground(Color.red);
            health = health - 1;
        }
        if (lblTruthTbl_3_2.getText().equals("0")) {
            lblTruthTbl_3_2.setForeground(Color.green);
            marks = marks + 7;

        } else {
            lblTruthTbl_3_2.setForeground(Color.red);
            health = health - 1;
        }
        if (lblTruthTbl_3_3.getText().equals("0")) {
            lblTruthTbl_3_3.setForeground(Color.green);
            marks = marks + 7;

        } else {
            lblTruthTbl_3_3.setForeground(Color.red);
            health = health - 1;
        }
        if (lblTruthTbl_3_4.getText().equals("1")) {
            lblTruthTbl_3_4.setForeground(Color.green);
            marks = marks + 7;

        } else {
            lblTruthTbl_3_4.setForeground(Color.red);
            health = health - 1;
        }

    }

    public void question2Check() {

        // first Colomn
        if (lblTruthTbl_1_1.getText().equals("0")) {
            lblTruthTbl_1_1.setForeground(Color.green);
            marks = marks + 7;

        } else {
            lblTruthTbl_1_1.setForeground(Color.red);
            health = health - 1;
        }

        if (lblTruthTbl_1_2.getText().equals("0")) {
            lblTruthTbl_1_2.setForeground(Color.green);
            marks = marks + 7;

        } else {
            lblTruthTbl_1_2.setForeground(Color.red);
            health = health - 1;
        }

        if (lblTruthTbl_1_3.getText().equals("1")) {
            lblTruthTbl_1_3.setForeground(Color.green);
            marks = marks + 7;

        } else {
            lblTruthTbl_1_3.setForeground(Color.red);
            health = health - 1;
        }

        if (lblTruthTbl_1_4.getText().equals("1")) {
            lblTruthTbl_1_4.setForeground(Color.green);
            marks = marks + 7;

        } else {
            lblTruthTbl_1_4.setForeground(Color.red);
            health = health - 1;
        }

        // Second Colomn
        if (lblTruthTbl_2_1.getText().equals("0")) {
            lblTruthTbl_2_1.setForeground(Color.green);
            marks = marks + 7;

        } else {
            lblTruthTbl_2_1.setForeground(Color.red);
            health = health - 1;
        }

        if (lblTruthTbl_2_2.getText().equals("1")) {
            lblTruthTbl_2_2.setForeground(Color.green);
            marks = marks + 7;

        } else {
            lblTruthTbl_2_2.setForeground(Color.red);
            health = health - 1;
        }

        if (lblTruthTbl_2_3.getText().equals("0")) {
            lblTruthTbl_2_3.setForeground(Color.green);
            marks = marks + 7;

        } else {
            lblTruthTbl_2_3.setForeground(Color.red);
            health = health - 1;
        }

        if (lblTruthTbl_2_4.getText().equals("1")) {
            lblTruthTbl_2_4.setForeground(Color.green);
            marks = marks + 7;

        } else {
            lblTruthTbl_2_4.setForeground(Color.red);
            health = health - 1;
        }

        // third Colomn
        if (lblTruthTbl_3_1.getText().equals("0")) {
            lblTruthTbl_3_1.setForeground(Color.green);
            marks = marks + 7;

        } else {
            lblTruthTbl_3_1.setForeground(Color.red);
            health = health - 1;
        }
        if (lblTruthTbl_3_2.getText().equals("1")) {
            lblTruthTbl_3_2.setForeground(Color.green);
            marks = marks + 7;

        } else {
            lblTruthTbl_3_2.setForeground(Color.red);
            health = health - 1;
        }
        if (lblTruthTbl_3_3.getText().equals("1")) {
            lblTruthTbl_3_3.setForeground(Color.green);
            marks = marks + 7;

        } else {
            lblTruthTbl_3_3.setForeground(Color.red);
            health = health - 1;
        }
        if (lblTruthTbl_3_4.getText().equals("1")) {
            lblTruthTbl_3_4.setForeground(Color.green);
            marks = marks + 7;

        } else {
            lblTruthTbl_3_4.setForeground(Color.red);
            health = health - 1;
        }

    }

    public void question3Check() {

        // first Colomn
        if (lblTruthTbl_1_1.getText().equals("0")) {
            lblTruthTbl_1_1.setForeground(Color.green);
            marks = marks + 7;

        } else {
            lblTruthTbl_1_1.setForeground(Color.red);
            health = health - 1;
        }

        if (lblTruthTbl_1_2.getText().equals("1")) {
            lblTruthTbl_1_2.setForeground(Color.green);
            marks = marks + 7;

        } else {
            lblTruthTbl_1_2.setForeground(Color.red);
            health = health - 1;
        }

        // Second Colomn
        if (lblTruthTbl_2_1.getText().equals("1")) {
            lblTruthTbl_2_1.setForeground(Color.green);
            marks = marks + 7;

        } else {
            lblTruthTbl_2_1.setForeground(Color.red);
            health = health - 1;
        }

        if (lblTruthTbl_2_2.getText().equals("0")) {
            lblTruthTbl_2_2.setForeground(Color.green);
            marks = marks + 7;

        } else {
            lblTruthTbl_2_2.setForeground(Color.red);
            health = health - 1;
        }

    }

    public void healthCheck() {
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
        } else if (health < 0) {
            lblHealth1.setVisible(false);
            lblHealth2.setVisible(false);
            lblHealth3.setVisible(false);
            lblErrorMessage.show();
            lblErrorMessage.setText("Your health is Over, Pls retry");
            btnCheck.setEnabled(false);
            btnNext.setEnabled(false);
            btnReset.setVisible(true);
        }
    }

    public void resetGame() {
        question = 1;
        marks = 0;
        fMarks = 0;
        complete = 0;
        fComplete = 0;
        health = 3;

        btnNext.setEnabled(false);
        //btnCheck.setEnabled(false);
        btn0.setEnabled(false);
        btn1.setEnabled(false);
        lblErrorMessage.setVisible(false);
        btnReset.setVisible(false);
        btnCheck.setEnabled(true);

        lblTruthTbl_1_1.setVisible(true);
        lblTruthTbl_1_2.setVisible(true);
        lblTruthTbl_1_3.setVisible(true);
        lblTruthTbl_1_4.setVisible(true);

        lblTruthTbl_2_1.setVisible(true);
        lblTruthTbl_2_2.setVisible(true);
        lblTruthTbl_2_3.setVisible(true);
        lblTruthTbl_2_4.setVisible(true);

        lblTruthTbl_3_1.setVisible(true);
        lblTruthTbl_3_2.setVisible(true);
        lblTruthTbl_3_3.setVisible(true);
        lblTruthTbl_3_4.setVisible(true);

        questionChange();
        healthCheck();

        lblMarks.setText(marks + "");
        lblComplete.setText("Complete : " + fComplete + "%");
//        ImageIcon icon = new ImageIcon(ElectronicConfigurationLevel1.class.getResource("/Images/AndGate.png"));
//        lblPictureBoxGate.setIcon(icon);
//
//        ImageIcon icon1 = new ImageIcon(ElectronicConfigurationLevel1.class.getResource("/Images/TruthTableForAndOrGate.png"));
//        lblPictureBoxTruthTable.setIcon(icon1);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblMarks = new javax.swing.JLabel();
        lblHealth1 = new javax.swing.JLabel();
        lblHealth2 = new javax.swing.JLabel();
        lblHealth3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        lblComplete = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        lblGateType = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        lblPictureBoxGate = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnCheck = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        lblErrorMessage = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        lblTruthTbl_1_4 = new javax.swing.JLabel();
        lblTruthTbl_3_4 = new javax.swing.JLabel();
        lblTruthTbl_1_2 = new javax.swing.JLabel();
        lblTruthTbl_1_3 = new javax.swing.JLabel();
        lblTruthTbl_1_1 = new javax.swing.JLabel();
        lblTruthTbl_2_1 = new javax.swing.JLabel();
        lblTruthTbl_2_2 = new javax.swing.JLabel();
        lblTruthTbl_2_3 = new javax.swing.JLabel();
        lblTruthTbl_2_4 = new javax.swing.JLabel();
        lblTruthTbl_3_1 = new javax.swing.JLabel();
        lblTruthTbl_3_2 = new javax.swing.JLabel();
        lblTruthTbl_3_3 = new javax.swing.JLabel();
        lblPictureBoxTruthTable = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        btn0 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        lblSidePnlAdvanceLogicGateComplete = new javax.swing.JLabel();
        lblSidePnlAdvanceLogicGateMarks = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        lblSidePnlWelcomeName = new javax.swing.JLabel();
        lblSidePnlUsername = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Logic Gates");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Basic Logic Gates");

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblHealth1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblHealth2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblHealth3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMarks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(lblMarks))
                    .addComponent(lblHealth1)
                    .addComponent(lblHealth2)
                    .addComponent(lblHealth3))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Fill the Truth Table ");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Logic Gate");

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        lblComplete.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblComplete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblComplete.setText("Complete : 0%");

        lblGateType.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblGateType.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGateType.setText("AND ");

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        lblPictureBoxGate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/AndGate.png"))); // NOI18N

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblPictureBoxGate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addComponent(lblPictureBoxGate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGateType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblGateType, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblComplete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblComplete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        btnCheck.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCheck.setText("Check");
        btnCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckActionPerformed(evt);
            }
        });

        btnNext.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(btnCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        lblErrorMessage.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblErrorMessage.setForeground(new java.awt.Color(153, 0, 0));
        lblErrorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblErrorMessage.setText("Error Message");

        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTruthTbl_1_4.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        lblTruthTbl_1_4.setForeground(new java.awt.Color(153, 153, 153));
        lblTruthTbl_1_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTruthTbl_1_4.setText("?");
        lblTruthTbl_1_4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTruthTbl_1_4MouseClicked(evt);
            }
        });
        jPanel16.add(lblTruthTbl_1_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 90, 50));

        lblTruthTbl_3_4.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        lblTruthTbl_3_4.setForeground(new java.awt.Color(153, 153, 153));
        lblTruthTbl_3_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTruthTbl_3_4.setText("?");
        lblTruthTbl_3_4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTruthTbl_3_4MouseClicked(evt);
            }
        });
        jPanel16.add(lblTruthTbl_3_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, 90, 50));

        lblTruthTbl_1_2.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        lblTruthTbl_1_2.setForeground(new java.awt.Color(153, 153, 153));
        lblTruthTbl_1_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTruthTbl_1_2.setText("?");
        lblTruthTbl_1_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTruthTbl_1_2MouseClicked(evt);
            }
        });
        jPanel16.add(lblTruthTbl_1_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 90, 50));

        lblTruthTbl_1_3.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        lblTruthTbl_1_3.setForeground(new java.awt.Color(153, 153, 153));
        lblTruthTbl_1_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTruthTbl_1_3.setText("?");
        lblTruthTbl_1_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTruthTbl_1_3MouseClicked(evt);
            }
        });
        jPanel16.add(lblTruthTbl_1_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 90, 50));

        lblTruthTbl_1_1.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        lblTruthTbl_1_1.setForeground(new java.awt.Color(153, 153, 153));
        lblTruthTbl_1_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTruthTbl_1_1.setText("?");
        lblTruthTbl_1_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTruthTbl_1_1MouseClicked(evt);
            }
        });
        jPanel16.add(lblTruthTbl_1_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 90, 50));

        lblTruthTbl_2_1.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        lblTruthTbl_2_1.setForeground(new java.awt.Color(153, 153, 153));
        lblTruthTbl_2_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTruthTbl_2_1.setText("?");
        lblTruthTbl_2_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTruthTbl_2_1MouseClicked(evt);
            }
        });
        jPanel16.add(lblTruthTbl_2_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 90, 50));

        lblTruthTbl_2_2.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        lblTruthTbl_2_2.setForeground(new java.awt.Color(153, 153, 153));
        lblTruthTbl_2_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTruthTbl_2_2.setText("?");
        lblTruthTbl_2_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTruthTbl_2_2MouseClicked(evt);
            }
        });
        jPanel16.add(lblTruthTbl_2_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 90, 50));

        lblTruthTbl_2_3.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        lblTruthTbl_2_3.setForeground(new java.awt.Color(153, 153, 153));
        lblTruthTbl_2_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTruthTbl_2_3.setText("?");
        lblTruthTbl_2_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTruthTbl_2_3MouseClicked(evt);
            }
        });
        jPanel16.add(lblTruthTbl_2_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 90, 50));

        lblTruthTbl_2_4.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        lblTruthTbl_2_4.setForeground(new java.awt.Color(153, 153, 153));
        lblTruthTbl_2_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTruthTbl_2_4.setText("?");
        lblTruthTbl_2_4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTruthTbl_2_4MouseClicked(evt);
            }
        });
        jPanel16.add(lblTruthTbl_2_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 90, 50));

        lblTruthTbl_3_1.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        lblTruthTbl_3_1.setForeground(new java.awt.Color(153, 153, 153));
        lblTruthTbl_3_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTruthTbl_3_1.setText("?");
        lblTruthTbl_3_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTruthTbl_3_1MouseClicked(evt);
            }
        });
        jPanel16.add(lblTruthTbl_3_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 90, 50));

        lblTruthTbl_3_2.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        lblTruthTbl_3_2.setForeground(new java.awt.Color(153, 153, 153));
        lblTruthTbl_3_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTruthTbl_3_2.setText("?");
        lblTruthTbl_3_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTruthTbl_3_2MouseClicked(evt);
            }
        });
        jPanel16.add(lblTruthTbl_3_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, 90, 50));

        lblTruthTbl_3_3.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        lblTruthTbl_3_3.setForeground(new java.awt.Color(153, 153, 153));
        lblTruthTbl_3_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTruthTbl_3_3.setText("?");
        lblTruthTbl_3_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTruthTbl_3_3MouseClicked(evt);
            }
        });
        jPanel16.add(lblTruthTbl_3_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 90, 50));

        lblPictureBoxTruthTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/TruthTableForAndOrGate.png"))); // NOI18N
        jPanel16.add(lblPictureBoxTruthTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        btn0.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        btn0.setText("0");
        btn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn0ActionPerformed(evt);
            }
        });

        btn1.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        btn1.setText("1");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn1, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(btn0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnReset.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
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
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblErrorMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblErrorMessage)
                    .addComponent(btnReset))
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Truth Table");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        jLabel9.setText("Advance Logic Gate");

        lblSidePnlAdvanceLogicGateComplete.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblSidePnlAdvanceLogicGateComplete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSidePnlAdvanceLogicGateComplete.setText("Completed : 0%");

        lblSidePnlAdvanceLogicGateMarks.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSidePnlAdvanceLogicGateMarks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSidePnlAdvanceLogicGateMarks.setText("Score : 00");

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
                    .addComponent(lblSidePnlAdvanceLogicGateComplete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSidePnlAdvanceLogicGateMarks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(lblSidePnlAdvanceLogicGateComplete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSidePnlAdvanceLogicGateMarks)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Other Scores");

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
                    .addComponent(lblSidePnlWelcomeName, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn0ActionPerformed
        // TODO add your handling code here:
        selectedLabel.setText("0");
        btn0.setEnabled(false);
        btn1.setEnabled(false);
        selectButton();
    }//GEN-LAST:event_btn0ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        // TODO add your handling code here:
        selectedLabel.setText("1");
        btn0.setEnabled(false);
        btn1.setEnabled(false);
        selectButton();
    }//GEN-LAST:event_btn1ActionPerformed

    //==================== Code to Labels ==============================//
    private void lblTruthTbl_1_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTruthTbl_1_1MouseClicked
        // TODO add your handling code here:
        selectedLabel = lblTruthTbl_1_1;
        setDefaultColor();
        selectLabal();
    }//GEN-LAST:event_lblTruthTbl_1_1MouseClicked

    private void lblTruthTbl_2_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTruthTbl_2_1MouseClicked
        // TODO add your handling code here:
        selectedLabel = lblTruthTbl_2_1;
        setDefaultColor();
        selectLabal();
    }//GEN-LAST:event_lblTruthTbl_2_1MouseClicked

    private void lblTruthTbl_3_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTruthTbl_3_1MouseClicked
        // TODO add your handling code here:
        selectedLabel = lblTruthTbl_3_1;
        setDefaultColor();
        selectLabal();
    }//GEN-LAST:event_lblTruthTbl_3_1MouseClicked

    private void lblTruthTbl_1_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTruthTbl_1_2MouseClicked
        // TODO add your handling code here:
        selectedLabel = lblTruthTbl_1_2;
        setDefaultColor();
        selectLabal();
    }//GEN-LAST:event_lblTruthTbl_1_2MouseClicked

    private void lblTruthTbl_2_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTruthTbl_2_2MouseClicked
        // TODO add your handling code here:
        selectedLabel = lblTruthTbl_2_2;
        setDefaultColor();
        selectLabal();
    }//GEN-LAST:event_lblTruthTbl_2_2MouseClicked

    private void lblTruthTbl_3_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTruthTbl_3_2MouseClicked
        // TODO add your handling code here:
        selectedLabel = lblTruthTbl_3_2;
        setDefaultColor();
        selectLabal();
    }//GEN-LAST:event_lblTruthTbl_3_2MouseClicked

    private void lblTruthTbl_1_3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTruthTbl_1_3MouseClicked
        // TODO add your handling code here:
        selectedLabel = lblTruthTbl_1_3;
        setDefaultColor();
        selectLabal();
    }//GEN-LAST:event_lblTruthTbl_1_3MouseClicked

    private void lblTruthTbl_2_3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTruthTbl_2_3MouseClicked
        // TODO add your handling code here:
        selectedLabel = lblTruthTbl_2_3;
        setDefaultColor();
        selectLabal();
    }//GEN-LAST:event_lblTruthTbl_2_3MouseClicked

    private void lblTruthTbl_3_3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTruthTbl_3_3MouseClicked
        // TODO add your handling code here:
        selectedLabel = lblTruthTbl_3_3;
        setDefaultColor();
        selectLabal();
    }//GEN-LAST:event_lblTruthTbl_3_3MouseClicked

    private void lblTruthTbl_1_4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTruthTbl_1_4MouseClicked
        // TODO add your handling code here:
        selectedLabel = lblTruthTbl_1_4;
        setDefaultColor();
        selectLabal();
    }//GEN-LAST:event_lblTruthTbl_1_4MouseClicked

    private void lblTruthTbl_2_4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTruthTbl_2_4MouseClicked
        // TODO add your handling code here:
        selectedLabel = lblTruthTbl_2_4;
        setDefaultColor();
        selectLabal();
    }//GEN-LAST:event_lblTruthTbl_2_4MouseClicked

    private void lblTruthTbl_3_4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTruthTbl_3_4MouseClicked
        // TODO add your handling code here:
        selectedLabel = lblTruthTbl_3_4;
        setDefaultColor();
        selectLabal();
    }//GEN-LAST:event_lblTruthTbl_3_4MouseClicked
//==========================other buttons coding ===============================//
    private void btnCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckActionPerformed
        // TODO add your handling code here:
        btnCheck.setEnabled(false);
        btnNext.setEnabled(true);
        check();
    }//GEN-LAST:event_btnCheckActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        question = question + 1;
        btnCheck.setEnabled(true);
        btnNext.setEnabled(false);
        questionChange();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        resetGame();
    }//GEN-LAST:event_btnResetActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        LogicGates logicGates = new LogicGates();
        logicGates.Setdata(RegisterId);
        logicGates.show();
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
            java.util.logging.Logger.getLogger(BasicLogicGates.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BasicLogicGates.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BasicLogicGates.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BasicLogicGates.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BasicLogicGates().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn0;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btnCheck;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblComplete;
    private javax.swing.JLabel lblErrorMessage;
    private javax.swing.JLabel lblGateType;
    private javax.swing.JLabel lblHealth1;
    private javax.swing.JLabel lblHealth2;
    private javax.swing.JLabel lblHealth3;
    private javax.swing.JLabel lblMarks;
    private javax.swing.JLabel lblPictureBoxGate;
    private javax.swing.JLabel lblPictureBoxTruthTable;
    private javax.swing.JLabel lblSidePnlAdvanceLogicGateComplete;
    private javax.swing.JLabel lblSidePnlAdvanceLogicGateMarks;
    private javax.swing.JLabel lblSidePnlUsername;
    private javax.swing.JLabel lblSidePnlWelcomeName;
    private javax.swing.JLabel lblTruthTbl_1_1;
    private javax.swing.JLabel lblTruthTbl_1_2;
    private javax.swing.JLabel lblTruthTbl_1_3;
    private javax.swing.JLabel lblTruthTbl_1_4;
    private javax.swing.JLabel lblTruthTbl_2_1;
    private javax.swing.JLabel lblTruthTbl_2_2;
    private javax.swing.JLabel lblTruthTbl_2_3;
    private javax.swing.JLabel lblTruthTbl_2_4;
    private javax.swing.JLabel lblTruthTbl_3_1;
    private javax.swing.JLabel lblTruthTbl_3_2;
    private javax.swing.JLabel lblTruthTbl_3_3;
    private javax.swing.JLabel lblTruthTbl_3_4;
    // End of variables declaration//GEN-END:variables
}
