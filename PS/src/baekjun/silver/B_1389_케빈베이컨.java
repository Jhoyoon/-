package baekjun.silver;
import java.io.*;
import java.util.*;
public class B_1389_케빈베이컨{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        long[][] arr=  new long[node+1][node+1];
        for(int i=1;i<=node;i++){
            for(int j=1;j<=node;j++){
                arr[i][j] = Integer.MAX_VALUE;
                if(i == j) arr[i][j] = 0;
            }
        }
        for(int i=1;i<=edge;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s][e] = 1;
            arr[e][s]=1;
        }
        // 플로이드 워셜 알고리즘 실행
        for(int k=1;k<=node;k++){
            for(int i=1;i<=node;i++){
                for(int j=1;j<=node;j++){
                    arr[i][j] = Math.min(arr[i][j],arr[i][k]+arr[k][j]);
                }
            }
        }
        long[] result = new long[node+1];
        for(int i=1;i<=node;i++){
            for(int j=1;j<=node;j++){
                result[i] = result[i] + arr[i][j];
            }
        }
        long min = Integer.MAX_VALUE;
        for(int i=1;i<=node;i++){
            if(min > result[i]) min = result[i];
        }
        for(int i=1;i<=node;i++){
            if(result[i] == min){
                System.out.println(i);
                break;
            }
        }
    }
}