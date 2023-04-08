package silver;
// import java.util.*;
// import java.io.*;

// public class B_1260{
//     static ArrayList<Integer>[] arr;
//     static boolean[] visited;
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         int N = sc.nextInt();
//         int M = sc.nextInt();
//         int start = sc.nextInt();
//         arr = new ArrayList[N+1];
//         for(int i=1;i<=N;i++){
//             arr[i] = new ArrayList<>();
//         }
//         for(int i=0;i<M;i++){
//             int s = sc.nextInt();
//             int e = sc.nextInt();
//             arr[s].add(e);
//             arr[e].add(s);
//         }
//         for(int i=1;i<=N;i++){
//             Collections.sort(arr[i]);
//         }
        
//         visited = new boolean[N+1];
//         DFS(start);
//         System.out.println();
//         visited = new boolean[N+1];
//         BFS(start);
//     }

//     private static void DFS(int start){
//         System.out.print(start+" ");
//         visited[start] = true;
//         for(int i: arr[start]){
//             if(!visited[i]){
//                 DFS(i);
//             }
//         }
//     }
//     private static void BFS(int start){
//         Queue<Integer> qu = new LinkedList<>();
//         qu.add(start);
//         visited[start] = true;

//         while(!qu.isEmpty()){
//             int now_start = qu.poll();
//             System.out.print(now_start+" ");
//             for(int i : arr[now_start]){
//                 if(!visited[i]){
//                     visited[i]=true;
//                     qu.add(i);
//                 }
//             }
//         }
//     }
// }

import java.util.*;

public class B_1260{
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int v = sc.nextInt();
        arr = new ArrayList[N+1];
        for(int i =1;i<=N;i++){
            arr[i] = new ArrayList<>();
        }
        visited = new boolean[N+1];
        for(int i=0;i<M;i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            arr[s].add(e);
            arr[e].add(s);
        }

        for(int i=1;i<=N;i++){
            Collections.sort(arr[i]);
        }

        DFS(v);
        System.out.println();
        visited = new boolean[N+1];
        BFS(v);
    }

    private static void DFS(int s){
        System.out.print(s+" ");
        visited[s] = true;
        for(int i : arr[s]){
            if(!visited[i]){
                visited[i] = true;
                DFS(i);
            }
        }
    }

    private static void BFS(int s){
        Queue<Integer> q = new LinkedList<>();
        System.out.print(s+" ");
        q.add(s);
        visited[s] = true;
        while(!q.isEmpty()){
            int now_node = q.poll();
            for(int i: arr[now_node]){
                if(!visited[i]){
                    System.out.print(i+" ");
                    visited[i]=true;
                    q.add(i);
                }
            }
        }
    }
}