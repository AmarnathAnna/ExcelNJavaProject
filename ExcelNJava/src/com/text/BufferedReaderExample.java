package com.text;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderExample {
	   public static void main(String[] args) {
	      try (BufferedReader br = new BufferedReader(
	         new FileReader("C:\\\\Amar\\\\JSP\\\\DR_Cmd.txt"))) { 
	         
	         String sCurrentLine;
	         while ((sCurrentLine = br.readLine()) != null) {
					System.out.println(sCurrentLine);
			 
				} 
		      System.out.println("Test");
	      } catch (IOException e) {
	         e.printStackTrace();
	      } 
	   }
	}  
