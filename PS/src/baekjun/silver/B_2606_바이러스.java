package baekjun.silver;
import java.io.*;
import java.util.*;
public class B_2606_바이러스{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int node = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] arr = new ArrayList[node+1];
        for(int i=1;i<=node;i++){
            arr[i] = new ArrayList<>();
        }
        for(int i=1;i<=edge;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
            arr[e].add(s);
        }
        int count = 0;
        boolean[] visited = new boolean[node+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            for(int i : arr[now]){
                if(!visited[i]){
                    visited[i] = true;
                    q.add(i);
                    count++;
                }
            }
        }
        System.out.println(count);
    } 
}