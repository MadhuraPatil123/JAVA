/*
NumberFormatException
NumberFormatException
 
Let’s learn a common type of exception which you would have come across already. When you use BufferedReader to read input you need to parse String it into various datatype like Integer, Double. For example, If you try to parse a String ("abc") into Integer, it throws NumberFormatException. So let's try to handle this NumberFormat exception.

In our application, while acquiring attributes for classes like ItemType, this exception may occur. So try to handle it in this program.

Create a class ItemType with the following attribute,
Attributes	Data type
name	String
deposit	Double
costPerDay	Double

Add appropriate getter/setter, default and parameterized constructor. public ItemType(String name, Double deposit, Double costPerDay).

Override toString() and print the details as in the specified format.

Create a Main class and test the above class. Display "The details of the item type are:" in the main method. Handle the NumberFormatException in the Main Class.

Input and Output format:
Refer to sample Input and Output for formatting specifications.

[All Texts in bold corresponds to the input and rest are output]

Sample Input and Output 1:

Enter the Item type details:
Enter the name:
Electronics
Enter the deposit:
1000
Enter the cost per day:
100
The details of the item type are:
Name:Electronics
Deposit:1000.0
Cost Per Day:100.0

Sample Input and Output 2:

Enter the Item type details:
Enter the name:
Electronics
Enter the deposit:
One thousand
java.lang.NumberFormatException: For input string: "One thousand"


Problem Requirements:
Java
Keyword	Min Count	Max Count
catch	1	-
Keyword	Min Count	Max Count
NumberFormatException	1	-
Keyword	Min Count	Max Count
try	1	-

*/


public class ItemType {
//Fill your code here	
    String name;
    double deposit;
    double costPerDay;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getDeposit() {
        return deposit;
    }
    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }
    public double getCostPerDay() {
        return costPerDay;
    }
    public void setCostPerDay(double costPerDay) {
        this.costPerDay = costPerDay;
    }
    ItemType(){

    }
 
    public ItemType(String name, Double deposit, Double costPerDay) {
        this. name = name;
        this. deposit = deposit;    
        this. costPerDay = costPerDay;
        }

         public String toString() {
            return "Name:"+name+"\nDeposit:"+deposit+"\nCost Per Day:"+costPerDay;
        }

}



import java.io.*;

public class Main {
	public static void main(String args[]) throws  NumberFormatException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Item type details:");
		String depost = "";
		try {
			System.out.println("Enter the name:");
			String name = br.readLine();
			System.out.println("Enter the deposit:");
			depost = br.readLine();
			double deposit = Double.parseDouble(depost);
			System.out.println("Enter the cost per day:");
			double cost = Double.parseDouble(br.readLine());
			ItemType it = new ItemType(name, deposit, cost);
			System.out.println("The details of the item type are:");
			System.out.println(it);
		}
		catch (NumberFormatException e){
			System.out.println( e);
		}
		catch(IOException e) {
			//e.printStackTrace();
			System.out.println("Error reading input. Please try again.");
		}
		
        //Fill your code here
	}
}
