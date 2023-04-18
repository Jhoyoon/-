package platinum;

import java.util.*;
import java.io.*;
public class B_11438_LCA빠른{
    static int[][] parent;
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int kmax;
    static int[] depth;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            tree[i] = new ArrayList<>();
        }
        int tmp = 1;
        kmax = 0;
        while(tmp<=N){
            tmp = tmp*2;
            kmax++;
        }
        parent = new int[kmax+1][N+1];
        depth = new int[N+1];
        visited = new boolean[N+1];
        StringTokenizer st;
        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            tree[s].add(e);
            tree[e].add(s);
        }
        BFS(1);
        for(int k=1;k<=kmax;k++){
            for(int n=1;n<=N;n++){
                parent[k][n] = parent[k-1][parent[k-1][n]];
            }
        }
        int M = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<M;i++){
            st  =new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(getLCA(a,b)+"\n");
        }
        System.out.print(sb.toString());
    }
    private static int getLCA(int a,int b){
        if(depth[a]<depth[b]){
            int tmp = 0;
            tmp = a;
            a=b;
            b=tmp;
        }
        for(int k=kmax;k>=0;k--){
            if(Math.pow(2,k)<=depth[a]-depth[b]){
                a = parent[k][a];
            }
        }
        for(int k=kmax;k>=0;k--){
            if(parent[k][a] != parent[k][b]){
                a=parent[k][a];
                b=parent[k][b];
            }
        }
        int LCA = a;
        if(a != b){
            LCA=parent[0][LCA];
        }
        return LCA;
    }
    private static void BFS(int node){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;
        int level = 1;
        int now_size = 1;
        int count=0;
        while(!q.isEmpty()){
            int now_node = q.poll();
            for(int i : tree[now_node]){
                if(!visited[i]){
                    visited[i] = true;
                    q.add(i);
                    depth[i] = level;
                    parent[0][i] = now_node;
                }
            }
            count++;
            if(count==now_size){
                level++;
                count=0;
                now_size = q.size();
            }
        }
    }
}