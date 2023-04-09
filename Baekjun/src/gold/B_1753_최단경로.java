package gold;
import java.util.*;
import java.io.*;
public class B_1753_최단경로{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N  = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start=  Integer.parseInt(br.readLine());
        ArrayList<Node1753>[] arr = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            arr[i] = new ArrayList<>();
        }
        for(int i = 0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[s].add(new Node1753(e, v));
        }
        PriorityQueue<Node1753> q = new PriorityQueue<>();
        boolean[] visited = new boolean[N+1];
        q.add(new Node1753(start,0));
        int[] sol = new int[N+1];
        for(int i=1;i<=N;i++){
            sol[i] = Integer.MAX_VALUE;
        }
        sol[start]=0;
        while(!q.isEmpty()){
            Node1753 now = q.poll();
            if(visited[now.tnode]) continue;
            visited[now.tnode] = true;
            for(Node1753 i : arr[now.tnode]){
                int tnode = i.tnode;
                int value = i.value;
                if(sol[tnode] > sol[now.tnode]+value){
                    sol[tnode]=sol[now.tnode]+value;
                    q.add(new Node1753(tnode, sol[tnode]));
                }
            }
        }
        StringBuffer sb  =new StringBuffer();
        for(int i=1;i<=N;i++){
            if(visited[i]) sb.append(sol[i]+"\n");
            else sb.append("INF\n");
        }
        System.out.print(sb.toString());

    }
}

class Node1753 implements Comparable<Node1753>{
    int tnode;
    int value;
    Node1753(int tnode,int value){
        this.tnode = tnode;
        this.value = value;
    }
    public int compareTo(Node1753 n){
        return this.value - n.value;
    }
}