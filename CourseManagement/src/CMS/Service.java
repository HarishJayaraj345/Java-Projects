package CMS;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.function.Consumer;

@FunctionalInterface
interface add{
	void addcustomer(Customer cus);
}

public class Service {
	
	Deque<Customer> customerlist = new LinkedList<>();
	
	Map<Integer,Customer> map = new HashMap<>();
	
	public void addCustomer(Customer customer) {
		
		add addcustomer = (c) -> customerlist.offer(c);
		addcustomer.addcustomer(customer);
		map.put(customer.getCustomerId(), customer);
        System.out.println("Customer successfully added.");
		
	}
	
	public void viewNextCustomer() {
		if(customerlist.size()>1) {
		Customer firstcustomer = customerlist.poll();
		Customer secondcustomer = customerlist.peek();
		Consumer<Customer> view2ndcustomer = (c) ->System.out.println("id :"+c.getCustomerId()+" Name :"+c.getCustomerName()+" Type s:"+c.getIssuetype());
		customerlist.addFirst(firstcustomer);
		view2ndcustomer.accept(secondcustomer);
		}
		else {
			System.out.println("there is no Next Customer");
		}
	}
	
	public void  serveCustomer() {
		Customer cus = customerlist.peek();
		Consumer<Customer> view2ndcustomer = (c) ->System.out.println("Id :"+c.getCustomerId()+" Name :"+c.getCustomerName()+" Type:"+c.getIssuetype());
		view2ndcustomer.accept(cus);
	}
	
	
	public static void showDetails(Customer customer) {
		System.out.println(customer);
	}

	public void displayAllCustomers() {
		customerlist.forEach(Service::showDetails);   
	}

	
	

}
