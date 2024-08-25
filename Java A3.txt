
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ProductDAO {
	
	public List<Product> obtainProductListFromFile(BufferedReader br) throws IOException{
		String st;
		List<Product> list = new ArrayList<Product>();
		while((st = br.readLine())!= null) {
			String[] det = st.split(",");
			if(det.length !=6) 
				continue;
			try {
				if(!verifyEmail(det[5])) {
					
					throw new InvalidEmailException("InvalidEmailException: Email Id invalid "+det[5]);
				}
				else {
					Product product = new Product(det[0], det[1], det[2], Integer.parseInt(det[3]), det[4], det[5]);
					list.add(product);
				}
			} catch (InvalidEmailException e) {
				
				System.out.println("InvalidEmailException: Email Id invalid "+det[5]);
			}
			
		}
		return list;
	}
	
	public void displayProducts(List<Product> productList){
		System.out.format("%-15s %-10s %-10s %-10s %-15s %-15s\n","ProductName","Brand","Color","Price","OwnerName","OwnerEmail");
		for(Product product : productList) {
			System.out.print(product);
		}
	}
	
	public boolean verifyEmail(String email) throws InvalidEmailException{
		String regrex = "^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9.]+$";
		Pattern pattern = Pattern.compile(regrex); 
		Matcher match = pattern.matcher(email);
		return match.matches();
    }
}

-------------------------------------------------------------------

import java.util.*;

public class Product{
    String productName;
    String brand;
    String color;
    Integer price;
    String ownerName;
    String ownerEmail;
    
    public Product() {
        super();
	}

	public Product(String productName, String brand, String color,
			Integer price, String ownerName, String ownerEmail) {
		this.productName = productName;
		this.brand = brand;
		this.color = color;
		this.price = price;
		this.ownerName = ownerName;
		this.ownerEmail = ownerEmail;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerEmail() {
		return ownerEmail;
	}

	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}
	public String toString() {
		return String.format("%-15s %-10s %-10s %-10s %-15s %-15s\n", getProductName(),getBrand(),getColor(), getPrice(),getOwnerName(),getOwnerEmail());
	}
    
}
-----------------------------------------------------------------------

import java.io.*;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		ProductDAO p = new ProductDAO();
		List<Product> list = p.obtainProductListFromFile(br);
		System.out.println("Product details");
		p.displayProducts(list);
		
	}
}
-----------------------------------------------------------------------


public class InvalidEmailException extends Exception{
	InvalidEmailException(String msg) {
		super(msg);
	}
}

