package gold;
import java.io.*;
import java.util.*;
public class B_1167_트리의지름{
    static ArrayList<Edge>[] arr;
    static boolean[] visited;
    static int[] distance;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new ArrayList[N+1];
        visited = new boolean[N+1];
        distance = new int[N+1];
        for(int i=1;i<=N;i++){
            arr[i] = new ArrayList<>();
        }
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            while(true){
                int node = Integer.parseInt(st.nextToken());
                if(node == -1) break;
                int value = Integer.parseInt(st.nextToken());
                arr[s].add(new Edge(node,value));
            }
        }
        BFS(1);
        int max = 1;
        for(int i=2;i<=N;i++){
            if(distance[i] > distance[max]) max = i;
        }
        visited = new boolean[N+1];
        distance = new int[N+1];
        BFS(max);
        Arrays.sort(distance);
        System.out.println(distance[N]);
    }
    private static void BFS(int node){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;
        while(!q.isEmpty()){
            int now_node = q.poll();
            for(Edge i : arr[now_node]){
                if(!visited[i.node]){
                    visited[i.node] = true;
                    q.add(i.node);
                    distance[i.node] = distance[now_node] + i.value;
                }
            }
        }
    } 
    static class Edge{
        int node;
        int value;
        Edge(int node,int value){
            this.node = node;
            this.value = value;
        }

    }
}

