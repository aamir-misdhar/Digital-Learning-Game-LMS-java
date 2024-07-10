/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Maths;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mmaam
 */
public class BasicMathsLevel3 extends javax.swing.JInternalFrame {

    /**
     * Creates new form BasicMathsLevel2
     */
    String RegisterId;
    int fMarks = 0;
    int Complete = 0;

    public BasicMathsLevel3() {
        initComponents();
        javax.swing.plaf.InternalFrameUI ifu = this.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) ifu).setNorthPane(null);
        lblErrorMessage.setVisible(false);
        btnNext.setEnabled(false);
        levelChack();
    }

    public void Setdata(String ID) {
        RegisterId = ID;

    }

    public void sendDataToDatabase() {
        try {
            // create connection to database
            Connection con = Database.db.getConnection();
            // Create prepared statement with the sql query
            PreparedStatement st1 = con.prepareStatement("UPDATE `digital_learning_game`.`maths` SET `basicMathsLevel3_Marks` = '" + fMarks + "', `basicMathsLevel3_Complete` = '" + Complete + "' WHERE (`stdRegisterId` = '" + RegisterId + "');");
            // execute query
            st1.executeUpdate();

            // show success message
            //JOptionPane.showMessageDialog(this, "Successfully Inserted...");
        } catch (SQLException ex) {
            Logger.getLogger(BasicMathsLevel1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void disableEasy() {
        lblEasy.setEnabled(false);
        txtEasyAns.setEnabled(false);
        lblEasyNum1.setEnabled(false);
        lblEasyNum2.setEnabled(false);
        btnEasyCheck.setEnabled(false);

        pnlEasy.setBackground(Color.LIGHT_GRAY);
    }

    public void disableHard() {
        lblHard.setEnabled(false);
        txtHardAns.setEnabled(false);
        lblHardNum1.setEnabled(false);
        lblHardNum2.setEnabled(false);
        lblHardNum3.setEnabled(false);
        btnHardCheck.setEnabled(false);

        pnlHard.setBackground(Color.LIGHT_GRAY);
    }

    public void enableEasy() {
        lblEasy.setEnabled(true);
        txtEasyAns.setEnabled(true);
        lblEasyNum1.setEnabled(true);
        lblEasyNum2.setEnabled(true);
        btnEasyCheck.setEnabled(true);

        pnlEasy.setBackground(new Color(204, 255, 255));
    }

    public void enableHard() {
        lblHard.setEnabled(true);
        txtHardAns.setEnabled(true);
        lblHardNum1.setEnabled(true);
        lblHardNum2.setEnabled(true);
        lblHardNum3.setEnabled(true);
        btnHardCheck.setEnabled(true);

        pnlHard.setBackground(new Color(255, 204, 204));
    }

    int Health = 3;
    int qestionNumber = 0;

    public void levelChack() {
        qestionNumber++;
        if (qestionNumber > 10) {
            btnNext.setEnabled(true);
            disableEasy();
            disableHard();
        } else {
            if (qestionNumber <= 5) {
                disableHard();
                enableEasy();
                easyGameRandom();
            } else {
                disableEasy();
                enableHard();
                HardGameRandom();
            }
        }

    }

    public void HealthLost() {
        Health--;
        if (Health == 3) {
            Health1.setVisible(true);
            Health2.setVisible(true);
            Health3.setVisible(true);
        } else if (Health == 2) {
            Health1.setVisible(true);
            Health2.setVisible(true);
            Health3.setVisible(false);
        } else if (Health == 1) {
            Health1.setVisible(true);
            Health2.setVisible(false);
            Health3.setVisible(false);
        } else {
            Health1.setVisible(false);
            Health2.setVisible(false);
            Health3.setVisible(false);
        }
    }

    public void healthChack() {
        if (Health < 0) {
            lblErrorMessage.setText("Your Health is Over, Reset the Game");
            lblErrorMessage.setVisible(true);

            disableEasy();
            disableHard();
        }
    }

    public void resetGame() {
        lblMarks.setText("00");
        qestionNumber = 0;
        Health = 3;

        fMarks = 0;
        Complete = 0;
        lblComplete.setText("Complete : " + Complete + "%");

        Health1.setVisible(true);
        Health2.setVisible(true);
        Health3.setVisible(true);

        lblEasyDisplay.setText("Display");
        lblHardDisplay.setText("Display");

        lblQuestion1.setForeground(Color.black);
        lblQuestion2.setForeground(Color.black);
        lblQuestion3.setForeground(Color.black);
        lblQuestion4.setForeground(Color.black);
        lblQuestion5.setForeground(Color.black);
        lblQuestion6.setForeground(Color.black);
        lblQuestion7.setForeground(Color.black);
        lblQuestion8.setForeground(Color.black);
        lblQuestion9.setForeground(Color.black);
        lblQuestion10.setForeground(Color.black);

        lblMarks1.setForeground(Color.black);
        lblMarks2.setForeground(Color.black);
        lblMarks3.setForeground(Color.black);
        lblMarks4.setForeground(Color.black);
        lblMarks5.setForeground(Color.black);
        lblMarks6.setForeground(Color.black);
        lblMarks7.setForeground(Color.black);
        lblMarks8.setForeground(Color.black);
        lblMarks9.setForeground(Color.black);
        lblMarks10.setForeground(Color.black);

        lblMarks1.setText("00");
        lblMarks2.setText("00");
        lblMarks3.setText("00");
        lblMarks4.setText("00");
        lblMarks5.setText("00");
        lblMarks6.setText("00");
        lblMarks7.setText("00");
        lblMarks8.setText("00");
        lblMarks9.setText("00");
        lblMarks10.setText("00");

        lblErrorMessage.setVisible(false);
        lblErrorMessage.setBackground(Color.red);
        btnNext.setEnabled(false);
        levelChack();

    }

    public void gameNext() {
        int marks = Integer.valueOf(lblMarks.getText());
        if (marks >= 80) {
            lblErrorMessage.setVisible(true);
            lblErrorMessage.setText("Level 2 is unlocked..!");
            lblErrorMessage.setForeground(Color.GREEN);
            BasicMaths bm = new BasicMaths();
            bm.show();
            bm.level2();
            this.setVisible(false);

        } else {
            lblErrorMessage.setVisible(true);
            lblErrorMessage.setText("You should get upto 80 Marks");

        }
    }

    //==========================Easy Game ======================================//
    public void easyGameRandom() {
        Random rnd = new Random();
        int num1 = rnd.nextInt(10);
        int num2 = rnd.nextInt(5);

        lblEasyNum1.setText("" + num1);
        lblEasyNum2.setText("" + num2);

        txtEasyAns.setText("");
    }

    public void easyGameChack() {
        try {
            int num1 = Integer.valueOf(lblEasyNum1.getText());
            int num2 = Integer.valueOf(lblEasyNum2.getText());
            int ans = Integer.valueOf(txtEasyAns.getText());
            int ttl = num1 * num2;

            if (ans == ttl) {
                easyGameCorrectAnswer();
            } else {
                easyGameWrongAnswer();
                HealthLost();
            }
        } catch (NumberFormatException e) {
            easyGameWrongAnswer();
            HealthLost();
            lblEasyDisplay.setText("Invalid Number");
            
        }

        Complete = Complete + 10;
        lblComplete.setText("Complete : " + Complete + "%");
    }

    public void easyGameCorrectAnswer() {
        lblEasyDisplay.setText("Last One is Correct Answer");
        int marks = Integer.valueOf(lblMarks.getText());
        marks = marks + 10;
        lblMarks.setText("" + marks);

        if (qestionNumber == 1) {
            lblMarks1.setText("10");
            lblMarks1.setForeground(Color.GREEN);
            lblQuestion1.setForeground(Color.GREEN);
        }
        if (qestionNumber == 2) {
            lblMarks2.setText("10");
            lblMarks2.setForeground(Color.GREEN);
            lblQuestion2.setForeground(Color.GREEN);
        }
        if (qestionNumber == 3) {
            lblMarks3.setText("10");
            lblMarks3.setForeground(Color.GREEN);
            lblQuestion3.setForeground(Color.GREEN);
        }
        if (qestionNumber == 4) {
            lblMarks4.setText("10");
            lblMarks4.setForeground(Color.GREEN);
            lblQuestion4.setForeground(Color.GREEN);
        }
        if (qestionNumber == 5) {
            lblMarks5.setText("10");
            lblMarks5.setForeground(Color.GREEN);
            lblQuestion5.setForeground(Color.GREEN);
        }

        fMarks = marks;
    }

    public void easyGameWrongAnswer() {
        lblEasyDisplay.setText("Last One is Wrong Answer");
        if (qestionNumber == 1) {
            lblMarks1.setText("00");
            lblMarks1.setForeground(Color.red);
            lblQuestion1.setForeground(Color.red);
        }
        if (qestionNumber == 2) {
            lblMarks2.setText("00");
            lblMarks2.setForeground(Color.red);
            lblQuestion2.setForeground(Color.red);
        }
        if (qestionNumber == 3) {
            lblMarks3.setText("00");
            lblMarks3.setForeground(Color.red);
            lblQuestion3.setForeground(Color.red);
        }
        if (qestionNumber == 4) {
            lblMarks4.setText("00");
            lblMarks4.setForeground(Color.red);
            lblQuestion4.setForeground(Color.red);
        }
        if (qestionNumber == 5) {
            lblMarks5.setText("00");
            lblMarks5.setForeground(Color.red);
            lblQuestion5.setForeground(Color.red);
        }
    }

    //==========================Hard Game ======================================//
    public void HardGameRandom() {
        Random rnd = new Random();
        int num1 = rnd.nextInt(10);
        int num2 = rnd.nextInt(10);
        int num3 = rnd.nextInt(20);

        lblHardNum1.setText("" + num1);
        lblHardNum2.setText("" + num2);
        lblHardNum3.setText("" + num3);

        txtHardAns.setText("");
    }

    public void HardGameChack() {
        try {
            int num1 = Integer.valueOf(lblHardNum1.getText());
            int num2 = Integer.valueOf(lblHardNum2.getText());
            int num3 = Integer.valueOf(lblHardNum3.getText());
            int ans = Integer.valueOf(txtHardAns.getText());
            int ttl = num1 * num2 + num3;

            if (ans == ttl) {
                hardGameCorrectAnswer();
            } else {
                hardGameWrongAnswer();
                HealthLost();
            }
        } catch (NumberFormatException e) {
            hardGameWrongAnswer();
            HealthLost();
            lblHardDisplay.setText("Invalid Number");
            
        }

        Complete = Complete + 10;
        lblComplete.setText("Complete : " + Complete + "%");
    }

    public void hardGameCorrectAnswer() {
        lblHardDisplay.setText("Last One is Correct Answer");
        int marks = Integer.valueOf(lblMarks.getText());
        marks = marks + 10;
        lblMarks.setText("" + marks);

        if (qestionNumber == 6) {
            lblMarks6.setText("10");
            lblMarks6.setForeground(Color.GREEN);
            lblQuestion6.setForeground(Color.GREEN);
        }
        if (qestionNumber == 7) {
            lblMarks7.setText("10");
            lblMarks7.setForeground(Color.GREEN);
            lblQuestion7.setForeground(Color.GREEN);
        }
        if (qestionNumber == 8) {
            lblMarks8.setText("10");
            lblMarks8.setForeground(Color.GREEN);
            lblQuestion8.setForeground(Color.GREEN);
        }
        if (qestionNumber == 9) {
            lblMarks9.setText("10");
            lblMarks9.setForeground(Color.GREEN);
            lblQuestion9.setForeground(Color.GREEN);
        }
        if (qestionNumber == 10) {
            lblMarks10.setText("10");
            lblMarks10.setForeground(Color.GREEN);
            lblQuestion10.setForeground(Color.GREEN);
        }

        fMarks = marks;
    }

    public void hardGameWrongAnswer() {
        lblHardDisplay.setText("Last One is Wrong Answer");
        if (qestionNumber == 6) {
            lblMarks6.setText("00");
            lblMarks6.setForeground(Color.red);
            lblQuestion6.setForeground(Color.red);
        }
        if (qestionNumber == 7) {
            lblMarks7.setText("00");
            lblMarks7.setForeground(Color.red);
            lblQuestion7.setForeground(Color.red);
        }
        if (qestionNumber == 8) {
            lblMarks8.setText("00");
            lblMarks8.setForeground(Color.red);
            lblQuestion8.setForeground(Color.red);
        }
        if (qestionNumber == 9) {
            lblMarks9.setText("00");
            lblMarks9.setForeground(Color.red);
            lblQuestion9.setForeground(Color.red);
        }
        if (qestionNumber == 10) {
            lblMarks10.setText("00");
            lblMarks10.setForeground(Color.red);
            lblQuestion10.setForeground(Color.red);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblMarks = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        Health1 = new javax.swing.JLabel();
        Health2 = new javax.swing.JLabel();
        Health3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        pnlEasy = new javax.swing.JPanel();
        lblEasyNum1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblEasyNum2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtEasyAns = new javax.swing.JTextField();
        btnEasyCheck = new javax.swing.JButton();
        lblEasy = new javax.swing.JLabel();
        lblEasyDisplay = new javax.swing.JLabel();
        pnlHard = new javax.swing.JPanel();
        btnHardCheck = new javax.swing.JButton();
        lblHard = new javax.swing.JLabel();
        lblHardNum1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblHardNum2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblHardNum3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtHardAns = new javax.swing.JTextField();
        lblHardDisplay = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lblComplete = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblQuestion1 = new javax.swing.JLabel();
        lblMarks1 = new javax.swing.JLabel();
        lblMarks2 = new javax.swing.JLabel();
        lblQuestion2 = new javax.swing.JLabel();
        lblMarks3 = new javax.swing.JLabel();
        lblQuestion3 = new javax.swing.JLabel();
        lblQuestion4 = new javax.swing.JLabel();
        lblMarks4 = new javax.swing.JLabel();
        lblMarks5 = new javax.swing.JLabel();
        lblQuestion5 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        lblQuestion6 = new javax.swing.JLabel();
        lblQuestion7 = new javax.swing.JLabel();
        lblQuestion8 = new javax.swing.JLabel();
        lblQuestion9 = new javax.swing.JLabel();
        lblQuestion10 = new javax.swing.JLabel();
        lblMarks10 = new javax.swing.JLabel();
        lblMarks9 = new javax.swing.JLabel();
        lblMarks8 = new javax.swing.JLabel();
        lblMarks7 = new javax.swing.JLabel();
        lblMarks6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblErrorMessage = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();

        setBorder(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Level 3");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("MULTIPLICATION");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Marks");

        lblMarks.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblMarks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMarks.setText("00");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Health");

        Health1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Health.png"))); // NOI18N

        Health2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Health.png"))); // NOI18N

        Health3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Health.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Health1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(Health2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(Health3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblMarks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMarks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Health1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Health2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Health3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        pnlEasy.setBackground(new java.awt.Color(204, 255, 255));

        lblEasyNum1.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        lblEasyNum1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEasyNum1.setText("00");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        jLabel3.setText("x");

        lblEasyNum2.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        lblEasyNum2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEasyNum2.setText("00");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        jLabel5.setText("=");

        txtEasyAns.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        txtEasyAns.setText("000");

        btnEasyCheck.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEasyCheck.setText("Check");
        btnEasyCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEasyCheckActionPerformed(evt);
            }
        });

        lblEasy.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lblEasy.setText("Easy");

        lblEasyDisplay.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblEasyDisplay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEasyDisplay.setText("Display");

        javax.swing.GroupLayout pnlEasyLayout = new javax.swing.GroupLayout(pnlEasy);
        pnlEasy.setLayout(pnlEasyLayout);
        pnlEasyLayout.setHorizontalGroup(
            pnlEasyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEasyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEasyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEasyLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnlEasyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEasyLayout.createSequentialGroup()
                                .addComponent(btnEasyCheck)
                                .addGap(45, 45, 45))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEasyLayout.createSequentialGroup()
                                .addComponent(lblEasyNum1)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(lblEasyNum2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtEasyAns, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(118, 118, 118))))
                    .addGroup(pnlEasyLayout.createSequentialGroup()
                        .addGroup(pnlEasyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEasyDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlEasyLayout.createSequentialGroup()
                                .addComponent(lblEasy)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        pnlEasyLayout.setVerticalGroup(
            pnlEasyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEasyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEasy)
                .addGap(13, 13, 13)
                .addGroup(pnlEasyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEasyNum1)
                    .addComponent(jLabel3)
                    .addComponent(lblEasyNum2)
                    .addComponent(jLabel5)
                    .addComponent(txtEasyAns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblEasyDisplay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEasyCheck)
                .addContainerGap())
        );

        pnlHard.setBackground(new java.awt.Color(255, 204, 204));

        btnHardCheck.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnHardCheck.setText("Check");
        btnHardCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHardCheckActionPerformed(evt);
            }
        });

        lblHard.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lblHard.setText("Hard");

        lblHardNum1.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        lblHardNum1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHardNum1.setText("000");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        jLabel8.setText("x");

        lblHardNum2.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        lblHardNum2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHardNum2.setText("000");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        jLabel11.setText("+");

        lblHardNum3.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        lblHardNum3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHardNum3.setText("000");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        jLabel10.setText("=");

        txtHardAns.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        txtHardAns.setText("000");

        lblHardDisplay.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblHardDisplay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHardDisplay.setText("Display");

        javax.swing.GroupLayout pnlHardLayout = new javax.swing.GroupLayout(pnlHard);
        pnlHard.setLayout(pnlHardLayout);
        pnlHardLayout.setHorizontalGroup(
            pnlHardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHardLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHardCheck)
                .addGap(45, 45, 45))
            .addGroup(pnlHardLayout.createSequentialGroup()
                .addGroup(pnlHardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlHardLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblHard))
                    .addGroup(pnlHardLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(lblHardNum1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(lblHardNum2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(lblHardNum3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(txtHardAns, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(88, Short.MAX_VALUE))
            .addGroup(pnlHardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHardDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlHardLayout.setVerticalGroup(
            pnlHardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHard)
                .addGap(17, 17, 17)
                .addGroup(pnlHardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHardNum1)
                    .addComponent(jLabel8)
                    .addComponent(lblHardNum2)
                    .addComponent(jLabel11)
                    .addComponent(lblHardNum3)
                    .addComponent(jLabel10)
                    .addComponent(txtHardAns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblHardDisplay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHardCheck)
                .addContainerGap())
        );

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Write the Correct answer in the textbox");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 102, 102));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("first do the Easy level After that you can do the Hard level");

        lblComplete.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblComplete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblComplete.setText("Complete : 0%");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlHard, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlEasy, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(42, 42, 42))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblComplete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addGap(18, 18, 18)
                .addComponent(pnlEasy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(pnlHard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(8, 8, 8)
                .addComponent(lblComplete)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Scores");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Easy");

        lblQuestion1.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblQuestion1.setText("Question 01");

        lblMarks1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblMarks1.setText("00");

        lblMarks2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblMarks2.setText("00");

        lblQuestion2.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblQuestion2.setText("Question 02");

        lblMarks3.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblMarks3.setText("00");

        lblQuestion3.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblQuestion3.setText("Question 03");

        lblQuestion4.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblQuestion4.setText("Question 04");

        lblMarks4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblMarks4.setText("00");

        lblMarks5.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblMarks5.setText("00");

        lblQuestion5.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblQuestion5.setText("Question 05");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setText("Hard");

        lblQuestion6.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblQuestion6.setText("Question 01");

        lblQuestion7.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblQuestion7.setText("Question 02");

        lblQuestion8.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblQuestion8.setText("Question 03");

        lblQuestion9.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblQuestion9.setText("Question 04");

        lblQuestion10.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblQuestion10.setText("Question 05");

        lblMarks10.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblMarks10.setText("00");

        lblMarks9.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblMarks9.setText("00");

        lblMarks8.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblMarks8.setText("00");

        lblMarks7.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblMarks7.setText("00");

        lblMarks6.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblMarks6.setText("00");

        lblErrorMessage.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblErrorMessage.setForeground(new java.awt.Color(255, 51, 51));
        lblErrorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblErrorMessage.setText("Error Message");

        btnNext.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 6, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                    .addComponent(lblQuestion1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblMarks1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                    .addComponent(lblQuestion2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblMarks2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(lblQuestion3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblMarks3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(lblQuestion4, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblMarks4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(lblQuestion5, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblMarks5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(lblQuestion6, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblMarks6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(lblQuestion7, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblMarks7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(lblQuestion8, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblMarks8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(lblQuestion9, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblMarks9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(lblQuestion10, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblMarks10, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblErrorMessage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuestion1)
                    .addComponent(lblMarks1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuestion2)
                    .addComponent(lblMarks2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuestion3)
                    .addComponent(lblMarks3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuestion4)
                    .addComponent(lblMarks4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuestion5)
                    .addComponent(lblMarks5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuestion6)
                    .addComponent(lblMarks6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuestion7)
                    .addComponent(lblMarks7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuestion8)
                    .addComponent(lblMarks8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuestion9)
                    .addComponent(lblMarks9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuestion10)
                    .addComponent(lblMarks10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblErrorMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNext)
                    .addComponent(btnReset))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEasyCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEasyCheckActionPerformed
        // TODO add your handling code here:
        String answer = txtEasyAns.getText();
        if (answer.equals("")) {
            lblErrorMessage.setText("Textbox is Empty");
            lblErrorMessage.setVisible(true);
        } else {
            easyGameChack();
            levelChack();
            healthChack();
        }
        sendDataToDatabase();
    }//GEN-LAST:event_btnEasyCheckActionPerformed

    private void btnHardCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHardCheckActionPerformed
        // TODO add your handling code here:
        String answer = txtHardAns.getText();
        if (answer.equals("")) {
            lblErrorMessage.setText("Textbox is Empty");
            lblErrorMessage.setVisible(true);
        } else {
            HardGameChack();
            levelChack();
            healthChack();
        }

        sendDataToDatabase();
    }//GEN-LAST:event_btnHardCheckActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        gameNext();
        btnNext.setEnabled(false);
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        resetGame();
    }//GEN-LAST:event_btnResetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Health1;
    private javax.swing.JLabel Health2;
    private javax.swing.JLabel Health3;
    private javax.swing.JButton btnEasyCheck;
    private javax.swing.JButton btnHardCheck;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnReset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblComplete;
    private javax.swing.JLabel lblEasy;
    private javax.swing.JLabel lblEasyDisplay;
    private javax.swing.JLabel lblEasyNum1;
    private javax.swing.JLabel lblEasyNum2;
    private javax.swing.JLabel lblErrorMessage;
    private javax.swing.JLabel lblHard;
    private javax.swing.JLabel lblHardDisplay;
    private javax.swing.JLabel lblHardNum1;
    private javax.swing.JLabel lblHardNum2;
    private javax.swing.JLabel lblHardNum3;
    private javax.swing.JLabel lblMarks;
    private javax.swing.JLabel lblMarks1;
    private javax.swing.JLabel lblMarks10;
    private javax.swing.JLabel lblMarks2;
    private javax.swing.JLabel lblMarks3;
    private javax.swing.JLabel lblMarks4;
    private javax.swing.JLabel lblMarks5;
    private javax.swing.JLabel lblMarks6;
    private javax.swing.JLabel lblMarks7;
    private javax.swing.JLabel lblMarks8;
    private javax.swing.JLabel lblMarks9;
    private javax.swing.JLabel lblQuestion1;
    private javax.swing.JLabel lblQuestion10;
    private javax.swing.JLabel lblQuestion2;
    private javax.swing.JLabel lblQuestion3;
    private javax.swing.JLabel lblQuestion4;
    private javax.swing.JLabel lblQuestion5;
    private javax.swing.JLabel lblQuestion6;
    private javax.swing.JLabel lblQuestion7;
    private javax.swing.JLabel lblQuestion8;
    private javax.swing.JLabel lblQuestion9;
    private javax.swing.JPanel pnlEasy;
    private javax.swing.JPanel pnlHard;
    private javax.swing.JTextField txtEasyAns;
    private javax.swing.JTextField txtHardAns;
    // End of variables declaration//GEN-END:variables
}
