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
import javax.swing.JLabel;

/**
 *
 * @author mmaam
 */
public class InformationAndCommunicationTechnology_MCQ extends javax.swing.JFrame {

    /**
     * Creates new form InformationAndCommunicationTechnology_MCQ
     */
    String RegisterId = "";

    JLabel labelQuestion;
    JLabel labelMarks;

    int complete = 0;
    int health = 3;
    int marks = 0;
    int questonNumber = 1;
    String correctAnswer = "";

    public InformationAndCommunicationTechnology_MCQ() {
        initComponents();
        btnNext.setEnabled(false);
        btnReset.setEnabled(false);
        questonChange();
    }

    public void Setdata(String ID) {
        RegisterId = ID;

        try {
            Connection con = Database.db.getConnection();
            String sql = "SELECT ictFillInTheBlanks_completed,ictFillInTheBlanks_marks FROM digital_learning_game.ict where stdRegisterId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String fillInTheBlanksComplete = rs.getString("ictFillInTheBlanks_completed");
                String fillInTheBlanksMarks = rs.getString("ictFillInTheBlanks_marks");

                //Set data
                lblSidePnlFillInTheBlanksComplete.setText("Completed : " + fillInTheBlanksComplete + "%");
                lblSidePnlFillInTheBlanksMarks.setText("Score : " + fillInTheBlanksMarks);

            }
        } catch (SQLException ex) {
            Logger.getLogger(InformationAndCommunicationTechnology_MCQ.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(InformationAndCommunicationTechnology_MCQ.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sendDataToDatabase() {
        try {
            // create connection to database
            Connection con = Database.db.getConnection();
            // Create prepared statement with the sql query
            PreparedStatement st1 = con.prepareStatement("UPDATE `digital_learning_game`.`ict` SET `ictMCQ_marks` = '" + marks + "', `ictMCQ_complete` = '" + complete + "' WHERE (`stdRegisterId` = '" + RegisterId + "');");
            // execute query
            st1.executeUpdate();

            // show success message
            //JOptionPane.showMessageDialog(this, "Successfully Inserted...");
        } catch (SQLException ex) {
            Logger.getLogger(InformationAndCommunicationTechnology_MCQ.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void disableAnswerButton() {
        radioAns1.setEnabled(false);
        radioAns2.setEnabled(false);
        radioAns3.setEnabled(false);
        radioAns4.setEnabled(false);
    }

    public void enableAnswerButton() {
        radioAns1.setEnabled(true);
        radioAns2.setEnabled(true);
        radioAns3.setEnabled(true);
        radioAns4.setEnabled(true);
    }

    public void questonChange() {
        lblDisplay.setVisible(false);
        btnAns.clearSelection();
        btnNext.setEnabled(false);
        btnCheck.setEnabled(true);
        if (questonNumber == 1) {
            labelQuestion = lblQstn1;
            labelMarks = lblMrks1;
            lblQstn.setText("<html>What does data become when it is processed and organized to convey meaning?</html>");
            radioAns1.setText("Raw data");
            radioAns2.setText("Meaningful data");
            radioAns3.setText("Information");
            radioAns4.setText("Contextual data");
            correctAnswer = radioAns3.getText();
        } else if (questonNumber == 2) {
            labelQuestion = lblQstn2;
            labelMarks = lblMrks2;
            lblQstn.setText("<html>In a computer system, what does the processing component involve?</html>");
            radioAns1.setText("Receiving data");
            radioAns2.setText("Transforming input into output");
            radioAns3.setText("Displaying information");
            radioAns4.setText("Providing feedback");
            correctAnswer = radioAns2.getText();
        } else if (questonNumber == 3) {
            labelQuestion = lblQstn3;
            labelMarks = lblMrks3;
            lblQstn.setText("<html>What are the main components of ICT?</html>");
            radioAns1.setText("Hardware, software, and networks");
            radioAns2.setText("Input, processing, output");
            radioAns3.setText("Data, information, communication");
            radioAns4.setText("People, feedback, control");
            correctAnswer = radioAns1.getText();
        } else if (questonNumber == 4) {
            labelQuestion = lblQstn4;
            labelMarks = lblMrks4;
            lblQstn.setText("<html>Which ICT application is associated with the use of customer relationship management (CRM) systems?</html>");
            radioAns1.setText("Business");
            radioAns2.setText("Education");
            radioAns3.setText("Healthcare");
            radioAns4.setText("Entertainment");
            correctAnswer = radioAns1.getText();
        } else if (questonNumber == 5) {
            labelQuestion = lblQstn5;
            labelMarks = lblMrks5;
            lblQstn.setText("<html>What is a common challenge related to job displacement in the context of ICT?</html>");
            radioAns1.setText("Lack of security");
            radioAns2.setText("Inequality in access");
            radioAns3.setText("Automation affecting employment");
            radioAns4.setText("Privacy issues");
            correctAnswer = radioAns3.getText();
        } else if (questonNumber == 6) {
            labelQuestion = lblQstn6;
            labelMarks = lblMrks6;
            lblQstn.setText("<html>Which generation of computers used vacuum tubes and mainframes?</html>");
            radioAns1.setText("First Generation");
            radioAns2.setText("Second Generation");
            radioAns3.setText("Third Generation");
            radioAns4.setText("Fourth Generation");
            correctAnswer = radioAns1.getText();
        } else if (questonNumber == 7) {
            labelQuestion = lblQstn7;
            labelMarks = lblMrks7;
            lblQstn.setText("<html>What is the primary characteristic of data?</html>");
            radioAns1.setText("Processed and meaningful");
            radioAns2.setText("Lacks context");
            radioAns3.setText("Involves communication");
            radioAns4.setText("Stored in hardware");
            correctAnswer = radioAns2.getText();
        } else if (questonNumber == 8) {
            labelQuestion = lblQstn8;
            labelMarks = lblMrks8;
            lblQstn.setText("<html>What role does feedback play in a system?</html>");
            radioAns1.setText("Input transformation");
            radioAns2.setText("Adjusting system operations");
            radioAns3.setText("Output generation");
            radioAns4.setText("Controlling the environment");
            correctAnswer = radioAns2.getText();
        } else if (questonNumber == 9) {
            labelQuestion = lblQstn9;
            labelMarks = lblMrks9;
            lblQstn.setText("<html>Which ICT component involves the programs and applications that run on a computer?</html>");
            radioAns1.setText("Hardware");
            radioAns2.setText("Software");
            radioAns3.setText("Networks");
            radioAns4.setText("People");
            correctAnswer = radioAns2.getText();
        } else if (questonNumber == 10) {
            labelQuestion = lblQstn10;
            labelMarks = lblMrks10;
            lblQstn.setText("<html>What is a common use of ICT in the education sector?</html>");
            radioAns1.setText("E-governance");
            radioAns2.setText("Telemedicine");
            radioAns3.setText("E-learning");
            radioAns4.setText("Streaming services");
            correctAnswer = radioAns3.getText();
        } else {
            lblDisplay.setText("You Have Done the Game");
            lblDisplay.setForeground(Color.green);
            lblDisplay.setVisible(true);

            disableAnswerButton();
            btnNext.setEnabled(false);
            btnCheck.setEnabled(false);
            btnReset.setEnabled(true);
        }

    }

    public void answerCheck() {
        String answer = "";
        if (radioAns1.isSelected()) {
            answer = radioAns1.getText();
        } else if (radioAns2.isSelected()) {
            answer = radioAns2.getText();
        } else if (radioAns3.isSelected()) {
            answer = radioAns3.getText();
        } else if (radioAns4.isSelected()) {
            answer = radioAns4.getText();
        }

        if (answer == correctAnswer) {
            marks = marks + 10;
            complete = complete + 10;
            labelMarks.setText("10");
            labelMarks.setForeground(Color.green);
            labelQuestion.setForeground(Color.green);
            lblDisplay.setText("Correct");
            lblDisplay.setForeground(Color.green);
            lblDisplay.setVisible(true);

        } else {
            health = health - 1;
            complete = complete + 10;
            labelMarks.setText("00");
            labelMarks.setForeground(Color.red);
            labelQuestion.setForeground(Color.red);
            lblDisplay.setText("Wrong");
            lblDisplay.setForeground(Color.red);
            lblDisplay.setVisible(true);
        }

        lblMarks.setText(marks + "");
        lblComplete.setText("Completed : " + complete + "%");

        disableAnswerButton();
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
            lblHealth1.setVisible(false);
            lblHealth2.setVisible(false);
            lblHealth3.setVisible(false);

            disableAnswerButton();
            btnNext.setEnabled(false);
            btnCheck.setEnabled(false);
            btnReset.setEnabled(true);

            lblDisplay.setText("Your Health is Over, Pls Retry");
            lblDisplay.setForeground(Color.red);
            lblDisplay.setVisible(true);
        }
    }

    public void reset() {
        btnCheck.setEnabled(true);
        btnNext.setEnabled(false);
        btnReset.setEnabled(false);
        enableAnswerButton();

        complete = 0;
        health = 3;
        marks = 0;
        questonNumber = 1;
        questonChange();
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

        btnAns = new javax.swing.ButtonGroup();
        jPanel7 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        lblSidePnlFillInTheBlanksComplete = new javax.swing.JLabel();
        lblSidePnlFillInTheBlanksMarks = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        lblSidePnlWelcomeName = new javax.swing.JLabel();
        lblSidePnlUsername = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblHealth1 = new javax.swing.JLabel();
        lblHealth2 = new javax.swing.JLabel();
        lblHealth3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblMarks = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblQstn = new javax.swing.JLabel();
        radioAns1 = new javax.swing.JRadioButton();
        radioAns2 = new javax.swing.JRadioButton();
        radioAns3 = new javax.swing.JRadioButton();
        radioAns4 = new javax.swing.JRadioButton();
        btnNext = new javax.swing.JButton();
        btnCheck = new javax.swing.JButton();
        lblDisplay = new javax.swing.JLabel();
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
        jLabel9.setText("Fill in The Blanks");

        lblSidePnlFillInTheBlanksComplete.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblSidePnlFillInTheBlanksComplete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSidePnlFillInTheBlanksComplete.setText("Completed : 0%");

        lblSidePnlFillInTheBlanksMarks.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSidePnlFillInTheBlanksMarks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSidePnlFillInTheBlanksMarks.setText("Score : 00");

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
                    .addComponent(lblSidePnlFillInTheBlanksComplete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSidePnlFillInTheBlanksMarks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(lblSidePnlFillInTheBlanksComplete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSidePnlFillInTheBlanksMarks)
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
                .addContainerGap(307, Short.MAX_VALUE))
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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Health");

        lblHealth1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Health.png"))); // NOI18N

        lblHealth2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Health.png"))); // NOI18N

        lblHealth3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Health.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Marks");

        lblMarks.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblMarks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMarks.setText("00");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("MCQ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Information and Communication Technology");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblHealth1)
                        .addGap(18, 18, 18)
                        .addComponent(lblHealth2)
                        .addGap(18, 18, 18)
                        .addComponent(lblHealth3))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(lblMarks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblHealth1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblHealth3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblHealth2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblMarks, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lblQstn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblQstn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQstn.setText("Question 1");

        radioAns1.setBackground(new java.awt.Color(255, 255, 255));
        btnAns.add(radioAns1);
        radioAns1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        radioAns1.setText("Answer 1");

        radioAns2.setBackground(new java.awt.Color(255, 255, 255));
        btnAns.add(radioAns2);
        radioAns2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        radioAns2.setText("Answer 2");

        radioAns3.setBackground(new java.awt.Color(255, 255, 255));
        btnAns.add(radioAns3);
        radioAns3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        radioAns3.setText("Answer 3");

        radioAns4.setBackground(new java.awt.Color(255, 255, 255));
        btnAns.add(radioAns4);
        radioAns4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        radioAns4.setText("Answer 4");

        btnNext.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnCheck.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnCheck.setText("Check");
        btnCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckActionPerformed(evt);
            }
        });

        lblDisplay.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblDisplay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDisplay.setText("Correct");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblQstn, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(radioAns3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(radioAns2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(radioAns1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(radioAns4, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(388, Short.MAX_VALUE)
                        .addComponent(btnCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblQstn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(radioAns1)
                .addGap(18, 18, 18)
                .addComponent(radioAns2)
                .addGap(18, 18, 18)
                .addComponent(radioAns3)
                .addGap(18, 18, 18)
                .addComponent(radioAns4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
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
                        .addGap(7, 7, 7))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(12, Short.MAX_VALUE))))
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
                .addGap(22, 22, 22))
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

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        questonNumber = questonNumber + 1;
        questonChange();

        enableAnswerButton();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckActionPerformed
        // TODO add your handling code here:
        btnCheck.setEnabled(false);
        btnNext.setEnabled(true);
        answerCheck();
        sendDataToDatabase();
    }//GEN-LAST:event_btnCheckActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        reset();
        btnReset.setEnabled(false);
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
            java.util.logging.Logger.getLogger(InformationAndCommunicationTechnology_MCQ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformationAndCommunicationTechnology_MCQ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformationAndCommunicationTechnology_MCQ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformationAndCommunicationTechnology_MCQ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformationAndCommunicationTechnology_MCQ().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnAns;
    private javax.swing.JButton btnCheck;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JLabel lblQstn;
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
    private javax.swing.JLabel lblSidePnlFillInTheBlanksComplete;
    private javax.swing.JLabel lblSidePnlFillInTheBlanksMarks;
    private javax.swing.JLabel lblSidePnlUsername;
    private javax.swing.JLabel lblSidePnlWelcomeName;
    private javax.swing.JRadioButton radioAns1;
    private javax.swing.JRadioButton radioAns2;
    private javax.swing.JRadioButton radioAns3;
    private javax.swing.JRadioButton radioAns4;
    // End of variables declaration//GEN-END:variables
}
