/*This class will represent a single contact in the phonebook. 
 * It should have fields for the contact’s name, phone number, email address, address, birthday, and notes.*/
public class Contact implements Comparable{
	
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
	public boolean compare(Contact other){   // method to compare between two contacts still not implemented
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getPnumber() {
		return pnumber;
	}

	public void setPnumber(int pnumber) {
		this.pnumber = pnumber;
	}
	

}
