package new_project;

public class Customer {
	private int ID;
	private String name;
	private char gender;
	
	Customer(int ID, String name, char gender){
		this.ID = ID;
		this.name = name;
		this.gender = gender;
	}
	public int getID(){
		return ID;
	}
	public String getname(){
		return name;
	}
	public char getGender(){
		return gender;
	}
	public String toString(){
		return "Customer : " + ID + " : " + name + " : " +  gender;
	}
}
