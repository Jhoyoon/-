package gold;
import java.io.*;
import java.util.*;
public class B_1915_가장큰정사각형 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][M+1];
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=1;j<=M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
    }
}
