/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ICT;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author mmaam
 */
public class InformationAndCommunicationTechnology_fillInTheBlanks extends javax.swing.JFrame {

    /**
     * Creates new form InformationAndCommunicationTechnology_fillInTheBlanks
     */
    String RegisterId = "";

    int questionNumber = 0;
    int complete = 0;
    int marks = 0;
    int health = 3;

    String correctAnswer = "Q1";
    JLabel sideQeustion;
    JLabel sideMarks;
    JButton selectedButton;

    public InformationAndCommunicationTechnology_fillInTheBlanks() {
        initComponents();

        questionChange();
    }

    public void Setdata(String ID) {

        RegisterId = ID;

        try {
            Connection con = Database.db.getConnection();
            String sql = "SELECT ictMCQ_complete,ictMCQ_marks FROM digital_learning_game.ict where stdRegisterId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String mcqComplete = rs.getString("ictMCQ_complete");
                String mcqMarks = rs.getString("ictMCQ_marks");

                //Set data
                lblSidePnlMcqComplete.setText("Completed : " + mcqComplete + "%");
                lblSidePnlMcqMarks.setText("Score : " + mcqMarks);

            }
        } catch (SQLException ex) {
            Logger.getLogger(InformationAndCommunicationTechnology_fillInTheBlanks.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            Logger.getLogger(InformationAndCommunicationTechnology_fillInTheBlanks.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void sendDataToDatabase() {
        try {
            // create connection to database
            Connection con = Database.db.getConnection();
            // Create prepared statement with the sql query
            PreparedStatement st1 = con.prepareStatement("UPDATE `digital_learning_game`.`ict` SET `ictFillInTheBlanks_marks` = '" + marks + "', `ictFillInTheBlanks_completed` = '" + complete + "' WHERE (`stdRegisterId` = '" + RegisterId + "');");
            // execute query
            st1.executeUpdate();

            // show success message
            //JOptionPane.showMessageDialog(this, "Successfully Inserted...");
        } catch (SQLException ex) {
            Logger.getLogger(InformationAndCommunicationTechnology_MCQ.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void disableButtons() {
        btnAnswer1.setEnabled(false);
        btnAnswer2.setEnabled(false);
        btnAnswer3.setEnabled(false);
        btnAnswer4.setEnabled(false);
    }

    public void enableButtons() {
        btnAnswer1.setEnabled(true);
        btnAnswer2.setEnabled(true);
        btnAnswer3.setEnabled(true);
        btnAnswer4.setEnabled(true);
    }

    public void questionChange() {
        btnNext.setEnabled(false);
        btnCheck.setEnabled(false);
        lblDisplay.setVisible(false);
        enableButtons();
        setDefaltBorder();
        questionNumber = questionNumber + 1;
        if (questionNumber == 1) {
            lblQuestion.setText("<htmL>______________ is the processed and organized form of data that conveys meaning.</htmL>");
            btnAnswer1.setText("Raw data");
            btnAnswer2.setText("Unprocessed data");
            btnAnswer3.setText("Meaningful data");
            btnAnswer4.setText("Processed data");
            correctAnswer = "Meaningful data";
            sideQeustion = lblQstn1;
            sideMarks = lblMrks1;
        } else if (questionNumber == 2) {
            lblQuestion.setText("<html>In a computer system, the ______________ component is responsible for transforming input into output.</html>");
            btnAnswer1.setText("Input");
            btnAnswer2.setText("Processing");
            btnAnswer3.setText("Output");
            btnAnswer4.setText("Control");
            correctAnswer = "Processing";
            sideQeustion = lblQstn2;
            sideMarks = lblMrks2;
        } else if (questionNumber == 3) {
            lblQuestion.setText("<html>ICT stands for Information and ______________ Technology.</html>");
            btnAnswer1.setText("Computer");
            btnAnswer2.setText("Communication");
            btnAnswer3.setText("Control");
            btnAnswer4.setText("Central");
            correctAnswer = "Communication";
            sideQeustion = lblQstn3;
            sideMarks = lblMrks3;
        } else if (questionNumber == 4) {
            lblQuestion.setText("<html>______________ involves the use of electronic health records and telemedicine in the healthcare sector.</html>");
            btnAnswer1.setText("Business");
            btnAnswer2.setText("Education");
            btnAnswer3.setText("Healthcare");
            btnAnswer4.setText("Entertainment");
            correctAnswer = "Healthcare";
            sideQeustion = lblQstn4;
            sideMarks = lblMrks4;
        } else if (questionNumber == 5) {
            lblQuestion.setText("<html>Job displacement is a common challenge associated with the ______________ of ICT.</html>");
            btnAnswer1.setText("Advantages");
            btnAnswer2.setText("Evolution");
            btnAnswer3.setText("Demerits");
            btnAnswer4.setText("Components");
            correctAnswer = "Demerits";
            sideQeustion = lblQstn5;
            sideMarks = lblMrks5;
        } else if (questionNumber == 6) {
            lblQuestion.setText("<html>The use of microprocessors and personal computers characterizes the ______________ of computers.</html>");
            btnAnswer1.setText("First Generation");
            btnAnswer2.setText("Second Generation");
            btnAnswer3.setText("Third Generation");
            btnAnswer4.setText("Fourth Generation");
            correctAnswer = "Fourth Generation";
            sideQeustion = lblQstn6;
            sideMarks = lblMrks6;
        } else if (questionNumber == 7) {
            lblQuestion.setText("<html>______________ is the raw facts and figures without context.</html>");
            btnAnswer1.setText("Contextual data");
            btnAnswer2.setText("Processed data");
            btnAnswer3.setText("Raw data");
            btnAnswer4.setText("Meaningful data");
            correctAnswer = "Raw data";
            sideQeustion = lblQstn7;
            sideMarks = lblMrks7;
        } else if (questionNumber == 8) {
            lblQuestion.setText("<html>______________ involves adjusting system operations based on information about the system's output.</html>");
            btnAnswer1.setText("Input");
            btnAnswer2.setText("Output");
            btnAnswer3.setText("Feedback");
            btnAnswer4.setText("Control");
            correctAnswer = "Feedback";
            sideQeustion = lblQstn8;
            sideMarks = lblMrks8;
        } else if (questionNumber == 9) {
            lblQuestion.setText("<html>______________ refers to the physical equipment used in ICT, such as computers and routers.</html>");
            btnAnswer1.setText("Software");
            btnAnswer2.setText("Hardware");
            btnAnswer3.setText("Networks");
            btnAnswer4.setText("People");
            correctAnswer = "Hardware";
            sideQeustion = lblQstn9;
            sideMarks = lblMrks9;
        } else if (questionNumber == 10) {
            lblQuestion.setText("<html>In the education sector, ______________ involves the use of digital tools and platforms for learning.</html>");
            btnAnswer1.setText("E-governance");
            btnAnswer2.setText("Telemedicine");
            btnAnswer3.setText("E-learning");
            btnAnswer4.setText("Streaming services");
            correctAnswer = "E-learning";
            sideQeustion = lblQstn10;
            sideMarks = lblMrks10;
            btnNext.setText("Finish");
        } else if (questionNumber == 11) {
//            lblQuestion.setText("Question 4");
//            btnAnswer1.setText("Q4A1");
//            btnAnswer2.setText("Q4A2");
//            btnAnswer3.setText("Q4A3");
//            btnAnswer4.setText("Q4A4");
//            correctAnswer = "Q4A1";
//            sideQeustion = lblQstn4;
//            sideMarks = lblMrks4;
            lblDisplay.setText("You have Done the Game");
            lblDisplay.setVisible(true);
            disableButtons();
        }
    }

    public void setDefaltBorder() {
        btnAnswer1.setBorder(BorderFactory.createEmptyBorder());
        btnAnswer2.setBorder(BorderFactory.createEmptyBorder());
        btnAnswer3.setBorder(BorderFactory.createEmptyBorder());
        btnAnswer4.setBorder(BorderFactory.createEmptyBorder());
    }

    public void answerCheck() {

        lblDisplay.setVisible(true);
        String answer = selectedButton.getText();
        if (answer.equals(correctAnswer)) {
            marks = marks + 10;
            sideQeustion.setForeground(Color.green);
            sideMarks.setForeground(Color.green);
            sideMarks.setText("10");
            lblDisplay.setText("Correct");
            lblDisplay.setForeground(Color.green);
            selectedButton.setBorder(BorderFactory.createLineBorder(Color.green, 2, true));
        } else {
            health = health - 1;
            sideQeustion.setForeground(Color.red);
            sideMarks.setForeground(Color.red);
            sideMarks.setText("00");
            lblDisplay.setText("Wrong");
            lblDisplay.setForeground(Color.red);
            selectedButton.setBorder(BorderFactory.createLineBorder(Color.red, 2, true));
        }

        btnNext.setEnabled(true);
        btnCheck.setEnabled(false);

        complete = complete + 10;
        lblComplete.setText("Completed : " + complete + "%");
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
        } else if (health < 0) {
            lblHealth1.setVisible(false);
            lblHealth2.setVisible(false);
            lblHealth3.setVisible(false);
            lblDisplay.setText("Please reset the game, your Health is Over");
            lblDisplay.setForeground(Color.red);
            lblDisplay.show();
            disableButtons();
            btnNext.setEnabled(false);
            btnCheck.setEnabled(false);
        }
    }

    public void resetGame() {
        questionNumber = 0;
        complete = 0;
        marks = 0;
        health = 3;

        questionChange();
        healthSet();
        lblComplete.setText("Completed : " + complete + "%");
        lblMarks.setText(marks + "");

        lblQstn1.setForeground(Color.black);
        lblQstn2.setForeground(Color.black);
        lblQstn3.setForeground(Color.black);
        lblQstn4.setForeground(Color.black);
        lblQstn5.setForeground(Color.black);
        lblQstn6.setForeground(Color.black);
        lblQstn7.setForeground(Color.black);
        lblQstn8.setForeground(Color.black);
        lblQstn9.setForeground(Color.black);
        lblQstn10.setForeground(Color.black);

        lblMrks1.setForeground(Color.black);
        lblMrks2.setForeground(Color.black);
        lblMrks3.setForeground(Color.black);
        lblMrks4.setForeground(Color.black);
        lblMrks5.setForeground(Color.black);
        lblMrks6.setForeground(Color.black);
        lblMrks7.setForeground(Color.black);
        lblMrks8.setForeground(Color.black);
        lblMrks9.setForeground(Color.black);
        lblMrks10.setForeground(Color.black);

        lblMrks1.setText("00");
        lblMrks2.setText("00");
        lblMrks3.setText("00");
        lblMrks4.setText("00");
        lblMrks5.setText("00");
        lblMrks6.setText("00");
        lblMrks7.setText("00");
        lblMrks8.setText("00");
        lblMrks9.setText("00");
        lblMrks10.setText("00");
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
        lblSidePnlMcqComplete = new javax.swing.JLabel();
        lblSidePnlMcqMarks = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        lblSidePnlWelcomeName = new javax.swing.JLabel();
        lblSidePnlUsername = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
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
        lblDisplay = new javax.swing.JLabel();
        lblQuestion = new javax.swing.JLabel();
        btnAnswer1 = new javax.swing.JButton();
        btnAnswer2 = new javax.swing.JButton();
        btnAnswer3 = new javax.swing.JButton();
        btnAnswer4 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnCheck = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblQstn1 = new javax.swing.JLabel();
        lblMrks1 = new javax.swing.JLabel();
        lblQstn2 = new javax.swing.JLabel();
        lblMrks2 = new javax.swing.JLabel();
        lblMrks3 = new javax.swing.JLabel();
        lblQstn3 = new javax.swing.JLabel();
        lblMrks4 = new javax.swing.JLabel();
        lblQstn4 = new javax.swing.JLabel();
        lblQstn5 = new javax.swing.JLabel();
        lblMrks5 = new javax.swing.JLabel();
        lblQstn6 = new javax.swing.JLabel();
        lblMrks6 = new javax.swing.JLabel();
        lblMrks7 = new javax.swing.JLabel();
        lblQstn7 = new javax.swing.JLabel();
        lblQstn8 = new javax.swing.JLabel();
        lblMrks8 = new javax.swing.JLabel();
        lblQstn9 = new javax.swing.JLabel();
        lblMrks9 = new javax.swing.JLabel();
        lblQstn10 = new javax.swing.JLabel();
        lblMrks10 = new javax.swing.JLabel();
        lblComplete = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();

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
        jLabel9.setText("MCQ");

        lblSidePnlMcqComplete.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblSidePnlMcqComplete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSidePnlMcqComplete.setText("Completed : 0%");

        lblSidePnlMcqMarks.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSidePnlMcqMarks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSidePnlMcqMarks.setText("Score : 00");

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
                    .addComponent(lblSidePnlMcqComplete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSidePnlMcqMarks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(lblSidePnlMcqComplete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSidePnlMcqMarks)
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
                .addContainerGap(291, Short.MAX_VALUE))
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
        jLabel1.setText("Information and Communication Technology");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Fill in the Blanks");

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
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
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

        lblDisplay.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDisplay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDisplay.setText("Correct");

        lblQuestion.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblQuestion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQuestion.setText("Question Question Question Question Question");

        btnAnswer1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnAnswer1.setText("Answer 1");
        btnAnswer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswer1ActionPerformed(evt);
            }
        });

        btnAnswer2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnAnswer2.setText("Answer 1");
        btnAnswer2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswer2ActionPerformed(evt);
            }
        });

