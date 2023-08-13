package baekjun.gold;
import java.io.*;
import java.util.*;
// ** DFS로 구현 **
// public class B_1707_이분그래프{
//     static ArrayList<Integer>[] arr;
//     static boolean[] visited;
//     static int[] result;
//     static boolean check;
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int T = Integer.parseInt(br.readLine());
//         for(int t=0;t<T;t++){
//             StringTokenizer st = new StringTokenizer(br.readLine()," ");
//             int node = Integer.parseInt(st.nextToken());
//             int edge = Integer.parseInt(st.nextToken());
//             arr = new ArrayList[node+1];
//             visited = new boolean[node+1];
//             result = new int[node+1];
//             for(int i=1;i<=node;i++){
//                 arr[i] = new ArrayList<>();
//             }
//             for(int i=0;i<edge;i++){
//                 st = new StringTokenizer(br.readLine()," ");
//                 int s = Integer.parseInt(st.nextToken());
//                 int e = Integer.parseInt(st.nextToken());
//                 arr[s].add(e);
//                 arr[e].add(s);
//             }
//             check = true;
//             for(int i=1;i<=node;i++){
//                 if(check) DFS(i);
//                 else break;
//             }
//             if(check)System.out.println("YES");
//             else System.out.println("NO");
//         }
//     }
//     private static void DFS(int node){
//         visited[node] = true;
//         for(int i : arr[node]){
//             if(!visited[i]){
//                 visited[i] = true;
//                 result[i] = (result[node]+1)%2;
//                 DFS(i);
//             }else{
//                 if(result[i] == result[node]){
//                     check = false;
//                     break;
//                 }
//             }
//         }      
//     }
// }

// ** BFS로 구현 **
// public class B_1707_이분그래프{
//     static ArrayList<Integer>[] arr;
//     static boolean[] visited;
//     static int[] result;
//     static boolean check;
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int T = Integer.parseInt(br.readLine());
//         for(int t=0;t<T;t++){
//             StringTokenizer st = new StringTokenizer(br.readLine()," ");
//             int node = Integer.parseInt(st.nextToken());
//             int edge = Integer.parseInt(st.nextToken());
//             arr = new ArrayList[node+1];
//             visited = new boolean[node+1];
//             result = new int[node+1];
//             for(int i=1;i<=node;i++){
//                 arr[i] = new ArrayList<>();
//             }
//             for(int i=0;i<edge;i++){
//                 st = new StringTokenizer(br.readLine()," ");
//                 int s = Integer.parseInt(st.nextToken());
//                 int e = Integer.parseInt(st.nextToken());
//                 arr[s].add(e);
//                 arr[e].add(s);
//             }
//             check = true;
//             for(int i=1;i<=node;i++){
//                 if(check) BFS(i);
//                 else break;
//             }
//             if(check)System.out.println("YES");
//             else System.out.println("NO");
//         }
//     }
//     private static void BFS(int node){
//         Queue<Integer> q = new LinkedList<>();
//         q.add(node);
//         visited[node] = true;
//         while(!q.isEmpty()){
//             int now = q.poll();
//             for(int i : arr[now]){
//                 if(!visited[i]){
//                     visited[i] = true;
//                     q.add(i);
//                     result[i] = (result[now]+1)%2;
//                 }else{
//                     if(result[i] == result[now]){
//                         check = false;
//                         break;
//                     }
//             }
//         }
//     }
// }
// }
public class B_1707_이분그래프{
    static boolean find;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int[] search;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int node = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());
            arr = new ArrayList[node+1];
            for(int i=1;i<=node;i++){
                arr[i] = new ArrayList<>();
            }
            for(int i=1;i<=edge;i++){
                st = new StringTokenizer(br.readLine()," ");
                int s= Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                arr[s].add(e);
                arr[e].add(s);
            }
            visited = new boolean[node+1];
            search = new int[node+1];
            find = true;
            for(int i=1;i<=node;i++){
                if(find) DFS(i);
                else break;
            }
            if(find) System.out.println("YES");
            else System.out.println("NO");
        }
    }
    private static void DFS(int node){
        visited[node] = true;
        for(int i : arr[node]){
            if(visited[i]){
                if(search[node] == search[i]) find = false;
            }else{
                search[i] = (search[node]+1)%2;
                DFS(i);
            }
        }
    }
}