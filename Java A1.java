
import java.util.*;

//CHANGE THE CLASS MODIFIER AS REQUIRED
public abstract class HotelRoom{
    protected String hotelName;
    protected int numberOfSqFeet;
    
    HotelRoom(){}

    HotelRoom(String hotelName,int numberOfSqFeet)
    {
        this.hotelName=hotelName;
        this.numberOfSqFeet=numberOfSqFeet;
    } 
    
    public abstract int calculateTariff(); 
    
    public String getHotelName() {
        return hotelName;
    }
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
    public int getNumberOfSqFeet() {
        return numberOfSqFeet;
    }
    public void setNumberOfSqFeet(int numberOfSqFeet) {
        this.numberOfSqFeet = numberOfSqFeet;
    }
}   
---------------------------------------------------------------
import java.util.*;

class DeluxeRoom extends HotelRoom
{
    private int ratePerSqFeet = 10;
    private String hasTV = null;
    
    public String getHasTV() {
        return hasTV;
    }
    public void setHasTV(String hasTV) {
        this.hasTV = hasTV;
    }
    
    DeluxeRoom(String hotelName,int numberOfSqFeet, String hasTV)
    {
        super(hotelName, numberOfSqFeet);
        this.hasTV = hasTV;
    }
    public int calculateTariff()
    {
        if(hasTV.equals("yes")) {
            ratePerSqFeet = ratePerSqFeet+2;
        }
        return numberOfSqFeet *ratePerSqFeet;
       
    }
}
---------------------------------------------------------------
import java.util.*;

class DeluxeACRoom extends HotelRoom
{
    private int ratePerSqFeet =     12;
    private String hasAC =null;
    
    public String getHasAC() {
        return hasAC;
    }
    public void setHasAC(String hasAC) {
        this.hasAC = hasAC;
    }
    
    DeluxeACRoom(String hotelName,int numberOfSqFeet,String hasAC)
    {
        super(hotelName, numberOfSqFeet);
        this.hasAC = hasAC;
    }
    public int calculateTariff()
    {
        if(hasAC.equals("yes")) {
            ratePerSqFeet += 2;
        }
        return numberOfSqFeet*ratePerSqFeet;
    }
}
---------------------------------------------------------------
import java.util.*;

class SuiteACRoom extends HotelRoom
{
    private int ratePerSqFeet = 15;
    private String hasWifi =null;
    
    public String getHasWifi() {
        return hasWifi;
    }
    public void setHasWifi(String hasWifi) {
        this.hasWifi = hasWifi;
    }
    
    SuiteACRoom(String hotelName,int numberOfSqFeet,String hasWifi)
    {
       super(hotelName, numberOfSqFeet);
        this.hasWifi= hasWifi;
    }
    public int calculateTariff()
    {
        if(hasWifi.equals("yes")) {
            ratePerSqFeet += 2;
        }
        return numberOfSqFeet*ratePerSqFeet;
    }
}
---------------------------------------------------------------
import java.io.*;
import java.util.*;

public class Main {  
    
    public static void main(String args[]) throws IOException {        
        System.out.println("Hotel Tariff Calculator");        
        System.out.println("1. Deluxe Room");
        System.out.println("2. Deluxe AC Room");
        System.out.println("3. Suite AC Room");
        System.out.println("Select Room Type:");
        HotelRoom room = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int option = Integer.parseInt(br.readLine());
        if(option==1)
        {
            System.out.println("Hotel Name:");
            String hname = br.readLine();
            System.out.println("Room Square Feet Area:");
            int area = Integer.parseInt(br.readLine());
            System.out.println("Room has TV (yes/no):");
            String hast = br.readLine();
            room = new DeluxeRoom(hname, area, hast);
            System.out.println("Room Tariff per day is:" +room.calculateTariff());
        }
        else if(option == 2) {
            System.out.println("Hotel Name:");
            String hname = br.readLine();
            System.out.println("Room Square Feet Area:");
            int area = Integer.parseInt(br.readLine());
            System.out.println("Room has AC (yes/no):");
            String  hast = br.readLine();
            room = new DeluxeACRoom(hname, area, hast);
            System.out.println("Room Tariff per day is:"+room.calculateTariff());
         }
        else if(option == 3) {
            System.out.println("Hotel Name:");
            String hname = br.readLine();
            System.out.println("Room Square Feet Area:");
            int area = Integer.parseInt(br.readLine());
            System.out.println("Room has Wifi (yes/no):");
            String  hast = br.readLine(); 
            room  = new SuiteACRoom(hname, area, hast );
            System.out.println("Room Tariff per day is:" +room.calculateTariff());

            //Read the hotel details
            //Read the hasWifi 
            //Create an object and call the calculateTariff method to display SuiteACRoom cost details
        }else {
            System.out.println("Invalid Option");
        }
    }
}


---------------------------------------------------------------
