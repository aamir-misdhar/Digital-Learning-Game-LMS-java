/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ICT;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author mmaam
 */
public class NumberSystemAdditionBase8 extends javax.swing.JFrame {

    /**
     * Creates new form NumberSystemAdditionBase8
     */
    String txtText = "";

    String RegisterId = "";

    int complete = 0;
    int health = 3;
    int marks = 0;
    int questonNumber = 0;

    JTextField selectedTextBox;
    JButton selectedButton;

    int correct = 0;
    int wrong = 0;

    public NumberSystemAdditionBase8() {
        initComponents();
        rendomNumbers();
    }

    public void Setdata(String ID) {

        try {
            RegisterId = ID;

            //set user marks
            Connection con = Database.db.getConnection();
            String sql = "SELECT numberSystemAddition10_marks,numberSystemAddition10_complete,numberSystemAddition8_marks,numberSystemAddition8_complete,numberSystemAddition16_marks,numberSystemAddition16_complete,numberSystemAddition2_marks,numberSystemAddition2_complete FROM digital_learning_game.ict where stdRegisterId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String numberSystemAddition10_complete = rs.getString("numberSystemAddition10_complete");
                String numberSystemAddition10_marks = rs.getString("numberSystemAddition10_marks");

                String numberSystemAddition8_complete = rs.getString("numberSystemAddition8_complete");
                String numberSystemAddition8_marks = rs.getString("numberSystemAddition8_marks");

                String numberSystemAddition16_complete = rs.getString("numberSystemAddition16_complete");
                String numberSystemAddition16_marks = rs.getString("numberSystemAddition16_marks");

                String numberSystemAddition2_complete = rs.getString("numberSystemAddition2_complete");
                String numberSystemAddition2_marks = rs.getString("numberSystemAddition2_marks");

                //Set data
                lblSidePnlBase10Complete.setText("Completed : " + numberSystemAddition10_complete + "%");
                lblSidePnlBase10Marks.setText("Score : " + numberSystemAddition10_marks);

                lblSidePnlBase2Complete.setText("Completed : " + numberSystemAddition2_complete + "%");
                lblSidePnlBase2Marks.setText("Score : " + numberSystemAddition2_marks);

                lblSidePnlBase16Complete.setText("Completed : " + numberSystemAddition16_complete + "%");
                lblSidePnlBase16Marks.setText("Score : " + numberSystemAddition16_marks);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NumberSystemAdditionBase8.class.getName()).log(Level.SEVERE, null, ex);
        }

//        // Set User datails
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
            Logger.getLogger(NumberSystemAdditionBase8.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sendDataToDatabase() {
        try {
            // create connection to database
            Connection con = Database.db.getConnection();
            // Create prepared statement with the sql query
            String sql = "UPDATE `digital_learning_game`.`ict` SET `numberSystemAddition8_marks` = '"+marks+"', `numberSystemAddition8_complete` = '"+complete+"' WHERE (`stdRegisterId` = '"+RegisterId+"');";
            PreparedStatement st1 = con.prepareStatement(sql);
            // execute query
            st1.executeUpdate();

            // show success message
            //JOptionPane.showMessageDialog(this, "Successfully Inserted...");
        } catch (SQLException ex) {
            Logger.getLogger(BasicLogicGates.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void topNumberPadDisable() {
        btnNum10.setEnabled(false);
        btnNum20.setEnabled(false);
        btnNum30.setEnabled(false);
        btnNum40.setEnabled(false);
        btnNum50.setEnabled(false);
        btnNum60.setEnabled(false);
        btnNum70.setEnabled(false);
        btnNum80.setEnabled(false);
        btnNum90.setEnabled(false);
        btnNum100.setEnabled(false);

    }

    public void topNumberPadEnable() {
        btnNum10.setEnabled(true);
        btnNum20.setEnabled(true);
        btnNum30.setEnabled(true);
        btnNum40.setEnabled(true);
        btnNum50.setEnabled(true);
        btnNum60.setEnabled(true);
        btnNum70.setEnabled(true);
        btnNum80.setEnabled(true);
        btnNum90.setEnabled(true);
        btnNum100.setEnabled(true);

    }

    public void bottomNumberPadDisable() {
        btnNum0.setEnabled(false);
        btnNum1.setEnabled(false);
        btnNum2.setEnabled(false);
        btnNum3.setEnabled(false);
        btnNum4.setEnabled(false);
        btnNum5.setEnabled(false);
        btnNum6.setEnabled(false);
        btnNum7.setEnabled(false);
        btnNum8.setEnabled(false);
        btnNum9.setEnabled(false);
    }

    public void bottomNumberPadEnable() {
        btnNum0.setEnabled(true);
        btnNum1.setEnabled(true);
        btnNum2.setEnabled(true);
        btnNum3.setEnabled(true);
        btnNum4.setEnabled(true);
        btnNum5.setEnabled(true);
        btnNum6.setEnabled(true);
        btnNum7.setEnabled(true);
        btnNum8.setEnabled(true);
        btnNum9.setEnabled(true);
    }

    public void rendomNumbers() {
        lblErrorMessage.setVisible(false);
        btnNext.setEnabled(false);
        btnNext.setText("Next");

        btnCheck.setEnabled(true);
        topNumberPadDisable();
        bottomNumberPadDisable();
        questonNumber++;
        correct = 0;
        wrong = 0;

        lblQuestionNumber.setText(questonNumber + ".");

        Random rnd = new Random();
        int num1Pos1 = rnd.nextInt(0, 8);
        int num1Pos2 = rnd.nextInt(0, 8);
        int num1Pos3 = rnd.nextInt(0, 8);
        int num1Pos4 = rnd.nextInt(0, 8);

        int num2Pos1 = rnd.nextInt(0, 8);
        int num2Pos2 = rnd.nextInt(0, 8);
        int num2Pos3 = rnd.nextInt(0, 8);
        int num2Pos4 = rnd.nextInt(0, 8);

        lblNum1Pos1.setText(num1Pos1 + "");
        lblNum1Pos2.setText(num1Pos2 + "");
        lblNum1Pos3.setText(num1Pos3 + "");
        lblNum1Pos4.setText(num1Pos4 + "");

        lblNum2Pos1.setText(num2Pos1 + "");
        lblNum2Pos2.setText(num2Pos2 + "");
        lblNum2Pos3.setText(num2Pos3 + "");
        lblNum2Pos4.setText(num2Pos4 + "");

        lblQuestion.setText(num1Pos4 + " " + num1Pos3 + " " + num1Pos2 + " " + num1Pos1 + " + " + num2Pos4 + " " + num2Pos3 + " " + num2Pos2 + " " + num2Pos1 + " = ?");
    }

    // Checking Game
    public void check() {
        checkTtl();
        checkBalance();
        checkNetTotal();

        if (wrong == 0) {
            marks = marks + 10;
        } else {
            health--;
        }

        complete = complete + 10;
        healthCheck();
        lblMarks.setText(marks + "");
        lblComplete.setText("Completed : " + complete + "%");
        btnCheck.setEnabled(false);
        btnNext.setEnabled(true);
        
        sendDataToDatabase();
    }

    public void checkTtl() {
        try {
            //Get Question
            int topBalncPos2 = Integer.valueOf(lblTopBalancePos2.getText());
            int topBalncPos3 = Integer.valueOf(lblTopBalancePos3.getText());
            int topBalncPos4 = Integer.valueOf(lblTopBalancePos4.getText());
            int topBalncPos5 = Integer.valueOf(lblTopBalancePos5.getText());

            int num1Pos1 = Integer.valueOf(lblNum1Pos1.getText());
            int num1Pos2 = Integer.valueOf(lblNum1Pos2.getText());
            int num1Pos3 = Integer.valueOf(lblNum1Pos3.getText());
            int num1Pos4 = Integer.valueOf(lblNum1Pos4.getText());

            int num2Pos1 = Integer.valueOf(lblNum2Pos1.getText());
            int num2Pos2 = Integer.valueOf(lblNum2Pos2.getText());
            int num2Pos3 = Integer.valueOf(lblNum2Pos3.getText());
            int num2Pos4 = Integer.valueOf(lblNum2Pos4.getText());

            //Get User Answer
            int ttlPos1 = Integer.valueOf(txtTtlPos1.getText());
            int ttlPos2 = Integer.valueOf(txtTtlPos2.getText());
            int ttlPos3 = Integer.valueOf(txtTtlPos3.getText());
            int ttlPos4 = Integer.valueOf(txtTtlPos4.getText());

            int balPos1 = Integer.valueOf(txtBalPos1.getText());
            int balPos2 = Integer.valueOf(txtBalPos2.getText());
            int balPos3 = Integer.valueOf(txtBalPos3.getText());
            int balPos4 = Integer.valueOf(txtBalPos4.getText());

            int netTtlPos1 = Integer.valueOf(txtNetTtlPos1.getText());
            int netTtlPos2 = Integer.valueOf(txtNetTtlPos2.getText());
            int netTtlPos3 = Integer.valueOf(txtNetTtlPos3.getText());
            int netTtlPos4 = Integer.valueOf(txtNetTtlPos4.getText());
            int netTtlPos5 = Integer.valueOf(txtNetTtlPos5.getText());

            //Checking First row
            if (ttlPos1 == num1Pos1 + num2Pos1) {
                txtTtlPos1.setForeground(Color.green);
                //marks ingrement
                correct++;
            } else {
                txtTtlPos1.setForeground(Color.red);
                //marks deicreement
                wrong++;
            }

            if (ttlPos2 == num1Pos2 + num2Pos2 + topBalncPos2) {
                txtTtlPos2.setForeground(Color.green);
                //marks ingrement
                correct++;
            } else {
                txtTtlPos2.setForeground(Color.red);
                //marks deicreement
                wrong++;
            }

            if (ttlPos3 == num1Pos3 + num2Pos3 + topBalncPos3) {
                txtTtlPos3.setForeground(Color.green);
                //marks ingrement
                correct++;
            } else {
                txtTtlPos3.setForeground(Color.red);
                //marks deicreement
                wrong++;
            }

            if (ttlPos4 == num1Pos4 + num2Pos4 + topBalncPos4) {
                txtTtlPos4.setForeground(Color.green);
                //marks ingrement
                correct++;
            } else {
                txtTtlPos4.setForeground(Color.red);
                //marks deicreement
                wrong++;
            }

        } catch (NumberFormatException e) {
            lblErrorMessage.setVisible(true);
            lblErrorMessage.setText("Invalid Number");
        }
    }

    public void checkBalance() {

        try {

            //get Data
            int topBalncPos2 = Integer.valueOf(lblTopBalancePos2.getText());
            int topBalncPos3 = Integer.valueOf(lblTopBalancePos3.getText());
            int topBalncPos4 = Integer.valueOf(lblTopBalancePos4.getText());
            int topBalncPos5 = Integer.valueOf(lblTopBalancePos5.getText());

            int num1Pos1 = Integer.valueOf(lblNum1Pos1.getText());
            int num1Pos2 = Integer.valueOf(lblNum1Pos2.getText());
            int num1Pos3 = Integer.valueOf(lblNum1Pos3.getText());
            int num1Pos4 = Integer.valueOf(lblNum1Pos4.getText());

            int num2Pos1 = Integer.valueOf(lblNum2Pos1.getText());
            int num2Pos2 = Integer.valueOf(lblNum2Pos2.getText());
            int num2Pos3 = Integer.valueOf(lblNum2Pos3.getText());
            int num2Pos4 = Integer.valueOf(lblNum2Pos4.getText());

            //Get User Answer
            int ttlPos1 = Integer.valueOf(txtTtlPos1.getText());
            int ttlPos2 = Integer.valueOf(txtTtlPos2.getText());
            int ttlPos3 = Integer.valueOf(txtTtlPos3.getText());
            int ttlPos4 = Integer.valueOf(txtTtlPos4.getText());

            int balPos1 = Integer.valueOf(txtBalPos1.getText());
            int balPos2 = Integer.valueOf(txtBalPos2.getText());
            int balPos3 = Integer.valueOf(txtBalPos3.getText());
            int balPos4 = Integer.valueOf(txtBalPos4.getText());

            int netTtlPos1 = Integer.valueOf(txtNetTtlPos1.getText());
            int netTtlPos2 = Integer.valueOf(txtNetTtlPos2.getText());
            int netTtlPos3 = Integer.valueOf(txtNetTtlPos3.getText());
            int netTtlPos4 = Integer.valueOf(txtNetTtlPos4.getText());
            int netTtlPos5 = Integer.valueOf(txtNetTtlPos5.getText());

            // Cheching Second Row pos1
            if (num1Pos1 + num2Pos1 < 8) {
                if (balPos1 == 0) {
                    txtBalPos1.setForeground(Color.green);
                    correct++;
                } else {
                    txtBalPos1.setForeground(Color.red);
                    wrong++;
                }
            } else if (num1Pos1 + num2Pos1 < 16) {
                if (balPos1 == 8) {
                    txtBalPos1.setForeground(Color.green);
                    correct++;
                } else {
                    txtBalPos1.setForeground(Color.red);
                    wrong++;
                }
            } else if (num1Pos1 + num2Pos1 < 24) {
                if (balPos1 == 16) {
                    txtBalPos1.setForeground(Color.green);
                    correct++;
                } else {
                    txtBalPos1.setForeground(Color.red);
                    wrong++;
                }
            } else {
                txtBalPos1.setForeground(Color.red);
                wrong++;
            }

            // Cheching Second Row pos 2
            if (num1Pos2 + num2Pos2 + topBalncPos2 < 8) {
                if (balPos2 == 0) {
                    txtBalPos2.setForeground(Color.green);
                    correct++;
                } else {
                    txtBalPos2.setForeground(Color.red);
                    wrong++;
                }
            } else if (num1Pos2 + num2Pos2 + topBalncPos2 < 16) {
                if (balPos2 == 8) {
                    txtBalPos2.setForeground(Color.green);
                    correct++;
                } else {
                    txtBalPos2.setForeground(Color.red);
                    wrong++;
                }
            } else if (num1Pos2 + num2Pos2 + topBalncPos2 < 24) {
                if (balPos2 == 16) {
                    txtBalPos2.setForeground(Color.green);
                    correct++;
                } else {
                    txtBalPos2.setForeground(Color.red);
                    wrong++;
                }
            } else {
                txtBalPos2.setForeground(Color.red);
                wrong++;
            }

            // Cheching Second Row pos 3
            if (num1Pos3 + num2Pos3 + topBalncPos3 < 8) {
                if (balPos3 == 0) {
                    txtBalPos3.setForeground(Color.green);
                    correct++;
                } else {
                    txtBalPos3.setForeground(Color.red);
                    wrong++;
                }
            } else if (num1Pos3 + num2Pos3 + topBalncPos3 < 16) {
                if (balPos3 == 8) {
                    txtBalPos3.setForeground(Color.green);
                    correct++;
                } else {
                    txtBalPos3.setForeground(Color.red);
                    wrong++;
                }
            } else if (num1Pos3 + num2Pos3 + topBalncPos3 < 24) {
                if (balPos3 == 16) {
                    txtBalPos3.setForeground(Color.green);
                    correct++;
                } else {
                    txtBalPos3.setForeground(Color.red);
                    wrong++;
                }
            } else {
                txtBalPos3.setForeground(Color.red);
                wrong++;
            }

            // Cheching Second Row pos 4
            if (num1Pos4 + num2Pos4 + topBalncPos4 < 8) {
                if (balPos4 == 0) {
                    txtBalPos4.setForeground(Color.green);
                    correct++;
                } else {
                    txtBalPos4.setForeground(Color.red);
                    wrong++;
                }
            } else if (num1Pos4 + num2Pos4 + topBalncPos4 < 16) {
                if (balPos4 == 8) {
                    txtBalPos4.setForeground(Color.green);
                    correct++;
                } else {
                    txtBalPos4.setForeground(Color.red);
                    wrong++;
                }
            } else if (num1Pos4 + num2Pos4 + topBalncPos4 < 24) {
                if (balPos4 == 16) {
                    txtBalPos4.setForeground(Color.green);
                    correct++;
                } else {
                    txtBalPos4.setForeground(Color.red);
                    wrong++;
                }
            } else {
                txtBalPos4.setForeground(Color.red);
                wrong++;
            }

        } catch (NumberFormatException e) {
            lblErrorMessage.setVisible(true);
            lblErrorMessage.setText("Invalid Number");

        }
    }

    public void checkNetTotal() {
        try {
            //Get Question
            int topBalncPos2 = Integer.valueOf(lblTopBalancePos2.getText());
            int topBalncPos3 = Integer.valueOf(lblTopBalancePos3.getText());
            int topBalncPos4 = Integer.valueOf(lblTopBalancePos4.getText());
            int topBalncPos5 = Integer.valueOf(lblTopBalancePos5.getText());

            int num1Pos1 = Integer.valueOf(lblNum1Pos1.getText());
            int num1Pos2 = Integer.valueOf(lblNum1Pos2.getText());
            int num1Pos3 = Integer.valueOf(lblNum1Pos3.getText());
            int num1Pos4 = Integer.valueOf(lblNum1Pos4.getText());

            int num2Pos1 = Integer.valueOf(lblNum2Pos1.getText());
            int num2Pos2 = Integer.valueOf(lblNum2Pos2.getText());
            int num2Pos3 = Integer.valueOf(lblNum2Pos3.getText());
            int num2Pos4 = Integer.valueOf(lblNum2Pos4.getText());

            //Get User Answer
            int ttlPos1 = Integer.valueOf(txtTtlPos1.getText());
            int ttlPos2 = Integer.valueOf(txtTtlPos2.getText());
            int ttlPos3 = Integer.valueOf(txtTtlPos3.getText());
            int ttlPos4 = Integer.valueOf(txtTtlPos4.getText());

            int balPos1 = Integer.valueOf(txtBalPos1.getText());
            int balPos2 = Integer.valueOf(txtBalPos2.getText());
            int balPos3 = Integer.valueOf(txtBalPos3.getText());
            int balPos4 = Integer.valueOf(txtBalPos4.getText());

            int netTtlPos1 = Integer.valueOf(txtNetTtlPos1.getText());
            int netTtlPos2 = Integer.valueOf(txtNetTtlPos2.getText());
            int netTtlPos3 = Integer.valueOf(txtNetTtlPos3.getText());
            int netTtlPos4 = Integer.valueOf(txtNetTtlPos4.getText());
            int netTtlPos5 = Integer.valueOf(txtNetTtlPos5.getText());

            //Checking net ttl pos1
            if (num1Pos1 + num2Pos1 < 8) {
                if (netTtlPos1 == num1Pos1 + num2Pos1 - 0) {
                    txtNetTtlPos1.setForeground(Color.green);
                    correct++;
                } else {
                    txtNetTtlPos1.setForeground(Color.red);
                    wrong++;
                }
            } else if (num1Pos1 + num2Pos1 < 16) {
                if (netTtlPos1 == num1Pos1 + num2Pos1 - 8) {
                    txtNetTtlPos1.setForeground(Color.green);
                    correct++;
                } else {
                    txtNetTtlPos1.setForeground(Color.red);
                    wrong++;
                }
            } else if (num1Pos1 + num2Pos1 < 24) {
                if (netTtlPos1 == num1Pos1 + num2Pos1 - 16) {
                    txtNetTtlPos1.setForeground(Color.green);
                    correct++;
                } else {
                    txtNetTtlPos1.setForeground(Color.red);
                    wrong++;
                }
            } else {
                txtNetTtlPos1.setForeground(Color.red);
                wrong++;
            }

            //Checking net ttl pos2
            if (num1Pos2 + num2Pos2 + topBalncPos2 < 8) {
                if (netTtlPos2 == num1Pos2 + num2Pos2 + topBalncPos2 - 0) {
                    txtNetTtlPos2.setForeground(Color.green);
                    correct++;
                } else {
                    txtNetTtlPos2.setForeground(Color.red);
                    wrong++;
                }
            } else if (num1Pos2 + num2Pos2 + topBalncPos2 < 16) {
                if (netTtlPos2 == num1Pos2 + num2Pos2 + topBalncPos2 - 8) {
                    txtNetTtlPos2.setForeground(Color.green);
                    correct++;
                } else {
                    txtNetTtlPos2.setForeground(Color.red);
                    wrong++;
                }
            } else if (num1Pos2 + num2Pos2 + topBalncPos2 < 24) {
                if (netTtlPos2 == num1Pos2 + num2Pos2 + topBalncPos2 - 16) {
                    txtNetTtlPos2.setForeground(Color.green);
                    correct++;
                } else {
                    txtNetTtlPos2.setForeground(Color.red);
                    wrong++;
                }
            } else {
                txtNetTtlPos2.setForeground(Color.red);
                wrong++;
            }

            //Checking net ttl pos3
            if (num1Pos3 + num2Pos3 + topBalncPos3 < 8) {
                if (netTtlPos3 == num1Pos3 + num2Pos3 + topBalncPos3 - 0) {
                    txtNetTtlPos3.setForeground(Color.green);
                    correct++;
                } else {
                    txtNetTtlPos3.setForeground(Color.red);
                    wrong++;
                }
            } else if (num1Pos3 + num2Pos3 + topBalncPos3 < 16) {
                if (netTtlPos3 == num1Pos3 + num2Pos3 + topBalncPos3 - 8) {
                    txtNetTtlPos3.setForeground(Color.green);
                    correct++;
                } else {
                    txtNetTtlPos3.setForeground(Color.red);
                    wrong++;
                }
            } else if (num1Pos3 + num2Pos3 + topBalncPos3 < 24) {
                if (netTtlPos3 == num1Pos3 + num2Pos3 + topBalncPos3 - 16) {
                    txtNetTtlPos3.setForeground(Color.green);
                    correct++;
                } else {
                    txtNetTtlPos3.setForeground(Color.red);
                    wrong++;
                }
            } else {
                txtNetTtlPos3.setForeground(Color.red);
                wrong++;
            }

            //Checking net ttl pos4
            if (num1Pos4 + num2Pos4 + topBalncPos4 < 8) {
                if (netTtlPos4 == num1Pos4 + num2Pos4 + topBalncPos4 - 0) {
                    txtNetTtlPos4.setForeground(Color.green);
                    correct++;
                } else {
                    txtNetTtlPos4.setForeground(Color.red);
                    wrong++;
                }
            } else if (num1Pos4 + num2Pos4 + topBalncPos4 < 16) {
                if (netTtlPos4 == num1Pos4 + num2Pos4 + topBalncPos4 - 8) {
                    txtNetTtlPos4.setForeground(Color.green);
                    correct++;
                } else {
                    txtNetTtlPos4.setForeground(Color.red);
                    wrong++;
                }
            } else if (num1Pos4 + num2Pos4 + topBalncPos4 < 24) {
                if (netTtlPos4 == num1Pos4 + num2Pos4 + topBalncPos4 - 16) {
                    txtNetTtlPos4.setForeground(Color.green);
                    correct++;
                } else {
                    txtNetTtlPos4.setForeground(Color.red);
                    wrong++;
                }
            } else {
                txtNetTtlPos4.setForeground(Color.red);
                wrong++;
            }

            //Checking net ttl pos4
            if (topBalncPos5 == netTtlPos5) {
                txtNetTtlPos5.setForeground(Color.green);
                correct++;
            } else {
                txtNetTtlPos5.setForeground(Color.red);
                wrong++;
            }

        } catch (NumberFormatException e) {
            lblErrorMessage.setVisible(true);
            lblErrorMessage.setText("Invalid Number");

        }
    }

    //Health Check
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

            disableAll();
            lblErrorMessage.setVisible(true);
            lblErrorMessage.setText("Your Health is Over");
        }
    }

    public void clearAll() {
        lblTopBalancePos2.setText("0");
        lblTopBalancePos2.setText("0");
        lblTopBalancePos3.setText("0");
        lblTopBalancePos4.setText("0");
        lblTopBalancePos5.setText("0");

        txtTtlPos1.setText("0");
        txtTtlPos2.setText("0");
        txtTtlPos3.setText("0");
        txtTtlPos4.setText("0");

        txtBalPos1.setText("0");
        txtBalPos2.setText("0");
        txtBalPos3.setText("0");
        txtBalPos4.setText("0");

        txtNetTtlPos1.setText("0");
        txtNetTtlPos2.setText("0");
        txtNetTtlPos3.setText("0");
        txtNetTtlPos4.setText("0");
        txtNetTtlPos5.setText("0");

        //Colour CHange
        txtTtlPos1.setForeground(Color.black);
        txtTtlPos2.setForeground(Color.black);
        txtTtlPos3.setForeground(Color.black);
        txtTtlPos4.setForeground(Color.black);

        txtBalPos1.setForeground(new Color(0, 51, 153));
        txtBalPos2.setForeground(new Color(0, 51, 153));
        txtBalPos3.setForeground(new Color(0, 51, 153));
        txtBalPos4.setForeground(new Color(0, 51, 153));

        txtNetTtlPos1.setForeground(Color.black);
        txtNetTtlPos2.setForeground(Color.black);
        txtNetTtlPos3.setForeground(Color.black);
        txtNetTtlPos4.setForeground(Color.black);
        txtNetTtlPos5.setForeground(Color.black);

    }

    //full game
    public void disableAll() {
        txtTtlPos1.setEnabled(false);
        txtTtlPos2.setEnabled(false);
        txtTtlPos3.setEnabled(false);
        txtTtlPos4.setEnabled(false);

        txtBalPos1.setEnabled(false);
        txtBalPos2.setEnabled(false);
        txtBalPos3.setEnabled(false);
        txtBalPos4.setEnabled(false);

        txtNetTtlPos1.setEnabled(false);
        txtNetTtlPos2.setEnabled(false);
        txtNetTtlPos3.setEnabled(false);
        txtNetTtlPos4.setEnabled(false);
        txtNetTtlPos5.setEnabled(false);

        btnNext.setEnabled(false);
        btnCheck.setEnabled(false);

        topNumberPadDisable();
        bottomNumberPadDisable();
        clearAll();

    }

    public void enableAll() {
        txtTtlPos1.setEnabled(true);
        txtTtlPos2.setEnabled(true);
        txtTtlPos3.setEnabled(true);
        txtTtlPos4.setEnabled(true);

        txtBalPos1.setEnabled(true);
        txtBalPos2.setEnabled(true);
        txtBalPos3.setEnabled(true);
        txtBalPos4.setEnabled(true);

        txtNetTtlPos1.setEnabled(true);
        txtNetTtlPos2.setEnabled(true);
        txtNetTtlPos3.setEnabled(true);
        txtNetTtlPos4.setEnabled(true);
        txtNetTtlPos5.setEnabled(true);

        topNumberPadDisable();
        bottomNumberPadDisable();
        clearAll();

    }

    public void resetGame() {
        complete = 0;
        health = 3;
        marks = 0;
        questonNumber = 0;

        enableAll();
        clearAll();
        setdefaultBorderColour();

        healthCheck();
        rendomNumbers();

        lblMarks.setText(marks + "");
        lblComplete.setText("Completed : " + complete + "%");

    }

    //================================== Key Board ====================================
    public void keypad() {
        String crntNum = selectedTextBox.getText();
        String keyNum = selectedButton.getText();

        if (crntNum.equals("0")) {
            crntNum = "";
            selectedTextBox.setText(crntNum + keyNum);
        } else {
            selectedTextBox.setText(crntNum + keyNum);
        }

    }

    public void selectedTextBoxBorder() {
        setdefaultBorderColour();
        selectedTextBox.setBorder(BorderFactory.createLineBorder(Color.blue, 2));
    }

    public void setdefaultBorderColour() {
        txtTtlPos1.setBorder(BorderFactory.createEmptyBorder());
        txtTtlPos2.setBorder(BorderFactory.createEmptyBorder());
        txtTtlPos3.setBorder(BorderFactory.createEmptyBorder());
        txtTtlPos4.setBorder(BorderFactory.createEmptyBorder());

        txtBalPos1.setBorder(BorderFactory.createEmptyBorder());
        txtBalPos2.setBorder(BorderFactory.createEmptyBorder());
        txtBalPos3.setBorder(BorderFactory.createEmptyBorder());
        txtBalPos4.setBorder(BorderFactory.createEmptyBorder());

        txtNetTtlPos1.setBorder(BorderFactory.createEmptyBorder());
        txtNetTtlPos2.setBorder(BorderFactory.createEmptyBorder());
        txtNetTtlPos3.setBorder(BorderFactory.createEmptyBorder());
        txtNetTtlPos4.setBorder(BorderFactory.createEmptyBorder());
        txtNetTtlPos5.setBorder(BorderFactory.createEmptyBorder());
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
        lblSidePnlBase10Complete = new javax.swing.JLabel();
        lblSidePnlBase10Marks = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        lblSidePnlWelcomeName = new javax.swing.JLabel();
        lblSidePnlUsername = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jProgressBar2 = new javax.swing.JProgressBar();
        lblSidePnlBase2Complete = new javax.swing.JLabel();
        lblSidePnlBase2Marks = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jProgressBar3 = new javax.swing.JProgressBar();
        lblSidePnlBase16Complete = new javax.swing.JLabel();
        lblSidePnlBase16Marks = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblMarks = new javax.swing.JLabel();
        lblHealth1 = new javax.swing.JLabel();
        lblHealth2 = new javax.swing.JLabel();
        lblHealth3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblNum1Pos4 = new javax.swing.JLabel();
        lblNum1Pos3 = new javax.swing.JLabel();
        lblNum1Pos2 = new javax.swing.JLabel();
        lblNum1Pos1 = new javax.swing.JLabel();
        lblNum2Pos1 = new javax.swing.JLabel();
        lblNum2Pos2 = new javax.swing.JLabel();
        lblNum2Pos3 = new javax.swing.JLabel();
        lblNum2Pos4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txtTtlPos1 = new javax.swing.JTextField();
        txtTtlPos2 = new javax.swing.JTextField();
        txtTtlPos3 = new javax.swing.JTextField();
        txtTtlPos4 = new javax.swing.JTextField();
        txtBalPos4 = new javax.swing.JTextField();
        txtBalPos3 = new javax.swing.JTextField();
        txtBalPos2 = new javax.swing.JTextField();
        txtBalPos1 = new javax.swing.JTextField();
        lblTopBalancePos4 = new javax.swing.JLabel();
        lblTopBalancePos3 = new javax.swing.JLabel();
        lblTopBalancePos2 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        txtNetTtlPos1 = new javax.swing.JTextField();
        txtNetTtlPos2 = new javax.swing.JTextField();
        txtNetTtlPos3 = new javax.swing.JTextField();
        txtNetTtlPos4 = new javax.swing.JTextField();
        txtNetTtlPos5 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        lblQuestionNumber = new javax.swing.JLabel();
        lblQuestion = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        btnNext = new javax.swing.JButton();
        btnCheck = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        lblTopBalancePos5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnNum0 = new javax.swing.JButton();
        btnNum2 = new javax.swing.JButton();
        btnNum1 = new javax.swing.JButton();
        btnNum3 = new javax.swing.JButton();
        btnNum4 = new javax.swing.JButton();
        btnNum5 = new javax.swing.JButton();
        btnNum6 = new javax.swing.JButton();
        btnNum7 = new javax.swing.JButton();
        btnNum8 = new javax.swing.JButton();
        btnNum9 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        btnNum20 = new javax.swing.JButton();
        btnNum100 = new javax.swing.JButton();
        btnNum70 = new javax.swing.JButton();
        btnNum40 = new javax.swing.JButton();
        btnNum80 = new javax.swing.JButton();
        btnNum60 = new javax.swing.JButton();
        btnNum10 = new javax.swing.JButton();
        btnNum50 = new javax.swing.JButton();
        btnNum30 = new javax.swing.JButton();
        btnNum90 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        lblComplete = new javax.swing.JLabel();
        lblErrorMessage = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

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
        jLabel9.setText("Base 10");

        lblSidePnlBase10Complete.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblSidePnlBase10Complete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSidePnlBase10Complete.setText("Completed : 0%");

        lblSidePnlBase10Marks.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSidePnlBase10Marks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSidePnlBase10Marks.setText("Score : 00");

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
                    .addComponent(lblSidePnlBase10Complete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSidePnlBase10Marks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(lblSidePnlBase10Complete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSidePnlBase10Marks)
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

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Base 2");

        lblSidePnlBase2Complete.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblSidePnlBase2Complete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSidePnlBase2Complete.setText("Completed : 0%");

        lblSidePnlBase2Marks.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSidePnlBase2Marks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSidePnlBase2Marks.setText("Score : 00");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jProgressBar2, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(lblSidePnlBase2Complete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSidePnlBase2Marks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSidePnlBase2Complete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSidePnlBase2Marks)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Base 16");

        lblSidePnlBase16Complete.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblSidePnlBase16Complete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSidePnlBase16Complete.setText("Completed : 0%");

        lblSidePnlBase16Marks.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSidePnlBase16Marks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSidePnlBase16Marks.setText("Score : 00");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jProgressBar3, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(lblSidePnlBase16Complete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSidePnlBase16Marks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSidePnlBase16Complete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSidePnlBase16Marks)
                .addContainerGap(18, Short.MAX_VALUE))
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
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        jLabel1.setText("NumberSystem");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Addition Base 8");

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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblMarks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
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

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        lblNum1Pos4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblNum1Pos4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNum1Pos4.setText("0");

        lblNum1Pos3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblNum1Pos3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNum1Pos3.setText("0");

        lblNum1Pos2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblNum1Pos2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNum1Pos2.setText("0");

        lblNum1Pos1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblNum1Pos1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNum1Pos1.setText("0");

        lblNum2Pos1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblNum2Pos1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNum2Pos1.setText("0");

        lblNum2Pos2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblNum2Pos2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNum2Pos2.setText("0");

        lblNum2Pos3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblNum2Pos3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNum2Pos3.setText("0");

        lblNum2Pos4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblNum2Pos4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNum2Pos4.setText("0");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("+");

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        txtTtlPos1.setBackground(new java.awt.Color(242, 242, 242));
        txtTtlPos1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        txtTtlPos1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTtlPos1.setText("0");
        txtTtlPos1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTtlPos1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTtlPos1FocusLost(evt);
            }
        });

