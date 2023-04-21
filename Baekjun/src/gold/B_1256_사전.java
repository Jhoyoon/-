package gold;
import java.io.*;
import java.util.*;
public class B_1256_사전{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N  = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] arr = new int[201][201];
        for(int i=0;i<=200;i++){
            arr[i][i] = 1;
            arr[i][0] = 1;
            arr[i][1] = i;
        }
        for(int i=2;i<=200;i++){
            for(int j=2;j<i;j++){
                arr[i][j] = arr[i-1][j-1]+arr[i-1][j];
                if(arr[i][j]>1000000000) arr[i][j] = 1000000001;
            }
        }
        StringBuffer sb = new StringBuffer();
        if(arr[N+M][N]<K) sb.append(-1);
        else{
            while(!(N==0 && M == 0)){
                if(arr[N+M-1][M]>=K){
                    sb.append("a");
                    N--;
                }else{
                    sb.append("z");
                    K = K - arr[N+M-1][M];
                    M--;
                }
            }
        }
        System.out.print(sb.toString());
    }
}