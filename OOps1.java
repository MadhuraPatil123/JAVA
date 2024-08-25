/*
aggregation
Strictly adhere to the Object-Oriented specifications given in the problem statement. All class names, attribute names and method names should be the same as specified in the problem statement.

The class Department has been created with the following attributes,
Attribute	Datatype
departmentName	String
staff	Staff

The class Staff has been created with the following attributes,
Attribute 	Datatype
staffName	String
designation	String

Include the following method in the Department class,
Method 	Description
public displayStaff()	This method displays "staffName is working in the departmentName department as designation".

Create a driver class Main, in the main method get the inputs from user, create the objects and call the methods.

Input and Output format:
Refer to sample Input and Output for formatting specifications.

Sample Input and Output:
[All text in bold corresponds to the input and rest corresponds to the output]

Enter the name of the staff:
Jane
Enter the staff designation:
Associate Professor
Enter the department name:
Physics
Jane is working in the Physics department as Associate Professor
 
*/


public class Department {
    String departmentName;
    Staff staff = new Staff();
    Department(String departmentName, Staff staff ){
        this.departmentName =departmentName;
        this.staff = staff;
    }
    
    public void displayStaff() {
        System.out.println(staff.staffName+" is working in the "+departmentName+" department as "+staff.designation);
    }
}
//Department.java

import java.util.*;

public class Main {
	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name of the staff:");
		String name = sc.nextLine();
		System.out.println("Enter the staff designation:");
		String desi = sc.nextLine();		
		System.out.println("Enter the department name:");
		String dep = sc.nextLine();
		Staff staff = new Staff(name, desi);
		Department d = new Department(dep, staff);
		d.displayStaff();
 
	}
}
public class Staff {
	String staffName;
	String designation;

	Staff() {
		
	}

	Staff(String staffName, String designation) {
		this.staffName =staffName;
		this.designation =designation;
	}
}
