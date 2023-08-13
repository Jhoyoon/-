package baekjun.gold;
import java.io.*;
import java.util.*;
public class B_11437_LCA{
    static ArrayList<Integer>[] tree;
    static int[] depth;
    static int[] parent;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N  = Integer.parseInt(br.readLine());
        tree = new ArrayList[N+1];
        depth  =new int[N+1];
        parent = new int[N+1];
        visited = new boolean[N+1];
        for(int i=1;i<=N;i++){
            tree[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            tree[s].add(e);
            tree[e].add(s);
        }
        BFS(1);
        int M = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int CLA = doCLA(s,e);
            sb.append(CLA+"\n");
        }
        System.out.print(sb.toString());
    }
    private static int doCLA(int s,int e){
        if(depth[s]<depth[e]){
            int tmp = 0;
            tmp = s;
            s = e;
            e = tmp;
        }
        while(depth[s] != depth[e]){
            s = parent[s];
        }
        while(s != e){
            s = parent[s];
            e = parent[e];
        }
        return s;
    }
    private static void BFS(int node){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;
        int level = 1;
        int count = 0;
        int now_size = 1;
        while(!q.isEmpty()){
            int now_node = q.poll();
            for(int i : tree[now_node]){
                if(!visited[i]){
                    visited[i]  =true;
                    q.add(i);
                    depth[i] = level;
                    parent[i] = now_node; 
                }
            }
            count++;
            if(now_size == count){
                count = 0;
                level++;
                now_size  = q.size();
            }
        }
    }
}