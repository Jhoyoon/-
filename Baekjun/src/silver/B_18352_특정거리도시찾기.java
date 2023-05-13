package silver;
import java.io.*;
import java.util.*;
public class B_18352_특정거리도시찾기{
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int[] distance;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        arr = new ArrayList[node+1];
        for(int i=1;i<=node;i++){
            arr[i] = new ArrayList<>();
        }
        visited = new boolean[node+1];
        distance = new int[node+1];
        for(int i=0;i<edge;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
        }
        BFS(start);
        ArrayList<Integer> result = new ArrayList<>();
        boolean find = false;
        for(int i=1;i<=node;i++){
            if(distance[i] == k){
                result.add(i);
                find = true;
            } 
        }
        StringBuffer sb = new StringBuffer();
        if(find){
            Collections.sort(result);
            for(int i: result){
                sb.append(i+"\n");
            }
        }else{
            sb.append(-1+"\n");
        }
        System.out.print(sb.toString());
    }
    private static void BFS(int node){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            for(int i : arr[now]){
                if(!visited[i]){
                    visited[i] = true;
                    q.add(i);
                    distance[i] = distance[now]+1;
                }
            }
        }
    }
}