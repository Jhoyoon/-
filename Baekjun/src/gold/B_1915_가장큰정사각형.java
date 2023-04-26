package gold;
import java.io.*;
import java.util.*;
public class B_1915_가장큰정사각형{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N  = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[][] D = new long[1002][1002];
        long max = 0;
        for(int i=1;i<=N;i++){
            String s= br.readLine();
            for(int j=1;j<=M;j++){
                D[i][j] = s.charAt(j-1)-'0';
                if(D[i][j]== 1 && i>1 && j>1){
                    D[i][j] = Math.min(D[i-1][j-1],Math.min(D[i-1][j],D[i][j-1]))+1;
                }
                if(D[i][j]>max) max = D[i][j];
            }
        }
        System.out.println(max*max);
    }
}