package baekjun.silver;
import java.io.*;
import java.util.*;
public class B_3182_한동이는공부하기싫어 {
    static int[] arr;
    static boolean[] visited;
    static int[] depth;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int node = Integer.parseInt(br.readLine());
        arr = new int[node+1];
        for(int i=1;i<=node;i++){
            int e = Integer.parseInt(br.readLine());
            arr[i] = e;
        }
        depth = new int[node+1];
        for(int i=1;i<=node;i++){
            visited = new boolean[node+1];
            DFS(i,i,0);
        //  BFS(i);
        }
        int max = 0;
        for(int i : depth){
            if(i > max) max = i;
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=1;i<=node;i++){
            if(depth[i] == max) result.add(i);
        }
        Collections.sort(result);
        System.out.println(result.get(0));
    }
    private static void DFS(int node,int find,int count){
        visited[node] = true;
        if(!visited[arr[node]]){
            DFS(arr[node],find,count+1);
        } 
        depth[find] = Math.max(depth[find],count);
    }

    private static void BFS(int node){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            if(!visited[arr[now]]){
                visited[arr[now]] = true;
                q.add(arr[now]);
                depth[node]++;
            }
        }
    }
}
