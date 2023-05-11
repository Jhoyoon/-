package silver;
import java.util.*;
import java.io.*;

public class B_11724_연결요소의개수{
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        A = new ArrayList[node+1];
        visited = new boolean[node+1];
        for(int i=1;i<=node;i++){
            A[i] = new ArrayList<>();
        }
        for(int i=0;i<edge;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }
        int count = 0;
        for(int i=1;i<=node;i++){
            if(!visited[i]){
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }
    private static void DFS(int node){
        visited[node] = true;
        for(int i: A[node]){
            if(!visited[i]){
                DFS(i);
            }
        }
    }
}