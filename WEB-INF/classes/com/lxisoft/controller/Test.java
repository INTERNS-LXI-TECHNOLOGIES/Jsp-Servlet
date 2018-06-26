package com.lxisoft.controller;
import java.io.*;
import java.util.*;
import com.lxisoft.model.*;
public class Test



{
public 	static void main(String [] args)
	{
		ArrayList<Contact>contacts=new ArrayList<Contact>();
		File dir=new File("C://apache-tomcat-7.0.72/webapps/ContactsFile/data");
		File contactDatas=new File(dir,"Datas.txt");
		
		Contact[] contactsTemp=new Contact[10];
		
		try{
				if(contactDatas!=null)
				{
					BufferedReader br=new BufferedReader(new FileReader(contactDatas));//null is coming
					
					String data= null;
					int i=0;
					int temp=0;
						while(temp<=1){
							
							data=br.readLine();
										System.out.println("looooppppppppppppppppppppp" +i);
							String[]datas=data.split(",");
							System.out.println("Contact-From file Reading +++++++++++++++++"+datas[0]+datas[1]+datas[2]);
							int id=Integer.parseInt(datas[0]);
							Contact c =new Contact(id,datas[1],datas[2]);
							contactsTemp[i]=c;
							//System.out.println("In list while loop "+contacts.get(i).getName()+" and size is "+contacts.size());
				
					i++;
					temp++;
						}
						br.close();
						
						
				}
			}
		catch(IOException e){
			
			System.out.println("getContacts/ "+e);
			
		}
					System.out.println(" +++++++++++++++++size "+contacts.size());

		for(Contact cp:contactsTemp){
			
			System.out.println(" +++++++++++++++++"+cp.getName());
		}
	}
	
}