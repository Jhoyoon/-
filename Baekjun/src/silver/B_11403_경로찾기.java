package silver;
import java.io.*;
import java.util.*;
public class B_11403_경로찾기{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int node = Integer.parseInt(br.readLine());
        int[][] arr = new int[node][node];
        for(int i=0;i<node;i++){
            for(int j=0;j<node;j++){
                arr[i][j] = 100;
                if(i == j) arr[i][j] = 0;
            }
        }
        for(int i=0;i<node;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0;j<node;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 플로이드 워셜 실행
        for(int k=0;k<node;k++){
            for(int i=0;i<node;i++){
                for(int j=0;j<node;j++){
                    if(arr[i][k] == 1 && arr[k][j] == 1) arr[i][j] =1;
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<node;i++){
            for(int j=0;j<node;j++){
               sb.append(arr[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());

    }
}