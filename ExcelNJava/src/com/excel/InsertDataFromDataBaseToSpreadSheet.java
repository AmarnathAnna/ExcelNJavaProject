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

public class InsertDataFromDataBaseToSpreadSheet {
   public static void main(String[] args) throws Exception {

      //Connecting to the database
/*      Class.forName("com.mysql.jdbc.Driver");
      Connection connect = DriverManager.getConnection(
         "jdbc:mysql://localhost:3306/details", "root" , "password");

      //Getting data from the table emp_tbl
      Statement statement = connect.createStatement();
      ResultSet resultSet = statement.executeQuery("select * from student_data");*/

	   /*	   String database="student.mdb";//Here database exists in the current directory  
	   
	   String url="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};"
	   		"DBQ=" + database + ";DriverID=22;READONLY=true";  
	  
	   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
	   Connection c=DriverManager.getConnection(url);  
	   Statement st=c.createStatement();  
	   ResultSet rs=st.executeQuery("select * from login");  	*/   
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

           String msAccDB = "C:/Amar/JSP/Test.accdb";
           String dbURL = "jdbc:ucanaccess://" + msAccDB; 

           // Step 2.A: Create and get connection using DriverManager class
           connection = DriverManager.getConnection(dbURL); 

           // Step 2.B: Creating JDBC Statement 
           statement = connection.createStatement();

           // Step 2.C: Executing SQL & retrieve data into ResultSet
           resultSet = statement.executeQuery("SELECT * FROM STUDENT_DATA");

           System.out.println("EMP ID\tEMP Name\t\t\tDegree\tSalary\tDept");
           System.out.println("==\t================\t===\t=======");

           //Creating a Work Book
           XSSFWorkbook workbook = new XSSFWorkbook();

           //Creating a Spread Sheet
           XSSFSheet spreadsheet = workbook.createSheet("employe db");
           XSSFRow row = spreadsheet.createRow(1);
           XSSFCell cell;
           
           cell = row.createCell(1);
           cell.setCellValue("EMPID");
           
           cell = row.createCell(2);
           cell.setCellValue("EMPNAME");
           
           cell = row.createCell(3);
           cell.setCellValue("DEGREE");
           
           cell = row.createCell(4);
           cell.setCellValue("SALARY");
           
           cell = row.createCell(5);
           cell.setCellValue("DEPT");
           int i = 2;           
           
           // processing returned data and printing into console
           while(resultSet.next()) {
        	   //System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3) + "\t" + resultSet.getInt(4)+"\t" + resultSet.getString(5));
               row = spreadsheet.createRow(i);
               cell = row.createCell(1);
               cell.setCellValue(resultSet.getInt("EMPID"));
               
               cell = row.createCell(2);
               cell.setCellValue(resultSet.getString("EMPNAME"));
               
               cell = row.createCell(3);
               cell.setCellValue(resultSet.getString("DEGREE"));
               
               cell = row.createCell(4);
               cell.setCellValue(resultSet.getString("SALARY"));
               
               cell = row.createCell(5);
               cell.setCellValue(resultSet.getString("DEPT"));
               i++;
           }
           
           FileOutputStream out = new FileOutputStream(
      	         new File("C:/Amar/JSP/excel/exceldatabase.xlsx"));
      	      
      	      workbook.write(out);
      	      out.close();
      	      
      	      System.out.println("exceldatabase.xlsx written successfully");           
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