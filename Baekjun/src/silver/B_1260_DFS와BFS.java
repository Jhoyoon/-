package silver;
import java.io.*;
import java.util.*;
public class B_1260_DFS와BFS{
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static StringBuffer sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int start_node = Integer.parseInt(st.nextToken());
        arr = new ArrayList[node+1];
        visited = new boolean[node+1];
        for(int i=1;i<=node;i++){
            arr[i] = new ArrayList<>();
        }
        for(int i=0;i<edge;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
            arr[e].add(s);
        }
        for(int i=1;i<=node;i++){
            Collections.sort(arr[i]);
        }
        sb = new StringBuffer();
        DFS(start_node);
        sb.append("\n");
        Arrays.fill(visited,false);
        BFS(start_node);
        System.out.println(sb.toString());
    }
    private static void DFS(int node){
        if(visited[node]) return;
        sb.append(node+" ");
        visited[node] = true;
        for(int i : arr[node]){
            DFS(i);
        }
    }
    private static void BFS(int node){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            sb.append(now+" ");
            for(int i : arr[now]){
                if(!visited[i]){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}