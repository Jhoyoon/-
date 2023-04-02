
// import java.util.*;
// import java.io.*;

// public class B_1167{
//     static ArrayList<Node>[] arr;
//     static boolean[] visited;
//     static int[] distance;
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int N = Integer.parseInt(br.readLine());
//         arr = new ArrayList[N+1];
//         for(int i=1;i<=N;i++){
//             arr[i] = new ArrayList<>();
//         }
//         for(int i=0;i<N;i++){
//             StringTokenizer st = new StringTokenizer(br.readLine()," ");
//             int node = Integer.parseInt(st.nextToken());
//             while(true){
//                 int n = Integer.parseInt(st.nextToken());
//                 if(n==-1) break;
//                 int d = Integer.parseInt(st.nextToken());
//                 arr[node].add(new Node(n,d));
//             }
//         }

//         visited = new boolean[N+1];
//         distance = new int[N+1];

//         // BFS에서 거리 배열 업데이트 함
//         BFS(1);
//         int max=1;
//         //가장 거리가 먼 노드 번호를 알아냄
//         for(int i=2;i<=N;i++){
//             if(distance[max]<distance[i]) max = i;
//         }
//         visited = new boolean[N+1];
//         distance = new int[N+1];
//         BFS(max);
//         Arrays.sort(distance);
//         System.out.println(distance[N]);
//     }   

//     private static void BFS(int node){
//        Queue<Integer> q= new LinkedList<>();
//        q.add(node);
//        //방문한거 표시해줌
//        visited[node] = true;
//        while(!q.isEmpty()){
//         int now_node = q.poll();
//         for(Node i : arr[now_node]){
//             if(!visited[i.node]){
//                 visited[i.node]=true;
//                 q.add(i.node);
//                 distance[i.node] = distance[now_node]+i.dis;
//             }
//         }
//        }
//     }
// }

// class Node{
//     int node;
//     int dis;
//     Node(int node,int dis){
//         this.node = node;
//         this.dis = dis;
//     }
// }

import java.util.*;
import java.io.*;

public class B_1167{
    static ArrayList<Node>[] arr;
    static boolean[] visited;
    static int[] distance;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            arr[i] = new ArrayList<>();
        }
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            while(true){
                int node = Integer.parseInt(st.nextToken());
                if(node==-1) break;
                int dis = Integer.parseInt(st.nextToken());
                arr[s].add(new Node(node,dis));
            }
        }
        // 입력완료

        visited = new boolean[N+1];
        distance = new int[N+1];
        BFS(1);
        int max=1;
        for(int i=2;i<=N;i++){
            if(distance[max]<distance[i]){
                max = i;
            }
        }
        visited = new boolean[N+1];
        distance = new int[N+1];
        BFS(max);
        Arrays.sort(distance);
        System.out.println(distance[N]);
    }

    private static void BFS(int node){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;

        while(!q.isEmpty()){
            int now_node = q.poll();
            for(Node i : arr[now_node]){
                if(!visited[i.node]){
                    visited[i.node] = true;
                    //거리 업데이트
                    distance[i.node] = distance[now_node]+i.dis;
                    q.add(i.node);
                }
            }
        }
    }
}

class Node{
    int node;
    int dis;
    Node(int node,int dis){
        this.node = node;
        this.dis = dis;
    }
}