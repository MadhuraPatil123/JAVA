/*
toString() and getClass() - Illustration
toString() and getClass() - Illustration

 

The toString() method returns a textual representation of an object. A basic implementation is already included in java.lang.Object and so because all objects inherit from java.lang.Object it is guaranteed that every object in Java has this method. Overriding the method is always a good idea.

getClass() method defined in the Object class returns the class Type of an object. getClass() method cannot be overridden.

 

Create a class named Product with the following private member variables.

id of type Long

productName of type String

supplierName of type String

Include appropriate getters and setters.

Include a 3-argument constructor and a default constructor.

 

Override the toString() method defined in the Object class. Display the details of the product in this method as shown in the sample output.

 

Create another class and write a main method to test the above class. Invoke the getClass() method from main.

 

Input and Output Format:

 

Refer sample input and output for formatting specifications.

All text in bold corresponds to input and the rest corresponds to output.

 

Sample Input and Output :

Enter the product id

1

Enter the product name

Printer

Enter the supplier name

HP

1 : Printer : HP

Invoking getClass() method : class Product

*/


import java.util.*;
public class Main {

	public static void main(String[] args) {
		//fill your code here
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the product id");
		long  id = sc.nextLong();
		sc.nextLine();
		System.out.println("Enter the product name");
		String pname = sc.nextLine();		
		System.out.println("Enter the supplier name");
		String sname = sc.nextLine();		
		Product p = new Product(id, pname, sname);
		System.out.println(p.toString());
		 //o = new Object();
		System.out.println("Invoking getClass() method : "+p.getClass());
	}

}



public class Product{
    private long id;
    private String  productName;
    private String supplierName;

    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return id;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getProductName() {
        return productName;
    }
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
    public String getSupplierName() {
        return supplierName;
    }
    Product() {

    }
    Product(long id, String productName, String supplierName) {
        this.id = id;
        this.productName = productName;
        this.supplierName = supplierName;

    }
    public String toString() {
        return getId()+" : " +getProductName()+" : "+getSupplierName();
    }

}  
