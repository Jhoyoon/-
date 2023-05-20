package silver;
import java.io.*;
import java.util.*;
public class B_1003_피보나치함수 {
    // 이전 재귀를 돌았을 때 0과 1 개수를 저장해놓는 배열.이렇게 하면 이전에 개수를 구한 재귀는 계산 안 하고 바로 더할수 있다.
    // N이 40까지기에 41
    static int[][] dp = new int[41][2];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<41;i++){
            for(int j=0;j<2;j++){
                dp[i][j] = -1;
            }
        }
        dp[0][0] = 1; // N이 0일 때 0개수
        dp[0][1] = 0; // N이 0일 때 1 개수
        dp[1][0] = 0; // N이 1일 때 0 개수
        dp[1][1] = 1; // N이 1일 때 1 개수
        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<T;i++){
            int N = Integer.parseInt(br.readLine());
            fibonachi(N);
            sb.append(dp[N][0]+" "+dp[N][1]+"\n");
        }
        System.out.print(sb.toString());
    }
    private static int[] fibonachi(int n){
        // 탐색한적이 없는 수일 때 탐색한다
       if(dp[n][0] == -1 || dp[n][1] == -1){
            dp[n][0] = fibonachi(n-1)[0]+fibonachi(n-2)[0];
            dp[n][1] = fibonachi(n-1)[1]+fibonachi(n-2)[1];
       }
       // 이미 탐색한적 있을시 그냥 그 값을 리턴해준다
       return dp[n];
    }
}
