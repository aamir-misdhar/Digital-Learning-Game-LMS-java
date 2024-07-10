/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ICT;

import Science.MapMarkingDigestiveSystem;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author mmaam
 */
public class AdvanceLogicGates_BooleanToMap extends javax.swing.JFrame {

    /**
     * Creates new form AdvanceLogicGates_BooleanToMap
     */
    String RegisterId;
    JLabel selectedLabel;
    JButton selectedButton;

    int marks = 0;
    int fMarks = 0;
    int complete = 0;
    int fComplete = 0;
    int health = 3;
    int questionNumber = 0;

    public AdvanceLogicGates_BooleanToMap() {
        initComponents();
        questionChange();
        lblMessageBox.setVisible(false);
        btnReset.setVisible(false);

    }
    
    public void Setdata(String ID) {
        RegisterId = ID;

        //set user marks
        try {
            Connection con = Database.db.getConnection();
            String sql = "SELECT basicLogicGates_marks,basicLogicGates_complete FROM digital_learning_game.ict where stdRegisterId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String basicLogicGatesComplete = rs.getString("basicLogicGates_complete");
                String basicLogicGatesMarks = rs.getString("basicLogicGates_marks");


                //Set data
                lblSidePnlBasicLogicGateComplete.setText("Completed : " + basicLogicGatesComplete + "%");
                lblSidePnlBasicLogicGateMarks.setText("Score : " + basicLogicGatesMarks);

                

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
    
    public void sendDataToDatabase(){
        try {
            // create connection to database
            Connection con = Database.db.getConnection();
            // Create prepared statement with the sql query
            PreparedStatement st1 = con.prepareStatement("UPDATE `digital_learning_game`.`ict` SET `advanceLogicGates_BooleanMap_marks` = '"+fMarks+"', `advanceLogicGates_BooleanMap_complete` = '"+fComplete+"' WHERE (`stdRegisterId` = '"+RegisterId+"');");
            // execute query
            st1.executeUpdate();
            
            // show success message
            //JOptionPane.showMessageDialog(this, "Successfully Inserted...");
        } catch (SQLException ex) {
            Logger.getLogger(AdvanceLogicGates_BooleanToMap.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void disableButtons() {
        btnAndGate.setEnabled(false);
        btnOrGate.setEnabled(false);
    }

    public void enableButtons() {
        btnAndGate.setEnabled(true);
        btnOrGate.setEnabled(true);
    }

    public void questionChange() {
        questionNumber = questionNumber + 1;
        disableButtons();
        btnNext.setEnabled(false);
        btnCheck.setEnabled(true);

        if (questionNumber == 1) {
            lblQuestion.setText("( A . B ) . C");
        } else if (questionNumber == 2) {
            lblQuestion.setText("( A + B ) + C");
        } else if (questionNumber == 3) {
            lblQuestion.setText("( A . B ) + C");
        } else if (questionNumber == 4) {
            lblQuestion.setText("( A + B ) . C");
            btnNext.setText("Finish");
        }else if(questionNumber>4){
            btnCheck.setEnabled(false);
            btnNext.setEnabled(false);
            lblMessageBox.setVisible(true);
            lblMessageBox.setText("Conguragilations, You have Completed");
            lblMessageBox.setForeground(new Color(0,153,0));
        }
    }

    public void lblGateSelected() {
        selectedLabel.setBorder(BorderFactory.createLineBorder(Color.blue, 2));
        selectedLabel.setForeground(Color.BLACK);
        enableButtons();
    }

    public void btnGateSelected() {
        complete = complete + 25;
        fComplete = complete / 2;
        lblComplete.setText("Completed : " + fComplete + "%");

        Icon btnIcon = selectedButton.getIcon();

        selectedLabel.setText("");
        selectedLabel.setBorder(null);
        selectedLabel.setIcon(btnIcon);
        disableButtons();
    }

    public void setdefoultBorder() {
        if (lblGate1.getText().equals("?")) {
            lblGate1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
            lblGate1.setForeground(new Color(153, 153, 153));
        }

        if (lblGate2.getText().equals("?")) {
            lblGate2.setBorder(BorderFactory.createLineBorder(Color.black, 1));
            lblGate2.setForeground(new Color(153, 153, 153));
        }

    }

    public void removeGate() {
        complete = complete - 25;
        fComplete = complete / 2;
        lblComplete.setText("Completed : " + fComplete + "%");

        selectedLabel.setIcon(null);
        selectedLabel.setText("?");
        setdefoultBorder();
    }

    public void checkGame() {
        if (questionNumber == 1) {
            checkGame1();
        } else if (questionNumber == 2) {
            checkGame2();
        } else if (questionNumber == 3) {
            checkGame3();
        } else if (questionNumber == 4) {
            checkGame4();
        }

        fMarks = marks / 2;
        lblMarks.setText(fMarks + "");
        
        sendDataToDatabase();
        btnNext.setEnabled(true);
        btnCheck.setEnabled(false);
        healthCheck();
    }

    public void checkGame1() {
        // Gate 1
        if (lblGate1.getIcon() == btnAndGate.getIcon()) {
            lblGate1.setBorder(BorderFactory.createLineBorder(Color.green, 2));
            marks = marks + 25;
        } else {
            lblGate1.setBorder(BorderFactory.createLineBorder(Color.red, 2));
            health = health - 1;
        }
        // Gate 2
        if (lblGate2.getIcon() == btnAndGate.getIcon()) {
            lblGate2.setBorder(BorderFactory.createLineBorder(Color.green, 2));
            marks = marks + 25;
        } else {
            lblGate2.setBorder(BorderFactory.createLineBorder(Color.red, 2));
            health = health - 1;
        }
    }

    public void checkGame2() {
        // Gate 1
        if (lblGate1.getIcon() == btnOrGate.getIcon()) {
            lblGate1.setBorder(BorderFactory.createLineBorder(Color.green, 2));
            marks = marks + 25;
        } else {
            lblGate1.setBorder(BorderFactory.createLineBorder(Color.red, 2));
            health = health - 1;
        }
        // Gate 2
        if (lblGate2.getIcon() == btnOrGate.getIcon()) {
            lblGate2.setBorder(BorderFactory.createLineBorder(Color.green, 2));
            marks = marks + 25;
        } else {
            lblGate2.setBorder(BorderFactory.createLineBorder(Color.red, 2));
            health = health - 1;
        }
    }

    public void checkGame3() {
        // Gate 1
        if (lblGate1.getIcon() == btnAndGate.getIcon()) {
            lblGate1.setBorder(BorderFactory.createLineBorder(Color.green, 2));
            marks = marks + 25;
        } else {
            lblGate1.setBorder(BorderFactory.createLineBorder(Color.red, 2));
            health = health - 1;
        }
        // Gate 2
        if (lblGate2.getIcon() == btnOrGate.getIcon()) {
            lblGate2.setBorder(BorderFactory.createLineBorder(Color.green, 2));
            marks = marks + 25;
        } else {
            lblGate2.setBorder(BorderFactory.createLineBorder(Color.red, 2));
            health = health - 1;
        }
    }

    public void checkGame4() {
        // Gate 1
        if (lblGate1.getIcon() == btnOrGate.getIcon()) {
            lblGate1.setBorder(BorderFactory.createLineBorder(Color.green, 2));
            marks = marks + 25;
        } else {
            lblGate1.setBorder(BorderFactory.createLineBorder(Color.red, 2));
            health = health - 1;
        }
        // Gate 2
        if (lblGate2.getIcon() == btnAndGate.getIcon()) {
            lblGate2.setBorder(BorderFactory.createLineBorder(Color.green, 2));
            marks = marks + 25;
        } else {
            lblGate2.setBorder(BorderFactory.createLineBorder(Color.red, 2));
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
            lblMessageBox.setVisible(true);
            lblMessageBox.setText("Your Lost the game, Pls Reset");

            btnCheck.setEnabled(false);
            btnNext.setEnabled(false);
            btnReset.setVisible(true);
        }
    }

    public void resetGameMap() {
        lblGate1.setIcon(null);
        lblGate1.setText("?");

        lblGate2.setIcon(null);
        lblGate2.setText("?");

        setdefoultBorder();
    }

    public void resetGame() {
        marks = 0;
        fMarks = 0;
        complete = 0;
        fComplete = 0;
        health = 3;
        questionNumber = 0;

        healthCheck();
        resetGameMap();
        questionChange();
        lblMessageBox.setVisible(false);
        btnReset.setVisible(false);
        btnNext.setText("Next");
        
        lblComplete.setText("Completed : "+fComplete+"%");
        lblMarks.setText(fMarks+"");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        lblSidePnlBasicLogicGateComplete = new javax.swing.JLabel();
        lblSidePnlBasicLogicGateMarks = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        lblSidePnlWelcomeName = new javax.swing.JLabel();
        lblSidePnlUsername = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
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
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        btnAndGate = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        btnOrGate = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        btnCheck = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        lblMessageBox = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblComplete = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        lblGate2 = new javax.swing.JLabel();
        lblGate1 = new javax.swing.JLabel();
        lblPictureBoxQuestionMap = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lblQuestion = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
        jLabel9.setText("Basic Logic Gate");

        lblSidePnlBasicLogicGateComplete.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblSidePnlBasicLogicGateComplete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSidePnlBasicLogicGateComplete.setText("Completed : 0%");

        lblSidePnlBasicLogicGateMarks.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSidePnlBasicLogicGateMarks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSidePnlBasicLogicGateMarks.setText("Score : 00");

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
                    .addComponent(lblSidePnlBasicLogicGateComplete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSidePnlBasicLogicGateMarks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(lblSidePnlBasicLogicGateComplete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSidePnlBasicLogicGateMarks)
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

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Logic Gates");

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        btnAndGate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/AdvancedLogicGate_AndGate.png"))); // NOI18N
        btnAndGate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAndGateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(btnAndGate, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAndGate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
        );

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));

        btnOrGate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/AdvancedLogicGate_OrGate.png"))); // NOI18N
        btnOrGate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrGateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(btnOrGate, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnOrGate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        btnCheck.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnCheck.setText("Check");
        btnCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckActionPerformed(evt);
            }
        });

        btnNext.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(btnCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCheck, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnNext, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        lblMessageBox.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblMessageBox.setForeground(new java.awt.Color(153, 0, 0));
        lblMessageBox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMessageBox.setText("Error Messege");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMessageBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(lblMessageBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lblComplete.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblComplete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblComplete.setText("Completed : 0%");

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblGate2.setFont(new java.awt.Font("Segoe UI", 1, 38)); // NOI18N
        lblGate2.setForeground(new java.awt.Color(153, 153, 153));
        lblGate2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGate2.setText("?");
        lblGate2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        lblGate2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGate2MouseClicked(evt);
            }
        });
        jPanel8.add(lblGate2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 160, 120));

        lblGate1.setFont(new java.awt.Font("Segoe UI", 1, 38)); // NOI18N
        lblGate1.setForeground(new java.awt.Color(153, 153, 153));
        lblGate1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGate1.setText("?");
        lblGate1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        lblGate1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGate1MouseClicked(evt);
            }
        });
        jPanel8.add(lblGate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 160, 120));

        lblPictureBoxQuestionMap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/AdvancedLogicGateMap.png"))); // NOI18N
        jPanel8.add(lblPictureBoxQuestionMap, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblComplete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblComplete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        lblQuestion.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        lblQuestion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQuestion.setText("( A . B ) + C");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setText("Fill  the Blanked Logic Gates Below");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblGate1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGate1MouseClicked
        // TODO add your handling code here:
        selectedLabel = lblGate1;
        if (selectedLabel.getText().equals("?")) {
            setdefoultBorder();
            lblGateSelected();
        } else {
            removeGate();
        }

    }//GEN-LAST:event_lblGate1MouseClicked

    private void lblGate2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGate2MouseClicked
        // TODO add your handling code here:
        selectedLabel = lblGate2;
        if (selectedLabel.getText().equals("?")) {
            setdefoultBorder();
            lblGateSelected();
        } else {
            removeGate();
        }
    }//GEN-LAST:event_lblGate2MouseClicked

    private void btnAndGateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAndGateActionPerformed
        // TODO add your handling code here:
        selectedButton = btnAndGate;
        btnGateSelected();
    }//GEN-LAST:event_btnAndGateActionPerformed

    private void btnOrGateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrGateActionPerformed
        // TODO add your handling code here:
        selectedButton = btnOrGate;
        btnGateSelected();
    }//GEN-LAST:event_btnOrGateActionPerformed

    private void btnCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckActionPerformed
        // TODO add your handling code here:
        checkGame();

    }//GEN-LAST:event_btnCheckActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        questionChange();
        resetGameMap();
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
            java.util.logging.Logger.getLogger(AdvanceLogicGates_BooleanToMap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdvanceLogicGates_BooleanToMap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdvanceLogicGates_BooleanToMap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdvanceLogicGates_BooleanToMap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdvanceLogicGates_BooleanToMap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAndGate;
    private javax.swing.JButton btnCheck;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnOrGate;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JLabel lblGate1;
    private javax.swing.JLabel lblGate2;
    private javax.swing.JLabel lblHealth1;
    private javax.swing.JLabel lblHealth2;
    private javax.swing.JLabel lblHealth3;
    private javax.swing.JLabel lblMarks;
    private javax.swing.JLabel lblMessageBox;
    private javax.swing.JLabel lblPictureBoxQuestionMap;
    private javax.swing.JLabel lblQuestion;
    private javax.swing.JLabel lblSidePnlBasicLogicGateComplete;
    private javax.swing.JLabel lblSidePnlBasicLogicGateMarks;
    private javax.swing.JLabel lblSidePnlUsername;
    private javax.swing.JLabel lblSidePnlWelcomeName;
    // End of variables declaration//GEN-END:variables
}
