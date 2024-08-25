/*
Various date formats
Date Formats

So far, we have got the dates from the user in MM-dd-yyyy format. but in some reports, we want them in some other formats. So write a program to convert the dates gotten from the user into different formats.

Create a driver class named Main and do all manipulation in the main method.

Input Format:
The first line input corresponds to the date that is to be processed in various date formats.
Refer sample input for formatting specifications.

Output Format:
The output consists of date in the format of ("EEE, MMM d, yy" , "dd.MM.yyyy" , "dd/MM/yyyy").
Refer sample output for formatting specifications.

Sample Input/Output-1:
Enter the date to be formatted:(MM-dd-yyyy)
10-20-1996
Date Format with EEE, MMM d, yy : Sun, Oct 20, 96
Date Format with dd.MM.yyyy : 20.10.1996
Date Format with dd dd/MM/yyyy : 20/10/1996



*/





import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;


public class Main {
	public static void main(String []args) {
		//fill your code here
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("EEE, MMM d, yy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd.MM.yyyy");
		SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.println("Enter the date to be formatted:(MM-dd-yyyy)");
			String da = sc.next();
			Date date = new SimpleDateFormat("MM-dd-yyyy").parse(da);
			System.out.println("Date Format with EEE, MMM d, yy :"+sdf1.format(date));
			System.out.println("Date Format with dd.MM.yyyy :"+sdf2.format(date));
			System.out.println("Date Format with dd dd/MM/yyyy :"+sdf3.format(date));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
