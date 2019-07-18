package com.pdf;

import java.io.File; 
import java.io.IOException;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;  

public class RemovingPagesFromPdf { 
   public static void main(String args[]) throws IOException, COSVisitorException {  
      
      //Loading an existing document 
      File file = new File("C:/Amar/JSP/PDF/BlankPdf.pdf"); 
      PDDocument doc = PDDocument.load(file); 
       
      //Listing the number of existing pages       
      System.out.print(doc.getNumberOfPages()); 
       
      for(int i = 0; i<2; i++){
         
         //removing the pages 
         doc.removePage(i); 
      } 
      System.out.println("page removed");       
      
      //Saving the document 
      doc.save("C:/Amar/JSP/PDF/BlankPdf.pdf");     
      
      //Closing the document  
      doc.close(); 
   }  
} 