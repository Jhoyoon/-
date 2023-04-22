package silver;

import java.io.*;
import java.util.*;
public class B_14501_퇴사준비하기{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] D = new int[N+2];
        int[] T = new int[N+1];
        int[] P = new int[N+1];
        for(int i=1;i<=N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=N;i>0;i--){
            // 직접 해보니까 N보다 하나 큰 경우는 괜찮다.N이 7이고 T[7]이 1인경우 합은 8이고 이는 가능하다
            // 아 8까지 들어올수 있으니까 +2를 해야하는구나
            if(T[i]+i>N+1){
                D[i] = D[i+1];
            }else{
                D[i] = Math.max(D[i+1],D[i+T[i]]+P[i]);
            }
        }
        System.out.print(D[1]);
    }
}