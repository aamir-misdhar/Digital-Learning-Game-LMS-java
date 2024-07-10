/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Maths;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mmaam
 */
public class PerimeterAndAreaSquare extends javax.swing.JFrame {

    /**
     * Creates new form PerimeterAndAreaRectangle
     */
    String RegisterId = "";

    int questionNumber = 0;
    int complete = 0;
    int marks = 0;
    int health = 3;

    public PerimeterAndAreaSquare() {
        initComponents();

        rendamNumbers();
    }

    public void Setdata(String ID) {

        RegisterId = ID;

        //set user marks
        try {
            Connection con = Database.db.getConnection();
            String sql = "SELECT perimeterAndAreaRectangle_Marks,perimeterAndAreaRectangle_Complete,perimeterAndAreaSquare_Marks,perimeterAndAreaSquare_Complete,perimeterAndAreaTriangle_Marks,perimeterAndAreaTriangle_Complete,perimeterAndAreaCircle_Marks,perimeterAndAreaCircle_Complete FROM digital_learning_game.maths where stdRegisterId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int perimeterAndAreaRectangleComplete = rs.getInt("perimeterAndAreaRectangle_Complete");
                int perimeterAndAreaRectangleMarks = rs.getInt("perimeterAndAreaRectangle_Marks");

                int perimeterAndAreaSquareComplete = rs.getInt("perimeterAndAreaSquare_Complete");
                int perimeterAndAreaSquareMarks = rs.getInt("perimeterAndAreaSquare_Marks");

                int perimeterAndAreaTriangleComplete = rs.getInt("perimeterAndAreaTriangle_Complete");
                int perimeterAndAreaTriangleMarks = rs.getInt("perimeterAndAreaTriangle_Marks");

                int perimeterAndAreaCircleComplete = rs.getInt("perimeterAndAreaCircle_Complete");
                int perimeterAndAreaCircleMarks = rs.getInt("perimeterAndAreaCircle_Marks");

                //Set data
                lblSidePnlRectangleComplete.setText("Completed : " + perimeterAndAreaRectangleComplete + "%");
                lblSidePnlRectangleMarks.setText("Score : " + perimeterAndAreaRectangleMarks);

                lblSidePnlTriangleComplete.setText("Completed : " + perimeterAndAreaTriangleComplete + "%");
                lblSidePnlTriangleMarks.setText("Score : " + perimeterAndAreaTriangleMarks);

                lblSidePnlCircleComplete.setText("Completed : " + perimeterAndAreaCircleComplete + "%");
                lblSidePnlCircleMarks.setText("Score : " + perimeterAndAreaCircleMarks);

            }
        } catch (SQLException ex) {
            Logger.getLogger(PerimeterAndAreaSquare.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(PerimeterAndAreaSquare.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sendDataToDatabase() {
        try {
            // create connection to database
            Connection con = Database.db.getConnection();
            // Create prepared statement with the sql query
            PreparedStatement st1 = con.prepareStatement("UPDATE `digital_learning_game`.`maths` SET `perimeterAndAreaSquare_Marks` = '" + marks + "', `perimeterAndAreaSquare_Complete` = '" + complete + "' WHERE (`stdRegisterId` = '" + RegisterId + "');");
            // execute query
            st1.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PerimeterAndAreaSquare.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void enablePerimeter() {
        lblAreaQuestion.setEnabled(false);
        txtAreaAnswer.setEnabled(false);
        btnAreaCheck.setEnabled(false);
        btnAreaNext.setEnabled(false);

        lblPerimeterQuestion.setEnabled(true);
        txtPerimeterAnswer.setEnabled(true);
        btnPerimeterCheck.setEnabled(true);
        btnPerimeterNext.setEnabled(false);
    }

    public void enableArea() {
        lblAreaQuestion.setEnabled(true);
        txtAreaAnswer.setEnabled(true);
        btnAreaCheck.setEnabled(true);
        btnAreaNext.setEnabled(false);

        lblPerimeterQuestion.setEnabled(false);
        txtPerimeterAnswer.setEnabled(false);
        btnPerimeterCheck.setEnabled(false);
        btnPerimeterNext.setEnabled(false);
    }

    public void rendamNumbers() {
        lblHeght.setVisible(false);
        lblPerimeterAnswerErrorMessage.setVisible(false);
        lblAreaAnswerErrorMessage.setVisible(false);
        lblErrorMessage.setVisible(false);
        questionNumber++;

        txtPerimeterAnswer.setText("");
        lblPerimeterDisplay.setText("(Answer)");
        lblPerimeterDisplay.setForeground(Color.black);
        txtAreaAnswer.setText("");
        lblAreaDisplay.setText("(Answer)");
        lblAreaDisplay.setForeground(Color.black);

        enablePerimeter();
        Random rnd = new Random();
        //int height = rnd.nextInt(5);
        int widht = rnd.nextInt(1, 5);

        lblWidht.setText(widht + "");
        //lblHeght.setText(height + "");

        lblPerimeterQuestion.setText("4 X " + widht);
        lblAreaQuestion.setText(widht + " X " + widht);
    }

    public void perimeterCheck() {
        try {
            int ans = Integer.valueOf(txtPerimeterAnswer.getText());
            int width = Integer.valueOf(lblWidht.getText());
            //int height = Integer.valueOf(lblHeght.getText());
            int correctAns = 4 * width;

            if (ans == correctAns) {
                //System.out.println("Correct");
                perimeterCorrectAnswer();
                marks = marks + 5;
            } else {
                //System.out.println("Wrong");
                perimeterWrongAnswer();
                health--;
            }

        } catch (NumberFormatException e) {
            lblPerimeterAnswerErrorMessage.setText("Invalid Number");
            lblPerimeterAnswerErrorMessage.setVisible(true);
            perimeterWrongAnswer();
            health--;
        }

        complete = complete + 5;
        lblMarks.setText(marks + "");
        lblComplete.setText("Complete " + complete + "%");

        btnPerimeterCheck.setEnabled(false);
        btnPerimeterNext.setEnabled(true);
        healthCheck();
    }

    public void areaCheck() {
        try {
            int ans = Integer.valueOf(txtAreaAnswer.getText());

            int width = Integer.valueOf(lblWidht.getText());
            //int height = Integer.valueOf(lblHeght.getText());
            int correctAns = width * width;

            if (ans == correctAns) {
                //System.out.println("Correct");
                areaCorrectAnswer();
                marks = marks + 5;
            } else {
                //System.out.println("Wrong");
                areaWrongAnswer();
                health--;
            }
        } catch (NumberFormatException e) {
            lblAreaAnswerErrorMessage.setText("Invalid Number");
            lblAreaAnswerErrorMessage.setVisible(true);
            areaWrongAnswer();
            health--;
        }

        complete = complete + 5;
        lblMarks.setText(marks + "");
        lblComplete.setText("Complete " + complete + "%");

        btnAreaCheck.setEnabled(false);
        btnAreaNext.setEnabled(true);
        healthCheck();
    }

    //healthCheck
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

            lblErrorMessage.setVisible(true);
            lblErrorMessage.setText("Please Reset the Game");
            disableFullGame();
        }
    }

    public void disableFullGame() {
        lblPerimeterQuestion.setEnabled(false);
        txtPerimeterAnswer.setEnabled(false);
        btnPerimeterCheck.setEnabled(false);
        btnPerimeterNext.setEnabled(false);

        lblAreaQuestion.setEnabled(false);
        txtAreaAnswer.setEnabled(false);
        btnAreaCheck.setEnabled(false);
        btnAreaNext.setEnabled(false);

    }

    //Color Change Code
    public void perimeterCorrectAnswer() {
        lblPerimeterDisplay.setText("(Correct)");
        lblPerimeterDisplay.setForeground(Color.green);

        if (questionNumber == 1) {
            lblQ1perimeter.setText("Perimeter  05");
            lblQ1perimeter.setForeground(Color.green);
        } else if (questionNumber == 2) {
            lblQ2perimeter.setText("Perimeter  05");
            lblQ2perimeter.setForeground(Color.green);
        } else if (questionNumber == 3) {
            lblQ3perimeter.setText("Perimeter  05");
            lblQ3perimeter.setForeground(Color.green);
        } else if (questionNumber == 4) {
            lblQ4perimeter.setText("Perimeter  05");
            lblQ4perimeter.setForeground(Color.green);
        } else if (questionNumber == 5) {
            lblQ5perimeter.setText("Perimeter  05");
            lblQ5perimeter.setForeground(Color.green);
        }
    }

    public void perimeterWrongAnswer() {
        lblPerimeterDisplay.setText("(Wrong)");
        lblPerimeterDisplay.setForeground(Color.red);

        if (questionNumber == 1) {
            lblQ1perimeter.setText("Perimeter  00");
            lblQ1perimeter.setForeground(Color.red);
        } else if (questionNumber == 2) {
            lblQ2perimeter.setText("Perimeter  00");
            lblQ2perimeter.setForeground(Color.red);
        } else if (questionNumber == 3) {
            lblQ3perimeter.setText("Perimeter  00");
            lblQ3perimeter.setForeground(Color.red);
        } else if (questionNumber == 4) {
            lblQ4perimeter.setText("Perimeter  00");
            lblQ4perimeter.setForeground(Color.red);
        } else if (questionNumber == 5) {
            lblQ5perimeter.setText("Perimeter  00");
            lblQ5perimeter.setForeground(Color.red);
        }
    }

    public void areaCorrectAnswer() {
        lblAreaDisplay.setText("(Correct)");
        lblAreaDisplay.setForeground(Color.green);

        if (questionNumber == 1) {
            lblQ1area.setText("Area  05");
            lblQ1area.setForeground(Color.green);
        } else if (questionNumber == 2) {
            lblQ2area.setText("Area  05");
            lblQ2area.setForeground(Color.green);
        } else if (questionNumber == 3) {
            lblQ3area.setText("Area  05");
            lblQ3area.setForeground(Color.green);
        } else if (questionNumber == 4) {
            lblQ4area.setText("Area  05");
            lblQ4area.setForeground(Color.green);
        } else if (questionNumber == 5) {
            lblQ5area.setText("Area  05");
            lblQ5area.setForeground(Color.green);
        }
    }

    public void areaWrongAnswer() {
        lblAreaDisplay.setText("(Wrong)");
        lblAreaDisplay.setForeground(Color.red);

        if (questionNumber == 1) {
            lblQ1area.setText("Area  00");
            lblQ1area.setForeground(Color.red);
        } else if (questionNumber == 2) {
            lblQ2area.setText("Area  00");
            lblQ2area.setForeground(Color.red);
        } else if (questionNumber == 3) {
            lblQ3area.setText("Area  00");
            lblQ3area.setForeground(Color.red);
        } else if (questionNumber == 4) {
            lblQ4area.setText("Area  00");
            lblQ4area.setForeground(Color.red);
        } else if (questionNumber == 5) {
            lblQ5area.setText("Area  00");
            lblQ5area.setForeground(Color.red);
        }
    }

    public void resetGame() {
        questionNumber = 0;
        complete = 0;
        marks = 0;
        health = 3;

        lblQ1perimeter.setText("Perimeter 00");
        lblQ2perimeter.setText("Perimeter 00");
        lblQ3perimeter.setText("Perimeter 00");
        lblQ4perimeter.setText("Perimeter 00");
        lblQ5perimeter.setText("Perimeter 00");

        lblQ1perimeter.setForeground(Color.black);
        lblQ2perimeter.setForeground(Color.black);
        lblQ3perimeter.setForeground(Color.black);
        lblQ4perimeter.setForeground(Color.black);
        lblQ5perimeter.setForeground(Color.black);

        lblQ1area.setText("Area 00");
        lblQ2area.setText("Area 00");
        lblQ3area.setText("Area 00");
        lblQ4area.setText("Area 00");
        lblQ5area.setText("Area 00");

        lblQ1area.setForeground(Color.black);
        lblQ2area.setForeground(Color.black);
        lblQ3area.setForeground(Color.black);
        lblQ4area.setForeground(Color.black);
        lblQ5area.setForeground(Color.black);

        healthCheck();
        lblMarks.setText(marks + "");
        lblComplete.setText("Completed : " + complete + "%");

        rendamNumbers();
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
        lblSidePnlRectangleComplete = new javax.swing.JLabel();
        lblSidePnlRectangleMarks = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        lblSidePnlWelcomeName = new javax.swing.JLabel();
        lblSidePnlUsername = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jProgressBar2 = new javax.swing.JProgressBar();
        lblSidePnlTriangleComplete = new javax.swing.JLabel();
        lblSidePnlTriangleMarks = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jProgressBar3 = new javax.swing.JProgressBar();
        lblSidePnlCircleComplete = new javax.swing.JLabel();
        lblSidePnlCircleMarks = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblMarks = new javax.swing.JLabel();
        lblHealth1 = new javax.swing.JLabel();
        lblHealth2 = new javax.swing.JLabel();
        lblHealth3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblWidht = new javax.swing.JLabel();
        lblHeght = new javax.swing.JLabel();
        PictureBox = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnPerimeterCheck = new javax.swing.JButton();
        btnPerimeterNext = new javax.swing.JButton();
        txtPerimeterAnswer = new javax.swing.JTextField();
        lblPerimeterQuestion = new javax.swing.JLabel();
        lblPerimeterDisplay = new javax.swing.JLabel();
        lblPerimeterAnswerErrorMessage = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblAreaQuestion = new javax.swing.JLabel();
        txtAreaAnswer = new javax.swing.JTextField();
        lblAreaDisplay = new javax.swing.JLabel();
        lblAreaAnswerErrorMessage = new javax.swing.JLabel();
        btnAreaCheck = new javax.swing.JButton();
        btnAreaNext = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblComplete = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lblQ1perimeter = new javax.swing.JLabel();
        lblQ1area = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lblQ2perimeter = new javax.swing.JLabel();
        lblQ2area = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        lblQ3perimeter = new javax.swing.JLabel();
        lblQ3area = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        lblQ4perimeter = new javax.swing.JLabel();
        lblQ4area = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        lblQ5perimeter = new javax.swing.JLabel();
        lblQ5area = new javax.swing.JLabel();
        lblErrorMessage = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

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
        jLabel9.setText("Rectangle");

        lblSidePnlRectangleComplete.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblSidePnlRectangleComplete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSidePnlRectangleComplete.setText("Completed : 0%");

        lblSidePnlRectangleMarks.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSidePnlRectangleMarks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSidePnlRectangleMarks.setText("Score : 00");

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
                    .addComponent(lblSidePnlRectangleComplete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSidePnlRectangleMarks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(lblSidePnlRectangleComplete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSidePnlRectangleMarks)
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
        jLabel10.setText("Triangle");

        lblSidePnlTriangleComplete.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblSidePnlTriangleComplete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSidePnlTriangleComplete.setText("Completed : 0%");

        lblSidePnlTriangleMarks.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSidePnlTriangleMarks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSidePnlTriangleMarks.setText("Score : 00");

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
                    .addComponent(lblSidePnlTriangleComplete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSidePnlTriangleMarks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(lblSidePnlTriangleComplete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSidePnlTriangleMarks)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Circle");

        lblSidePnlCircleComplete.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblSidePnlCircleComplete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSidePnlCircleComplete.setText("Completed : 0%");

        lblSidePnlCircleMarks.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSidePnlCircleMarks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSidePnlCircleMarks.setText("Score : 00");

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
                    .addComponent(lblSidePnlCircleComplete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSidePnlCircleMarks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(lblSidePnlCircleComplete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSidePnlCircleMarks)
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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Square");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Perimeter and Area");

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
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE))
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

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblWidht.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblWidht.setForeground(new java.awt.Color(102, 102, 102));
        lblWidht.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWidht.setText("jLabel18");
        jPanel4.add(lblWidht, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 80, -1));

        lblHeght.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblHeght.setForeground(new java.awt.Color(102, 102, 102));
        lblHeght.setText("jLabel18");
        jPanel4.add(lblHeght, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 150, -1, -1));

        PictureBox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PerimeterAndArea_Square.png"))); // NOI18N
        jPanel4.add(PictureBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 684, 250));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Perimeter");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("4 X Width");

        btnPerimeterCheck.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnPerimeterCheck.setText("Check");
        btnPerimeterCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerimeterCheckActionPerformed(evt);
            }
        });

        btnPerimeterNext.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnPerimeterNext.setText("Next");
        btnPerimeterNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerimeterNextActionPerformed(evt);
            }
        });

        txtPerimeterAnswer.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtPerimeterAnswer.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPerimeterAnswer.setText("000");

        lblPerimeterQuestion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblPerimeterQuestion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPerimeterQuestion.setText("2 ( 00 + 00 )");

        lblPerimeterDisplay.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblPerimeterDisplay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPerimeterDisplay.setText("(Answer)");

        lblPerimeterAnswerErrorMessage.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblPerimeterAnswerErrorMessage.setForeground(new java.awt.Color(204, 0, 0));
        lblPerimeterAnswerErrorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPerimeterAnswerErrorMessage.setText("Error Message");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPerimeterQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPerimeterAnswerErrorMessage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(btnPerimeterCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnPerimeterNext, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPerimeterAnswer)
                                    .addComponent(lblPerimeterDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPerimeterQuestion)
                .addGap(18, 18, 18)
                .addComponent(txtPerimeterAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(lblPerimeterDisplay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(lblPerimeterAnswerErrorMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPerimeterCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPerimeterNext, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Area");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Width X Width");

        lblAreaQuestion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblAreaQuestion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAreaQuestion.setText("00 X 00");

        txtAreaAnswer.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtAreaAnswer.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAreaAnswer.setText("000");

        lblAreaDisplay.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblAreaDisplay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAreaDisplay.setText("(Answer)");

        lblAreaAnswerErrorMessage.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblAreaAnswerErrorMessage.setForeground(new java.awt.Color(204, 0, 0));
        lblAreaAnswerErrorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAreaAnswerErrorMessage.setText("Error Message");

        btnAreaCheck.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAreaCheck.setText("Check");
        btnAreaCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAreaCheckActionPerformed(evt);
            }
        });

        btnAreaNext.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAreaNext.setText("Next");
        btnAreaNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAreaNextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAreaQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAreaAnswerErrorMessage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(btnAreaCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAreaNext, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtAreaAnswer)
                                    .addComponent(lblAreaDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAreaQuestion)
                .addGap(18, 18, 18)
                .addComponent(txtAreaAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(lblAreaDisplay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblAreaAnswerErrorMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAreaCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAreaNext, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        lblComplete.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblComplete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblComplete.setText("Completed 0%");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Question 01 :");

        lblQ1perimeter.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblQ1perimeter.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblQ1perimeter.setText("Perimeter 00");

        lblQ1area.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblQ1area.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblQ1area.setText("Area 00");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("Question 02 :");

        lblQ2perimeter.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblQ2perimeter.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblQ2perimeter.setText("Perimeter 00");

        lblQ2area.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblQ2area.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblQ2area.setText("Area 00");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setText("Question 03 :");

        lblQ3perimeter.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblQ3perimeter.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblQ3perimeter.setText("Perimeter 00");

        lblQ3area.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblQ3area.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblQ3area.setText("Area 00");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setText("Question 04 :");

        lblQ4perimeter.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblQ4perimeter.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblQ4perimeter.setText("Perimeter 00");

        lblQ4area.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblQ4area.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblQ4area.setText("Area 00");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel32.setText("Question 05 :");

        lblQ5perimeter.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblQ5perimeter.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblQ5perimeter.setText("Perimeter 00");

        lblQ5area.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblQ5area.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblQ5area.setText("Area 00");

        lblErrorMessage.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        lblErrorMessage.setForeground(new java.awt.Color(204, 0, 51));
        lblErrorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblErrorMessage.setText("ErrorMessage");

        btnReset.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblComplete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblQ1perimeter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblQ1area, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblQ2perimeter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblQ2area, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblQ3perimeter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblQ3area, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblQ4perimeter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblQ4area, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblQ5perimeter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblQ5area, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(lblErrorMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblComplete)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(lblQ1perimeter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblQ1area)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(lblQ2perimeter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblQ2area)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(lblQ3perimeter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblQ3area)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(lblQ4perimeter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblQ4area)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(lblQ5perimeter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblQ5area)
                .addGap(18, 18, 18)
                .addComponent(lblErrorMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here
        PerimeterAndArea perimeterArea = new PerimeterAndArea();
        perimeterArea.Setdata(RegisterId);
        perimeterArea.show();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnPerimeterCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerimeterCheckActionPerformed
        // TODO add your handling code here:
        if (txtPerimeterAnswer.getText().equals("")) {
            lblPerimeterAnswerErrorMessage.setVisible(true);
            lblPerimeterAnswerErrorMessage.setText("Answer Box is Empty");
        } else {
            lblPerimeterAnswerErrorMessage.setVisible(false);
            perimeterCheck();
            sendDataToDatabase();
        }

    }//GEN-LAST:event_btnPerimeterCheckActionPerformed

    private void btnAreaCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAreaCheckActionPerformed
        // TODO add your handling code here:
        if (txtAreaAnswer.getText().equals("")) {
            lblAreaAnswerErrorMessage.setVisible(true);
            lblAreaAnswerErrorMessage.setText("Answer Box is Empty");
        } else {
            lblAreaAnswerErrorMessage.setVisible(false);
            areaCheck();
            sendDataToDatabase();
        }
    }//GEN-LAST:event_btnAreaCheckActionPerformed

    private void btnPerimeterNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerimeterNextActionPerformed
        // TODO add your handling code here:
        enableArea();
    }//GEN-LAST:event_btnPerimeterNextActionPerformed

    private void btnAreaNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAreaNextActionPerformed
        // TODO add your handling code here:
        rendamNumbers();
        if (questionNumber == 5) {
            btnAreaNext.setText("Finish");
        } else if (questionNumber >= 6) {
            disableFullGame();

        }


    }//GEN-LAST:event_btnAreaNextActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        resetGame();
    }//GEN-LAST:event_btnResetActionPerformed

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
            java.util.logging.Logger.getLogger(PerimeterAndAreaSquare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PerimeterAndAreaSquare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PerimeterAndAreaSquare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PerimeterAndAreaSquare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PerimeterAndAreaSquare().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PictureBox;
    private javax.swing.JButton btnAreaCheck;
    private javax.swing.JButton btnAreaNext;
    private javax.swing.JButton btnPerimeterCheck;
    private javax.swing.JButton btnPerimeterNext;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
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
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JProgressBar jProgressBar3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAreaAnswerErrorMessage;
    private javax.swing.JLabel lblAreaDisplay;
    private javax.swing.JLabel lblAreaQuestion;
    private javax.swing.JLabel lblComplete;
    private javax.swing.JLabel lblErrorMessage;
    private javax.swing.JLabel lblHealth1;
    private javax.swing.JLabel lblHealth2;
    private javax.swing.JLabel lblHealth3;
    private javax.swing.JLabel lblHeght;
    private javax.swing.JLabel lblMarks;
    private javax.swing.JLabel lblPerimeterAnswerErrorMessage;
    private javax.swing.JLabel lblPerimeterDisplay;
    private javax.swing.JLabel lblPerimeterQuestion;
    private javax.swing.JLabel lblQ1area;
    private javax.swing.JLabel lblQ1perimeter;
    private javax.swing.JLabel lblQ2area;
    private javax.swing.JLabel lblQ2perimeter;
    private javax.swing.JLabel lblQ3area;
    private javax.swing.JLabel lblQ3perimeter;
    private javax.swing.JLabel lblQ4area;
    private javax.swing.JLabel lblQ4perimeter;
    private javax.swing.JLabel lblQ5area;
    private javax.swing.JLabel lblQ5perimeter;
    private javax.swing.JLabel lblSidePnlCircleComplete;
    private javax.swing.JLabel lblSidePnlCircleMarks;
    private javax.swing.JLabel lblSidePnlRectangleComplete;
    private javax.swing.JLabel lblSidePnlRectangleMarks;
    private javax.swing.JLabel lblSidePnlTriangleComplete;
    private javax.swing.JLabel lblSidePnlTriangleMarks;
    private javax.swing.JLabel lblSidePnlUsername;
    private javax.swing.JLabel lblSidePnlWelcomeName;
    private javax.swing.JLabel lblWidht;
    private javax.swing.JTextField txtAreaAnswer;
    private javax.swing.JTextField txtPerimeterAnswer;
    // End of variables declaration//GEN-END:variables
}
