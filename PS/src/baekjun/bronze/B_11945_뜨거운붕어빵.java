package baekjun.bronze;
import java.io.*;
import java.util.*;
public class B_11945_뜨거운붕어빵 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                arr[i][j] = str.charAt(j)-'0';
            }
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<N;i++){
            for(int j=M-1;j>=0;j--){
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
