package com.pdf;

import java.io.File; 
import java.io.IOException;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument; 
import org.apache.pdfbox.pdmodel.PDPage;  

public class AddingPagesToPdf { 
   public static void main(String args[]) throws IOException, COSVisitorException { 
      
      //Creating PDF document object 
      PDDocument document = new PDDocument(); 
      
      File file = new File("C:/Amar/Personal/Receipt_HKHalli_26_04_2019.pdf"); 
      PDDocument.load(file);
      
      for (int i=0; i<5; i++){ 
         //Creating a blank page 
         PDPage blankPage = new PDPage(); 
         
         //Adding the blank page to the document 
         document.addPage(blankPage); 
      } 
      //Saving the document 
      document.save("C:/Amar/JSP/PDF/BlankPdf.pdf"); 
      System.out.println("PDF created");  
      
      //Closing the document  
      document.close(); 
   }  
}