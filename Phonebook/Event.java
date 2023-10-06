/*This class will represent events or appointment that can be scheduled with a contact. 
 * It should have fields for the event title, date and time, location, and the contact involved in this event.*/
public class Event {
 private String title;
    private String date; 
    private String time;
    private String location;
    private Contact contact; 

    public Event(String t, String d, String time, String l, Contact contact) {
        title = t;
        date = d;
        location = l;
        this.time=time;
        this.contact = contact;}
    
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

    public Contact getContact() {
        return contact;
    } 

}
