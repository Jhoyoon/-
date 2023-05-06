package silver;
import java.util.*;
import java.io.*;
public class B_11399_ATM인출시간{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<N;i++){
            int insert_index = i;
            int insert_value = arr[i];
            for(int j=i-1;j>=0;j--){
                if(arr[i] > arr[j]){
                    insert_index = j+1;
                    break;
                }
                if(j==0){
                    insert_index=0;
                }
            }
            for(int j=i;j>insert_index;j--){
                arr[j] = arr[j-1];
            }
            arr[insert_index] = insert_value;
        }
        int[] sum = new int[N+1];
        int ans = 0;
        for(int i=1;i<=N;i++){
            sum[i] = sum[i-1]+arr[i-1];
            ans = ans + sum[i];
        }
        System.out.println(ans);
    }
}