package baekjun.silver;
import java.io.*;
import java.util.*;
public class B_1325_효율적인해킹{
    static boolean[] visited;
    static ArrayList<Integer>[] arr;
    static int[] relief;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        arr = new ArrayList[node+1];
        for(int i=1;i<=node;i++){
            arr[i] = new ArrayList<>();
        }
        relief = new int[node+1];
        for(int i=1;i<=edge;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
        }
        for(int i=1;i<=node;i++){
            visited = new boolean[node+1];
            BFS(i);
        }
        int max = 0;
        for(int i : relief){
            if(i > max) max = i;
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=1;i<=node;i++){
            if(relief[i] == max) result.add(i);
        }
        StringBuffer sb = new StringBuffer();
        for(int i : result){
            sb.append(i+" ");
        }
        System.out.println(sb.toString());
    }

    private static void BFS(int node){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            for(int i : arr[now]){
                if(visited[i]) continue;
                visited[i] = true;
                q.add(i);
                relief[i]++;
            }
        }
    }
}