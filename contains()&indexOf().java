/* Problem

 contains() & indexOf() methods in ArrayList
Write a program to get the hall details and store in the ArrayList and search the hall and display it's position details.

Get hall names in the Main class and store it an ArrayList.

Input format:
The first line of input is an integer which corresponds to the number ‘n’ of halls.
The n lines of input are the string which corresponds to the hall name.
The last line of input is the string which corresponds to the hall name to be searched.

Output format:
The output is the hall position.
It is the position at which the hall is present in the list starting from 0.
If the hall to be searched is not present in the list, then print "[Hall name] hall is not found"
Refer to sample Input and Output for formatting specifications.

[All Texts in bold corresponds to the input and rest are output]
Sample Input and Output 1:

Enter the number of halls:
3
Enter the Hall Name 1
SPK
Enter the Hall Name 2
DFG
Enter the Hall Name 3
TRE
Enter the hall name to be searched:
DFG
DFG hall is found in the list at position 1

Sample Input/Output 2:

Enter the number of halls:
3
Enter the Hall Name 1
SPJ
Enter the Hall Name 2
RWE
Enter the Hall Name 3
HFG
Enter the hall name to be searched:
SPK
SPK hall is not found

*/

import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception{
		//write your code here
		Scanner sc = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<>();
		System.out.println("Enter the number of halls:");
		int n = Integer.parseInt(sc.next());
		for(int i = 1; i<= n; i++) {
			System.out.println("Enter the Hall Name "+i);
			list.add(sc.next());
		}
		System.out.println("Enter the hall name to be searched:");
		String search = sc.next();
		if(list.contains(search))
			System.out.println(search+" hall is found in the list at position "+list.indexOf(search));
		else
			System.out.println(search+" hall is not found");
		
	}
}
