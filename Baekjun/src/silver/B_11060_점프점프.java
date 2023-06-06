package silver;
import java.io.*;
import java.util.*;
public class B_11060_점프점프{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        // 해당 번호까지의 최단거리
        long[] dp = new long[2000];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // Math.min을 사용할 것이기에 큰값으로 업데이트 해놓는다
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        // 모든 arr 요소들을 한번씩 돈다
        for(int i=0;i<N;i++){
            // 해당 요소에 도달이 불가능한 것이기에 체크하지 않는다.
            if(arr[i] == Integer.MAX_VALUE) continue;
            // 가능한 이동거리만큼 전부 확인해본다
            for(int j=1;j<=arr[i];j++){
                // 기존 값과 dp[i]+1중 작은거롤 업데이트 한다.
                dp[i+j] = Math.min(dp[i]+1,dp[i+j]);
            }
        }
        if(dp[N-1] == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(dp[N-1]);
    }
}