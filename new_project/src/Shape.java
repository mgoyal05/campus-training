
public abstract class Shape {
	private String color;
	private boolean filled;
	Shape(){
		color = "red";
		filled = true;
	}
	Shape(String color, boolean filled){
		this.color = color;
		this.filled = filled;
	}
	
	public String getColor(){
		return color;
	}
	
	public void setColor(String color){
		this.color = color;
	}

	public boolean isFilled(boolean filled){
		if(filled)
			return true;
		else
			return false;
	}
	
	public void setFilled(boolean filled){
		this.filled = filled;
	}
	
	//public double getArea;

}
