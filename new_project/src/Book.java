public class Book {
	String name;
	Author author;
	double price;
	int qty;
	public Book(String name, Author author, double price ){
		this.name = name;
		this.author = author;
		this.price = price;
	}
	
	public Book (String name, Author author, double price, int qty){
		this.name = name;
		this.author = author;
		this.price = price;
		this.qty = qty;
	}
	
	public String getName(){
		return name;
	}
	
	public String toString(){
		return "Book[name= " + name + ", " + author.toString()+ ", price= " + price + ",qty= "+ qty +" ";
	}
}
