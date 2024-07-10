/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

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
public class totalDatabse {

    int mathsMarks = 0;
    int mathsComplete = 0;
    int scienceMarks = 0;
    int ScienceComplete = 0;
    int ictMarks = 0;
    int ictComplete = 0;

    public void updateData(String ID){
        //Get Data
        selectSumMathsScore(ID);
        selectSumScienceScore(ID);
        selectSumIctScore(ID);
        
        //update Data
        updateDataToTables(ID);
        updateDataToRegisterTable(ID);
    }
    
    // GetdataFromDatabase
    public void selectSumMathsScore(String ID) {
        int totalMarksMaths = 0;
        int totalCompleteMaths = 0;
        //Maths Marks
        try {
            Connection con = Database.db.getConnection();
            String sql = "SELECT stdRegisterId,((basicMathsLevel1_Marks+basicMathsLevel2_Marks+basicMathsLevel3_Marks+basicMathsLevel4_Marks)+(perimeterAndAreaRectangle_Marks+perimeterAndAreaSquare_Marks+perimeterAndAreaTriangle_Marks+perimeterAndAreaCircle_Marks)) FROM digital_learning_game.maths where stdRegisterId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                totalMarksMaths = rs.getInt("((basicMathsLevel1_Marks+basicMathsLevel2_Marks+basicMathsLevel3_Marks+basicMathsLevel4_Marks)+(perimeterAndAreaRectangle_Marks+perimeterAndAreaSquare_Marks+perimeterAndAreaTriangle_Marks+perimeterAndAreaCircle_Marks))");

            }
        } catch (SQLException ex) {
            Logger.getLogger(totalDatabse.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Maths Complete
        try {
            Connection con = Database.db.getConnection();
            String sql = "SELECT stdRegisterId,((((basicMathsLevel1_Complete+basicMathsLevel2_Complete+basicMathsLevel3_Complete+basicMathsLevel4_Complete)/4) +((perimeterAndAreaRectangle_Complete+perimeterAndAreaSquare_Complete+perimeterAndAreaTriangle_Complete+perimeterAndAreaCircle_Complete)/4))/2)FROM digital_learning_game.maths where stdRegisterId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                totalCompleteMaths = rs.getInt("((((basicMathsLevel1_Complete+basicMathsLevel2_Complete+basicMathsLevel3_Complete+basicMathsLevel4_Complete)/4) +((perimeterAndAreaRectangle_Complete+perimeterAndAreaSquare_Complete+perimeterAndAreaTriangle_Complete+perimeterAndAreaCircle_Complete)/4))/2)");
            }
        } catch (SQLException ex) {
            Logger.getLogger(totalDatabse.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        mathsMarks = totalMarksMaths;
        mathsComplete = totalCompleteMaths;

    }

    public void selectSumScienceScore(String ID) {
        int totalMarksScience = 0;
        int totalCompleteScience = 0;
        //science Marks
        try {
            Connection con = Database.db.getConnection();
            String sql = "SELECT stdRegisterId,(electronicConfigurationLevel1_marks+((electronicConfigurationLevel2_marks+electronicConfigurationLevel2_marks_II)/2)+mapMarkingDignestiveSystem_marks+mapMarkingRespiratorySystem_marks+mapMarkingUrinarySystem_marks) FROM digital_learning_game.science where stdRegisterId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                totalMarksScience = rs.getInt("(electronicConfigurationLevel1_marks+((electronicConfigurationLevel2_marks+electronicConfigurationLevel2_marks_II)/2)+mapMarkingDignestiveSystem_marks+mapMarkingRespiratorySystem_marks+mapMarkingUrinarySystem_marks)");

            }
        } catch (SQLException ex) {
            Logger.getLogger(totalDatabse.class.getName()).log(Level.SEVERE, null, ex);
        }
        //science Complete
        try {
            Connection con = Database.db.getConnection();
            String sql = "SELECT stdRegisterId,(((electronicConfigurationLevel1_completed+((electronicConfigurationLevel2_completed+electronicConfigurationLevel2_complete_II)/2))/2)+((mapMarkingDignestiveSystem_completed+mapMarkingRespiratorySystem_completed+mapMarkingUrinarySystem_completed)/3)) FROM digital_learning_game.science where stdRegisterId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                totalCompleteScience = rs.getInt("(((electronicConfigurationLevel1_completed+((electronicConfigurationLevel2_completed+electronicConfigurationLevel2_complete_II)/2))/2)+((mapMarkingDignestiveSystem_completed+mapMarkingRespiratorySystem_completed+mapMarkingUrinarySystem_completed)/3))");
            }
        } catch (SQLException ex) {
            Logger.getLogger(totalDatabse.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        scienceMarks = totalMarksScience;
        ScienceComplete= totalCompleteScience;
    }

    public void selectSumIctScore(String ID) {
        int totalMarksIct1 = 0;
        int totalMarksIct2 = 0;
        int totalCompleteIct1 = 0;
        int totalCompleteIct2 = 0;
        //ict Marks
        try {
            Connection con = Database.db.getConnection();
            String sql = "SELECT stdRegisterId,((ictMCQ_marks+ictFillInTheBlanks_marks)+(fundamentalsOfcompSysMCQ_marks+fundamentalsOfcompSysFillInTheBlanks_marks)+(basicLogicGates_marks+advanceLogicGates_BooleanMap_marks)),(numberSystemAddition10_marks+numberSystemAddition8_marks+numberSystemAddition16_marks+numberSystemAddition2_marks) FROM digital_learning_game.ict where stdRegisterId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                totalMarksIct1 = rs.getInt("((ictMCQ_marks+ictFillInTheBlanks_marks)+(fundamentalsOfcompSysMCQ_marks+fundamentalsOfcompSysFillInTheBlanks_marks)+(basicLogicGates_marks+advanceLogicGates_BooleanMap_marks))");
                totalMarksIct2 = rs.getInt("(numberSystemAddition10_marks+numberSystemAddition8_marks+numberSystemAddition16_marks+numberSystemAddition2_marks)");
            }
        } catch (SQLException ex) {
            Logger.getLogger(totalDatabse.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ict Complete
        try {
            Connection con = Database.db.getConnection();
            String sql = "SELECT stdRegisterId,((((ictMCQ_complete+ictFillInTheBlanks_completed)/2)+((fundamentalsOfcompSysMCQ_complete+fundamentalsOfcompSysFillInTheBlanks_completed)/2)+((basicLogicGates_complete+advanceLogicGates_BooleanMap_complete)/2))/4),(((numberSystemAddition10_complete+numberSystemAddition8_complete+numberSystemAddition16_complete+numberSystemAddition2_complete)/4)/4) FROM digital_learning_game.ict where stdRegisterId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                totalCompleteIct1 = rs.getInt("((((ictMCQ_complete+ictFillInTheBlanks_completed)/2)+((fundamentalsOfcompSysMCQ_complete+fundamentalsOfcompSysFillInTheBlanks_completed)/2)+((basicLogicGates_complete+advanceLogicGates_BooleanMap_complete)/2))/4)");
                totalCompleteIct2 = rs.getInt("(((numberSystemAddition10_complete+numberSystemAddition8_complete+numberSystemAddition16_complete+numberSystemAddition2_complete)/4)/4)");
            }
        } catch (SQLException ex) {
            Logger.getLogger(totalDatabse.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ictMarks=totalMarksIct1+totalMarksIct2;
        ictComplete=totalCompleteIct1+totalCompleteIct2;
       
    }

    // Update data in Database
    public void updateDataToTables(String ID){
        try {
            // create connection to database
            Connection con = Database.db.getConnection();
            // Create prepared statement with the sql query
            String sqlMaths ="UPDATE `digital_learning_game`.`maths` SET `mathsTotalMarks` = '"+mathsMarks+"', `mathsTotalComplete` = '"+mathsComplete+"' WHERE (`stdRegisterId` = ?);";
            String sqlScience ="UPDATE `digital_learning_game`.`science` SET `scienceTotalMarks` = '"+scienceMarks+"', `scienceTotalComplete` = '"+ScienceComplete+"' WHERE (`stdRegisterId` = ?);";
            String sqlIct = "UPDATE `digital_learning_game`.`ict` SET `ictTotalMarks` = '"+ictMarks+"', `ictTotalComplete` = '"+ictComplete+"' WHERE (`stdRegisterId` = ?);";
            
            PreparedStatement st1 = con.prepareStatement(sqlMaths);
            PreparedStatement st2 = con.prepareStatement(sqlScience);
            PreparedStatement st3 = con.prepareStatement(sqlIct);
            
            st1.setString(1, ID);
            st2.setString(1, ID);
            st3.setString(1, ID);
            
            // execute query
            st1.executeUpdate();
            st2.executeUpdate();
            st3.executeUpdate();
                        
            // show success message
            //JOptionPane.showMessageDialog(this, "Successfully Inserted...");
        } catch (SQLException ex) {
            Logger.getLogger(totalDatabse.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void updateDataToRegisterTable(String ID){
        int totalMarks = mathsMarks+scienceMarks+ictMarks;
        int totalComplete = (mathsComplete+ScienceComplete+ictComplete)/3;
        
        try {
            // create connection to database
            Connection con = Database.db.getConnection();
            // Create prepared statement with the sql query
            String sql = "UPDATE `digital_learning_game`.`register` SET `stdTotalMarks` = '"+totalMarks+"', `stdTotalComplete` = '"+totalComplete+"' WHERE (`stdRegisterId` = ?);";
            PreparedStatement st1 = con.prepareStatement(sql);
            st1.setString(1, ID);
            // execute query
            st1.executeUpdate();
            
            // show success message
            //JOptionPane.showMessageDialog(this, "Successfully Inserted...");
        } catch (SQLException ex) {
            Logger.getLogger(totalDatabse.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
