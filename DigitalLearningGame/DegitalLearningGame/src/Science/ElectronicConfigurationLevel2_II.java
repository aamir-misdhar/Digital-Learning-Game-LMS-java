/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Science;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mmaam
 */
public class ElectronicConfigurationLevel2_II extends javax.swing.JInternalFrame {

    /**
     * Creates new form ElectronicConfigurationLevel2_II
     */
    String RegisterId = "";

    int questionNumber = 0;
    int fMarks = 0;
    int marks = 0;
    int complete = 0;
    int health = 8;

    public ElectronicConfigurationLevel2_II() {
        initComponents();
        javax.swing.plaf.InternalFrameUI ifu = this.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) ifu).setNorthPane(null);
        disabeleAll();
        questionChange();
    }

    public void Setdata(String ID) {
        RegisterId = ID;

    }

    public void sendDataToDatabase() {
        
        try {
            // create connection to database
            Connection con = Database.db.getConnection();
            // Create prepared statement with the sql query
            PreparedStatement st1 = con.prepareStatement("UPDATE `digital_learning_game`.`science` SET `electronicConfigurationLevel2_marks_II` = '"+marks+"', `electronicConfigurationLevel2_complete_II` = '"+complete+"' WHERE (`stdRegisterId` = '"+RegisterId+"');");
            // execute query
            st1.executeUpdate();

            // show success message
            //JOptionPane.showMessageDialog(this, "Successfully Inserted...");
        } catch (SQLException ex) {
            Logger.getLogger(MapMarkingDigestiveSystem.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void disabeleAll() {
        //lblIcon1.setEnabled(false);
        cmbBoxAl_K.setEnabled(false);
        cmbBoxAl_L.setEnabled(false);
        cmbBoxAl_M.setEnabled(false);
        cmbBoxAl_N.setEnabled(false);
        btnCheck1.setEnabled(false);

        cmbBoxAr_K.setEnabled(false);
        cmbBoxAr_L.setEnabled(false);
        cmbBoxAr_M.setEnabled(false);
        cmbBoxAr_N.setEnabled(false);
        btnCheck2.setEnabled(false);

        cmbBoxB_K.setEnabled(false);
        cmbBoxB_L.setEnabled(false);
        cmbBoxB_M.setEnabled(false);
        cmbBoxB_N.setEnabled(false);
        btnCheck3.setEnabled(false);

        cmbBoxBe_K.setEnabled(false);
        cmbBoxBe_L.setEnabled(false);
        cmbBoxBe_M.setEnabled(false);
        cmbBoxBe_N.setEnabled(false);
        btnCheck4.setEnabled(false);

        cmbBoxC_K.setEnabled(false);
        cmbBoxC_L.setEnabled(false);
        cmbBoxC_M.setEnabled(false);
        cmbBoxC_N.setEnabled(false);
        btnCheck5.setEnabled(false);

        cmbBoxCa_K.setEnabled(false);
        cmbBoxCa_L.setEnabled(false);
        cmbBoxCa_M.setEnabled(false);
        cmbBoxCa_N.setEnabled(false);
        btnCheck6.setEnabled(false);

        cmbBoxCl_K.setEnabled(false);
        cmbBoxCl_L.setEnabled(false);
        cmbBoxCl_M.setEnabled(false);
        cmbBoxCl_N.setEnabled(false);
        btnCheck7.setEnabled(false);

        cmbBoxF_K.setEnabled(false);
        cmbBoxF_L.setEnabled(false);
        cmbBoxF_M.setEnabled(false);
        cmbBoxF_N.setEnabled(false);
        btnCheck8.setEnabled(false);

        cmbBoxH_K.setEnabled(false);
        cmbBoxH_L.setEnabled(false);
        cmbBoxH_M.setEnabled(false);
        cmbBoxH_N.setEnabled(false);
        btnCheck9.setEnabled(false);

        cmbBoxHe_K.setEnabled(false);
        cmbBoxHe_L.setEnabled(false);
        cmbBoxHe_M.setEnabled(false);
        cmbBoxHe_N.setEnabled(false);
        btnCheck10.setEnabled(false);
    }

    public void questionChange() {

        questionNumber = questionNumber + 1;
        if (questionNumber == 1) {
            cmbBoxAl_K.setEnabled(true);
            cmbBoxAl_L.setEnabled(true);
            cmbBoxAl_M.setEnabled(true);
            cmbBoxAl_N.setEnabled(true);
            btnCheck1.setEnabled(true);
        } else if (questionNumber == 2) {
            cmbBoxAr_K.setEnabled(true);
            cmbBoxAr_L.setEnabled(true);
            cmbBoxAr_M.setEnabled(true);
            cmbBoxAr_N.setEnabled(true);
            btnCheck2.setEnabled(true);
        } else if (questionNumber == 3) {
            cmbBoxB_K.setEnabled(true);
            cmbBoxB_L.setEnabled(true);
            cmbBoxB_M.setEnabled(true);
            cmbBoxB_N.setEnabled(true);
            btnCheck3.setEnabled(true);
        } else if (questionNumber == 4) {
            cmbBoxBe_K.setEnabled(true);
            cmbBoxBe_L.setEnabled(true);
            cmbBoxBe_M.setEnabled(true);
            cmbBoxBe_N.setEnabled(true);
            btnCheck4.setEnabled(true);
        } else if (questionNumber == 5) {
            cmbBoxC_K.setEnabled(true);
            cmbBoxC_L.setEnabled(true);
            cmbBoxC_M.setEnabled(true);
            cmbBoxC_N.setEnabled(true);
            btnCheck5.setEnabled(true);
        } else if (questionNumber == 6) {
            cmbBoxCa_K.setEnabled(true);
            cmbBoxCa_L.setEnabled(true);
            cmbBoxCa_M.setEnabled(true);
            cmbBoxCa_N.setEnabled(true);
            btnCheck6.setEnabled(true);
        } else if (questionNumber == 7) {
            cmbBoxCl_K.setEnabled(true);
            cmbBoxCl_L.setEnabled(true);
            cmbBoxCl_M.setEnabled(true);
            cmbBoxCl_N.setEnabled(true);
            btnCheck7.setEnabled(true);
        } else if (questionNumber == 8) {
            cmbBoxF_K.setEnabled(true);
            cmbBoxF_L.setEnabled(true);
            cmbBoxF_M.setEnabled(true);
            cmbBoxF_N.setEnabled(true);
            btnCheck8.setEnabled(true);
        } else if (questionNumber == 9) {
            cmbBoxH_K.setEnabled(true);
            cmbBoxH_L.setEnabled(true);
            cmbBoxH_M.setEnabled(true);
            cmbBoxH_N.setEnabled(true);
            btnCheck9.setEnabled(true);
        } else if (questionNumber == 10) {
            cmbBoxHe_K.setEnabled(true);
            cmbBoxHe_L.setEnabled(true);
            cmbBoxHe_M.setEnabled(true);
            cmbBoxHe_N.setEnabled(true);
            btnCheck10.setEnabled(true);
        }

        healthCheck();
    }

    public void check() {
        if (questionNumber == 1) {
            question1Check();
            complete = complete + 10;
        } else if (questionNumber == 2) {
            question2Check();
            complete = complete + 10;
        } else if (questionNumber == 3) {
            question3Check();
            complete = complete + 10;
        } else if (questionNumber == 4) {
            question4Check();
            complete = complete + 10;
        } else if (questionNumber == 5) {
            question5Check();
            complete = complete + 10;
        } else if (questionNumber == 6) {
            question6Check();
            complete = complete + 10;
        } else if (questionNumber == 7) {
            question7Check();
            complete = complete + 10;
        } else if (questionNumber == 8) {
            question8Check();
            complete = complete + 10;
        } else if (questionNumber == 9) {
            question9Check();
            complete = complete + 10;
        } else if (questionNumber == 10) {
            question10Check();
            complete = complete + 10;
        }
        marks=fMarks/2;
        lblMarks.setText(marks + "");
        lblComplete.setText("Complete : " + complete + "%");
        healthCheck();
        sendDataToDatabase();
    }

    public void healthCheck() {
        if (health == 8) {
            health1.setVisible(true);
            health2.setVisible(true);
            health3.setVisible(true);
            health4.setVisible(true);
        } else if (health == 6) {
            health1.setVisible(true);
            health2.setVisible(true);
            health3.setVisible(true);
            health4.setVisible(false);
        } else if (health == 4) {
            health1.setVisible(true);
            health2.setVisible(true);
            health3.setVisible(false);
            health4.setVisible(false);
        } else if (health == 2) {
            health1.setVisible(true);
            health2.setVisible(false);
            health3.setVisible(false);
            health4.setVisible(false);
        } else if (health == 0) {
            health1.setVisible(false);
            health2.setVisible(false);
            health3.setVisible(false);
            health4.setVisible(false);
        } else if (health < 0) {
            health1.setVisible(false);
            health2.setVisible(false);
            health3.setVisible(false);
            health4.setVisible(false);
            lblErrorMessage.setText("Reset Game");
            lblErrorMessage.setVisible(true);
            disabeleAll();

        }
    }

    public void question1Check() {
        String k = cmbBoxAl_K.getSelectedItem().toString();
        String l = cmbBoxAl_L.getSelectedItem().toString();
        String m = cmbBoxAl_M.getSelectedItem().toString();
        String n = cmbBoxAl_N.getSelectedItem().toString();

        String correctAnswerK = "02";
        String correctAnswerL = "08";
        String correctAnswerM = "08";
        String correctAnswerN = "01";

        lblCorrectAnsAl_K.setText(correctAnswerK);
        lblCorrectAnsAl_L.setText(correctAnswerL);
        lblCorrectAnsAl_M.setText(correctAnswerM);
        lblCorrectAnsAl_N.setText(correctAnswerN);

        if (k.equals(correctAnswerK)) {
            fMarks = fMarks + 5;
            lblAl_K.setForeground(Color.green);
        } else {
            health = health - 1;
            lblAl_K.setForeground(Color.red);
        }

        if (l.equals(correctAnswerL)) {
            fMarks = fMarks + 5;
            lblAl_L.setForeground(Color.green);
        } else {
            health = health - 1;
            lblAl_L.setForeground(Color.red);
        }

        if (m.equals(correctAnswerM)) {
            fMarks = fMarks + 5;
            lblAl_M.setForeground(Color.green);
        } else {
            health = health - 1;
            lblAl_M.setForeground(Color.red);
        }

        if (n.equals(correctAnswerN)) {
            fMarks = fMarks + 5;
            lblAl_N.setForeground(Color.green);
        } else {
            health = health - 1;
            lblAl_N.setForeground(Color.red);
        }
    }

    public void question2Check() {
        String k = cmbBoxAr_K.getSelectedItem().toString();
        String l = cmbBoxAr_L.getSelectedItem().toString();
        String m = cmbBoxAr_M.getSelectedItem().toString();
        String n = cmbBoxAr_N.getSelectedItem().toString();

        String correctAnswerK = "02";
        String correctAnswerL = "01";
        String correctAnswerM = "00";
        String correctAnswerN = "00";

        lblCorrectAnsAr_K.setText(correctAnswerK);
        lblCorrectAnsAr_L.setText(correctAnswerL);
        lblCorrectAnsAr_M.setText(correctAnswerM);
        lblCorrectAnsAr_N.setText(correctAnswerN);

        if (k.equals(correctAnswerK)) {
            fMarks = fMarks + 5;
            lblAr_K.setForeground(Color.green);
        } else {
            health = health - 1;
            lblAr_K.setForeground(Color.red);
        }

        if (l.equals(correctAnswerL)) {
            fMarks = fMarks + 5;
            lblAr_L.setForeground(Color.green);
        } else {
            health = health - 1;
            lblAr_L.setForeground(Color.red);
        }

        if (m.equals(correctAnswerM)) {
            fMarks = fMarks + 5;
            lblAr_M.setForeground(Color.green);
        } else {
            health = health - 1;
            lblAr_M.setForeground(Color.red);
        }

        if (n.equals(correctAnswerN)) {
            fMarks = fMarks + 5;
            lblAr_N.setForeground(Color.green);
        } else {
            health = health - 1;
            lblAr_N.setForeground(Color.red);
        }
    }

    public void question3Check() {
        String k = cmbBoxB_K.getSelectedItem().toString();
        String l = cmbBoxB_L.getSelectedItem().toString();
        String m = cmbBoxB_M.getSelectedItem().toString();
        String n = cmbBoxB_N.getSelectedItem().toString();

        String correctAnswerK = "02";
        String correctAnswerL = "08";
        String correctAnswerM = "02";
        String correctAnswerN = "00";

        lblCorrectAnsB_K.setText(correctAnswerK);
        lblCorrectAnsB_L.setText(correctAnswerL);
        lblCorrectAnsB_M.setText(correctAnswerM);
        lblCorrectAnsB_N.setText(correctAnswerN);

        if (k.equals(correctAnswerK)) {
            fMarks = fMarks + 5;
            lblB_K.setForeground(Color.green);
        } else {
            health = health - 1;
            lblB_K.setForeground(Color.red);
        }

        if (l.equals(correctAnswerL)) {
            fMarks = fMarks + 5;
            lblB_L.setForeground(Color.green);
        } else {
            health = health - 1;
            lblB_L.setForeground(Color.red);
        }

        if (m.equals(correctAnswerM)) {
            fMarks = fMarks + 5;
            lblB_M.setForeground(Color.green);
        } else {
            health = health - 1;
            lblB_M.setForeground(Color.red);
        }

        if (n.equals(correctAnswerN)) {
            fMarks = fMarks + 5;
            lblB_N.setForeground(Color.green);
        } else {
            health = health - 1;
            lblB_N.setForeground(Color.red);
        }
    }

    public void question4Check() {
        String k = cmbBoxBe_K.getSelectedItem().toString();
        String l = cmbBoxBe_L.getSelectedItem().toString();
        String m = cmbBoxBe_M.getSelectedItem().toString();
        String n = cmbBoxBe_N.getSelectedItem().toString();

        String correctAnswerK = "02";
        String correctAnswerL = "05";
        String correctAnswerM = "00";
        String correctAnswerN = "00";

        lblCorrectAnsBe_K.setText(correctAnswerK);
        lblCorrectAnsBe_L.setText(correctAnswerL);
        lblCorrectAnsBe_M.setText(correctAnswerM);
        lblCorrectAnsBe_N.setText(correctAnswerN);

        if (k.equals(correctAnswerK)) {
            fMarks = fMarks + 5;
            lblBe_K.setForeground(Color.green);
        } else {
            health = health - 1;
            lblBe_K.setForeground(Color.red);
        }

        if (l.equals(correctAnswerL)) {
            fMarks = fMarks + 5;
            lblBe_L.setForeground(Color.green);
        } else {
            health = health - 1;
            lblBe_L.setForeground(Color.red);
        }

        if (m.equals(correctAnswerM)) {
            fMarks = fMarks + 5;
            lblBe_M.setForeground(Color.green);
        } else {
            health = health - 1;
            lblBe_M.setForeground(Color.red);
        }

        if (n.equals(correctAnswerN)) {
            fMarks = fMarks + 5;
            lblBe_N.setForeground(Color.green);
        } else {
            health = health - 1;
            lblBe_N.setForeground(Color.red);
        }
    }

    public void question5Check() {
        String k = cmbBoxC_K.getSelectedItem().toString();
        String l = cmbBoxC_L.getSelectedItem().toString();
        String m = cmbBoxC_M.getSelectedItem().toString();
        String n = cmbBoxC_N.getSelectedItem().toString();

        String correctAnswerK = "02";
        String correctAnswerL = "08";
        String correctAnswerM = "01";
        String correctAnswerN = "00";

        lblCorrectAnsC_K.setText(correctAnswerK);
        lblCorrectAnsC_L.setText(correctAnswerL);
        lblCorrectAnsC_M.setText(correctAnswerM);
        lblCorrectAnsC_N.setText(correctAnswerN);

        if (k.equals(correctAnswerK)) {
            fMarks = fMarks + 5;
            lblC_K.setForeground(Color.green);
        } else {
            health = health - 1;
            lblC_K.setForeground(Color.red);
        }

        if (l.equals(correctAnswerL)) {
            fMarks = fMarks + 5;
            lblC_L.setForeground(Color.green);
        } else {
            health = health - 1;
            lblC_L.setForeground(Color.red);
        }

        if (m.equals(correctAnswerM)) {
            fMarks = fMarks + 5;
            lblC_M.setForeground(Color.green);
        } else {
            health = health - 1;
            lblC_M.setForeground(Color.red);
        }

        if (n.equals(correctAnswerN)) {
            fMarks = fMarks + 5;
            lblC_N.setForeground(Color.green);
        } else {
            health = health - 1;
            lblC_N.setForeground(Color.red);
        }
    }

    public void question6Check() {
        String k = cmbBoxCa_K.getSelectedItem().toString();
        String l = cmbBoxCa_L.getSelectedItem().toString();
        String m = cmbBoxCa_M.getSelectedItem().toString();
        String n = cmbBoxCa_N.getSelectedItem().toString();

        String correctAnswerK = "02";
        String correctAnswerL = "06";
        String correctAnswerM = "00";
        String correctAnswerN = "00";

        lblCorrectAnsCa_K.setText(correctAnswerK);
        lblCorrectAnsCa_L.setText(correctAnswerL);
        lblCorrectAnsCa_M.setText(correctAnswerM);
        lblCorrectAnsCa_N.setText(correctAnswerN);

        if (k.equals(correctAnswerK)) {
            fMarks = fMarks + 5;
            lblCa_K.setForeground(Color.green);
        } else {
            health = health - 1;
            lblCa_K.setForeground(Color.red);
        }

        if (l.equals(correctAnswerL)) {
            fMarks = fMarks + 5;
            lblCa_L.setForeground(Color.green);
        } else {
            health = health - 1;
            lblCa_L.setForeground(Color.red);
        }

        if (m.equals(correctAnswerM)) {
            fMarks = fMarks + 5;
            lblCa_M.setForeground(Color.green);
        } else {
            health = health - 1;
            lblCa_M.setForeground(Color.red);
        }

        if (n.equals(correctAnswerN)) {
            fMarks = fMarks + 5;
            lblCa_N.setForeground(Color.green);
        } else {
            health = health - 1;
            lblCa_N.setForeground(Color.red);
        }
    }

    public void question7Check() {
        String k = cmbBoxCl_K.getSelectedItem().toString();
        String l = cmbBoxCl_L.getSelectedItem().toString();
        String m = cmbBoxCl_M.getSelectedItem().toString();
        String n = cmbBoxCl_N.getSelectedItem().toString();

        String correctAnswerK = "02";
        String correctAnswerL = "08";
        String correctAnswerM = "05";
        String correctAnswerN = "00";

        lblCorrectAnsCl_K.setText(correctAnswerK);
        lblCorrectAnsCl_L.setText(correctAnswerL);
        lblCorrectAnsCl_M.setText(correctAnswerM);
        lblCorrectAnsCl_N.setText(correctAnswerN);

        if (k.equals(correctAnswerK)) {
            fMarks = fMarks + 5;
            lblCl_K.setForeground(Color.green);
        } else {
            health = health - 1;
            lblCl_K.setForeground(Color.red);
        }

        if (l.equals(correctAnswerL)) {
            fMarks = fMarks + 5;
            lblCl_L.setForeground(Color.green);
        } else {
            health = health - 1;
            lblCl_L.setForeground(Color.red);
        }

        if (m.equals(correctAnswerM)) {
            fMarks = fMarks + 5;
            lblCl_M.setForeground(Color.green);
        } else {
            health = health - 1;
            lblCl_M.setForeground(Color.red);
        }

        if (n.equals(correctAnswerN)) {
            fMarks = fMarks + 5;
            lblCl_N.setForeground(Color.green);
        } else {
            health = health - 1;
            lblCl_N.setForeground(Color.red);
        }
    }

    public void question8Check() {
        String k = cmbBoxF_K.getSelectedItem().toString();
        String l = cmbBoxF_L.getSelectedItem().toString();
        String m = cmbBoxF_M.getSelectedItem().toString();
        String n = cmbBoxF_N.getSelectedItem().toString();

        String correctAnswerK = "02";
        String correctAnswerL = "08";
        String correctAnswerM = "06";
        String correctAnswerN = "00";

        lblCorrectAnsF_K.setText(correctAnswerK);
        lblCorrectAnsF_L.setText(correctAnswerL);
        lblCorrectAnsF_M.setText(correctAnswerM);
        lblCorrectAnsF_N.setText(correctAnswerN);

        if (k.equals(correctAnswerK)) {
            fMarks = fMarks + 5;
            lblF_K.setForeground(Color.green);
        } else {
            health = health - 1;
            lblF_K.setForeground(Color.red);
        }

        if (l.equals(correctAnswerL)) {
            fMarks = fMarks + 5;
            lblF_L.setForeground(Color.green);
        } else {
            health = health - 1;
            lblF_L.setForeground(Color.red);
        }

        if (m.equals(correctAnswerM)) {
            fMarks = fMarks + 5;
            lblF_M.setForeground(Color.green);
        } else {
            health = health - 1;
            lblF_M.setForeground(Color.red);
        }

        if (n.equals(correctAnswerN)) {
            fMarks = fMarks + 5;
            lblF_N.setForeground(Color.green);
        } else {
            health = health - 1;
            lblF_N.setForeground(Color.red);
        }
    }

    public void question9Check() {
        String k = cmbBoxH_K.getSelectedItem().toString();
        String l = cmbBoxH_L.getSelectedItem().toString();
        String m = cmbBoxH_M.getSelectedItem().toString();
        String n = cmbBoxH_N.getSelectedItem().toString();

        String correctAnswerK = "02";
        String correctAnswerL = "08";
        String correctAnswerM = "04";
        String correctAnswerN = "00";

        lblCorrectAnsH_K.setText(correctAnswerK);
        lblCorrectAnsH_L.setText(correctAnswerL);
        lblCorrectAnsH_M.setText(correctAnswerM);
        lblCorrectAnsH_N.setText(correctAnswerN);

        if (k.equals(correctAnswerK)) {
            fMarks = fMarks + 5;
            lblH_K.setForeground(Color.green);
        } else {
            health = health - 1;
            lblH_K.setForeground(Color.red);
        }

        if (l.equals(correctAnswerL)) {
            fMarks = fMarks + 5;
            lblH_L.setForeground(Color.green);
        } else {
            health = health - 1;
            lblH_L.setForeground(Color.red);
        }

        if (m.equals(correctAnswerM)) {
            fMarks = fMarks + 5;
            lblH_M.setForeground(Color.green);
        } else {
            health = health - 1;
            lblH_M.setForeground(Color.red);
        }

        if (n.equals(correctAnswerN)) {
            fMarks = fMarks + 5;
            lblH_N.setForeground(Color.green);
        } else {
            health = health - 1;
            lblH_N.setForeground(Color.red);
        }
    }

    public void question10Check() {
        String k = cmbBoxHe_K.getSelectedItem().toString();
        String l = cmbBoxHe_L.getSelectedItem().toString();
        String m = cmbBoxHe_M.getSelectedItem().toString();
        String n = cmbBoxHe_N.getSelectedItem().toString();

        String correctAnswerK = "02";
        String correctAnswerL = "08";
        String correctAnswerM = "00";
        String correctAnswerN = "00";

        lblCorrectAnsHe_K.setText(correctAnswerK);
        lblCorrectAnsHe_L.setText(correctAnswerL);
        lblCorrectAnsHe_M.setText(correctAnswerM);
        lblCorrectAnsHe_N.setText(correctAnswerN);

        if (k.equals(correctAnswerK)) {
            fMarks = fMarks + 5;
            lblHe_K.setForeground(Color.green);
        } else {
            health = health - 1;
            lblHe_K.setForeground(Color.red);
        }

        if (l.equals(correctAnswerL)) {
            fMarks = fMarks + 5;
            lblHe_L.setForeground(Color.green);
        } else {
            health = health - 1;
            lblHe_L.setForeground(Color.red);
        }

        if (m.equals(correctAnswerM)) {
            fMarks = fMarks + 5;
            lblHe_M.setForeground(Color.green);
        } else {
            health = health - 1;
            lblHe_M.setForeground(Color.red);
        }

        if (n.equals(correctAnswerN)) {
            fMarks = fMarks + 5;
            lblHe_N.setForeground(Color.green);
        } else {
            health = health - 1;
            lblHe_N.setForeground(Color.red);
        }
    }

    public void resetGame() {
        questionNumber = 0;
        fMarks = 0;
        complete = 0;
        health = 4;

        lblMarks.setText(marks+"");
        lblComplete.setText("Complete : "+complete+"%");
        
        lblAl_K.setForeground(Color.black);
        lblAl_L.setForeground(Color.black);
        lblAl_M.setForeground(Color.black);
        lblAl_N.setForeground(Color.black);
        
        lblAr_K.setForeground(Color.black);
        lblAr_L.setForeground(Color.black);
        lblAr_M.setForeground(Color.black);
        lblAr_N.setForeground(Color.black);
        
        lblB_K.setForeground(Color.black);
        lblB_L.setForeground(Color.black);
        lblB_M.setForeground(Color.black);
        lblB_N.setForeground(Color.black);
        
        lblBe_K.setForeground(Color.black);
        lblBe_L.setForeground(Color.black);
        lblBe_M.setForeground(Color.black);
        lblBe_N.setForeground(Color.black);
        
        lblC_K.setForeground(Color.black);
        lblC_L.setForeground(Color.black);
        lblC_M.setForeground(Color.black);
        lblC_N.setForeground(Color.black);
        
        lblCa_K.setForeground(Color.black);
        lblCa_L.setForeground(Color.black);
        lblCa_M.setForeground(Color.black);
        lblCa_N.setForeground(Color.black);
        
        lblCl_K.setForeground(Color.black);
        lblCl_L.setForeground(Color.black);
        lblCl_M.setForeground(Color.black);
        lblCl_N.setForeground(Color.black);
        
        lblF_K.setForeground(Color.black);
        lblF_L.setForeground(Color.black);
        lblF_M.setForeground(Color.black);
        lblF_N.setForeground(Color.black);
        
        lblH_K.setForeground(Color.black);
        lblH_L.setForeground(Color.black);
        lblH_M.setForeground(Color.black);
        lblH_N.setForeground(Color.black);
        
        lblHe_K.setForeground(Color.black);
        lblHe_L.setForeground(Color.black);
        lblHe_M.setForeground(Color.black);
        lblHe_N.setForeground(Color.black);
        
        
        cmbBoxAl_K.setSelectedIndex(0);
        cmbBoxAl_L.setSelectedIndex(0);
        cmbBoxAl_M.setSelectedIndex(0);
        cmbBoxAl_N.setSelectedIndex(0);
        
        cmbBoxAr_K.setSelectedIndex(0);
        cmbBoxAr_L.setSelectedIndex(0);
        cmbBoxAr_M.setSelectedIndex(0);
        cmbBoxAr_N.setSelectedIndex(0);
        
        cmbBoxB_K.setSelectedIndex(0);
        cmbBoxB_L.setSelectedIndex(0);
        cmbBoxB_M.setSelectedIndex(0);
        cmbBoxB_N.setSelectedIndex(0);
        
        cmbBoxBe_K.setSelectedIndex(0);
        cmbBoxBe_L.setSelectedIndex(0);
        cmbBoxBe_M.setSelectedIndex(0);
        cmbBoxBe_N.setSelectedIndex(0);
        
        cmbBoxC_K.setSelectedIndex(0);
        cmbBoxC_L.setSelectedIndex(0);
        cmbBoxC_M.setSelectedIndex(0);
        cmbBoxC_N.setSelectedIndex(0);
        
        cmbBoxCa_K.setSelectedIndex(0);
        cmbBoxCa_L.setSelectedIndex(0);
        cmbBoxCa_M.setSelectedIndex(0);
        cmbBoxCa_N.setSelectedIndex(0);
        
        cmbBoxCl_K.setSelectedIndex(0);
        cmbBoxCl_L.setSelectedIndex(0);
        cmbBoxCl_M.setSelectedIndex(0);
        cmbBoxCl_N.setSelectedIndex(0);
        
        cmbBoxF_K.setSelectedIndex(0);
        cmbBoxF_L.setSelectedIndex(0);
        cmbBoxF_M.setSelectedIndex(0);
        cmbBoxF_N.setSelectedIndex(0);
        
        cmbBoxH_K.setSelectedIndex(0);
        cmbBoxH_L.setSelectedIndex(0);
        cmbBoxH_M.setSelectedIndex(0);
        cmbBoxH_N.setSelectedIndex(0);
        
        cmbBoxHe_K.setSelectedIndex(0);
        cmbBoxHe_L.setSelectedIndex(0);
        cmbBoxHe_M.setSelectedIndex(0);
        cmbBoxHe_N.setSelectedIndex(0);
        
        
        lblCorrectAnsAl_K.setText("00");
        lblCorrectAnsAl_L.setText("00");
        lblCorrectAnsAl_M.setText("00");
        lblCorrectAnsAl_N.setText("00");
        
        lblCorrectAnsAr_K.setText("00");
        lblCorrectAnsAr_L.setText("00");
        lblCorrectAnsAr_M.setText("00");
        lblCorrectAnsAr_N.setText("00");
        
        lblCorrectAnsB_K.setText("00");
        lblCorrectAnsB_L.setText("00");
        lblCorrectAnsB_M.setText("00");
        lblCorrectAnsB_N.setText("00");
        
        lblCorrectAnsBe_K.setText("00");
        lblCorrectAnsBe_L.setText("00");
        lblCorrectAnsBe_M.setText("00");
        lblCorrectAnsBe_N.setText("00");
        
        lblCorrectAnsC_K.setText("00");
        lblCorrectAnsC_L.setText("00");
        lblCorrectAnsC_M.setText("00");
        lblCorrectAnsC_N.setText("00");
        
        lblCorrectAnsCa_K.setText("00");
        lblCorrectAnsCa_L.setText("00");
        lblCorrectAnsCa_M.setText("00");
        lblCorrectAnsCa_N.setText("00");
        
        lblCorrectAnsCl_K.setText("00");
        lblCorrectAnsCl_L.setText("00");
        lblCorrectAnsCl_M.setText("00");
        lblCorrectAnsCl_N.setText("00");
        
        lblCorrectAnsF_K.setText("00");
        lblCorrectAnsF_L.setText("00");
        lblCorrectAnsF_M.setText("00");
        lblCorrectAnsF_N.setText("00");
        
        lblCorrectAnsH_K.setText("00");
        lblCorrectAnsH_L.setText("00");
        lblCorrectAnsH_M.setText("00");
        lblCorrectAnsH_N.setText("00");
        
        lblCorrectAnsHe_K.setText("00");
        lblCorrectAnsHe_L.setText("00");
        lblCorrectAnsHe_M.setText("00");
        lblCorrectAnsHe_N.setText("00");


        
        disabeleAll();
        questionChange();
        
        
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
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblMarks = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        health1 = new javax.swing.JLabel();
        health2 = new javax.swing.JLabel();
        health3 = new javax.swing.JLabel();
        health4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        lblCorrectAnsAl_K = new javax.swing.JLabel();
        lblCorrectAnsAl_L = new javax.swing.JLabel();
        lblCorrectAnsAl_M = new javax.swing.JLabel();
        lblCorrectAnsAl_N = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        lblCorrectAnsAr_K = new javax.swing.JLabel();
        lblCorrectAnsAr_L = new javax.swing.JLabel();
        lblCorrectAnsAr_M = new javax.swing.JLabel();
        lblCorrectAnsAr_N = new javax.swing.JLabel();
        lblCorrectAnsB_L = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        lblCorrectAnsB_N = new javax.swing.JLabel();
        lblCorrectAnsB_K = new javax.swing.JLabel();
        lblCorrectAnsB_M = new javax.swing.JLabel();
        lblCorrectAnsBe_M = new javax.swing.JLabel();
        lblCorrectAnsBe_K = new javax.swing.JLabel();
        lblCorrectAnsBe_N = new javax.swing.JLabel();
        lblCorrectAnsBe_L = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        lblCorrectAnsC_M = new javax.swing.JLabel();
        lblCorrectAnsC_L = new javax.swing.JLabel();
        lblCorrectAnsC_K = new javax.swing.JLabel();
        lblCorrectAnsC_N = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        lblCorrectAnsCa_L = new javax.swing.JLabel();
        lblCorrectAnsCa_M = new javax.swing.JLabel();
        lblCorrectAnsCa_K = new javax.swing.JLabel();
        lblCorrectAnsCa_N = new javax.swing.JLabel();
        lblCorrectAnsCl_M = new javax.swing.JLabel();
        lblCorrectAnsCl_L = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        lblCorrectAnsCl_K = new javax.swing.JLabel();
        lblCorrectAnsCl_N = new javax.swing.JLabel();
        lblCorrectAnsF_K = new javax.swing.JLabel();
        lblCorrectAnsF_M = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        lblCorrectAnsF_N = new javax.swing.JLabel();
        lblCorrectAnsF_L = new javax.swing.JLabel();
        lblCorrectAnsH_K = new javax.swing.JLabel();
        lblCorrectAnsH_M = new javax.swing.JLabel();
        lblCorrectAnsH_L = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        lblCorrectAnsH_N = new javax.swing.JLabel();
        lblCorrectAnsHe_L = new javax.swing.JLabel();
        lblCorrectAnsHe_M = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        lblCorrectAnsHe_N = new javax.swing.JLabel();
        lblCorrectAnsHe_K = new javax.swing.JLabel();
        lblComplete = new javax.swing.JLabel();
        lblErrorMessage = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        lblIcon6 = new javax.swing.JLabel();
        lblCa_K = new javax.swing.JLabel();
        cmbBoxCa_K = new javax.swing.JComboBox<>();
        lblCa_L = new javax.swing.JLabel();
        cmbBoxCa_L = new javax.swing.JComboBox<>();
        lblCa_M = new javax.swing.JLabel();
        cmbBoxCa_M = new javax.swing.JComboBox<>();
        lblCa_N = new javax.swing.JLabel();
        cmbBoxCa_N = new javax.swing.JComboBox<>();
        btnCheck6 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        lblIcon1 = new javax.swing.JLabel();
        lblAl_K = new javax.swing.JLabel();
        cmbBoxAl_K = new javax.swing.JComboBox<>();
        lblAl_L = new javax.swing.JLabel();
        cmbBoxAl_L = new javax.swing.JComboBox<>();
        lblAl_M = new javax.swing.JLabel();
        cmbBoxAl_M = new javax.swing.JComboBox<>();
        lblAl_N = new javax.swing.JLabel();
        cmbBoxAl_N = new javax.swing.JComboBox<>();
        btnCheck1 = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        lblIcon7 = new javax.swing.JLabel();
        lblCl_K = new javax.swing.JLabel();
        cmbBoxCl_K = new javax.swing.JComboBox<>();
        lblCl_L = new javax.swing.JLabel();
        cmbBoxCl_L = new javax.swing.JComboBox<>();
        lblCl_M = new javax.swing.JLabel();
        cmbBoxCl_M = new javax.swing.JComboBox<>();
        lblCl_N = new javax.swing.JLabel();
        cmbBoxCl_N = new javax.swing.JComboBox<>();
        btnCheck7 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        lblIcon2 = new javax.swing.JLabel();
        lblAr_K = new javax.swing.JLabel();
        cmbBoxAr_K = new javax.swing.JComboBox<>();
        lblAr_L = new javax.swing.JLabel();
        cmbBoxAr_L = new javax.swing.JComboBox<>();
        lblAr_M = new javax.swing.JLabel();
        cmbBoxAr_M = new javax.swing.JComboBox<>();
        lblAr_N = new javax.swing.JLabel();
        cmbBoxAr_N = new javax.swing.JComboBox<>();
        btnCheck2 = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        lblIcon3 = new javax.swing.JLabel();
        lblB_K = new javax.swing.JLabel();
        cmbBoxB_K = new javax.swing.JComboBox<>();
        lblB_L = new javax.swing.JLabel();
        cmbBoxB_L = new javax.swing.JComboBox<>();
        lblB_M = new javax.swing.JLabel();
        cmbBoxB_M = new javax.swing.JComboBox<>();
        lblB_N = new javax.swing.JLabel();
        cmbBoxB_N = new javax.swing.JComboBox<>();
        btnCheck3 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        lblIcon8 = new javax.swing.JLabel();
        lblF_K = new javax.swing.JLabel();
        cmbBoxF_K = new javax.swing.JComboBox<>();
        lblF_L = new javax.swing.JLabel();
        cmbBoxF_L = new javax.swing.JComboBox<>();
        lblF_M = new javax.swing.JLabel();
        cmbBoxF_M = new javax.swing.JComboBox<>();
        lblF_N = new javax.swing.JLabel();
        cmbBoxF_N = new javax.swing.JComboBox<>();
        btnCheck8 = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        lblIcon4 = new javax.swing.JLabel();
        lblBe_K = new javax.swing.JLabel();
        cmbBoxBe_K = new javax.swing.JComboBox<>();
        lblBe_L = new javax.swing.JLabel();
        cmbBoxBe_L = new javax.swing.JComboBox<>();
        lblBe_M = new javax.swing.JLabel();
        cmbBoxBe_M = new javax.swing.JComboBox<>();
        lblBe_N = new javax.swing.JLabel();
        cmbBoxBe_N = new javax.swing.JComboBox<>();
        btnCheck4 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        lblIcon9 = new javax.swing.JLabel();
        lblH_K = new javax.swing.JLabel();
        cmbBoxH_K = new javax.swing.JComboBox<>();
        lblH_L = new javax.swing.JLabel();
        cmbBoxH_L = new javax.swing.JComboBox<>();
        lblH_M = new javax.swing.JLabel();
        cmbBoxH_M = new javax.swing.JComboBox<>();
        lblH_N = new javax.swing.JLabel();
        cmbBoxH_N = new javax.swing.JComboBox<>();
        btnCheck9 = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        lblIcon10 = new javax.swing.JLabel();
        lblHe_K = new javax.swing.JLabel();
        cmbBoxHe_K = new javax.swing.JComboBox<>();
        lblHe_L = new javax.swing.JLabel();
        cmbBoxHe_L = new javax.swing.JComboBox<>();
        lblHe_M = new javax.swing.JLabel();
        cmbBoxHe_M = new javax.swing.JComboBox<>();
        lblHe_N = new javax.swing.JLabel();
        cmbBoxHe_N = new javax.swing.JComboBox<>();
        btnCheck10 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        lblIcon5 = new javax.swing.JLabel();
        lblC_K = new javax.swing.JLabel();
        cmbBoxC_K = new javax.swing.JComboBox<>();
        lblC_L = new javax.swing.JLabel();
        cmbBoxC_L = new javax.swing.JComboBox<>();
        lblC_M = new javax.swing.JLabel();
        cmbBoxC_M = new javax.swing.JComboBox<>();
        lblC_N = new javax.swing.JLabel();
        cmbBoxC_N = new javax.swing.JComboBox<>();
        btnCheck5 = new javax.swing.JButton();

        setBorder(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Level 2");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Eletronic configuration");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Marks");

        lblMarks.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblMarks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMarks.setText("00");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Health");

        health1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Health.png"))); // NOI18N

        health2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Health.png"))); // NOI18N

        health3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Health.png"))); // NOI18N

        health4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Health.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(health1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(health2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(health3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(health4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                    .addComponent(lblMarks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(lblMarks)
                    .addComponent(health1)
                    .addComponent(health2)
                    .addComponent(health3)
                    .addComponent(health4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Correct Answer");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Eletrone");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("N");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("M");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("L");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(102, 102, 102));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("K");

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel31.setText("Potassium");

        lblCorrectAnsAl_K.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCorrectAnsAl_K.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorrectAnsAl_K.setText("00");

        lblCorrectAnsAl_L.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCorrectAnsAl_L.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorrectAnsAl_L.setText("00");

        lblCorrectAnsAl_M.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCorrectAnsAl_M.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorrectAnsAl_M.setText("00");

        lblCorrectAnsAl_N.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCorrectAnsAl_N.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorrectAnsAl_N.setText("00");

        jLabel56.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel56.setText("Lithium");

        lblCorrectAnsAr_K.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCorrectAnsAr_K.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorrectAnsAr_K.setText("00");

        lblCorrectAnsAr_L.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCorrectAnsAr_L.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorrectAnsAr_L.setText("00");

        lblCorrectAnsAr_M.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCorrectAnsAr_M.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorrectAnsAr_M.setText("00");

        lblCorrectAnsAr_N.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCorrectAnsAr_N.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorrectAnsAr_N.setText("00");

        lblCorrectAnsB_L.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCorrectAnsB_L.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorrectAnsB_L.setText("00");

        jLabel62.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel62.setText("Magnesi...");

        lblCorrectAnsB_N.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCorrectAnsB_N.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorrectAnsB_N.setText("00");

        lblCorrectAnsB_K.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCorrectAnsB_K.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorrectAnsB_K.setText("00");

        lblCorrectAnsB_M.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCorrectAnsB_M.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorrectAnsB_M.setText("00");

        lblCorrectAnsBe_M.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCorrectAnsBe_M.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorrectAnsBe_M.setText("00");

        lblCorrectAnsBe_K.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCorrectAnsBe_K.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorrectAnsBe_K.setText("00");

        lblCorrectAnsBe_N.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCorrectAnsBe_N.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorrectAnsBe_N.setText("00");

        lblCorrectAnsBe_L.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCorrectAnsBe_L.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorrectAnsBe_L.setText("00");

        jLabel70.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel70.setText("Nitrogen");

        jLabel71.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel71.setText("Sodium");

        lblCorrectAnsC_M.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCorrectAnsC_M.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorrectAnsC_M.setText("00");

        lblCorrectAnsC_L.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCorrectAnsC_L.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorrectAnsC_L.setText("00");

        lblCorrectAnsC_K.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCorrectAnsC_K.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorrectAnsC_K.setText("00");

        lblCorrectAnsC_N.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCorrectAnsC_N.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorrectAnsC_N.setText("00");

        jLabel76.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel76.setText("Oxygen");

        lblCorrectAnsCa_L.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCorrectAnsCa_L.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorrectAnsCa_L.setText("00");

        lblCorrectAnsCa_M.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCorrectAnsCa_M.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorrectAnsCa_M.setText("00");

        lblCorrectAnsCa_K.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCorrectAnsCa_K.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorrectAnsCa_K.setText("00");

        lblCorrectAnsCa_N.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCorrectAnsCa_N.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorrectAnsCa_N.setText("00");

        lblCorrectAnsCl_M.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCorrectAnsCl_M.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorrectAnsCl_M.setText("00");

        lblCorrectAnsCl_L.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCorrectAnsCl_L.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorrectAnsCl_L.setText("00");

        jLabel83.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel83.setText("Phospho..");

        lblCorrectAnsCl_K.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCorrectAnsCl_K.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorrectAnsCl_K.setText("00");

        lblCorrectAnsCl_N.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCorrectAnsCl_N.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorrectAnsCl_N.setText("00");

        lblCorrectAnsF_K.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCorrectAnsF_K.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorrectAnsF_K.setText("00");

        lblCorrectAnsF_M.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCorrectAnsF_M.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorrectAnsF_M.setText("00");

        jLabel88.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel88.setText("Sulfur");

        lblCorrectAnsF_N.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCorrectAnsF_N.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorrectAnsF_N.setText("00");

        lblCorrectAnsF_L.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCorrectAnsF_L.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorrectAnsF_L.setText("00");

        lblCorrectAnsH_K.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCorrectAnsH_K.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorrectAnsH_K.setText("00");

        lblCorrectAnsH_M.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCorrectAnsH_M.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorrectAnsH_M.setText("00");

        lblCorrectAnsH_L.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCorrectAnsH_L.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorrectAnsH_L.setText("00");

        jLabel94.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel94.setText("Silicon");

        lblCorrectAnsH_N.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCorrectAnsH_N.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorrectAnsH_N.setText("00");

        lblCorrectAnsHe_L.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCorrectAnsHe_L.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorrectAnsHe_L.setText("00");

        lblCorrectAnsHe_M.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCorrectAnsHe_M.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorrectAnsHe_M.setText("00");

        jLabel98.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel98.setText("Neon");

        lblCorrectAnsHe_N.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCorrectAnsHe_N.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorrectAnsHe_N.setText("00");

        lblCorrectAnsHe_K.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCorrectAnsHe_K.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorrectAnsHe_K.setText("00");

        lblComplete.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblComplete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblComplete.setText("Complete : 0%");

        lblErrorMessage.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblErrorMessage.setForeground(new java.awt.Color(204, 0, 51));
        lblErrorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblErrorMessage.setText("Error Message");

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
                    .addComponent(lblErrorMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCorrectAnsAl_K, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCorrectAnsAl_L, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCorrectAnsAl_M, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCorrectAnsAl_N, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCorrectAnsAr_K, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCorrectAnsAr_L, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCorrectAnsAr_M, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCorrectAnsAr_N, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCorrectAnsB_K, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCorrectAnsB_L, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCorrectAnsB_M, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCorrectAnsB_N, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel70, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCorrectAnsBe_K, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCorrectAnsBe_L, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCorrectAnsBe_M, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCorrectAnsBe_N, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel71, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCorrectAnsC_K, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCorrectAnsC_L, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCorrectAnsC_M, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCorrectAnsC_N, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel76, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCorrectAnsCa_K, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCorrectAnsCa_L, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCorrectAnsCa_M, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCorrectAnsCa_N, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel83, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCorrectAnsCl_K, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCorrectAnsCl_L, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCorrectAnsCl_M, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCorrectAnsCl_N, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel88, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCorrectAnsF_K, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCorrectAnsF_L, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCorrectAnsF_M, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCorrectAnsF_N, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel94, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCorrectAnsH_K, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCorrectAnsH_L, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCorrectAnsH_M, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCorrectAnsH_N, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel98, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCorrectAnsHe_K, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCorrectAnsHe_L, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCorrectAnsHe_M, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCorrectAnsHe_N, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblComplete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblComplete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jLabel21)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(lblCorrectAnsAl_N)
                    .addComponent(lblCorrectAnsAl_M)
                    .addComponent(lblCorrectAnsAl_L)
                    .addComponent(lblCorrectAnsAl_K))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(lblCorrectAnsAr_N)
                    .addComponent(lblCorrectAnsAr_M)
                    .addComponent(lblCorrectAnsAr_L)
                    .addComponent(lblCorrectAnsAr_K))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62)
                    .addComponent(lblCorrectAnsB_N)
                    .addComponent(lblCorrectAnsB_M)
                    .addComponent(lblCorrectAnsB_L)
                    .addComponent(lblCorrectAnsB_K))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel70)
                    .addComponent(lblCorrectAnsBe_N)
                    .addComponent(lblCorrectAnsBe_M)
                    .addComponent(lblCorrectAnsBe_L)
                    .addComponent(lblCorrectAnsBe_K))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel71)
                    .addComponent(lblCorrectAnsC_N)
                    .addComponent(lblCorrectAnsC_M)
                    .addComponent(lblCorrectAnsC_L)
                    .addComponent(lblCorrectAnsC_K))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel76)
                    .addComponent(lblCorrectAnsCa_N)
                    .addComponent(lblCorrectAnsCa_M)
                    .addComponent(lblCorrectAnsCa_L)
                    .addComponent(lblCorrectAnsCa_K))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel83)
                    .addComponent(lblCorrectAnsCl_N)
                    .addComponent(lblCorrectAnsCl_M)
                    .addComponent(lblCorrectAnsCl_L)
                    .addComponent(lblCorrectAnsCl_K))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel88)
                    .addComponent(lblCorrectAnsF_N)
                    .addComponent(lblCorrectAnsF_M)
                    .addComponent(lblCorrectAnsF_L)
                    .addComponent(lblCorrectAnsF_K))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel94)
                    .addComponent(lblCorrectAnsH_N)
                    .addComponent(lblCorrectAnsH_M)
                    .addComponent(lblCorrectAnsH_L)
                    .addComponent(lblCorrectAnsH_K))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel98)
                    .addComponent(lblCorrectAnsHe_N)
                    .addComponent(lblCorrectAnsHe_M)
                    .addComponent(lblCorrectAnsHe_L)
                    .addComponent(lblCorrectAnsHe_K))
                .addGap(18, 18, 18)
                .addComponent(lblErrorMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReset)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        lblIcon6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_O.png"))); // NOI18N

        lblCa_K.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCa_K.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCa_K.setText("K");

        cmbBoxCa_K.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbBoxCa_K.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02" }));

        lblCa_L.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCa_L.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCa_L.setText("L");

        cmbBoxCa_L.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbBoxCa_L.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08" }));

        lblCa_M.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCa_M.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCa_M.setText("M");

        cmbBoxCa_M.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbBoxCa_M.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08" }));

        lblCa_N.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCa_N.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCa_N.setText("N");

        cmbBoxCa_N.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbBoxCa_N.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02" }));

        btnCheck6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCheck6.setText("Check");
        btnCheck6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheck6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIcon6)
                .addGap(12, 12, 12)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbBoxCa_K, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCa_K, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbBoxCa_L, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCa_L, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbBoxCa_M, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCa_M, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbBoxCa_N, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCa_N, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnCheck6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIcon6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(lblCa_N)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBoxCa_N, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(lblCa_M)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBoxCa_M, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(lblCa_L)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBoxCa_L, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(lblCa_K)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBoxCa_K, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCheck6)))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        lblIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_K.png"))); // NOI18N

        lblAl_K.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblAl_K.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAl_K.setText("K");

        cmbBoxAl_K.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbBoxAl_K.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02" }));

        lblAl_L.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblAl_L.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAl_L.setText("L");

        cmbBoxAl_L.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbBoxAl_L.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08" }));

        lblAl_M.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblAl_M.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAl_M.setText("M");

        cmbBoxAl_M.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbBoxAl_M.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08" }));

        lblAl_N.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblAl_N.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAl_N.setText("N");

        cmbBoxAl_N.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbBoxAl_N.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02" }));

        btnCheck1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCheck1.setText("Check");
        btnCheck1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheck1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIcon1)
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbBoxAl_K, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAl_K, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbBoxAl_L, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAl_L, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbBoxAl_M, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAl_M, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbBoxAl_N, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAl_N, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnCheck1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIcon1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lblAl_N)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBoxAl_N, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lblAl_M)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBoxAl_M, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lblAl_L)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBoxAl_L, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lblAl_K)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBoxAl_K, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCheck1)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        lblIcon7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_P.png"))); // NOI18N

        lblCl_K.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCl_K.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCl_K.setText("K");

        cmbBoxCl_K.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbBoxCl_K.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02" }));

        lblCl_L.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCl_L.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCl_L.setText("L");

        cmbBoxCl_L.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbBoxCl_L.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08" }));

        lblCl_M.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCl_M.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCl_M.setText("M");

        cmbBoxCl_M.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbBoxCl_M.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08" }));

        lblCl_N.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCl_N.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCl_N.setText("N");

        cmbBoxCl_N.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbBoxCl_N.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02" }));

        btnCheck7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCheck7.setText("Check");
        btnCheck7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheck7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIcon7)
                .addGap(12, 12, 12)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbBoxCl_K, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCl_K, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbBoxCl_L, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCl_L, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbBoxCl_M, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCl_M, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbBoxCl_N, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCl_N, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnCheck7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIcon7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(lblCl_N)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBoxCl_N, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(lblCl_M)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBoxCl_M, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(lblCl_L)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBoxCl_L, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(lblCl_K)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBoxCl_K, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCheck7)))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        lblIcon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_Li.png"))); // NOI18N

        lblAr_K.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblAr_K.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAr_K.setText("K");

        cmbBoxAr_K.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbBoxAr_K.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02" }));

        lblAr_L.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblAr_L.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAr_L.setText("L");

        cmbBoxAr_L.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbBoxAr_L.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08" }));

        lblAr_M.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblAr_M.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAr_M.setText("M");

        cmbBoxAr_M.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbBoxAr_M.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08" }));

        lblAr_N.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblAr_N.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAr_N.setText("N");

        cmbBoxAr_N.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbBoxAr_N.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02" }));

        btnCheck2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCheck2.setText("Check");
        btnCheck2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheck2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIcon2)
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbBoxAr_K, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAr_K, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbBoxAr_L, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAr_L, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbBoxAr_M, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAr_M, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbBoxAr_N, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAr_N, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnCheck2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIcon2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(lblAr_N)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBoxAr_N, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(lblAr_M)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBoxAr_M, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(lblAr_L)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBoxAr_L, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(lblAr_K)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBoxAr_K, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCheck2)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        lblIcon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_Mg.png"))); // NOI18N

        lblB_K.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblB_K.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblB_K.setText("K");

        cmbBoxB_K.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbBoxB_K.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02" }));

        lblB_L.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblB_L.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblB_L.setText("L");

        cmbBoxB_L.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbBoxB_L.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08" }));

        lblB_M.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblB_M.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblB_M.setText("M");

        cmbBoxB_M.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbBoxB_M.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08" }));

        lblB_N.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblB_N.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblB_N.setText("N");

        cmbBoxB_N.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbBoxB_N.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02" }));

        btnCheck3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCheck3.setText("Check");
        btnCheck3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheck3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIcon3)
                .addGap(12, 12, 12)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbBoxB_K, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblB_K, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbBoxB_L, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblB_L, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbBoxB_M, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblB_M, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbBoxB_N, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblB_N, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnCheck3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIcon3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(lblB_N)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBoxB_N, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(lblB_M)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBoxB_M, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(lblB_L)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBoxB_L, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(lblB_K)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBoxB_K, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCheck3)))
                .addContainerGap())
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        lblIcon8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_S.png"))); // NOI18N

        lblF_K.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblF_K.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblF_K.setText("K");

        cmbBoxF_K.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbBoxF_K.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02" }));

        lblF_L.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblF_L.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblF_L.setText("L");

        cmbBoxF_L.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbBoxF_L.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08" }));

        lblF_M.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblF_M.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblF_M.setText("M");

        cmbBoxF_M.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbBoxF_M.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08" }));

        lblF_N.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblF_N.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblF_N.setText("N");

        cmbBoxF_N.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbBoxF_N.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02" }));

        btnCheck8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCheck8.setText("Check");
        btnCheck8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheck8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIcon8)
                .addGap(12, 12, 12)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbBoxF_K, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblF_K, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbBoxF_L, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblF_L, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbBoxF_M, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblF_M, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbBoxF_N, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblF_N, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnCheck8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIcon8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(lblF_N)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBoxF_N, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(lblF_M)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBoxF_M, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(lblF_L)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBoxF_L, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(lblF_K)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBoxF_K, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCheck8)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        lblIcon4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_N.png"))); // NOI18N

        lblBe_K.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblBe_K.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBe_K.setText("K");

        cmbBoxBe_K.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbBoxBe_K.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02" }));

        lblBe_L.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblBe_L.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBe_L.setText("L");

        cmbBoxBe_L.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbBoxBe_L.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08" }));

        lblBe_M.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblBe_M.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBe_M.setText("M");

        cmbBoxBe_M.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbBoxBe_M.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08" }));

        lblBe_N.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblBe_N.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBe_N.setText("N");

        cmbBoxBe_N.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbBoxBe_N.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02" }));

        btnCheck4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCheck4.setText("Check");
        btnCheck4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheck4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIcon4)
                .addGap(12, 12, 12)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbBoxBe_K, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBe_K, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbBoxBe_L, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBe_L, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbBoxBe_M, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBe_M, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbBoxBe_N, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBe_N, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnCheck4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIcon4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(lblBe_N)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBoxBe_N, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(lblBe_M)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBoxBe_M, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(lblBe_L)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBoxBe_L, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(lblBe_K)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBoxBe_K, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCheck4)))
                .addContainerGap())
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        lblIcon9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_Si.png"))); // NOI18N

        lblH_K.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblH_K.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblH_K.setText("K");

        cmbBoxH_K.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbBoxH_K.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02" }));

        lblH_L.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblH_L.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblH_L.setText("L");

        cmbBoxH_L.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbBoxH_L.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08" }));

        lblH_M.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblH_M.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblH_M.setText("M");

        cmbBoxH_M.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbBoxH_M.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08" }));

        lblH_N.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblH_N.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblH_N.setText("N");

        cmbBoxH_N.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbBoxH_N.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02" }));

        btnCheck9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCheck9.setText("Check");
        btnCheck9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheck9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIcon9)
                .addGap(12, 12, 12)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbBoxH_K, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblH_K, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbBoxH_L, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblH_L, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbBoxH_M, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblH_M, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbBoxH_N, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblH_N, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnCheck9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIcon9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(lblH_N)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBoxH_N, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(lblH_M)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBoxH_M, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(lblH_L)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBoxH_L, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(lblH_K)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBoxH_K, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCheck9)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        lblIcon10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_Ne.png"))); // NOI18N

        lblHe_K.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblHe_K.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHe_K.setText("K");

        cmbBoxHe_K.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbBoxHe_K.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02" }));

        lblHe_L.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblHe_L.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHe_L.setText("L");

        cmbBoxHe_L.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbBoxHe_L.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08" }));

        lblHe_M.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblHe_M.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHe_M.setText("M");

        cmbBoxHe_M.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbBoxHe_M.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08" }));

        lblHe_N.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblHe_N.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHe_N.setText("N");

        cmbBoxHe_N.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbBoxHe_N.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02" }));

        btnCheck10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCheck10.setText("Check");
        btnCheck10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheck10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIcon10)
                .addGap(12, 12, 12)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbBoxHe_K, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblHe_K, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbBoxHe_L, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblHe_L, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbBoxHe_M, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblHe_M, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbBoxHe_N, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblHe_N, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnCheck10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIcon10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(lblHe_N)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBoxHe_N, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(lblHe_M)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBoxHe_M, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(lblHe_L)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBoxHe_L, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(lblHe_K)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBoxHe_K, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCheck10)))
                .addContainerGap())
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        lblIcon5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_Na.png"))); // NOI18N

        lblC_K.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblC_K.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblC_K.setText("K");

        cmbBoxC_K.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbBoxC_K.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02" }));

        lblC_L.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblC_L.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblC_L.setText("L");

        cmbBoxC_L.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbBoxC_L.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08" }));

        lblC_M.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblC_M.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblC_M.setText("M");

        cmbBoxC_M.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbBoxC_M.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08" }));

        lblC_N.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblC_N.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblC_N.setText("N");

        cmbBoxC_N.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbBoxC_N.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02" }));

        btnCheck5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCheck5.setText("Check");
        btnCheck5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheck5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIcon5)
                .addGap(12, 12, 12)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbBoxC_K, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblC_K, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbBoxC_L, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblC_L, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbBoxC_M, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblC_M, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbBoxC_N, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblC_N, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnCheck5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIcon5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(lblC_N)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBoxC_N, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(lblC_M)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBoxC_M, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(lblC_L)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBoxC_L, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(lblC_K)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBoxC_K, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCheck5)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        resetGame();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnCheck6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheck6ActionPerformed
        // TODO add your handling code here:
        check();
        questionChange();
        btnCheck6.setEnabled(false);
        cmbBoxCa_K.setEnabled(false);
        cmbBoxCa_L.setEnabled(false);
        cmbBoxCa_M.setEnabled(false);
        cmbBoxCa_N.setEnabled(false);
    }//GEN-LAST:event_btnCheck6ActionPerformed

    private void btnCheck1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheck1ActionPerformed
        // TODO add your handling code here:
        check();
        questionChange();
        btnCheck1.setEnabled(false);
        cmbBoxAl_K.setEnabled(false);
        cmbBoxAl_L.setEnabled(false);
        cmbBoxAl_M.setEnabled(false);
        cmbBoxAl_N.setEnabled(false);
    }//GEN-LAST:event_btnCheck1ActionPerformed

    private void btnCheck7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheck7ActionPerformed
        // TODO add your handling code here:
        check();
        questionChange();
        btnCheck7.setEnabled(false);
        cmbBoxCl_K.setEnabled(false);
        cmbBoxCl_L.setEnabled(false);
        cmbBoxCl_M.setEnabled(false);
        cmbBoxCl_N.setEnabled(false);
    }//GEN-LAST:event_btnCheck7ActionPerformed

    private void btnCheck2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheck2ActionPerformed
        // TODO add your handling code here:
        check();
        questionChange();
        btnCheck2.setEnabled(false);
        cmbBoxAr_K.setEnabled(false);
        cmbBoxAr_L.setEnabled(false);
        cmbBoxAr_M.setEnabled(false);
        cmbBoxAr_N.setEnabled(false);
    }//GEN-LAST:event_btnCheck2ActionPerformed

    private void btnCheck3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheck3ActionPerformed
        // TODO add your handling code here:
        check();
        questionChange();
        btnCheck3.setEnabled(false);
        cmbBoxB_K.setEnabled(false);
        cmbBoxB_L.setEnabled(false);
        cmbBoxB_M.setEnabled(false);
        cmbBoxB_N.setEnabled(false);
    }//GEN-LAST:event_btnCheck3ActionPerformed

    private void btnCheck8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheck8ActionPerformed
        // TODO add your handling code here:
        check();
        questionChange();
        btnCheck8.setEnabled(false);
        cmbBoxF_K.setEnabled(false);
        cmbBoxF_L.setEnabled(false);
        cmbBoxF_M.setEnabled(false);
        cmbBoxF_N.setEnabled(false);
    }//GEN-LAST:event_btnCheck8ActionPerformed

    private void btnCheck4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheck4ActionPerformed
        // TODO add your handling code here:
        check();
        questionChange();
        btnCheck4.setEnabled(false);
        cmbBoxBe_K.setEnabled(false);
        cmbBoxBe_L.setEnabled(false);
        cmbBoxBe_M.setEnabled(false);
        cmbBoxBe_N.setEnabled(false);
    }//GEN-LAST:event_btnCheck4ActionPerformed

    private void btnCheck9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheck9ActionPerformed
        // TODO add your handling code here:
        check();
        questionChange();
        btnCheck9.setEnabled(false);
        cmbBoxH_K.setEnabled(false);
        cmbBoxH_L.setEnabled(false);
        cmbBoxH_M.setEnabled(false);
        cmbBoxH_N.setEnabled(false);
    }//GEN-LAST:event_btnCheck9ActionPerformed

    private void btnCheck10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheck10ActionPerformed
        // TODO add your handling code here:
        check();
        questionChange();
        btnCheck10.setEnabled(false);
        cmbBoxHe_K.setEnabled(false);
        cmbBoxHe_L.setEnabled(false);
        cmbBoxHe_M.setEnabled(false);
        cmbBoxHe_N.setEnabled(false);
    }//GEN-LAST:event_btnCheck10ActionPerformed

    private void btnCheck5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheck5ActionPerformed
        // TODO add your handling code here:
        check();
        questionChange();
        btnCheck5.setEnabled(false);
        cmbBoxC_K.setEnabled(false);
        cmbBoxC_L.setEnabled(false);
        cmbBoxC_M.setEnabled(false);
        cmbBoxC_N.setEnabled(false);
    }//GEN-LAST:event_btnCheck5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCheck1;
    private javax.swing.JButton btnCheck10;
    private javax.swing.JButton btnCheck2;
    private javax.swing.JButton btnCheck3;
    private javax.swing.JButton btnCheck4;
    private javax.swing.JButton btnCheck5;
    private javax.swing.JButton btnCheck6;
    private javax.swing.JButton btnCheck7;
    private javax.swing.JButton btnCheck8;
    private javax.swing.JButton btnCheck9;
    private javax.swing.JButton btnReset;
    private javax.swing.JComboBox<String> cmbBoxAl_K;
    private javax.swing.JComboBox<String> cmbBoxAl_L;
    private javax.swing.JComboBox<String> cmbBoxAl_M;
    private javax.swing.JComboBox<String> cmbBoxAl_N;
    private javax.swing.JComboBox<String> cmbBoxAr_K;
    private javax.swing.JComboBox<String> cmbBoxAr_L;
    private javax.swing.JComboBox<String> cmbBoxAr_M;
    private javax.swing.JComboBox<String> cmbBoxAr_N;
    private javax.swing.JComboBox<String> cmbBoxB_K;
    private javax.swing.JComboBox<String> cmbBoxB_L;
    private javax.swing.JComboBox<String> cmbBoxB_M;
    private javax.swing.JComboBox<String> cmbBoxB_N;
    private javax.swing.JComboBox<String> cmbBoxBe_K;
    private javax.swing.JComboBox<String> cmbBoxBe_L;
    private javax.swing.JComboBox<String> cmbBoxBe_M;
    private javax.swing.JComboBox<String> cmbBoxBe_N;
    private javax.swing.JComboBox<String> cmbBoxC_K;
    private javax.swing.JComboBox<String> cmbBoxC_L;
    private javax.swing.JComboBox<String> cmbBoxC_M;
    private javax.swing.JComboBox<String> cmbBoxC_N;
    private javax.swing.JComboBox<String> cmbBoxCa_K;
    private javax.swing.JComboBox<String> cmbBoxCa_L;
    private javax.swing.JComboBox<String> cmbBoxCa_M;
    private javax.swing.JComboBox<String> cmbBoxCa_N;
    private javax.swing.JComboBox<String> cmbBoxCl_K;
    private javax.swing.JComboBox<String> cmbBoxCl_L;
    private javax.swing.JComboBox<String> cmbBoxCl_M;
    private javax.swing.JComboBox<String> cmbBoxCl_N;
    private javax.swing.JComboBox<String> cmbBoxF_K;
    private javax.swing.JComboBox<String> cmbBoxF_L;
    private javax.swing.JComboBox<String> cmbBoxF_M;
    private javax.swing.JComboBox<String> cmbBoxF_N;
    private javax.swing.JComboBox<String> cmbBoxH_K;
    private javax.swing.JComboBox<String> cmbBoxH_L;
    private javax.swing.JComboBox<String> cmbBoxH_M;
    private javax.swing.JComboBox<String> cmbBoxH_N;
    private javax.swing.JComboBox<String> cmbBoxHe_K;
    private javax.swing.JComboBox<String> cmbBoxHe_L;
    private javax.swing.JComboBox<String> cmbBoxHe_M;
    private javax.swing.JComboBox<String> cmbBoxHe_N;
    private javax.swing.JLabel health1;
    private javax.swing.JLabel health2;
    private javax.swing.JLabel health3;
    private javax.swing.JLabel health4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lblAl_K;
    private javax.swing.JLabel lblAl_L;
    private javax.swing.JLabel lblAl_M;
    private javax.swing.JLabel lblAl_N;
    private javax.swing.JLabel lblAr_K;
    private javax.swing.JLabel lblAr_L;
    private javax.swing.JLabel lblAr_M;
    private javax.swing.JLabel lblAr_N;
    private javax.swing.JLabel lblB_K;
    private javax.swing.JLabel lblB_L;
    private javax.swing.JLabel lblB_M;
    private javax.swing.JLabel lblB_N;
    private javax.swing.JLabel lblBe_K;
    private javax.swing.JLabel lblBe_L;
    private javax.swing.JLabel lblBe_M;
    private javax.swing.JLabel lblBe_N;
    private javax.swing.JLabel lblC_K;
    private javax.swing.JLabel lblC_L;
    private javax.swing.JLabel lblC_M;
    private javax.swing.JLabel lblC_N;
    private javax.swing.JLabel lblCa_K;
    private javax.swing.JLabel lblCa_L;
    private javax.swing.JLabel lblCa_M;
    private javax.swing.JLabel lblCa_N;
    private javax.swing.JLabel lblCl_K;
    private javax.swing.JLabel lblCl_L;
    private javax.swing.JLabel lblCl_M;
    private javax.swing.JLabel lblCl_N;
    private javax.swing.JLabel lblComplete;
    private javax.swing.JLabel lblCorrectAnsAl_K;
    private javax.swing.JLabel lblCorrectAnsAl_L;
    private javax.swing.JLabel lblCorrectAnsAl_M;
    private javax.swing.JLabel lblCorrectAnsAl_N;
    private javax.swing.JLabel lblCorrectAnsAr_K;
    private javax.swing.JLabel lblCorrectAnsAr_L;
    private javax.swing.JLabel lblCorrectAnsAr_M;
    private javax.swing.JLabel lblCorrectAnsAr_N;
    private javax.swing.JLabel lblCorrectAnsB_K;
    private javax.swing.JLabel lblCorrectAnsB_L;
    private javax.swing.JLabel lblCorrectAnsB_M;
    private javax.swing.JLabel lblCorrectAnsB_N;
    private javax.swing.JLabel lblCorrectAnsBe_K;
    private javax.swing.JLabel lblCorrectAnsBe_L;
    private javax.swing.JLabel lblCorrectAnsBe_M;
    private javax.swing.JLabel lblCorrectAnsBe_N;
    private javax.swing.JLabel lblCorrectAnsC_K;
    private javax.swing.JLabel lblCorrectAnsC_L;
    private javax.swing.JLabel lblCorrectAnsC_M;
    private javax.swing.JLabel lblCorrectAnsC_N;
    private javax.swing.JLabel lblCorrectAnsCa_K;
    private javax.swing.JLabel lblCorrectAnsCa_L;
    private javax.swing.JLabel lblCorrectAnsCa_M;
    private javax.swing.JLabel lblCorrectAnsCa_N;
    private javax.swing.JLabel lblCorrectAnsCl_K;
    private javax.swing.JLabel lblCorrectAnsCl_L;
    private javax.swing.JLabel lblCorrectAnsCl_M;
    private javax.swing.JLabel lblCorrectAnsCl_N;
    private javax.swing.JLabel lblCorrectAnsF_K;
    private javax.swing.JLabel lblCorrectAnsF_L;
    private javax.swing.JLabel lblCorrectAnsF_M;
    private javax.swing.JLabel lblCorrectAnsF_N;
    private javax.swing.JLabel lblCorrectAnsH_K;
    private javax.swing.JLabel lblCorrectAnsH_L;
    private javax.swing.JLabel lblCorrectAnsH_M;
    private javax.swing.JLabel lblCorrectAnsH_N;
    private javax.swing.JLabel lblCorrectAnsHe_K;
    private javax.swing.JLabel lblCorrectAnsHe_L;
    private javax.swing.JLabel lblCorrectAnsHe_M;
    private javax.swing.JLabel lblCorrectAnsHe_N;
    private javax.swing.JLabel lblErrorMessage;
    private javax.swing.JLabel lblF_K;
    private javax.swing.JLabel lblF_L;
    private javax.swing.JLabel lblF_M;
    private javax.swing.JLabel lblF_N;
    private javax.swing.JLabel lblH_K;
    private javax.swing.JLabel lblH_L;
    private javax.swing.JLabel lblH_M;
    private javax.swing.JLabel lblH_N;
    private javax.swing.JLabel lblHe_K;
    private javax.swing.JLabel lblHe_L;
    private javax.swing.JLabel lblHe_M;
    private javax.swing.JLabel lblHe_N;
    private javax.swing.JLabel lblIcon1;
    private javax.swing.JLabel lblIcon10;
    private javax.swing.JLabel lblIcon2;
    private javax.swing.JLabel lblIcon3;
    private javax.swing.JLabel lblIcon4;
    private javax.swing.JLabel lblIcon5;
    private javax.swing.JLabel lblIcon6;
    private javax.swing.JLabel lblIcon7;
    private javax.swing.JLabel lblIcon8;
    private javax.swing.JLabel lblIcon9;
    private javax.swing.JLabel lblMarks;
    // End of variables declaration//GEN-END:variables
}
