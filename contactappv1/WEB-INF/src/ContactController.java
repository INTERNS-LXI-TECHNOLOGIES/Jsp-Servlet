
import java.util.*;

public class ContactController{
	Contact contact;
	ArrayList<Contact> contactList;
	public void createContact(String name,String phNumber,String email){
	contact= new Contact(name,phNumber);
	contact.setEmail(email);
	
	contactList.add(contact);
	}
	
}