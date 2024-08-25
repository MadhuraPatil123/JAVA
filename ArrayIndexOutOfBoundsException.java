/*
ArrayIndexOutOfBoundsException
ArrayIndexOutOfBoundsException

The next prominent exception which you will see is ArrayIndexOutOfBoundsException. It occurs when the program tries to access the array beyond its size. As we know arrays have fixed size. So when you try to use array beyond its size it throws this exception. Let's try to handle this exception.

Handling this exception will also prove to be good for our application. For example, if there are only 100 seats in the event and the user tries to book the 105th seat, it will throw this exception. So you must handle it to do a specific job.

Create an array of size 100 and assume it as seat array. Get the tickets to be booked from the user and handle any exception that occurs in Main Class. At last display all the tickets booked.

Input and Output format:
The first line of input consists of an integer which corresponds to the number of seats to be booked.
The next n lines of input consist of the integer which corresponds to the seat number.
Refer to sample Input and Output for formatting specifications.

Note: All Texts in bold corresponds to the input and rest are output.

Sample Input and Output 1:

Enter the number of seats to be booked:
5
Enter the seat number 1
23
Enter the seat number 2
42
Enter the seat number 3
65
Enter the seat number 4
81
Enter the seat number 5
100
The seats booked are:
23
42
65
81
100

Sample Input and Output 2:

Enter the number of seats to be booked:
4
Enter the seat number 1
12
Enter the seat number 2
101
java.lang.ArrayIndexOutOfBoundsException: 100
 


Problem Requirements:
Java
Keyword	Min Count	Max Count
catch	-	-
Keyword	Min Count	Max Count
ArrayIndexOutOfBoundsException	1	-
Keyword	Min Count	Max Count
try	1	-

*/


import java.util.*;
public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int [100];
		System.out.println("Enter the number of seats to be booked:");
		int no = sc.nextInt();
		int i, j , a = 0;
		try {
			for( i = 0 ;i < no; i++) {
			System.out.println("Enter the seat number "+ (i+1));
			a = sc.nextInt();
			arr[a-1] = 1;
			}
			System.out.println("The seats booked are:");
			for( j = 0; j < 100 ; j++) {
				if (arr[j] == 1)
					System.out.println(j+1);
				else 
					continue;
			}
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}
		
	}
}
