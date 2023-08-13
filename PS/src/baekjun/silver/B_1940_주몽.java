package baekjun.silver;
import java.io.*;
import java.util.*;
public class B_1940_주몽 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start_index = 1;
        int end_index = N;
        int count = 0;
        Arrays.sort(arr);
        while(start_index <end_index){
            long sum = arr[start_index]+arr[end_index];
            if(sum > M){
                end_index--;
            }else if(sum<M){
                start_index++;
            }else{
                count++;
                start_index++;
                end_index--;
            }
        }
        System.out.println(count);
    }
}
