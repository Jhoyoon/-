package baekjun.silver;
import java.io.*;
import java.util.*;

// value를 1로 두고 최소신장트리를 구현해 보았다.하지만 이 문제의 경우 엣지의 가중치가 없다.즉,엣지의 개수만 세면 된다는거다.
// 최소신장트리에서 엣지의 개수는 항상 node-1이다.즉,node-1을 그냥 출력하면 되는 문제였다.

// public class B_9372_상근이의여행 {
//     static int[] parent;
//     public static void main(String[] args) throws IOException{
//         // 최소신장트리를 사용해야 하는 문제 같다.
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int T = Integer.parseInt(br.readLine());
//         StringBuffer sb = new StringBuffer();
//         for(int t=0;t<T;t++){
//             StringTokenizer st = new StringTokenizer(br.readLine()," ");
//             int node  =Integer.parseInt(st.nextToken());
//             int edge = Integer.parseInt(st.nextToken());
//             parent = new int[node+1];
//             Queue<Edge> q = new LinkedList<>();
//             for(int i=1;i<=node;i++){
//                 parent[i] = i;
//             }
//             for(int i=1;i<=edge;i++){
//                 st = new StringTokenizer(br.readLine()," ");
//                 int s = Integer.parseInt(st.nextToken());
//                 int e = Integer.parseInt(st.nextToken());
//                 q.add(new Edge(s,e,1));
//             }
//             int count = 0;
//             int result = 0;
//             while(count < node-1){
//                 Edge now = q.poll();
//                 if(find(now.s) != find(now.e)){
//                     union(now.s,now.e);
//                     result = result + now.value;
//                     count++;
//                 }
//             }
//             sb.append(count+"\n");
//         }
//         System.out.print(sb.toString());
//     }    
//     private static void union(int a,int b){
//         a = find(a);
//         b = find(b);
//         if(a!=b){
//             if(a>b) parent[a] = b;
//             else parent[a] = b;
//         }
//     }
//     private static int find(int a){
//         if(a == parent[a]) return a;
//         else return parent[a]=find(parent[a]);
//     }
//     static class Edge{
//         int s;
//         int e;
//         int value;
//         Edge(int s,int e,int value){
//             this.s = s;
//             this.e = e;
//             this.value = value;
//         }
//     }
// }
public class B_9372_상근이의여행{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int t=0;t<T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int node = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());
            for(int i=0;i<edge;i++){
                st = new StringTokenizer(br.readLine()," ");
                st.nextToken();
            }
            sb.append(node-1+"\n");
        }
        System.out.print(sb.toString());
    }
}
