/*This class will represent a single contact in the phonebook. 
 * It should have fields for the contact’s name, phone number, email address, address, birthday, and notes.*/
public class Contact {
	
	private String name,email,address,birthday,notes;
	private int pnumber;
	
	Contact(String n,int number,String em,String addr,String birth, String note){
		name= n;
		pnumber= number;
		email= em;
		address= addr;
		birthday= birth;
		notes= note;
	}

}
