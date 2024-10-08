package com.CloneMethod;

class Complaint {
    private String complaint;
    private Customer customer;

    public Complaint(String complaint, Customer customer) {
        this.complaint = complaint;
        this.customer = customer;
    }

    public void display() {
        if (customer != null) {
            System.out.println("Name : " + customer.getName()+" ");
            System.out.println("ID : " + customer.getId()+" ");
            System.out.println("Country : " + customer.getCountry()+" ");
        }
        System.out.println("Complaint : " + complaint);
    }
}
........................................................

package com.CloneMethod;
import java.util.*;

class Customer implements Cloneable {
    private String name;
    private String id;
    private String country;

    public Customer(String name, String id, String country) {
        this.name = name;
        this.id = id;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}


........................................................

package com.CloneMethod;
import java.util.*;

import java.util.*;
import java.io.*;


class Main{
	public static void main(String[] args) throws Exception{
	        Scanner scanner = new Scanner(System.in);
	        ArrayList<Complaint> complaints = new ArrayList<>();
	        Customer prevCustomer = null;
	        String ch="";
	
	        do {
	            System.out.println("Enter the customer name");
	            String name = scanner.nextLine();
	
	            if (name.isEmpty()) {
	                if (prevCustomer == null) {
	                    System.out.println("No previous customer. Please enter a name.");
	                    continue;
	                }
	                 System.out.println("Same customer");
	                System.out.println("Enter the complaint");
	                String complaintText = scanner.nextLine();
	                complaints.add(new Complaint(complaintText, (Customer) prevCustomer.clone()));
	            } else {
	                System.out.println("Enter the id");
	                String id = scanner.nextLine();
	                System.out.println("Enter the country");
	                String country = scanner.nextLine();
	
	                prevCustomer = new Customer(name, id, country);
	                System.out.println("Enter the complaint");
	                String complaint = scanner.nextLine();
	                complaints.add(new Complaint(complaint, prevCustomer));
	            }
	
	            System.out.println("Add another complaint ??");
	            ch = scanner.nextLine();
	        } while (ch.equalsIgnoreCase("yes"));
	
	        System.out.println("Complaint Details");
	        for (Complaint complaint : complaints) {
	            complaint.display();
	            System.out.println();
	        }
	
	        scanner.close();
	    }
}

