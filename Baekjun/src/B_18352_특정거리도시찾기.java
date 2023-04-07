// import java.util.*;
// import java.io.*;
// public class B_18352_특정거리도시찾기 {
//     static ArrayList<Integer>[] arr;
//     static boolean[] visited;
//     static int[] distance;
//     static int count;
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine()," ");
//         // 도시의 개수
//         int N = Integer.parseInt(st.nextToken());
//         // 도로의 개수
//         int M = Integer.parseInt(st.nextToken());
//         // 거리 정보
//         int K = Integer.parseInt(st.nextToken());
//         // 출발 도시의 번호
//         int X = Integer.parseInt(st.nextToken());
//         arr = new ArrayList[N+1];
//         distance = new int[N+1];
//         for(int i=1;i<=N;i++){
//             arr[i] = new ArrayList<>();
//         }
//         visited = new boolean[N+1];
//         for(int i=0;i<M;i++){
//             st = new StringTokenizer(br.readLine()," ");
//             int s = Integer.parseInt(st.nextToken());
//             int e=  Integer.parseInt(st.nextToken());
//             arr[s].add(e);
//         }
//         // DFS를 탐색하면서 거리 배열을 업데이트
//         BFS(X);
//         ArrayList<Integer> sol = new ArrayList<>();
//         // 그 중 거리가 k와 일치하는걸 찾고,일치하는 도시의 번호를 배열에 담음
//         for(int i=1;i<=N;i++){
//             if(distance[i]==K) sol.add(i);
//         }
//         if(sol.size()==0){
//             System.out.print(-1);
//         }else{
//             // 오름차순으로 정렬하고
//             Collections.sort(sol);
//             StringBuffer sb  =new StringBuffer();
//             for(int i : sol){
//                 sb.append(i+"\n");
//             }
//             // 출력
//             System.out.println(sb.toString());
//         }
//     }
//     private static void BFS(int X){
//        Queue<Integer> q = new LinkedList<>();
//        q.add(X);
//        visited[X] = true;

//        while(!q.isEmpty()){
//         int now_node = q.poll();
//         for(int i : arr[now_node]){
//             if(!visited[i]){
//                 distance[i] = distance[now_node]+1;
//                 visited[i] = true;
//                 q.add(i);
//             }
//         }
//        }

//     }
// }
import java.io.*;
import java.util.*;

public class B_18352_특정거리도시찾기{
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int[] distance;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N+1];
        visited = new boolean[N+1];
        distance = new int[N+1];
        for(int i=1;i<=N;i++){
            arr[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
        }
        BFS(X);
        List<Integer> sol = new ArrayList<>();
        for(int i=1;i<=N;i++){
            if(distance[i]==K) sol.add(i); 
        }
        StringBuffer sb  = new StringBuffer();
        if(sol.size()==0) System.out.print(-1);
        else if(sol.size()==1) System.out.print(sol.get(0));
        else{
            Collections.sort(sol);
            for(int i : sol){
                sb.append(i+"\n");
            }
        }
        System.out.print(sb.toString());
    }
    private static void BFS(int n){
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = true;
        while(!q.isEmpty()){
            int now_node = q.poll();
            for(int i : arr[now_node]){
                if(!visited[i]){
                    visited[i] = true;
                    q.add(i);
                    distance[i] = distance[now_node]+1;
                }
            }
        }
    }
}