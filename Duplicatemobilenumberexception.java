/*
Duplicate mobile number exception
Duplicate mobile number exception
 

Write a java program to find the duplicate mobile number using the exception handling mechanism.

Strictly adhere to the Object-Oriented specifications given in the problem statement. All class names, attribute names and method names should be the same as specified in the problem statement.

Create a Class called ContactDetail with the following private attributes.

Attributes	Datatype
mobile	String
alternateMobile	String
landLine	String
email	String
address	String
Include getters and setters.
Include default and parameterized constructors.
Format for a parameterized constructor is ContactDetail(String mobile, String alternateMobile,String landLine, String email, String address)

Override the toString() method to display the Contact details as specified.

Create a class called ContactDetailBO with following methods

Method 	Description
static void validate(String mobile,String alternateMobile)	This method throws DuplicateMobileNumber exception
if the mobile and alternateMobile are the same.
 

Create a driver class called Main. In the Main method, obtain inputs from the user. Validate the mobile and alternateMobile and display the ContactDetail if no exception occurs else handle the exception.

Pass the exception message as "Mobile number and alternate mobile number are same". If mobile and alternateMobile are the same.

Input and Output format:
Refer to sample Input and Output for formatting specifications.

Note: All text in bold corresponds to the input and rest corresponds to the output.

Sample Input and Output 1:

Enter the contact details
9874563210,9874563210,0447896541,johndoe@abc.in,22nd street kk nagar chennai
DuplicateMobileNumberException: Mobile number and alternate mobile number are same

Sample Input and Output 2:

Enter the contact details
9874563210,9876543211,0447896541,johndoe@abc.in,22nd lane RR nagar kovai
Mobile:9874563210
Alternate mobile:9876543211
LandLine:0447896541
Email:johndoe@abc.in
Address:22nd lane RR nagar kovai

 
*/



public class ContactDetailBO {
		//your code here
	public static void validate(String mobile,String AlternateMobile) throws DuplicateMobileNumberException
    {
       if(mobile.equals(AlternateMobile)) {
           throw new DuplicateMobileNumberException("Mobile number and alternate mobile number are same");
       }
    }
}



public class ContactDetail {
	//Your code here
    private    String mobile;
	private	String alternateMobile;
	private	String landLine;
	private	String email;
	private String address;
	public ContactDetail(String mobile, String alternateMobile, String landLine, String email, String address) {
		this.mobile = mobile;
		this.alternateMobile = alternateMobile;
		this.landLine = landLine;
		this.email = email;
		this.address = address;
	}
	public ContactDetail()
	{
		
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAlternateMobile() {
		return alternateMobile;
	}
	public void setAlternateMobile(String alternateMobile) {
		this.alternateMobile = alternateMobile;
	}
	public String getLandLine() {
		return landLine;
	}
	public void setLandLine(String landLine) {
		this.landLine = landLine;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
    public String toString()
    {
        return "Mobile:"+this.mobile+"\nAlternate mobile:"+this.alternateMobile+"\nLandLine:"+this.landLine+"\nEmail:"+this.email+"\nAddress:"+this.address;
    }
}



import java.io.*;
public class Main {
	public static void main(String[] args)throws Exception{
		//Your code here
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the contact details");
        String st=br.readLine();
        String[] str=st.split(",");
        // fill the code
        ContactDetail cd = new ContactDetail(str[0],str[1],str[2],str[3],str[4]);
        ContactDetailBO bo = new ContactDetailBO();
        try{
            bo.validate(str[0],str[1]);
            System.out.println(cd);
        }
        catch(Exception e) {
            System.out.println(e);
        }
	}
}



public class DuplicateMobileNumberException extends Exception {
    DuplicateMobileNumberException(String msg) {
        super(msg);
    }

}
	
    
