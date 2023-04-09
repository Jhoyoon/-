package gold;
import java.io.*;
import java.util.*;
public class B_1916_최소비용구하기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<Node1916>[] arr=  new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            arr[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[s].add(new Node1916(e,v));
        }
        st = new StringTokenizer(br.readLine()," ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int[] sol = new int[N+1];
        for(int i=1;i<=N;i++){
            sol[i] = Integer.MAX_VALUE;
        }
        sol[start] = 0;
        boolean[] visited = new boolean[N+1];
        PriorityQueue<Node1916> q=  new PriorityQueue<>();
        q.add(new Node1916(start, 0));
        while(!q.isEmpty()){
            Node1916 now = q.poll();
            if(visited[now.node]) continue;
            visited[now.node] = true;
            for(Node1916 i : arr[now.node]){
                if(sol[i.node]>sol[now.node]+i.value){
                    sol[i.node] = sol[now.node]+i.value;
                    q.add(new Node1916(i.node, sol[i.node]));
                }
            }
        }
        System.out.print(sol[end]);
    }
}
class Node1916 implements Comparable<Node1916>{
    int node;
    int value;
    Node1916(int node,int value){
        this.node = node;
        this.value = value;
    }
    public int compareTo(Node1916 n){
        return this.value - n.value;
    }
}