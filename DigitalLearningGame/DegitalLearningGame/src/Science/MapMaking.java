/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Science;

import Main.Subjects;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mmaam
 */
public class MapMaking extends javax.swing.JFrame {

    /**
     * Creates new form MapMaking
     */
    String RegisterId;

    public MapMaking() {
        initComponents();
    }

    public void Setdata(String ID) {
        RegisterId = ID;
        setRegisterDetails(ID);
        setSubjectDetails(ID);
        setSidePnlData();
        
        Database.totalDatabse dbTtl = new Database.totalDatabse();
        dbTtl.updateData(ID);
    }

    public void setRegisterDetails(String ID) {
        try {
            Connection con = Database.db.getConnection();
            String sql = "SELECT stdFirstName,stdLastName,stdUsername FROM digital_learning_game.register where stdRegisterId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String firstName = rs.getString("stdFirstName");
                String lastName = rs.getString("stdLastName");
                String username = rs.getString("stdUsername");

                lblWelcomeName.setText("Welcome " + firstName + " " + lastName);
                lblUsername.setText(username);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Subjects.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setSubjectDetails(String ID) {
        try {
            Connection con = Database.db.getConnection();
            String sql = "SELECT mapMarkingDignestiveSystem_marks,mapMarkingDignestiveSystem_completed,mapMarkingRespiratorySystem_marks,mapMarkingRespiratorySystem_completed,mapMarkingUrinarySystem_marks,mapMarkingUrinarySystem_completed FROM digital_learning_game.science where stdRegisterId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                // get data from database
                String digestiveSystemComplete = rs.getString("mapMarkingDignestiveSystem_completed");
                String digestiveSystemMarks = rs.getString("mapMarkingDignestiveSystem_marks");

                String respiratorySystemComplete = rs.getString("mapMarkingRespiratorySystem_completed");
                String respiratorySystemMarks = rs.getString("mapMarkingRespiratorySystem_marks");

                String urinarySystemComplete = rs.getString("mapMarkingUrinarySystem_completed");
                String urinarySystemMarks = rs.getString("mapMarkingUrinarySystem_marks");

                int completeDig = Integer.valueOf(digestiveSystemComplete);
                int completeRes = Integer.valueOf(respiratorySystemComplete);
                int completeUri = Integer.valueOf(urinarySystemComplete);
                int complete = completeDig + completeRes + completeUri;

                int marksDig = Integer.valueOf(digestiveSystemMarks);
                int marksRes = Integer.valueOf(respiratorySystemMarks);
                int marksUri = Integer.valueOf(urinarySystemMarks);
                int marks = marksDig + marksRes + marksUri;

                //Set data to form
                lblDigestiveSystemComplete.setText("Completed : " + digestiveSystemComplete + "%");
                lblDigestiveSystemMarks.setText("Marks : " + digestiveSystemMarks);

                lblRespiratorySystemComplete.setText("Completed : " + respiratorySystemComplete + "%");
                lblRespiratorySystemMarks.setText("Marks : " + respiratorySystemMarks);

                lblUrinarySystemComplete.setText("Completed : " + urinarySystemComplete + "%");
                lblUrinarySystemMarks.setText("Marks : " + urinarySystemMarks);
                
                lblComplete.setText("Completed : "+complete/3+"%");
                lblMarks.setText("Marks : "+marks);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MapMaking.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setSidePnlData(){
        try {
            Connection con = Database.db.getConnection();
            String sql = "SELECT electronicConfigurationLevel1_marks,electronicConfigurationLevel1_completed,electronicConfigurationLevel2_marks,electronicConfigurationLevel2_completed,electronicConfigurationLevel2_marks_II,electronicConfigurationLevel2_complete_II FROM digital_learning_game.science where stdRegisterId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, RegisterId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                // get data from database
                String electronicConfigurationLevel1Completed = rs.getString("electronicConfigurationLevel1_completed");
                String electronicConfigurationLevel1Marks = rs.getString("electronicConfigurationLevel1_marks");

                String electronicConfigurationLevel2Completed = rs.getString("electronicConfigurationLevel2_completed");
                String electronicConfigurationLevel2Marks = rs.getString("electronicConfigurationLevel2_marks");

                String electronicConfigurationLevel2Complete_II = rs.getString("electronicConfigurationLevel2_complete_II");
                String electronicConfigurationLevel2Marks_II = rs.getString("electronicConfigurationLevel2_marks_II");

                int completeLvl1 = Integer.valueOf(electronicConfigurationLevel1Completed);
                int completeLvl2 = Integer.valueOf(electronicConfigurationLevel2Completed);
                int completeLvl2_II = Integer.valueOf(electronicConfigurationLevel2Complete_II);
                int completeLvl2F = (completeLvl2_II + completeLvl2) / 2;
                int complete = completeLvl1 + completeLvl2F;

                int marksLvl1 = Integer.valueOf(electronicConfigurationLevel1Marks);
                int marksLvl2 = Integer.valueOf(electronicConfigurationLevel2Marks);
                int marksLvl2_II = Integer.valueOf(electronicConfigurationLevel2Marks_II);
                int marksLvl2F = (marksLvl2 + marksLvl2_II) / 2;
                int marks = marksLvl1 + marksLvl2F;

                //Set data to form           
                lblSidePnlElectronicConfigurationComplete.setText("Completed : " + complete / 2 + "%");
                lblSidePnlElectronicConfigurationMarks.setText("Marks : " + marks );
            }
        } catch (SQLException ex) {
            Logger.getLogger(MapMaking.class.getName()).log(Level.SEVERE, null, ex);
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
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblSidePnlElectronicConfigurationComplete = new javax.swing.JLabel();
        lblSidePnlElectronicConfigurationMarks = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblWelcomeName = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        lblUsername = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnDigestiveSystem = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        btnRespiratorySystem = new javax.swing.JButton();
        lblDigestiveSystemComplete = new javax.swing.JLabel();
        lblDigestiveSystemMarks = new javax.swing.JLabel();
        lblRespiratorySystemComplete = new javax.swing.JLabel();
        lblRespiratorySystemMarks = new javax.swing.JLabel();
        lblUrinarySystemComplete = new javax.swing.JLabel();
        lblUrinarySystemMarks = new javax.swing.JLabel();
        lblComplete = new javax.swing.JLabel();
        lblMarks = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_Back.png"))); // NOI18N
        jButton1.setText("Back to Science");
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_Back_Hover.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Other Scores");

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Electronic Configuration");

        lblSidePnlElectronicConfigurationComplete.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblSidePnlElectronicConfigurationComplete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSidePnlElectronicConfigurationComplete.setText("Completed : 0%");

        lblSidePnlElectronicConfigurationMarks.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSidePnlElectronicConfigurationMarks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSidePnlElectronicConfigurationMarks.setText("Marks : 00");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSidePnlElectronicConfigurationComplete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSidePnlElectronicConfigurationMarks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSidePnlElectronicConfigurationComplete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSidePnlElectronicConfigurationMarks)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Biological Processes in  Human Body");

        lblWelcomeName.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblWelcomeName.setText("Welcome Admin");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/profile.png"))); // NOI18N
        jButton3.setContentAreaFilled(false);

        lblUsername.setFont(new java.awt.Font("Segoe UI", 3, 16)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(102, 102, 102));
        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUsername.setText("Admin_Admin");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblWelcomeName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblWelcomeName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(40, 40, 40))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        btnDigestiveSystem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Btn_DignestiveSystem.png"))); // NOI18N
        btnDigestiveSystem.setContentAreaFilled(false);
        btnDigestiveSystem.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Btn_DignestiveSystem_Hover.png"))); // NOI18N
        btnDigestiveSystem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDigestiveSystemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnDigestiveSystem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnDigestiveSystem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Btn_UrinarySystem.png"))); // NOI18N
        jButton2.setContentAreaFilled(false);
        jButton2.setRolloverIcon(new javax.swing.ImageIcon("D:\\COURSE WORKS\\JAVA PROGRAMMING\\GUI\\CODE FAST COMPATITION\\DigitalLearningGame\\DegitalLearningGame\\src\\Images\\Btn_UrinarySystem_Hover.png")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        btnRespiratorySystem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Btn_RespiratorySystem.png"))); // NOI18N
        btnRespiratorySystem.setContentAreaFilled(false);
        btnRespiratorySystem.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Btn_RespiratorySystem_Hover.png"))); // NOI18N
        btnRespiratorySystem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRespiratorySystemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRespiratorySystem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRespiratorySystem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        lblDigestiveSystemComplete.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblDigestiveSystemComplete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDigestiveSystemComplete.setText("Completed : 0%");

        lblDigestiveSystemMarks.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblDigestiveSystemMarks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDigestiveSystemMarks.setText("Marks : 0");

        lblRespiratorySystemComplete.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblRespiratorySystemComplete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRespiratorySystemComplete.setText("Completed : 0%");

        lblRespiratorySystemMarks.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblRespiratorySystemMarks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRespiratorySystemMarks.setText("Marks : 0");

        lblUrinarySystemComplete.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblUrinarySystemComplete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUrinarySystemComplete.setText("Completed : 0%");

        lblUrinarySystemMarks.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblUrinarySystemMarks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUrinarySystemMarks.setText("Marks : 0");

        lblComplete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblComplete.setForeground(new java.awt.Color(102, 102, 102));
        lblComplete.setText("Completed : 0%");

        lblMarks.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMarks.setForeground(new java.awt.Color(102, 102, 102));
        lblMarks.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMarks.setText("Marks : 00");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblDigestiveSystemComplete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDigestiveSystemMarks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblRespiratorySystemComplete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRespiratorySystemMarks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblUrinarySystemComplete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblUrinarySystemMarks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(44, 44, 44))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblComplete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblMarks)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblComplete)
                    .addComponent(lblMarks))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblDigestiveSystemComplete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDigestiveSystemMarks))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblRespiratorySystemComplete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRespiratorySystemMarks))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblUrinarySystemComplete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUrinarySystemMarks)))
                .addContainerGap(114, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDigestiveSystemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDigestiveSystemActionPerformed
        // TODO add your handling code here:
        MapMarkingDigestiveSystem digestive = new MapMarkingDigestiveSystem();
        digestive.Setdata(RegisterId);
        digestive.show();
        this.dispose();
    }//GEN-LAST:event_btnDigestiveSystemActionPerformed

    private void btnRespiratorySystemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRespiratorySystemActionPerformed
        // TODO add your handling code here:
        MapMarkingRespiratorySystem respiratory = new MapMarkingRespiratorySystem();
        respiratory.Setdata(RegisterId);
        respiratory.show();
        this.dispose();
    }//GEN-LAST:event_btnRespiratorySystemActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ScienceMain scienceMain = new ScienceMain();
        scienceMain.Setdata(RegisterId);
        scienceMain.show();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        MapMarkingUrinarySystem urinary = new MapMarkingUrinarySystem();
        urinary.Setdata(RegisterId);
        urinary.show();
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(MapMaking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MapMaking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MapMaking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MapMaking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MapMaking().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDigestiveSystem;
    private javax.swing.JButton btnRespiratorySystem;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblComplete;
    private javax.swing.JLabel lblDigestiveSystemComplete;
    private javax.swing.JLabel lblDigestiveSystemMarks;
    private javax.swing.JLabel lblMarks;
    private javax.swing.JLabel lblRespiratorySystemComplete;
    private javax.swing.JLabel lblRespiratorySystemMarks;
    private javax.swing.JLabel lblSidePnlElectronicConfigurationComplete;
    private javax.swing.JLabel lblSidePnlElectronicConfigurationMarks;
    private javax.swing.JLabel lblUrinarySystemComplete;
    private javax.swing.JLabel lblUrinarySystemMarks;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblWelcomeName;
    // End of variables declaration//GEN-END:variables
}
