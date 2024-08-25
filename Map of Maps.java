/*
Map of Maps
 

In our application, we gonna implement Map of Map. The value of the map is gonna be another map. This can be helpful in making counts of linked variables. We have the Address class. The address belongs to a city and state. So if we separate addresses based on each state and city maps of maps will be useful. The first map will have the state as key with a map as value. The inner map will have the city as key and count of addresses in that city as value.

Map<String,Map<String,Integer>> is the general format and Map<state,Map<city,count>> is the format for this problem.

Create a driver class Main and using the main method get the details, create a map, and display the details.

Input Format:
The first line has the number of address n.
The next n lines have the addresses in CSV format. (area,city,state, pincode)
Refer to the sample Input and Output for the formatting specifications.

Output Format:
Output has State name in the first line and each city name along with the count of address in the city in the next lines. A new line between 2 different states.
The order of output must be in lexicographical order for both state and city.

[All Texts in bold corresponds to the input and rest are output]
Sample Input/Output 1:

Enter the number of address:
3
Enter the address:
Annanagar,Madurai,Tamil Nadu,666666
Enter the address:
Gandhipuram,Coimbatore,Tamil Nadu,123456
Enter the address:
KKnagar,Madurai,Tamil Nadu,678901
Number of entries in city/state wise:

State:Tamil Nadu
City:Coimbatore Count:1
City:Madurai Count:2

Sample Input/Output 2:

Enter the number of address:
5
Enter the address:
Annanagar,Madurai,Tamil Nadu,666666
Enter the address:
Gandhipuram,Coimbatore,Tamil Nadu,123456
Enter the address:
KKnagar,Madurai,Tamil Nadu,678901
Enter the address:
Marathahalli,Banglore,Karnataka,123456
Enter the address:
Electronic City,Banglore,Karnataka,123457
Number of entries in city/state wise:

State:Karnataka
City:Banglore Count:2

State:Tamil Nadu
City:Coimbatore Count:1
City:Madurai Count:2

 
*/

// Main.java

import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of address:");
        int n = sc.nextInt();
	  sc.nextLine();
        
        Map<String,Map<String,Integer>> myMap = new TreeMap<>();
        List<Address> addressList = new ArrayList<Address>();
        
        for(int i=1;i<=n;i++) {
            System.out.println("Enter the address:");
            String[] details = (sc.nextLine()).split(",");
            Address address = new Address(details[0], details[1], details[2], Integer.parseInt(details[3]));
            addressList.add(address);
        }
        
        // Creating Map<Sate, Map<City,Count>>
        for (Address address : addressList) {
            String state = address.getState();
            String city = address.getCity();
            
            if(myMap.containsKey(state)) {
                Map<String,Integer> subMap = myMap.get(state);
                if(subMap.containsKey(city))
                    subMap.replace(city, subMap.get(city)+1);
                else
                    subMap.put(city,1);
            } else {
                Map<String,Integer> subMap = new TreeMap<>();
                subMap.put(city,1);
                myMap.put(state,subMap);
            }
        }
        
        System.out.println("Number of entries in city/state wise:");
        for(String state : myMap.keySet()) {
            System.out.println("\nState:"+state);
            Map<String,Integer> subMap = myMap.get(state);
            for(String city : subMap.keySet()) {
                System.out.println("City:"+city+" Count:"+subMap.get(city));
            }
        }
        
        sc.close();
	}
    

}


// Address.java ( ! Create this file )

public class Address {
    private String area,city,state;
    private Integer pincode;
    
    Address() {}
    Address(String area, String city, String state, Integer pincode) {
        this.area = area;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }
    
    void setArea(String area) { this.area = area; }
    void setCity(String city) { this.city = city; }
    void setState(String State) { this.state = state; }
    void setPincode(Integer pincode) { this.pincode = pincode; }
    String getArea() { return this.area; }
    String getCity() { return this.city; }
    String getState() { return this.state; }
    Integer getPincode() { return this.pincode; }

}
