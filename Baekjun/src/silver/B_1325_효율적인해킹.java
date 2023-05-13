package silver;
import java.io.*;
import java.util.*;
// ** 내 방식대로 푼 코드 **
// public class B_1325_효율적인해킹{
//     static ArrayList<Integer>[] arr;
//     static boolean[] visited;
//     static int[] hack;
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine()," ");
//         int node = Integer.parseInt(st.nextToken());
//         int edge = Integer.parseInt(st.nextToken());
//         arr = new ArrayList[node+1];
//         visited = new boolean[node+1];
//         hack = new int[node+1];
//         for(int i=1;i<=node;i++){
//             arr[i] = new ArrayList<>();
//         }
//         for(int i=0;i<edge;i++){
//             st = new StringTokenizer(br.readLine()," ");
//             int s = Integer.parseInt(st.nextToken());
//             int e = Integer.parseInt(st.nextToken());
//             arr[e].add(s);
//         }
//         for(int i=1;i<=node;i++){
//             BFS(i);
//             visited = new boolean[node+1];
//         }
//         int max = 0;
//         for(int i : hack){
//             if(i > max) max = i;
//         }
//         StringBuffer sb = new StringBuffer();
//         for(int i=1;i<=node;i++){
//             if(hack[i] == max) sb.append(i+" ");
//         }
//         System.out.println(sb.toString());
//     }
//     private static void BFS(int node){
//         Queue<Integer> q = new LinkedList<>();
//         q.add(node);
//         visited[node] = true;
//         int num = 1;
//         while(!q.isEmpty()){
//             int now = q.poll();
//             for(int i : arr[now]){
//                 if(!visited[i]){
//                     q.add(i);
//                     visited[i] = true;
//                     num = num+1;
//                 }
//             }
//         }
//         hack[node] = num;
//     }
// }
// ** 책에 나와있는 코드
public class B_1325_효율적인해킹{
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int[] hack;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        arr = new ArrayList[node+1];
        for(int i=1;i<=node;i++){
            arr[i] = new ArrayList<>();
        }
        visited = new boolean[node+1];
        hack = new int[node+1];
        for(int i=0;i<edge;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
        }
        for(int i=1;i<=node;i++){
            BFS(i);
            visited = new boolean[node+1];
        }
        int max = 0;
        for(int i : hack){
            if(i > max) max = i;
        }
        StringBuffer sb = new StringBuffer();
        for(int i=1;i<=node;i++){
            if(hack[i] == max) sb.append(i+" ");
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
                if(!visited[i]){
                    q.add(i);
                    visited[i] = true;
                    hack[i]++;
                }
            }
        }
    }
}