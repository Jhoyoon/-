package baekjun.silver;
import java.io.*;
import java.util.*;
public class B_14248_점프점프 {
    static int N;
    static int[] arr;
    static int s;
    static int count;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N  = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        arr = new int[N];
        visited = new boolean[N];
        count=1;
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        s = Integer.parseInt(br.readLine());
        DFS(s-1);
        System.out.println(count);
    }
    private static void DFS(int s){
        int now = arr[s];
        if(s+now >=0 && s+now<N){
            if(!visited[s+now]) {
                visited[s+now] = true;
                count++;
            }
            DFS(s+now);
        }
        if(s - now >= 0 && s-now <N){
            if(!visited[s-now]){
                visited[s-now] = true;
                count++;
            }
            DFS(s-now);
        }
    }
}
