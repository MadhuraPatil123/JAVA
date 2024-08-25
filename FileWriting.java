/* 
File Writing
The file we write can be of several formats. But for now, we are just going to write a CSV text file, in which all the fields are separated by comma delimiter. Use FileWriter and BufferedWriter to write the data to a file.

As a first thing, we are gonna create a file that contains the record of all the users registered. So write a program that can write all the user details from the console into a file "output.csv".

Strictly adhere to the Object-Oriented specifications given in the problem statement. All class names, attribute names and method names should be the same as specified in the problem statement.

Create a class User with the following attributes, 

Attribute	Data type
name	String
mobileNumber	String
username	String
password	String
 
Create a class UserBO with the following methods,

Method	Description
public static void writeFile(ArrayList<User> userList, BufferedWriter bw)	This method gets a list of the user as argument and
writes all the user details in the list into a file

Create a driver class Main and use the main method to get the details from the user.

Input format:
The first line of input consists of an integer that corresponds to the number of users.
The next n line of input consists of user details in  the CSV format (name, mobileNumber, username, password)
Refer to sample Input for other further details.

Output format:
Write the user details in the output.csv file.
Refer to sample Output for other further details.

Sample Input:
[All Texts in bold corresponds to the input and rest are output]

Enter the number of users:
3
Enter the details of user :1
Jane,1234,jane,jane
Enter the details of user :2
John,5678,john,john
Enter the details of user :3
Jill,1357,jill,jill

 

Sample Output: (output.csv)


*/
//USerBo.java
import java.util.*;
import java.io.*;

public class UserBO {

	public static void writeFile(ArrayList<User> userList, BufferedWriter bw) throws Exception {
		
		for(User user : userList) {
			bw.write(user.toString());
		}
	}
}

//Main.java
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws Exception{
		System.out.println("Enter the number of users:");
		Scanner sc = new Scanner(System.in);
		ArrayList<User> users = new ArrayList<User>();
		int n = sc.nextInt();
		sc.nextLine();
		for(int i = 1; i <= n; i++) {
			System.out.println("Enter the details of user :"+i);
			String[] details = sc.nextLine().split(",");
			User user = new User(details[0], details[1], details[2], details[3]);
			users.add(user);
		}
		UserBO ubo = new UserBO();
		
		//FileWriter fwrite = new FileWriter("output.csv");
		BufferedWriter bw= new BufferedWriter(new FileWriter("output.csv")); 
		ubo.writeFile(users, bw);
		bw.close();
	}
}

//User.java
public class User {
	String name,mobileNumber,username,password;
    
    User() {}
    
    User(String name, String mobileNumber, String username, String password) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.username = username;
        this.password = password;
    }
    @Override
    public String toString(){
        return String.format("%s,%s,%s,%s\n",this.name, this.mobileNumber,this.username,this.password);
    }
	
}
