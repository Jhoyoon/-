package baekjun.bronze;
import java.io.*;
import java.util.*;
public class B_1547_공 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[4];
        arr[1] = 1;
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int tmp = arr[a];
            arr[a] = arr[b];
            arr[b] = tmp;
        }
        for(int i=1;i<=3;i++){
            if(arr[i] == 1) System.out.println(i);
        }
    }
}
