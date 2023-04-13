package silver;
import java.util.*;
import java.io.*;

public class B_1389_케빈베이컨{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[][] distance = new long[N+1][N+1];
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(i==j) distance[i][j] = 0;
                else distance[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            distance[s][e] = 1;
            distance[e][s] =1;
        }
        for(int k=1;k<=N;k++){
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    distance[i][j] = Math.min(distance[i][j],distance[i][k]+distance[k][j]);
                }
            }
        }

        long min = Integer.MAX_VALUE;
        int answer = 0;
        for(int i=1;i<=N;i++){
            long sum = 0;
            for(int j=1;j<=N;j++){
                sum = sum+distance[i][j];
            }
            // 같은 수를 가졌을 경우 answer를 업데이트 하지 않는다.그렇기에 문제의 조건을 만족함.
            if(min>sum) {
            min = sum;
            answer = i;
            }
        }
        System.out.print(answer);
    }
}