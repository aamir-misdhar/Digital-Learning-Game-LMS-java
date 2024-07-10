/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Global;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author mmaam
 */
public class Validations {
     public static final String EMAIL
            = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public static final String PHONE_NUMBER = "\\d{10}";
    public static final String ALPHA_NUMERIC = "^[a-zA-Z0-9]+$";
    public static final String ALPHA = "^[ a-zA-Z]+$";
    public static final String ALPHA_DOT = "^[a-zA-Z .]+$";
    public static final String NUMERIC = ".*\\D.*";
    public static final String HEX = "^[0-9A-Fa-f]+$";
    public static final String DOUBLE = "^[-+]?\\d+(\\.{0,1}(\\d+?))?$";
   // public static final String DOUBLE = "^[-+]?\\d{1,10}+(\\.{0,1}(\\d{0,3}))?$";
    public static final String NIC = "^\\d{9}(X|V|x|v)$";
    public static final String IP = "^(([0-9]|[1-9][0-9]|1[0-9]{2}|"
            + "2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|"
            + "2[0-4][0-9]|25[0-5])$";

    /**
     * Check the given email is a valid email
     * @param email email to be checked
     * @return True if valid else False
     */
    public static boolean isValidEmail(String email) {

        Pattern p = Pattern.compile(EMAIL);
        Matcher matcher = p.matcher(email);
        return matcher.matches();
        
    }
    
     /**
     * Check the given regNo is a valid regNo
     * @param regNo email to be checked
     * @return True if valid else False
     */
    public static boolean isValidregNo(String regNo) {

        Pattern p = Pattern.compile(NUMERIC);
        Matcher matcher = p.matcher(regNo);
        return matcher.matches();
        
    }
    
     /**
     * Check the given Name is a valid Name
     * @param Name email to be checked
     * @return True if valid else False
     */
    public static boolean isValidName(String Name) {

        Pattern p = Pattern.compile(ALPHA);
        Matcher matcher = p.matcher(Name);
        return matcher.matches();
        
    }
    
     /**
     * Check the given NIC is a valid NIC
     * @param Nic email to be checked
     * @return True if valid else False
     */
    public static boolean isValidNic(String Nic) {

        Pattern p = Pattern.compile(NIC);
        Matcher matcher = p.matcher(Nic);
        return matcher.matches();
        
    }
    
     /**
     * Check the given email is a valid email
     * @param mobile email to be checked
     * @return True if valid else False
     */
    public static boolean isValidMobile(String mobile) {

        Pattern p = Pattern.compile(PHONE_NUMBER);
        Matcher matcher = p.matcher(mobile);
        return matcher.matches();
        
    }
}
