package gold;
import java.io.*;
public class B_1947_선물전달{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[1000001];
        int MOD = 1000000000;
        arr[1] = 0;
        arr[2] = 1;
        for(int i=3;i<=N;i++){
            arr[i] = (i-1)*(arr[i-1]+arr[i-2])%MOD;
        }
        System.out.print(arr[N]);
    }
}