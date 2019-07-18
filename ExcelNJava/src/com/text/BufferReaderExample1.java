package com.text;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferReaderExample1 extends IOException{
	public static void main (String args []) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("C:\\\\Amar\\\\JSP\\\\Template.txt"));
		BufferedReader br1 ;
		String sCurrentLine; 
		String getInputFromUser = null;
		StringBuffer sb;
		 while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
				br1 = new BufferedReader(new InputStreamReader(System.in));
				getInputFromUser = br1.readLine();
				sb = new StringBuffer(getInputFromUser);
				System.out.println(sCurrentLine+" --> : "+sb.toString() );
			} 
		
	}

}
