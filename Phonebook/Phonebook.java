/*This class will represent the phonebook application itself. 
 * It should have a field for the linked list ADT that stores the contacts and 
 * methods for interacting with the list (e.g., adding, searching, and deleting contacts). 
 * You will also need to schedule events and appointments with contacts.*/
public class Phonebook {
	private ADT clist;
	
	Phonebook(){
		clist = new ADT();
	}
	
	public void addC(Contact c) {
		if(existContact(c))
			System.out.println("This contact has been added previously!");
		else
			clist.add(c);
	}
	
	public boolean existContact(Contact c) {
		if(clist.search(c)==true)   // if it's found
			return true;
		return false;
	}
	
	

}
