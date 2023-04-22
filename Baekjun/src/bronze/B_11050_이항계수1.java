package bronze;
import java.io.*;
import java.util.*;
public class B_11050_이항계수1{
    public static void main(String[] args) throws IOException{
        int[][] arr = new int[11][11];
        for(int i=0;i<=10;i++){
            arr[i][0] = 1;
            arr[i][i]=1;
            arr[i][1]=i;
        }
        for(int i=2;i<=10;i++){
            for(int j=2;j<i;j++){
                arr[i][j] = arr[i-1][j]+arr[i-1][j-1];
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        System.out.print(arr[N][M]);
    }
}