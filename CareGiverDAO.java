/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caregivers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author 27672
 */
public class CareGiverDAO {
    
    private static final String DATABASE_URL = "jdbc:derby://localhost:1527/Caregiver";
    private static final String USERNAME = "administrator"; 
    private static final String PASSWORD = "password";
    
    public static void populateComboBox(JComboBox cboCaregiverTypeName){
        Connection connection = null;
        Statement statement = null;
        String sql = "SELECT * FROM CAREGIVERTYPE";      
        
        try{
               connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
               statement = connection.createStatement();
               ResultSet resultSet = statement.executeQuery(sql);
               if(resultSet != null)
                   while(resultSet.next()){
                       cboCaregiverTypeName.addItem(resultSet.getString(1));
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
    }
    
     public static boolean isCaregiverCodeUnique(CareGiver c){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        boolean unique = false;
        int ok;
           
           try{
               connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
               statement = connection.createStatement();
               resultSet = statement.executeQuery("SELECT* FROM caregivers WHERE caregiverCode = '"+ c.getCaregiverCode()+"'");
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
    
    public static void saveToDataBase(CareGiver c){
        
           Connection connection = null;
           PreparedStatement statement = null;
           int ok;
           
           try{
               connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
               statement = connection.prepareStatement("INSERT INTO caregivers VALUES(?,?,?,?,?)");
               statement.setString(1, c.getCaregiverCode());
               statement.setString(2, c.getFirstName());
               statement.setString(3, c.getLastName());
               statement.setString(4, c.getCaregiverTypeName());
               statement.setBoolean(5, c.isHasResources());
               
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
           
    }
}
