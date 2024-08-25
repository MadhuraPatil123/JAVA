
import java.util.*;

public class SickLeave extends Leave {
    
    String aboutIllness;
	
	public SickLeave() {
		super();
	}

	public SickLeave(Integer employeeId, String date, Integer noOfDays, String aboutIllness) {
		super(employeeId,date,noOfDays);
		this.aboutIllness = aboutIllness;
	}

	public String getAboutIllness() {
		return aboutIllness;
	}

	public void setAboutIllness(String aboutIllness) {
		this.aboutIllness = aboutIllness;
	}

	public void calculateLeave(){
		int totalDays = getAvailablesickleaves() - getNoOfDays();
		System.out.println("Sick Leave : " +getEmployeeId()+","+getDate()+","+aboutIllness+","+getNoOfDays()+","+totalDays+" sick leaves available");
	}
 

}
-------------------------------------------------------------------------

import java.util.*;

public class CasualLeave extends Leave {
    
    String reason;
	
	public CasualLeave() {
		super();
	}

	public CasualLeave(Integer employeeId, String date, Integer noOfDays, String reason) {
		super(employeeId,date,noOfDays);
		this.reason = reason;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public void calculateLeave(){
		int totalDays = getAvailablecasualleaves() - getNoOfDays();
		System.out.println("Casual Leave : " +getEmployeeId()+","+getDate()+","+reason+","+getNoOfDays()+","+totalDays+" casual leaves available");
	}
 

}

-------------------------------------------------------------------------
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args)throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String isContinue=null;
		List<Leave> list = new ArrayList<Leave>();
		do {
			System.out.println("Enter employee details:");
			String details=br.readLine();
			String[] det=details.split(",");
			String type = det[4];
			if(type.equalsIgnoreCase("S")){
				SickLeave sl = new SickLeave(Integer.parseInt(det[0]), det[1],Integer.parseInt(det[2]), det[3]);
				list.add(sl);
			}
			else if(type.equalsIgnoreCase("C")){
				CasualLeave cl = new CasualLeave(Integer.parseInt(det[0]), det[1],Integer.parseInt(det[2]), det[3]);
				list.add(cl);
			}
			System.out.println("Do you want to add another?(Yes/No)");
			isContinue=br.readLine();
		}while(isContinue.equalsIgnoreCase("yes"));
		
		for(Leave l:list)
		{
		  l.calculateLeave();
		}

	}

}


-------------------------------------------------------------------------
import java.util.*;

//CHANGE THE CLASS MODIFIER AS REQUIRED

public abstract class Leave {
    Integer employeeId;
    Integer noOfDays;
    String date;
    Integer availableSickLeaves = 15;
    Integer availableCasualLeaves = 10;
    
    public abstract void calculateLeave();
    public Leave() {

    }
    public Leave(Integer employeeId, String date, Integer noOfDays) {
    	super();
		this.employeeId = employeeId;
		this.noOfDays = noOfDays;
		this.date = date;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public Integer getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(Integer noOfDays) {
		this.noOfDays = noOfDays;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getAvailablesickleaves() {
		return availableSickLeaves;
	}
	public Integer getAvailablecasualleaves() {
		return availableCasualLeaves;
	}
	

}
-------------------------------------------------------------------------
