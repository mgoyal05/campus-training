package com.login;
import java.util.Scanner;

public class facebook implements Interface{

	@Override
	public void disp(){

		System.out.println("Please Provide your id");
		Scanner id = new Scanner(System.in);
		String id3 = id.nextLine();
		System.out.println("Please Provide your Password");
		Scanner pass = new Scanner(System.in);
		String pas = pass.nextLine();		
	}

}
