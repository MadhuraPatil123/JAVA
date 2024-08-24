/*
Email Search
 
In your application let’s dive deep into Set and explore its inbuilt functions. In this problem experiment with containsAll() method. Write a program to search all the email addresses which are given as CSV format.

Create a Main class. Obtain email addresses from the user and add them to a Set. At last, get a String that has multiple email addresses in CSV format. Print "Email addresses are present" if all email addresses are present in the Set, else print "Email addresses are not present".

Input and Output format:
Refer to sample Input and Output for formatting specifications.

Note: All Texts in bold corresponds to the input and rest are output

Sample Input and Output 1:
Enter Email address
Merry@gmail.com
Do you want to Continue?(yes/no)
yes
Enter Email address
Peter@yahoo.com
Do you want to Continue?(yes/no)
yes
Enter Email address
Christian@hotmail.com
Do you want to Continue?(yes/no)
yes
Enter Email address
Merry@gmail.com
Do you want to Continue?(yes/no)
no
Enter the email addresses to be searched separated by comma
Merry@gmail.com,Peter@yahoo.com
Email addresses are present


Sample Input and Output 2:
Enter Email address
Manikandan@yahoo.com
Do you want to Continue?(yes/no)
yes
Enter Email address
bala@google.co.in
Do you want to Continue?(yes/no)
no
Enter the email addresses to be searched separated by comma
bala@google.co.in,jeryy@gmail.com
Email addresses are not present
*/

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// fill the code here
		Scanner sc = new Scanner(System.in);
        Set<String> emails = new TreeSet<>();
		 String ch;
		do{
			System.out.println("Enter Email address");
			emails.add(sc.nextLine());
			System.out.println("Do you want to Continue?(yes/no)");
			ch = sc.nextLine();
		}while(ch.equals("yes"));
	
		System.out.println("Enter the email addresses to be searched separated by comma");
		String[] search = (sc.nextLine()).split(",");
		List<String> searchList = new ArrayList<String>();
		Collections.addAll(searchList, search);
		if(emails.containsAll(searchList)){
			System.out.println("Email addresses are present");
		}
		else
			System.out.println("Email addresses are not present");
	}
	
}

