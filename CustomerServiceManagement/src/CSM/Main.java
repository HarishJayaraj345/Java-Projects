package CSM;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Service service = new Service();
		
		System.out.println("Customer Service Management");
		
		while(true) {
			System.out.println("1. Add Customer");
			System.out.println("2. View Next Customer");
			System.out.println("3. Serve Customer");
			System.out.println("4. Display All Customer");
			System.out.println("5. Exit");
			System.out.println("Enter a choice :");
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("Enter a id :");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter a name :");
				String name = sc.nextLine();
				System.out.println("Enter a type :");
				String type = sc.nextLine();
				service.addCustomer(new Customer(id,name,type));
				break;
			case 2:
				service.viewNextCustomer();
				break;
			case 3:
				service.serveCustomer();
				break;
			case 4:
				service.displayAllCustomers();
				break;
			case 5:
				System.out.println("Thank you..");
				System.exit(0);
			default :
				System.out.println("Invalid choice ! ");
			}
			
		}

	}

}
