package new_project;

public class Account {
	private int id;
	private Customer customer;
	private double balance;
	
	Account(int id, Customer customer, double balance){
		this.id = id;
		this.customer = customer;
		this.balance = balance;
	}
	Account(int id, Customer customer){
		this.id = id;
		this.customer = customer;
	}
	public int getID(){
		return id;
	}
	public Customer customer(){
		return customer;
	}
	public double balance(){
		return balance;
	}

}