        btnAnswer3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnAnswer3.setText("Answer 1");
        btnAnswer3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswer3ActionPerformed(evt);
            }
        });

        btnAnswer4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnAnswer4.setText("Answer 1");
        btnAnswer4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswer4ActionPerformed(evt);
            }
        });

        btnCheck.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnCheck.setText("Check");
        btnCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckActionPerformed(evt);
            }
        });

        btnNext.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAnswer4, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAnswer3, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAnswer2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAnswer1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblQuestion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(btnCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(lblQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAnswer1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAnswer2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAnswer3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAnswer4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        lblQstn1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblQstn1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQstn1.setText("Question 01");

        lblMrks1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblMrks1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMrks1.setText("00");

        lblQstn2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblQstn2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQstn2.setText("Question 02");

        lblMrks2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblMrks2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMrks2.setText("00");

        lblMrks3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblMrks3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMrks3.setText("00");

        lblQstn3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblQstn3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQstn3.setText("Question 03");

        lblMrks4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblMrks4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMrks4.setText("00");

        lblQstn4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblQstn4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQstn4.setText("Question 04");

        lblQstn5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblQstn5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQstn5.setText("Question 05");

        lblMrks5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblMrks5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMrks5.setText("00");

        lblQstn6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblQstn6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQstn6.setText("Question 06");

        lblMrks6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblMrks6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMrks6.setText("00");

        lblMrks7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblMrks7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMrks7.setText("00");

        lblQstn7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblQstn7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQstn7.setText("Question 07");

        lblQstn8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblQstn8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQstn8.setText("Question 08");

        lblMrks8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblMrks8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMrks8.setText("00");

        lblQstn9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblQstn9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQstn9.setText("Question 09");

        lblMrks9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblMrks9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMrks9.setText("00");

        lblQstn10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblQstn10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQstn10.setText("Question 10");

        lblMrks10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblMrks10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMrks10.setText("00");

        lblComplete.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblComplete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblComplete.setText("Completed : 0%");

        btnReset.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 102, 102));
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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(17, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                            .addComponent(lblComplete, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblQstn1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblMrks1, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblQstn2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblMrks2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblQstn3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblMrks3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblQstn4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblMrks4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblQstn5, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblMrks5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblQstn6, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblMrks6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblQstn7, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblMrks7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblQstn8, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblMrks8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblQstn9, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblMrks9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblQstn10, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblMrks10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblComplete)
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQstn1)
                    .addComponent(lblMrks1))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQstn2)
                    .addComponent(lblMrks2))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQstn3)
                    .addComponent(lblMrks3))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQstn4)
                    .addComponent(lblMrks4))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQstn5)
                    .addComponent(lblMrks5))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQstn6)
                    .addComponent(lblMrks6))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQstn7)
                    .addComponent(lblMrks7))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQstn8)
                    .addComponent(lblMrks8))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQstn9)
                    .addComponent(lblMrks9))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQstn10)
                    .addComponent(lblMrks10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        InformationAndCommunicationTechnology ict = new InformationAndCommunicationTechnology();
        ict.Setdata(RegisterId);
        ict.show();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        resetGame();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        questionChange();


    }//GEN-LAST:event_btnNextActionPerformed

    private void btnAnswer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswer1ActionPerformed
        // TODO add your handling code here:
        selectedButton = btnAnswer1;
        setDefaltBorder();
        selectedButton.setBorder(BorderFactory.createLineBorder(Color.blue, 2, true));
        btnCheck.setEnabled(true);

    }//GEN-LAST:event_btnAnswer1ActionPerformed

    private void btnAnswer2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswer2ActionPerformed
        // TODO add your handling code here:
        selectedButton = btnAnswer2;
        setDefaltBorder();
        selectedButton.setBorder(BorderFactory.createLineBorder(Color.blue, 2, true));
        btnCheck.setEnabled(true);

    }//GEN-LAST:event_btnAnswer2ActionPerformed

    private void btnAnswer3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswer3ActionPerformed
        // TODO add your handling code here:
        selectedButton = btnAnswer3;
        setDefaltBorder();
        selectedButton.setBorder(BorderFactory.createLineBorder(Color.blue, 2, true));
        btnCheck.setEnabled(true);

    }//GEN-LAST:event_btnAnswer3ActionPerformed

    private void btnAnswer4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswer4ActionPerformed
        // TODO add your handling code here:
        selectedButton = btnAnswer4;
        setDefaltBorder();
        selectedButton.setBorder(BorderFactory.createLineBorder(Color.blue, 2, true));
        btnCheck.setEnabled(true);

    }//GEN-LAST:event_btnAnswer4ActionPerformed

    private void btnCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckActionPerformed
        // TODO add your handling code here:
        answerCheck();
        sendDataToDatabase();
        disableButtons();
    }//GEN-LAST:event_btnCheckActionPerformed

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
            java.util.logging.Logger.getLogger(InformationAndCommunicationTechnology_fillInTheBlanks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformationAndCommunicationTechnology_fillInTheBlanks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformationAndCommunicationTechnology_fillInTheBlanks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformationAndCommunicationTechnology_fillInTheBlanks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformationAndCommunicationTechnology_fillInTheBlanks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnswer1;
    private javax.swing.JButton btnAnswer2;
    private javax.swing.JButton btnAnswer3;
    private javax.swing.JButton btnAnswer4;
    private javax.swing.JButton btnCheck;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblComplete;
    private javax.swing.JLabel lblDisplay;
    private javax.swing.JLabel lblHealth1;
    private javax.swing.JLabel lblHealth2;
    private javax.swing.JLabel lblHealth3;
    private javax.swing.JLabel lblMarks;
    private javax.swing.JLabel lblMrks1;
    private javax.swing.JLabel lblMrks10;
    private javax.swing.JLabel lblMrks2;
    private javax.swing.JLabel lblMrks3;
    private javax.swing.JLabel lblMrks4;
    private javax.swing.JLabel lblMrks5;
    private javax.swing.JLabel lblMrks6;
    private javax.swing.JLabel lblMrks7;
    private javax.swing.JLabel lblMrks8;
    private javax.swing.JLabel lblMrks9;
    private javax.swing.JLabel lblQstn1;
    private javax.swing.JLabel lblQstn10;
    private javax.swing.JLabel lblQstn2;
    private javax.swing.JLabel lblQstn3;
    private javax.swing.JLabel lblQstn4;
    private javax.swing.JLabel lblQstn5;
    private javax.swing.JLabel lblQstn6;
    private javax.swing.JLabel lblQstn7;
    private javax.swing.JLabel lblQstn8;
    private javax.swing.JLabel lblQstn9;
    private javax.swing.JLabel lblQuestion;
    private javax.swing.JLabel lblSidePnlMcqComplete;
    private javax.swing.JLabel lblSidePnlMcqMarks;
    private javax.swing.JLabel lblSidePnlUsername;
    private javax.swing.JLabel lblSidePnlWelcomeName;
    // End of variables declaration//GEN-END:variables
}
