import java.util.Scanner;
import com.login.*;
public class FactoryMain {

	public static void main(String[] args) {
		
		System.out.println("Please type any existing social network accounts");
		Scanner login = new Scanner(System.in);
		SocialNetworkFactory obj = new SocialNetworkFactory();
		Interface Net = obj.getInstance(login.nextLine());
		Net.disp();
	}

}
