/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Maths;

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
public class PerimeterAndArea extends javax.swing.JFrame {

    /**
     * Creates new form PerimeterAndArea
     */
    String RegisterId;

    public PerimeterAndArea() {
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
            Logger.getLogger(PerimeterAndArea.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void setSubjectDetails(String ID) {

        try {
            Connection con = Database.db.getConnection();
            String sql = "SELECT perimeterAndAreaRectangle_Marks,perimeterAndAreaRectangle_Complete,perimeterAndAreaSquare_Marks,perimeterAndAreaSquare_Complete,perimeterAndAreaTriangle_Marks,perimeterAndAreaTriangle_Complete,perimeterAndAreaCircle_Marks,perimeterAndAreaCircle_Complete FROM digital_learning_game.maths where stdRegisterId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                // get data from database
                int perimeterAndAreaRectangleComplete = rs.getInt("perimeterAndAreaRectangle_Complete");
                int perimeterAndAreaRectangleMarks = rs.getInt("perimeterAndAreaRectangle_Marks");

                int perimeterAndAreaSquareComplete = rs.getInt("perimeterAndAreaSquare_Complete");
                int perimeterAndAreaSquareMarks = rs.getInt("perimeterAndAreaSquare_Marks");

                int perimeterAndAreaTriangleComplete = rs.getInt("perimeterAndAreaTriangle_Complete");
                int perimeterAndAreaTriangleMarks = rs.getInt("perimeterAndAreaTriangle_Marks");

                int perimeterAndAreaCircleComplete = rs.getInt("perimeterAndAreaCircle_Complete");
                int perimeterAndAreaCircleMarks = rs.getInt("perimeterAndAreaCircle_Marks");

                int complete = perimeterAndAreaRectangleComplete + perimeterAndAreaSquareComplete + perimeterAndAreaTriangleComplete + perimeterAndAreaCircleComplete;
                int marks = perimeterAndAreaRectangleMarks + perimeterAndAreaSquareMarks + perimeterAndAreaTriangleMarks + perimeterAndAreaCircleMarks;

                //Set data to form
                lblRectangleComplete.setText("Completed : " + perimeterAndAreaRectangleComplete + "%");
                lblRectangleMarks.setText("Marks : " + perimeterAndAreaRectangleMarks);

                lblSquareComplete.setText("Completed : " + perimeterAndAreaSquareComplete + "%");
                lblSquareMarks.setText("Marks : " + perimeterAndAreaSquareMarks);

                lblTriangleComplete.setText("Completed : " + perimeterAndAreaTriangleComplete + "%");
                lblTriangleMarks.setText("Marks : " + perimeterAndAreaTriangleMarks);

                lblCircleComplete.setText("Completed : " + perimeterAndAreaCircleComplete + "%");
                lblCircleMarks.setText("Marks : " + perimeterAndAreaCircleMarks);

                lblComplete.setText("Completed : " + complete / 4 + "%");
                lblMarks.setText("Marks : " + marks);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PerimeterAndArea.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void setSidePnlData() {

        try {
            Connection con = Database.db.getConnection();
            String sql = "SELECT ((basicMathsLevel1_Marks+basicMathsLevel2_Marks+basicMathsLevel3_Marks+basicMathsLevel4_Marks)),((basicMathsLevel1_Complete+basicMathsLevel2_Complete+basicMathsLevel3_Complete+basicMathsLevel4_Complete)/4) FROM digital_learning_game.maths where stdRegisterId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, RegisterId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                // get data from database
                int complete = rs.getInt("((basicMathsLevel1_Complete+basicMathsLevel2_Complete+basicMathsLevel3_Complete+basicMathsLevel4_Complete)/4)");
                int marks = rs.getInt("((basicMathsLevel1_Marks+basicMathsLevel2_Marks+basicMathsLevel3_Marks+basicMathsLevel4_Marks))");
                //Set data to form           
                lblSidePnlBasicMathsComplete.setText("Completed : " + complete + "%");
                lblSidePnlBasicMathsMarks.setText("Marks : " + marks);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PerimeterAndArea.class.getName()).log(Level.SEVERE, null, ex);
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
        lblSidePnlBasicMathsComplete = new javax.swing.JLabel();
        lblSidePnlBasicMathsMarks = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblWelcomeName = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        lblUsername = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnRectangle = new javax.swing.JButton();
        lblRectangleComplete = new javax.swing.JLabel();
        lblRectangleMarks = new javax.swing.JLabel();
        lblComplete = new javax.swing.JLabel();
        lblMarks = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel7 = new javax.swing.JPanel();
        btnTriangle = new javax.swing.JButton();
        lblTriangleComplete = new javax.swing.JLabel();
        lblTriangleMarks = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        btnSquare = new javax.swing.JButton();
        lblSquareComplete = new javax.swing.JLabel();
        lblSquareMarks = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        btnCircle = new javax.swing.JButton();
        lblCircleComplete = new javax.swing.JLabel();
        lblCircleMarks = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_Back.png"))); // NOI18N
        jButton1.setText("Back to Maths");
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
        jLabel3.setText("Basic Maths");

        lblSidePnlBasicMathsComplete.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblSidePnlBasicMathsComplete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSidePnlBasicMathsComplete.setText("Completed : 0%");

        lblSidePnlBasicMathsMarks.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSidePnlBasicMathsMarks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSidePnlBasicMathsMarks.setText("Marks : 00");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSidePnlBasicMathsComplete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSidePnlBasicMathsMarks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSidePnlBasicMathsComplete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSidePnlBasicMathsMarks)
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
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))
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
        jLabel1.setText("Perimeter and Area");

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
                .addComponent(lblUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
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

        btnRectangle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_PerimeterAndArea_Rectangle.png"))); // NOI18N
        btnRectangle.setContentAreaFilled(false);
        btnRectangle.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_PerimeterAndArea_Rectangle_Hover.png"))); // NOI18N
        btnRectangle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRectangleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(btnRectangle, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRectangle, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        lblRectangleComplete.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblRectangleComplete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRectangleComplete.setText("Completed : 0%");

        lblRectangleMarks.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblRectangleMarks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRectangleMarks.setText("Marks : 0");

        lblComplete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblComplete.setForeground(new java.awt.Color(102, 102, 102));
        lblComplete.setText("Completed : 0%");

        lblMarks.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMarks.setForeground(new java.awt.Color(102, 102, 102));
        lblMarks.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMarks.setText("Marks : 00");

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        btnTriangle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_PerimeterAndArea_Triangle.png"))); // NOI18N
        btnTriangle.setContentAreaFilled(false);
        btnTriangle.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_PerimeterAndArea_Triangle_Hover.png"))); // NOI18N
        btnTriangle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTriangleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(btnTriangle, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnTriangle, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        lblTriangleComplete.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblTriangleComplete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTriangleComplete.setText("Completed : 0%");

        lblTriangleMarks.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblTriangleMarks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTriangleMarks.setText("Marks : 0");

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        btnSquare.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_PerimeterAndArea_Square.png"))); // NOI18N
        btnSquare.setContentAreaFilled(false);
        btnSquare.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_PerimeterAndArea_Square_Hover.png"))); // NOI18N
        btnSquare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSquareActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(btnSquare, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSquare, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        lblSquareComplete.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblSquareComplete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSquareComplete.setText("Completed : 0%");

        lblSquareMarks.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblSquareMarks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSquareMarks.setText("Marks : 0");

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        btnCircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_PerimeterAndArea_Circle.png"))); // NOI18N
        btnCircle.setContentAreaFilled(false);
        btnCircle.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_PerimeterAndArea_Circle_Hover.png"))); // NOI18N
        btnCircle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCircleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(btnCircle, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCircle, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        lblCircleComplete.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblCircleComplete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCircleComplete.setText("Completed : 0%");

        lblCircleMarks.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblCircleMarks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCircleMarks.setText("Marks : 0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblComplete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblMarks)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblRectangleComplete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblRectangleMarks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTriangleComplete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTriangleMarks, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCircleComplete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCircleMarks, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSquareComplete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSquareMarks, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRectangleComplete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRectangleMarks))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSquareComplete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSquareMarks)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTriangleComplete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTriangleMarks))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCircleComplete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCircleMarks)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        MathsMain mathsMainMain = new MathsMain();
        mathsMainMain.Setdata(RegisterId);
        mathsMainMain.show();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnRectangleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRectangleActionPerformed
        // TODO add your handling code here:
        PerimeterAndAreaRectangleF rectangle = new PerimeterAndAreaRectangleF();
        rectangle.Setdata(RegisterId);
        rectangle.show();
        this.dispose();
    }//GEN-LAST:event_btnRectangleActionPerformed

    private void btnTriangleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTriangleActionPerformed
        // TODO add your handling code here:
        PerimeterAndAreaTriangle triangle = new PerimeterAndAreaTriangle();
        triangle.Setdata(RegisterId);
        triangle.show();
        this.dispose();
    }//GEN-LAST:event_btnTriangleActionPerformed

    private void btnSquareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSquareActionPerformed
        // TODO add your handling code here:
        PerimeterAndAreaSquare square = new PerimeterAndAreaSquare();
        square.Setdata(RegisterId);
        square.show();
        this.dispose();
    }//GEN-LAST:event_btnSquareActionPerformed

    private void btnCircleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCircleActionPerformed
        // TODO add your handling code here:
        PerimeterAndAreaCircle circle = new PerimeterAndAreaCircle();
        circle.Setdata(RegisterId);
        circle.show();
        this.dispose();
    }//GEN-LAST:event_btnCircleActionPerformed

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
            java.util.logging.Logger.getLogger(PerimeterAndArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PerimeterAndArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PerimeterAndArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PerimeterAndArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PerimeterAndArea().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCircle;
    private javax.swing.JButton btnRectangle;
    private javax.swing.JButton btnSquare;
    private javax.swing.JButton btnTriangle;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblCircleComplete;
    private javax.swing.JLabel lblCircleMarks;
    private javax.swing.JLabel lblComplete;
    private javax.swing.JLabel lblMarks;
    private javax.swing.JLabel lblRectangleComplete;
    private javax.swing.JLabel lblRectangleMarks;
    private javax.swing.JLabel lblSidePnlBasicMathsComplete;
    private javax.swing.JLabel lblSidePnlBasicMathsMarks;
    private javax.swing.JLabel lblSquareComplete;
    private javax.swing.JLabel lblSquareMarks;
    private javax.swing.JLabel lblTriangleComplete;
    private javax.swing.JLabel lblTriangleMarks;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblWelcomeName;
    // End of variables declaration//GEN-END:variables
}
