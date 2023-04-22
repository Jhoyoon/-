package silver;
import java.io.*;
public class B_1463_1로만들기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        arr[1]=0;
        for(int i=2;i<=N;i++){
            arr[i] = arr[i-1]+1;
            if(arr[i]%3==0) arr[i]=Math.min(arr[i/3]+1,arr[i]);
            if(arr[i]%2==0) arr[i] = Math.min(arr[i],arr[i/2]+1);
        }
        System.out.print(arr[N]);
    }
}
