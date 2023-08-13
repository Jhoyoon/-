package baekjun.silver;
import java.io.*;
import java.util.*;
public class B_5567_결혼식 {
    // depth 구하는 문제는 BFS가 훨씬 코드 짜기가 편하다.
    static ArrayList<Integer>[] arr;
    static int count;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int node = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());
        arr = new ArrayList[node+1];
        for(int i=1;i<=node;i++){
            arr[i] = new ArrayList<>();
        }
        visited = new boolean[node+1];
        count = 0;
        for(int i=1;i<=edge;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
            arr[e].add(s);
        }
        BFS(1);
        System.out.println(count);
    }
    private static void BFS(int node){
      Queue<int[]> q = new LinkedList<>();
      q.add(new int[]{node,0});
      visited[node]= true;
      while(!q.isEmpty()){
        int[] now = q.poll();
        int now_node = now[0];
        int now_depth = now[1];
        for(int i : arr[now_node]){
            if(!visited[i] && now_depth < 2){
                count++;
                visited[i] = true;
                q.add(new int[]{i,now_depth+1});
            }
        }
      }
    }
}
