/*
File handling introduction
File handling introduction

File handling is an important technique that you need to accustom to it. File reading and writing are types of handling. Let's practice file reading for now. There is a Class called FileReader that will help us with file reading. You'll be provided with a file that contains the data in CSV format. Using FileReader, read the file and parse the data contained in it to below specified format.

Provided "input.csv" which have User details. Read all the user information stored in CSV format and create a user object by parsing the line. Add all the user objects to the ArrayList. At last, display the user list.

Strictly adhere to the Object-Oriented specifications given in the problem statement. All class names, attribute names and method names should be the same as specified in the problem statement.

Create a class called User with following private attributes

Attributes	Datatype
name	String
email	String
username	String
password	String

Include getters and setters.
Create a default constructor and parameterized constructor.
Format for the parameterized constructor is User(String name, String email, String username, String password)

Create UserBO class with following methods

Method 	Description
public List<User> readFromFile(BufferedReader br)	This method accepts the BufferedReader object as input and parses the data
in the file to User objects and adds them to a list. Finally, it returns the list of User objects.
public void display(List<User> list)	This method accepts a list of User objects and displays the user details by iterating the list.
Use "%-15s %-20s %-15s %s\n" to print the details.

Create a driver class called Main. If the List of Users is empty print "The list is empty" in the main method. Else display the user detail by calling the display method.

Note : Use BufferedReader br=new BufferedReader(new FileReader("input.csv")) for file reading.

Input format:
Read the input from the "input.csv" file which contains the user details.

Output format:
Use "%-15s %-20s %-15s %s\n" to print statements for the heading of the details in the Main method.

Sample Input: (input.csv)
 




Sample Output :

Name            Email                Username        Password
Ram             ram@gmail.com        ram             ram123
krish           krish@gmail.com     krish           abc


*/




Ram,ram@gmail.com,ram,ram123
krish,krish@gmail.com,krish,abc


  import java.io.*;
import java.util.*;


public class UserBO {
	public List<User> readFromFile(BufferedReader br) throws IOException {
		List<User> list = new ArrayList<User>();
		String st;
		while((st = br.readLine()) != null) {
			String [] details = st.split(",");
			User user = new User(details[0], details[1], details[2], details[3]);
			list.add(user);
		}
		return list;
	}
	public void display(List<User> list){
		for(User user: list) {
			System.out.println(user);
		}
		
	}
}


import java.io.*;
import java.util.List;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException{
		UserBO userBO = new UserBO();
		List<User> users = userBO.readFromFile(new BufferedReader(new FileReader("input.csv")));
	if(users.size() > 0) {
			System.out.format("%-15s %-20s %-15s %s\n" ,"Name","Email","Username","Password");
			userBO.display(users);
		
		}
		else
			System.out.println("The list is empty");
	}
}





public class User{
	private String name;
	private String email;
	private String username;
	private String password;
	public User() {
		
	}
	public User(String name, String email, String username, String password) {
		super();
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return String.format("%-15s %-20s %-15s %s\n",this.name,this.email,this.username,this.password);
	}
}



