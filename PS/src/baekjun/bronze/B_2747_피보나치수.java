package baekjun.bronze;
import java.io.*;
public class B_2747_피보나치수{
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        for(int i=0;i<=N;i++){
            arr[i] = -1;
        }
        arr[0]=0;
        arr[1]=1;
        int sol = pibo(N);
        System.out.print(sol);
    }
    private static int pibo(int n){
        if(arr[n] != -1) return arr[n];
        return arr[n] = pibo(n-2)+pibo(n-1);
    }
}