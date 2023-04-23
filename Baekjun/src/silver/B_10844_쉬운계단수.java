package silver;
import java.io.*;
import java.util.*;
public class B_10844_쉬운계단수{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] D = new long[101][10];
        D[1][0]=0;
        long MOD = 1000000000;
        for(int i=1;i<=9;i++){
            D[1][i] = 1;
        }
        for(int i=2;i<=N;i++){
            D[i][0] = D[i-1][1];
            D[i][9] = D[i-1][8];
            for(int j=1;j<=8;j++){
                D[i][j] = (D[i-1][j-1]+D[i-1][j+1])%MOD;
            }
        }
        long sum = 0;
        for(int i=0;i<=9;i++){
            sum = (sum + D[N][i])%MOD;
        }
        System.out.print(sum);
    }
}