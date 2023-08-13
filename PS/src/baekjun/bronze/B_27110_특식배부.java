package baekjun.bronze;
import java.io.*;
import java.util.*;
public class B_27110_특식배부 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[3];
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<3;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] <= N) sum = sum + arr[i];
            else sum = sum + N;
        }
        System.out.println(sum);
        
    }
}
