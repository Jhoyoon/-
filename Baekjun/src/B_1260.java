import java.util.*;
import java.io.*;

public class B_1260{
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int start = sc.nextInt();
        arr = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            arr[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            arr[s].add(e);
            arr[e].add(s);
        }
        for(int i=1;i<=N;i++){
            Collections.sort(arr[i]);
        }
        
        visited = new boolean[N+1];
        DFS(start);
        System.out.println();
        visited = new boolean[N+1];
        BFS(start);
    }

    private static void DFS(int start){
        System.out.print(start+" ");
        visited[start] = true;
        for(int i: arr[start]){
            if(!visited[i]){
                DFS(i);
            }
        }
    }
    private static void BFS(int start){
        Queue<Integer> qu = new LinkedList<>();
        qu.add(start);
        visited[start] = true;

        while(!qu.isEmpty()){
            int now_start = qu.poll();
            System.out.print(now_start+" ");
            for(int i : arr[now_start]){
                if(!visited[i]){
                    visited[i]=true;
                    qu.add(i);
                }
            }
        }
    }
}