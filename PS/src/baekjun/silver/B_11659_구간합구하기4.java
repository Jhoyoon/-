package baekjun.silver;
import java.io.*;
import java.util.*;
public class B_11659_구간합구하기4 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<=N;i++){
            arr[i] = arr[i-1]+Integer.parseInt(st.nextToken());
        }
        StringBuffer sb = new StringBuffer();
        for(int i=1;i<=T;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(arr[e] - arr[s-1]+"\n");
        }
        System.out.print(sb.toString());
    }
}
