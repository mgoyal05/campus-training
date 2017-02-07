import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int T, N;
        T = sc.nextInt();
        for(int k = 0; k < T; k++){
            N = sc.nextInt();
            int arr[][] = new int[N][N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j <= i; j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            int depth = N-2;
            while(depth >= 0){
                for(int i = 0; i <= depth ; i++){
                    arr[depth][i] += Math.max(arr[depth+1][i],arr[depth+1][i+1]);
                }
                depth--;
            }
            System.out.println(arr[0][0]);
        }
    }
}
