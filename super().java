import java.util.*;
public class StageEvent extends Event{
	int noOfSeats;
	StageEvent(){

	}
	StageEvent(String name, String detail, String type, String ownerName, Double costPerDay, int noOfSeats){
		 setName(name);
    	 setDetail( detail);
    	 setType( type);
    	 setOwnerName( ownerName);
    	 setCostPerDay( costPerDay) ;
		this.noOfSeats = noOfSeats;
	}
	public double calculateGST(Date d1, Date d2) {
		return getDifferenceDays(d1, d2) * getCostPerDay()*0.15 ;
	}
}
-------------------
import java.util.*;
import java.util.concurrent.*;

public class Event {
	String name, detail, type, ownerName;
	Double costPerDay;
	
	void setName(String name) {this.name = name;}
    void setDetail(String detail) {this.detail = detail;}
    void setType(String type) {this.type = type;}
    void setOwnerName(String ownerName) {this.ownerName = ownerName;}
    void setCostPerDay(Double costPerDay) {this.costPerDay = costPerDay;}
    
    String getName() {return this.name;}
    String getDetail() {return this.detail;}
    String getType() {return this.type;}
    String getOwnerName() {return this.ownerName;}
    Double getCostPerDay() {return this.costPerDay;}

    public static long getDifferenceDays(Date d1, Date d2) {
        long diff = d2.getTime() - d1.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
	
}

------------------
import java.util.*;
import java.text.*;
public class Main {
    public static void main(String args[]) throws Exception {
    	Scanner sc = new Scanner(System.in);
        Date startDate,endDate;
        Double gst = 0.0;
        System.out.print("Enter your choice:\n1.Exhibition event\n2.Stage event\n");
        int ch = sc.nextInt();
        SimpleDateFormat sd=new SimpleDateFormat("dd-MM-yyyy"); 
        String[] details;
        sc.nextLine();
        switch(ch) {
            case 1:
                System.out.println("Enter the details of exhibition:");
                details = sc.nextLine().split(",");
                Exhibition ex = new Exhibition(details[0],details[1],details[2],details[3],Double.parseDouble(details[4]),Integer.parseInt(details[5]));
                System.out.println("Enter the starting date of the event:");
                startDate = sd.parse(sc.next());
                System.out.println("Enter the ending date of the event:");
                endDate = sd.parse(sc.next());
                gst = ex.calculateGST(startDate, endDate);
                break;
            case 2:
                System.out.println("Enter the details of stage event:");
                details = sc.nextLine().split(",");
                StageEvent se = new StageEvent(details[0],details[1],details[2],details[3],Double.parseDouble(details[4]),Integer.parseInt(details[5]));
                System.out.println("Enter the starting date of the event:");
                startDate = sd.parse(sc.next());
                System.out.println("Enter the ending date of the event:");
                endDate = sd.parse(sc.next());
                gst = se.calculateGST(startDate, endDate);
                break;
            default:
                System.out.println("Wrong Choice!");
                System.exit(0);
        }
        
        System.out.println("The GST to be paid is Rs."+gst);
        
        sc.close();
	}
    
}
----------------------
import java.util.*;
public class Exhibition extends Event{
	int noOfStall;
	Exhibition(){

	}
	Exhibition(String name, String detail, String type, String ownerName, Double costPerDay, int noOfStall){
		 setName(name);
    	 setDetail( detail);
    	 setType( type);
    	 setOwnerName( ownerName);
    	 setCostPerDay( costPerDay) ;
		this.noOfStall = noOfStall;
	}
	public double calculateGST(Date d1, Date d2) {
		return getDifferenceDays(d1, d2)  * getCostPerDay()*0.05;
	}
}
