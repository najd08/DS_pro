/*This class will represent the phonebook application itself. 
 * It should have a field for the linked list ADT that stores the contacts and 
 * methods for interacting with the list (e.g., adding, searching, and deleting contacts). 
 * You will also need to schedule events and appointments with contacts.*/

import java.util.Scanner;

public class Phonebook {
    static Scanner input = new Scanner(System.in);
    
    public static LinkedList <Contact> contacts = new LinkedList <Contact>();
    public static LinkedList <Event> events = new LinkedList <Event>();
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to the Linked Tree Phonebook!");
		display();

	} // End main
	
	
	public static boolean existContact(Contact c) {
		if(contacts.searchMatch(c.getName(), c.getEmail())==true)   // if it's found
			return true;
		return false;
	}
	
    public static void display() {
    	String name, pnumber,email,adress,birthday,note, eventTitle, dateTime,date,time ,location;
    	int searchChoice;
    
    	boolean flag = true; 
    	while(flag) { //To repeat showing the menu 
				System.out.println("choose an option:\n"
				+ "1. Add a contact\n"
				+ "2. Search for a contact\n"
				+ "3. Delete a contact\n"
				+ "4. Schedule an event\n"
				+ "5. Print event details\n"
				+ "6. Print contacts by first name\n"
				+ "7. Print all events alphabetically\n"
				+ "8. Exit\n"
				+ "Enter your choice:");
		
		//try {  // Input handling using exceptions
		 int choice = input.nextInt();
		 switch(choice) {
		 case 1:  // Add contact
			System.out.println("\nEnter the contact's name: ");
			 name = input.nextLine();
		  	       input.nextLine(); //for emptying the garbage
		    System.out.println("Enter the contact's phone number: ");
		     pnumber = input.nextLine();
		    System.out.println("Enter the contact's email address: ");
		     email = input.nextLine();
		    System.out.println(" Enter the contact's address: ");
		     adress = input.nextLine();
		     System.out.println(); //for emptying the garbage
		    System.out.println( "Enter the contact's birthday:  ");
		     birthday = input.nextLine();
		    System.out.println("Enter any notes for the contact: ");
		     note = input.nextLine();
		      Contact c = new Contact(name,pnumber,email,adress,birthday,note);
		      if( contacts.search(c) != true) //checking if it already exists
		    	  contacts.add(c);
		      else
		    	  System.out.println("Contact already exists");
		      break;
		      
		 case 2: //Search a contact
			 System.out.println("Enter search criteria:\n"
			 		+ "1. Name\n"
			 		+ "2. Phone Number\n"
			 		+ "3. Email Address\n"
			 		+ "4. Address\n"
			 		+ "5. Birthday");
			 System.out.println("Enter your choice:");           
			 searchChoice = input.nextInt();
			 
			  if(searchChoice == 1) { //Search by name
				  System.out.println("Enter the contact's name:");
				  String name1 = input.nextLine();
				   contacts.searchByName(name1);
				} 
			  else if(searchChoice == 2) { //Search by phone number
				  System.out.println("Enter the contact's Phone Number:");
				  String pnumber1 = input.nextLine();
				  contacts.searchByPhoneNumber(pnumber1);
			  }
              else if(searchChoice == 3) { //Search by Email Address
            	  System.out.println("Enter the contact's Email Address:");
				  String email1 = input.nextLine();
				  for (int i = 0; i < contacts.size ; i++)
                  {
                      if (contacts.retrieve().getEmail().compareTo(email1) == 0)
                      {
                          System.out.println("Contacts found!");
                          System.out.println(contacts.retrieve());
                      }
                      contacts.findNext();
                  }
			  }
             else if(searchChoice == 4) { //Search by Address
            	 System.out.println("Enter the contact's Address:");
				  String address1 = input.nextLine();
				  for (int i = 0; i < contacts.size ; i++)
                  {
                      if (contacts.retrieve().getAddress().compareTo(address1) == 0)
                      {
                          System.out.println("Contacts found!");
                          System.out.println(contacts.retrieve());
                      }
                      contacts.findNext();
                  }
              }
             else if(searchChoice == 5) { //Search by Birthday
            	 System.out.println("Enter the contact's Birthday:");
				  String birthday1 = input.nextLine();
				  for (int i = 0; i < contacts.size ; i++)
                  {
                      if (contacts.retrieve().getBirthday().compareTo(birthday1) == 0)
                      {
                          System.out.println("Contacts found!");
                          System.out.println(contacts.retrieve());
                      }
                      contacts.findNext();
                  }
             }
			  break;
			 
		 case 3: //Delete a contact
			 Contact cont = new Contact();
			 System.out.println("Enter the contact's name:");
			 cont.setName(input.nextLine()); 
			  contacts.remove(cont);
			  if(!cont.cEvent.empty()) {
				  cont.cEvent.findFirst();
				  int cSize = cont.cEvent.size;
			  for ( int i = 1 ; i <= cSize ; i++) {
				  Event eve = cont.cEvent.retrieve();
				  if(events.search(eve)== true) {
					  Event listEvent = events.retrieve();
					 listEvent.removeEventsByContact(cont.getName());
					  if(listEvent.nContacts.empty() == true)
						  events.remove(eve);
					  
				  }
				 cont.cEvent.findNext();
			  } // End for loop
			  System.out.println("Contact deleted successfully!");
			  } //End if 
				  
			 break;
			 
		 case 4: //Add event
			 Contact cont2 = new Contact();
			 System.out.println("Enter event title:");
			 eventTitle = input.nextLine();
			 System.out.println("Enter contact name:");
			 cont2.setName(input.nextLine()); 
			 System.out.println("Enter event date and time (MM/DD/YYYY HH:MM):");
			  dateTime = input.nextLine();
			  date = dateTime.substring(0,10);
			  time = dateTime.substring(10);
			 System.out.println("Enter event location:");
			  location = input.nextLine();
			  
			 if(!contacts.empty() && !events.empty()) {
			   if(contacts.search(cont2)== true) {
			    Event event = new Event(eventTitle, date, time ,location, cont2.getName());
			    cont2 = contacts.retrieve();
			   if(cont2.addEvent(event) == true) { //it wasn't added before
				  contacts.update(cont2);
				  if(events.search(event)==true) {
				     Event event2 = events.retrieve();
					  if((event2.getDate().compareTo(event.getDate())==0) && (event2.getLocation().compareTo(event.getLocation())==0) && (event2.getTime().compareTo(event.getTime())==0)) { 
					    event2.nContacts.add(cont2.getName());
					    events.update(event2);
					  }
					   else {
						  event.nContacts.add(cont2.getName());
						  events.add(event2);
					  }
						  }    
				  }
			    } //3rd if
			    
			 } else  //Outer if
				  System.out.println("Contact wasn't added before");
			 
			   break;
			  
		 case 5: //print event details
			 System.out.println("Enter search criteria:\n 1.contact name \n 2.Event title"); 
			 System.out.print("Enter your choice:");
			 searchChoice = input.nextInt();
			 if(searchChoice == 1) {
				 Contact cont3 = new Contact();
				 System.out.print("\nEnter contact name:");
				 cont3.setName(input.nextLine());
				if(contacts.search(cont3) == true) {
					System.out.println("Contact found!");
					cont3 = contacts.retrieve();
					cont3.cEvent.findFirst();
					int cSize2 = cont3.cEvent.size;
					for(int i = 1 ; i <= cSize2 ; i++) {
						Event eve = cont3.cEvent.retrieve();
						if(events.search(eve )== true)
							System.out.println(events.retrieve());
						cont3.cEvent.findNext();
						}
				}else
					System.out.println("Contact not found!");
				
			 }else if(searchChoice == 2) {
				 Event title = new Event();
				 System.out.print("\nEnter the event title:");
				  title.setTitle(input.nextLine());
				  if(events.search(title) == true) {
					  System.out.println("Event found!");
					  System.out.println(events.retrieve());
				  }else
					  System.out.println("Event not found!");	
				  } break;
				 
		 case 6: //Print contacts by first name
			 System.out.println("Enter the first name:");
			  name = input.nextLine();
			   if(contacts.searchByName(name) == true)
				   System.out.println("Contacts found!");
			   else
			       System.out.println("Contacts not found!"); 
			   break;
			  
		 case 7: //print all events alphabetically
			 if(!events.empty()) {
				 int i  = 1;
				 events.findFirst();
				 while(i++ <= events.size) {
					 System.out.println(i+". "+events.retrieve().getTitle());
					 events.findNext();
				 } 
			 }else
				 System.out.println("There are no events!");
			 
			 
		 case 8: // if user wants to exit
			 flag = false; //to break the loop
			 System.out.println("Goodbye!");
		 } // End switch
		// }catch(InputMismatchException e) {
			// System.out.println("Please enter a number!");
			// input.nextLine();
		// }
		}// end while loop 
    	}
	
	

}
