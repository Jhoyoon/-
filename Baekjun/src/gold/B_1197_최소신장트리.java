package gold;
import java.io.*;
import java.util.*;
// public class B_1197_최소신장트리{
//     static int[] parent;
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine()," ");
//         int node = Integer.parseInt(st.nextToken());
//         int edge = Integer.parseInt(st.nextToken());
//         parent = new int[node+1];
//         for(int i=1;i<=node;i++){
//             parent[i] = i;
//         }
//         PriorityQueue<Edge> q=  new PriorityQueue<>((o1,o2)->{
//             return o1.value - o2.value;
//         });
//         for(int i=1;i<=edge;i++){
//             st = new StringTokenizer(br.readLine()," ");
//             int s = Integer.parseInt(st.nextToken());
//             int e = Integer.parseInt(st.nextToken());
//             int value = Integer.parseInt(st.nextToken());
//             q.add(new Edge(s,e,value));
//         }
//         // 최소신장트리 구현
        
//         // 몇개의 엣지를 사용했는지 체크
//         int count = 0;
//         // 현재까지의 모든 가중치 누적치
//         int result = 0;
//         while(count < node-1){
//             Edge now = q.poll();
//             if(find(now.s) != find(now.e)){
//                 union(now.s,now.e);
//                 count++;
//                 result = result + now.value;
//             }
//         }
//         System.out.println(result);
//     }
//     private static void union(int a,int b){
//         a = find(a);
//         b = find(b);
//         if(a!=b){
//             if(a>b){
//                 parent[a] = b;
//             }else{
//                 parent[b] = a;
//             }
//         }
//     }
//     private static int find(int a){
//         if(a == parent[a]) return a;
//         // a의 대표노드를 찾아서
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
public class B_1197_최소신장트리{
    static int[] parent;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        parent = new int[node+1];
        for(int i=1;i<=node;i++){
            parent[i] = i;
        }
        PriorityQueue<Edge> q = new PriorityQueue<>((o1,o2)->{
            return o1.value - o2.value;
        });
        for(int i=1;i<=edge;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            q.add(new Edge(s,e,value));
        }
        int count = 0;
        int result = 0;
        while(count < node-1){
            Edge now = q.poll();
            if(find(now.s) != find(now.e)){
                union(now.s,now.e);
                count++;
                result = result +now.value;
            }
        }
        System.out.println(result);
    }
    private static void union(int a,int b){
        a = find(a);
        b = find(b);
        if(a!=b){
            if(a>b) parent[a] = b;
            else parent[b] = a;
        }
    }
    private static int find(int a){
        if(a == parent[a]) return a;
        else return parent[a]=find(parent[a]);
    }
    static class Edge{
        int s;
        int e;
        int value;
        Edge(int s,int e,int value){
            this.s = s;
            this.e = e;
            this.value = value;
        }
    }
}