package com.lxisoft.model;

public class Contact  {
	private int id;
	private String first_Name;
	private String last_Name;
	private String phone;
	private String number;
	private String email;


		public Contact(int id){
			this.id=id;
		}
		public Contact(int id,String first_Name,String last_Name,String phone,String number,String email){
			this.id=id;
			this.first_Name=first_Name;
			this.last_Name=last_Name;
			this.phone=phone;
			this.number=number;
			this.email=email;
		}
		
		public Contact(String first_Name,String last_Name,String phone,String number,String email){
			this.first_Name=first_Name;
			this.last_Name=last_Name;
			this.phone=phone;
			this.number=number;
			this.email=email;
		}
		
		public int getId(){
			return id;
		}
		
		public String getFirstName() {
	        return first_Name;
	    }
		
		public String getLastName() {
	        return last_Name;
	    }
		
		public String getEmail() {
	        return email;
	    }

		public String getPhone() {
	        return phone;
	    }
		
		public String getNumber() {
	        return number;
	    }
		
		public String toString(){
		return first_Name+" "+last_Name+" "+phone+" "+number+" "+email+" ";
		}

}
