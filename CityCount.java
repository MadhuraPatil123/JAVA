/*
City Count
City Count

Now we are gonna use threading in a small part of our application. The users can be from any city. So get the user details in the console and count the number of users from each city.

Strictly adhere to the Object-Oriented specifications given in the problem statement. All class names, attribute names and method names should be the same as specified in the problem statement.

Create a class User with the following private attributes
Attributes	Datatype
name	String
mobileNumber	String
city	String
state	String
 
Include appropriate getters and setters
Create Default and Parameterized Constructor as User(String name, String mobileNumber, String city, String state) for the class.

Create a class CityCount extends Thread with the following private attribute,

Attributes	Datatype
city	String
count	Integer
userList	List<User>
Call a thread class for each city and count the number of users in that city.

Create constructor as public CityCount(String city, ArrayList<User> userList) and create appropriate getters and setters.

When creating CityCount object initialize count as zero.
Create a driver class Main and use the main method.

Input and Output format:
Refer to Sample Input and Output for other further details and format of the output.

[All Texts in bold corresponds to the input and rest are output]
Sample Input and Output 1:

Enter the number of users:
5
Enter the details of user 1
John,123456,Banglore,Karnataka
Enter the details of user 2
Jane,23456,Hyderabad,Telungana
Enter the details of user 3
Jim,56789,Chennai,Tamil Nadu
Enter the details of user 4
June,45678,Chennai,Tamil Nadu
Enter the details of user 5
James,13579,Banglore,Karnataka
Enter the number of cities:
3
Enter the name of city 1
Chennai
Enter the name of city 2
Banglore
Enter the name of city 3
Hyderabad
Chennai--2
Banglore--2
Hyderabad--1

*/


import java.util.*;

public class CityCount extends Thread{
	//write your code here
	private String city;
	private Integer count;
	 ArrayList<User> userList = new ArrayList<>();

	public CityCount(String city, ArrayList<User> userList) {
		this.city = city;
		this.count = 0;
		this.userList = userList;
	}
	public String getCity() {
		return  city;
	}
	public Integer getCount() {
		return  count;
	}
	@Override
	public void run() {
		for(User user : userList) {
			if(user.getCity().equals(city))
				count++;
		}
	}
}


import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
		//write your code here
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of users:");
		int n = sc.nextInt();
		sc.nextLine();
		ArrayList<User>list = new ArrayList<>();
		for(int i = 1; i <= n ; i++ ) {
			System.out.println("Enter the details of user "+i);
			String [] arr = sc.nextLine().split(",");
			list.add(new User(arr[0],arr[1],arr[2],arr[3]));
		}	
		System.out.println("Enter the number of cities:");
		int  city = Integer.parseInt(sc.next());
		ArrayList<String> cities = new ArrayList<>(); 
		for(int i = 1; i <= city ; i++ ) {
			System.out.println("Enter the name of city "+i);
			cities.add(sc.next());
		}
		for(String cit : cities) {
			CityCount cc = new CityCount(cit, list);
			cc.start();
			cc.join();
			System.out.println(cc.getCity() +"--"+cc.getCount());
		}
	}
}



public class User {
	//write your code here
	private String name, mobileNumber, city, state;
	
	public void setName(String name) {this.name = name;}
	public void setMB(String  mobileNumber){this.mobileNumber = mobileNumber;}
	public void setCity(String city){this.city = city;}
	public void setState(String state){this.state = state;}

	public String getName() {return name ;}
	public String getMB() {return  mobileNumber;}
	public String getCity() {return  city;}
	public String getState() {return state;}

	User() {

	}
	User(String name, String mobileNumber, String city, String state) {
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.city = city;
		this.state = state;
	}
}
