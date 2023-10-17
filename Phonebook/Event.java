/*This class will represent events or appointment that can be scheduled with a contact. 
 * It should have fields for the event title, date and time, location, and the contact involved in this event.*/



import java.util.List;

public class Event implements Comparable<Event> {
    private String title,date,time,location;
    
     LinkedList<String> nContacts; //Linked list to store contacts names
  
    Event(){
    	
    }
    
    public Event(String titleP, String dateP, String timeP, String locationP, String contactP) {
        title = titleP;
        date = dateP;
        time = timeP;
        location = locationP;
        nContacts = new LinkedList<String> ();
        nContacts.add(contactP);
        }
    
    
    public boolean removeEventsByContact(String contact) {
  
    	String name = nContacts.remove(contact);
        if ( name != null)
            return true; 
        return false;
        }
    
    public boolean addContact (String contact)
    {
        return nContacts.add(contact);
    }


    public void setTitle(String title) {
		this.title = title;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setLocation(String location) {
		this.location = location;
	}


    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }
    public String getTime() {
    	return time;
    }

    public String getLocation() {
        return location;
    }

	public int compareTo(Event other) {
		if(this.title.compareTo(other.title) == 0)
			  return 0; //They are equal 
			return 1; 
	} 

}
