package gold;
import java.io.*;
import java.util.*;
public class B_1916_최소비용구하기{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int node = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());
        ArrayList<Node>[] arr = new ArrayList[node+1];
        int[] distance = new int[node+1];
        for(int i=1;i<=node;i++){
            arr[i] = new ArrayList<>();
        }
        Arrays.fill(distance,Integer.MAX_VALUE);
        StringTokenizer st;
        for(int i=0;i<edge;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            arr[s].add(new Node(e,value));
        }
        st = new StringTokenizer(br.readLine()," ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        distance[start] = 0;
        PriorityQueue<Node> q = new PriorityQueue<>((o1,o2)->{
            return o1.value - o2.value;
        });
        q.add(new Node(start,0));
        boolean[] visited = new boolean[node+1];
        while(!q.isEmpty()){
            Node now = q.poll();
            if(visited[now.node]) continue;
            visited[now.node] = true;
            for(Node i : arr[now.node]){
                distance[i.node] = Math.min(distance[i.node],now.value+i.value);
                q.add(new Node(i.node,distance[i.node]));
            }
        }
        System.out.println(distance[end]);
    }
    static class Node{
        int node;
        int value;
        Node(int node,int value){
            this.node = node;
            this.value = value;
        }
    }
}