import java.util.*;

public class Calculator {
	public static void main(String args[]){
		Scanner name = new Scanner(System.in);
		double fnum, snum, answer;
		System.out.print("Enter First name :");
		fnum = name.nextDouble();
		System.out.print("Enter Sec name :");
		snum = name.nextDouble();
		answer = fnum + snum;
		System.out.println(answer);
		name.close();
	}
}
