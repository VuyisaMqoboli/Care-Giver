/* CareGiver.java
 * This is the caregiver section that connects to the databases
 * Author: Vuyisa Lutho Mqoboli (219191018)
 * 8 August 2022
*/
package com.mycompany.caregivers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class CareGiver {
    private String caregiverCode;
    private String firstName;
    private String lastName;
    private String caregiverTypeName;
    private boolean hasResources;
    
    static final String DATABASE_URL = "jdbc:derby://localhost:1527/Caregiver";
    private final String USERNAME = "administrator"; 
    private final String PASSWORD = "password";

    public CareGiver() {
    }

    public CareGiver(String caregiverCode, String firstName, String lastName, String caregiverTypeName, boolean hasResources) {
        this.caregiverCode = caregiverCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.caregiverTypeName = caregiverTypeName;
        this.hasResources = hasResources;
    }

    public String getCaregiverCode() {
        return caregiverCode;
    }

    public void setCaregiverCode(String caregiverCode) {
        this.caregiverCode = caregiverCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCaregiverTypeName() {
        return caregiverTypeName;
    }

    public void setCaregiverTypeName(String caregiverTypeName) {
        this.caregiverTypeName = caregiverTypeName;
    }

    public boolean isHasResources() {
        return hasResources;
    }

    public void setHasResources(boolean hasResources) {
        this.hasResources = hasResources;
    }

    @Override
    public String toString() {
        return "CareGiver{" + "caregiverCode=" + caregiverCode + ", firstName=" + firstName + ", lastName=" + lastName + ", caregiverTypeName=" + caregiverTypeName + ", hasResources=" + hasResources + ", USERNAME=" + USERNAME + ", PASSWORD=" + PASSWORD + '}';
    }
    
    
   /* public ArrayList<String> populateComboBox(){
        Connection connection = null;
        Statement statement = null;
        ArrayList<String> cmbcaregiverTypeNameList = new ArrayList<>();
        String sql = "SELECT * FROM CAREGIVERTYPE";
       
        
        try{
               connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
               statement = connection.createStatement();
               ResultSet resultSet = statement.executeQuery(sql);
               if(resultSet != null)
                   while(resultSet.next()){
                       cmbcaregiverTypeNameList.add(resultSet.getString(1));
                   }
           }catch(SQLException SQLExpcetion){
               JOptionPane.showMessageDialog(null,"Error: Could not read from the Database"+ SQLExpcetion);
           }catch(Exception exception){
               JOptionPane.showMessageDialog(null, "Error: "+ exception);
           }finally {
               try{
                 if(statement != null)  
                     statement.close();
               }catch(Exception exception){
                   JOptionPane.showMessageDialog(null, exception.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
               }try{
                 if(connection != null)  
                     connection.close();
               }catch(Exception exception){
                   JOptionPane.showMessageDialog(null, exception.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
               }
           }
        return cmbcaregiverTypeNameList;
    }

    public boolean isCaregiverCodeUnique(){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        boolean unique = false;
        int ok;
           
           try{
               connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
               statement = connection.createStatement();
               resultSet = statement.executeQuery("SELECT* FROM caregivers WHERE caregiverCode = '"+ caregiverCode+"'");
               if(!resultSet.next())
                   unique = true;
               
           }catch(SQLException SQLExpcetion){
               JOptionPane.showMessageDialog(null,"Could not add caregiver code"+ SQLExpcetion);
           }catch(Exception exception){
               JOptionPane.showMessageDialog(null, "Error: "+ exception);
           }finally {
               try{
                 if(statement != null)  
                     statement.close();
               }catch(Exception exception){
                   JOptionPane.showMessageDialog(null, exception.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
               }try{
                 if(connection != null)  
                     connection.close();
               }catch(Exception exception){
                   JOptionPane.showMessageDialog(null, exception.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
               }
           }
           return unique;

    }
    
    public void saveToDataBase(){
        
           Connection connection = null;
           PreparedStatement statement = null;
           int ok;
           
           try{
               connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
               statement = connection.prepareStatement("INSERT INTO caregivers VALUES(?,?,?,?,?)");
               statement.setString(1, caregiverCode);
               statement.setString(2, firstName);
               statement.setString(3, lastName);
               statement.setString(4, caregiverTypeName);
               statement.setBoolean(5, hasResources);
               
               ok = statement.executeUpdate();
               
               if(ok>0){
                   JOptionPane.showMessageDialog(null, "Caregiver added successfully.");
               }else{
                   JOptionPane.showMessageDialog(null, "Could not add caregiver");
               }
               
           }catch(SQLException SQLExpcetion){
               JOptionPane.showMessageDialog(null,"Error: "+SQLExpcetion.getMessage());
           }catch(Exception exception){
               JOptionPane.showMessageDialog(null, "Error: "+ exception.getMessage());
            
           }finally {
               try{
                 if(statement != null)  
                     statement.close();
               }catch(Exception exception){
                   JOptionPane.showMessageDialog(null, exception.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
               }try{
                 if(connection != null)  
                     connection.close();
               }catch(Exception exception){
                   JOptionPane.showMessageDialog(null, exception.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
               }
           }
           
    }*/

}
