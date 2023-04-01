import java.util.*;
import java.io.*;
public class B_1300 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] arr = new int[N][N];
        int[] arr2 = new int[N*N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                arr[i][j]=i*j;
            }
        }
        

        
    }
}