        txtTtlPos2.setBackground(new java.awt.Color(242, 242, 242));
        txtTtlPos2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        txtTtlPos2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTtlPos2.setText("0");
        txtTtlPos2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTtlPos2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTtlPos2FocusLost(evt);
            }
        });

        txtTtlPos3.setBackground(new java.awt.Color(242, 242, 242));
        txtTtlPos3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        txtTtlPos3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTtlPos3.setText("0");
        txtTtlPos3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTtlPos3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTtlPos3FocusLost(evt);
            }
        });

        txtTtlPos4.setBackground(new java.awt.Color(242, 242, 242));
        txtTtlPos4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        txtTtlPos4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTtlPos4.setText("0");
        txtTtlPos4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTtlPos4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTtlPos4FocusLost(evt);
            }
        });

        txtBalPos4.setBackground(new java.awt.Color(242, 242, 242));
        txtBalPos4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        txtBalPos4.setForeground(new java.awt.Color(0, 51, 153));
        txtBalPos4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBalPos4.setText("0");
        txtBalPos4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBalPos4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBalPos4FocusLost(evt);
            }
        });

        txtBalPos3.setBackground(new java.awt.Color(242, 242, 242));
        txtBalPos3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        txtBalPos3.setForeground(new java.awt.Color(0, 51, 153));
        txtBalPos3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBalPos3.setText("0");
        txtBalPos3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBalPos3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBalPos3FocusLost(evt);
            }
        });

        txtBalPos2.setBackground(new java.awt.Color(242, 242, 242));
        txtBalPos2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        txtBalPos2.setForeground(new java.awt.Color(0, 51, 153));
        txtBalPos2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBalPos2.setText("0");
        txtBalPos2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBalPos2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBalPos2FocusLost(evt);
            }
        });

        txtBalPos1.setBackground(new java.awt.Color(242, 242, 242));
        txtBalPos1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        txtBalPos1.setForeground(new java.awt.Color(0, 51, 153));
        txtBalPos1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBalPos1.setText("0");
        txtBalPos1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBalPos1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBalPos1FocusLost(evt);
            }
        });

        lblTopBalancePos4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTopBalancePos4.setForeground(new java.awt.Color(204, 102, 0));
        lblTopBalancePos4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTopBalancePos4.setText("0");

        lblTopBalancePos3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTopBalancePos3.setForeground(new java.awt.Color(204, 102, 0));
        lblTopBalancePos3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTopBalancePos3.setText("0");

        lblTopBalancePos2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTopBalancePos2.setForeground(new java.awt.Color(204, 102, 0));
        lblTopBalancePos2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTopBalancePos2.setText("0");

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));

        txtNetTtlPos1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        txtNetTtlPos1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNetTtlPos1.setText("0");
        txtNetTtlPos1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNetTtlPos1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNetTtlPos1FocusLost(evt);
            }
        });

        txtNetTtlPos2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        txtNetTtlPos2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNetTtlPos2.setText("0");
        txtNetTtlPos2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNetTtlPos2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNetTtlPos2FocusLost(evt);
            }
        });

        txtNetTtlPos3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        txtNetTtlPos3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNetTtlPos3.setText("0");
        txtNetTtlPos3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNetTtlPos3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNetTtlPos3FocusLost(evt);
            }
        });

        txtNetTtlPos4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        txtNetTtlPos4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNetTtlPos4.setText("0");
        txtNetTtlPos4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNetTtlPos4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNetTtlPos4FocusLost(evt);
            }
        });

        txtNetTtlPos5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        txtNetTtlPos5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNetTtlPos5.setText("0");
        txtNetTtlPos5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNetTtlPos5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNetTtlPos5FocusLost(evt);
            }
        });

        lblQuestionNumber.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblQuestionNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQuestionNumber.setText("01.");

        lblQuestion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblQuestion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQuestion.setText("0 0 0 0 + 0 0 0 0 = ?");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblQuestionNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblQuestionNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                    .addComponent(lblQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnNext.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnNext.setText("Next ");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnCheck.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnCheck.setText("Chack");
        btnCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblTopBalancePos5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTopBalancePos5.setForeground(new java.awt.Color(204, 102, 0));
        lblTopBalancePos5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTopBalancePos5.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addGap(75, 75, 75)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(lblNum1Pos4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblNum1Pos3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblNum1Pos2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblNum1Pos1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblNum2Pos4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblNum2Pos3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblNum2Pos2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblNum2Pos1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(lblTopBalancePos5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblTopBalancePos4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblTopBalancePos3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblTopBalancePos2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(65, 65, 65)))
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(txtTtlPos4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtTtlPos3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtTtlPos2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtTtlPos1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(txtBalPos4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtBalPos3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtBalPos2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtBalPos1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(txtNetTtlPos5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNetTtlPos4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(txtNetTtlPos3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNetTtlPos2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNetTtlPos1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 176, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTopBalancePos4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTopBalancePos3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTopBalancePos2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTopBalancePos5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNum1Pos4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNum1Pos3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNum1Pos2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNum1Pos1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNum2Pos4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNum2Pos3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNum2Pos2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNum2Pos1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTtlPos1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTtlPos2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTtlPos3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTtlPos4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBalPos1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBalPos2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBalPos3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBalPos4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNetTtlPos1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNetTtlPos2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNetTtlPos3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNetTtlPos4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNetTtlPos5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        btnNum0.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnNum0.setText("0");
        btnNum0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNum0ActionPerformed(evt);
            }
        });

        btnNum2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnNum2.setText("2");
        btnNum2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNum2ActionPerformed(evt);
            }
        });

        btnNum1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnNum1.setText("1");
        btnNum1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNum1ActionPerformed(evt);
            }
        });

        btnNum3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnNum3.setText("3");
        btnNum3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNum3ActionPerformed(evt);
            }
        });

        btnNum4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnNum4.setText("4");
        btnNum4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNum4ActionPerformed(evt);
            }
        });

        btnNum5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnNum5.setText("5");
        btnNum5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNum5ActionPerformed(evt);
            }
        });

        btnNum6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnNum6.setText("6");
        btnNum6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNum6ActionPerformed(evt);
            }
        });

        btnNum7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnNum7.setText("7");
        btnNum7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNum7ActionPerformed(evt);
            }
        });

        btnNum8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnNum8.setText("8");
        btnNum8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNum8ActionPerformed(evt);
            }
        });

        btnNum9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnNum9.setText("9");
        btnNum9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNum9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnNum7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNum8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNum9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnNum4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNum5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNum6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnNum1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(btnNum2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNum3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnNum0, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNum8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNum7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNum9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNum5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNum4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNum6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNum2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNum1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNum3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNum0, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnNum20.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnNum20.setText("16");
        btnNum20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNum20ActionPerformed(evt);
            }
        });

        btnNum100.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnNum100.setText("80");
        btnNum100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNum100ActionPerformed(evt);
            }
        });

        btnNum70.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnNum70.setText("56");
        btnNum70.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNum70ActionPerformed(evt);
            }
        });

        btnNum40.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnNum40.setText("32");
        btnNum40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNum40ActionPerformed(evt);
            }
        });

        btnNum80.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnNum80.setText("64");
        btnNum80.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNum80ActionPerformed(evt);
            }
        });

        btnNum60.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnNum60.setText("48");
        btnNum60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNum60ActionPerformed(evt);
            }
        });

        btnNum10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnNum10.setText("8");
        btnNum10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNum10ActionPerformed(evt);
            }
        });

        btnNum50.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnNum50.setText("40");
        btnNum50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNum50ActionPerformed(evt);
            }
        });

        btnNum30.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnNum30.setText("24");
        btnNum30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNum30ActionPerformed(evt);
            }
        });

        btnNum90.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnNum90.setText("72");
        btnNum90.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNum90ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(btnNum60, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNum70, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNum80, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNum90, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNum100, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(btnNum10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNum20, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNum30, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNum40, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNum50, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNum60, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNum70, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNum80, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNum90, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNum100, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNum10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNum20, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNum30, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNum40, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNum50, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));

        lblComplete.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblComplete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblComplete.setText("Completed : 0%");

        lblErrorMessage.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblErrorMessage.setForeground(new java.awt.Color(204, 0, 0));
        lblErrorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblErrorMessage.setText("Error Message");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("You Can Use This Keyboard Also");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator4)
                    .addComponent(jSeparator5)
                    .addComponent(lblComplete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblErrorMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblComplete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrorMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        NumberSystem numberSys = new NumberSystem();
        numberSys.Setdata(RegisterId);
        numberSys.show();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtTtlPos1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTtlPos1FocusGained
        // TODO add your handling code here:
        topNumberPadDisable();
        bottomNumberPadEnable();
        selectedTextBox = txtTtlPos1;
        selectedTextBoxBorder();

        txtTtlPos1.setText("");
    }//GEN-LAST:event_txtTtlPos1FocusGained

    private void txtTtlPos1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTtlPos1FocusLost
        // TODO add your handling code here:
        JTextField focustFeild = txtTtlPos1;
        if (focustFeild.getText().equals("")) {
            focustFeild.setText("0");
        }
    }//GEN-LAST:event_txtTtlPos1FocusLost

    private void txtTtlPos2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTtlPos2FocusGained
        // TODO add your handling code here:
        topNumberPadDisable();
        bottomNumberPadEnable();
        selectedTextBox = txtTtlPos2;
        selectedTextBoxBorder();

        txtTtlPos2.setText("");
    }//GEN-LAST:event_txtTtlPos2FocusGained

    private void txtTtlPos2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTtlPos2FocusLost
        // TODO add your handling code here:
        JTextField focustFeild = txtTtlPos2;
        if (focustFeild.getText().equals("")) {
            focustFeild.setText("0");
        }
    }//GEN-LAST:event_txtTtlPos2FocusLost

    private void txtTtlPos3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTtlPos3FocusGained
        // TODO add your handling code here:
        topNumberPadDisable();
        bottomNumberPadEnable();
        selectedTextBox = txtTtlPos3;
        selectedTextBoxBorder();

        txtTtlPos3.setText("");
    }//GEN-LAST:event_txtTtlPos3FocusGained

    private void txtTtlPos3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTtlPos3FocusLost
        // TODO add your handling code here:
        JTextField focustFeild = txtTtlPos3;
        if (focustFeild.getText().equals("")) {
            focustFeild.setText("0");
        }
    }//GEN-LAST:event_txtTtlPos3FocusLost

    private void txtTtlPos4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTtlPos4FocusGained
        topNumberPadDisable();
        bottomNumberPadEnable();
        selectedTextBox = txtTtlPos4;
        selectedTextBoxBorder();

        txtTtlPos4.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_txtTtlPos4FocusGained

    private void txtTtlPos4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTtlPos4FocusLost
        // TODO add your handling code here:
        JTextField focustFeild = txtTtlPos4;
        if (focustFeild.getText().equals("")) {
            focustFeild.setText("0");
        }
    }//GEN-LAST:event_txtTtlPos4FocusLost

    private void txtBalPos4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBalPos4FocusGained
        // TODO add your handling code here:
        topNumberPadEnable();
        bottomNumberPadDisable();
        selectedTextBox = txtBalPos4;
        selectedTextBoxBorder();

        txtBalPos4.setText("");
    }//GEN-LAST:event_txtBalPos4FocusGained

    private void txtBalPos4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBalPos4FocusLost
        // TODO add your handling code here:
        JTextField focustFeild = txtBalPos4;
        JLabel focusedLabel = lblTopBalancePos5;

        try {
            if (focustFeild.getText().equals("")) {
                focustFeild.setText("0");
            } else {
                if (Integer.valueOf(focustFeild.getText()) < 8) {
                    focusedLabel.setText("0");
                } else if (Integer.valueOf(focustFeild.getText()) < 16) {
                    focusedLabel.setText("1");
                } else if (Integer.valueOf(focustFeild.getText()) < 24) {
                    focusedLabel.setText("2");
                } else {
                    focusedLabel.setText("3");
                }
            }
        } catch (NumberFormatException e) {
            lblErrorMessage.setVisible(true);
            lblErrorMessage.setText("Inalid Number");
        }
    }//GEN-LAST:event_txtBalPos4FocusLost

    private void txtBalPos3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBalPos3FocusGained
        // TODO add your handling code here:
        topNumberPadEnable();
        bottomNumberPadDisable();
        selectedTextBox = txtBalPos3;
        selectedTextBoxBorder();

        txtBalPos3.setText("");
    }//GEN-LAST:event_txtBalPos3FocusGained

    private void txtBalPos3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBalPos3FocusLost
        // TODO add your handling code here:
        JTextField focustFeild = txtBalPos3;
        JLabel focusedLabel = lblTopBalancePos4;

        try {
            if (focustFeild.getText().equals("")) {
                focustFeild.setText("0");
            } else {
                if (Integer.valueOf(focustFeild.getText()) < 8) {
                    focusedLabel.setText("0");
                } else if (Integer.valueOf(focustFeild.getText()) < 16) {
                    focusedLabel.setText("1");
                } else if (Integer.valueOf(focustFeild.getText()) < 24) {
                    focusedLabel.setText("2");
                } else {
                    focusedLabel.setText("3");
                }
            }
        } catch (NumberFormatException e) {
            lblErrorMessage.setVisible(true);
            lblErrorMessage.setText("Inalid Number");
        }
    }//GEN-LAST:event_txtBalPos3FocusLost

    private void txtBalPos2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBalPos2FocusGained
        // TODO add your handling code here:
        topNumberPadEnable();
        bottomNumberPadDisable();
        selectedTextBox = txtBalPos2;
        selectedTextBoxBorder();

        txtBalPos2.setText("");
    }//GEN-LAST:event_txtBalPos2FocusGained

    private void txtBalPos2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBalPos2FocusLost
        // TODO add your handling code here:
        JTextField focustFeild = txtBalPos2;
        JLabel focusedLabel = lblTopBalancePos3;

        try {
            if (focustFeild.getText().equals("")) {
                focustFeild.setText("0");
            } else {
                if (Integer.valueOf(focustFeild.getText()) < 8) {
                    focusedLabel.setText("0");
                } else if (Integer.valueOf(focustFeild.getText()) < 16) {
                    focusedLabel.setText("1");
                } else if (Integer.valueOf(focustFeild.getText()) < 24) {
                    focusedLabel.setText("2");
                } else {
                    focusedLabel.setText("3");
                }
            }
        } catch (NumberFormatException e) {
            lblErrorMessage.setVisible(true);
            lblErrorMessage.setText("Inalid Number");
        }
    }//GEN-LAST:event_txtBalPos2FocusLost

    private void txtBalPos1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBalPos1FocusGained
        // TODO add your handling code here:
        topNumberPadEnable();
        bottomNumberPadDisable();
        selectedTextBox = txtBalPos1;
        selectedTextBoxBorder();

        txtBalPos1.setText("");
    }//GEN-LAST:event_txtBalPos1FocusGained

    private void txtBalPos1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBalPos1FocusLost
        // TODO add your handling code here:
        JTextField focustFeild = txtBalPos1;
        JLabel focusedLabel = lblTopBalancePos2;

        try {
            if (focustFeild.getText().equals("")) {
                focustFeild.setText("0");
            } else {
                if (Integer.valueOf(focustFeild.getText()) < 8) {
                    focusedLabel.setText("0");
                } else if (Integer.valueOf(focustFeild.getText()) < 16) {
                    focusedLabel.setText("1");
                } else if (Integer.valueOf(focustFeild.getText()) < 24) {
                    focusedLabel.setText("2");
                } else {
                    focusedLabel.setText("3");
                }
            }
        } catch (NumberFormatException e) {
            lblErrorMessage.setVisible(true);
            lblErrorMessage.setText("Inalid Number");
        }
    }//GEN-LAST:event_txtBalPos1FocusLost

    private void txtNetTtlPos1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNetTtlPos1FocusGained
        // TODO add your handling code here:
        topNumberPadDisable();
        bottomNumberPadEnable();
        selectedTextBox = txtNetTtlPos1;
        selectedTextBoxBorder();

        txtNetTtlPos1.setText("");
    }//GEN-LAST:event_txtNetTtlPos1FocusGained

    private void txtNetTtlPos1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNetTtlPos1FocusLost
        // TODO add your handling code here:
        JTextField focustFeild = txtNetTtlPos1;
        if (focustFeild.getText().equals("")) {
            focustFeild.setText("0");
        }
    }//GEN-LAST:event_txtNetTtlPos1FocusLost

    private void txtNetTtlPos2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNetTtlPos2FocusGained
        // TODO add your handling code here:
        topNumberPadDisable();
        bottomNumberPadEnable();
        selectedTextBox = txtNetTtlPos2;
        selectedTextBoxBorder();

        txtNetTtlPos2.setText("");
    }//GEN-LAST:event_txtNetTtlPos2FocusGained

    private void txtNetTtlPos2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNetTtlPos2FocusLost
        // TODO add your handling code here:
        JTextField focustFeild = txtNetTtlPos2;
        if (focustFeild.getText().equals("")) {
            focustFeild.setText("0");
        }
    }//GEN-LAST:event_txtNetTtlPos2FocusLost

    private void txtNetTtlPos3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNetTtlPos3FocusGained
        // TODO add your handling code here:
        topNumberPadDisable();
        bottomNumberPadEnable();
        selectedTextBox = txtNetTtlPos3;
        selectedTextBoxBorder();

        txtNetTtlPos3.setText("");
    }//GEN-LAST:event_txtNetTtlPos3FocusGained

    private void txtNetTtlPos3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNetTtlPos3FocusLost
        // TODO add your handling code here:
        JTextField focustFeild = txtNetTtlPos3;
        if (focustFeild.getText().equals("")) {
            focustFeild.setText("0");
        }
    }//GEN-LAST:event_txtNetTtlPos3FocusLost

    private void txtNetTtlPos4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNetTtlPos4FocusGained
        // TODO add your handling code here:
        topNumberPadDisable();
        bottomNumberPadEnable();
        selectedTextBox = txtNetTtlPos4;
        selectedTextBoxBorder();

        txtNetTtlPos4.setText("");
    }//GEN-LAST:event_txtNetTtlPos4FocusGained

    private void txtNetTtlPos4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNetTtlPos4FocusLost
        // TODO add your handling code here:
        JTextField focustFeild = txtNetTtlPos4;
        if (focustFeild.getText().equals("")) {
            focustFeild.setText("0");
        }
    }//GEN-LAST:event_txtNetTtlPos4FocusLost

    private void txtNetTtlPos5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNetTtlPos5FocusGained
        // TODO add your handling code here:
        topNumberPadDisable();
        bottomNumberPadEnable();
        selectedTextBox = txtNetTtlPos5;
        selectedTextBoxBorder();

        txtNetTtlPos5.setText("");
    }//GEN-LAST:event_txtNetTtlPos5FocusGained

    private void txtNetTtlPos5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNetTtlPos5FocusLost
        // TODO add your handling code here:
        JTextField focustFeild = txtNetTtlPos5;
        if (focustFeild.getText().equals("")) {
            focustFeild.setText("0");
        }
    }//GEN-LAST:event_txtNetTtlPos5FocusLost

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        rendomNumbers();
        clearAll();
        if (questonNumber == 9) {
            btnNext.setText("Finish");
        } else if (questonNumber == 10) {
            disableAll();
            lblErrorMessage.show();
            lblErrorMessage.setText("You Have Completed the game");
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckActionPerformed
        // TODO add your handling code here:
        check();

        topNumberPadDisable();
        bottomNumberPadDisable();

        setdefaultBorderColour();

    }//GEN-LAST:event_btnCheckActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        resetGame();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnNum0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNum0ActionPerformed
        // TODO add your handling code here:
        selectedButton = btnNum0;
        keypad();
    }//GEN-LAST:event_btnNum0ActionPerformed

    private void btnNum2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNum2ActionPerformed
        // TODO add your handling code here:
        selectedButton = btnNum2;
        keypad();
    }//GEN-LAST:event_btnNum2ActionPerformed

    private void btnNum1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNum1ActionPerformed
        // TODO add your handling code here:
        selectedButton = btnNum1;
        keypad();
    }//GEN-LAST:event_btnNum1ActionPerformed

    private void btnNum3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNum3ActionPerformed
        // TODO add your handling code here:
        selectedButton = btnNum3;
        keypad();
    }//GEN-LAST:event_btnNum3ActionPerformed

    private void btnNum4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNum4ActionPerformed
        // TODO add your handling code here:
        selectedButton = btnNum4;
        keypad();
    }//GEN-LAST:event_btnNum4ActionPerformed

    private void btnNum5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNum5ActionPerformed
        // TODO add your handling code here:
        selectedButton = btnNum5;
        keypad();
    }//GEN-LAST:event_btnNum5ActionPerformed

    private void btnNum6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNum6ActionPerformed
        // TODO add your handling code here:
        selectedButton = btnNum6;
        keypad();
    }//GEN-LAST:event_btnNum6ActionPerformed

    private void btnNum7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNum7ActionPerformed
        // TODO add your handling code here:
        selectedButton = btnNum7;
        keypad();
    }//GEN-LAST:event_btnNum7ActionPerformed

    private void btnNum8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNum8ActionPerformed
        // TODO add your handling code here:
        selectedButton = btnNum8;
        keypad();
    }//GEN-LAST:event_btnNum8ActionPerformed

    private void btnNum9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNum9ActionPerformed
        // TODO add your handling code here:
        selectedButton = btnNum9;
        keypad();
    }//GEN-LAST:event_btnNum9ActionPerformed

    private void btnNum20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNum20ActionPerformed
        // TODO add your handling code here:
        selectedButton = btnNum20;
        keypad();
        topNumberPadDisable();

        FocusEvent FocusEvent = null;
        txtBalPos1FocusLost(FocusEvent);
        txtBalPos2FocusLost(FocusEvent);
        txtBalPos3FocusLost(FocusEvent);
        txtBalPos4FocusLost(FocusEvent);
    }//GEN-LAST:event_btnNum20ActionPerformed

    private void btnNum100ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNum100ActionPerformed
        // TODO add your handling code here:
        selectedButton = btnNum100;
        keypad();
        topNumberPadDisable();

        FocusEvent FocusEvent = null;
        txtBalPos1FocusLost(FocusEvent);
        txtBalPos2FocusLost(FocusEvent);
        txtBalPos3FocusLost(FocusEvent);
        txtBalPos4FocusLost(FocusEvent);
    }//GEN-LAST:event_btnNum100ActionPerformed

    private void btnNum70ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNum70ActionPerformed
        // TODO add your handling code here:
        selectedButton = btnNum70;
        keypad();
        topNumberPadDisable();

        FocusEvent FocusEvent = null;
        txtBalPos1FocusLost(FocusEvent);
        txtBalPos2FocusLost(FocusEvent);
        txtBalPos3FocusLost(FocusEvent);
        txtBalPos4FocusLost(FocusEvent);
    }//GEN-LAST:event_btnNum70ActionPerformed

    private void btnNum40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNum40ActionPerformed
        // TODO add your handling code here:
        selectedButton = btnNum40;
        keypad();
        topNumberPadDisable();

        FocusEvent FocusEvent = null;
        txtBalPos1FocusLost(FocusEvent);
        txtBalPos2FocusLost(FocusEvent);
        txtBalPos3FocusLost(FocusEvent);
        txtBalPos4FocusLost(FocusEvent);
    }//GEN-LAST:event_btnNum40ActionPerformed

    private void btnNum80ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNum80ActionPerformed
        // TODO add your handling code here:
        selectedButton = btnNum80;
        keypad();
        topNumberPadDisable();

        FocusEvent FocusEvent = null;
        txtBalPos1FocusLost(FocusEvent);
        txtBalPos2FocusLost(FocusEvent);
        txtBalPos3FocusLost(FocusEvent);
        txtBalPos4FocusLost(FocusEvent);
    }//GEN-LAST:event_btnNum80ActionPerformed

    private void btnNum60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNum60ActionPerformed
        // TODO add your handling code here:
        selectedButton = btnNum60;
        keypad();
        topNumberPadDisable();

        FocusEvent FocusEvent = null;
        txtBalPos1FocusLost(FocusEvent);
        txtBalPos2FocusLost(FocusEvent);
        txtBalPos3FocusLost(FocusEvent);
        txtBalPos4FocusLost(FocusEvent);
    }//GEN-LAST:event_btnNum60ActionPerformed

    private void btnNum10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNum10ActionPerformed
        // TODO add your handling code here:
        selectedButton = btnNum10;
        keypad();
        topNumberPadDisable();

        FocusEvent FocusEvent = null;
        txtBalPos1FocusLost(FocusEvent);
        txtBalPos2FocusLost(FocusEvent);
        txtBalPos3FocusLost(FocusEvent);
        txtBalPos4FocusLost(FocusEvent);
    }//GEN-LAST:event_btnNum10ActionPerformed

    private void btnNum50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNum50ActionPerformed
        // TODO add your handling code here:
        selectedButton = btnNum50;
        keypad();
        topNumberPadDisable();

        FocusEvent FocusEvent = null;
        txtBalPos1FocusLost(FocusEvent);
        txtBalPos2FocusLost(FocusEvent);
        txtBalPos3FocusLost(FocusEvent);
        txtBalPos4FocusLost(FocusEvent);
    }//GEN-LAST:event_btnNum50ActionPerformed

    private void btnNum30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNum30ActionPerformed
        // TODO add your handling code here:
        selectedButton = btnNum30;
        keypad();
        topNumberPadDisable();

        FocusEvent FocusEvent = null;
        txtBalPos1FocusLost(FocusEvent);
        txtBalPos2FocusLost(FocusEvent);
        txtBalPos3FocusLost(FocusEvent);
        txtBalPos4FocusLost(FocusEvent);
    }//GEN-LAST:event_btnNum30ActionPerformed

    private void btnNum90ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNum90ActionPerformed
        // TODO add your handling code here:
        selectedButton = btnNum90;
        keypad();
        topNumberPadDisable();

        FocusEvent FocusEvent = null;
        txtBalPos1FocusLost(FocusEvent);
        txtBalPos2FocusLost(FocusEvent);
        txtBalPos3FocusLost(FocusEvent);
        txtBalPos4FocusLost(FocusEvent);
    }//GEN-LAST:event_btnNum90ActionPerformed

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
            java.util.logging.Logger.getLogger(NumberSystemAdditionBase8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NumberSystemAdditionBase8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NumberSystemAdditionBase8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NumberSystemAdditionBase8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NumberSystemAdditionBase8().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCheck;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnNum0;
    private javax.swing.JButton btnNum1;
    private javax.swing.JButton btnNum10;
    private javax.swing.JButton btnNum100;
    private javax.swing.JButton btnNum2;
    private javax.swing.JButton btnNum20;
    private javax.swing.JButton btnNum3;
    private javax.swing.JButton btnNum30;
    private javax.swing.JButton btnNum4;
    private javax.swing.JButton btnNum40;
    private javax.swing.JButton btnNum5;
    private javax.swing.JButton btnNum50;
    private javax.swing.JButton btnNum6;
    private javax.swing.JButton btnNum60;
    private javax.swing.JButton btnNum7;
    private javax.swing.JButton btnNum70;
    private javax.swing.JButton btnNum8;
    private javax.swing.JButton btnNum80;
    private javax.swing.JButton btnNum9;
    private javax.swing.JButton btnNum90;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
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
    private javax.swing.JProgressBar jProgressBar3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lblComplete;
    private javax.swing.JLabel lblErrorMessage;
    private javax.swing.JLabel lblHealth1;
    private javax.swing.JLabel lblHealth2;
    private javax.swing.JLabel lblHealth3;
    private javax.swing.JLabel lblMarks;
    private javax.swing.JLabel lblNum1Pos1;
    private javax.swing.JLabel lblNum1Pos2;
    private javax.swing.JLabel lblNum1Pos3;
    private javax.swing.JLabel lblNum1Pos4;
    private javax.swing.JLabel lblNum2Pos1;
    private javax.swing.JLabel lblNum2Pos2;
    private javax.swing.JLabel lblNum2Pos3;
    private javax.swing.JLabel lblNum2Pos4;
    private javax.swing.JLabel lblQuestion;
    private javax.swing.JLabel lblQuestionNumber;
    private javax.swing.JLabel lblSidePnlBase10Complete;
    private javax.swing.JLabel lblSidePnlBase10Marks;
    private javax.swing.JLabel lblSidePnlBase16Complete;
    private javax.swing.JLabel lblSidePnlBase16Marks;
    private javax.swing.JLabel lblSidePnlBase2Complete;
    private javax.swing.JLabel lblSidePnlBase2Marks;
    private javax.swing.JLabel lblSidePnlUsername;
    private javax.swing.JLabel lblSidePnlWelcomeName;
    private javax.swing.JLabel lblTopBalancePos2;
    private javax.swing.JLabel lblTopBalancePos3;
    private javax.swing.JLabel lblTopBalancePos4;
    private javax.swing.JLabel lblTopBalancePos5;
    private javax.swing.JTextField txtBalPos1;
    private javax.swing.JTextField txtBalPos2;
    private javax.swing.JTextField txtBalPos3;
    private javax.swing.JTextField txtBalPos4;
    private javax.swing.JTextField txtNetTtlPos1;
    private javax.swing.JTextField txtNetTtlPos2;
    private javax.swing.JTextField txtNetTtlPos3;
    private javax.swing.JTextField txtNetTtlPos4;
    private javax.swing.JTextField txtNetTtlPos5;
    private javax.swing.JTextField txtTtlPos1;
    private javax.swing.JTextField txtTtlPos2;
    private javax.swing.JTextField txtTtlPos3;
    private javax.swing.JTextField txtTtlPos4;
    // End of variables declaration//GEN-END:variables
}
