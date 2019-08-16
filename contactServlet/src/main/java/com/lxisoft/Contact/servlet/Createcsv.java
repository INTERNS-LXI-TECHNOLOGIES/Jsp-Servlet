package com.lxisoft.Contact.servlet;

import java.io.*;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.lxisoft.Contact.model.ContactModel;
import com.lxisoft.Contact.repositoryImpl.RepositoryImpl;


@WebServlet("/createcsv")
public class Createcsv extends HttpServlet {
	ArrayList<ContactModel> contacts = new ArrayList <ContactModel>();
	ArrayList<String> phno = new ArrayList<String>();
	RepositoryImpl ri = new RepositoryImpl();
	RepositoryImpl si = new RepositoryImpl();
	int count = 0;
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException 
	{
		String data;
		try{
			File file = new File("create.csv");
			FileReader fR = new FileReader(file);
			BufferedReader bR = new BufferedReader(fR);
			while((data = bR.readLine())!= null){
					String[] split = data.split(",");
					ContactModel cml = new ContactModel();
					cml.setName(split[0]);
					ArrayList<String> phno = new ArrayList<String>();
					
					for(int i=2;i<4;i++){
						phno.add(split[i+1]);
					}
					cml.setPhoneNumber(phno);
					cml.setMailId(split[1]);
					ri.createContact(cml);
					PrintWriter out = res.getWriter();
				}
			}catch(FileNotFoundException e){

			}
		catch(IOException e){

			}

		}
}