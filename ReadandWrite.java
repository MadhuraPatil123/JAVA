/*
Read and Write
In our application, we are gonna read the contents of a file and write it into another file with some conditions. There can be many events for the same organization or owner. But we want only one event for every owner available. So we are gonna read the event details from the file "input.txt" and then write the event details into "output.txt" but after removal of duplicate entries.

Strictly adhere to the Object-Oriented specifications given in the problem statement. All class names, attribute names and method names should be the same as specified in the problem statement.

Create a class Event with the following private attributes

Attributes	Datatype
eventName	String
attendeesCount	Integer
ownerName	String
Include appropriate getters and setters
Create default constructor and a parameterized constructor with arguments in order Event(String eventName, Integer attendeesCount, String ownerName).

Create a class EventBO to access the above class. Include the following public methods.

Method	Description
public List<Event> readFromFile(BufferedReader br)	This method accepts the BufferedReader object as input and parses the data in the file to Event objects
and then adds them to a list. Finally, it returns the list of Event objects.
void writeFile(List<Event> eventList,FileWriter fr)	This method takes event list and file writer as the arguments and writes into "output.txt" with
the removal of duplicate event details (i.e) an event having the same owner name.
 

Create a driver class named Main which reads data from console and to test the above class.

Input:
Read the contents[event details] from the file "input.txt".

Output:
Write the contents[event details] with the removal of duplicate events into the "output.txt".

Sample Input: (input.txt)




Sample Output: (output.txt)


*/

//Event.java
public class Event {

	private String eventName;
	private Integer attendeesCount;
	private String ownerName;

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Integer getAttendeesCount() {
		return attendeesCount;
	}

	public void setAttendeesCount(Integer attendeesCount) {
		this.attendeesCount = attendeesCount;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public Event(String eventName, Integer attendeesCount, String ownerName) {
		super();
		this.eventName = eventName;
		this.attendeesCount = attendeesCount;
		this.ownerName = ownerName;
	}

	@Override
	public String toString() {
		return String.format("%s,%s,%s\n",eventName, attendeesCount, ownerName);
	}
	@Override
	public boolean equals(Object o) {
		if(o instanceof Event ) {
			Event e = (Event) o;
			return this.ownerName.equals(e.ownerName);
		}
		return false;
		
	}
	 @Override 
	 public int hashCode()
    { return ownerName.hashCode(); }
	
}

// Main.java
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		EventBO ebo = new EventBO();
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		List<Event> list = ebo.readFromFile(br);
		br.close();
		list = removeDuplicates(list);
		FileWriter fr = new FileWriter("output.txt");
		ebo.writeFile(list, fr); 
		fr.close();

	}
	public static List<Event> removeDuplicates(List<Event> events) {
        Set<Event> e = new LinkedHashSet<Event>(events);
        return new ArrayList<Event>(e);
    }
}
//EventBo.java

import java.util.*;
import java.io.*;

public class EventBO {

	public List<Event> readFromFile(BufferedReader br) throws IOException {
		
		List<Event> list = new ArrayList<Event> ();
		String st;
		while((st = br.readLine()) != null) {
			String[] details = st.split(",");
			if(details.length != 3) break;
			Event e = new Event(details[0], Integer.parseInt(details[1]), details[2]);
			list.add(e);
		}
		return list;
	}
	public void writeFile(List<Event> eventList,FileWriter fr) throws IOException {
		for(Event event :  eventList) {
			fr.write(event.toString());
		}
	}
}
