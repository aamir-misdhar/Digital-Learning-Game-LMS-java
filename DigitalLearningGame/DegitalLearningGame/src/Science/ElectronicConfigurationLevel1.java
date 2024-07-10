/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Science;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.ForkJoinTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author mmaam
 */
public class ElectronicConfigurationLevel1 extends javax.swing.JInternalFrame {

    /**
     * Creates new form ElectronicConfigurationLevel1
     */
    String RegisterId;
    public ElectronicConfigurationLevel1() {
        initComponents();
        javax.swing.plaf.InternalFrameUI ifu = this.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) ifu).setNorthPane(null);
        elementBoxIconDisable();
        lblMessageBox.setVisible(false);
        btnPeriodicTable_NotSelectedIcon.setVisible(false);
    }
     public void Setdata(String ID) {
        RegisterId = ID;

    }

    public void sendDataToDatabase() {
        try {
            // create connection to database
            Connection con = Database.db.getConnection();
            // Create prepared statement with the sql query
            PreparedStatement st1 = con.prepareStatement("UPDATE `digital_learning_game`.`science` SET `electronicConfigurationLevel1_marks` = '" + marks + "', `electronicConfigurationLevel1_completed` = '" + complete + "' WHERE (`stdRegisterId` = " + RegisterId + ");");
            // execute query
            st1.executeUpdate();

            // show success message
            //JOptionPane.showMessageDialog(this, "Successfully Inserted...");
        } catch (SQLException ex) {
            Logger.getLogger(MapMarkingDigestiveSystem.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    // ========= Add icon For Button public Variabel Start ========= //
    JButton selectedPeriodicTableButton;
    JButton selectedElementBoxButton;
    ImageIcon icon;
    // ========= Add icon For Button public Variabel End ========= //   
    ImageIcon notSelectIcon = new ImageIcon(ElectronicConfigurationLevel1.class.getResource("/Images/PeriodicTableButtons_NotSelect.png"));
    String notSelectIconString = notSelectIcon.toString();
    //String notSelectIconString = btnPeriodicTable_NotSelectedIcon.getIcon().toString();

    // ==== other coutabale variable === //
    int wrongAnswer = 0;
    int health = 4;
    int marks = 0;
    int complete = 0;

    public void elementBoxIconDisable() {
        btnElementBox_Al.setEnabled(false);
        btnElementBox_Ar.setEnabled(false);
        btnElementBox_B.setEnabled(false);
        btnElementBox_Be.setEnabled(false);
        btnElementBox_C.setEnabled(false);
        btnElementBox_Ca.setEnabled(false);
        btnElementBox_Cl.setEnabled(false);
        btnElementBox_F.setEnabled(false);
        btnElementBox_H.setEnabled(false);
        btnElementBox_He.setEnabled(false);
        btnElementBox_K.setEnabled(false);
        btnElementBox_Li.setEnabled(false);
        btnElementBox_Mg.setEnabled(false);
        btnElementBox_N.setEnabled(false);
        btnElementBox_Na.setEnabled(false);
        btnElementBox_Ne.setEnabled(false);
        btnElementBox_O.setEnabled(false);
        btnElementBox_P.setEnabled(false);
        btnElementBox_S.setEnabled(false);
        btnElementBox_Si.setEnabled(false);
    }

    public void elementBoxIconEnable() {
        btnElementBox_Al.setEnabled(true);
        btnElementBox_Ar.setEnabled(true);
        btnElementBox_B.setEnabled(true);
        btnElementBox_Be.setEnabled(true);
        btnElementBox_C.setEnabled(true);
        btnElementBox_Ca.setEnabled(true);
        btnElementBox_Cl.setEnabled(true);
        btnElementBox_F.setEnabled(true);
        btnElementBox_H.setEnabled(true);
        btnElementBox_He.setEnabled(true);
        btnElementBox_K.setEnabled(true);
        btnElementBox_Li.setEnabled(true);
        btnElementBox_Mg.setEnabled(true);
        btnElementBox_N.setEnabled(true);
        btnElementBox_Na.setEnabled(true);
        btnElementBox_Ne.setEnabled(true);
        btnElementBox_O.setEnabled(true);
        btnElementBox_P.setEnabled(true);
        btnElementBox_S.setEnabled(true);
        btnElementBox_Si.setEnabled(true);
    }

    public void selectPeridicTabelButtonFunction() {
        peridicTabelButtonBorderDefault();
        elementBoxIconEnable();
        selectedPeriodicTableButton.setBorder(BorderFactory.createLineBorder(Color.black, 6));
        
    }

    public void selectElementBoxButtonFunction() {
        selectedPeriodicTableButton.setIcon(icon);
        selectedPeriodicTableButton.setBorder(BorderFactory.createEmptyBorder());
        selectedElementBoxButton.setVisible(false);
        elementBoxIconDisable();
        complete = complete + 5;
        lblCompletedDisplay.setText("Completed : "+complete+"%");
    }

    public void ButtonRebackFunction(String thisIcon) {
        complete = complete - 5;
        lblCompletedDisplay.setText("Completed : "+complete+"%");
        // ====== All button Icons From ElemetntBox ====== //
        String icon_H = btnElementBox_H.getIcon().toString();
        String icon_He = btnElementBox_He.getIcon().toString();
        String icon_Li = btnElementBox_Li.getIcon().toString();
        String icon_Be = btnElementBox_Be.getIcon().toString();
        String icon_B = btnElementBox_B.getIcon().toString();
        String icon_C = btnElementBox_C.getIcon().toString();
        String icon_N = btnElementBox_N.getIcon().toString();
        String icon_O = btnElementBox_O.getIcon().toString();
        String icon_F = btnElementBox_F.getIcon().toString();
        String icon_Ne = btnElementBox_Ne.getIcon().toString();
        String icon_Na = btnElementBox_Na.getIcon().toString();
        String icon_Mg = btnElementBox_Mg.getIcon().toString();
        String icon_Al = btnElementBox_Al.getIcon().toString();
        String icon_Si = btnElementBox_Si.getIcon().toString();
        String icon_P = btnElementBox_P.getIcon().toString();
        String icon_S = btnElementBox_S.getIcon().toString();
        String icon_Cl = btnElementBox_Cl.getIcon().toString();
        String icon_Ar = btnElementBox_Ar.getIcon().toString();
        String icon_K = btnElementBox_K.getIcon().toString();
        String icon_Ca = btnElementBox_Ca.getIcon().toString();

        if (thisIcon.equals(icon_H)) {
            btnElementBox_H.setVisible(true);
        } else if (thisIcon.equals(icon_He)) {
            btnElementBox_He.setVisible(true);
        } else if (thisIcon.equals(icon_Li)) {
            btnElementBox_Li.setVisible(true);
        } else if (thisIcon.equals(icon_Be)) {
            btnElementBox_Be.setVisible(true);
        } else if (thisIcon.equals(icon_B)) {
            btnElementBox_B.setVisible(true);
        } else if (thisIcon.equals(icon_C)) {
            btnElementBox_C.setVisible(true);
        } else if (thisIcon.equals(icon_N)) {
            btnElementBox_N.setVisible(true);
        } else if (thisIcon.equals(icon_O)) {
            btnElementBox_O.setVisible(true);
        } else if (thisIcon.equals(icon_F)) {
            btnElementBox_F.setVisible(true);
        } else if (thisIcon.equals(icon_Ne)) {
            btnElementBox_Ne.setVisible(true);
        } else if (thisIcon.equals(icon_Na)) {
            btnElementBox_Na.setVisible(true);
        } else if (thisIcon.equals(icon_Mg)) {
            btnElementBox_Mg.setVisible(true);
        } else if (thisIcon.equals(icon_Al)) {
            btnElementBox_Al.setVisible(true);
        } else if (thisIcon.equals(icon_Si)) {
            btnElementBox_Si.setVisible(true);
        } else if (thisIcon.equals(icon_P)) {
            btnElementBox_P.setVisible(true);
        } else if (thisIcon.equals(icon_S)) {
            btnElementBox_S.setVisible(true);
        } else if (thisIcon.equals(icon_Cl)) {
            btnElementBox_Cl.setVisible(true);
        } else if (thisIcon.equals(icon_Ar)) {
            btnElementBox_Ar.setVisible(true);
        } else if (thisIcon.equals(icon_K)) {
            btnElementBox_K.setVisible(true);
        } else if (thisIcon.equals(icon_Ca)) {
            btnElementBox_Ca.setVisible(true);
        }
    }

    public void peridicTabelButtonBorderDefault() {
        btnPeriodicTable_H.setBorder(BorderFactory.createEmptyBorder());
        btnPeriodicTable_He.setBorder(BorderFactory.createEmptyBorder());
        btnPeriodicTable_Li.setBorder(BorderFactory.createEmptyBorder());
        btnPeriodicTable_Be.setBorder(BorderFactory.createEmptyBorder());
        btnPeriodicTable_B.setBorder(BorderFactory.createEmptyBorder());
        btnPeriodicTable_C.setBorder(BorderFactory.createEmptyBorder());
        btnPeriodicTable_N.setBorder(BorderFactory.createEmptyBorder());
        btnPeriodicTable_O.setBorder(BorderFactory.createEmptyBorder());
        btnPeriodicTable_F.setBorder(BorderFactory.createEmptyBorder());
        btnPeriodicTable_Ne.setBorder(BorderFactory.createEmptyBorder());
        btnPeriodicTable_Na.setBorder(BorderFactory.createEmptyBorder());
        btnPeriodicTable_Mg.setBorder(BorderFactory.createEmptyBorder());
        btnPeriodicTable_Al.setBorder(BorderFactory.createEmptyBorder());
        btnPeriodicTable_Si.setBorder(BorderFactory.createEmptyBorder());
        btnPeriodicTable_P.setBorder(BorderFactory.createEmptyBorder());
        btnPeriodicTable_S.setBorder(BorderFactory.createEmptyBorder());
        btnPeriodicTable_Cl.setBorder(BorderFactory.createEmptyBorder());
        btnPeriodicTable_Ar.setBorder(BorderFactory.createEmptyBorder());
        btnPeriodicTable_K.setBorder(BorderFactory.createEmptyBorder());
        btnPeriodicTable_Ca.setBorder(BorderFactory.createEmptyBorder());

    }

    public void chack() {
        elementBoxIconDisable();
        marks = 0;
        //health = 4;
        wrongAnswer = 0;
        lblMessageBox.setVisible(true);
        String icon_H = btnElementBox_H.getIcon().toString();
        String icon_He = btnElementBox_He.getIcon().toString();
        String icon_Li = btnElementBox_Li.getIcon().toString();
        String icon_Be = btnElementBox_Be.getIcon().toString();
        String icon_B = btnElementBox_B.getIcon().toString();
        String icon_C = btnElementBox_C.getIcon().toString();
        String icon_N = btnElementBox_N.getIcon().toString();
        String icon_O = btnElementBox_O.getIcon().toString();
        String icon_F = btnElementBox_F.getIcon().toString();
        String icon_Ne = btnElementBox_Ne.getIcon().toString();
        String icon_Na = btnElementBox_Na.getIcon().toString();
        String icon_Mg = btnElementBox_Mg.getIcon().toString();
        String icon_Al = btnElementBox_Al.getIcon().toString();
        String icon_Si = btnElementBox_Si.getIcon().toString();
        String icon_P = btnElementBox_P.getIcon().toString();
        String icon_S = btnElementBox_S.getIcon().toString();
        String icon_Cl = btnElementBox_Cl.getIcon().toString();
        String icon_Ar = btnElementBox_Ar.getIcon().toString();
        String icon_K = btnElementBox_K.getIcon().toString();
        String icon_Ca = btnElementBox_Ca.getIcon().toString();

        String icon_H_Ans = btnPeriodicTable_H.getIcon().toString();
        String icon_He_Ans = btnPeriodicTable_He.getIcon().toString();
        String icon_Li_Ans = btnPeriodicTable_Li.getIcon().toString();
        String icon_Be_Ans = btnPeriodicTable_Be.getIcon().toString();
        String icon_B_Ans = btnPeriodicTable_B.getIcon().toString();
        String icon_C_Ans = btnPeriodicTable_C.getIcon().toString();
        String icon_N_Ans = btnPeriodicTable_N.getIcon().toString();
        String icon_O_Ans = btnPeriodicTable_O.getIcon().toString();
        String icon_F_Ans = btnPeriodicTable_F.getIcon().toString();
        String icon_Ne_Ans = btnPeriodicTable_Ne.getIcon().toString();
        String icon_Na_Ans = btnPeriodicTable_Na.getIcon().toString();
        String icon_Mg_Ans = btnPeriodicTable_Mg.getIcon().toString();
        String icon_Al_Ans = btnPeriodicTable_Al.getIcon().toString();
        String icon_Si_Ans = btnPeriodicTable_Si.getIcon().toString();
        String icon_P_Ans = btnPeriodicTable_P.getIcon().toString();
        String icon_S_Ans = btnPeriodicTable_S.getIcon().toString();
        String icon_Cl_Ans = btnPeriodicTable_Cl.getIcon().toString();
        String icon_Ar_Ans = btnPeriodicTable_Ar.getIcon().toString();
        String icon_K_Ans = btnPeriodicTable_K.getIcon().toString();
        String icon_Ca_Ans = btnPeriodicTable_Ca.getIcon().toString();

        // H
        if (icon_H_Ans.equals(icon_H)) {
            btnPeriodicTable_H.setBorder(BorderFactory.createLineBorder(Color.green, 6));
            marks = marks + 5;
        } else {
            btnPeriodicTable_H.setBorder(BorderFactory.createLineBorder(Color.red, 6));
            wrongAnswer++;
        }

        // He
        if (icon_He_Ans.equals(icon_He)) {
            btnPeriodicTable_He.setBorder(BorderFactory.createLineBorder(Color.green, 6));
            marks = marks + 5;
        } else {
            btnPeriodicTable_He.setBorder(BorderFactory.createLineBorder(Color.red, 6));
            wrongAnswer++;
        }

        // Li
        if (icon_Li_Ans.equals(icon_Li)) {
            btnPeriodicTable_Li.setBorder(BorderFactory.createLineBorder(Color.green, 6));
            marks = marks + 5;
        } else {
            btnPeriodicTable_Li.setBorder(BorderFactory.createLineBorder(Color.red, 6));
            wrongAnswer++;
        }

        // Be
        if (icon_Be_Ans.equals(icon_Be)) {
            btnPeriodicTable_Be.setBorder(BorderFactory.createLineBorder(Color.green, 6));
            marks = marks + 5;
        } else {
            btnPeriodicTable_Be.setBorder(BorderFactory.createLineBorder(Color.red, 6));
            wrongAnswer++;
        }

        // B
        if (icon_B_Ans.equals(icon_B)) {
            btnPeriodicTable_B.setBorder(BorderFactory.createLineBorder(Color.green, 6));
            marks = marks + 5;
        } else {
            btnPeriodicTable_B.setBorder(BorderFactory.createLineBorder(Color.red, 6));
            wrongAnswer++;
        }

        // C
        if (icon_C_Ans.equals(icon_C)) {
            btnPeriodicTable_C.setBorder(BorderFactory.createLineBorder(Color.green, 6));
            marks = marks + 5;
        } else {
            btnPeriodicTable_C.setBorder(BorderFactory.createLineBorder(Color.red, 6));
            wrongAnswer++;
        }

        // N
        if (icon_N_Ans.equals(icon_N)) {
            btnPeriodicTable_N.setBorder(BorderFactory.createLineBorder(Color.green, 6));
            marks = marks + 5;
        } else {
            btnPeriodicTable_N.setBorder(BorderFactory.createLineBorder(Color.red, 6));
            wrongAnswer++;
        }

        // O
        if (icon_O_Ans.equals(icon_O)) {
            btnPeriodicTable_O.setBorder(BorderFactory.createLineBorder(Color.green, 6));
            marks = marks + 5;
        } else {
            btnPeriodicTable_O.setBorder(BorderFactory.createLineBorder(Color.red, 6));
            wrongAnswer++;
        }

        // F
        if (icon_F_Ans.equals(icon_F)) {
            btnPeriodicTable_F.setBorder(BorderFactory.createLineBorder(Color.green, 6));
            marks = marks + 5;
        } else {
            btnPeriodicTable_F.setBorder(BorderFactory.createLineBorder(Color.red, 6));
            wrongAnswer++;
        }

        // Ne
        if (icon_Ne_Ans.equals(icon_Ne)) {
            btnPeriodicTable_Ne.setBorder(BorderFactory.createLineBorder(Color.green, 6));
            marks = marks + 5;
        } else {
            btnPeriodicTable_Ne.setBorder(BorderFactory.createLineBorder(Color.red, 6));
            wrongAnswer++;
        }

        // Na
        if (icon_Na_Ans.equals(icon_Na)) {
            btnPeriodicTable_Na.setBorder(BorderFactory.createLineBorder(Color.green, 6));
            marks = marks + 5;
        } else {
            btnPeriodicTable_Na.setBorder(BorderFactory.createLineBorder(Color.red, 6));
            wrongAnswer++;
        }

        // Mg
        if (icon_Mg_Ans.equals(icon_Mg)) {
            btnPeriodicTable_Mg.setBorder(BorderFactory.createLineBorder(Color.green, 6));
            marks = marks + 5;
        } else {
            btnPeriodicTable_Mg.setBorder(BorderFactory.createLineBorder(Color.red, 6));
            wrongAnswer++;
        }

        // Al
        if (icon_Al_Ans.equals(icon_Al)) {
            btnPeriodicTable_Al.setBorder(BorderFactory.createLineBorder(Color.green, 6));
            marks = marks + 5;
        } else {
            btnPeriodicTable_Al.setBorder(BorderFactory.createLineBorder(Color.red, 6));
            wrongAnswer++;
        }

        // Si
        if (icon_Si_Ans.equals(icon_Si)) {
            btnPeriodicTable_Si.setBorder(BorderFactory.createLineBorder(Color.green, 6));
            marks = marks + 5;
        } else {
            btnPeriodicTable_Si.setBorder(BorderFactory.createLineBorder(Color.red, 6));
            wrongAnswer++;
        }

        // P
        if (icon_P_Ans.equals(icon_P)) {
            btnPeriodicTable_P.setBorder(BorderFactory.createLineBorder(Color.green, 6));
            marks = marks + 5;
        } else {
            btnPeriodicTable_P.setBorder(BorderFactory.createLineBorder(Color.red, 6));
            wrongAnswer++;
        }

        // S
        if (icon_S_Ans.equals(icon_S)) {
            btnPeriodicTable_S.setBorder(BorderFactory.createLineBorder(Color.green, 6));
            marks = marks + 5;
        } else {
            btnPeriodicTable_S.setBorder(BorderFactory.createLineBorder(Color.red, 6));
            wrongAnswer++;
        }

        // Cl
        if (icon_Cl_Ans.equals(icon_Cl)) {
            btnPeriodicTable_Cl.setBorder(BorderFactory.createLineBorder(Color.green, 6));
            marks = marks + 5;
        } else {
            btnPeriodicTable_Cl.setBorder(BorderFactory.createLineBorder(Color.red, 6));
            wrongAnswer++;
        }

        // Ar
        if (icon_Ar_Ans.equals(icon_Ar)) {
            btnPeriodicTable_Ar.setBorder(BorderFactory.createLineBorder(Color.green, 6));
            marks = marks + 5;
        } else {
            btnPeriodicTable_Ar.setBorder(BorderFactory.createLineBorder(Color.red, 6));
            wrongAnswer++;
        }

        // K
        if (icon_K_Ans.equals(icon_K)) {
            btnPeriodicTable_K.setBorder(BorderFactory.createLineBorder(Color.green, 6));
            marks = marks + 5;
        } else {
            btnPeriodicTable_K.setBorder(BorderFactory.createLineBorder(Color.red, 6));
            wrongAnswer++;
        }

        // Ca
        if (icon_Ca_Ans.equals(icon_Ca)) {
            btnPeriodicTable_Ca.setBorder(BorderFactory.createLineBorder(Color.green, 6));
            marks = marks + 5;
        } else {
            btnPeriodicTable_Ca.setBorder(BorderFactory.createLineBorder(Color.red, 6));
            wrongAnswer++;
        }

        //===================== Marks and Health Seting to the interface ------------------//
        if (wrongAnswer != 0) {
            lblMessageBox.setText("Try Again, You have done " + wrongAnswer + " question Wrongly");
        }

        lblMarks.setText("" + marks);
        markChack();
        healthVisible();
        sendDataToDatabase();
        
    }

    public void markChack() {
        if (marks == 100) {
            lblMessageBox.setText("Conguragilation, You passed to next level");
        } else {
            health--;
        }
    }

    public void healthVisible() {
        if (health == 4) {
            health1.setVisible(true);
            health2.setVisible(true);
            health3.setVisible(true);
            health4.setVisible(true);

        } else if (health == 3) {
            health1.setVisible(true);
            health2.setVisible(true);
            health3.setVisible(true);
            health4.setVisible(false);

        } else if (health == 2) {
            health1.setVisible(true);
            health2.setVisible(true);
            health3.setVisible(false);
            health4.setVisible(false);

        } else if (health == 1) {
            health1.setVisible(true);
            health2.setVisible(false);
            health3.setVisible(false);
            health4.setVisible(false);

        } else if (health == 0) {
            health1.setVisible(false);
            health2.setVisible(false);
            health3.setVisible(false);
            health4.setVisible(false);

        } else {
            health1.setVisible(false);
            health2.setVisible(false);
            health3.setVisible(false);
            health4.setVisible(false);

        }
    }

    public void resetGame() {
        elementBoxIconDisable(); 
        peridicTabelButtonBorderDefault();
        lblMessageBox.setVisible(false);
        lblCompletedDisplay.setText("Completed : 0%");
        
        wrongAnswer = 0;
        health = 4;
        marks = 0;
        complete = 0;
        
        health1.setVisible(true);
        health2.setVisible(true);
        health3.setVisible(true);
        health4.setVisible(true);
        lblMarks.setText("00");
          
        btnElementBox_Al.setVisible(true);
        btnElementBox_Ar.setVisible(true);
        btnElementBox_B.setVisible(true);
        btnElementBox_Be.setVisible(true);
        btnElementBox_C.setVisible(true);
        btnElementBox_Ca.setVisible(true);
        btnElementBox_Cl.setVisible(true);
        btnElementBox_F.setVisible(true);
        btnElementBox_H.setVisible(true);
        btnElementBox_He.setVisible(true);
        btnElementBox_K.setVisible(true);
        btnElementBox_Li.setVisible(true);
        btnElementBox_Mg.setVisible(true);
        btnElementBox_N.setVisible(true);
        btnElementBox_Na.setVisible(true);
        btnElementBox_Ne.setVisible(true);
        btnElementBox_O.setVisible(true);
        btnElementBox_P.setVisible(true);
        btnElementBox_S.setVisible(true);
        btnElementBox_Si.setVisible(true);
        
        
         btnPeriodicTable_H.setIcon(notSelectIcon);
        btnPeriodicTable_He.setIcon(notSelectIcon);
        btnPeriodicTable_Li.setIcon(notSelectIcon);
        btnPeriodicTable_Be.setIcon(notSelectIcon);
        btnPeriodicTable_B.setIcon(notSelectIcon);
        btnPeriodicTable_C.setIcon(notSelectIcon);
        btnPeriodicTable_N.setIcon(notSelectIcon);
        btnPeriodicTable_O.setIcon(notSelectIcon);
        btnPeriodicTable_F.setIcon(notSelectIcon);
        btnPeriodicTable_Ne.setIcon(notSelectIcon);
        btnPeriodicTable_Na.setIcon(notSelectIcon);
        btnPeriodicTable_Mg.setIcon(notSelectIcon);
        btnPeriodicTable_Al.setIcon(notSelectIcon);
        btnPeriodicTable_Si.setIcon(notSelectIcon);
        btnPeriodicTable_P.setIcon(notSelectIcon);
        btnPeriodicTable_S.setIcon(notSelectIcon);
        btnPeriodicTable_Cl.setIcon(notSelectIcon);
        btnPeriodicTable_Ar.setIcon(notSelectIcon);
        btnPeriodicTable_K.setIcon(notSelectIcon);
        btnPeriodicTable_Ca.setIcon(notSelectIcon);
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
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnPeriodicTable_Li = new javax.swing.JButton();
        btnPeriodicTable_N = new javax.swing.JButton();
        btnPeriodicTable_He = new javax.swing.JButton();
        btnPeriodicTable_H = new javax.swing.JButton();
        btnPeriodicTable_Be = new javax.swing.JButton();
        btnPeriodicTable_B = new javax.swing.JButton();
        btnPeriodicTable_Ne = new javax.swing.JButton();
        btnPeriodicTable_C = new javax.swing.JButton();
        btnPeriodicTable_O = new javax.swing.JButton();
        btnPeriodicTable_F = new javax.swing.JButton();
        btnPeriodicTable_Na = new javax.swing.JButton();
        btnPeriodicTable_Mg = new javax.swing.JButton();
        btnPeriodicTable_Al = new javax.swing.JButton();
        btnPeriodicTable_Si = new javax.swing.JButton();
        btnPeriodicTable_P = new javax.swing.JButton();
        btnPeriodicTable_S = new javax.swing.JButton();
        btnPeriodicTable_Cl = new javax.swing.JButton();
        btnPeriodicTable_Ar = new javax.swing.JButton();
        btnPeriodicTable_K = new javax.swing.JButton();
        btnPeriodicTable_Ca = new javax.swing.JButton();
        btnPeriodicTable_NotSelectedIcon = new javax.swing.JButton();
        lblCompletedDisplay = new javax.swing.JLabel();
        lblPeriodicTable = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblMessageBox = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnElementBox_B = new javax.swing.JButton();
        btnElementBox_Be = new javax.swing.JButton();
        btnElementBox_C = new javax.swing.JButton();
        btnElementBox_Ca = new javax.swing.JButton();
        btnElementBox_Cl = new javax.swing.JButton();
        btnElementBox_F = new javax.swing.JButton();
        btnElementBox_H = new javax.swing.JButton();
        btnElementBox_He = new javax.swing.JButton();
        btnElementBox_Li = new javax.swing.JButton();
        btnElementBox_N = new javax.swing.JButton();
        btnElementBox_Na = new javax.swing.JButton();
        btnElementBox_Ne = new javax.swing.JButton();
        btnElementBox_O = new javax.swing.JButton();
        btnElementBox_S = new javax.swing.JButton();
        btnElementBox_Si = new javax.swing.JButton();
        btnElementBox_P = new javax.swing.JButton();
        btnElementBox_Al = new javax.swing.JButton();
        btnElementBox_Mg = new javax.swing.JButton();
        btnElementBox_K = new javax.swing.JButton();
        btnElementBox_Ar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btnReset = new javax.swing.JButton();
        btnChack = new javax.swing.JButton();

        setBorder(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Level 1");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Periodic Table");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(lblMarks)
                    .addComponent(health1)
                    .addComponent(health2)
                    .addComponent(health3)
                    .addComponent(health4))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Fill the Periodic Table Using the Element in the Element Box");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPeriodicTable_Li.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_NotSelect.png"))); // NOI18N
        btnPeriodicTable_Li.setBorder(null);
        btnPeriodicTable_Li.setContentAreaFilled(false);
        btnPeriodicTable_Li.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeriodicTable_LiActionPerformed(evt);
            }
        });
        jPanel5.add(btnPeriodicTable_Li, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 64, 64));

        btnPeriodicTable_N.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_NotSelect.png"))); // NOI18N
        btnPeriodicTable_N.setBorder(null);
        btnPeriodicTable_N.setContentAreaFilled(false);
        btnPeriodicTable_N.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeriodicTable_NActionPerformed(evt);
            }
        });
        jPanel5.add(btnPeriodicTable_N, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 64, 64));

        btnPeriodicTable_He.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_NotSelect.png"))); // NOI18N
        btnPeriodicTable_He.setBorder(null);
        btnPeriodicTable_He.setContentAreaFilled(false);
        btnPeriodicTable_He.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeriodicTable_HeActionPerformed(evt);
            }
        });
        jPanel5.add(btnPeriodicTable_He, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 64, 64));

        btnPeriodicTable_H.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_NotSelect.png"))); // NOI18N
        btnPeriodicTable_H.setToolTipText("");
        btnPeriodicTable_H.setBorder(null);
        btnPeriodicTable_H.setContentAreaFilled(false);
        btnPeriodicTable_H.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeriodicTable_HActionPerformed(evt);
            }
        });
        jPanel5.add(btnPeriodicTable_H, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 64, 64));

        btnPeriodicTable_Be.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_NotSelect.png"))); // NOI18N
        btnPeriodicTable_Be.setBorder(null);
        btnPeriodicTable_Be.setContentAreaFilled(false);
        btnPeriodicTable_Be.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeriodicTable_BeActionPerformed(evt);
            }
        });
        jPanel5.add(btnPeriodicTable_Be, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 64, 64));

        btnPeriodicTable_B.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_NotSelect.png"))); // NOI18N
        btnPeriodicTable_B.setBorder(null);
        btnPeriodicTable_B.setContentAreaFilled(false);
        btnPeriodicTable_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeriodicTable_BActionPerformed(evt);
            }
        });
        jPanel5.add(btnPeriodicTable_B, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 64, 64));

        btnPeriodicTable_Ne.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_NotSelect.png"))); // NOI18N
        btnPeriodicTable_Ne.setBorder(null);
        btnPeriodicTable_Ne.setContentAreaFilled(false);
        btnPeriodicTable_Ne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeriodicTable_NeActionPerformed(evt);
            }
        });
        jPanel5.add(btnPeriodicTable_Ne, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 120, 64, 64));

        btnPeriodicTable_C.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_NotSelect.png"))); // NOI18N
        btnPeriodicTable_C.setBorder(null);
        btnPeriodicTable_C.setContentAreaFilled(false);
        btnPeriodicTable_C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeriodicTable_CActionPerformed(evt);
            }
        });
        jPanel5.add(btnPeriodicTable_C, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 64, 64));

        btnPeriodicTable_O.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_NotSelect.png"))); // NOI18N
        btnPeriodicTable_O.setBorder(null);
        btnPeriodicTable_O.setContentAreaFilled(false);
        btnPeriodicTable_O.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeriodicTable_OActionPerformed(evt);
            }
        });
        jPanel5.add(btnPeriodicTable_O, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, 64, 64));

        btnPeriodicTable_F.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_NotSelect.png"))); // NOI18N
        btnPeriodicTable_F.setBorder(null);
        btnPeriodicTable_F.setContentAreaFilled(false);
        btnPeriodicTable_F.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeriodicTable_FActionPerformed(evt);
            }
        });
        jPanel5.add(btnPeriodicTable_F, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 64, 64));

        btnPeriodicTable_Na.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_NotSelect.png"))); // NOI18N
        btnPeriodicTable_Na.setBorder(null);
        btnPeriodicTable_Na.setContentAreaFilled(false);
        btnPeriodicTable_Na.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeriodicTable_NaActionPerformed(evt);
            }
        });
        jPanel5.add(btnPeriodicTable_Na, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 64, 64));

        btnPeriodicTable_Mg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_NotSelect.png"))); // NOI18N
        btnPeriodicTable_Mg.setBorder(null);
        btnPeriodicTable_Mg.setContentAreaFilled(false);
        btnPeriodicTable_Mg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeriodicTable_MgActionPerformed(evt);
            }
        });
        jPanel5.add(btnPeriodicTable_Mg, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 64, 64));

        btnPeriodicTable_Al.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_NotSelect.png"))); // NOI18N
        btnPeriodicTable_Al.setBorder(null);
        btnPeriodicTable_Al.setContentAreaFilled(false);
        btnPeriodicTable_Al.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeriodicTable_AlActionPerformed(evt);
            }
        });
        jPanel5.add(btnPeriodicTable_Al, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 64, 64));

        btnPeriodicTable_Si.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_NotSelect.png"))); // NOI18N
        btnPeriodicTable_Si.setBorder(null);
        btnPeriodicTable_Si.setContentAreaFilled(false);
        btnPeriodicTable_Si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeriodicTable_SiActionPerformed(evt);
            }
        });
        jPanel5.add(btnPeriodicTable_Si, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 64, 64));

        btnPeriodicTable_P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_NotSelect.png"))); // NOI18N
        btnPeriodicTable_P.setBorder(null);
        btnPeriodicTable_P.setContentAreaFilled(false);
        btnPeriodicTable_P.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeriodicTable_PActionPerformed(evt);
            }
        });
        jPanel5.add(btnPeriodicTable_P, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 64, 64));

        btnPeriodicTable_S.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_NotSelect.png"))); // NOI18N
        btnPeriodicTable_S.setBorder(null);
        btnPeriodicTable_S.setContentAreaFilled(false);
        btnPeriodicTable_S.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeriodicTable_SActionPerformed(evt);
            }
        });
        jPanel5.add(btnPeriodicTable_S, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, 64, 64));

        btnPeriodicTable_Cl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_NotSelect.png"))); // NOI18N
        btnPeriodicTable_Cl.setBorder(null);
        btnPeriodicTable_Cl.setContentAreaFilled(false);
        btnPeriodicTable_Cl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeriodicTable_ClActionPerformed(evt);
            }
        });
        jPanel5.add(btnPeriodicTable_Cl, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 190, 64, 64));

        btnPeriodicTable_Ar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_NotSelect.png"))); // NOI18N
        btnPeriodicTable_Ar.setBorder(null);
        btnPeriodicTable_Ar.setContentAreaFilled(false);
        btnPeriodicTable_Ar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeriodicTable_ArActionPerformed(evt);
            }
        });
        jPanel5.add(btnPeriodicTable_Ar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 190, 64, 64));

        btnPeriodicTable_K.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_NotSelect.png"))); // NOI18N
        btnPeriodicTable_K.setBorder(null);
        btnPeriodicTable_K.setContentAreaFilled(false);
        btnPeriodicTable_K.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeriodicTable_KActionPerformed(evt);
            }
        });
        jPanel5.add(btnPeriodicTable_K, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 64, 64));

        btnPeriodicTable_Ca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_NotSelect.png"))); // NOI18N
        btnPeriodicTable_Ca.setBorder(null);
        btnPeriodicTable_Ca.setContentAreaFilled(false);
        btnPeriodicTable_Ca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeriodicTable_CaActionPerformed(evt);
            }
        });
        jPanel5.add(btnPeriodicTable_Ca, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 64, 64));

        btnPeriodicTable_NotSelectedIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_NotSelect.png"))); // NOI18N
        btnPeriodicTable_NotSelectedIcon.setBorder(null);
        btnPeriodicTable_NotSelectedIcon.setContentAreaFilled(false);
        btnPeriodicTable_NotSelectedIcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeriodicTable_NotSelectedIconActionPerformed(evt);
            }
        });
        jPanel5.add(btnPeriodicTable_NotSelectedIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, 64, 64));

        lblCompletedDisplay.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblCompletedDisplay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCompletedDisplay.setText("Completed : 0%");
        jPanel5.add(lblCompletedDisplay, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 570, -1));

        lblPeriodicTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTable.png"))); // NOI18N
        jPanel5.add(lblPeriodicTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, 0, 610, 350));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Periodic Table");

        lblMessageBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMessageBox.setForeground(new java.awt.Color(153, 0, 51));
        lblMessageBox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMessageBox.setText("MessageBox");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addComponent(lblMessageBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(15, 15, 15)
                .addComponent(lblMessageBox)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Elements Box");

        btnElementBox_B.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_B.png"))); // NOI18N
        btnElementBox_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElementBox_BActionPerformed(evt);
            }
        });

        btnElementBox_Be.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_Be.png"))); // NOI18N
        btnElementBox_Be.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElementBox_BeActionPerformed(evt);
            }
        });

        btnElementBox_C.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_C.png"))); // NOI18N
        btnElementBox_C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElementBox_CActionPerformed(evt);
            }
        });

        btnElementBox_Ca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_Ca.png"))); // NOI18N
        btnElementBox_Ca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElementBox_CaActionPerformed(evt);
            }
        });

        btnElementBox_Cl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_Cl.png"))); // NOI18N
        btnElementBox_Cl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElementBox_ClActionPerformed(evt);
            }
        });

        btnElementBox_F.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_F.png"))); // NOI18N
        btnElementBox_F.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElementBox_FActionPerformed(evt);
            }
        });

        btnElementBox_H.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_H.png"))); // NOI18N
        btnElementBox_H.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElementBox_HActionPerformed(evt);
            }
        });

        btnElementBox_He.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_He.png"))); // NOI18N
        btnElementBox_He.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElementBox_HeActionPerformed(evt);
            }
        });

        btnElementBox_Li.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_Li.png"))); // NOI18N
        btnElementBox_Li.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElementBox_LiActionPerformed(evt);
            }
        });

        btnElementBox_N.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_N.png"))); // NOI18N
        btnElementBox_N.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElementBox_NActionPerformed(evt);
            }
        });

        btnElementBox_Na.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_Na.png"))); // NOI18N
        btnElementBox_Na.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElementBox_NaActionPerformed(evt);
            }
        });

        btnElementBox_Ne.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_Ne.png"))); // NOI18N
        btnElementBox_Ne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElementBox_NeActionPerformed(evt);
            }
        });

        btnElementBox_O.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_O.png"))); // NOI18N
        btnElementBox_O.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElementBox_OActionPerformed(evt);
            }
        });

        btnElementBox_S.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_S.png"))); // NOI18N
        btnElementBox_S.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElementBox_SActionPerformed(evt);
            }
        });

        btnElementBox_Si.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_Si.png"))); // NOI18N
        btnElementBox_Si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElementBox_SiActionPerformed(evt);
            }
        });

        btnElementBox_P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_P.png"))); // NOI18N
        btnElementBox_P.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElementBox_PActionPerformed(evt);
            }
        });

        btnElementBox_Al.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_Al.png"))); // NOI18N
        btnElementBox_Al.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElementBox_AlActionPerformed(evt);
            }
        });

        btnElementBox_Mg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_Mg.png"))); // NOI18N
        btnElementBox_Mg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElementBox_MgActionPerformed(evt);
            }
        });

        btnElementBox_K.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_K.png"))); // NOI18N
        btnElementBox_K.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElementBox_KActionPerformed(evt);
            }
        });

        btnElementBox_Ar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PeriodicTableButtons_Ar.png"))); // NOI18N
        btnElementBox_Ar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElementBox_ArActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        btnReset.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReset.setForeground(new java.awt.Color(102, 102, 102));
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnChack.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnChack.setText("Chack");
        btnChack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnChack, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnChack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnElementBox_B, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnElementBox_Be, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnElementBox_C, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnElementBox_Ca, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnElementBox_Cl, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnElementBox_F, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnElementBox_H, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnElementBox_He, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnElementBox_Li, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnElementBox_N, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnElementBox_Na, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnElementBox_Ne, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnElementBox_O, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnElementBox_S, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnElementBox_Si, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnElementBox_P, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnElementBox_Al, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnElementBox_Mg, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnElementBox_K, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnElementBox_Ar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnElementBox_B, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnElementBox_Be, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnElementBox_C, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnElementBox_Ca, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnElementBox_Cl, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnElementBox_F, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnElementBox_H, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnElementBox_He, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnElementBox_Li, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnElementBox_N, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnElementBox_Na, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnElementBox_Ne, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnElementBox_O, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnElementBox_S, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnElementBox_Si, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnElementBox_P, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnElementBox_Al, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnElementBox_Mg, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnElementBox_K, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnElementBox_Ar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Btn Periodic Table coding
    private void btnPeriodicTable_HActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeriodicTable_HActionPerformed
        // TODO add your handling code here:         
        String thisIcon = btnPeriodicTable_H.getIcon().toString();
        if (thisIcon.equals(notSelectIconString)) {
            selectedPeriodicTableButton = btnPeriodicTable_H;
            selectPeridicTabelButtonFunction();
        } else {
            ButtonRebackFunction(thisIcon);
            btnPeriodicTable_H.setIcon(notSelectIcon);
        }
    }//GEN-LAST:event_btnPeriodicTable_HActionPerformed

    private void btnPeriodicTable_HeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeriodicTable_HeActionPerformed
        // TODO add your handling code here:
        String thisIcon = btnPeriodicTable_He.getIcon().toString();
        if (thisIcon.equals(notSelectIconString)) {
            selectedPeriodicTableButton = btnPeriodicTable_He;
            selectPeridicTabelButtonFunction();
        } else {
            ButtonRebackFunction(thisIcon);
            btnPeriodicTable_He.setIcon(notSelectIcon);
        }
    }//GEN-LAST:event_btnPeriodicTable_HeActionPerformed

    private void btnPeriodicTable_LiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeriodicTable_LiActionPerformed
        // TODO add your handling code here:      
        String thisIcon = btnPeriodicTable_Li.getIcon().toString();
        if (thisIcon.equals(notSelectIconString)) {
            selectedPeriodicTableButton = btnPeriodicTable_Li;
            selectPeridicTabelButtonFunction();
        } else {
            ButtonRebackFunction(thisIcon);
            btnPeriodicTable_Li.setIcon(notSelectIcon);
        }
    }//GEN-LAST:event_btnPeriodicTable_LiActionPerformed

    private void btnPeriodicTable_BeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeriodicTable_BeActionPerformed
        // TODO add your handling code here:   
        String thisIcon = btnPeriodicTable_Be.getIcon().toString();
        if (thisIcon.equals(notSelectIconString)) {
            selectedPeriodicTableButton = btnPeriodicTable_Be;
            selectPeridicTabelButtonFunction();
        } else {
            ButtonRebackFunction(thisIcon);
            btnPeriodicTable_Be.setIcon(notSelectIcon);
        }
    }//GEN-LAST:event_btnPeriodicTable_BeActionPerformed

    private void btnPeriodicTable_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeriodicTable_BActionPerformed
        // TODO add your handling code here:     
        String thisIcon = btnPeriodicTable_B.getIcon().toString();
        if (thisIcon.equals(notSelectIconString)) {
            selectedPeriodicTableButton = btnPeriodicTable_B;
            selectPeridicTabelButtonFunction();
        } else {
            ButtonRebackFunction(thisIcon);
            btnPeriodicTable_B.setIcon(notSelectIcon);
        }
    }//GEN-LAST:event_btnPeriodicTable_BActionPerformed

    private void btnPeriodicTable_CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeriodicTable_CActionPerformed
        // TODO add your handling code here:       
        String thisIcon = btnPeriodicTable_C.getIcon().toString();
        if (thisIcon.equals(notSelectIconString)) {
            selectedPeriodicTableButton = btnPeriodicTable_C;
            selectPeridicTabelButtonFunction();
        } else {
            ButtonRebackFunction(thisIcon);
            btnPeriodicTable_C.setIcon(notSelectIcon);
        }
    }//GEN-LAST:event_btnPeriodicTable_CActionPerformed

    private void btnPeriodicTable_NActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeriodicTable_NActionPerformed
        // TODO add your handling code here:      
        String thisIcon = btnPeriodicTable_N.getIcon().toString();
        if (thisIcon.equals(notSelectIconString)) {
            selectedPeriodicTableButton = btnPeriodicTable_N;
            selectPeridicTabelButtonFunction();
        } else {
            ButtonRebackFunction(thisIcon);
            btnPeriodicTable_N.setIcon(notSelectIcon);
        }
    }//GEN-LAST:event_btnPeriodicTable_NActionPerformed

    private void btnPeriodicTable_OActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeriodicTable_OActionPerformed
        // TODO add your handling code here:
        String thisIcon = btnPeriodicTable_O.getIcon().toString();
        if (thisIcon.equals(notSelectIconString)) {
            selectedPeriodicTableButton = btnPeriodicTable_O;
            selectPeridicTabelButtonFunction();
        } else {
            ButtonRebackFunction(thisIcon);
            btnPeriodicTable_O.setIcon(notSelectIcon);
        }
    }//GEN-LAST:event_btnPeriodicTable_OActionPerformed

    private void btnPeriodicTable_FActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeriodicTable_FActionPerformed
        // TODO add your handling code here:
        String thisIcon = btnPeriodicTable_F.getIcon().toString();
        if (thisIcon.equals(notSelectIconString)) {
            selectedPeriodicTableButton = btnPeriodicTable_F;
            selectPeridicTabelButtonFunction();
        } else {
            ButtonRebackFunction(thisIcon);
            btnPeriodicTable_F.setIcon(notSelectIcon);
        }
    }//GEN-LAST:event_btnPeriodicTable_FActionPerformed

    private void btnPeriodicTable_NeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeriodicTable_NeActionPerformed
        // TODO add your handling code here:    
        String thisIcon = btnPeriodicTable_Ne.getIcon().toString();
        if (thisIcon.equals(notSelectIconString)) {
            selectedPeriodicTableButton = btnPeriodicTable_Ne;
            selectPeridicTabelButtonFunction();
        } else {
            ButtonRebackFunction(thisIcon);
            btnPeriodicTable_Ne.setIcon(notSelectIcon);
        }
    }//GEN-LAST:event_btnPeriodicTable_NeActionPerformed

    private void btnPeriodicTable_NaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeriodicTable_NaActionPerformed
        // TODO add your handling code here:        
        String thisIcon = btnPeriodicTable_Na.getIcon().toString();
        if (thisIcon.equals(notSelectIconString)) {
            selectedPeriodicTableButton = btnPeriodicTable_Na;
            selectPeridicTabelButtonFunction();
        } else {
            ButtonRebackFunction(thisIcon);
            btnPeriodicTable_Na.setIcon(notSelectIcon);
        }
    }//GEN-LAST:event_btnPeriodicTable_NaActionPerformed

    private void btnPeriodicTable_MgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeriodicTable_MgActionPerformed
        // TODO add your handling code here:
        String thisIcon = btnPeriodicTable_Mg.getIcon().toString();
        if (thisIcon.equals(notSelectIconString)) {
            selectedPeriodicTableButton = btnPeriodicTable_Mg;
            selectPeridicTabelButtonFunction();
        } else {
            ButtonRebackFunction(thisIcon);
            btnPeriodicTable_Mg.setIcon(notSelectIcon);
        }
    }//GEN-LAST:event_btnPeriodicTable_MgActionPerformed

    private void btnPeriodicTable_AlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeriodicTable_AlActionPerformed
        // TODO add your handling code here:       
        String thisIcon = btnPeriodicTable_Al.getIcon().toString();
        if (thisIcon.equals(notSelectIconString)) {
            selectedPeriodicTableButton = btnPeriodicTable_Al;
            selectPeridicTabelButtonFunction();
        } else {
            ButtonRebackFunction(thisIcon);
            btnPeriodicTable_Al.setIcon(notSelectIcon);
        }
    }//GEN-LAST:event_btnPeriodicTable_AlActionPerformed

    private void btnPeriodicTable_SiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeriodicTable_SiActionPerformed
        // TODO add your handling code here:     
        String thisIcon = btnPeriodicTable_Si.getIcon().toString();
        if (thisIcon.equals(notSelectIconString)) {
            selectedPeriodicTableButton = btnPeriodicTable_Si;
            selectPeridicTabelButtonFunction();
        } else {
            ButtonRebackFunction(thisIcon);
            btnPeriodicTable_Si.setIcon(notSelectIcon);
        }
    }//GEN-LAST:event_btnPeriodicTable_SiActionPerformed

    private void btnPeriodicTable_PActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeriodicTable_PActionPerformed
        // TODO add your handling code here:
        String thisIcon = btnPeriodicTable_P.getIcon().toString();
        if (thisIcon.equals(notSelectIconString)) {
            selectedPeriodicTableButton = btnPeriodicTable_P;
            selectPeridicTabelButtonFunction();
        } else {
            ButtonRebackFunction(thisIcon);
            btnPeriodicTable_P.setIcon(notSelectIcon);
        }
    }//GEN-LAST:event_btnPeriodicTable_PActionPerformed

    private void btnPeriodicTable_SActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeriodicTable_SActionPerformed
        // TODO add your handling code here: 
        String thisIcon = btnPeriodicTable_S.getIcon().toString();
        if (thisIcon.equals(notSelectIconString)) {
            selectedPeriodicTableButton = btnPeriodicTable_S;
            selectPeridicTabelButtonFunction();
        } else {
            ButtonRebackFunction(thisIcon);
            btnPeriodicTable_S.setIcon(notSelectIcon);
        }
    }//GEN-LAST:event_btnPeriodicTable_SActionPerformed

    private void btnPeriodicTable_ClActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeriodicTable_ClActionPerformed
        // TODO add your handling code here:
        String thisIcon = btnPeriodicTable_Cl.getIcon().toString();
        if (thisIcon.equals(notSelectIconString)) {
            selectedPeriodicTableButton = btnPeriodicTable_Cl;
            selectPeridicTabelButtonFunction();
        } else {
            ButtonRebackFunction(thisIcon);
            btnPeriodicTable_Cl.setIcon(notSelectIcon);
        }
    }//GEN-LAST:event_btnPeriodicTable_ClActionPerformed

    private void btnPeriodicTable_ArActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeriodicTable_ArActionPerformed
        // TODO add your handling code here:
        String thisIcon = btnPeriodicTable_Ar.getIcon().toString();
        if (thisIcon.equals(notSelectIconString)) {
            selectedPeriodicTableButton = btnPeriodicTable_Ar;
            selectPeridicTabelButtonFunction();
        } else {
            ButtonRebackFunction(thisIcon);
            btnPeriodicTable_Ar.setIcon(notSelectIcon);
        }
    }//GEN-LAST:event_btnPeriodicTable_ArActionPerformed

    private void btnPeriodicTable_KActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeriodicTable_KActionPerformed
        // TODO add your handling code here:
        String thisIcon = btnPeriodicTable_K.getIcon().toString();
        if (thisIcon.equals(notSelectIconString)) {
            selectedPeriodicTableButton = btnPeriodicTable_K;
            selectPeridicTabelButtonFunction();
        } else {
            ButtonRebackFunction(thisIcon);
            btnPeriodicTable_K.setIcon(notSelectIcon);
        }
    }//GEN-LAST:event_btnPeriodicTable_KActionPerformed

    private void btnPeriodicTable_CaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeriodicTable_CaActionPerformed
        // TODO add your handling code here:
        String thisIcon = btnPeriodicTable_Ca.getIcon().toString();
        if (thisIcon.equals(notSelectIconString)) {
            selectedPeriodicTableButton = btnPeriodicTable_Ca;
            selectPeridicTabelButtonFunction();
        } else {
            ButtonRebackFunction(thisIcon);
            btnPeriodicTable_Ca.setIcon(notSelectIcon);
        }
    }//GEN-LAST:event_btnPeriodicTable_CaActionPerformed

    // Element Box button Coding
    private void btnElementBox_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElementBox_BActionPerformed
        // TODO add your handling code here:
        icon = new ImageIcon(ElectronicConfigurationLevel1.class.getResource("/Images/PeriodicTableButtons_B.png"));
        selectedElementBoxButton = btnElementBox_B;
        selectElementBoxButtonFunction();
    }//GEN-LAST:event_btnElementBox_BActionPerformed

    private void btnElementBox_BeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElementBox_BeActionPerformed
        // TODO add your handling code here:
        icon = new ImageIcon(ElectronicConfigurationLevel1.class.getResource("/Images/PeriodicTableButtons_Be.png"));
        selectedElementBoxButton = btnElementBox_Be;
        selectElementBoxButtonFunction();
    }//GEN-LAST:event_btnElementBox_BeActionPerformed

    private void btnElementBox_CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElementBox_CActionPerformed
        // TODO add your handling code here:
        icon = new ImageIcon(ElectronicConfigurationLevel1.class.getResource("/Images/PeriodicTableButtons_C.png"));
        selectedElementBoxButton = btnElementBox_C;
        selectElementBoxButtonFunction();
    }//GEN-LAST:event_btnElementBox_CActionPerformed

    private void btnElementBox_CaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElementBox_CaActionPerformed
        // TODO add your handling code here:
        icon = new ImageIcon(ElectronicConfigurationLevel1.class.getResource("/Images/PeriodicTableButtons_Ca.png"));
        selectedElementBoxButton = btnElementBox_Ca;
        selectElementBoxButtonFunction();
    }//GEN-LAST:event_btnElementBox_CaActionPerformed

    private void btnElementBox_ClActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElementBox_ClActionPerformed
        // TODO add your handling code here:
        icon = new ImageIcon(ElectronicConfigurationLevel1.class.getResource("/Images/PeriodicTableButtons_Cl.png"));
        selectedElementBoxButton = btnElementBox_Cl;
        selectElementBoxButtonFunction();
    }//GEN-LAST:event_btnElementBox_ClActionPerformed

    private void btnElementBox_FActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElementBox_FActionPerformed
        // TODO add your handling code here:
        icon = new ImageIcon(ElectronicConfigurationLevel1.class.getResource("/Images/PeriodicTableButtons_F.png"));
        selectedElementBoxButton = btnElementBox_F;
        selectElementBoxButtonFunction();
    }//GEN-LAST:event_btnElementBox_FActionPerformed

    private void btnElementBox_HActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElementBox_HActionPerformed
        // TODO add your handling code here:
        icon = new ImageIcon(ElectronicConfigurationLevel1.class.getResource("/Images/PeriodicTableButtons_H.png"));
        selectedElementBoxButton = btnElementBox_H;
        selectElementBoxButtonFunction();
    }//GEN-LAST:event_btnElementBox_HActionPerformed

    private void btnElementBox_HeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElementBox_HeActionPerformed
        // TODO add your handling code here:
        icon = new ImageIcon(ElectronicConfigurationLevel1.class.getResource("/Images/PeriodicTableButtons_He.png"));
        selectedElementBoxButton = btnElementBox_He;
        selectElementBoxButtonFunction();
    }//GEN-LAST:event_btnElementBox_HeActionPerformed

    private void btnElementBox_LiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElementBox_LiActionPerformed
        // TODO add your handling code here:
        icon = new ImageIcon(ElectronicConfigurationLevel1.class.getResource("/Images/PeriodicTableButtons_Li.png"));
        selectedElementBoxButton = btnElementBox_Li;
        selectElementBoxButtonFunction();
    }//GEN-LAST:event_btnElementBox_LiActionPerformed

    private void btnElementBox_NActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElementBox_NActionPerformed
        // TODO add your handling code here:
        icon = new ImageIcon(ElectronicConfigurationLevel1.class.getResource("/Images/PeriodicTableButtons_N.png"));
        selectedElementBoxButton = btnElementBox_N;
        selectElementBoxButtonFunction();
    }//GEN-LAST:event_btnElementBox_NActionPerformed

    private void btnElementBox_NaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElementBox_NaActionPerformed
        // TODO add your handling code here:
        icon = new ImageIcon(ElectronicConfigurationLevel1.class.getResource("/Images/PeriodicTableButtons_Na.png"));
        selectedElementBoxButton = btnElementBox_Na;
        selectElementBoxButtonFunction();
    }//GEN-LAST:event_btnElementBox_NaActionPerformed

    private void btnElementBox_NeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElementBox_NeActionPerformed
        // TODO add your handling code here:
        icon = new ImageIcon(ElectronicConfigurationLevel1.class.getResource("/Images/PeriodicTableButtons_Ne.png"));
        selectedElementBoxButton = btnElementBox_Ne;
        selectElementBoxButtonFunction();
    }//GEN-LAST:event_btnElementBox_NeActionPerformed

    private void btnElementBox_OActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElementBox_OActionPerformed
        // TODO add your handling code here:
        icon = new ImageIcon(ElectronicConfigurationLevel1.class.getResource("/Images/PeriodicTableButtons_O.png"));
        selectedElementBoxButton = btnElementBox_O;
        selectElementBoxButtonFunction();
    }//GEN-LAST:event_btnElementBox_OActionPerformed

    private void btnElementBox_SActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElementBox_SActionPerformed
        // TODO add your handling code here:
        icon = new ImageIcon(ElectronicConfigurationLevel1.class.getResource("/Images/PeriodicTableButtons_S.png"));
        selectedElementBoxButton = btnElementBox_S;
        selectElementBoxButtonFunction();
    }//GEN-LAST:event_btnElementBox_SActionPerformed

    private void btnElementBox_SiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElementBox_SiActionPerformed
        // TODO add your handling code here:
        icon = new ImageIcon(ElectronicConfigurationLevel1.class.getResource("/Images/PeriodicTableButtons_Si.png"));
        selectedElementBoxButton = btnElementBox_Si;
        selectElementBoxButtonFunction();
    }//GEN-LAST:event_btnElementBox_SiActionPerformed

    private void btnElementBox_PActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElementBox_PActionPerformed
        // TODO add your handling code here:
        icon = new ImageIcon(ElectronicConfigurationLevel1.class.getResource("/Images/PeriodicTableButtons_P.png"));
        selectedElementBoxButton = btnElementBox_P;
        selectElementBoxButtonFunction();
    }//GEN-LAST:event_btnElementBox_PActionPerformed

    private void btnElementBox_AlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElementBox_AlActionPerformed
        // TODO add your handling code here:
        icon = new ImageIcon(ElectronicConfigurationLevel1.class.getResource("/Images/PeriodicTableButtons_Al.png"));
        selectedElementBoxButton = btnElementBox_Al;
        selectElementBoxButtonFunction();
    }//GEN-LAST:event_btnElementBox_AlActionPerformed

    private void btnElementBox_MgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElementBox_MgActionPerformed
        // TODO add your handling code here:
        icon = new ImageIcon(ElectronicConfigurationLevel1.class.getResource("/Images/PeriodicTableButtons_Mg.png"));
        selectedElementBoxButton = btnElementBox_Mg;
        selectElementBoxButtonFunction();
    }//GEN-LAST:event_btnElementBox_MgActionPerformed

    private void btnElementBox_KActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElementBox_KActionPerformed
        // TODO add your handling code here:
        icon = new ImageIcon(ElectronicConfigurationLevel1.class.getResource("/Images/PeriodicTableButtons_K.png"));
        selectedElementBoxButton = btnElementBox_K;
        selectElementBoxButtonFunction();
    }//GEN-LAST:event_btnElementBox_KActionPerformed

    private void btnElementBox_ArActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElementBox_ArActionPerformed
        // TODO add your handling code here:
        icon = new ImageIcon(ElectronicConfigurationLevel1.class.getResource("/Images/PeriodicTableButtons_Ar.png"));
        selectedElementBoxButton = btnElementBox_Ar;
        selectElementBoxButtonFunction();
    }//GEN-LAST:event_btnElementBox_ArActionPerformed

    private void btnPeriodicTable_NotSelectedIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeriodicTable_NotSelectedIconActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPeriodicTable_NotSelectedIconActionPerformed

    private void btnChackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChackActionPerformed
        // TODO add your handling code here:
        chack();
        
    }//GEN-LAST:event_btnChackActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        resetGame();
    }//GEN-LAST:event_btnResetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChack;
    private javax.swing.JButton btnElementBox_Al;
    private javax.swing.JButton btnElementBox_Ar;
    private javax.swing.JButton btnElementBox_B;
    private javax.swing.JButton btnElementBox_Be;
    private javax.swing.JButton btnElementBox_C;
    private javax.swing.JButton btnElementBox_Ca;
    private javax.swing.JButton btnElementBox_Cl;
    private javax.swing.JButton btnElementBox_F;
    private javax.swing.JButton btnElementBox_H;
    private javax.swing.JButton btnElementBox_He;
    private javax.swing.JButton btnElementBox_K;
    private javax.swing.JButton btnElementBox_Li;
    private javax.swing.JButton btnElementBox_Mg;
    private javax.swing.JButton btnElementBox_N;
    private javax.swing.JButton btnElementBox_Na;
    private javax.swing.JButton btnElementBox_Ne;
    private javax.swing.JButton btnElementBox_O;
    private javax.swing.JButton btnElementBox_P;
    private javax.swing.JButton btnElementBox_S;
    private javax.swing.JButton btnElementBox_Si;
    private javax.swing.JButton btnPeriodicTable_Al;
    private javax.swing.JButton btnPeriodicTable_Ar;
    private javax.swing.JButton btnPeriodicTable_B;
    private javax.swing.JButton btnPeriodicTable_Be;
    private javax.swing.JButton btnPeriodicTable_C;
    private javax.swing.JButton btnPeriodicTable_Ca;
    private javax.swing.JButton btnPeriodicTable_Cl;
    private javax.swing.JButton btnPeriodicTable_F;
    private javax.swing.JButton btnPeriodicTable_H;
    private javax.swing.JButton btnPeriodicTable_He;
    private javax.swing.JButton btnPeriodicTable_K;
    private javax.swing.JButton btnPeriodicTable_Li;
    private javax.swing.JButton btnPeriodicTable_Mg;
    private javax.swing.JButton btnPeriodicTable_N;
    private javax.swing.JButton btnPeriodicTable_Na;
    private javax.swing.JButton btnPeriodicTable_Ne;
    private javax.swing.JButton btnPeriodicTable_NotSelectedIcon;
    private javax.swing.JButton btnPeriodicTable_O;
    private javax.swing.JButton btnPeriodicTable_P;
    private javax.swing.JButton btnPeriodicTable_S;
    private javax.swing.JButton btnPeriodicTable_Si;
    private javax.swing.JButton btnReset;
    private javax.swing.JLabel health1;
    private javax.swing.JLabel health2;
    private javax.swing.JLabel health3;
    private javax.swing.JLabel health4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblCompletedDisplay;
    private javax.swing.JLabel lblMarks;
    private javax.swing.JLabel lblMessageBox;
    private javax.swing.JLabel lblPeriodicTable;
    // End of variables declaration//GEN-END:variables
}
