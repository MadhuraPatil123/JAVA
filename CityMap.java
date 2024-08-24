/* City map
 

Let's spice up things by creating a Multimap. Map<City,List<Address>> with City name as key and List of address that corresponds to the City as value. Given list of Addresses as input create a map with the above specification. Obtain a city name as input from the user and display the addresses with the city name as that of the given city by fetching the list of addresses from the map.

Create a class called Address with the following private attributes.

Attributes	Datatype
addressLine1	String
addressLine2	String
city	String
state	String
pincode	Integer
 

Include appropriate getters and setters.
Include default and parameterized constructor for the class.
Format for the Parameterized Constructor Address(String addressLine1, String addressLine2, String city,String state, Integer pincode)

Create a driver class called Main. In the Main method, obtain address details from the input and create the map of above specification. Obtain a city as a search term and display the address that has the given city. If no such address is present, Print "Searched city not found".

Note: 
[Strictly adhere to the Object-Oriented Specifications given in the problem statement.
All class names, attribute names and method names should be the same as specified in the problem statement.]

Input format:

First line corresponds to number of address details
Next n lines consists of n address details in CSV format
n+1th  line consists of city input

Output format:

Address details are displayed in tabular format.(Use "%-15s %-15s %-15s %-15s %s\n" for formatting Address details.)

[All text in bold corresponds to the input and rest corresponds to the output]
Sample Input/Output:

Enter the number of address
4
Enter the address 1 detail
22nd lane,RR nagar,Chennai,Tamil nadu,600028
Enter the address 2 detail
3rd street,KRK nagar,Visak,Andhrapradesh,745601
Enter the address 3 detail
1/45 8th street,KK nagar,Chennai,Tamil nadu,600021
Enter the address 4 detail
5/15 7th lane,RK nagar,Madurai,Tamil nadu,625001
Enter the city to be searched
Chennai
Line 1          Line 2          City            State           Pincode
22nd lane       RRnagar        Chennai         Tamilnadu      600028
1/45 8th street KKnagar        Chennai         Tamilnadu      600021

 */

//Main.java

 import java.util.*;
import java.util.Map;

public class Main {

	public static void main(String[] args){
		//Your code here
		Scanner sc = new Scanner(System.in);
		Map<String,List<Address>>  cityMap = new HashMap<>()  ;
		System.out.println("Enter the number of address");
		int n = Integer.parseInt(sc.next());
		sc.nextLine();
		List <Address> address = new ArrayList<>();
		for(int i = 1; i <= n; i++) {
			System.out.println("Enter the address "+i+" detail");
			String[] arr = sc.nextLine().split(",");
			Address a  = new Address(arr[0], arr[1], arr[2], arr[3], Integer.parseInt(arr[4]));
			address.add(a);
		}
		System.out.println("Enter the city to be searched");
		String search = sc.next();
		for(Address a :  address) {
			String city = a.getCity();
			if(cityMap.get(city) == null)
				cityMap.put(city,  new ArrayList<Address>());
			cityMap.get(city).add(a);
		}
		if(cityMap.containsKey(search)) {
            List<Address> found = cityMap.get(search);
            System.out.print(String.format("%-15s %-15s %-15s %-15s %s\n","Line 1","Line 2","City","State","Pincode"));
            for (Address a : found) {
                System.out.print(a);
            }
        } else {
            System.out.println("Searched city not found");
        }
	}

}
//Address.java

import java.util.*;

public class Address {
    //your code here
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private Integer pincode;

    Address() {}
    Address(String addressLine1, String addressLine2, String city,String state, Integer pincode) {
        this.addressLine1 =addressLine1;
        this.addressLine2 =addressLine2;
        this.city =city;
        this.state =state;
        this.pincode =pincode;
    }
    public String getAddressLine1() {
        return addressLine1;
    }
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 =addressLine1;
    }
    public String getAddressLine2() {
        return addressLine2;
    }
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 =addressLine2;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city =city;
    }
    public String getState() {
        return state;
    }
    public  void setState(String state) {
        this.state =state;
    }
    public Integer getPincode() {
        return pincode;
    }
    public void setPincode(Integer pincode) {
        this.pincode =pincode;
    }
     @Override
    public String toString() {
        return String.format("%-15s %-15s %-15s %-15s %d", addressLine1, addressLine2, city, state, pincode);
    }

}
