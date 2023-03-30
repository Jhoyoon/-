import java.util.*;
import java.io.*;
public class B_10989{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        StringBuffer sb  = new StringBuffer();
        for(int i : arr){
            sb.append(i+"\n");
        }
        System.out.print(sb.toString());
        
    }
}