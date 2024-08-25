/*
Bank Account
Bank Account
Inheritance in Java is same as that of inheritance in real Life. A class which inherits another class obtains all the latter's attributes and methods. The former is called Child class whilst the latter is called Parent class. This phenomenon would be very promising in applications dealing with multiple classes that are constituted by similar or more likely same attributes. You 'll get to know the importance of inheritance from the following problem. All type of accounts in a bank have common attributes which can be inherited from an Account class.
 
The class Account has been created with the following protected attributes,

Attributes	Datatype
accName	String
accNo	String
bankName	String
Include appropriate getters and setters.


Include the following protected methods.

Method	Description
public void display()	This protected method displays the account details
 

Create a class CurrentAccount with following private attributes which extends Account class

Attributes	Datatype
tinNumber	String
Create default constructor and a parameterized constructor with arguments in order CurrentAccount(String accName,String accNo,String bankName,String tinNumber).
Include appropriate getters and setters.


Include the following public methods.

Method	Description
public void display()	This method calls the super class display().
This public method displays the TIN number.
Call this method with the reference of base class.
 

Create a class SavingsAccount with following private attributes which extends Account class

Attributes	Datatype
orgName	String
Create default constructor and a parameterized constructor with arguments in order SavingsAccount(String accName,String accNo,String bankName,String orgName).
Include appropriate getters and setters.


Include the following public methods.

Method	Description
public void display()	This method calls the super class display().
This public method displays the Organisation Name.
Call this method with the reference of base class.
 

Create a driver class named Main to test the above class.

Note:
  Strictly adhere to the Object-Oriented Specifications given in the problem statement.All class names, attribute names and method names should be the same as specified in the problem statement.

Input Format:
The first input corresponds to choose current or savings account
The next line consists of account name,account number,bank name,org name or tin number (according to chosen account type)

Output Format
The output consists of account details  and TIN number or Organisation name
Refer sample output for formatting specifications.

Sample Input/Output-1:
Choose Account Type
1.Savings Account
2.Current Account
1
Enter Account details in comma separated(Account Name,Account Number,Bank Name,Organisation Name)
Morsh,033808020000879,Baroda,Amphisoft
Account Name:Morsh
Account Number:033808020000879
Bank Name:Baroda
Organisation Name:Amphisoft

Sample Input/Output-2:
Choose Account Type
1.Savings Account
2.Current Account
2
Enter Account details in comma separated(Account Name,Account Number,Bank Name,TIN Number)
Krish,131231451,ICICI,798902
Account Name:Krish
Account Number:131231451
Bank Name:ICICI
TIN Number:798902
*/

public class SavingsAccount extends Account{
	String orgName;

	SavingsAccount() {

	}
	SavingsAccount(String aname, String ano, String bname, String orgName){
		super.setAccName(aname);
		super.setAccNo(ano);
		super.setBankName(bname);
		this.orgName = orgName;
	}
	public void display() {
		super.display();
		System.out.println("Organisation Name:"+orgName);
	}
}



public class Account {
	String accName, accNo, bankName;

	public void setAccName(String accName) {
		this.accName = accName;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public void display() {
		System.out.println("Account Name:"+accName);
		System.out.println("Account Number:"+accNo);
		System.out.println("Bank Name:"+bankName);
	}
}


public class CurrentAccount extends Account{
	String tinNumber;

	CurrentAccount(){

	}
	CurrentAccount(String aname, String ano, String bname, String tinNumber ){
		super.setAccNo(ano);
		super.setAccName(aname);
		super.setBankName(bname);
		this.tinNumber = tinNumber;
	}
	public void display() {
		super.display();
		System.out.println("TIN Number:"+tinNumber);
	}

}


import java.util.*;
public class Main {
	public static void main(String[] args){
		System.out.println("Choose Account Type\n1.Savings Account\n2.Current Account");
		Scanner sc = new Scanner(System.in);
		int ch =sc.nextInt();
		Account a = null;
		if(ch == 1){
			sc.nextLine();
			System.out.println("Enter Account details in comma separated(Account Name,Account Number,Bank Name,Organisation Name)");
			String [] dets = sc.nextLine().split(",");
			a= new SavingsAccount(dets[0],dets[1],dets[2],dets[3]);
			a.display();
		}
		else if(ch == 2) {
		System.out.println("Enter Account details in comma separated(Account Name,Account Number,Bank Name,TIN Number)");
		sc.nextLine();
		String[] det = sc.nextLine().split(",");
		a= new CurrentAccount(det[0],det[1],det[2],det[3]);
		a.display();
	}
}
}


