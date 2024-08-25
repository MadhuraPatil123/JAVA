/*
String Builder 
String Builder
StringBuilder class is used to create mutable (modifiable) string. StringBuilders are used when the String has to be modified constantly. We recently observed that the availability of items for the stall is hard to know. So we are gonna program that requirement here. Get the availability of the items from the vendors. They are providing the list separated by "$". So use string builder and display the details of the items along with their availability. The list provided by vendors only have the available numbers of the item. We don't want that, so just display whether the item is available or not.

Create a class Item with following private attributes

Attributes	Datatype
name	String
type	String
cost	Integer
availableQuantity	Integer
Include appropriate getters and setters
Create default constructor and a parameterized constructor with arguments in order Item(String name, String type, Integer cost, Integer availableQuantity).

Create a driver class named Main to test the above class.

Note:
  Strictly adhere to the Object-Oriented Specifications given in the problem statement.All class names, attribute names and method names should be the same as specified in the problem statement.

Input Format:
The first line input corresponds to the number of items 'n'.
The next 'n' line of inputs corresponds to the item details in the format of (Item Name$Item Type$Item Cost$Item Availability).
Refer sample input for formatting specifications.

Output Format:
The output consists Item details in the CSV format.If the available quantity of the item is 0 then make it as "Not Available" else "Available".
Refer sample output for formatting specifications.

Sample Input/Output-1:
Enter the number of items:
3
Enter the item details in the format(Item Name$Item Type$Item Cost$Item Availability)
Wallets$Leather$1200$10
Notebooks$Papers$200$0
Headphones$Electronics$800$3
Items:
Wallets,Leather,1200,Available
Notebooks,Papers,200,Not Available
Headphones,Electronics,800,Available
 



Problem Requirements:
Java
Keyword	Min Count	Max Count
StringBuilder	1	-

*/


public class Item {
    private String name,type;
    private Integer cost,availableQuantity;
    
    Item() {}
    
    Item(String name, String type, Integer cost, Integer availableQuantity) {
        this.name = name;
        this.type = type;
        this.cost = cost;
        this.availableQuantity = availableQuantity;
    }
    	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	public Integer getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(Integer availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
    
    String getAvailability() {
        return availableQuantity > 0 ? "Available" : "Not Available";
    }
    
    
}




import java.util.*;

public class Main {
    
	public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);
        //StringBuilder sb = new StringBuilder();
        System.out.println("Enter the number of items:");
        int n = sc.nextInt();
        sc.nextLine();
        List<Item> list = new ArrayList<Item>();
        List<String> sbList = new ArrayList<String>();
        System.out.println("Enter the item details in the format(Item Name$Item Type$Item Cost$Item Availability)");
        
        for(int i=0;i<n;i++) {
            String[] details = sc.nextLine().split("\\$");
            Item item = new Item(details[0], details[1], Integer.parseInt(details[2]), Integer.parseInt(details[3]));
           list.add(item);
        }
        System.out.println("Items:");
        for(Item item : list) {
          StringBuilder sb = new StringBuilder();
          
            sb.append(item.getName()).append(",")
               .append(item.getType()).append(",")
               .append(item.getCost()).append(",")
               .append(item.getAvailability());
               System.out.println(sb);
                //sbList.add(sb);
        }

       
        sc.close();
	}
}
