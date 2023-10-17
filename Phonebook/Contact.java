/*This class will represent a single contact in the phonebook. 
 * It should have fields for the contact’s name, phone number, email address, address, birthday, and notes.*/

public class Contact implements Comparable<Contact>{
	
	private String name,number,email,address,birthday,notes;
    public LinkedList<Event> cEvent;
	
	public Contact() {
	}
	
	Contact(String cName,String cNumber,String cEmail,String cAddress,String cBirthday, String cNotes){
		name= cName;
		setNumber(cNumber);
		email= cEmail;
		address= cAddress;
		birthday= cBirthday;
		notes= cNotes;
		cEvent =  new LinkedList<Event>();
	}
	public int compareTo(Contact other){  // method to compare between two contacts
		if(this.name.compareTo(other.name) == 0)
		  return 0; //They are equal 
		return 1; 
	}
	
	
	public boolean removeEvents(String title) {
        Event eve = new Event();
        eve.getTitle().equals(title);
        
        if(cEvent.search(eve)) {
        	cEvent.remove(eve);
         return true;
        } 
        return false;
    }

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {  //Simple validation for the number since it's stored in a string
		
		if(number.length()<10)   
			throw new IllegalArgumentException("Number must contain 10 digits!");
		
		else {
			for(int i = 0; i < number.length(); i++) {      //To make sure that the entered input is all numbers
				if(!Character.isAlphabetic(number.charAt(i)))
					continue;
				throw new IllegalArgumentException("Phone numbeer can only have numbers!");
		} //End for loop
			this.number = number;
			} //End else 
	} //End set Number 
	
	public boolean addEvent(Event event) {
		if(cEvent.search(event)) //Event is already has been added!
			return false;
		else
			cEvent.add(event);
		return true;
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


	
	

	

}
