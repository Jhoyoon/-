package baekjun.gold;
import java.io.*;
import java.util.*;
public class B_13023_ABCDE{
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static boolean arrive;
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        visited = new boolean[node];
        arrive = false;
        arr = new ArrayList[node];
        for(int i=0;i<node;i++){
            arr[i] = new ArrayList<>();
        }
        for(int i=0;i<edge;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
            arr[e].add(s);
        }
        for(int i=0;i<node;i++){
            DFS(i,1);
            if(arrive) break;
        }
        if(arrive) System.out.println(1);
        else System.out.println(0);
    }
    private static void DFS(int node,int depth){
        if(visited[node]) return;
        if(depth == 5){
            arrive = true;
            return;
        }
        visited[node] = true;
        for(int i : arr[node]){
            DFS(i,depth+1);
        }
        visited[node] = false;

    }
}