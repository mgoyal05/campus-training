
public class TestCircle {
	
	public int get(int r){
		return r;
	}
	
	public static void main(String[] args){
		Circle c2 = new Circle(5.0);
		TestCircle t = new TestCircle();
		t.get(15);
		System.out.println(c2.toString());  // explicit call
	}
}
