import java.io.File;
import java.util.*;

public class Euler_project_advance {

    private static int N = 100;
    private static int[][] num=new int[N][N];
    public static void main(String[] args) {
        int i,j;
        try{
		File f=new File("/home/manish/p067_triangle.txt");
		Scanner s= new Scanner(f);
		for( i = 0; i < N; i++){
            for( j = 0; j <= i; j++){
                num[i][j] = s.nextInt();
            }
            s.nextLine();
        }
		s.close();
        }
        catch (Exception e)
		{
	    	e.printStackTrace();
	    }
        int depth = N-2;
        while(depth >= 0){
            for(i = 0; i <= depth ; i++){
                num[depth][i] += Math.max(num[depth+1][i],num[depth+1][i+1]);
            }
            depth--;
        }
        System.out.println(num[0][0]);
    }
}