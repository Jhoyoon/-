package baekjun.gold;
import java.io.*;
import java.util.*;
public class B_10986_나머지합{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] S = new long[N+1];
        long[] D = new long[M];
        long count = 0;
        st = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<=N;i++){
            S[i] = S[i-1] + Long.parseLong(st.nextToken());
        }
        for(int i=1;i<=N;i++){
            long remainder = S[i]%M;
            if(remainder == 0) count++;
            D[(int)remainder]++;
        }
        for(int i=0;i<M;i++){
            if(D[i]>1) count = count + (D[i] * (D[i]-1)/2);
        }
        System.out.println(count);
    }
}