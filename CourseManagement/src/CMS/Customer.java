package CMS;

public class Customer {
	
 private int customerId;
 private String customerName;
 private String issuetype;
 
 public Customer(int customerId, String customerName, String issuetype) {
	this.customerId = customerId;
	this.customerName = customerName;
	this.issuetype = issuetype;
 }

 public int getCustomerId() {
	return customerId;
 }

 public void setCustomerId(int customerId) {
	this.customerId = customerId;
 }

 public String getCustomerName() {
	return customerName;
 }

 public void setCustomerName(String customerName) {
	this.customerName = customerName;
 }

 public String getIssuetype() {
	return issuetype;
 }

 public void setIssuetype(String issuetype) {
	this.issuetype = issuetype;
 }

 @Override
 public String toString() {
	return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", issuetype=" + issuetype + "]";
 }
 
 
 
 
	

}

