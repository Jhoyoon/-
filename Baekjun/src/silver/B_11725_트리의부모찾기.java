package silver;
import java.util.*;
import java.io.*;


public class B_11725_트리의부모찾기{
    static boolean[] visited;
    static int[] answer;
    static ArrayList<Integer>[] tree;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        answer = new int[N+1];
        tree = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            tree[i] = new ArrayList<>();
        }
        for(int i=1;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            tree[s].add(e);
            tree[e].add(s);
        }
        DFS(1);
        StringBuffer sb = new StringBuffer();
        for(int i=2;i<=N;i++){
            sb.append(answer[i]+"\n");
        }
        System.out.print(sb.toString());

    }
    private static void DFS(int n){
        visited[n] = true;

        for(int i: tree[n]){
            if(!visited[i]){
                visited[i] = true;
                answer[i] = n;
                DFS(i);
            }
        }
    }
}