package baekjun.silver;
import java.io.*;
import java.util.*;
public class B_2644_촌수계산 {
    // 양방향 그래프라 visited로 체크하지 않으면 탐색을 무한히 반복하게 됨
    static int a,b;
    static ArrayList<Integer>[] arr;
    static boolean find;
    static int answer;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int node = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(br.readLine());
        arr = new ArrayList[node+1];
        visited = new boolean[node+1];
        for(int i=1;i<=node;i++){
            arr[i] = new ArrayList<>();
        }
        for(int i=1;i<=edge;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
            arr[e].add(s);
        }
        find = false;
        answer = 0;
        BFS(a);
        if(find) System.out.println(answer);
        else System.out.println(-1);
    }
    private static void DFS(int node,int count){
        if(node == b){
            answer = count;
            find = true;
            return;
        }
        visited[node] = true;
        for(int i : arr[node]){
            if(!visited[i]){
                DFS(i,count+1);
            }
        }
    }
    // BFS가 신경쓸게 더 많다.
    private static void BFS(int node){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{node,0});
        visited[node] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[0] == b){
                answer = now[1];
                find = true;
                break;
            }
            for(int i: arr[now[0]]){
                if(!visited[i]){
                    visited[i] = true;
                    q.add(new int[]{i,now[1]+1});
                }
            }
        }
    }
}
