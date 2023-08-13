package baekjun.bronze;
import java.io.*;
import java.util.*;
public class B_2775_부녀회장{
    public static void main(String[] args) throws IOException{
        int[][] apart = new int[15][15];
        for(int i=0;i<=14;i++){
            apart[0][i] = i;
        }
        for(int i=1;i<=14;i++){
            for(int j=1;j<=14;j++){
                apart[i][j] = apart[i][j-1]+apart[i-1][j];
            }
        }
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<T;i++){
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());
            sb.append(apart[N][M]+"\n");
        }
        System.out.print(sb.toString());
    }
}