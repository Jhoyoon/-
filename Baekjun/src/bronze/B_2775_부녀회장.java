package bronze;
import java.io.*;
public class B_2775_부녀회장{
    public static void main(String[] args) throws IOException{
        int[][] arr = new int[15][15];
        for(int i=0;i<=14;i++){
            arr[i][1] = 1;
            arr[0][i] = i;
        }
        for(int i=1;i<=14;i++){
            for(int j=1;j<=14;j++){
                arr[i][j] = arr[i-1][j]+arr[i][j-1];
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuffer sb  =new StringBuffer();
        for(int i=0;i<T;i++){
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());
            sb.append(arr[N][M]+"\n");
        }
        System.out.print(sb.toString());
    }
}