package com.lxisoft.contacts.utility;

import java.io.*;
import java.util.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public final class FileUtils {

	private static final Logger LOGGER = LogManager.getLogger(FileUtils.class.getName());

	//WRITE TO FILE
		public static void write(String fileName, String text){
			LOGGER.info("write");
			
			try{
				PrintWriter pw = new PrintWriter(fileName);	
				pw.append(text);
				pw.println();
				pw.flush();
				pw.close();	
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
		//READ LINE
		public static String readLine(String fileName, String searchText1, String searchText2){
			LOGGER.info("readLine");
			
			Scanner scanner = null;
			String currentLine = null, word1 = null, word2 = null, word3 = null;
			
			try{
				BufferedReader br = new BufferedReader(new FileReader(fileName));
				while( (currentLine = br.readLine()) != null){
					scanner = new Scanner(currentLine);
					//Below 3 lines change according to each project
					word1 = scanner.next();
					word2 = scanner.next(); 
					word3 = scanner.next();
					if(searchText1.equals(word2) && searchText2.equals(word3)){
						return currentLine;
					}
				}
				br.close();
			}catch(IOException e){
				e.printStackTrace();
			}
				
			return null;
		}
		
		//READ FILE 
		public static List<String> readFile(String fileName){
			LOGGER.info("readFile");
			
			Scanner scanner = null;
			String currentLine = null;
			List<String> lineList = new ArrayList<String>();
			
			try{
				BufferedReader br = new BufferedReader(new FileReader(fileName));
				while( (currentLine = br.readLine()) != null){
					lineList.add(currentLine);
				}
				br.close();
			}catch(IOException e){
				e.printStackTrace();
			}
			return lineList;
		}
		
		//UPDATE TEXT OF A PARTICULAR LINE
		public static void updateTextOfMatchingLine(String fileName, String searchText, String oldText, String newText){
			LOGGER.info("update");
			
			Scanner scanner = null;
			List<String> lineList = new ArrayList<String>();
			String currentLine = null, word1 = null, word2 = null, word3 = null;
			
	        try {
	            BufferedReader br = new BufferedReader(new FileReader(fileName));
	            while( (currentLine = br.readLine()) != null){
	                scanner = new Scanner(currentLine);
					//Below 4 lines change according to each project
					word1 = scanner.next();
					word2 = scanner.next(); 
					word3 = scanner.next();
					if(searchText.equals(word2)){
	                    currentLine = currentLine.replace(oldText, newText);					
					}
	                lineList.add(currentLine);
	            }
	            br.close();
				
	            writeBackToFile(fileName, lineList);
					
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
		}
		
		//DELETE LINE CONTAINING TEXT
		public static void deleteLine(String fileName, String searchText){
			LOGGER.info("delete");
			
			Scanner scanner = null;
			List<String> lineList = new ArrayList<String>();
			String currentLine = null, word1 = null, word2 = null, word3 = null;
			
	        try {
	            BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));
	            while( (currentLine = br.readLine()) != null){
	                scanner = new Scanner(currentLine);
					//Below 4 lines change according to each project
					word1 = scanner.next();
					word2 = scanner.next(); 
					word3 = scanner.next();
					if(searchText.equals(word1)){
	                    continue;					
					}
	                lineList.add(currentLine);
	            }
	            br.close();

	            writeBackToFile(fileName, lineList);
				
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
			
		}
		
		//WRITE UPDATED CONTENT BACK TO FILE
		private static void writeBackToFile(String fileName, List<String> lineList) throws FileNotFoundException {
			LOGGER.info("writeBackToFile");
			PrintWriter pw = new PrintWriter(fileName);
			pw.write("");	//empties the file
			
			for(String s : lineList){
				pw.append(s);
				pw.println();
			}
			pw.flush();
			pw.close();
		}

}
