
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of policy");
		int n = sc.nextInt();
		sc.nextLine();
		List<Policy> list = new ArrayList<Policy>();
		
		for(int i = 1; i <=n; i++) {
			
			System.out.println("Enter the policy "+i+" detail");
			String[] policy = sc.nextLine().split(",");
			Policy p = new Policy(policy[0],policy[1], Double.parseDouble(policy[2]),policy[3],Double.parseDouble(policy[4]));
			list.add(p);
			
		}
		Policy p = new Policy();
		Map<String,List<Policy>> PolicyMap = p.generatePolicyMap(list);
		
		System.out.println("Enter the policy plan to be searched");
		String search = sc.nextLine();
		List<Policy> found = p.searchPolicy(PolicyMap, search);
		
		if(found != null) {
			System.out.format("%-15s %-15s %-15s %-15s %s\n","Policy Id","Customer Name","Policy Value","Policy plan","Coverage Percentage");

			for(Policy policy: found) {
				System.out.print(policy);
			}
		}
		else 
			System.out.println("Searched policy not found");
	}

}

---------------------------------------------------------------
import java.util.*;
public class Policy{
    String policyId;
    String customerName;
    double policyValue;
    String policyPlan;
    double coveragePercentage;
    
    public Policy() {
    	super();
	}
    
    public Policy(String policyId,String customerName,double policyValue,String policyPlan,double coveragePercentage){
        super();
        this.policyId = policyId;
        this.customerName = customerName;
        this.policyValue = policyValue;
        this.policyPlan = policyPlan;
        this.coveragePercentage = coveragePercentage;
    }
    
    public String getPolicyId() {
    	return policyId;
	}

	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}
    
    public String getCustomerName() {
        return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
    
    public double getPolicyValue() {
        return policyValue;
    }

	public void setPolicyValue(double policyValue) {
		this.policyValue = policyValue;
	}
    
    public String getPolicyPlan() {
        return policyPlan;
    }

    public void setPolicyPlan(String policyPlan) {
		this.policyPlan = policyPlan;
	}
    
    public double getCoveragePercentage() {
        return coveragePercentage;
    }

    public void setCoveragePercentage(double coveragePercentage) {
		this.coveragePercentage = coveragePercentage;
	}
    
    

    @Override
	public String toString() {
		return String.format("%-15s %-15s %-15s %-15s %s\n", policyId, customerName, policyValue, policyPlan, coveragePercentage );
	}



	Map<String,List<Policy>> generatePolicyMap(List<Policy> policyList){
    	Map<String,List<Policy>> policyMap = new HashMap <String,List<Policy >>();
        
        for(Policy policy : policyList) {
        	 String policyPlan = policy.getPolicyPlan();
        	 if(policyMap.get(policyPlan) == null) {
        		 policyMap.put(policyPlan, new ArrayList<Policy>());
        	 }
        	 policyMap.get(policyPlan).add(policy);
        }
        
		return policyMap;
        
    }
    List<Policy> searchPolicy(Map<String,List<Policy>> policyMap, String policyPlan){
    	List <Policy> found = policyMap.get(policyPlan);
    	return found;
    }
    
}
