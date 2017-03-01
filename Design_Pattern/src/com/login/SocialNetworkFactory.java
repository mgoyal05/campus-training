package com.login;

public class SocialNetworkFactory {
	
	public Interface getInstance(String str){
		if(str.equals("facebook"))
			return new facebook();
		else if(str.equals("google")){
			return new google();
		}
		else
			return new twitter();
		
	}
}
