public class Circle{
	private double radius;
	private String color;
	public Circle(){
		radius = 1.0;
		color = "red";
	}

	public String toString(){
		return "Circle \nradius : "+ radius + "color : " + color;
	}
	
	public Circle(double radius){
		this.radius = radius;
		color = "red";
	}
	public Circle(double r, String c){
		radius = r;
		color = c;
	}
	public double getRadius(){
		return radius;
	}
	public double getArea(){
		return Math.PI*radius*radius;
	}
}
