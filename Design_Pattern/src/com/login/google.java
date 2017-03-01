package com.login;
import java.util.Scanner;

public class google implements Interface{

	@Override
	public void disp() {
		// TODO Auto-generated method stub
		System.out.println("Please Provide your id");
		Scanner id = new Scanner(System.in);
		String id3 = id.nextLine();
		System.out.println("Please Provide your Password");
		Scanner pass = new Scanner(System.in);
		String pas = pass.nextLine();
		System.out.println("Thank u for ur time");
	}

}
