public class Circle{
	public static void main(String[] args){
		circle c = new circle();
		c.radius = 1/Math.sqrt(Math.PI);
		c.area = Math.PI*Math.pow(c.radius, 2);
		System.out.println(c.area);
	}

}
class circle{
	double radius;
	double area;
}
