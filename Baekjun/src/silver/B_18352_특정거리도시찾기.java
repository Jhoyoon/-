package silver;
import java.io.*;
import java.util.*;
// ** 다익스트라 **
// public class B_18352_특정거리도시찾기{
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine()," ");
//         int node = Integer.parseInt(st.nextToken());
//         int edge = Integer.parseInt(st.nextToken());
//         int K = Integer.parseInt(st.nextToken());
//         int start = Integer.parseInt(st.nextToken());
//         int[] distance=  new int[node+1];
//         Arrays.fill(distance,Integer.MAX_VALUE);
//         distance[start] = 0;
//         ArrayList<Node>[] arr=  new ArrayList[node+1];
//         for(int i=1;i<=node;i++){
//             arr[i] = new ArrayList<>();
//         }
//         for(int i=1;i<=edge;i++){
//             st = new StringTokenizer(br.readLine()," ");
//             int s = Integer.parseInt(st.nextToken());
//             int e = Integer.parseInt(st.nextToken());
//             arr[s].add(new Node(e,1));
//         }
//         Queue<Node> q=  new LinkedList<>();
//         q.add(new Node(start,0));
//         boolean[] visited = new boolean[node+1];
//         while(!q.isEmpty()){
//             Node now = q.poll();
//             if(visited[now.node]) continue;
//             visited[now.node] = true;
//             for(Node i: arr[now.node]){
//                 distance[i.node] = Math.min(distance[i.node],now.value + i.value);
//                 q.add(new Node(i.node,distance[i.node]));
//             }
//         }
//         ArrayList<Integer> result = new ArrayList<>();
//         for(int i=1;i<=node;i++){
//             if(distance[i] == K) result.add(i);
//         }
//         Collections.sort(result);
//         StringBuffer sb = new StringBuffer();
//         if(result.size() == 0) sb.append(-1);
//         else{
//             for(int i: result){
//                 sb.append(i+"\n");
//             }
//         } 
//         System.out.print(sb.toString());
//     }
//     static class Node{
//         int node;
//         int value;
//         Node(int node,int value){
//             this.node = node;
//             this.value = value;
//         }
//     }
// }

// ** BFS **
public class B_18352_특정거리도시찾기{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] arr = new ArrayList[node+1];
        for(int i=1;i<=node;i++){
            arr[i] = new ArrayList<>();
        }
        boolean[] visited = new boolean[node+1];
        int[] depth = new int[node+1];
        for(int i=1;i<=edge;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            for(int i : arr[now]){
                if(visited[i]) continue;
                visited[i] = true;
                q.add(i);
                depth[i] = depth[now]+1;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=1;i<=node;i++){
            if(depth[i] == K) result.add(i);
        }
        Collections.sort(result);
        StringBuffer sb = new StringBuffer();
        if(result.size() == 0) sb.append(-1+"\n");
        else{
            for(int i : result) sb.append(i+"\n");
        }
        System.out.print(sb.toString());
    }
}