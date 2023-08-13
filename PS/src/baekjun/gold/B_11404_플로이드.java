package baekjun.gold;
import java.io.*;
import java.util.*;
public class B_11404_플로이드{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int node = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());
        long[][] arr = new long[node+1][node+1];
        for(int i=1;i<=node;i++){
            for(int j=1;j<=node;j++){
                arr[i][j] = Integer.MAX_VALUE;
                if(i == j) arr[i][j] = 0;
            }
        }
        for(int i=1;i<=edge;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            arr[s][e] = Math.min(arr[s][e],value);
        }
        // 플로이드 워셜 알고리즘 실행
        for(int k=1;k<=node;k++){
            for(int i=1;i<=node;i++){
                for(int j=1;j<=node;j++){
                    arr[i][j] = Math.min(arr[i][j],arr[i][k]+arr[k][j]);
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        for(int i=1;i<=node;i++){
            for(int j=1;j<=node;j++){
                if(arr[i][j] == Integer.MAX_VALUE) sb.append(0+" ");
                else sb.append(arr[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}