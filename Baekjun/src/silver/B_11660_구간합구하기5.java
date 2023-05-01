package silver;
import java.io.*;
import java.util.*;
public class B_11660_구간합구하기5 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        long[][] arr = new long[N+1][N+1];
        // 일단 원본 배열을 입력 받음
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=1;j<=N;j++){
                arr[i][j] = Long.parseLong(st.nextToken());
            }
        }
        long[][] arr2 = new long[N+1][N+1];
        // 합배열을 만듬
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                arr2[i][j] = arr2[i-1][j] + arr2[i][j-1] - arr2[i-1][j-1]+arr[i][j];
            }
        }
        // 이제 구간합을 도출해냄
        StringBuffer sb = new StringBuffer();
        for(int i=1;i<=T;i++){
            st = new StringTokenizer(br.readLine()," ");
            int x1,y1,x2,y2;
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            long ans = arr2[x2][y2]-arr2[x1-1][y2]-arr2[x2][y1-1]+arr2[x1-1][y1-1];
            sb.append(ans+"\n");
        }
        System.out.print(sb.toString());
    }
}
