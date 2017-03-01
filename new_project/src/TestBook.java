
public class TestBook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Author Manish = new Author("Manish", "mgoyal05", 'm');
		Book b = new Book("Java", Manish, 150.0, 3);
		System.out.println(b.author.getemail());
	}

}
