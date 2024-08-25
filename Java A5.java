import java.util.Date;
import java.util.List;

public class Order {
    private int orderNo;
    private String paymentType;
    private double amount;
    private Date purchasedDate;
    private List<Purchase> purchaseList;

    public Order(int orderNo, String paymentType, Date purchasedDate, List<Purchase> purchaseList) {
        this.orderNo = orderNo;
        this.paymentType = paymentType;
        this.purchasedDate = purchasedDate;
        this.purchaseList = purchaseList;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getPurchasedDate() {
        return purchasedDate;
    }

    public void setPurchasedDate(Date purchasedDate) {
        this.purchasedDate = purchasedDate;
    }

    public List<Purchase> getPurchaseList() {
        return purchaseList;
    }

    public void setPurchaseList(List<Purchase> purchaseList) {
        this.purchaseList = purchaseList;
    }

   public void calculateAmount() {
    	amount = 0;
        for(Purchase p : purchaseList) {
        	amount += p.getQuantity()* p.getProduct().getPrice();
        }
    }
}

-------------------------------------------------------------------------
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Product {
    private String productId;
    private String name;
    private Date expiryDate;
    private double price;

    public Product(String productId, String name, Date expiryDate, double price) {
        this.productId = productId;
        this.name = name;
        this.expiryDate = expiryDate;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static List<Product> prefill() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("P001", "WonderCake", new Date(), 200.0));
        products.add(new Product("P002", "Refined Oil", new Date(), 150.0));
        products.add(new Product("P003", "Jamun Mix", new Date(), 100.0));
        products.add(new Product("P004", "Sugar", new Date(), 50.0));
        products.add(new Product("P005", "Luvit", new Date(), 50.0));
        products.add(new Product("P006", "Lifebuoy", new Date(), 30.0));
        products.add(new Product("P007", "Frooti", new Date(), 20.0));
        products.add(new Product("P008", "Maggi", new Date(), 30.0));
        return products;
    }
}

-------------------------------------------------------------------------
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
public class SalesPerson {
    private String name;
    private List<Order> orderList;

    public SalesPerson(String name, List<Order> orderList) {
        this.name = name;
        this.orderList = orderList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

     public static SalesPerson getBestSalesPerson(List<SalesPerson> list) {
        SalesPerson bestSalesPerson = null;
        int maxValuable = 0;
        for(SalesPerson person : list) {
        	int valuable = 0;
        	for(Order order: person.getOrderList()) {
                order.calculateAmount();
        		if(order.getAmount()>500) {
        			valuable++;
        		}
        		
        	}
        	if(valuable> maxValuable) {
        		maxValuable = valuable;
        		bestSalesPerson = person;
        	}
        }
        
        return bestSalesPerson;
    }

    public static List<SalesPerson> prefill() {
        // Prefill with sample data
        // Create products
        List<Product> products = Product.prefill();

        // Create purchases
        List<Purchase> purchases1 = new ArrayList<>();
        purchases1.add(new Purchase(2, products.get(0)));
        purchases1.add(new Purchase(1, products.get(1)));
        purchases1.add(new Purchase(1, products.get(2)));
        purchases1.add(new Purchase(1, products.get(3)));

        List<Purchase> purchases2 = new ArrayList<>();
        purchases2.add(new Purchase(2, products.get(4)));
        purchases2.add(new Purchase(3, products.get(5)));
        purchases2.add(new Purchase(3, products.get(6)));

        // Create orders
        List<Order> orders1 = new ArrayList<>();
        orders1.add(new Order(12, "Debit Card", new Date(), purchases1));

        List<Order> orders2 = new ArrayList<>();
        orders2.add(new Order(10, "Paytm", new Date(), purchases2));

        // Create salespersons
        List<SalesPerson> salesPersons = new ArrayList<>();
        salesPersons.add(new SalesPerson("Oliver", orders1));
        salesPersons.add(new SalesPerson("Barry", orders2));

        return salesPersons;
    }
}

-------------------------------------------------------------------------
public class Purchase {
    private int quantity;
    private Product product;

    public Purchase(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

-------------------------------------------------------------------------
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        System.out.println("Enter the number of orders:");
        int numberOfOrders = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        List<SalesPerson> salesPersons = new ArrayList<>();

        for (int i = 0; i < numberOfOrders; i++) {
            String[] orderDetails = scanner.nextLine().split(",");

            int orderNo = Integer.parseInt(orderDetails[0]);
            String paymentType = orderDetails[1];
            Date purchasedDate = dateFormat.parse(orderDetails[2]);
            String salesPersonName = orderDetails[3];

            System.out.println("Enter the number of purchases:");
            int numberOfPurchases = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            List<Purchase> purchaseList = new ArrayList<>();

            for (int j = 0; j < numberOfPurchases; j++) {
                String[] purchaseDetails = scanner.nextLine().split(",");
                String productName = purchaseDetails[0];
                int quantity = Integer.parseInt(purchaseDetails[1]);

                // Find product by name
                Product product = null;
                for (Product p : Product.prefill()) {
                    if (p.getName().equals(productName)) {
                        product = p;
                        break;
                    }
                }

                if (product != null) {
                    Purchase purchase = new Purchase(quantity, product);
                    purchaseList.add(purchase);
                }
            }

            Order order = new Order(orderNo, paymentType, purchasedDate, purchaseList);

            // Check if the salesperson already exists
            SalesPerson salesPerson = null;
            for (SalesPerson sp : salesPersons) {
                if (sp.getName().equals(salesPersonName)) {
                    salesPerson = sp;
                    break;
                }
            }

            if (salesPerson == null) {
                salesPerson = new SalesPerson(salesPersonName, new ArrayList<>());
                salesPersons.add(salesPerson);
            }

            salesPerson.getOrderList().add(order);
        }

        SalesPerson bestSalesPerson = SalesPerson.getBestSalesPerson(salesPersons);

        if (bestSalesPerson != null) {
            System.out.println("The best salesperson is " + bestSalesPerson.getName());
        } else {
            System.out.println("No best salesperson found.");
        }

        scanner.close();
    }
}

-------------------------------------------------------------------------
