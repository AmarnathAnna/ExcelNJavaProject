package com.excel;

import java.io.File;
import java.io.FileOutputStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadAccessDBFromJava {
   public static void main(String[] args) throws Exception {


       Connection connection = null;
       Statement statement = null;
       ResultSet resultSet = null;

    // Step 1: Loading or registering Oracle JDBC driver class
       try {

           Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
       }
       catch(ClassNotFoundException cnfex) {

           System.out.println("Problem in loading or "
                   + "registering MS Access JDBC driver");
           cnfex.printStackTrace();
       }
       
       
    // Step 2: Opening database connection
       try {

           String msAccDB = "C:/Amar/JSP/excel/Test.accdb";
           String dbURL = "jdbc:ucanaccess://" + msAccDB; 

           // Step 2.A: Create and get connection using DriverManager class
           connection = DriverManager.getConnection(dbURL); 

           // Step 2.B: Creating JDBC Statement 
           statement = connection.createStatement();

           // Step 2.C: Executing SQL & retrieve data into ResultSet
           resultSet = statement.executeQuery("SELECT * FROM STUDENT_DATA");

           System.out.println("EMP ID\tEMP Name\t\t\tDegree\tSalary\tDept");
           System.out.println("==\t================\t===\t=======");

           // processing returned data and printing into console
           while(resultSet.next()) {
               System.out.println(resultSet.getInt(1) + "\t" + 
                       resultSet.getString(2) + "\t" + 
                       resultSet.getString(3) + "\t" +
                       resultSet.getInt(4)+"\t" +
                       resultSet.getString(5));
           }
       }
       catch(SQLException sqlex){
           sqlex.printStackTrace();
       }
       finally {

           // Step 3: Closing database connection
           try {
               if(null != connection) {

                   // cleanup resources, once after processing
                   resultSet.close();
                   statement.close();

                   // and then finally close connection
                   connection.close();
               }
           }
           catch (SQLException sqlex) {
               sqlex.printStackTrace();
           }
       }
       
       
	   
   }
}